package com.sdc.controller.BackEntities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="movie")
public class Movie {

    @Id
    @Column(name="movie_id")
    @GeneratedValue(strategy=GenerationType.AUTO, generator="movie_seq")
    @SequenceGenerator(name="movie_seq", sequenceName="movie_movie_id_seq")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="direction")
    private String direction;

    @Column(name="year")
    private String year;

    @Column(name="language")
    private String language;

    @Column(name="duration")
    private String duration;

    @OneToMany (cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy = "movie")
    private List<ActorB> actors;

    public Movie(){

    }

    public Long getId() {
        return id;
    }
    public void setId(Long newId) {
       id = newId;
    }

    public String getName(){
        return name;
    }

    public void setName(String newName){
        name = newName;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String newDescription){
        description = newDescription;
    }

    public String getDirection(){
        return direction;
    }

    public void setDirection(String newDirection){
        direction = newDirection;
    }

    public String getYear(){
        return year;
    }

    public void setYear(String newYear){
        year = newYear;
    }

    public String getLanguage(){
        return language;
    }

    public void setLanguage(String newLanguage){
        language = newLanguage;
    }

    public String getDuration(){
        return duration;
    }

    public void setDuration(String newDuration){
        duration = newDuration;
    }

    public List<ActorB> getActors(){
        return actors;
    }

    public void addActor(ActorB actor) {
        actors.add(actor);
    }
}

