import api.ContractAPI;
import api.EventTradeToken;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.web3j.tuples.generated.Tuple4;

import java.math.BigInteger;

public class ContractAPITest {
    private static ContractAPI contractAPI;

    @BeforeClass
    public static void init() {
        contractAPI = new ContractAPI();
    }

    @Test
    public void createNewContract() throws Exception {
        EventTradeToken ett = contractAPI.createContract();
        ett.addProduct(BigInteger.ONE, "T-Shirt", BigInteger.TEN, BigInteger.ONE).send();
        Assert.assertEquals(ett.getProductsCount().send(), BigInteger.ONE);
        Tuple4<BigInteger, String, BigInteger, BigInteger> product = ett.getProductByIndex(BigInteger.ONE).send();
        Assert.assertEquals(ett.getProductsCount().send(), BigInteger.ONE);
        ett.newClient("Julia").send();
        Assert.assertEquals(ett.getClientBalance("Julia").send(), BigInteger.valueOf(50l));
        Assert.assertEquals(ett.getClientBalance("NoName").send(), BigInteger.ZERO);
    }

    @Test
    public void loadContract() throws Exception {
        EventTradeToken ett = contractAPI.getContract();

        ett.addProduct(BigInteger.ONE, "T-Shirt", BigInteger.TEN, BigInteger.TEN);
//        ett.newClient("Julia").send();
//        Assert.assertEquals(ett.getClientBalance("Julia").send(), BigInteger.valueOf(50l));
//        Assert.assertEquals(ett.getClientBalance("NoName").send(), BigInteger.ZERO);
//        Tuple3<BigInteger, String, BigInteger> product = ett.getProductByIndex(BigInteger.ZERO).send();
//        Assert.assertEquals(ett.getProductsCount().send(), BigInteger.ONE);
    }
}