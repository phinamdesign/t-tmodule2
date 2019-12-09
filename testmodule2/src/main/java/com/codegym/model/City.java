package com.codegym.model;

import javax.persistence.*;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Long area;
    private Long population;
    private Long gdp;
    private String title;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    public City() {

    }

    public City(String name, Long area, Long population, Long gdp, String title, Country country) {
        this.name = name;
        this.area = area;
        this.population = population;
        this.gdp = gdp;
        this.title = title;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getArea() {
        return area;
    }

    public void setArea(Long area) {
        this.area = area;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public Long getGdp() {
        return gdp;
    }

    public void setGdp(Long gdp) {
        this.gdp = gdp;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
