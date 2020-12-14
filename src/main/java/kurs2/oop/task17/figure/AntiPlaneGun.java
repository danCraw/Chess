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
//public class AntiPlaneGun extends Unit {
//
////    private String symbol = "G";
//    private String symbol = "\uD83D\uDCA3";
//
//    private final int step = 2;
//    private final int shot = 1;
//    private  final ArrayList<GroveType> allowedGrove = Stream.of(GroveType.riverCross, GroveType.earth, GroveType.river)
//            .collect(Collectors.toCollection(ArrayList::new));
//    private final ArrayList<Direction> allowedDirection = Stream.of(Direction.up, Direction.left, Direction.right, Direction.down)
//            .collect(Collectors.toCollection(ArrayList::new));
//
//    private void initAntiAircraftGun() {
//        setAllowedGrove(allowedGrove);
//        setAllowedDirection(allowedDirection);
//        setAttack(shot);
//        setSteps(step);
//        setSymbol(symbol);
//        setUnitType(UnitType.antiPlaneGun);
//    }
//
//    public String getSymbol() {
//        return symbol;
//    }
//
//    public AntiPlaneGun(Node currentNode) {
//        super(currentNode);
//        initAntiAircraftGun();
//    }
//}
