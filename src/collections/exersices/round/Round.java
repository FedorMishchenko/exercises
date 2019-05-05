package collections.exersices.round;

import java.util.Objects;

public class Round {
    private double x;
    private double y;
    private double r;

    public Round(){
        x = 0;
        y = 0;
        r = 0;
    }

    public Round(double x, double y, double r){
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public double getX() {
        return x;
    }

    public Round setX(double x) {
        this.x = x;
        return this;
    }

    public double getY() {
        return y;
    }

    public Round setY(double y) {
        this.y = y;
        return this;
    }

    public double getR() {
        return r;
    }

    public Round setR(double r) {
        this.r = r;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Round)) return false;
        Round round = (Round) o;
        return Double.compare(round.getX(), getX()) == 0 &&
                Double.compare(round.getY(), getY()) == 0 &&
                Double.compare(round.getR(), getR()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY(), getR());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Round{");
        sb.append("x=").append(x);
        sb.append(", y=").append(y);
        sb.append(", r=").append(r);
        sb.append('}');
        return sb.toString();
    }
}
