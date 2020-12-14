package kurs2.oop.task17.json;

import com.google.gson.*;
import kurs2.oop.task17.GroveType;
import kurs2.oop.task17.Node;

import java.lang.reflect.Type;

public class NodeConverter  implements JsonDeserializer<Node> {

    @Override
    public Node deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject object = jsonElement.getAsJsonObject();
        int x = jsonDeserializationContext.deserialize(object.get("coordinateX"), Node.class);
        int y = jsonDeserializationContext.deserialize(object.get("coordinateY"), Node.class);
        GroveType groveType = jsonDeserializationContext.deserialize(object.get("groveType"), GroveType.class);
        return new Node(x, y, groveType);
    }

}
