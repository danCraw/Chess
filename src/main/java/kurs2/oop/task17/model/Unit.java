package kurs2.oop.task17.model;

public class Unit {
    private Unit unit = this;
    private Node currentNode;
    private final UnitType unitType;

    public Unit(Node currentNode, UnitType unitType) {
        this.currentNode = currentNode;
        this.unitType = unitType;
    }

    public void setCurrentNode(Node currentNode) {
        this.currentNode = currentNode;
    }

    public UnitType getUnitType() {
        return unitType;
    }

    public Node getNode() {
        return currentNode;
    }
}
