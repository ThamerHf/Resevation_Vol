package reservation;

import java.lang.ref.Cleaner.Cleanable;
import java.util.Date;
import java.util.Objects;

import javax.print.FlavorException;

import java.lang.Integer;

import aeroport.Compagnie;
import aeroport.Vol;

import java.util.ArrayList;

public class Reservation {

    private static int next = 0;

    private Client client;

    private Passager passager;

    private String numero;

    private Vol vol;

    private Date date;

    private boolean paye;

    private boolean confirme;

    public Reservation(Client client, Passager passager, Vol vol, Date date) {
        this.setClient(client);
        this.setPassager(passager);
        this.setNumero();
        this.setVol(vol);
        this.setDate(date);
        this.confirme = false;
        this.paye = false;
    }

    public Passager getPassager() {
        return this.passager;
    }

    public void setPassager(Passager passager) {
        Objects.requireNonNull(passager, "passager ne doit pas être NULL");
        this.passager = passager;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) throws IllegalArgumentException{
        Objects.requireNonNull(date);
        if(this.date != null) {
            if(date.after(this.vol.getDateDepart())){
                throw new IllegalArgumentException("la reservation ne peut se faire après la date de départ du vol");
            }
        }
        this.date = date;
    }

    public String getNumero() {
        return this.numero;
    }

    private String setNumero() {
        next++;
        Integer i = new Integer(next);
        
        if(vol.getCompagnie().getName().length() < 3) {
            return vol.getCompagnie().getName().concat(i.toString());
        }
        return vol.getCompagnie().getName().substring(0, 2).concat(i.toString());
    }

    public Client getClient() {
        return this.client;
    }

    public void setClient(Client client) {
        Objects.requireNonNull(client, "client ne doit pas être NULL");
        this.client = client;
    }

    public Vol getVol() {
        return this.vol;
    }

    public void setVol(Vol vol) {
        Objects.requireNonNull(vol, "vol ne doit pas être NULL");
        this.vol = vol;
    }

    public void payer() throws IllegalCallerException{
        if(this.vol.getStatut() == false) {
            throw new IllegalCallerException("la rservation n'est pas disponible");
        }
        if(this.paye == true){
            throw new IllegalCallerException("cette reservation a déjà été payée");
        }
        this.paye = true;
    }

    public void confirmer() throws IllegalCallerException {
        if(this.vol.getStatut() == false) {
            throw new IllegalCallerException("la rservation n'est pas disponible");
        }
        if(this.paye == false) {
            throw new IllegalCallerException("la reservation n'a pas été payée");
        }
        this.confirme = true;
    }

    public void annuler() throws IllegalCallerException{
        if(this.vol.getStatut() == false) {
            throw new IllegalCallerException("la rservation ne peut être annulée");
        }
        if(this.confirme == true){
            throw new IllegalCallerException("la reservation ne peut être annulée");
        }
        this.paye = false;

    }

    public String infoReservation() {
        return "Reservation numero: " + this.getNumero() + " faite le " + this.getDate().toString() + " | Vol: " + this.getVOl().toString();
    }

    @Override
    public String toString() {
        String s = infoReservation();
        s = s + " pour le client: "  + this.getClient().getNom() + "\nPassager: " + this.getPassager().getNom();
        return s;
    }
}
