package kurs2.oop.task17.service;

import kurs2.oop.task17.Node;
import kurs2.oop.task17.Unit;
import org.w3c.dom.ls.LSOutput;

public class AttackService {

    private NodeService nodeService = NodeService.getNodeService();
    private GameFieldService gf = GameFieldService.getGameFieldService();

    public void attack(Node from, Node to) {
//            System.err.println("ебашим");
            System.err.print("Атака из ");
            nodeService.printNode(from);
            System.err.print("в ");
            nodeService.printNode(to);
            System.err.print("Убита фигура " + gf.getNodeToUnitMap().get(to).getUnitType());
            if (gf.getTeam1().contains(gf.getNodeToUnitMap().get(to))) {
                System.err.println(" из команды красных");
            } else {
                System.err.println(" из ыоманды жёлтых");
            }
            kill(from, to);
            System.err.println("Атака выполнена");
            System.out.println();
//            if (check.canDoStepWithAttack(from, to)) {
//                System.out.println("выполнен ход |" + from.getNodeX() + " " + from.getNodeY() + "| в |" + to.getNodeX() + " " + to.getNodeY() + "| ");
//                System.out.println("проведена атака " + from.getNodeX() + " " + from.getNodeY() + " в " + to.getNodeX() + " " + to.getNodeY());
//                kill(from, to);
//            }
//            } else {
//               if (check.canDoAttack(from, to)) {
//                   gf.getNodeToUnitMap().remove(to);
////                System.err.println("Ход не выполнен");
//                   System.out.println("проведена атака " + from.getNodeX() + " " + from.getNodeY() + " в " + to.getNodeX() + " " + to.getNodeY());
//               }
//            }
        }

    private void kill(Node from, Node to) {
        Unit u = gf.getNodeToUnitMap().get(from);
        gf.getNodeToUnitMap().put(to, u);
        gf.getNodeToUnitMap().remove(from);
        gf.getUnitToNodeMap().put(u, to);
    }

}
