package api;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple3;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import rx.Observable;
import rx.functions.Func1;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.4.0.
 */
public class EventTradeToken extends Contract {
    private static final String BINARY = "6080604052600380546032600755600160a860020a031916331790556001546113889061003990826401000000006114d86100b282021704565b6001553360009081526020819052604090205461006390826401000000006114d86100b282021704565b336000818152602081815260408083209490945583518581529351929391927fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef9281900390910190a3506100c8565b6000828201838110156100c157fe5b9392505050565b6117ae806100d76000396000f3006080604052600436106101265763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166266ac1d811461012b57806305d2035b1461019057806306fdde03146101b9578063095ea7b31461024357806318160ddd1461026757806323b872dd1461028e578063313ce567146102b857806334a17d7a146102e357806340c10f191461033c5780634b1b9e92146103605780635786fd40146103be57806366188463146103d357806370a08231146103f75780637d64bcb41461041857806382e02a071461042d5780638da5cb5b146104d057806395d89b4114610501578063a9059cbb14610516578063d73dd6231461053a578063dd62ed3e1461055e578063ef8b9f0a14610585578063f2fde38b146105de575b600080fd5b34801561013757600080fd5b5060408051602060046024803582810135601f810185900485028601850190965285855261018e95833560ff1695369560449491939091019190819084018382808284375094975050933594506105ff9350505050565b005b34801561019c57600080fd5b506101a5610715565b604080519115158252519081900360200190f35b3480156101c557600080fd5b506101ce610736565b6040805160208082528351818301528351919283929083019185019080838360005b838110156102085781810151838201526020016101f0565b50505050905090810190601f1680156102355780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561024f57600080fd5b506101a5600160a060020a036004351660243561076d565b34801561027357600080fd5b5061027c6107d3565b60408051918252519081900360200190f35b34801561029a57600080fd5b506101a5600160a060020a03600435811690602435166044356107da565b3480156102c457600080fd5b506102cd610951565b6040805160ff9092168252519081900360200190f35b3480156102ef57600080fd5b506040805160206004803580820135601f810184900484028501840190955284845261018e9436949293602493928401919081908401838280828437509497506109569650505050505050565b34801561034857600080fd5b506101a5600160a060020a0360043516602435610ae9565b34801561036c57600080fd5b506040805160206004803580820135601f810184900484028501840190955284845261018e9436949293602493928401919081908401838280828437509497505050923560ff169350610c0492505050565b3480156103ca57600080fd5b5061027c610e2a565b3480156103df57600080fd5b506101a5600160a060020a0360043516602435610e30565b34801561040357600080fd5b5061027c600160a060020a0360043516610f22565b34801561042457600080fd5b506101a5610f41565b34801561043957600080fd5b5061044860ff60043516610fe7565b6040805160ff85168152908101829052606060208083018281528551928401929092528451608084019186019080838360005b8381101561049357818101518382015260200161047b565b50505050905090810190601f1680156104c05780820380516001836020036101000a031916815260200191505b5094505050505060405180910390f35b3480156104dc57600080fd5b506104e56110f5565b60408051600160a060020a039092168252519081900360200190f35b34801561050d57600080fd5b506101ce611104565b34801561052257600080fd5b506101a5600160a060020a036004351660243561113b565b34801561054657600080fd5b506101a5600160a060020a036004351660243561121c565b34801561056a57600080fd5b5061027c600160a060020a03600435811690602435166112b5565b34801561059157600080fd5b506040805160206004803580820135601f810184900484028501840190955284845261027c9436949293602493928401919081908401838280828437509497506112e09650505050505050565b3480156105ea57600080fd5b5061018e600160a060020a0360043516611431565b6005546001600080831115610659575060005b828160ff161015610659576005805460ff831690811061062e57fe5b600091825260209091206003909102015460ff8781169116141561065157600091505b600101610612565b811561070d576040805160608101825260ff88811682526020808301898152938301889052600580546001810180835560009290925284517f036b6384b5eca791c62761152d0c79bb0604c104a5fb6f4eb0703f3154bb3db06003909202918201805460ff1916919095161784559451805191956106fe937f036b6384b5eca791c62761152d0c79bb0604c104a5fb6f4eb0703f3154bb3db1909101929101906116ea565b50604082015181600201555050505b505050505050565b60035474010000000000000000000000000000000000000000900460ff1681565b60408051808201909152600f81527f4576656e745472616465546f6b656e0000000000000000000000000000000000602082015281565b336000818152600260209081526040808320600160a060020a038716808552908352818420869055815186815291519394909390927f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925928290030190a350600192915050565b6001545b90565b6000600160a060020a03831615156107f157600080fd5b600160a060020a03841660009081526020819052604090205482111561081657600080fd5b600160a060020a038416600090815260026020908152604080832033845290915290205482111561084657600080fd5b600160a060020a03841660009081526020819052604090205461086f908363ffffffff6114c616565b600160a060020a0380861660009081526020819052604080822093909355908516815220546108a4908363ffffffff6114d816565b600160a060020a038085166000908152602081815260408083209490945591871681526002825282812033825290915220546108e6908363ffffffff6114c616565b600160a060020a03808616600081815260026020908152604080832033845282529182902094909455805186815290519287169391927fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef929181900390910190a35060019392505050565b600281565b610a306004805480602002602001604051908101604052809291908181526020016000905b82821015610a265760008481526020908190208301805460408051601f6002600019610100600187161502019094169390930492830185900485028101850190915281815292830182828015610a125780601f106109e757610100808354040283529160200191610a12565b820191906000526020600020905b8154815290600101906020018083116109f557829003601f168201915b50505050508152602001906001019061097b565b50505050826114ee565b15610a3a57600080fd5b60048054600181018083556000929092528251610a7e917f8a35acfbc15ff81a39ae7d344fd709f28e8600b4aa8c65c6b64bfe7fe36bd19b019060208501906116ea565b50506007546006826040518082805190602001908083835b60208310610ab55780518252601f199092019160209182019101610a96565b51815160209384036101000a6000190180199092169116179052920194855250604051938490030190922092909255505050565b600354600090600160a060020a03163314610b0357600080fd5b60035474010000000000000000000000000000000000000000900460ff1615610b2b57600080fd5b600154610b3e908363ffffffff6114d816565b600155600160a060020a038316600090815260208190526040902054610b6a908363ffffffff6114d816565b600160a060020a03841660008181526020818152604091829020939093558051858152905191927f0f6798a560793a54c3bcfe86a93cde1e73087d944c0ea20544137d412139688592918290030190a2604080518381529051600160a060020a038516916000917fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef9181900360200190a350600192915050565b6000610ce06004805480602002602001604051908101604052809291908181526020016000905b82821015610cd65760008481526020908190208301805460408051601f6002600019610100600187161502019094169390930492830185900485028101850190915281815292830182828015610cc25780601f10610c9757610100808354040283529160200191610cc2565b820191906000526020600020905b815481529060010190602001808311610ca557829003601f168201915b505050505081526020019060010190610c2b565b50505050846114ee565b1515610ceb57600080fd5b610cf482611605565b9050600060ff82161015610d0757600080fd5b6005805460ff8316908110610d1857fe5b9060005260206000209060030201600201546006846040518082805190602001908083835b60208310610d5c5780518252601f199092019160209182019101610d3d565b51815160209384036101000a600019018019909216911617905292019485525060405193849003019092205492909210159150610d9a905057600080fd5b6005805460ff8316908110610dab57fe5b9060005260206000209060030201600201546006846040518082805190602001908083835b60208310610def5780518252601f199092019160209182019101610dd0565b51815160209384036101000a600019018019909216911617905292019485525060405193849003019092208054939093039092555050505050565b60055490565b336000908152600260209081526040808320600160a060020a038616845290915281205480831115610e8557336000908152600260209081526040808320600160a060020a0388168452909152812055610eba565b610e95818463ffffffff6114c616565b336000908152600260209081526040808320600160a060020a03891684529091529020555b336000818152600260209081526040808320600160a060020a0389168085529083529281902054815190815290519293927f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925929181900390910190a3600191505b5092915050565b600160a060020a0381166000908152602081905260409020545b919050565b600354600090600160a060020a03163314610f5b57600080fd5b60035474010000000000000000000000000000000000000000900460ff1615610f8357600080fd5b6003805474ff00000000000000000000000000000000000000001916740100000000000000000000000000000000000000001790556040517fae5184fba832cb2b1f702aca6117b8d265eaf03ad33eb133f19dde0f5920fa0890600090a150600190565b60006060600060058460ff16815481101515610fff57fe5b60009182526020909120600390910201546005805460ff92831692871690811061102557fe5b906000526020600020906003020160010160058660ff1681548110151561104857fe5b60009182526020918290206002600390920201810154835460408051601f6000196101006001861615020190931694909404918201859004850284018501905280835290928491908301828280156110e15780601f106110b6576101008083540402835291602001916110e1565b820191906000526020600020905b8154815290600101906020018083116110c457829003601f168201915b505050505091509250925092509193909250565b600354600160a060020a031681565b60408051808201909152600381527f4554540000000000000000000000000000000000000000000000000000000000602082015281565b6000600160a060020a038316151561115257600080fd5b3360009081526020819052604090205482111561116e57600080fd5b3360009081526020819052604090205461118e908363ffffffff6114c616565b3360009081526020819052604080822092909255600160a060020a038516815220546111c0908363ffffffff6114d816565b600160a060020a038416600081815260208181526040918290209390935580518581529051919233927fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef9281900390910190a350600192915050565b336000908152600260209081526040808320600160a060020a0386168452909152812054611250908363ffffffff6114d816565b336000818152600260209081526040808320600160a060020a0389168085529083529281902085905580519485525191937f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925929081900390910190a350600192915050565b600160a060020a03918216600090815260026020908152604080832093909416825291909152205490565b60006113bc6004805480602002602001604051908101604052809291908181526020016000905b828210156113b25760008481526020908190208301805460408051601f600260001961010060018716150201909416939093049283018590048502810185019091528181529283018282801561139e5780601f106113735761010080835404028352916020019161139e565b820191906000526020600020905b81548152906001019060200180831161138157829003601f168201915b505050505081526020019060010190611307565b50505050836114ee565b15611429576006826040518082805190602001908083835b602083106113f35780518252601f1990920191602091820191016113d4565b51815160209384036101000a60001901801990921691161790529201948552506040519384900301909220549250610f3c915050565b506000610f3c565b600354600160a060020a0316331461144857600080fd5b600160a060020a038116151561145d57600080fd5b600354604051600160a060020a038084169216907f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e090600090a36003805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0392909216919091179055565b6000828211156114d257fe5b50900390565b6000828201838110156114e757fe5b9392505050565b6000806000845111156115fb575060005b83518160ff1610156115fb57826040518082805190602001908083835b6020831061153b5780518252601f19909201916020918201910161151c565b5181516020939093036101000a60001901801990911692169190911790526040519201829003909120875190935087925060ff85169150811061157a57fe5b906020019060200201516040518082805190602001908083835b602083106115b35780518252601f199092019160209182019101611594565b6001836020036101000a03801982511681845116808217855250505050505090500191505060405180910390206000191614156115f35760019150610f1b565b6001016114ff565b5060009392505050565b6000806116118361167e565b151561161c57600080fd5b60055460001015611678575060005b60055460ff82161015611678578260ff1660058260ff1681548110151561164e57fe5b600091825260209091206003909102015460ff16141561167057809150611678565b60010161162b565b50919050565b600080600060058054905011156116e1575060005b60055460ff821610156116e1578260ff1660058260ff168154811015156116b657fe5b600091825260209091206003909102015460ff1614156116d95760019150611678565b600101611693565b50600092915050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061172b57805160ff1916838001178555611758565b82800160010185558215611758579182015b8281111561175857825182559160200191906001019061173d565b50611764929150611768565b5090565b6107d791905b80821115611764576000815560010161176e5600a165627a7a723058201715805246d9a42580754826c9d2a00ff1ca05073112bd223c7498da3401961f0029";

