package kurs2.oop.task17;

import java.util.HashMap;
import java.util.Map;

public class Node {
    private Map<Direction, Node> neighbors = new HashMap<>();
    private int x, y;
    private GroveType gt;

    public Node(int x, int y, GroveType gt) {
        this.x = y;
        this.y = x;
        this.gt = gt;
    }

    public Map<Direction, Node> getNeighbors() {
        return neighbors;
    }

    public GroveType getGroveType() {
        return gt;
    }

    public int getNodeX() {
        return x;
    }

    public int getNodeY() { return y; }

    public void setGroveType(GroveType gt) {
        this.gt = gt;
    }
}
