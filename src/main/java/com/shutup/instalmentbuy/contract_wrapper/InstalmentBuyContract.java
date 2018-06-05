package com.shutup.instalmentbuy.contract_wrapper;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple3;
import org.web3j.tuples.generated.Tuple4;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.3.1.
 */
public class InstalmentBuyContract extends Contract {
    private static final String BINARY = "0x60806040526000600e60006101000a81548160ff0219169083151502179055506001600f556040516200189538038062001895833981018060405281019080805190602001909291908051906020019092919080519060200190929190805182019291906020018051906020019092919080519060200190929190505050856000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555084600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550600f548402600281905550826003908051906020019062000121929190620003bd565b5081600560006101000a81548160ff021916908360ff16021790555080600160156101000a81548160ff021916908360ff1602179055506200017a848360ff168360ff1662000186640100000000026401000000009004565b5050505050506200046c565b600080600080620001d26064620001b5888a620003336401000000000262000f6a179091906401000000009004565b6200036f6401000000000262000f54179091906401000000009004565b93506200021985620001fc868a620003866401000000000262000f3b179091906401000000009004565b6200036f6401000000000262000f54179091906401000000009004565b92506200023e8484620003a06401000000000262000fa2179091906401000000009004565b91506009829080600181540180825580915050906001820390600052602060002001600090919290919091505550600190505b60018503811015620002dc57620002a08383620003a06401000000000262000fa2179091906401000000009004565b91506009839080600181540180825580915050906001820390600052602060002001600090919290919091505550808060010191505062000271565b6009620003018389620003866401000000000262000f3b179091906401000000009004565b908060018154018082558091505090600182039060005260206000200160009091929091909150555050505050505050565b60008083141562000348576000905062000369565b81830290508183828115156200035a57fe5b041415156200036557fe5b8090505b92915050565b600081838115156200037d57fe5b04905092915050565b60008282111515156200039557fe5b818303905092915050565b60008183019050828110151515620003b457fe5b80905092915050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106200040057805160ff191683800117855562000431565b8280016001018555821562000431579182015b828111156200043057825182559160200191906001019062000413565b5b50905062000440919062000444565b5090565b6200046991905b80821115620004655760008160009055506001016200044b565b5090565b90565b611419806200047c6000396000f3006080604052600436106100fc576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680630c4b12de146101015780630eeaea281461012c578063103888091461016557806312065fe01461019d578063542540ce146101c85780637558bd2f146101f357806388303e971461025f5780638cfc15701461028a578063982002da146102bb578063ad0d6d13146102e6578063ba71f1cb14610317578063c072d6b5146103fe578063c1c244e814610429578063cac7da6614610454578063cebd4b36146104c0578063d148892914610518578063d169656f14610558578063e01e6701146105af575b600080fd5b34801561010d57600080fd5b5061011661063f565b6040518082815260200191505060405180910390f35b34801561013857600080fd5b50610141610649565b60405180848152602001838152602001828152602001935050505060405180910390f35b610183600480360381019080803590602001909291905050506107f9565b604051808215151515815260200191505060405180910390f35b3480156101a957600080fd5b506101b261091a565b6040518082815260200191505060405180910390f35b3480156101d457600080fd5b506101dd610939565b6040518082815260200191505060405180910390f35b3480156101ff57600080fd5b50610208610943565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b8381101561024b578082015181840152602081019050610230565b505050509050019250505060405180910390f35b34801561026b57600080fd5b5061027461099b565b6040518082815260200191505060405180910390f35b34801561029657600080fd5b5061029f6109a5565b604051808260ff1660ff16815260200191505060405180910390f35b3480156102c757600080fd5b506102d06109bc565b6040518082815260200191505060405180910390f35b3480156102f257600080fd5b506102fb6109c6565b604051808260ff1660ff16815260200191505060405180910390f35b34801561032357600080fd5b50610342600480360381019080803590602001909291905050506109dd565b604051808573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200184815260200180602001838152602001828103825284818151815260200191508051906020019080838360005b838110156103c05780820151818401526020810190506103a5565b50505050905090810190601f1680156103ed5780820380516001836020036101000a031916815260200191505b509550505050505060405180910390f35b34801561040a57600080fd5b50610413610ae3565b6040518082815260200191505060405180910390f35b34801561043557600080fd5b5061043e610aed565b6040518082815260200191505060405180910390f35b34801561046057600080fd5b50610469610af7565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b838110156104ac578082015181840152602081019050610491565b505050509050019250505060405180910390f35b6104fe600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190505050610b4f565b604051808215151515815260200191505060405180910390f35b610556600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190505050610cbb565b005b34801561056457600080fd5b5061056d610e6f565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b3480156105bb57600080fd5b506105c4610e99565b6040518080602001828103825283818151815260200191508051906020019080838360005b838110156106045780820151818401526020810190506105e9565b50505050905090810190601f1680156106315780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b6000600854905090565b6000806000806000806000600160149054906101000a900460ff1660ff1614156106aa576009600160149054906101000a900460ff1660ff1681548110151561068e57fe5b90600052602060002001546000428191509550955095506107f1565b6008544211156107b6576106c960085442610f3b90919063ffffffff16565b92506106e16201518084610f5490919063ffffffff16565b9150600061070d6106fe6201518085610f6a90919063ffffffff16565b85610f3b90919063ffffffff16565b111561072a57610727600183610fa290919063ffffffff16565b91505b61077b8261076d60c86009600160149054906101000a900460ff1660ff1681548110151561075457fe5b9060005260206000200154610f5490919063ffffffff16565b610f6a90919063ffffffff16565b90506009600160149054906101000a900460ff1660ff1681548110151561079e57fe5b906000526020600020015481429550955095506107f1565b6009600160149054906101000a900460ff1660ff168154811015156107d757fe5b906000526020600020015460006008548191509550955095505b505050909192565b6000600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151561085757600080fd5b600160159054906101000a900460ff1660ff16600160149054906101000a900460ff1660ff1610151561088957600080fd5b60025460045410151561089b57600080fd5b6108b0600f5483610f6a90919063ffffffff16565b600d819055506001600e60006101000a81548160ff02191690831515021790555061091133836040805190810160405280601081526020017f7365745472616e73666572507269636500000000000000000000000000000000815250610fbe565b60019050919050565b60003073ffffffffffffffffffffffffffffffffffffffff1631905090565b6000600254905090565b6060600a80548060200260200160405190810160405280929190818152602001828054801561099157602002820191906000526020600020905b81548152602001906001019080831161097d575b5050505050905090565b6000600d54905090565b6000600160149054906101000a900460ff16905090565b6000600c54905090565b6000600160159054906101000a900460ff16905090565b6000806060600080600b868154811015156109f457fe5b906000526020600020906004020190508060000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff168160010154826002018360030154818054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610acc5780601f10610aa157610100808354040283529160200191610acc565b820191906000526020600020905b815481529060010190602001808311610aaf57829003601f168201915b505050505091509450945094509450509193509193565b6000600454905090565b6000600754905090565b60606009805480602002602001604051908101604052809291908181526020018280548015610b4557602002820191906000526020600020905b815481526020019060010190808311610b31575b5050505050905090565b6000806000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610bad57600080fd5b600e60009054906101000a900460ff161515610bc857600080fd5b60085442101515610bd857600080fd5b829050600d54811015610bea57600080fd5b83600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506000600d819055506000600e60006101000a81548160ff021916908315150217905550610cb0600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16826040805190810160405280600c81526020017f6275794f776e6572536869700000000000000000000000000000000000000000815250610fbe565b600191505092915050565b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610d1857600080fd5b600160159054906101000a900460ff1660ff16600160149054906101000a900460ff1660ff16101515610d4a57600080fd5b600254600454101515610d5c57600080fd5b8190506009600160149054906101000a900460ff1660ff16815481101515610d8057fe5b906000526020600020015481141515610d9857600080fd5b610db66000600160149054906101000a900460ff1660ff16146110bf565b60018060148282829054906101000a900460ff160192506101000a81548160ff021916908360ff160217905550610df881600454610fa290919063ffffffff16565b600481905550600a819080600181540180825580915050906001820390600052602060002001600090919290919091505550610e6a83826040805190810160405280600d81526020017f696e7374616c6d656e7450617900000000000000000000000000000000000000815250610fbe565b505050565b6000600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16905090565b606060038054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610f315780601f10610f0657610100808354040283529160200191610f31565b820191906000526020600020905b815481529060010190602001808311610f1457829003601f168201915b5050505050905090565b6000828211151515610f4957fe5b818303905092915050565b60008183811515610f6157fe5b04905092915050565b600080831415610f7d5760009050610f9c565b8183029050818382811515610f8e57fe5b04141515610f9857fe5b8090505b92915050565b60008183019050828110151515610fb557fe5b80905092915050565b600b6080604051908101604052808573ffffffffffffffffffffffffffffffffffffffff168152602001848152602001838152602001428152509080600181540180825580915050906001820390600052602060002090600402016000909192909190915060008201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550602082015181600101556040820151816002019080519060200190611090929190611348565b50606082015181600301555050506110b46001600c54610fa290919063ffffffff16565b600c81905550505050565b600081156110d4576110cf611117565b6110de565b6008546007819055505b6110e9600754611129565b905061110d620151808260ff160262ffffff16600754610fa290919063ffffffff16565b6008819055505050565b42600681905550600654600781905550565b60008060008073__DateTime______________________________6392d66313866040518263ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004018082815260200191505060206040518083038186803b15801561119a57600080fd5b505af41580156111ae573d6000803e3d6000fd5b505050506040513d60208110156111c457600080fd5b8101908080519060200190929190505050925073__DateTime______________________________63a324ad24866040518263ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004018082815260200191505060206040518083038186803b15801561124257600080fd5b505af4158015611256573d6000803e3d6000fd5b505050506040513d602081101561126c57600080fd5b8101908080519060200190929190505050915073__DateTime______________________________63b238ad0e83856040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808360ff1660ff1681526020018261ffff1661ffff1681526020019250505060206040518083038186803b15801561130057600080fd5b505af4158015611314573d6000803e3d6000fd5b505050506040513d602081101561132a57600080fd5b81019080805190602001909291905050509050809350505050919050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061138957805160ff19168380011785556113b7565b828001600101855582156113b7579182015b828111156113b657825182559160200191906001019061139b565b5b5090506113c491906113c8565b5090565b6113ea91905b808211156113e65760008160009055506001016113ce565b5090565b905600a165627a7a72305820b043724c42e5c1c43d07947e96013bb8cbd6324b8a91a2df275200ddceb4671a0029";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<>();
        _addresses.put("4447", "0xfb88de099e13c3ed21f80a7a1e49f8caecf10df6");
    }

    protected InstalmentBuyContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected InstalmentBuyContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static RemoteCall<InstalmentBuyContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue, String contractOwnerAddr, String buyerAddress, BigInteger _productPrice, String _productDesc, BigInteger _firstPayRate, BigInteger _totalInstalmentCount) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(contractOwnerAddr), 
                new org.web3j.abi.datatypes.Address(buyerAddress), 
                new org.web3j.abi.datatypes.generated.Uint256(_productPrice), 
                new org.web3j.abi.datatypes.Utf8String(_productDesc), 
                new org.web3j.abi.datatypes.generated.Uint8(_firstPayRate), 
                new org.web3j.abi.datatypes.generated.Uint8(_totalInstalmentCount)));
        return deployRemoteCall(InstalmentBuyContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor, initialWeiValue);
    }

    public static RemoteCall<InstalmentBuyContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue, String contractOwnerAddr, String buyerAddress, BigInteger _productPrice, String _productDesc, BigInteger _firstPayRate, BigInteger _totalInstalmentCount) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(contractOwnerAddr), 
                new org.web3j.abi.datatypes.Address(buyerAddress), 
                new org.web3j.abi.datatypes.generated.Uint256(_productPrice), 
                new org.web3j.abi.datatypes.Utf8String(_productDesc), 
                new org.web3j.abi.datatypes.generated.Uint8(_firstPayRate), 
                new org.web3j.abi.datatypes.generated.Uint8(_totalInstalmentCount)));
        return deployRemoteCall(InstalmentBuyContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor, initialWeiValue);
    }

    public RemoteCall<TransactionReceipt> payInstalment(String _buyerAddr, BigInteger _value, BigInteger weiValue) {
        final Function function = new Function(
                "payInstalment", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_buyerAddr), 
                new org.web3j.abi.datatypes.generated.Uint256(_value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<Tuple3<BigInteger, BigInteger, BigInteger>> getNextInstalmentPayInfo() {
        final Function function = new Function("getNextInstalmentPayInfo", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple3<BigInteger, BigInteger, BigInteger>>(
                new Callable<Tuple3<BigInteger, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple3<BigInteger, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<BigInteger, BigInteger, BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue());
                    }
                });
    }

    public RemoteCall<TransactionReceipt> setTransferPrice(BigInteger _transferPrice, BigInteger weiValue) {
        final Function function = new Function(
                "setTransferPrice", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_transferPrice)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<BigInteger> getTransferPrice() {
        final Function function = new Function("getTransferPrice", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> buyOwnerShip(String _buyerAddr, BigInteger _value, BigInteger weiValue) {
        final Function function = new Function(
                "buyOwnerShip", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_buyerAddr), 
                new org.web3j.abi.datatypes.generated.Uint256(_value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<BigInteger> getNextTimeStamp() {
        final Function function = new Function("getNextTimeStamp", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> getLastTimeStamp() {
        final Function function = new Function("getLastTimeStamp", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<List> getInstalMentBills() {
        final Function function = new Function("getInstalMentBills", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Uint256>>() {}));
        return new RemoteCall<List>(
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteCall<List> getActualInstalMentBills() {
        final Function function = new Function("getActualInstalMentBills", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Uint256>>() {}));
        return new RemoteCall<List>(
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteCall<BigInteger> getTotalInfoLogsCount() {
        final Function function = new Function("getTotalInfoLogsCount", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<Tuple4<String, BigInteger, String, BigInteger>> getInfoLog(BigInteger pos) {
        final Function function = new Function("getInfoLog", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(pos)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple4<String, BigInteger, String, BigInteger>>(
                new Callable<Tuple4<String, BigInteger, String, BigInteger>>() {
                    @Override
                    public Tuple4<String, BigInteger, String, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple4<String, BigInteger, String, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue());
                    }
                });
    }

    public RemoteCall<BigInteger> getCurrentInstalmentNo() {
        final Function function = new Function("getCurrentInstalmentNo", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> getTotalInstalmentCount() {
        final Function function = new Function("getTotalInstalmentCount", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> getProductPrice() {
        final Function function = new Function("getProductPrice", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> getProductDesc() {
        final Function function = new Function("getProductDesc", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> getPaidMoney() {
        final Function function = new Function("getPaidMoney", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> getBalance() {
        final Function function = new Function("getBalance", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> getCurrentProductOwnerAddr() {
        final Function function = new Function("getCurrentProductOwnerAddr", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public static InstalmentBuyContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new InstalmentBuyContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static InstalmentBuyContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new InstalmentBuyContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }
}
