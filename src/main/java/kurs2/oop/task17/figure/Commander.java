//package kurs2.oop.task17.figure;
//
//import kurs2.oop.task17.Unit;
//import kurs2.oop.task17.Direction;
//import kurs2.oop.task17.GroveType;
//import kurs2.oop.task17.Node;
//import kurs2.oop.task17.UnitType;
//
//import java.util.ArrayList;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//public class Commander extends Unit {
//
//    private final String symbol = "\uD83C\uDF1F";
////    private String symbol = "C";
//
//    private final int step = 100;
//    private final int shot = 1;
//    private final ArrayList<GroveType> allowedGroveС =  Stream.of(GroveType.riverCross, GroveType.earth, GroveType.river)
//            .collect(Collectors.toCollection(ArrayList::new));
//    private final ArrayList<Direction> allowedDirectionС = Stream.of(Direction.up, Direction.left, Direction.right, Direction.down)
//            .collect(Collectors.toCollection(ArrayList::new));
//
//    private void initCommander() {
//        setAllowedGrove(allowedGroveС);
//        setAllowedDirection(allowedDirectionС);
//        setAttack(shot);
//        setSteps(step);
//        setSymbol(symbol);
//        setUnitType(UnitType.commander);
//    }
//
//    public String getSymbol() {
//        return symbol;
//    }
//
//    public Commander(Node currentNode) {
//        super(currentNode);
//        initCommander();
//    }
//
//}
