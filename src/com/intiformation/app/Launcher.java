package com.intiformation.app;
import com.intiformation.app.dao.DaoFactory;
import com.intiformation.app.dao.PlaceDao;
import com.intiformation.app.dao.TripDao;
import com.intiformation.app.model.Place;
import com.intiformation.app.model.Trip;
import com.intiformation.app.util.ConnectionManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Launcher {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args)  {

        Connection myConnection = ConnectionManager.getConnection();
        int choix = 0;
        do{
            System.out.println("Welcome abord !");
            System.out.println("1 - Add a place");
            System.out.println("2 - Find a place");
            System.out.println("3 - Edit a place");
            System.out.println("4 - Remove a place");
            System.out.println("5 - Add a trip");
            System.out.println("6 - Find a trip");
            System.out.println("7 - Remove a trip");
            System.out.println("8 - Quit");
            choix=scan.nextInt();
            switch (choix){
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
                    removeaPlace();
                    break;
                case 5:
                    //Add a trip
                    break;

                case 6:
                    //Find a trip
                    break;

                case 7:
                    //Remove a trip
                    removeaTrip();
                    break;
                case 8:
                    // fermeture de la connexion
                    System.out.println("Goodby !");
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
        while(choix != 8);
    }

    // add new Place
    private static void addaPlace() {
        System.out.println("Name of place to add :");
        String name = scan.nextLine();
        Place place = new Place();
        place.setName(name);
        PlaceDao placeDao = DaoFactory.GetPlaceDao();
        placeDao.createPlace(place);
        System.out.println("New place added.");
    }
    // find a place

    private static void findaPlace() {
        System.out.println("Name of place to find :");
        String name = scan.nextLine();
        Place place = new Place();
        //TODO rechercher place
        if (place!= null)//TODO place non vide
        {System.out.println("place trouvée.");}
        else
        { System.out.println("place non trouvée.");}
    }


    private static void removeaPlace() {
        System.out.println("Name of place to be removed :");
        String name = scan.nextLine();
        Place place = new Place();
        place.setName(name);
        PlaceDao placeDao = DaoFactory.GetPlaceDao();
        if (placeDao.removePlace(place)) {
            System.out.println("place " + place.getName() + " found & removed");
        } else {
            System.out.println("place " + place.getName() + " not found.");
        }
    }

    private static void removeaTrip() {
        System.out.println("Please provide departure and arrival info for the Trip to be removed:");
        System.out.println("Departure:");
        String dep = scan.nextLine();
        System.out.println("Arrival:");
        String arr = scan.nextLine();
        Trip trip = new Trip();
        trip.setDeparture(dep);
        trip.setArrival(arr);
        TripDao tripDao = DaoFactory.GetTripDao();
        if (tripDao.removeTrip(trip)) {
            System.out.println("trip " + trip.getDeparture() + " / " + trip.getArrival() + " found & removed");
        } else {
            System.out.println("trip " +  trip.getDeparture() + " / " + trip.getArrival() + " not found.");
        }
    }


}
