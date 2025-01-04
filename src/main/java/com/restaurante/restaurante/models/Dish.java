package com.restaurante.restaurante.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "dish")
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    @JsonIgnore
    private Menu menu;
    private String dishType;


    public Dish(Long id, String name, Double price, String dishType) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.dishType = dishType;
    }

    public Dish() {
    }
}