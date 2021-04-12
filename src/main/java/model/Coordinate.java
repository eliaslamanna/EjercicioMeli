package model;

import java.util.Objects;

public class Coordinate {

    private float positionX;
    private float positionY;

    public Coordinate(float posX, float posY) {
        this.positionX = posX;
        this.positionY = posY;
    }

    public Coordinate() {
        super();
    }

    public float getPositionX() {
        return positionX;
    }

    public void setPositionX(float positionX) {
        this.positionX = positionX;
    }

    public float getPositionY() {
        return positionY;
    }

    public void setPositionY(float positionY) {
        this.positionY = positionY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return Float.compare(that.positionX, positionX) == 0 && Float.compare(that.positionY, positionY) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(positionX, positionY);
    }
}
