package com.intiformation.app;

import com.intiformation.app.dao.DaoFactory;
import com.intiformation.app.dao.PlaceDao;
import com.intiformation.app.dao.TripDao;
import com.intiformation.app.dao.jdbc.JdbcPlaceDao;
import com.intiformation.app.model.Place;
import com.intiformation.app.model.Trip;
import com.intiformation.app.util.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Launcher {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        Connection myConnection = ConnectionManager.getConnection();
        int choix = 0;
        do {
            System.out.println("Welcome abord !");
            System.out.println("1 - Add a place");
            System.out.println("2 - Find a place");
            System.out.println("3 - Edit a place");
            System.out.println("4 - Remove a place");
            System.out.println("5 - Add a trip");
            System.out.println("6 - Find a trip");
            System.out.println("7 - Remoove a trip");
            System.out.println("8 - Quit");
            choix = scan.nextInt();
            switch (choix) {
                case 1:
                    // add a place
                    addaPlace();
                    break;
                case 2:
                    //Find a place
                    findaPlace();
                    break;
                case 3:
                    //Edit a place
                    break;
                case 4:
                    //Remove a place
                    break;
                case 5:
                    //Add a trip
                    addaTrip();
                    break;

                case 6:
                    //Find a trip
                    findaTrip();
                    break;

                case 7:
                    //Remoove a trip
                    break;
                case 8:
                    System.out.println("Goodby !");
                    // fermeture de la connexion
                    try {
                        myConnection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();

                    }
                    break;
                default:
                    System.out.println("I did not understand your choice !");
                    break;
            }
        }
        while (choix != 8);


    }


    private static void addaTrip() {
        System.out.println("Vous désirez ajouter un voyage");
        TripDao tripDao = DaoFactory.GetTripDao();
        PlaceDao placeDao = DaoFactory.GetPlaceDao();
        ArrayList<Place> places = placeDao.findAllPlace();
        for (Place p : places) {
            System.out.println(p.toString());
        }
        System.out.println("Choice id of depature");
        Long iddepature = scan.nextLong();
        System.out.println("Choice id of arrival");
        Long idarrival = scan.nextLong();

        System.out.println("Price of the trip ?");
        float price = scan.nextFloat();

        Trip newTrip = new Trip();
        newTrip.setDeparture(iddepature);
        newTrip.setArrival(idarrival);
        newTrip.setPrice(price);

        try {
            tripDao.createTrip(newTrip);
            System.out.println("Le voyage à bien été ajouté");
        } catch (Exception e) {
            System.out.println("erreur lors de la création du voyage.");
            e.printStackTrace();
        }
    }

    // add new Place
    private static void addaPlace() {
        System.out.println("Name of place to add :");
        String name = scan.next();
        Place place = new Place();
        place.setName(name);
        PlaceDao placeDao = DaoFactory.GetPlaceDao();
        placeDao.createPlace(place);
        System.out.println("New place added.");

    }
    // find a place

    //6
    private static void findaPlace() {
        Place place = new Place();
        System.out.println("Find a place 1/ by name and 2/ by ID :");
        int choix = scan.nextInt();

        try {
            place = findPlacebyName();
            if (place != null) {
                System.out.println("place find.");
                System.out.println(place.toString());
            } else {
                System.out.println("place nt find.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Place findPlacebyName() {
        System.out.println("Name of place to find :");
       //String name = scan.nextLine();
        String name ="Rome";
        //System.out.println("Name of place to id :");
        //long id = scan.nextLong();
        Place place = new Place();
        try {
            PlaceDao placeDao = DaoFactory.GetPlaceDao();
            //place = placeDao.findPlaceById(id);
            place = ((JdbcPlaceDao) placeDao).findPlaceByName(name);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return place;
    }

    private static Place findPlacebyId() {
        System.out.println("Id of place to find :");

        System.out.println("Name of place to id :");
        long id = scan.nextLong();
        Place place = new Place();
        try {
            PlaceDao placeDao = DaoFactory.GetPlaceDao();
            place = placeDao.findPlaceById(id);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return place;
    }

    private static void findaTrip() {
        TripDao tripDao = DaoFactory.GetTripDao();
        PlaceDao placeDao = DaoFactory.GetPlaceDao();
        ArrayList<Place> places = placeDao.findAllPlace();
        for (Place p : places) {
            System.out.println(p.toString());
        }
        System.out.println("Choice id of depature to find");
        Long iddepature = scan.nextLong();
        System.out.println("Choice id of arrival to find");
        Long idarrival = scan.nextLong();


        Boolean trouveplace = false;
        Boolean boucle = false;
        //TODO rechercher place
        Place place = new Place();
        if (place != null)//TODO place non vide
        {
            trouveplace = true;
            ;
        } else {
            System.out.println("place non trouvée.");
        }
        if (trouveplace == true) {
            System.out.println("Name of place of arival to find :");
        }


    }


}
