public class Trip {

    private long id;
    private String depart ;
    private String arrive;
    private float prix ;

    public Trip() {
    }

    public Trip(long id, String depart, String arrive, float prix) {
        this.id = id;
        this.depart = depart;
        this.arrive = arrive;
        this.prix = prix;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getArrive() {
        return arrive;
    }

    public void setArrive(String arrive) {
        this.arrive = arrive;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }
}
