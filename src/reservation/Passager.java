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


}
