package collections.exersices.round;

public class Demo {
    private Round round;
    public static Round getRound(){
        return new Round();
    }
    public static Round getRound(double x, double y, double r){
        return new Round(x, y, r);
    }

    public static void x(Round r1, Round r2){
        double tmp = Math.sqrt((r2.getX() - r1.getX()) * (r2.getX() - r1.getX())
                             + (r2.getY() - r2.getY()) * (r2.getY() - r2.getY()));
        if(tmp < r1.getR() + r2.getR()) System.out.println("negative");
        if(tmp == r1.getR() + r2.getR()) System.out.println("touch");
        if(tmp > r1.getR() + r2.getR()) System.out.println("into");
    }

    public static void main(String[] args) {

    }
}
