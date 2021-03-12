package main;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;



public class Lambda implements RequestHandler<Object, String> {
    private final Logger logger;

    public Lambda(){
        logger = new Logger();
    }

    public String getGreetings() {
        return "Hello, world!";
    }

    public String getJson() {
        String json = "{\"message\": \"" + getGreetings() + "\"}";
        logger.log(json);
        return json;
    }

    @Override
    public String handleRequest(Object event, Context context) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        logger.log(String.valueOf(event));
        Message m = gson.fromJson(getJson(), Message.class);
        return gson.toJson(m);
    }
}


class Message {
    private final String message;

    public Message(String m){
        message = m;
    }

    public String getMessage(){
        return message;
    }
}
