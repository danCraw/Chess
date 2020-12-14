//package kurs2.oop.task17.json;
//
//import com.google.gson.*;
//import com.google.gson.JsonDeserializer;
//import kurs2.oop.task17.Graph;
//import kurs2.oop.task17.Node;
//import kurs2.oop.task17.service.GraphService;
//
//import java.lang.reflect.Type;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.Set;
//
//public class GraphConverter implements JsonDeserializer<Graph> {
//    private NodeConverter nodeConverter = new NodeConverter();
//    private UnitConverter vertexConverter = new UnitConverter();
//    private GraphService graphService = new GraphService();
//
//    @Override
//    public Graph deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
//        JsonObject object = jsonElement.getAsJsonObject();
//        Graph graph = new Graph();
//        ArrayList<ArrayList<Node>> nodes = new ArrayList<>();
//
//        JsonArray nodesArray = object.get("nodes").getAsJsonArray();
//        for (int i = 0; i < nodesArray.size(); i++) {
//            for (int j = 0; j < nodesArray.size(); j++) {
//                nodes.add(new ArrayList<>(i, j))a
//            }
//        }
//        graph.setNodes(nodes);
//
//        return graph;
//    }
//}
