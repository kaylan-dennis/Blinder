package za.co.wethinkcode;

import io.javalin.Javalin;
import java.net.*;

import static io.javalin.apibuilder.ApiBuilder.*;

public class BlinderServer {
    private final Javalin server;

    public BlinderServer() {
        server = Javalin.create(config -> {
            config.defaultContentType = "application/json";
            config.enableCorsForOrigin("*");
        });
        this.server.post("/login", context -> BlinderAPI.signUp(context));
    }

    public static void main(String[] args) throws UnknownHostException {
        BlinderServer server = new BlinderServer();
        server.start(5000);

        System.out.println(InetAddress.getLocalHost());
    }

    public void start(int port) {
        this.server.start(port);
    }

    public void stop() {
        this.server.stop();
    }
}