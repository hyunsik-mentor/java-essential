package http_server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

interface MyHandle extends HttpHandler {
    boolean match(URI uri);

    void handle(HttpExchange httpExchange) throws IOException;
}

public class MyHttpServer2 {

    static class AuthorHandle implements HttpHandler {
        @Override
        public void handle(HttpExchange httpExchange) throws IOException {
            System.out.println("Request URL: " + httpExchange.getRequestURI());

            String path = httpExchange.getRequestURI().getPath();

            if (path.endsWith("/authors")) {
                httpExchange.sendResponseHeaders(404, 2);
                OutputStream os = httpExchange.getResponseBody();
                os.write("xx".getBytes());
                os.flush();
            } else {
                byte[] readBytes = httpExchange.getRequestBody().readAllBytes();
                String read = new String(readBytes, StandardCharsets.UTF_8.name());
                System.out.println("Request Method: " + httpExchange.getRequestMethod());
                System.out.println("Request Body: " + read);
                httpExchange.sendResponseHeaders(200, readBytes.length);
                OutputStream os = httpExchange.getResponseBody();
                os.write(readBytes);
                os.flush();
            }
        }
    }


    static class AggregatedHandler implements HttpHandler {
        List<MyHandle> handlers;

        AggregatedHandler(List<MyHandle> handlers) {
            this.handlers = handlers;
        }

        @Override
        public void handle(HttpExchange httpExchange) throws IOException {
            for (MyHandle handle : this.handlers) {
                if (handle.match(httpExchange.getRequestURI())) {
                    handle.handle(httpExchange);
                    break;
                }
            }
        }
    }

    static class ActualHandle implements MyHandle {

        @Override
        public boolean match(URI uri) {
            return uri.getPath().endsWith("/abc");
        }

        @Override
        public void handle(HttpExchange httpExchange) throws IOException {
            System.out.println(">>>>>> ActualHandle is called");
            byte[] readBytes = httpExchange.getRequestBody().readAllBytes();
            String read = new String(readBytes, StandardCharsets.UTF_8.name());
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

        List<MyHandle> handlers = List.of(new ActualHandle());
        server.createContext("/books/authors", new AggregatedHandler(handlers));

        server.setExecutor(Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()));
        System.out.println("Server starts on localhost:8080");
        server.start();
    }
}
