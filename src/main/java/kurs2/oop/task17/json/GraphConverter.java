package kurs2.oop.task17.json;

import com.google.gson.*;
import com.google.gson.JsonDeserializer;
import kurs2.oop.task17.model.Graph;
import kurs2.oop.task17.model.Node;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class GraphConverter implements JsonDeserializer<Graph> {
    private NodeConverter nodeConverter = new NodeConverter();

    @Override
    public Graph deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject object = jsonElement.getAsJsonObject();
        Graph graph = new Graph();
        ArrayList<ArrayList<Node>> nodes = new ArrayList<>();

        JsonArray nodesArray = object.get("nodes").getAsJsonArray();
        for (int y = 0; y < nodesArray.size() + 1; y++) {
            ArrayList<Node> tmp = new ArrayList<>();
            for (int x = 0; x < nodesArray.size() + 2; x++) {
                tmp.add(nodeConverter.deserialize(nodesArray.get(y), Node.class, jsonDeserializationContext));
            }
            nodes.add(tmp);
        }
        graph.setNodes(nodes);

        return graph;
    }
}
