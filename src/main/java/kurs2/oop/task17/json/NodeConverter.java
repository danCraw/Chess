package kurs2.oop.task17.json;

import com.google.gson.*;
import kurs2.oop.task17.model.GroveType;
import kurs2.oop.task17.model.Node;

import java.lang.reflect.Type;

public class NodeConverter implements JsonDeserializer<Node>, JsonSerializer<Node> {

    @Override
    public Node deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject object = jsonElement.getAsJsonObject();
        int x = jsonDeserializationContext.deserialize(object.get("coordinateX"), Node.class);
        int y = jsonDeserializationContext.deserialize(object.get("coordinateY"), Node.class);
        GroveType groveType = jsonDeserializationContext.deserialize(object.get("groveType"), GroveType.class);
        return new Node(x, y, groveType);
    }

    @Override
    public JsonElement serialize(Node node, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject object = new JsonObject();
        object.addProperty("groveType", node.getGroveType().toString());
        object.addProperty("coordinateX", String.valueOf(node.getNodeX()));
        object.addProperty("coordinateY", String.valueOf(node.getNodeY()));
        return null;
    }
}
