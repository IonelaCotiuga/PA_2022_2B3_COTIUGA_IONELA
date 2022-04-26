package lab7;

import java.io.IOException;
import java.util.List;

public class Player implements Runnable {
    private String name;
    private Game game;
    private boolean running = false;
    public int turn = 0;
    public Player(String name) { this.name = name; }


    private boolean submitWord() throws IOException {
        List<Tile> extracted = game.getBag().extractTiles(7);
        if (extracted.isEmpty()) {
            return false;
        }

        int score = 0;
        StringBuilder wordBuilder = new StringBuilder();
        for (Tile tile : extracted) {
            wordBuilder.append(tile.getLetter());
            score += tile.getPoints();
        }

        String word = wordBuilder.toString();
            //if(game.getDictionary().isWord(word))
        game.getBoard().addWord(this, word, score);
        game.getBoard().addScoreForEachPlayer(this, score);

        return true;
    }


    @Override
    public void run() {
        turn++;

        if(turn == 1){
            System.out.println("player = " + this.getName());
           /* if(this.getName().equals("Player 1") ){
                try {
                    running = this.submitWord();
                    //this.wait();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //this.notifyAll();*/
        }

        do{
            try {
                running = this.submitWord();


            } catch (IOException e) {
                e.printStackTrace();
            }

        }while (running);

        System.out.println("score player 1 = " + game.getBoard().getScorePlayer1());
        System.out.println("score player 2 = " + game.getBoard().getScorePlayer2());
        System.out.println("score player 3 = " + game.getBoard().getScorePlayer3());

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public String getName() {
        return name;
    }
}
