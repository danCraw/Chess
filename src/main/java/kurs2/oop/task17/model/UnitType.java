package kurs2.oop.task17.model;

import kurs2.oop.task17.model.Direction;
import kurs2.oop.task17.model.GroveType;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum UnitType {
    tank("\uD83D\uDE92", 2, 2,
            Stream.of(GroveType.RIVER_CROSS, GroveType.EARTH, GroveType.RIVER)
                    .collect(Collectors.toCollection(ArrayList::new)),
            Stream.of(Direction.up, Direction.left, Direction.right, Direction.down)
                    .collect(Collectors.toCollection(ArrayList::new))),
    ship("\uD83D\uDEA2", 4, 4, Stream.of(GroveType.SEE, GroveType.RIVER)
            .collect(Collectors.toCollection(ArrayList::new)),
            Stream.of(Direction.up, Direction.left, Direction.right, Direction.down,
            Direction.rightDown, Direction.leftDown, Direction.rightUp, Direction.leftUp)
            .collect(Collectors.toCollection(ArrayList::new))),
    plane("\uD83D\uDE81", 4, 4,
            Stream.of(GroveType.RIVER_CROSS, GroveType.EARTH, GroveType.RIVER, GroveType.SEE)
            .collect(Collectors.toCollection(ArrayList::new)),
            Stream.of(Direction.up, Direction.left, Direction.right, Direction.down,
            Direction.rightDown, Direction.leftDown, Direction.rightUp, Direction.leftUp)
            .collect(Collectors.toCollection(ArrayList::new))),
    militia("\uD83C\uDF33", 2, 2,
            Stream.of(GroveType.RIVER_CROSS, GroveType.EARTH, GroveType.RIVER)
            .collect(Collectors.toCollection(ArrayList::new)),
            Stream.of(Direction.up, Direction.left, Direction.right, Direction.down,
            Direction.rightDown, Direction.leftDown, Direction.rightUp, Direction.leftUp)
            .collect(Collectors.toCollection(ArrayList::new))),
    infantry("\uD83D\uDD2B", 2, 2,
            Stream.of(GroveType.RIVER_CROSS, GroveType.EARTH)
            .collect(Collectors.toCollection(ArrayList::new)),
            Stream.of(Direction.up, Direction.left, Direction.right, Direction.down)
            .collect(Collectors.toCollection(ArrayList::new))),
    headquarter("\uD83C\uDFE0", 0, 0, null, null),
    engineer("\uD83D\uDD28", 2, 0,
            Stream.of(GroveType.RIVER_CROSS, GroveType.EARTH, GroveType.RIVER)
            .collect(Collectors.toCollection(ArrayList::new)),
            Stream.of(Direction.up, Direction.left, Direction.right, Direction.down)
            .collect(Collectors.toCollection(ArrayList::new))),
    commander("\uD83C\uDF1F", 100, 1,
            Stream.of(GroveType.RIVER_CROSS, GroveType.EARTH, GroveType.RIVER)
            .collect(Collectors.toCollection(ArrayList::new)),
            Stream.of(Direction.up, Direction.left, Direction.right, Direction.down)
            .collect(Collectors.toCollection(ArrayList::new))),
    artillery("\uD83D\uDD2D", 3,3,
            Stream.of(GroveType.RIVER_CROSS, GroveType.EARTH, GroveType.RIVER)
            .collect(Collectors.toCollection(ArrayList::new)),
            Stream.of(Direction.up, Direction.left, Direction.right, Direction.down,
            Direction.rightDown, Direction.leftDown, Direction.rightUp, Direction.leftUp)
            .collect(Collectors.toCollection(ArrayList::new))),
    antiPlaneGun("\uD83D\uDCA3", 2, 1,
            Stream.of(GroveType.RIVER_CROSS, GroveType.EARTH, GroveType.RIVER)
            .collect(Collectors.toCollection(ArrayList::new)),
            Stream.of(Direction.up, Direction.left, Direction.right, Direction.down)
            .collect(Collectors.toCollection(ArrayList::new)));


    private final String symbol;
    private final int step;
    private final int attack;
    private final ArrayList<GroveType> allowedGrove;
    private final ArrayList<Direction> allowedDirection;

    UnitType(String symbol, int step, int attack, ArrayList<GroveType> allowedGrove, ArrayList<Direction> allowedDirection) {
        this.symbol = symbol;
        this.step = step;
        this.attack = attack;
        this.allowedGrove = allowedGrove;
        this.allowedDirection = allowedDirection;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getStep() {
        return step;
    }

    public int getAttack() {
        return attack;
    }

    public ArrayList<GroveType> getAllowedGrove() {
        return allowedGrove;
    }

    public ArrayList<Direction> getAllowedDirection() {
        return allowedDirection;
    }
}
