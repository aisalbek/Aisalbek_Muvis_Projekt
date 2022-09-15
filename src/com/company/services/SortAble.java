package com.company.services;

import com.company.models.Director;
import com.company.models.Movie;

public interface SortAble{

    void printAllMovies();

    void findMovie();

    void sortByYear();

    void sortByName();

    void sortByDirector();
}
