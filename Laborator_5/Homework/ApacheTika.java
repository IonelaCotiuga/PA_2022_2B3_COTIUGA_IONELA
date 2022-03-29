package homework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

public class ApacheTika extends Command{

    @Override
    void execute(Catalog catalog, String path) throws IOException, InvalidCatalogException, TikaException, SAXException {

        //Assume that boy.jpg is in your current directory
        File file = new File("C:/Users/cotiu/IdeaProjects/PA_Lab/Laborator_5/catalog.json");

        //Parser method parameters
        Parser parser = new AutoDetectParser();
        BodyContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        FileInputStream inputstream = new FileInputStream(file);
        ParseContext context = new ParseContext();

        parser.parse(inputstream, handler, metadata, context);
        info(handler);

        //getting the list of all meta data elements
        String[] metadataNames = metadata.names();

        for(String name : metadataNames) {
            System.out.println(name + ": " + metadata.get(name));
        }
    }

    public void info(BodyContentHandler handler){
        System.out.println(handler.toString());
    }
}
