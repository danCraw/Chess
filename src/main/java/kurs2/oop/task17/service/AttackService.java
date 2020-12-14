package kurs2.oop.task17.service;

import kurs2.oop.task17.Graph;
import kurs2.oop.task17.Node;
import kurs2.oop.task17.Unit;
import org.w3c.dom.ls.LSOutput;

public class AttackService {

    private NodeService nodeService = NodeService.getNodeService();
    private GameFieldService gf = GameFieldService.getGameFieldService();
    private CheckService check = new CheckService();
    private Graph graph = gf.getGraph();

    public void attack(Node from, Node to) {
            System.err.print("Атака из ");
            nodeService.printNode(from);
            System.err.print("в ");
            nodeService.printNode(to);
            System.err.print("Убита фигура " + gf.getNodeToUnitMap().get(to).getUnitType());
            if (gf.getTeam1().contains(gf.getNodeToUnitMap().get(to))) {
                System.err.println(" из команды красных");
            } else {
                System.err.println(" из ыоманды зелёных");
            }
            kill(from, to);
            System.err.println("Атака выполнена");
            System.out.println();
        }

    private void kill(Node from, Node to) {
        Unit unit = gf.getNodeToUnitMap().get(graph.getNodes().get(from.getNodeX()).get(from.getNodeY()));
        Unit attackedFigure = gf.getNodeToUnitMap().get(to);
        gf.getNodeToUnitMap().put(to.getNeighbors().get(check.defineDirection(from, to)), unit);
        gf.getNodeToUnitMap().remove(from); // удаление себя
        gf.getNodeToUnitMap().remove(to); // удаление противника
        gf.getUnitToNodeMap().put(unit, to.getNeighbors().get(check.defineDirection(from, to)));
        if (check.isTeam1(unit)) {
            gf.getTeam1().remove(unit);
            gf.getNodeToUnitMap().get(to.getNeighbors().get(check.defineDirection(from, to))).setCurrentNode(to);
            gf.getTeam1().add(gf.getNodeToUnitMap().get(to.getNeighbors().get(check.defineDirection(from, to))));
            gf.getTeam2().remove(attackedFigure);
        }
        if (check.isTeam2(unit)) {
            gf.getTeam2().remove(unit);
            gf.getNodeToUnitMap().get(to.getNeighbors().get(check.defineDirection(from, to))).setCurrentNode(to);
            gf.getTeam2().add(gf.getNodeToUnitMap().get(to.getNeighbors().get(check.defineDirection(from, to))));
            gf.getTeam1().remove(attackedFigure);
        }
    }

}
