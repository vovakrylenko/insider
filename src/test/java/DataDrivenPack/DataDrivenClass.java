package DataDrivenPack;

import org.testng.annotations.DataProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class DataDrivenClass {

    @DataProvider(name = "C01", parallel = false)
    public static Iterator<Object[]> C01() {
        List<Object[]> data = new ArrayList<Object[]>();
        data.add(new Object[]{"https://useinsider.com/"});
        return data.iterator();
    }

    @DataProvider(name = "C02", parallel = false)
    public static Iterator<Object[]> C02() {
        List<Object[]> data = new ArrayList<Object[]>();
        data.add(new Object[]{});
        return data.iterator();
    }

}


