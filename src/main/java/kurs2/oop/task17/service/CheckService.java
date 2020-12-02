package kurs2.oop.task17.service;

import kurs2.oop.task17.Constants;
import kurs2.oop.task17.Direction;
import kurs2.oop.task17.Node;
import kurs2.oop.task17.Unit;

public class CheckService {

    private GameFieldService gf = GameFieldService.getGameFieldService();

    boolean amountSteps(Node from, Node to) {
        Unit u = gf.getNodeToUnitMap().get(from);
        return (Math.abs(from.getNodeX() - to.getNodeX()) <= u.getSteps()) && (Math.abs(from.getNodeY() - to.getNodeY()) <= u.getSteps())
                && (to.getNodeY() < Constants.HEIGHT)
                && (to.getNodeY() >= 0)
                && (to.getNodeX() < Constants.WEIGHT)
                && (to.getNodeX() >= 0);
    }

    private boolean correctAttackDistance(Node from, Node to) {
        Unit u = gf.getNodeToUnitMap().get(from);
        return (Math.abs(from.getNodeX() - to.getNodeX()) <= u.getAttack()) && (Math.abs(from.getNodeY() - to.getNodeY()) <= u.getAttack())
                && (to.getNodeY() < Constants.HEIGHT)
                && (to.getNodeY() >= 0)
                && (to.getNodeX() < Constants.WEIGHT)
                && (to.getNodeX() >= 0);
    }

    boolean canDoAttack(Node from, Node to) {
//        if (!correctAttackDistance(from, to)) {
//            System.out.println("одинаковые команды");
//        }
        return employment(to) && employment(from) && direction(from, to) && !teamAreEqual(from, to) && correctAttackDistance(from, to);
    }

    public boolean canDoStep(Node from, Node to) {
        return !employment(to) && employment(from) && amountSteps(from, to) && wayIsClear(from, to) && groveType(from, to) && direction(from, to);
    }

    boolean canDoStepWithAttack(Node from, Node to) {
        return (canDoAttack(from, to)) && canDoStep(from, to);
    }

    private boolean groveType(Node from, Node to) {

        return gf.getNodeToUnitMap().get(from).getAllowedGrove().contains(to.getGroveType());
    }

    private boolean direction(Node from, Node to) {
        if (gf.getNodeToUnitMap().get(from).getAllowedDirection() != null) {
            return gf.getNodeToUnitMap().get(from).getAllowedDirection().contains(defineDirection(from, to));
        } else {
            return false;
        }
    }

    private boolean employment(Node n) {
        return gf.getNodeToUnitMap().get(n) != null;
    }

    private boolean wayIsClear(Node from, Node to) {
        int i = 0;
        Direction direction = straight(from, to);

        if (direction != null) {
            if (direction == Direction.left) {
                while (gf.getNodes().get(from.getNodeX() - i).get(from.getNodeY()) != to) {
                    i++;
                    if (employment(gf.getNodes().get(from.getNodeX() - i).get(from.getNodeY()))) {
                        return false;
                    }
                }
                return true;
            }
            if (direction == Direction.up) {
                while (gf.getNodes().get(from.getNodeX()).get(from.getNodeY() + i) != to) {
                    i++;
                    if (employment((gf.getNodes().get(from.getNodeX()).get(from.getNodeY() + i)))) {
                        return false;
                    }
                }
                return true;
            }
            if (direction == Direction.right) {
                while (gf.getNodes().get(from.getNodeX() + i).get(from.getNodeY()) != to) {
                    i++;
                    if (employment((gf.getNodes().get(from.getNodeX() + i).get(from.getNodeY())))) {
                        return false;
                    }
                }
                return true;
            }
            if (direction == Direction.down) {
                while (gf.getNodes().get(from.getNodeX()).get(from.getNodeY() - i) != to) {
                    i++;
                    if  (employment((gf.getNodes().get(from.getNodeX()).get(from.getNodeY() - i)))) {
                        return false;
                    }
                }
                return true;
            }

        } else {
            direction = diagonal(from, to);
            if (direction == Direction.leftUp) {
                while (gf.getNodes().get(from.getNodeX() - i).get(from.getNodeY() + i) != to) {
                    i++;
                    if (employment((gf.getNodes().get(from.getNodeX() - i).get(from.getNodeY() + i)))) {
                        return false;
                    }
                }
                return true;
            }
            if (direction == Direction.leftDown) {
                while (gf.getNodes().get(from.getNodeX() - i).get(from.getNodeY() - i) != to) {
                    i++;
                    if (employment((gf.getNodes().get(from.getNodeX() - i).get(from.getNodeY() - i)))) {
                        return false;
                    }
                }
                return true;
            }
            if (direction == Direction.rightUp) {
                while (gf.getNodes().get(from.getNodeX() + i).get(from.getNodeY() + i) != to) {
                    i++;
                    if (employment((gf.getNodes().get(from.getNodeX() + i).get(from.getNodeY() + i)))) {
                        return false;
                    }
                }
                return true;
            }
            if (direction == Direction.rightDown) {
                while (gf.getNodes().get(from.getNodeX() + i).get(from.getNodeY() - i) != to) {
                    i++;
                    if (employment((gf.getNodes().get(from.getNodeX() + i).get(from.getNodeY() - i)))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    private boolean teamAreEqual(Node from, Node to) {
        return gf.getTeam(from).equals(gf.getTeam(to));
    }

    private Direction defineDirection(Node from, Node to) {
        if (straight(from, to) != null) {
            return straight(from, to);
        }
        if (diagonal(from, to) != null) {
            return diagonal(from, to);
        }
        return null;
    }

    Direction diagonal(Node from, Node to) {
        if (Math.abs(from.getNodeX() - to.getNodeX()) != Math.abs(from.getNodeY() - to.getNodeY())) {
            return null;
        }
        if ((from.getNodeX() < to.getNodeX()) && (from.getNodeY() < to.getNodeY())) {
            return Direction.rightUp;
        }
        if ((from.getNodeX() > to.getNodeX()) && (from.getNodeY() > to.getNodeY())) {
            return Direction.leftDown;
        }
        if ((from.getNodeX() < to.getNodeX()) && (from.getNodeY() > to.getNodeY())) {
            return Direction.rightDown;
        }
        if ((from.getNodeX() > to.getNodeX()) && (from.getNodeY() < to.getNodeY())) {
            return Direction.leftUp;
        }
        return null;
    }

    Direction straight(Node from, Node to) {
        if ((from.getNodeX() == to.getNodeX()) && (from.getNodeY() < to.getNodeY())) {
            return Direction.up;
        }
        if ((from.getNodeX() == to.getNodeX()) && (from.getNodeY() > to.getNodeY())) {
            return Direction.down;
        }
        if ((from.getNodeX() > to.getNodeX()) && (from.getNodeY() == to.getNodeY())) {
            return Direction.left;
        }
        if ((from.getNodeX() < to.getNodeX()) && (from.getNodeY() == to.getNodeY())) {
            return Direction.right;
        }
        return null;
    }
}
