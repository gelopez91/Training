package com.sdc.controller.BackEntities;


import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="actor")
public class ActorB {

    @Id
    @Column(name="actor_id")
    @GeneratedValue(strategy=GenerationType.AUTO, generator="actor_seq")
    @SequenceGenerator(name="actor_seq", sequenceName="actor_actor_id_seq")
    private Long id;

    @Column(name="firstName")
    private String firstName;

    @Column(name="lastName")
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    public ActorB(){

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

    @JsonIgnore
    public Movie getMovie(){
        return movie;
    }

    @JsonIgnore
    public void setMovie(Movie newMovie){
        movie = newMovie;
    }
}

