package com.sdc.controller;


import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="actor")
public class Actor {

    @Id
    @Column(name="actor_id")
    @GeneratedValue(strategy=GenerationType.AUTO, generator="actor_seq")
    @SequenceGenerator(name="actor_seq", sequenceName="actor_actor_id_seq")
    private Long id;

    @Column(name="firstName")
    private String firstName;

    @Column(name="lastName")
    private String lastName;

    @ManyToOne (cascade={}, fetch=FetchType.LAZY)
    @JoinColumn(name="movie_id")
    @JsonIgnore
    private Movie movie;

    public Actor(){

    }

    public Long getId() {
        return id;
    }
    public void setId(Long newId) {
        id = newId;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String newFirstName){
        firstName = newFirstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String newLastName){
        lastName = newLastName;
    }

    public Movie getMovie(){
        return movie;
    }

    public void setMovie(Movie newMovie){
        movie = newMovie;
    }
}

