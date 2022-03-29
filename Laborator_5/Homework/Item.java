package homework;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.io.Serializable;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "subtype"
)
@JsonSubTypes({@JsonSubTypes.Type(
        value = Book.class,
        name = "book"
),})

public abstract class Item implements Serializable {
    public String id;
    public String title;
    public String location;
    public int year;
    public String author;
    public String type;


    public Item(String identifier, String title, String location, String type) {
        this.id = identifier;
        this.title = title;
        this.location = location;
        this.type = type;
    }

    public Item(){}

    public String getId() {
        return id;
    }

    public void setId(String identifier) {
        this.id = identifier;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", location='" + location + '\'' +
                ", year=" + year +
                ", author='" + author + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

}
