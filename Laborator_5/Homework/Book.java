package homework;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("book")
public class Book extends Item {

    @Override
    public String getId() {
        return super.getId();
    }

    @Override
    public void setId(String identifier) {
        super.setId(identifier);
    }

    @Override
    public String getTitle() {
        return super.getTitle();
    }

    @Override
    public void setTitle(String title) {
        super.setTitle(title);
    }

    @Override
    public String getLocation() {
        return super.getLocation();
    }

    @Override
    public void setLocation(String location) {
        super.setLocation(location);
    }

    @Override
    public int getYear() {
        return super.getYear();
    }

    @Override
    public void setYear(int year) {
        super.setYear(year);
    }

    @Override
    public String getAuthor() {
        return super.getAuthor();
    }

    @Override
    public void setAuthor(String author) {
        super.setAuthor(author);
    }

    @Override
    public String getType() {
        return super.getType();
    }

    @Override
    public void setType(String type) {
        super.setType(type);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public Book(String identifier, String title, String location, String type) {
        super(identifier, title, location, type);
    }

    public Book(){}

}
