package aeroport;

import java.util.Objects;

import reservation.Reservation;

import java.util.ArrayList;
import java.util.Collection;

public class Compagnie {

    private String name;

    private Collection<Vol> vols = new ArrayList<>();

    private ArrayList<Reservation> reservations = new ArrayList<>();


    public Compagnie(String name) {
        this.setName(name);
    }

    public ArrayList<Reservation> getReservations() {
        return this.reservations;
    }

    public void setReservations(ArrayList<Reservation> reservations) {
        Objects.requireNonNull(reservations, "reservation ne doit pass être NULL");
        this.reservations = reservations;
    }

    public void addReservation(Reservation reservation) {
        Objects.requireNonNull(reservations, "reservation ne doit pass être NULL");
        reservation.setCompagnie(this);
        this.reservations.add(reservation);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        Objects.requireNonNull(name, "Nom doit être non null");
        this.name = name;
    }

    public Collection<Vol> getVols() {
        return vols;
    }

    public void setVols(Collection<Vol> vols) {
        for(Vol v : this.vols){
            v.setCompagnieWithoutBidirectional(null);
        }

        this.vols = vols;

        if(this.vols != null) {
            for (Vol v : this.vols) {
                v.setCompagnieWithoutBidirectional(this);
            }
        }
    }

    public void addVol(Vol vol){
        Objects.requireNonNull(vol, "vol ne doit pas être null");
        vol.setCompagnieWithoutBidirectional(this);
        this.addVolWithoutBidirectional(vol);
    }

    
    public void removeVol(Vol vol){
        vol.setCompagnieWithoutBidirectional(null);
        this.removeVolWithoutBidirectional(vol);
    }


    protected void setVolsWithoutBidirectional(Collection<Vol> vols) {
        Objects.requireNonNull(vols, "vols ne peut pas être null");
        this.vols = vols;
    }

    protected void addVolWithoutBidirectional(Vol vol){
        this.vols.add(vol);
    }

    protected void removeVolWithoutBidirectional(Vol vol){
        this.vols.remove(vol);
    }
}
