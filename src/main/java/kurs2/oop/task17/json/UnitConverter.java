//package kurs2.oop.task17.json;
//
//import com.google.gson.*;
//import kurs2.oop.task17.*;
//
//import java.lang.reflect.Type;
//
//public class UnitConverter implements JsonDeserializer<Unit> {
////    "unitType": "Tank",
////            "steps": 2,
////            "shot": 2,
////            "allowedGrove": "riverCross, earth, river",
////            "allowedDirection": "up, left, right, down"
//    @Override
//    public Unit deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
//        JsonObject object = jsonElement.getAsJsonObject();
//        UnitType unitType = jsonDeserializationContext.deserialize(object.get("unitType"), UnitType.class);
//        return new Unit();
//    }
//}
