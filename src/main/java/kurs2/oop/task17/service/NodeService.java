package kurs2.oop.task17.service;

import kurs2.oop.task17.model.Node;

public class NodeService  {

    private static NodeService nodeService = new NodeService();

    public void printNode(Node n) {
        System.out.print(n.getNodeX() + " ");
        System.out.print(n.getNodeY() + " ");
        System.out.println(n.getGroveType() + " ");
    }

    public static NodeService getNodeService() {
        return nodeService;
    }
}
