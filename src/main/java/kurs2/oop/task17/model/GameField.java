package kurs2.oop.task17.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class GameField {

   private GameField gf = this;

    private Map<Node, Unit> nodeToUnitMap = new HashMap<>();
    private Map<Unit, Node> unitToNodeMap = new HashMap<>();

    private LinkedList<Unit> team1 = new LinkedList<>();
    private LinkedList<Unit> team2 = new LinkedList<>();
    private ArrayList<ArrayList<Node>> nodes = new ArrayList<>();

    public GameField getGf() {
        return gf;
    }

    public Map<Node, Unit> getNodeToUnitMap() {
        return nodeToUnitMap;
    }

    public Map<Unit, Node> getUnitToNodeMap() {
        return unitToNodeMap;
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
}
