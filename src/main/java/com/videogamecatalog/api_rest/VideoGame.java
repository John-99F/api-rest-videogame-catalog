package com.videogamecatalog.api_rest;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "VideoGame")
public class VideoGame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private double price;
    private String gender;

    @Override
    public String toString() {
        return "{\n" +
                "\tid=" + id +",\n"+
                "\ttitle='" + title + '\'' +",\n"+
                "\tdescription='" + description + '\'' +",\n"+
                "\tprice=" + price +",\n"+
                "\tgender='" + gender + '\'' +"\n"+
                "}\n";
    }
}
