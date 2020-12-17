package kurs2.oop.task17;

import kurs2.oop.task17.json.GsonSerializer;
import kurs2.oop.task17.service.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        GsonSerializer gsonSerializer = new GsonSerializer();
        GameService game = gsonSerializer.deserialize("src/main/java/kurs2/oop/task17/json/chess.json");
        game.start();
    }
}
