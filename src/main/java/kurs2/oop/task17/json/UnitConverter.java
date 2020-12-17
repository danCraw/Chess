package kurs2.oop.task17.json;

import com.google.gson.*;
import kurs2.oop.task17.model.Node;
import kurs2.oop.task17.model.Unit;
import kurs2.oop.task17.model.UnitType;

import java.lang.reflect.Type;

public class UnitConverter implements JsonDeserializer<Unit> {

    @Override
    public Unit deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject object = jsonElement.getAsJsonObject();
        Node currentNode = jsonDeserializationContext.deserialize(object.get("currentNode"), Node.class);
        UnitType unitType = jsonDeserializationContext.deserialize(object.get("unitType"), UnitType.class);
        return new Unit(currentNode, unitType);
    }
}
