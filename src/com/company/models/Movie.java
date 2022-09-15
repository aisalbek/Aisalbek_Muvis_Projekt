package com.company.models;

import java.util.List;

public class Movie {

    private String name;
    private int year;
    private String description;
    private Director director;
    private List<Cast> cast;

   public void printCast() {
        int counter = 1;
        for (Cast s : cast) {
            System.out.printf("%s)   Fullname: %s\n", counter, s.getFullName());
            System.out.println("     Role: " + s.getRole());
            counter++;
        }
    }

    public List<Cast> getCast() {
        return cast;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getDescription() {
        return description;
    }

    public Director getDirector() {
        return director;
    }

    @Override
    public String toString() {
        return  "\n|_|-|_|-|_|-|_||_|-|_|-|_|-|_||_|-|_|-|_|-|_|-|_|-|_|-|_||_|-|_|-|_|-|_|" +
                "\n     Movies " +
                "\n name : " + name +
                "\n year : " + year +
                "\n description : " + description +
                "\n director : " + director +
                "\n cast : " + cast ;
    }
}
