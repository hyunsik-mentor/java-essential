package http_server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Executors;

public class MyHttpServer {
    static class EchoHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange httpExchange) throws IOException {
            byte [] readBytes = httpExchange.getRequestBody().readAllBytes();
            String read = new String(readBytes,  StandardCharsets.UTF_8.name());
            System.out.println("Request Method: " + httpExchange.getRequestMethod());
            System.out.println("Request Body: " + read);
            httpExchange.sendResponseHeaders(200, readBytes.length);
            OutputStream os = httpExchange.getResponseBody();
            os.write(readBytes);
            os.flush();
        }
    }

    public static void main(String [] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 8080), 0);
        server.createContext("/echo", new EchoHandler());
        server.setExecutor(Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()));
        server.start();
    }
}
