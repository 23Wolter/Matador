package Model;

import java.util.Random;


public class Die {
    private Random generator;
    private int sides;

    // Denne constructor opretter en standart terning med 6 sider
    // ved kald til den anden constructor
    public Die() {
        this(6);
    }

    public Die(int sides) {
        this.sides = sides;
        this.generator = new Random();
    }

    public int throwDie() {
        return generator.nextInt(sides) + 1;
    }


}
