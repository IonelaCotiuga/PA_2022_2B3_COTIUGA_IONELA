package homework;

import java.io.IOException;

public class Add extends Command{
    @Override
    void execute(Catalog catalog, Item item) throws IOException, InvalidCatalogException {
        catalog.getItems().add(item);
        catalog.setItems(catalog.getItems());
    }
}
