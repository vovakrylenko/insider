package requests_API;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.HttpClientBuilder;
import java.io.IOException;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class DeleteRequests {

    String urlDeleteUser = "https://petstore.swagger.io/v2/user/Tommy";
    String urlDeleteOrderID = "https://petstore.swagger.io/v2/store/order/4";

    public static int executeDeleteRequest(String urlGiven)
            throws IOException{

        HttpDelete request = new HttpDelete(urlGiven);
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
        return httpResponse.getStatusLine().getStatusCode();

    }

    public void urlsDeleteResponse()
            throws IOException {

        assertThat(executeDeleteRequest(urlDeleteUser),equalTo(HttpStatus.SC_OK));
        assertThat(executeDeleteRequest(urlDeleteOrderID),equalTo(HttpStatus.SC_OK));
    }

}