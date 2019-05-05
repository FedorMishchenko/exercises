package collections.builder.phone;

public class Time {
    private double urban;
    private double intercity;

    public double getUrban() {
        return urban;
    }

    public void setUrban(double urban) {
        this.urban = urban;
    }

    public double getIntercity() {
        return intercity;
    }

    public void setIntercity(double intercity) {
        this.intercity = intercity;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("urban=").append(urban);
        sb.append(", intercity=").append(intercity);
        sb.append('}');
        return sb.toString();
    }
}