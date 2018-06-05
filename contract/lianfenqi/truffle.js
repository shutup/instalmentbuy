module.exports = {
  // See <http://truffleframework.com/docs/advanced/configuration>
  // to customize your Truffle configuration!
  networks: {
   development: {
   host: "localhost",
   //host: "192.168.4.134",
   //port: 8989,
   port: 9545,
   network_id: "*" // Match any network id
  }
  }
};
