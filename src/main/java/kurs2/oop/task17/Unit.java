package kurs2.oop.task17;

import java.util.ArrayList;

public class Unit {
    private  Unit unit = this;
    private String symbol;
    private int steps;
    private int attack;
    private ArrayList<GroveType> allowedGrove;
    private ArrayList<Direction> allowedDirection;
    private Node currentNode;
    private UnitType unitType;

    public Unit(Node currentNode) {
        this.currentNode = currentNode;
    }

    public int getSteps() {
        return steps;
    }

    public void setUnitType(UnitType unitType) { this.unitType = unitType; }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setAllowedGrove(ArrayList<GroveType> allowedGrove) {
        this.allowedGrove = allowedGrove;
    }

    public void setAllowedDirection(ArrayList<Direction> allowedDirection) {
        this.allowedDirection = allowedDirection;
    }

    public void setCurrentNode(Node currentNode) {
        this.currentNode = currentNode;
    }

    public int getAttack() {
        return attack;
    }

    public UnitType getUnitType() {
        return unitType;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public ArrayList<GroveType> getAllowedGrove() {
        return allowedGrove;
    }

    public ArrayList<Direction> getAllowedDirection() {
        return allowedDirection;
    }

    public Node getNode() {
        return currentNode;
    }

    public Unit getUnit() {
        return unit;
    }
}
