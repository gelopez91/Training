package com.sdc.controller.FrontEntities;


public class ActorF {

    private String firstName;

    private String lastName;

    private int movie_id;

    public ActorF(){

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

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }
}

