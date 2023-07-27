package model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "name", "price", "genre"})
public class Film {
    private int id;
    private String name;
    private int price;
    private Genre genre;
    @JsonCreator
    public Film(@JsonProperty("id") int id,
                @JsonProperty("name") String name,
                @JsonProperty("price") int price,
                @JsonProperty("genre") Genre genre) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "model.Film{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", genre=" + genre.getName() +
                '}';
    }
}