package reservation;

import java.util.ArrayList;
import java.util.Objects;


public class Passager {
    
    private ArrayList<Reservation> reservations = new ArrayList<>();

    private String nom;

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        Objects.requireNonNull(nom,"nom ne doit pas être NULL");
        this.nom = nom;
    }

    public ArrayList<Reservation> getReservations() {
        return this.reservations;
    }

    public void setReservation(ArrayList<Reservation> reservation) {
        Objects.requireNonNull(reservation, "reservation doit être non NULL");
        this.reservations = reservation;
    }

    public void addReservation(Reservation reservation){
        Objects.requireNonNull(reservation, "reservvation ne doit pas être null");
        
        this.reservations.add(reservation);
    }

    public void removeReservation(Reservation reservation){
        Objects.requireNonNull(reservation, "reservvation ne doit pas être null");
        this.reservations.remove(reservation);
    }

    @Override
    public String toString(){
        String s = new String("Passager: " + this.getNom());
        for(Reservation r: this.reservations){
            s = s + r.infoReservation();
        }
        return s;
    }


}