    public static final String FUNC_ADDPRODUCT = "addProduct";

    public static final String FUNC_MINTINGFINISHED = "mintingFinished";

    public static final String FUNC_NAME = "name";

    public static final String FUNC_APPROVE = "approve";

    public static final String FUNC_TOTALSUPPLY = "totalSupply";

    public static final String FUNC_TRANSFERFROM = "transferFrom";

    public static final String FUNC_DECIMALS = "decimals";

    public static final String FUNC_NEWCLIENT = "newClient";

    public static final String FUNC_MINT = "mint";

    public static final String FUNC_BUYPRODUCT = "buyProduct";

    public static final String FUNC_GETPRODUCTSCOUNT = "getProductsCount";

    public static final String FUNC_DECREASEAPPROVAL = "decreaseApproval";

    public static final String FUNC_BALANCEOF = "balanceOf";

    public static final String FUNC_FINISHMINTING = "finishMinting";

    public static final String FUNC_GETPRODUCTBYINDEX = "getProductByIndex";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_SYMBOL = "symbol";

    public static final String FUNC_TRANSFER = "transfer";

    public static final String FUNC_INCREASEAPPROVAL = "increaseApproval";

    public static final String FUNC_ALLOWANCE = "allowance";

    public static final String FUNC_GETCLIENTBALANCE = "getClientBalance";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final Event MINT_EVENT = new Event("Mint", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
    ;

    public static final Event MINTFINISHED_EVENT = new Event("MintFinished", 
            Arrays.<TypeReference<?>>asList(),
            Arrays.<TypeReference<?>>asList());
    ;

    public static final Event OWNERSHIPTRANSFERRED_EVENT = new Event("OwnershipTransferred", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
            Arrays.<TypeReference<?>>asList());
    ;

    public static final Event APPROVAL_EVENT = new Event("Approval", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
    ;

    public static final Event TRANSFER_EVENT = new Event("Transfer", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
    ;

    protected EventTradeToken(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected EventTradeToken(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<TransactionReceipt> addProduct(BigInteger _code, String _name, BigInteger _price) {
        final Function function = new Function(
                FUNC_ADDPRODUCT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint8(_code), 
                new org.web3j.abi.datatypes.Utf8String(_name), 
                new org.web3j.abi.datatypes.generated.Uint256(_price)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Boolean> mintingFinished() {
        final Function function = new Function(FUNC_MINTINGFINISHED, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<String> name() {
        final Function function = new Function(FUNC_NAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> approve(String _spender, BigInteger _value) {
        final Function function = new Function(
                FUNC_APPROVE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_spender), 
                new org.web3j.abi.datatypes.generated.Uint256(_value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> totalSupply() {
        final Function function = new Function(FUNC_TOTALSUPPLY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> transferFrom(String _from, String _to, BigInteger _value) {
        final Function function = new Function(
                FUNC_TRANSFERFROM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_from), 
                new org.web3j.abi.datatypes.Address(_to), 
                new org.web3j.abi.datatypes.generated.Uint256(_value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> decimals() {
        final Function function = new Function(FUNC_DECIMALS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> newClient(String _client) {
        final Function function = new Function(
                FUNC_NEWCLIENT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_client)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> mint(String _to, BigInteger _amount) {
        final Function function = new Function(
                FUNC_MINT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_to), 
                new org.web3j.abi.datatypes.generated.Uint256(_amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> buyProduct(String _client, BigInteger _code) {
        final Function function = new Function(
                FUNC_BUYPRODUCT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_client), 
                new org.web3j.abi.datatypes.generated.Uint8(_code)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> getProductsCount() {
        final Function function = new Function(FUNC_GETPRODUCTSCOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> decreaseApproval(String _spender, BigInteger _subtractedValue) {
        final Function function = new Function(
                FUNC_DECREASEAPPROVAL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_spender), 
                new org.web3j.abi.datatypes.generated.Uint256(_subtractedValue)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> balanceOf(String _owner) {
        final Function function = new Function(FUNC_BALANCEOF, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_owner)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> finishMinting() {
        final Function function = new Function(
                FUNC_FINISHMINTING, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Tuple3<BigInteger, String, BigInteger>> getProductByIndex(BigInteger num) {
        final Function function = new Function(FUNC_GETPRODUCTBYINDEX, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint8(num)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple3<BigInteger, String, BigInteger>>(
                new Callable<Tuple3<BigInteger, String, BigInteger>>() {
                    @Override
                    public Tuple3<BigInteger, String, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<BigInteger, String, BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue());
                    }
                });
    }

    public RemoteCall<String> owner() {
        final Function function = new Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> symbol() {
        final Function function = new Function(FUNC_SYMBOL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> transfer(String _to, BigInteger _value) {
        final Function function = new Function(
                FUNC_TRANSFER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_to), 
                new org.web3j.abi.datatypes.generated.Uint256(_value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> increaseApproval(String _spender, BigInteger _addedValue) {
        final Function function = new Function(
                FUNC_INCREASEAPPROVAL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_spender), 
                new org.web3j.abi.datatypes.generated.Uint256(_addedValue)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> allowance(String _owner, String _spender) {
        final Function function = new Function(FUNC_ALLOWANCE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_owner), 
                new org.web3j.abi.datatypes.Address(_spender)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> getClientBalance(String _client) {
        final Function function = new Function(FUNC_GETCLIENTBALANCE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_client)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> transferOwnership(String newOwner) {
        final Function function = new Function(
                FUNC_TRANSFEROWNERSHIP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<EventTradeToken> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployRemoteCall(EventTradeToken.class, web3j, credentials, gasPrice, gasLimit, BINARY, "", initialWeiValue);
    }

    public static RemoteCall<EventTradeToken> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployRemoteCall(EventTradeToken.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "", initialWeiValue);
    }

    public List<MintEventResponse> getMintEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(MINT_EVENT, transactionReceipt);
        ArrayList<MintEventResponse> responses = new ArrayList<MintEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            MintEventResponse typedResponse = new MintEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.to = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<MintEventResponse> mintEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, MintEventResponse>() {
            @Override
            public MintEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(MINT_EVENT, log);
                MintEventResponse typedResponse = new MintEventResponse();
                typedResponse.log = log;
                typedResponse.to = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<MintEventResponse> mintEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(MINT_EVENT));
        return mintEventObservable(filter);
    }

    public List<MintFinishedEventResponse> getMintFinishedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(MINTFINISHED_EVENT, transactionReceipt);
        ArrayList<MintFinishedEventResponse> responses = new ArrayList<MintFinishedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            MintFinishedEventResponse typedResponse = new MintFinishedEventResponse();
            typedResponse.log = eventValues.getLog();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<MintFinishedEventResponse> mintFinishedEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, MintFinishedEventResponse>() {
            @Override
            public MintFinishedEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(MINTFINISHED_EVENT, log);
                MintFinishedEventResponse typedResponse = new MintFinishedEventResponse();
                typedResponse.log = log;
                return typedResponse;
            }
        });
    }

    public Observable<MintFinishedEventResponse> mintFinishedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(MINTFINISHED_EVENT));
        return mintFinishedEventObservable(filter);
    }

    public List<OwnershipTransferredEventResponse> getOwnershipTransferredEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT, transactionReceipt);
        ArrayList<OwnershipTransferredEventResponse> responses = new ArrayList<OwnershipTransferredEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<OwnershipTransferredEventResponse> ownershipTransferredEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, OwnershipTransferredEventResponse>() {
            @Override
            public OwnershipTransferredEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT, log);
                OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
                typedResponse.log = log;
                typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<OwnershipTransferredEventResponse> ownershipTransferredEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(OWNERSHIPTRANSFERRED_EVENT));
        return ownershipTransferredEventObservable(filter);
    }

    public List<ApprovalEventResponse> getApprovalEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(APPROVAL_EVENT, transactionReceipt);
        ArrayList<ApprovalEventResponse> responses = new ArrayList<ApprovalEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ApprovalEventResponse typedResponse = new ApprovalEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.spender = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<ApprovalEventResponse> approvalEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, ApprovalEventResponse>() {
            @Override
            public ApprovalEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(APPROVAL_EVENT, log);
                ApprovalEventResponse typedResponse = new ApprovalEventResponse();
                typedResponse.log = log;
                typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.spender = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<ApprovalEventResponse> approvalEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(APPROVAL_EVENT));
        return approvalEventObservable(filter);
    }

    public List<TransferEventResponse> getTransferEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(TRANSFER_EVENT, transactionReceipt);
        ArrayList<TransferEventResponse> responses = new ArrayList<TransferEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            TransferEventResponse typedResponse = new TransferEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<TransferEventResponse> transferEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, TransferEventResponse>() {
            @Override
            public TransferEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(TRANSFER_EVENT, log);
                TransferEventResponse typedResponse = new TransferEventResponse();
                typedResponse.log = log;
                typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<TransferEventResponse> transferEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(TRANSFER_EVENT));
        return transferEventObservable(filter);
    }

    public static EventTradeToken load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new EventTradeToken(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static EventTradeToken load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new EventTradeToken(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static class MintEventResponse {
        public Log log;

        public String to;

        public BigInteger amount;
    }

    public static class MintFinishedEventResponse {
        public Log log;
    }

    public static class OwnershipTransferredEventResponse {
        public Log log;

        public String previousOwner;

        public String newOwner;
    }

    public static class ApprovalEventResponse {
        public Log log;

        public String owner;

        public String spender;

        public BigInteger value;
    }

    public static class TransferEventResponse {
        public Log log;

        public String from;

        public String to;

        public BigInteger value;
    }
}
