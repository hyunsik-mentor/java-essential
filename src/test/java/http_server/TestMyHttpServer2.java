package http_server;

import com.google.api.client.http.*;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.http.json.JsonHttpContent;
import com.google.api.client.testing.http.MockHttpTransport;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

import static org.junit.jupiter.api.Assertions.*;

class TestMyHttpServer2 {
    @Test
    void test() throws IOException {
        HttpTransport transport = new NetHttpTransport();
        GenericUrl url = new GenericUrl("http://localhost:8080/xxx");
        HttpContent content = new ByteArrayContent("plain/text", "test message".getBytes());
        HttpRequest request = transport.createRequestFactory().buildPostRequest(url, content);
        HttpResponse response = request.execute();
        assertEquals(response.getStatusCode(), 200);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        response.download(os);
        assertEquals("test message", os.toString());
    }
}