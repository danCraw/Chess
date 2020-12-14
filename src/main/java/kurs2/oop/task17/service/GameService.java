package kurs2.oop.task17.service;

import kurs2.oop.task17.Node;
import kurs2.oop.task17.Unit;
import kurs2.oop.task17.UnitType;

import java.util.LinkedList;

public class GameService {
    LinkedList<LinkedList<Unit>> players = new LinkedList<>();

    GameFieldService gf = GameFieldService.getGameFieldService();
    UnitService unitService = new UnitService();

    public void start() {
        MovementService mv = new MovementService();
        AttackService at = new AttackService();
        DrawService draw = new DrawService();
        initPlayers();
        startGame(mv, at, draw);
        draw.drawWarZone(gf);
    }

    private void  startGame(MovementService mv, AttackService at, DrawService draw) {
        Unit unitToAttack;
        Unit unitToStep;
        while (!gameOver()){
            for (LinkedList<Unit> player : players) {
                draw.drawWarZone(gf);
                unitToAttack = findUnitToAttack(player);
                if (unitToAttack == null) {
                    unitToStep = findUnitToStep(player);
                    mv.go(unitToStep.getNode(), unitService.getAllowedNodes(unitToStep).get(RandomService.interval(0, unitService.getAllowedNodes(unitToStep).size() - 1)));
                } else {
                    at.attack(unitToAttack.getNode(), unitService.getNodesToAttack(unitToAttack).get(RandomService.interval(0, unitService.getNodesToAttack(unitToAttack).size() - 1)));
                }
            }
        }
    }

    private Unit findUnitToAttack(LinkedList<Unit> team) {
        for (Unit unit : team) {
            if (unitService.getNodesToAttack(unit).size() != 0) {
                return unit;
            }
        }
        return null;
    }

    private Unit findUnitToStep(LinkedList<Unit> team){
        Unit randomUnit = team.get(RandomService.interval(0, team.size() - 1));
        LinkedList<Node> possibleToStep = unitService.getAllowedNodes(randomUnit);
        while (possibleToStep.size() == 0) {
            randomUnit = team.get(RandomService.interval(0, team.size() - 1));
            possibleToStep = unitService.getAllowedNodes(randomUnit);
        }
        return randomUnit;
    }

    private void initPlayers() {
        players.add(gf.getTeam1());
        players.add(gf.getTeam2());
    }

    private boolean gameOver() {
        LinkedList<Unit> team1 = gf.getTeam1();
        LinkedList<Unit> team2 = gf.getTeam2();
        return (gf.countNavalForce(team1) == 0 || gf.countNavalForce(team2) == 0) ||
                (gf.countAirForce(team1) == 0 || gf.countAirForce(team2) == 0) ||
                (gf.countEarthForce(team1) == 0 || gf.countEarthForce(team2) == 0) ||
                (gf.countCommanders(team1) == 0 || gf.countCommanders(team2) == 0);
    }
}
