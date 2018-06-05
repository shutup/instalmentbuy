pragma solidity ^0.4.17;

import "./StringExtend.sol";
import "./InstalmentBuyContract.sol";

contract ContractHouse{
    using StringExtend for string;
    address owner;
    mapping(string => address) contracts;
    mapping(address =>uint[]) userTimestamps;

    constructor(address _contract_owner) public {
        owner = _contract_owner;
    }

    function createContract(address _buyerAddress,uint _productPrice ,string _productDesc, uint8 _firstPayRate,uint8 _totalInstalmentCount) public onlyOwner payable returns(address) {
        address addr = new InstalmentBuyContract(owner,_buyerAddress,_productPrice,_productDesc,_firstPayRate,_totalInstalmentCount);
        string memory addrStr = addressToAsciiString(_buyerAddress);
        uint timestamp = now;
        string memory timestampStr = uint2str(timestamp);
        string memory result = addrStr.concat(":");
        result = result.concat(timestampStr);
        contracts[result] = addr;
        userTimestamps[_buyerAddress].push(timestamp);
        return addr;
    }

    function getContractTimestamps(address _addr) public view returns (uint[]) {
        return userTimestamps[_addr];
    }

    function getUserContracts(string _key) public view returns(address) {
        return contracts[_key];
    }

    modifier onlyOwner {
        require(msg.sender == owner);
        _;
    }

    //utils
    function addressToAsciiString(address x)internal pure returns (string) {
        bytes memory s = new bytes(40);
        for (uint i = 0; i < 20; i++) {
            byte b = byte(uint8(uint(x) / (2**(8*(19 - i)))));
            byte hi = byte(uint8(b) / 16);
            byte lo = byte(uint8(b) - 16 * uint8(hi));
            s[2*i] = char(hi);
            s[2*i+1] = char(lo);
        }
        return string(s);
    }

    function char(byte b)internal pure returns (byte c) {
        if (b < 10) return byte(uint8(b) + 0x30);
        else return byte(uint8(b) + 0x57);
    }

    function uint2str(uint i) internal pure returns (string){
        if (i == 0) return "0";
        uint j = i;
        uint length;
        while (j != 0){
            length++;
            j /= 10;
        }
        bytes memory bstr = new bytes(length);
        uint k = length - 1;
        while (i != 0){
            bstr[k--] = byte(48 + i % 10);
            i /= 10;
        }
        return string(bstr);
    }
}
