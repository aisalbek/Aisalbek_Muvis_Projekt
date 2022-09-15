package com.company.services.impl;

import com.company.JsonIO;
import com.company.models.Director;
import com.company.models.Movie;
import com.company.services.SortAble;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class SortAbleImpl implements SortAble  {

static Scanner scanner=new Scanner(System.in);

    @Override
    public void printAllMovies() {
        List<Movie>movies= JsonIO.getMovies();
        System.out.println(movies);

    }
    @Override
    public void findMovie() {
        System.out.println("поиск название филма : ");
        String sk =scanner.nextLine();
        List<Movie>movies= JsonIO.getMovies();
        int counter =0;
        if (!sk.equals(":")) {
            for (Movie i : movies) {
                if (i.getName().toUpperCase(Locale.ROOT).contains(sk.toUpperCase())) {
                    System.out.println(i);
                } else {
                    counter++;
                }
            }
            if (counter == movies.size()) System.out.println("филим не найден ! ");
        }else {
            System.out.println("филим не найден !");
        }
    }
    @Override
    public void sortByYear() {
        List<Movie>movies= JsonIO.getMovies();
        System.out.println("Фильм : (1) с старого  (2) нового");
        String sk=scanner.nextLine();
        String a1="1";String a2="2";
            if (sk.length()>0){
                if (a1.equals(sk)){
                    Comparator<Movie>movieComparator=new Comparator<Movie>() {
                        @Override
                        public int compare(Movie o1, Movie o2) {
                            return o1.getYear()-o2.getYear();
                        }
                    };
                    movies.sort(movieComparator);

                    for (Movie m: movies) {
                        System.out.println(m);
                    }
                }else if (a2.equals(sk)) {
                    Comparator<Movie>movieComparator=new Comparator<Movie>() {
                        @Override
                        public int compare(Movie o1, Movie o2) {
                            return o2.getYear()-o1.getYear();
                        }
                    };
                    movies.sort(movieComparator);

                    for (Movie m: movies) {
                        System.out.println(m);
                    }
                }else{
                    System.out.println("нет токого кнопка!");
                }
            }

    }

    @Override
    public void sortByName() {
        List<Movie>movies= JsonIO.getMovies();
        System.out.println("Фильм : (1) с   A...  (2) c ...Z");
        String sk=scanner.nextLine();
        String a1="1";String a2="2";
        if (sk.length()>0){
            if (a1.equals(sk)){
                Comparator<Movie>movieComparator=new Comparator<Movie>() {
                    @Override
                    public int compare(Movie o1, Movie o2) {
                        return o1.getName().compareTo(o2.getName());
                    }
                };
                movies.sort(movieComparator);

                for (Movie m: movies) {
                    System.out.println(m);
                }
            }else if (a2.equals(sk)) {
                Comparator<Movie>movieComparator=new Comparator<Movie>() {
                    @Override
                    public int compare(Movie o1, Movie o2) {
                        return o2.getName().compareTo(o1.getName());
                    }
                };
                movies.sort(movieComparator);

                for (Movie m: movies) {
                    System.out.println(m);
                }
            }else
                System.out.println("нет токого кнопка!");
        }

    }

    @Override
    public void sortByDirector() {
        List<Movie>movies= JsonIO.getMovies();
        System.out.println("Фильм : (1) с   A...  (2) c ...Z");
        String sk=scanner.nextLine();
        String a1="1";String a2="2";
        if (sk.length()>0){
            if (a1.equals(sk)){
                Comparator<Movie>movieComparator=new Comparator<Movie>() {
                    @Override
                    public int compare(Movie o1, Movie o2) {
                        return o1.getDirector().getFullName().compareTo(o2.getDirector().getFullName());
                    }
                };
                movies.sort(movieComparator);

                for (Movie m: movies) {
                    System.out.println(m);
                }
            }else if (a2.equals(sk)) {
                Comparator<Movie>movieComparator=new Comparator<Movie>() {
                    @Override
                    public int compare(Movie o1, Movie o2) {
                        return o2.getDirector().getFullName().compareTo(o1.getDirector().getFullName());
                    }
                };
                movies.sort(movieComparator);

                for (Movie m: movies) {
                    System.out.println(m);
                }
            }else
                System.out.println("нет токого кнопка!");
        }

    }


    }

