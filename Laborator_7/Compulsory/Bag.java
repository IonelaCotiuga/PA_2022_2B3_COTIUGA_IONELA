package lab7;

import java.util.*;
import java.util.stream.Collectors;

public class Bag {
    private final HashMap<Integer, Tile > letters = new HashMap<>();

    public Bag() {
        int key = 0;
        for (char c = 'a'; c < 'z'; c++) {
            Random r = new Random();
            int nrPoints = r.nextInt(10-1) + 1;

            letters.put(key++, new Tile(c, nrPoints));
            for(int nrTiles = 0; nrTiles <10 ; nrTiles++){
                letters.put(key++, new Tile(c, nrPoints));
            }
        }
    }


    public synchronized List<Tile> extractTiles(int howMany) {
        List<Tile> extracted = new ArrayList<>(howMany);

        for (int i = 0; i < howMany; i++) {
            if (letters.isEmpty()) {
                break;
            }

            List<Integer> indexes = new ArrayList<>(letters.keySet());
            int minIndex = 0;
            int maxIndex = indexes.size() - 1;
            Random r = new Random();
            Integer indexLetter = indexes.get(r.nextInt(maxIndex-minIndex) + minIndex);


            Tile tile = letters.get(indexLetter);
            extracted.add(new Tile(tile.getLetter(), tile.getPoints()));
            letters.remove(indexLetter);
        }

        return extracted;
    }

    @Override
    public String toString() {
        return "Bag{" +
                "letters=" + letters +
                '}';
    }
}
