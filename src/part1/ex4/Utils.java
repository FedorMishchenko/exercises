package part1.ex4;

public class Utils {


    public static Utils getInstance(){
        return new Utils();
    }

    public boolean validate(Integer...source) {
        if (source == null || source.length == 0) {
            System.out.printf("%n%s%n", "Input param has no numbers");
            return false;
        }
        return true;
    }

}

