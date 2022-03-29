package homework;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class SaveCommand extends Command {
    @Override
    void execute(Catalog catalog, String path) throws IOException, InvalidCatalogException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(path), catalog);
    }

}
