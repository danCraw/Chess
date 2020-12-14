package kurs2.oop.task17.service;

import kurs2.oop.task17.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

public class GameFieldService {


    private GameField gf = new GameField();

    private static GameFieldService gameFieldService = new GameFieldService();

    private Map<Node, Unit> nodeToUnitMap = gf.getNodeToUnitMap();
    private Map<Unit, Node> unitToNodeMap = gf.getUnitToNodeMap();

    private LinkedList<Unit> team1 = new LinkedList<>();
    private LinkedList<Unit> team2 = new LinkedList<>();
    private Graph graph = new Graph();
    private ArrayList<ArrayList<Node>> nodes = graph.getNodes();

    public GameFieldService() {
        initUnits();
    }

    private void initUnits() {
        initTeam1();
        initTeam2();
    }

    private void initTeam1() {

        Unit commander = new Unit(nodes.get(8).get(1), UnitType.commander);
        Unit infantry1 = new Unit(nodes.get(4).get(5), UnitType.infantry);
        Unit infantry2 = new Unit(nodes.get(12).get(5), UnitType.infantry);
        Unit tank1 = new Unit(nodes.get(7).get(4), UnitType.tank);
        Unit tank2 = new Unit(nodes.get(9).get(4), UnitType.tank);
        Unit militia1 = new Unit(nodes.get(8).get(5), UnitType.militia);
        Unit militia2 = new Unit(nodes.get(8).get(2), UnitType.militia);
        Unit engineer1 = new Unit(nodes.get(5).get(5), UnitType.engineer);
        Unit engineer2 = new Unit(nodes.get(11).get(5), UnitType.engineer);
        Unit artillery1 = new Unit(nodes.get(5).get(3), UnitType.artillery);
        Unit artillery2 = new Unit(nodes.get(11).get(3), UnitType.artillery);
        Unit antiAircraftGun1 = new Unit(nodes.get(6).get(4), UnitType.antiPlaneGun);
        Unit antiAircraftGun2 = new Unit(nodes.get(10).get(4), UnitType.antiPlaneGun);
        Unit ship1 = new Unit(nodes.get(2).get(2), UnitType.ship);
        Unit ship2 = new Unit(nodes.get(3).get(4), UnitType.ship);
        Unit plane1 = new Unit(nodes.get(6).get(2), UnitType.plane);
        Unit plane2 = new Unit(nodes.get(10).get(2), UnitType.plane);
        Unit headquarters1 = new Unit(nodes.get(7).get(2), UnitType.headquarter);
        Unit headquarters2 = new Unit(nodes.get(9).get(2), UnitType.headquarter);

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
        Unit commander = new Unit(nodes.get(8).get(13), UnitType.commander);
        Unit infantry1 = new Unit(nodes.get(4).get(9), UnitType.infantry);
        Unit infantry2 = new Unit(nodes.get(12).get(9), UnitType.infantry);
        Unit tank1 = new Unit(nodes.get(7).get(10), UnitType.tank);
        Unit tank2 = new Unit(nodes.get(9).get(10), UnitType.tank);
        Unit militia1 = new Unit(nodes.get(8).get(11), UnitType.militia);
        Unit militia2 = new Unit(nodes.get(8).get(9), UnitType.militia);
        Unit engineer1 = new Unit(nodes.get(5).get(9), UnitType.engineer);
        Unit engineer2 = new Unit(nodes.get(11).get(9), UnitType.engineer);
        Unit artillery1 = new Unit(nodes.get(5).get(11), UnitType.artillery);
        Unit artillery2 = new Unit(nodes.get(11).get(11), UnitType.artillery);
        Unit antiAircraftGun1 = new Unit(nodes.get(6).get(10), UnitType.antiPlaneGun);
        Unit antiAircraftGun2 = new Unit(nodes.get(10).get(10), UnitType.antiPlaneGun);
        Unit ship1 = new Unit(nodes.get(2).get(12), UnitType.ship);
        Unit ship2 = new Unit(nodes.get(3).get(10), UnitType.ship);
        Unit plane1 = new Unit(nodes.get(6).get(12), UnitType.plane);
        Unit plane2 = new Unit(nodes.get(10).get(12), UnitType.plane);
        Unit headquarters1 = new Unit(nodes.get(7).get(12), UnitType.headquarter);
        Unit headquarters2 = new Unit(nodes.get(9).get(12), UnitType.headquarter);

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

    private void putUnit(Unit unit, LinkedList<Unit> units) {
        units.add(unit);
        nodeToUnitMap.put(unit.getNode(), unit);
        unitToNodeMap.put(unit, unit.getNode());
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
        return countUnitTypeInTeam(team, UnitType.ship);
    }

    public int countAirForce(LinkedList<Unit> team) {
        return countUnitTypeInTeam(team, UnitType.plane);

    }

    public int countEarthForce(LinkedList<Unit> team) {
        return  countUnitTypeInTeam(team, UnitType.infantry) +
                countUnitTypeInTeam(team, UnitType.tank) +
                countUnitTypeInTeam(team, UnitType.artillery);
    }

    public int countCommanders(LinkedList<Unit> team) {
        return countUnitTypeInTeam(team, UnitType.commander);
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

    public Graph getGraph() {
        return graph;
    }

    public static GameFieldService getGameFieldService() {
        return gameFieldService;
    }
}
