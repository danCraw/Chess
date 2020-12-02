package kurs2.oop.task17.service;

import kurs2.oop.task17.Node;
import kurs2.oop.task17.Unit;
import kurs2.oop.task17.UnitType;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class GameService {
    private GameFieldService gf = GameFieldService.getGameFieldService();
    private UnitService unitService = new UnitService();

    Map<Integer, LinkedList<Unit>> playerToTeam = new HashMap<Integer, LinkedList<Unit>>() {{
        put(1, gf.getTeam1());
        put(2, gf.getTeam2());
    }};

    public void start() {
        MovementService move = new MovementService();
        AttackService attack = new AttackService();
        startBattle(move, attack);
    }

    private void startBattle(MovementService mv, AttackService attackService) {
        int move = 0;
        LinkedList<Unit> curTeam;
        Unit randomUnit;
        while (move != 100) {
//            System.err.println(move);
            for (int player = 1; player <= 2; player++) {

                curTeam = playerToTeam.get(player);
                randomUnit = gf.getRandomUnit(curTeam);
                LinkedList<Node> possibleAttack = unitService.getNodesToAttack(randomUnit);
                LinkedList<Node> possibleWays = unitService.getAllowedNodes(randomUnit);

                if (possibleAttack.size() != 0) {
                    move++;
                    Node randomNode = possibleAttack.get(RandomService.interval(0, possibleAttack.size() - 1));
                    attackService.attack(randomUnit.getNode(), randomNode);
                } else {
                    move++;
                    if (possibleWays.size() != 0 && possibleAttack.size() == 0) {
                        Node randomNode = possibleWays.get(RandomService.interval(0, possibleWays.size() - 1));
                        mv.go(randomUnit.getNode(), randomNode);
                    }
                }

            }
        }
        DrawService d = new DrawService();
        d.drawWarZone(gf);
    }

    private boolean gameOver() {
        LinkedList<Unit> team1 = gf.getTeam1();
        LinkedList<Unit> team2 = gf.getTeam2();
        return  !(gf.countNavalForce(team1) > 0 || gf.countNavalForce(team2) > 0) &&
                !(gf.countAirForce(team1) > 0 || gf.countAirForce(team2) > 0) &&
                !(gf.countEarthForce(team1) > 0 || gf.countEarthForce(team2) > 0);
    }


}
