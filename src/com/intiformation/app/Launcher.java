package com.intiformation.app;
import com.intiformation.app.dao.DaoFactory;
import com.intiformation.app.dao.PlaceDao;
import com.intiformation.app.dao.TripDao;
import com.intiformation.app.model.Place;
import com.intiformation.app.model.Trip;
import com.intiformation.app.util.ConnectionManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
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
            System.out.println("7 - Remoove a trip");
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
        while(choix!=8);



    }

    private static void findaTrip() {
        System.out.println("Name of place of depature to find :");
        String name = scan.nextLine();
        Place place = new Place();
        Boolean trouveplace=false;
        Boolean boucle = false;
        //TODO rechercher place
        if (place!= null)//TODO place non vide
        {
        trouveplace=true;
        ;}
        else
        { System.out.println("place non trouvée.");}
        if(trouveplace==true){
            System.out.println("Name of place of arival to find :");
        }


    }

    private static void addaTrip() {
        System.out.println("Vous désirez ajouter un voyage");


        TripDao tripDao = DaoFactory.GetTripDao();
        PlaceDao placeDao = DaoFactory.GetPlaceDao();
        ArrayList<Place> places = placeDao.findAllPlace();
        for (Place p : places ) {
            System.out.println(p.toString());
        }
        System.out.println("Choice id of depature");
        Long iddepature = scan.nextLong();
        System.out.println("Choice id of arrival");
        Long idarrival = scan.nextLong();

        System.out.println("Price of the trip ?");
        float price=scan.nextFloat();

        Trip newTrip= new Trip();
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




}
