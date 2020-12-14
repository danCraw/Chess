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
//public class Engineer extends Unit {
//
////    private String symbol = "E️";
//    private String symbol = "\uD83D\uDD28";
//
//    private final int step = 2;
//    private final int shot = 0;
//    private final ArrayList<GroveType> allowedGrove = Stream.of(GroveType.riverCross, GroveType.earth, GroveType.river)
//            .collect(Collectors.toCollection(ArrayList::new));
//    private final ArrayList<Direction> allowedDirection = Stream.of(Direction.up, Direction.left, Direction.right, Direction.down)
//            .collect(Collectors.toCollection(ArrayList::new));
//
//    private void initEngineer() {
//        setAllowedGrove(allowedGrove);
//        setAllowedDirection(allowedDirection);
//        setAttack(shot);
//        setSteps(step);
//        setSymbol(symbol);
//        setUnitType(UnitType.engineer);
//    }
//
//    public String getSymbol() {
//        return symbol;
//    }
//
//    public Engineer(Node currentNode) {
//        super(currentNode);
//        initEngineer();
//    }
//}
