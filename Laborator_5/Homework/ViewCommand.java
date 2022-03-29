package homework;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ViewCommand extends Command{
    @Override
    void execute(Catalog catalog, String path, Item item) throws IOException, InvalidCatalogException {
        Desktop desktop = Desktop.getDesktop();
        File file=new File("C:/Users/cotiu/IdeaProjects/PA_Lab/Laborator_5/catalog.json");
        desktop.open(file);
    }
}
