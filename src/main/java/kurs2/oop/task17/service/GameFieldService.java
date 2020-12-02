package kurs2.oop.task17.service;

import kurs2.oop.task17.*;
import kurs2.oop.task17.figure.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

public class GameFieldService {

    private GameField gf = new GameField();

    private static GameFieldService gameFieldService = new GameFieldService();

    private ArrayList<ArrayList<Node>> nodes = gf.getNodes();

    private Map<Node, Unit> nodeToUnitMap = gf.getNodeToUnitMap();
    private Map<Unit, Node> unitToNodeMap = gf.getUnitToNodeMap();

    private LinkedList<Unit> team1 = new LinkedList<>();
    private LinkedList<Unit> team2 = new LinkedList<>();

    public GameFieldService() {
        initField();
        initUnits();
    }

    private void initField() {
        buildField();
        buildNeighbors();
    }

    private void initUnits() {
        initTeam1();
        initTeam2();
    }

    private void initTeam1() {
        Commander commander = new Commander(nodes.get(7).get(0));
        Infantry infantry1 = new Infantry(nodes.get(3).get(4));
        Infantry infantry2 = new Infantry(nodes.get(11).get(4));
        Tank tank1 = new Tank(nodes.get(6).get(3));
        Tank tank2 = new Tank(nodes.get(8).get(3));
        Militia militia1 = new Militia(nodes.get(7).get(4));
        Militia militia2 = new Militia(nodes.get(7).get(2));
        Engineer engineer1 = new Engineer(nodes.get(4).get(4));
        Engineer engineer2 = new Engineer(nodes.get(10).get(4));
        Artillery artillery1 = new Artillery(nodes.get(4).get(2));
        Artillery artillery2 = new Artillery(nodes.get(10).get(2));
        AntiPlaneGun antiAircraftGun1 = new AntiPlaneGun(nodes.get(5).get(3));
        AntiPlaneGun antiAircraftGun2 = new AntiPlaneGun(nodes.get(9).get(3));
        Ship ship1 = new Ship(nodes.get(1).get(1));
        Ship ship2 = new Ship(nodes.get(2).get(3));
        Plane plane1 = new Plane(nodes.get(5).get(1));
        Plane plane2 = new Plane(nodes.get(9).get(1));
        Headquarters headquarters1 = new Headquarters(nodes.get(6).get(1));
        Headquarters headquarters2 = new Headquarters(nodes.get(8).get(1));

        putUnit(commander, team1);
        putUnit(infantry1, team1);
        putUnit(infantry2, team1);
        putUnit(tank1, team1);
        putUnit(tank2, team1);
        putUnit(militia1, team1);
        putUnit(militia2, team1);
        putUnit(engineer1, team1);
        putUnit(engineer2, team1);
        putUnit(artillery1, team1);
        putUnit(artillery2, team1);
        putUnit(antiAircraftGun1, team1);
        putUnit(antiAircraftGun2, team1);
        putUnit(ship1, team1);
        putUnit(ship2, team1);
        putUnit(plane1, team1);
        putUnit(plane2, team1);
        putUnit(headquarters1, team1);
        putUnit(headquarters2, team1);
    }

