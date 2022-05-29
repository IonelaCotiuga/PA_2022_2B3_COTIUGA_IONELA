package lab12;

import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import static java.lang.System.out;

public class Main {
    public static void main(String args[]){
        String url = "Users/cotiu/IdeaProjects/PA_Lab/Laborator_1/out/production/Laborator_1/";
        String className = "lab1.HelloWorld";
        Class clazz = null;

        try {
            URL classUrl = new URL("file:///" + url);
            URL[] classUrls = {classUrl};
            URLClassLoader ucl = new URLClassLoader(classUrls);
            clazz = ucl.loadClass(className);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        if(clazz == null){
            out.println("Class not found!");
            System.exit(0);
        }

        out.println("Package: " + getPackageName(clazz) + "\n");

        out.println("Print methods: ");
        printMethods(clazz);

        out.println("Print static methods: ");
        callStaticMethods(clazz);

    }

    public static String getPackageName(Class c){
        String package_ = "";
        Package p = c.getPackage();
        if(p != null)
            package_ = p.getName();
        return package_;
    }

    public static void printMethods(Class c){
        Method[] methods = c.getMethods();

        for(int i = 0; i < methods.length; i++){
            out.print(methods[i].getReturnType() + " " + methods[i].getName() + "(");
            boolean first = true;
            for(var it : methods[i].getParameters()){
                if(first){
                    out.print(it.getType() + " " + it.getName());
                    first = false;
                }else{
                    out.print(", " + it.getType() + " " + it.getName());
                }
            }
            out.println(");\n");
        }
    }

    public static void callStaticMethods(Class c){
        Method[] methods = c.getMethods();
        for(int i = 0; i < methods.length; i++){
            if(methods[i].isAnnotationPresent(Test.class) && methods[i].getParameterCount() ==0){
                try {
                    methods[i].invoke(methods);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
