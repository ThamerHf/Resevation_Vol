package reservation;

import java.lang.ref.Cleaner.Cleanable;
import java.util.Date;
import java.util.Objects;
import java.util.ArrayList;

public class Reservation {

    private static ArrayList<String> numReservation = new ArrayList<>();

    private Client client;

    private Passager passager;

    private String numero;

    private Date date;

    private boolean confirme;

    public Reservation(Client client, Passager passager, String numero, Date date) {
        this.setClient(client);
        this.setPassager(passager);
        this.setNumero(numero);
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

    public void setNumero(String numero) throws IllegalArgumentException{
        Objects.requireNonNull(numero, "numero ne doit pas être NULL");
        if(numReservation.contains(numero)){
            throw new IllegalArgumentException("Numéro de Reservation existe déja, choisir un autre");
        }
        else{
            numReservation.add(numero);
            this.numero = numero;
        }
    }

    public Client getClient() {
        return this.client;
    }

    public void setClient(Client client) {
        Objects.requireNonNull(client, "client ne doit pas être NULL");
        this.client = client;
    }

    public void confirmer() {
        this.confirme = true;
    }

    public void annuler() {
        this.confirme = false;
    }
}
