package kurs2.oop.task17.service;

import kurs2.oop.task17.Constants;
import kurs2.oop.task17.Node;
import kurs2.oop.task17.Unit;

import java.util.LinkedList;

public class UnitService {

    public LinkedList<Node> getAllowedNodes(Unit unit) {
        CheckService check = new CheckService();
        GameFieldService gf = GameFieldService.getGameFieldService();
        LinkedList<Node> allowedMoves = new LinkedList<>();
        Node currentNode = unit.getNode();

        for (int x = 0; x < Constants.WEIGHT; x++) {
            for (int y = 0; y < Constants.HEIGHT; y++) {
                if (check.canDoStep(currentNode, gf.getNodes().get(x).get(y))) {
                    allowedMoves.add(gf.getNodes().get(x).get(y));
                }
            }
        }
        return allowedMoves;
    }

    public LinkedList<Node> getNodesToAttack(Unit unit) {
        CheckService check = new CheckService();
        GameFieldService gf = GameFieldService.getGameFieldService();
        LinkedList<Node> nodesToAttack = new LinkedList<>();
        Node currentNode = unit.getNode();

        for (int x = 0; x < Constants.WEIGHT; x++) {
            for (int y = 0; y < Constants.HEIGHT; y++) {
                if (check.canDoAttack(currentNode, gf.getNodes().get(x).get(y))) {
                    nodesToAttack.add(gf.getNodes().get(x).get(y));
                }
            }
        }
        return nodesToAttack;
    }


}
