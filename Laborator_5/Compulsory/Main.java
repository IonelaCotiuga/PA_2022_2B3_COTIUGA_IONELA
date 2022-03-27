package lab5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException, InvalidCatalogException {
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();
    }

    private void testCreateSave() throws IOException {
        List<Item> list=new ArrayList<>();
        Item item1=new Book("knuth67", "The Art of Computer Programming", "d:/books/programming/tacp.ps", "book");
        Item item2=new Book("java17", "The Java Language Specification", "https://docs.oracle.com/javase/specs/jls/se17/html/index.html","book");

        item1.setYear(1987);
        item1.setAuthor("Donald E. Knuth");
        item1.setType("book");

        item2.setYear(2021);
        item2.setAuthor("James Gosling & others");

        list.add(item1);
        list.add(item2);

        Catalog catalog = new Catalog("MyRefs", list);
        CatalogUtil.save(catalog, "C:/Users/cotiu/IdeaProjects/PA_Lab/Laborator_5/catalog.json");

    }

    private void testLoadView() throws InvalidCatalogException, IOException {
        Catalog catalog = CatalogUtil.load("C:/Users/cotiu/IdeaProjects/PA_Lab/Laborator_5/catalog.json");
        CatalogUtil.view(catalog.findById("knuth67"));
    }


}
