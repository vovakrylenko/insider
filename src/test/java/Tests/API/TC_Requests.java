package Tests.API;

import DataDrivenPack.DataDrivenClass;
import org.testng.annotations.Test;
import requests_API.DeleteRequests;
import requests_API.GetRequests;
import requests_API.PostRequests;
import java.io.IOException;

public class TC_Requests extends PostRequests {

    PostRequests postRequests;
    GetRequests getRequests;
    DeleteRequests deleteRequests;

    @Test(dataProvider = "requests", priority = 1, dataProviderClass = DataDrivenClass.class)

    public void executePostRequests()
            throws IOException {

        postRequests = new PostRequests();
        postRequests.urlsPostResponse();

    }

    @Test(dataProvider = "requests", priority = 2, dataProviderClass = DataDrivenClass.class)

    public void executeGetRequests()
            throws IOException {

        getRequests = new GetRequests();
        getRequests.urlsGetResponse();

    }

    @Test(dataProvider = "requests", priority = 3, dataProviderClass = DataDrivenClass.class)

    public void executeDeleteRequests()
            throws IOException {

        deleteRequests = new DeleteRequests();
        deleteRequests.urlsDeleteResponse();

    }

}