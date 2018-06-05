pragma solidity ^0.4.17;
import "./DateTime.sol";
import 'openzeppelin-solidity/contracts/math/SafeMath.sol';

contract InstalmentBuyContract {

    using SafeMath for uint;

    address contract_owner;
    address currentProductOwnerAddr;
    uint8 currentInstalmentNo;
    uint8 totalInstalmentCount;
    uint productPrice;
    string productDesc;
    uint paidMoney;
    uint8 firstPayRate;

    uint createTimeStamp;
    uint lastTimeStamp;
    uint nextTimeStamp;

    uint[] instalmentBills;
    uint[] actualInstalmentBills;

    struct InfoLog{
        address userAddr;
        uint value;
        string action;
        uint timestamp;
    }

    InfoLog[] infoLogs;
    uint totalInfoLogCount;

    uint transferPrice;
    bool isTransfer = false;

    // uint fixedRate = 1000000000000000000;
    uint fixedRate = 1;

    constructor (address contractOwnerAddr,address buyerAddress,uint _productPrice ,string _productDesc, uint8 _firstPayRate,uint8 _totalInstalmentCount) public payable{
        contract_owner = contractOwnerAddr;
        currentProductOwnerAddr = buyerAddress;
        productPrice = _productPrice *fixedRate;
        productDesc = _productDesc;
        firstPayRate = _firstPayRate;
        totalInstalmentCount = _totalInstalmentCount;
        initInstalMentBills(_productPrice,_firstPayRate,_totalInstalmentCount);
    }

    //init
    function initInstalMentBills(uint _productPrice,uint _firstPayRate,uint _totalInstalmentCount) internal {
        uint firstPay = _productPrice.mul(_firstPayRate).div(100);
        uint instalmentPrice = (_productPrice.sub(firstPay)).div(_totalInstalmentCount);
        uint need = instalmentPrice.add(firstPay);
        instalmentBills.push(need);
        for(uint i=1 ; i<_totalInstalmentCount - 1; i++ ) {
            need = need.add(instalmentPrice);
            instalmentBills.push(instalmentPrice);
        }
        instalmentBills.push(_productPrice.sub(need));
    }


    //time method
    function initTimeStamp() internal {
        createTimeStamp = now;
        lastTimeStamp = createTimeStamp;
    }

    function getNextDays(uint _lastTimeStamp) internal pure returns(uint8) {
        uint16 year = DateTime.getYear(_lastTimeStamp);
        uint8 month = DateTime.getMonth(_lastTimeStamp);
        uint8 daysOfMonth = DateTime.getDaysInMonth(month,year);
        return daysOfMonth;
    }

    function updateTimeStamp(bool isFirst) internal {
        if(isFirst) {
            initTimeStamp();
        }else{
            lastTimeStamp = nextTimeStamp;
        }
        uint8 daysOfMonth = getNextDays(lastTimeStamp);
        nextTimeStamp = lastTimeStamp.add( daysOfMonth * 1 days);
    }


    //instalment method
    function payInstalment(address _buyerAddr,uint _value) public payable onlyContractOwner instalmentPayValid payValid{
        uint paid = _value ;
        if(paid != instalmentBills[currentInstalmentNo]) {
            revert();
        }else{
            updateTimeStamp( currentInstalmentNo == 0 );
            currentInstalmentNo +=1;
            paidMoney = paidMoney.add(paid);
            actualInstalmentBills.push(paid);
            saveLogInfo(_buyerAddr,paid,"instalmentPay");
        }
    }

    function getNextInstalmentPayInfo() public view returns(uint,uint,uint) {
        if(currentInstalmentNo == 0) {
            return(instalmentBills[currentInstalmentNo],0,now);
        }else{
            if(now > nextTimeStamp) {
                uint diff = now.sub(nextTimeStamp);
                uint d = diff.div(86400);
                if(diff.sub(d.mul(86400)) > 0) {
                    d = d.add(1);
                }
                //0.005 tax rate
                uint tax = instalmentBills[currentInstalmentNo].div(200).mul(d);

                return(instalmentBills[currentInstalmentNo],tax,now);
            }else{
                return(instalmentBills[currentInstalmentNo],0,nextTimeStamp);
            }

        }
    }

    //transfer ownership method
    function setTransferPrice(uint _transferPrice) public payable onlyBuyer instalmentPayValid payValid returns(bool){
        transferPrice = _transferPrice.mul(fixedRate);
        isTransfer = true;
        saveLogInfo(msg.sender,_transferPrice,"setTransferPrice");
        return true;
    }

    function getTransferPrice() public view returns (uint){
        return transferPrice;
    }

    function buyOwnerShip(address _buyerAddr,uint _value) public payable onlyContractOwner transferable lockState returns (bool){
        uint value = _value;
        if(value < transferPrice) {
            revert();
            return false;
        }else{
            currentProductOwnerAddr = _buyerAddr;
            transferPrice = 0;
            isTransfer = false;
            saveLogInfo(currentProductOwnerAddr,value,"buyOwnerShip");
            return true;
        }
    }


    //utils
    function saveLogInfo(address _addr,uint _value,string _info) internal {
        infoLogs.push(InfoLog(_addr,_value,_info,now));
        totalInfoLogCount = totalInfoLogCount.add(1);
    }


    //getter

    function getNextTimeStamp() public view returns(uint) {
        return nextTimeStamp;
    }

    function getLastTimeStamp() public view returns(uint) {
        return lastTimeStamp;
    }

    function getInstalMentBills() public view returns (uint[]) {
        return instalmentBills;
    }

    function getActualInstalMentBills() public view returns (uint[]) {
        return actualInstalmentBills;
    }

    function getTotalInfoLogsCount() public view returns(uint) {
        return totalInfoLogCount;
    }

    function getInfoLog(uint pos) public constant returns(address addr, uint value,string action, uint time){
        InfoLog storage infoLog = infoLogs[pos];
        return (infoLog.userAddr, infoLog.value, infoLog.action,infoLog.timestamp);
    }

    function getCurrentInstalmentNo() public view returns (uint8) {
        return currentInstalmentNo;
    }

    function getTotalInstalmentCount() public view returns (uint8) {
        return totalInstalmentCount;
    }

    function getProductPrice() public view returns (uint) {
        return productPrice;
    }

    function getProductDesc() public view returns (string) {
        return productDesc;
    }

    function getPaidMoney() public view returns (uint) {
        return paidMoney;
    }


    function getBalance() public view returns (uint) {
        return address(this).balance;
    }

    function getCurrentProductOwnerAddr() public view returns(address) {
        return currentProductOwnerAddr;
    }

    modifier onlyContractOwner {
        require(msg.sender == contract_owner);
        _;
    }

    modifier onlyBuyer {
        require(msg.sender == currentProductOwnerAddr);
        _;
    }

    modifier instalmentPayValid {
        require(currentInstalmentNo < totalInstalmentCount);
        _;
    }

    modifier payValid{
        require(paidMoney < productPrice);
        _;
    }

    modifier transferable {
        require(isTransfer);
        _;
    }

    modifier lockState {
        require(now < nextTimeStamp);
        _;
    }
}

