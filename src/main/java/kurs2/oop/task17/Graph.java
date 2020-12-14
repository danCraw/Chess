package kurs2.oop.task17;

import kurs2.oop.task17.*;
import kurs2.oop.task17.service.CheckService;
import kurs2.oop.task17.service.GraphService;

import java.util.ArrayList;

public class Graph {
    private GraphService graphService = new GraphService();
    private ArrayList<ArrayList<Node>> nodes = new ArrayList<>();

    public ArrayList<ArrayList<Node>> getNodes() {
        return graphService.initField(nodes);
    }

    public void setNodes(ArrayList<ArrayList<Node>> nodes) {
        this.nodes = nodes;
    }
}
