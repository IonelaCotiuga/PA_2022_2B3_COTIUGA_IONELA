package lab5;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;


public class CatalogUtil implements Serializable {

    public static void save(Catalog catalog, String path) throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(path), catalog);
    }

    public static Catalog load(String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(path), Catalog.class);
    }

    public static void view(Item item) throws IOException {
        Desktop desktop = Desktop.getDesktop();
        File file = new File("C:/Users/cotiu/IdeaProjects/PA_Lab/Laborator_5/catalog.json");
        desktop.open(file);
    }



}
