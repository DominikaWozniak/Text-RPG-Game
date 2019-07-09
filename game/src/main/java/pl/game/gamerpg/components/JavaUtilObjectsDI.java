package pl.game.gamerpg.components;

import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.Scanner;

@Component
public class JavaUtilObjectsDI {

    public Scanner scanner(){
        return new Scanner(System.in);
    }

    public Random random(){
        return new Random();
    }
}
