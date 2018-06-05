var DateTime = artifacts.require("./DateTime.sol");
var StringExtend = artifacts.require("./StringExtend.sol");
var ContractHouse= artifacts.require("./ContractHouse.sol");
var InstalmentBuyContract= artifacts.require("./InstalmentBuyContract.sol");

module.exports = function(deployer) {
  deployer.deploy(DateTime);
  deployer.deploy(StringExtend);
  deployer.link(DateTime,ContractHouse);
  deployer.link(StringExtend,ContractHouse);

  deployer.deploy(ContractHouse,"0x627306090abab3a6e1400e9345bc60c78a8bef57");
};
