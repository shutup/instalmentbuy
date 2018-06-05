package com.shutup.instalmentbuy.service;

import com.shutup.instalmentbuy.contract_wrapper.ContractHouse;
import org.springframework.stereotype.Service;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.ipc.UnixIpcService;
import org.web3j.tx.Contract;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;

@Service
public class Web3jService {
//    String IPCUrl = "/Users/shutup/Desktop/privateChain/data1/geth.ipc";
    //    String TestNetUrl = "https://kovan.infura.io/vknyxyJN14EVybheGKVV";
    String TestNetUrl = "https://kovan.infura.io/vknyxyJN14EVybheGKVV";
    String contractAddr = "0x8c860524282d220396f345725e3fe07391c95473";
    static Web3j web3j;

    public void createInstalmentBuyContract() {
        Credentials credentials = null;
        try {
            credentials = WalletUtils.loadCredentials("ww1234",new File("/Users/shutup/Desktop/keystore/UTC--2018-06-04T14-18-25.322417283Z--426af9045c7b6970fb08e760ec0dabca74cd418c"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CipherException e) {
            e.printStackTrace();
        }
        ContractHouse contractHouse = ContractHouse.load(contractAddr,getWeb3j(),credentials, Contract.GAS_PRICE,Contract.GAS_LIMIT);
        try {
            TransactionReceipt receipt = contractHouse.createContract("0x426af9045c7b6970fb08e760ec0dabca74cd418c", BigInteger.valueOf(600),"wkc",BigInteger.valueOf(50),BigInteger.valueOf(10),BigInteger.valueOf(3000000)).send();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public Web3j getWeb3j() {
        if (web3j== null) {
//            web3j = Web3j.build(new UnixIpcService(IPCUrl));
            web3j = Web3j.build(new HttpService(TestNetUrl));
        }else {
            return web3j;
        }
        return web3j;
    }

}
