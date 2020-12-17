package kurs2.oop.task17.service;

import kurs2.oop.task17.model.Direction;
import kurs2.oop.task17.model.Graph;
import kurs2.oop.task17.model.GroveType;
import kurs2.oop.task17.model.Node;

public class DrawService {

    GameFieldService gf = GameFieldService.getGameFieldService();
    Graph graph = gf.getGraph();

    public void drawWarZone(GameFieldService gf) {
        Node currentNode = graph.getNodes().get(0).get(0);
        Node startNode = graph.getNodes().get(0).get(0);
        while (startNode != null) {
            while (currentNode.getNeighbors().get(Direction.right) != null) {
                if (currentNode.getNodeX() == 0 || currentNode.getNodeY() == 0) {
                    drawAsix(currentNode);
                } else {
                    if (currentNode.getGroveType() == GroveType.SEE) {
                        printSee(gf, currentNode);
                    } else {
                        if (currentNode.getGroveType() == GroveType.EARTH) {
                            printEarth(gf, currentNode);
                        } else {
                            if (currentNode.getGroveType() == GroveType.RIVER) {
                                printRiver(gf, currentNode);
                            } else {
                                if (currentNode.getGroveType() == GroveType.RIVER_CROSS) {
                                    printRiverCross(gf, currentNode);
                                }
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

    private void drawAsix(Node node) {
      int x = node.getNodeX();
      int y = node.getNodeY();
        if (x == 0 && y == 0) {
            System.out.print("     ");
        }   else {
            if(x== 0 && y!= 0){
                if (y < 10) {
                    System.out.print("|" + (y) + "| ");
                } else {
                    System.out.print("|" + (y) + "|");
                }
            }else{
//                System.out.print("| "+ (x) + "  |  ");
            }
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
            System.out.print(" |" + " \uD83C\uDF2B " + "| ");
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
        System.out.print((char) 27 + "[31m | " + gf.getNodeToUnitMap().get(node).getUnitType().getSymbol() + " | " + (char) 27 + "[0m");
    }

    private void printBlueUnit(GameFieldService gf, Node node) {
        System.out.print((char) 27 + "[32m | " + gf.getNodeToUnitMap().get(node).getUnitType().getSymbol() + " | " + (char) 27 + "[0m");
    }

    private void drawUI() {

    }
}