    private void initTeam2() {
        Commander commander = new Commander(nodes.get(7).get(12));
        Infantry infantry1 = new Infantry(nodes.get(3).get(8));
        Infantry infantry2 = new Infantry(nodes.get(11).get(8));
        Tank tank1 = new Tank(nodes.get(6).get(9));
        Tank tank2 = new Tank(nodes.get(8).get(9));
        Militia militia1 = new Militia(nodes.get(7).get(10));
        Militia militia2 = new Militia(nodes.get(7).get(8));
        Engineer engineer1 = new Engineer(nodes.get(4).get(8));
        Engineer engineer2 = new Engineer(nodes.get(10).get(8));
        Artillery artillery1 = new Artillery(nodes.get(4).get(10));
        Artillery artillery2 = new Artillery(nodes.get(10).get(10));
        AntiPlaneGun antiAircraftGun1 = new AntiPlaneGun(nodes.get(5).get(9));
        AntiPlaneGun antiAircraftGun2 = new AntiPlaneGun(nodes.get(9).get(9));
        Ship ship1 = new Ship(nodes.get(1).get(11));
        Ship ship2 = new Ship(nodes.get(2).get(9));
        Plane plane1 = new Plane(nodes.get(5).get(11));
        Plane plane2 = new Plane(nodes.get(9).get(11));
        Headquarters headquarters1 = new Headquarters(nodes.get(6).get(11));
        Headquarters headquarters2 = new Headquarters(nodes.get(8).get(11));

        putUnit(commander, team2);
        putUnit(infantry1, team2);
        putUnit(infantry2, team2);
        putUnit(tank1, team2);
        putUnit(tank2, team2);
        putUnit(militia1, team2);
        putUnit(militia2, team2);
        putUnit(engineer1, team2);
        putUnit(engineer2, team2);
        putUnit(artillery1, team2);
        putUnit(artillery2, team2);
        putUnit(antiAircraftGun1, team2);
        putUnit(antiAircraftGun2, team2);
        putUnit(ship1, team2);
        putUnit(ship2, team2);
        putUnit(plane1, team2);
        putUnit(plane2, team2);
        putUnit(headquarters1, team2);
        putUnit(headquarters2, team2);
    }

    private void buildField() {
        createEarth();
        createRiver();
        createRiverCross();
        createSee();
    }

    private void createEarth() {

        for (int y = 0; y < Constants.HEIGHT + 1; y++) {
            ArrayList<Node> earth = new ArrayList<>();
            for (int x = 0; x < Constants.WEIGHT + 2; x++) {
                earth.add(new Node(x, y, GroveType.earth));
            }
            nodes.add(earth);
        }
    }

    private void createSee() {
        for (int y = 0; y < Constants.HEIGHT; y++) {
            for (int x = 0; x < Constants.WEIGHT; x++) {
                if (x < 3) {
                    nodes.get(x).get(y).setGroveType(GroveType.see);
                }
            }
        }
    }

    private void createRiver() {
        for (int y = 0; y < Constants.WEIGHT; y++) {
            for (int x = 0; x < Constants.HEIGHT; x++) {
                if (y == 6) {
                    nodes.get(x).get(y).setGroveType(GroveType.river);
                }
            }
        }
    }

    private void createRiverCross() {
        for (int y = 0; y < Constants.WEIGHT; y++) {
            for (int x = 0; x < Constants.HEIGHT; x++) {
                if (((x == 6) || (x == 8)) && ((y == 6))) {
                    nodes.get(x).get(y).setGroveType(GroveType.riverCross);
                }
            }
        }
    }


    private void putUnit(Unit unit, LinkedList<Unit> units) {
        units.add(unit);
        nodeToUnitMap.put(unit.getNode(), unit);
        unitToNodeMap.put(unit, unit.getNode());
    }

    private void buildNeighbors() {
        for (int x = 0; x < Constants.WEIGHT; x++) {
            for (int y = 0; y < Constants.HEIGHT; y++) {
                if (x > 0) {
                    addNeighbor(nodes.get(x).get(y), x - 1, y);
                    addNeighbor(nodes.get(x).get(y), x - 1, y + 1);
                }
                if (y > 0) {
                    addNeighbor(nodes.get(x).get(y), x + 1, y - 1);
                    addNeighbor(nodes.get(x).get(y), x, y - 1);
                }
                if ((x > 0) && (y > 0)) {
                    addNeighbor(nodes.get(x).get(y), x - 1, y - 1);
                }
                addNeighbor(nodes.get(x).get(y), x + 1, y);
                addNeighbor(nodes.get(x).get(y), x + 1, y + 1);
                addNeighbor(nodes.get(x).get(y), x, y + 1);
            }
        }
    }

