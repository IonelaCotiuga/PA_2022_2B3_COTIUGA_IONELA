package lab7;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Bag bag = new Bag();
    private final Board board = new Board();
    private final MockDictionary dictionary = new MockDictionary();
    private final List<Player> players = new ArrayList<>();

    public void addPlayer(Player player) {
        players.add(player);
        player.setGame(this);
    }

    public MockDictionary getDictionary() {
        return dictionary;
    }

    public void play() {
        DaemonThread t1 = new DaemonThread("t1");
        t1.setDaemon(true);
        t1.start();

        for (Player player : players) {
            Thread thread =new Thread(player);
            thread.start();



            //Thread thread = new Thread(new Producer());
            //Thread thread1 = new Thread(Consumer());

        }

    }

    public Bag getBag() {
        return bag;
    }

    public Board getBoard() {
        return board;
    }


    public static void main(String args[]) {
        Game game = new Game();
        game.addPlayer(new Player("Player 1"));
        game.addPlayer(new Player("Player 2"));
        game.addPlayer(new Player("Player 3"));
        game.play();

    }
}