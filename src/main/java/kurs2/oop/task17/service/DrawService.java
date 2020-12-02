package kurs2.oop.task17.service;

import kurs2.oop.task17.Direction;
import kurs2.oop.task17.GroveType;
import kurs2.oop.task17.Node;

public class DrawService {

    public void drawWarZone(GameFieldService gf) {
        Node currentNode = gf.getNodes().get(0).get(0);
        Node startNode = gf.getNodes().get(0).get(0);
        while (startNode != null) {
            while (currentNode.getNeighbors().get(Direction.right) != null) {
                if (currentNode.getGroveType() == GroveType.see) {
                    printSee(gf, currentNode);
                } else {
                    if (currentNode.getGroveType() == GroveType.earth) {
                        printEarth(gf, currentNode);
                    } else {
                        if (currentNode.getGroveType() == GroveType.river) {
                            printRiver(gf, currentNode);
                        } else {
                            if (currentNode.getGroveType() == GroveType.riverCross) {
                                printRiverCross(gf, currentNode);
                            }
                        }
                    }
                }
                currentNode = currentNode.getNeighbors().get(Direction.right);
            }
            startNode = startNode.getNeighbors().get(Direction.up);
            currentNode = startNode;
            System.out.println();
        }
    }

    private void printRiverCross(GameFieldService gf, Node node) {
        if (gf.getNodeToUnitMap().get(node) != null) {
            drawUnit(gf, node);
        } else {
            System.out.print((char) 27 + "[33m |" + " \uD83C\uDF2B " + "| " + (char) 27 + "[0m");
        }
    }

    private void printRiver(GameFieldService gf, Node node) {
        if (gf.getNodeToUnitMap().get(node) != null) {
            drawUnit(gf, node);
        } else {
            System.out.print((char) 27 + "[35m |" + " \uD83C\uDF2B " + "| " + (char) 27 + "[0m");
        }
    }

    private void printEarth(GameFieldService gf, Node node) {
        if (gf.getNodeToUnitMap().get(node) != null) {
            drawUnit(gf, node);
        } else {
            System.out.print((char) 27 + "[30m |" + " \uD83C\uDF2B " + "| " + (char) 27 + "[0m");
        }
    }

    private void printSee(GameFieldService gf, Node node) {
        if (gf.getNodeToUnitMap().get(node) != null) {
            drawUnit(gf, node);
        } else {
            System.out.print((char) 27 + "[34m |" + " \uD83C\uDF2B " + "| " + (char) 27 + "[0m");

        }
    }

    private void drawUnit(GameFieldService gf, Node node) {
        if (gf.getTeam1().contains(gf.getNodeToUnitMap().get(node))) {
            drawRedUnit(gf, node);
        }
        if (gf.getTeam2().contains(gf.getNodeToUnitMap().get(node))) {
            printBlueUnit(gf, node);
        }
    }

    private void drawRedUnit(GameFieldService gf, Node node) {
        System.out.print((char) 27 + "[31m | " + gf.getNodeToUnitMap().get(node).getSymbol() + " | " + (char) 27 + "[0m");
    }

    private void printBlueUnit(GameFieldService gf, Node node) {
        System.out.print((char) 27 + "[32m | " + gf.getNodeToUnitMap().get(node).getSymbol() + " | " + (char) 27 + "[0m");
    }

    private void drawUI() {

    }
}
