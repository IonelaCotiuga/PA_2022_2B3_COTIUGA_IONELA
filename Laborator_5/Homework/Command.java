package homework;

import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;
import java.io.IOException;

public abstract class Command {
    void execute(Catalog catalog, String path) throws IOException, InvalidCatalogException, TikaException, SAXException {};
    void execute(Catalog catalog, Item item) throws IOException, InvalidCatalogException{};
    void execute(Catalog catalog, String path, Item item) throws IOException, InvalidCatalogException{};

}
