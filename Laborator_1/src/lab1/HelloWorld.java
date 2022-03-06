package lab1;
import java.util.Random;
import java.util.Arrays;
import java.util.*;

public class HelloWorld {
    public static void main(String[] args) {
        String[] words;
        HelloWorld lab1 = new HelloWorld();
        lab1.compulsory();
        words = lab1.homework(args);
        ab1.bonus(words);

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
    
     public String getRandomWord(String setOfCharacters, int p){
        Random random = new Random();

        int randomInt;  // a certain number is generated between 0 and the length of the character set
        char randomChar = 0;
        String newWord = "";

        for (int i = 0; i < p; i++) {  // we use that number as an index at our set of characters to generate a random char
            randomInt = random.nextInt(setOfCharacters.length());
            randomChar = setOfCharacters.charAt(randomInt);
            newWord += randomChar;
        }
        return newWord;
    }

    public boolean commonCharacter(String[] words, int indexWord1, int indexWord2, int lengthOfAWord ){
        for(int i = 0; i < lengthOfAWord; i++){
            for(int j = 0; j < lengthOfAWord; j++)
                if(words[indexWord1].charAt(i) == words[indexWord2].charAt(j)) // abx cxa
                    return true;
        }
        return false;
    }

    public boolean argumentsAreValid(String args[]){
        if(args.length < 3) {
            return false;
        }

        try{
            Integer.parseInt(args[0]); // the first two arguments should be integers
            Integer.parseInt(args[1]);
        }
        catch(Exception e){
            return false;
        }

        for (int i = 2; i < args.length; i++) { // the values from the command line should be all letters except n and p
            if(!Character.isLetter(args[i].charAt(0))){
                return false;
            }
        }
        return true;
    }

    String[] homework(String[] args){
        long startTime = System.nanoTime();

        if(!argumentsAreValid(args)){
            System.out.println("Something went wrong.");
            System.exit(0);
        }

        int n;
        int p;
        n = Integer.parseInt(args[0]);
        p = Integer.parseInt(args[1]);

        StringBuilder setOfCharacters = new StringBuilder();  // the character set is built
        for (int i = 2; i < args.length; i++) {
            setOfCharacters.append(args[i]);
        }

        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = getRandomWord(setOfCharacters.toString(), p); // the words array with random words is built
        }

        // print the Words array
        System.out.print("Words array : ");
        for (String word : words) {
            System.out.print(word + " ");
        }

        System.out.println();

        boolean[][] adjacencyRelation = new boolean[n][n];
        HashMap<String, String[]> map = new HashMap<>();

        // the word vector is traversed and both the Boolean matrix
        // and the vector with the neighbors of each word are constructed

        for (int i = 0; i < n; i++) {
            String[] neigh = new String[n]; // a new String array is formed for each word to store it's neighbors
            int cIndex = 0;

            for (int j = 0; j < n; j++)
                if(commonCharacter(words, i, j, p)){
                    adjacencyRelation[i][j] = true; // se completeaza matricea booleana
                    neigh[cIndex++] = words[j];     // se construieste array ul de vecini
                }
            map.put(words[i],neigh);
        }

        for (String key: map.keySet()){
            System.out.println();
            System.out.print("The neighbors of the word " + key + " are: ");
            for(String s : map.get(key)) {
                if(s != null)
                    System.out.print(s + " ");
            }
        }

        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.println();
        System.out.println("Execution time in nanoseconds: " + timeElapsed);

        return words;

        //  0  1  2
        //  aa bx ba
        // 0  aa 1  0  1
        // 1  bx 0  1  1
        // 2  ba 1  1  1
    }

        /* First, we sort each element(string) from words array, then we sort the words array.
           let k = 1 be the first word from the subset W1,W2,...,Wk
           The words being sorted it will be easier to check if 2 consecutive words have a letter in common */

    void bonus(String[] words){
        int k = 1;

        System.out.println();
        for (int i = 0; i < words.length; i++) {
            char tempArray[] = words[i].toCharArray();
            Arrays.sort(tempArray);
            words[i] = new String(tempArray);
        }
        Arrays.sort(words);

        for(String str : words){
            System.out.println(str);
        }

        int p = words[0].length();
        int j = 0;
        for (int i = 1; i < words.length; i++) {
            if(commonCharacter(words, j, i, p)) {
                k++;
                j = i; // j = adresa ultimului cuvant din sirul de cuvinte "neigh"
            }
        }
        if(k >= 3) {
            System.out.println("Exists a subset of "+ k + " distinct words");
        }
        else System.out.println("Doesn't exists a subset of distinct words > 3 ");

    }

    }


