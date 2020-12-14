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
//public class Ship extends Unit {
//
////    private String symbol = "S";
//    private String symbol = "\uD83D\uDEA2";
//
//    private final int step = 4;
//    private final int shot = 4;
//    private final ArrayList<GroveType> allowedGrove = Stream.of(GroveType.see, GroveType.river)
//            .collect(Collectors.toCollection(ArrayList::new));
//    private final ArrayList<Direction> allowedDirection = Stream.of(Direction.up, Direction.left, Direction.right, Direction.down,
//            Direction.rightDown, Direction.leftDown, Direction.rightUp, Direction.leftUp)
//            .collect(Collectors.toCollection(ArrayList::new));
//
//    private void initShip() {
//        setAllowedGrove(allowedGrove);
//        setAllowedDirection(allowedDirection);
//        setAttack(shot);
//        setSteps(step);
//        setSymbol(symbol);
//        setUnitType(UnitType.ship);
//    }
//
//    public String getSymbol() {
//        return symbol;
//    }
//
//    public Ship(Node currentNode) {
//        super(currentNode);
//        initShip();
//    }
//}
