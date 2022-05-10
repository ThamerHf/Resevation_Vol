package reservation;

import java.util.ArrayList;
import java.util.Objects;

public class Client {

    private ArrayList<Reservation> reservations = new ArrayList<>();

    private String nom;

    private String reference;

    private boolean paiment;

    private String contact;

    public Client(String nom, String reference, String contact) {
        this.setNom(nom);
        this.setReference(reference);
        this.paiment = false;
        this.setContact(contact);
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        Objects.requireNonNull(nom, "nom doit être non NULL");
        this.nom = nom;
    }

    public String getContact() {
        return this.contact;
    }

    public void setContact(String contact) {
        Objects.requireNonNull(contact, "contact doit être non NULL");
        this.contact = contact;
    }

    public boolean isPaiment() {
        return this.paiment;
    }

    public void PaimentValide() {
        this.paiment = true;
    }

    public String getReference() {
        return this.reference;
    }

    public void setReference(String reference) {
        Objects.requireNonNull(reference, "reference doit être non NULL");
        this.reference = reference;
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


    
    
}
