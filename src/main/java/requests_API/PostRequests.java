package requests_API;

import com.google.gson.Gson;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.json.simple.JSONObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class PostRequests {

    String urlForOrder = "https://petstore.swagger.io/v2/store/order";
    String urlForUser = "https://petstore.swagger.io/v2/user/createWithArray";
    String urlForUserList = "https://petstore.swagger.io/v2/user/createWithList";
    String urlForCreatingUser = "https://petstore.swagger.io/v2/user";

    public static String bodyForOrder(){
        JSONObject json = new JSONObject();
        json.put("id", "4");
        json.put("petId", "4");
        json.put("quantity", "4");
        json.put("shipDate", "2020-12-15T14:16:40.385Z");
        json.put("status", "placed");
        json.put("complete", "true");
        return json.toString();
    }

    public static String creatingUser () {
        JSONObject json = new JSONObject();
        json.put("firstName", "Tom");
        json.put("lastName", "Sawyer");
        json.put("password", "Mark");
        json.put("userStatus", "0");
        json.put("phone", "555-55-55");
        json.put("id", "0");
        json.put("email", "testmail@mail.com");
        json.put("username", "Tommy");

        return json.toString();

    }

    public static String bodyForUserList () {

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("firstName", "string"));
        params.add(new BasicNameValuePair("lastName", "string"));
        params.add(new BasicNameValuePair("password", "string"));
        params.add(new BasicNameValuePair("userStatus", "0"));
        params.add(new BasicNameValuePair("phone", "string"));
        params.add(new BasicNameValuePair("email", "string"));
        params.add(new BasicNameValuePair("username", "string"));

        return new Gson().toJson(params);

    }

    public static int executePostRequest(String urlGiven, String json)
            throws IOException {

        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(urlGiven);

        StringEntity entity = new StringEntity(json);
        httpPost.setEntity(entity);
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");

        CloseableHttpResponse response = client.execute(httpPost);
        client.close();

        return response.getStatusLine().getStatusCode();

    }

    public void urlsPostResponse()
            throws IOException {

        assertThat(executePostRequest(urlForOrder, bodyForOrder()), equalTo(200));
        assertThat(executePostRequest(urlForUser, bodyForUserList()), equalTo(200));
        assertThat(executePostRequest(urlForUserList, bodyForUserList()), equalTo(200));
        assertThat(executePostRequest(urlForCreatingUser, creatingUser()), equalTo(200));

    }

}