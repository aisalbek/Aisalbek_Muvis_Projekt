package com.company.services.impl;

import com.company.JsonIO;
import com.company.models.Cast;
import com.company.models.Movie;
import com.company.services.FindAble;
import java.util.*;
public class FindAbleImpl implements FindAble {

  public static   Scanner in = new Scanner(System.in);
    @Override
    public void findMoviesByActor() {
        System.out.println("поиск по имени актера : ");
        String sk = in.nextLine();
        List<Movie> movies = JsonIO.getMovies();
        List<Movie> actorMovies = new ArrayList<>();
        for (Movie i : movies) {
            for (Cast j : i.getCast()) {
                if (j.getFullName().toUpperCase(Locale.ROOT).contains(sk.toUpperCase())) {
                    actorMovies.add(i);
                }
            }
        }
        Movie movie = new Movie();
        for (Movie i : actorMovies) {
            System.out.println("Name: " + i.getName());
            System.out.println("Year: " + i.getYear());
            System.out.println("Description: " + i.getDescription());
            movie.printCast();
        }
        System.out.println("-----------------------------");
    }


    @Override
    public void findMoviesByDirector() {
        System.out.println("поиск по имени Директора : ");
        String sk = in.nextLine();

        List<Movie> movies = JsonIO.getMovies();
        int counter = 0;
        for (Movie i : movies) {
            if (i.getDirector().getFullName().toUpperCase().contains(sk.toUpperCase())) {
                System.out.println("\n" + i.getDirector());
                System.out.println(i);

            } else counter++;
            if (counter == movies.size()) System.out.println("не найден такого имени Директора ! ");
        }


    }

    @Override
    public void findMoviesByYear() {
        System.out.println("поиск по года выпуска : ");
        try {
            int sk = in.nextInt();
            int conter = 0;
            List<Movie> movies = JsonIO.getMovies();
            for (Movie i : movies) {
                if (i.getYear()==sk) {
                    System.out.println(i);
                } else conter++;
            }
            if (conter == movies.size())  System.out.println("не найден !");
        } catch (InputMismatchException e) {
            System.out.println("кечирип кой чырагым тура жаз!");
            in.nextLine();
        }



    }

    @Override
    public void findMoviesAndRoleByActor() {
        System.out.println("поиск по имени роли : ");
        String sk = in.nextLine();
        List<Movie> movies = JsonIO.getMovies();
        List<Movie> actorMovies = new ArrayList<>();

        for (Movie i : movies) {
            for (Cast j : i.getCast()) {
                if (j.getRole().toUpperCase(Locale.ROOT).contains(sk.toUpperCase())) {
                    actorMovies.add(i);
                }
            }
        }
        for (Movie i : actorMovies) {
            System.out.println(sk);
            System.out.println("---------------------------------");
            System.out.println("Name: " + i.getName());
            System.out.println("Year: " + i.getYear());
            System.out.println("роль: " + i.getCast());
            System.out.println("--------------------------");
        }

    }

    @Override
    public void showActorRoles() {

        List<Movie> movieList = JsonIO.getMovies();
        TreeSet<Cast> treeSetActors = new TreeSet<>();
        for (Movie i : movieList) {
            treeSetActors.addAll(i.getCast());
        }
        System.out.print("сортировка 1 .(с начало алфавита)| 2 .(c конса алфавита): ");
        String choose = in.nextLine();
        if (choose.equals("1")) {
            for (Cast cast : treeSetActors) {
                System.out.println("имя актера : " + cast.getFullName());
                for (Movie movie : movieList) {
                    for (int k = 0; k < movie.getCast().size(); k++) {
                        if (cast.getFullName().equals(movie.getCast().get(k).getFullName())) {
                            System.out.println("название филма: " + movie.getName());
                            System.out.print("роль     : ");
                            System.out.println("-= " + movie.getCast().get(k).getRole() + "  ");
                        }
                    }
                }
                System.out.println("=====================================");
            }
        }
        if (choose.equals("2")) {
            TreeSet<Cast> treeSetActorDes = (TreeSet<Cast>) treeSetActors.descendingSet();
            for (Cast cast : treeSetActorDes) {
                System.out.println("имя актера : " + cast.getFullName());
                for (Movie movie : movieList) {
                    for (int k = 0; k < movie.getCast().size(); k++) {
                        if (cast.getFullName().equals(movie.getCast().get(k).getFullName())) {
                            System.out.println("название филма  : " + movie.getName());
                            System.out.print("роль   : ");
                            System.out.println("-= " + movie.getCast().get(k).getRole() + "  ");
                        }
                    }
                }
                System.out.println("===================================");
            }
        }
    }
}