    public LinkedList<Unit> getTeam(Node n) {
        Unit u = nodeToUnitMap.get(n);
        if (team1.contains(u)) {
            return team1;
        }
        if (team2.contains(u)) {
            return team2;
        }
        return null;
    }

    private void addNeighbor(Node curNode, int neighborX, int neighborY) {
        Direction direction = defineDirection(curNode, nodes.get(neighborX).get(neighborY));
            curNode.getNeighbors().put(direction, nodes.get(neighborX).get(neighborY));
    }

    private Direction defineDirection(Node from, Node to) {
        if (straight(from, to) != null) {
            return straight(from, to);
        }
        if (diagonal(from, to) != null) {
            return diagonal(from, to);
        }
        return null;
    }

   private Direction diagonal(Node from, Node to) {
        if (Math.abs(from.getNodeX() - to.getNodeX()) != Math.abs(from.getNodeY() - to.getNodeY())) {
            return null;
        }
        if ((from.getNodeX() < to.getNodeX()) && (from.getNodeY() < to.getNodeY())) {
            return Direction.rightUp;
        }
        if ((from.getNodeX() > to.getNodeX()) && (from.getNodeY() > to.getNodeY())) {
            return Direction.leftDown;
        }
        if ((from.getNodeX() < to.getNodeX()) && (from.getNodeY() > to.getNodeY())) {
            return Direction.rightDown;
        }
        if ((from.getNodeX() > to.getNodeX()) && (from.getNodeY() < to.getNodeY())) {
            return Direction.leftUp;
        }
        return null;
    }

   private Direction straight(Node from, Node to) {
        if ((from.getNodeX() == to.getNodeX()) && (from.getNodeY() < to.getNodeY())) {
            return Direction.up;
        }
        if ((from.getNodeX() == to.getNodeX()) && (from.getNodeY() > to.getNodeY())) {
            return Direction.down;
        }
        if ((from.getNodeX() > to.getNodeX()) && (from.getNodeY() == to.getNodeY())) {
            return Direction.left;
        }
        if ((from.getNodeX() < to.getNodeX()) && (from.getNodeY() == to.getNodeY())) {
            return Direction.right;
        }
        return null;
    }

    public int countUnitTypeInTeam(LinkedList<Unit> team, UnitType unitType) {
        int k = 0;
        for (Unit unit : team) {
            if (unit.getUnitType() == unitType) {
                k++;
            }
        }
        return k;
    }

    public int countNavalForce(LinkedList<Unit> team) {
        int k = 0;
        for (Unit unit : team) {
            if ((unit.getUnitType() == UnitType.ship)){
                k++;
            }
        }
        return k;
    }

    public int countAirForce(LinkedList<Unit> team) {
        int k = 0;
        for (Unit unit : team) {
            if ((unit.getUnitType() == UnitType.ship)){
                k++;
            }
        }
        return k;
    }

    public int countEarthForce(LinkedList<Unit> team) {
        int k = 0;
        for (Unit unit : team) {
            if ((unit.getUnitType() == UnitType.infantry) ||
               (unit.getUnitType() == UnitType.tank) ||
               (unit.getUnitType() == UnitType.artillery)){
                k++;
            }
        }
        return k;
    }

    public Unit getRandomUnit(LinkedList<Unit> team) {
        return (team.get(RandomService.interval(0, team.size() - 1)));
    }

    public LinkedList<Unit> getTeam1() {
        return team1;
    }

    public LinkedList<Unit> getTeam2() {
        return team2;
    }

    public ArrayList<ArrayList<Node>> getNodes() {
        return nodes;
    }

    public Map<Node, Unit> getNodeToUnitMap() {
        return nodeToUnitMap;
    }

    public Map<Unit, Node> getUnitToNodeMap() {
        return unitToNodeMap;
    }

    public static GameFieldService getGameFieldService() {
        return gameFieldService;
    }
}
