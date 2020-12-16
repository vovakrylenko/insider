package requests_API;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import java.io.IOException;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class GetRequests {

    String urlInventory = "https://petstore.swagger.io/v2/store/inventory";
    String urlUser = "https://petstore.swagger.io/v2/user/Tommy";
    String urlUserLoginPass = "https://petstore.swagger.io/v2/user/login?username=tommy&password=test";
    String urlUserLogOut = "https://petstore.swagger.io/v2/user/logout";
    String urlOrderID = "https://petstore.swagger.io/v2/store/order/90";


    public static int executeGetRequest(String urlGiven)
            throws IOException{

        HttpUriRequest request = new HttpGet(urlGiven);
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
        return httpResponse.getStatusLine().getStatusCode();

    }


    public void urlsGetResponse()
            throws IOException {

        assertThat(executeGetRequest(urlInventory),equalTo(HttpStatus.SC_OK));
        assertThat(executeGetRequest(urlUser),equalTo(HttpStatus.SC_OK));
        assertThat(executeGetRequest(urlOrderID),equalTo(HttpStatus.SC_NOT_FOUND));
        assertThat(executeGetRequest(urlUserLoginPass),equalTo(HttpStatus.SC_OK));
        assertThat(executeGetRequest(urlUserLogOut),equalTo(HttpStatus.SC_OK));

    }

}