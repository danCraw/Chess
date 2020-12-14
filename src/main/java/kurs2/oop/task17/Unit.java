package kurs2.oop.task17;

import java.util.ArrayList;

public class Unit {
    private Unit unit = this;
    private String symbol;
    private int steps;
    private int attack;
    private ArrayList<GroveType> allowedGrove;
    private ArrayList<Direction> allowedDirection;
    private Node currentNode;
    private UnitType unitType;

    public Unit(Node currentNode, UnitType unitType) {
        this.currentNode = currentNode;
        this.unitType = unitType;
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

    public void setCurrentNode(Node currentNode) {
        this.currentNode = currentNode;
    }

    public UnitType getUnitType() {
        return unitType;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Node getNode() {
        return currentNode;
    }

    public Unit getUnit() {
        return unit;
    }
}
