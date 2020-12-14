package kurs2.oop.task17.service;

import kurs2.oop.task17.Constants;
import kurs2.oop.task17.Direction;
import kurs2.oop.task17.GroveType;
import kurs2.oop.task17.Node;

import java.util.ArrayList;

public class GraphService {

    CheckService check = new CheckService();

    public ArrayList<ArrayList<Node>> initField(ArrayList<ArrayList<Node>> nodes) {
        buildField(nodes);
        buildNeighbors(nodes);
        return nodes;
    }

    private ArrayList<ArrayList<Node>> buildNeighbors(ArrayList<ArrayList<Node>> nodes) {
        for (int x = 0; x < Constants.WEIGHT; x++) {
            for (int y = 0; y < Constants.HEIGHT; y++) {
                if (x > 0) {
                    addNeighbor(nodes, nodes.get(x).get(y), x - 1, y);
                    addNeighbor(nodes, nodes.get(x).get(y), x - 1, y + 1);
                }
                if (y > 0) {
                    addNeighbor(nodes, nodes.get(x).get(y), x + 1, y - 1);
                    addNeighbor(nodes, nodes.get(x).get(y), x, y - 1);
                }
                if ((x > 0) && (y > 0)) {
                    addNeighbor(nodes, nodes.get(x).get(y), x - 1, y - 1);
                }
                addNeighbor(nodes, nodes.get(x).get(y), x + 1, y);
                addNeighbor(nodes, nodes.get(x).get(y), x + 1, y + 1);
                addNeighbor(nodes, nodes.get(x).get(y), x, y + 1);
            }
        }
        return nodes;
    }

    private void addNeighbor(ArrayList<ArrayList<Node>> nodes, Node curNode, int neighborX, int neighborY) {
        Direction direction = check.defineDirection(curNode, nodes.get(neighborX).get(neighborY));
        curNode.getNeighbors().put(direction, nodes.get(neighborX).get(neighborY));
    }

    private void buildField(ArrayList<ArrayList<Node>> nodes) {
        createEarth(nodes);
        createRiver(nodes);
        createRiverCross(nodes);
        createSee(nodes);
    }

    private void createEarth(ArrayList<ArrayList<Node>> nodes) {
        for (int y = 0; y < Constants.HEIGHT + 1; y++) {
            ArrayList<Node> earth = new ArrayList<>();
            for (int x = 0; x < Constants.WEIGHT + 2; x++) {
                earth.add(new Node(x, y, GroveType.earth));
            }
            nodes.add(earth);
        }
    }

    private void createSee(ArrayList<ArrayList<Node>> nodes) {
        for (int y = 0; y < Constants.HEIGHT; y++) {
            for (int x = 0; x < Constants.WEIGHT; x++) {
                if (x < 4) {
                    nodes.get(x).get(y).setGroveType(GroveType.see);
                }
            }
        }
    }

    private void createRiver(ArrayList<ArrayList<Node>> nodes) {
        for (int y = 0; y < Constants.WEIGHT; y++) {
            for (int x = 0; x < Constants.HEIGHT; x++) {
                if (y == 7) {
                    nodes.get(x).get(y).setGroveType(GroveType.river);
                }
            }
        }
    }

    private void createRiverCross(ArrayList<ArrayList<Node>> nodes) {
        for (int y = 0; y < Constants.WEIGHT; y++) {
            for (int x = 0; x < Constants.HEIGHT; x++) {
                if (((x == 6) || (x == 8)) && ((y == 7))) {
                    nodes.get(x).get(y).setGroveType(GroveType.riverCross);
                }
            }
        }
    }

}
