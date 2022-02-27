package lab1;
import java.util.Random;
import java.util.Arrays;
import java.util.*;

public class HelloWorld {
    public static void main(String[] args) {
        String[] words;
        HelloWorld lab1 = new HelloWorld();
        lab1.compulsory();
        //words = lab1.homework(args);
        //lab1.bonus(words);

    }

    void compulsory(){
        System.out.println("Hello world");

        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};

        int n = (int) (Math.random() * 1_000_000);
        int result = (n*3 + Integer.parseInt("10101",2) + Integer.parseInt("FF",16)) * 6;

        System.out.println(n);

        int sum = 0;
        while(result > 0 || sum > 9) {
            if (result == 0) {
                result = sum;
                sum = 0;
            }
            sum += result % 10;
            result /= 10;
        }
        result = sum;

        System.out.println("Willy-nilly, this semester I will learn " + languages[result]);
    }

    }


