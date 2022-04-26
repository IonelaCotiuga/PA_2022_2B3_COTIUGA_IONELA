package lab7;

import java.util.ArrayList;
import java.util.Collection;

public class Board {
    int scorePlayer1 = 0;
    int scorePlayer2 = 0;
    int scorePlayer3 = 0;
    private final Collection<String> words = new ArrayList<>();

    public int getScorePlayer1() {
        return scorePlayer1;
    }

    public int getScorePlayer2() {
        return scorePlayer2;
    }

    public int getScorePlayer3() {
        return scorePlayer3;
    }

    public final void addWord(Player player, String word, int score) {
        words.add(word);
        System.out.println(player.getName() + ": " + word + ", score = " + score);
    }

    public void addScoreForEachPlayer(Player player, int score){
        switch (player.getName()){
            case("Player 1"):
                scorePlayer1 += score;
                break;
            case ("Player 2"):
                scorePlayer2 += score;
                break;
            case ("Player 3"):
                scorePlayer3 += score;
                break;
            default:
                System.out.println("Eroare! nu ar trebui sa ajungi aici.. sau poate exista mai multi jucatori si nu i.am adaugat o_0");

        }
    }

    @Override
    public String toString() {
        return words.toString();
    }
}