package reservation;

import java.lang.ref.Cleaner.Cleanable;
import java.util.Date;
import java.util.Objects;
import java.lang.Integer;

import aeroport.Compagnie;

import java.util.ArrayList;

public class Reservation {

    private static int next = 0;

    private Client client;

    private Passager passager;

    private String numero;

    private Compagnie compagnie;

    private Date date;

    private boolean confirme;

    public Reservation(Client client, Passager passager, Compagnie compagnie, Date date) {
        this.setClient(client);
        this.setPassager(passager);
        this.setNumero();
        this.setCompagnie(compagnie);
        this.setDate(date);
        this.confirme = false;
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

    public void setDate(Date date) {
        Objects.requireNonNull(date);
        this.date = date;
    }

    public String getNumero() {
        return this.numero;
    }

    private String setNumero() {
        next++;
        Integer i = new Integer(next);
        
        if(compagnie.getName().length() < 3) {
            return compagnie.getName().concat(i.toString());
        }
        return compagnie.getName().substring(0, 2).concat(i.toString());
    }

    public Client getClient() {
        return this.client;
    }

    public void setClient(Client client) {
        Objects.requireNonNull(client, "client ne doit pas être NULL");
        this.client = client;
    }

    public Compagnie getCompagnie() {
        return this.compagnie;
    }

    public void setCompagnie(Compagnie companie) {
        Objects.requireNonNull(companie, "companie ne doit pas être NULL");
        this.compagnie = companie;
    }

    public void confirmer() {
        this.confirme = true;
    }

    public void annuler() {
        this.confirme = false;
    }
}
