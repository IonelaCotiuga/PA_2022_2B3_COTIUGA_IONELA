package homework;

import java.io.IOException;

public class ListCommand extends Command{
    @Override
    void execute(Catalog catalog, String path) throws IOException, InvalidCatalogException {
        for (Item item : catalog.getItems()) {
            System.out.println(item + "\n");
        }
    }
}
