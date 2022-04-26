package lab7;

import java.util.*;

public class Bag {
    private final HashMap<Integer, Tile > letters = new HashMap<>();

    public HashMap<Integer, Tile> getLetters() {
        return letters;
    }

    public Bag() {
        int key = 0;

        for(int nrTiles = 0; nrTiles < 1; nrTiles++){
            letters.put(key++, new Tile('j', 8));
            letters.put(key++, new Tile('k', 5));
            letters.put(key++, new Tile('q', 10));
            letters.put(key++, new Tile('x', 8));
            letters.put(key++, new Tile('z', 10));
        }

        // B,C,F,H,M,P,V,W,Y
        for(int nrTiles = 0; nrTiles < 2; nrTiles++){
            letters.put(key++, new Tile('b', 3));
            letters.put(key++, new Tile('c', 3));
            letters.put(key++, new Tile('f', 4));
            letters.put(key++, new Tile('h', 4));
            letters.put(key++, new Tile('m', 3));
            letters.put(key++, new Tile('p', 3));
            letters.put(key++, new Tile('v', 4));
            letters.put(key++, new Tile('w', 4));
            letters.put(key++, new Tile('y', 4));
        }

        for(int nrTiles = 0; nrTiles < 3; nrTiles++){
            letters.put(key++, new Tile('g', 2));
        }

        for(int nrTiles = 0; nrTiles < 4; nrTiles++){
            letters.put(key++, new Tile('d', 2));
            letters.put(key++, new Tile('l', 1));
            letters.put(key++, new Tile('s', 1));
            letters.put(key++, new Tile('u', 1));
        }

        for(int nrTiles = 0; nrTiles < 6; nrTiles++){
            letters.put(key++, new Tile('n', 1));
            letters.put(key++, new Tile('r', 1));
            letters.put(key++, new Tile('t', 1));
        }

        for(int nrTiles = 0; nrTiles < 8; nrTiles++){
            letters.put(key++, new Tile('o', 1));
        }

        // A,I
        for(int nrTiles = 0; nrTiles < 9 ; nrTiles++){
            letters.put(key++, new Tile('a', 1));
            letters.put(key++, new Tile('i', 1));
        }

        for(int nrTiles = 0; nrTiles < 12 ; nrTiles++){
            letters.put(key++, new Tile('e', 1));
        }

    }

    public synchronized List<Tile> extractTiles(int howMany) {
        List<Tile> extracted = new ArrayList<>();

        for (int i = 0; i < howMany; i++) {
            if (letters.isEmpty()) {
                break;
            }

            List<Integer> indexes = new ArrayList<>(letters.keySet());
            int minIndex = 0;
            int maxIndex = indexes.size();
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
