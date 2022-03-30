package za.co.wethinkcode;

import net.lemnik.eodsql.QueryTool;
import io.javalin.http.Context;
import io.javalin.http.HttpCode;
import org.json.simple.JSONObject;
import za.co.wethinkcode.Data.BlinderDAI;
import za.co.wethinkcode.Data.DBConnect;

import java.sql.Connection;
import java.util.List;

public class BlinderAPI {

    public static void signUp(Context context) {
        boolean output = true;

        JSONObject body = context.bodyAsClass(JSONObject.class);

        DBConnect db = new DBConnect("profiles");
        Connection profileConn = db.getConnection();

        BlinderDAI dai = QueryTool.getQuery(profileConn, BlinderDAI.class);

        // add profile to db
        dai.addProfile(
                (body.get("name").toString()),
                (body.get("surname").toString()),
                (body.get("email").toString()),
                Integer.parseInt(body.get("age").toString()),
                (body.get("gender").toString()),
                (body.get("hash").toString()));

        context.header("Location", "/profile/CREATED");

        if (output) {
            context.status(HttpCode.CREATED);
        } else {
            context.status(HttpCode.INTERNAL_SERVER_ERROR);
        }
    }


}