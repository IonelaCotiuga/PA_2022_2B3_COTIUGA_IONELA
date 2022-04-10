package lab7;

import java.util.List;

public class Player implements Runnable {
    private String name;
    private Game game;
    private boolean running = false;
    public Player(String name) { this.name = name; }


    private boolean submitWord() {
        List<Tile> extracted = game.getBag().extractTiles(7);
        if (extracted.isEmpty()) {
            return false;
        }

        StringBuilder wordBuilder = new StringBuilder();
        for (Tile tile : extracted) {
            wordBuilder.append(tile.getLetter());
        }

        String word = wordBuilder.toString();
        game.getBoard().addWord(this, word);

        return true;
    }


    @Override
     public void run() {
        System.out.println(this.name +  " has entered the game.");
        System.out.println(getName() + " -tiles-> " + getGame().getBag().extractTiles(7));

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
