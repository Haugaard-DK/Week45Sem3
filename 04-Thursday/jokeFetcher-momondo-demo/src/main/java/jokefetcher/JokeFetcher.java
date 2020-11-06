package jokefetcher;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import utils.HttpUtils;

public class JokeFetcher {

    public static void main(String[] args) throws IOException {

        String chuck = HttpUtils.fetchData("https://api.chucknorris.io/jokes/random");
        String dad = HttpUtils.fetchData("https://icanhazdadjoke.com");

        System.out.println("JSON fetched from chucknorris:");
        System.out.println(chuck);
        System.out.println("JSON fetched from dadjokes:");
        System.out.println(dad);

    }

    public static HashMap<String, String> runSequental() throws IOException {
        String chuck = HttpUtils.fetchData("https://api.chucknorris.io/jokes/random");
        String dad = HttpUtils.fetchData("https://icanhazdadjoke.com");
        String joke1, joke1Reference, joke2, joke2Reference;
        HashMap jokes = new HashMap<String, String>();
        
        Gson gson = new Gson();
        
        joke1 = gson.fromJson(chuck, ChuckDTO.class).getValue();
        joke1Reference = "https://api.chucknorris.io/jokes/random";
        joke2 = gson.fromJson(dad, DadDTO.class).getJoke();
        joke2Reference = "https://icanhazdadjoke.com";
        
        jokes.put("joke1", joke1);
        jokes.put("joke1Reference", joke1Reference);
        jokes.put("joke2", joke2);
        jokes.put("joke2Reference", joke2Reference);
        
        return jokes;
    }
}
