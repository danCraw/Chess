package kurs2.oop.task17.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import kurs2.oop.task17.model.Graph;
import kurs2.oop.task17.model.Node;
import kurs2.oop.task17.model.Unit;
import kurs2.oop.task17.service.GameService;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GsonSerializer {

    public GsonSerializer() {
    }

    public void serialize(GameService game, String fileName) throws IOException {
        Gson gson = initGSon();
        FileWriter fileWriter = new FileWriter(fileName);
        gson.toJson(game, fileWriter);
        fileWriter.close();
    }

    public GameService deserialize(String fileName) throws FileNotFoundException {
        Gson gson = initGSon();
        FileReader fileReader = new FileReader(fileName);
        JsonReader jsonReader = new JsonReader(fileReader);
        return gson.fromJson(jsonReader, GameService.class);
    }

    private Gson initGSon() {
        return new GsonBuilder().setPrettyPrinting()
                .registerTypeAdapter(Node.class, new NodeConverter())
                .registerTypeAdapter(Unit.class, new UnitConverter())
                .registerTypeAdapter(Graph.class, new GraphConverter())
                .enableComplexMapKeySerialization()
                .create();
    }
}

