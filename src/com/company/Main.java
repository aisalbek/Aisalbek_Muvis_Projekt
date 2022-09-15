package com.company;

import com.company.models.Movie;
import com.company.services.impl.FindAbleImpl;
import com.company.services.impl.SortAbleImpl;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        FindAbleImpl findAble = new FindAbleImpl();
        SortAbleImpl sortAble = new SortAbleImpl();
        String number = "null";
        while (!number.equals("x")) {
            try {
                commands();
                System.out.println("Выберите команду:");
                number = in.nextLine().trim();
                if (Character.isDigit(number.charAt(0))) {
                    switch (number) {
                        case "1" -> sortAble.printAllMovies();
                        case "2" -> sortAble.findMovie();
                        case "3" -> sortAble.sortByYear();
                        case "4" -> sortAble.sortByName();
                        case "5" -> sortAble.sortByDirector();
                        case "6" -> findAble.findMoviesByActor(); // поиск по имени актера
                        case "7" -> findAble.findMoviesByDirector();
                        case "8" -> findAble.findMoviesByYear();
                        case "9" -> findAble.findMoviesAndRoleByActor();
                        case "10" -> findAble.showActorRoles();
                        default -> System.out.println("вы вели не правилную кнопку");
                    }
                } else {
                    throw new RuntimeException();
                }
            } catch (Exception e) {
                System.out.println("это не кнопка!");
            }
        }
    }

    static void commands() {
        System.out.println("--------------Commands-----------------------");
        System.out.println("Press 1 to print catalog");
        System.out.println("Press 2 to Find a Movie by full or part name");
        System.out.println("Press 3 to sort by year");
        System.out.println("Press 4 to sort by name");
        System.out.println("Press 5 to sort by director");
        System.out.println("Press 6 to find movies by actor's name");
        System.out.println("Press 7 to find movies by director's name");
        System.out.println("Press 8 to find movies by year");
        System.out.println("Press 9 to List all movies and roles by actor's name");
        System.out.println("Press 10 to sorted List of all actors with his roles");
        System.out.println("---------------------------------------------");
        System.out.println("Если хотите останавить Х Продолжить выберите команду");
    }

    static String button() {

        System.out.println("Choose a command: ");
        String as = in.nextLine();

        return button();
    }
}



