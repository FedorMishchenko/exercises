package part2.ex3.fraction;

import java.util.StringJoiner;

public class Fraction {
    private int n;
    private int m;

    public Fraction(int n, int m){
        this.n = n;
        this.m = m;
    }

    @Override
    public String toString(){
        return new StringJoiner("\n")
                .add(String.valueOf(n))
                .add("-")
                .add(String.valueOf(m))
                .toString();
    }
}
