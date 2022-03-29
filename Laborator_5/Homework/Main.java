package homework;

import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, InvalidCatalogException, TikaException, SAXException {
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();
    }

    private void testCreateSave() throws IOException, InvalidCatalogException, TikaException, SAXException {
        List<Item> list=new ArrayList<>();
        Item item1 = new Book("knuth67", "The Art of Computer Programming", "d:/books/programming/tacp.ps", "book");
        Item item2 = new Book("java17", "The Java Language Specification", "https://docs.oracle.com/javase/specs/jls/se17/html/index.html","book");
        Item item3 = new Book("id3", "Titlu3", "adresa", "book");

        item1.setYear(1987);
        item1.setAuthor("Donald E. Knuth");
        item1.setType("book");

        item2.setYear(2021);
        item2.setAuthor("James Gosling & others");
        item2.setType("book");

        list.add(item1);
        list.add(item2);

        Catalog catalog=new Catalog("CatalogulMeu",  list);
        String path = "C:/Users/cotiu/IdeaProjects/PA_Lab/Laborator_5/catalog.json";

        new Add().execute(catalog, item3);
        new ListCommand().execute(catalog,path );

        new SaveCommand().execute(catalog, path);
        new Report().execute(catalog, path);

        new ApacheTika().execute(catalog, path);
    }

    private void testLoadView() throws InvalidCatalogException, IOException {
        Catalog catalog = new Catalog();
        String path = "C:/Users/cotiu/IdeaProjects/PA_Lab/Laborator_5/catalog.json";
        new LoadCommand().execute(catalog, path);
        new ViewCommand().execute(catalog,path, catalog.findById("id3hjb"));

    }
    // C:\Users\cotiu\IdeaProjects\PA_Lab\Laborator_5\out\artifacts\Laborator_5_jar> java -jar Laborator_5.jar

}
