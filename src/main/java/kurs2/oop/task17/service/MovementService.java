package kurs2.oop.task17.service;

import kurs2.oop.task17.Direction;
import kurs2.oop.task17.Node;
import kurs2.oop.task17.Unit;

public class MovementService {

    private CheckService check = new CheckService();
    private GameFieldService gf = GameFieldService.getGameFieldService();
    private NodeService nodeService = NodeService.getNodeService();
    private UnitService unitService = new UnitService();

    public void go(Node from, Node to) {
        int amountSteps = getAmountSteps(from, to);
        Direction direction = getDirection(from, to);
        int i = 0;
        if (direction == Direction.right) {
            while (i < amountSteps) {
                move(gf.getNodes().get(from.getNodeX() + i).get(from.getNodeY()),
                        gf.getNodes().get(from.getNodeX() + (i + 1)).get(from.getNodeY()));
                i++;
                System.out.println("Ходов выполнено " + i);
            }
        } else {
            if (direction == Direction.left) {
                while (i < amountSteps) {
                    move(gf.getNodes().get(from.getNodeX() - i).get(from.getNodeY()),
                            gf.getNodes().get(from.getNodeX() - (i + 1)).get(from.getNodeY()));
                    i++;
                    System.out.println("Ходов выполнено " + i);
                }
            }
            if (direction == Direction.up) {
                while (i < amountSteps) {
                    move(gf.getNodes().get(from.getNodeX()).get(from.getNodeY() + i),
                            gf.getNodes().get(from.getNodeX()).get(from.getNodeY() + (i + 1)));
                    i++;
                    System.out.println("Ходов выполнено " + i);
                }
            } else {
                if (direction == Direction.down) {
                    while (i < amountSteps) {
                        move(gf.getNodes().get(from.getNodeX()).get(from.getNodeY() - i),
                                gf.getNodes().get(from.getNodeX()).get(from.getNodeY() - (i + 1)));
                        i++;
                        System.out.println("Ходов выполнено " + i);
                    }
                }
                if (direction == Direction.leftUp) {
                    while (i < amountSteps) {
                        move(gf.getNodes().get(from.getNodeX() - i).get(from.getNodeY() + i),
                                gf.getNodes().get(from.getNodeX() - (i + 1)).get(from.getNodeY() + (i + 1)));
                        i++;
                        System.out.println("Ходов выполнено " + i);
                    }
                }
                if (direction == Direction.leftDown) {
                    while (i < amountSteps) {
                        move(gf.getNodes().get(from.getNodeX() - i).get(from.getNodeY() - i),
                                gf.getNodes().get(from.getNodeX() - (i + 1)).get(from.getNodeY() - (i + 1)));

                        i++;
                        System.out.println("Ходов выполнено " + i);
                    }
                }
                if (direction == Direction.rightUp) {
                    while (i < amountSteps) {
                        move(gf.getNodes().get(from.getNodeX() + i).get(from.getNodeY() + i),
                                gf.getNodes().get(from.getNodeX() + (i + 1)).get(from.getNodeY() + (i + 1)));
                        i++;
                        System.out.println("Ходов выполнено " + i);
                    }
                }
                if (direction == Direction.rightDown) {
                    while (i < amountSteps) {
                        move(gf.getNodes().get(from.getNodeX() + i).get(from.getNodeY() - i),
                                gf.getNodes().get(from.getNodeX() + (i + 1)).get(from.getNodeY() - (i + 1)));
                        i++;
                        System.out.println("Ходов выполнено " + i);
                    }
                }
            }
        }
    }

    private void move(Node from, Node to) {
        System.out.print("Ход из ");
        nodeService.printNode(from);
        System.out.print("в ");
        nodeService.printNode(to);
        Node curr = from;
        Direction direction = getDirection(from, to);
        if (gf.getNodeToUnitMap().get(from) != null) {
            System.out.println("фигура " + gf.getNodeToUnitMap().get(from).getUnitType());
            System.out.println("Направление " + direction);
            if (!check.canDoStep(from, to)) {
                System.err.println("Ход не выполнен");
                System.out.println();
                return;
            } else {
                System.out.println("Ход выполнен");
                System.out.println();
                doStep(curr, curr.getNeighbors().get(direction));
            }
        }
    }


    private void doStep(Node from, Node to) {
        Unit unit = gf.getNodeToUnitMap().get(from);
        System.out.println(unit);
        gf.getNodeToUnitMap().put(to, unit);
        gf.getNodeToUnitMap().remove(from);
        gf.getUnitToNodeMap().put(unit, to);
        if (check.isTeam1(unit)) {
            gf.getTeam1().remove(unit);
            gf.getNodeToUnitMap().get(to).setCurrentNode(to);
            gf.getTeam1().add(gf.getNodeToUnitMap().get(to));
        }
        if (check.isTeam2(unit)) {
            gf.getTeam2().remove(unit);
            gf.getNodeToUnitMap().get(to).setCurrentNode(to);
            gf.getTeam2().add(gf.getNodeToUnitMap().get(to));
        }
    }

    private Direction getDirection(Node from, Node to) {
        Direction d = check.straight(from, to);
        if (d != null) {
            return d;
        } else {
            return check.diagonal(from, to);
        }
    }

    private int getAmountSteps(Node from, Node to) {

        if (check.amountSteps(from, to)) {

            if (Math.abs(from.getNodeX() - to.getNodeX()) == 0) {
                return Math.abs(from.getNodeY() - to.getNodeY());
            }
            if (Math.abs(from.getNodeY() - to.getNodeY()) == 0) {
                return Math.abs(from.getNodeX() - to.getNodeX());
            }
            if (Math.abs(from.getNodeY() - to.getNodeY()) != 0 && Math.abs(from.getNodeX() - to.getNodeX()) != 0) {
                return Math.abs(from.getNodeX() - to.getNodeX());
            }
        }
        return -1;
    }

}

