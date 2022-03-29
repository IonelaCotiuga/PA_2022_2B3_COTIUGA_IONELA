package homework;

import freemarker.template.*;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Report extends Command{
    @Override
    void execute(Catalog catalog, String path) throws IOException {
        Configuration cfg = new Configuration(new Version("2.3.23"));
        cfg.setDirectoryForTemplateLoading(new File("C:/Users/cotiu/IdeaProjects/PA_Lab/Laborator_5"));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        Map<String, Object> templateData = new HashMap<>();
        templateData.put("title", "Freemarker Template");
        templateData.put("message", "This is a list of the items from catalog.");
        List<Item> list = catalog.items;
        templateData.put("list", list);

        Template template = cfg.getTemplate("test.ftl");

        try {
                Writer console = new OutputStreamWriter(System.out);
                template.process(templateData, console);
                console.flush();

                Writer file = new FileWriter (new File("C:/Users/cotiu/IdeaProjects/PA_Lab/Laborator_5/items-output.html"));
                template.process(templateData, file);
                file.flush();
                file.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}



