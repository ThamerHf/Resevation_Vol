package aeroport;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Objects; 
import java.util.ArrayList;

public class Vol {

    private static ArrayList<String> numVols = new ArrayList<>();
    private static ArrayList<Escale> mesEscales = new ArrayList<>();

    private String numero;

    private Aeroport depart;

    private Aeroport arrivee;

    private Compagnie compagnie;

    private Date dateDepart;

    private Date dateArrivee;

    private boolean statut;

    public Duration obtenirDuree() {
        if(this.dateDepart != null && this.dateArrivee != null) {
            return Duration.of(dateArrivee.getTime() - dateDepart.getTime(), ChronoUnit.MILLIS);
        }
        return null;
    }

    public Date getDateDepart() {
        return this.dateDepart;
    }

    public void setDateDepart(Date dateDepart) throws IllegalArgumentException {
        Objects.requireNonNull(dateDepart);
        if(dateDepart.after(this.dateArrivee)) {
            throw new IllegalArgumentException("La date de déoart ne peut pas être après celle d'arrivée");
        }
        this.dateDepart = dateDepart;
    }

    public Date getDateArrivee() {
        return this.dateArrivee;
    }

    public void setDateArrivee(Date dateArrivee) {
        Objects.requireNonNull(dateArrivee);
        if(this.dateDepart.after(dateArrivee)) {
            throw new IllegalArgumentException("La date de déoart ne peut pas être après celle d'arrivée");
        }
        this.dateArrivee = dateArrivee;
    }

    public Vol(String numero, Aeroport depart, Aeroport Arrivee, Date departDate, Date dateArrivee) {
        this.setNumero(numero);
        this.setDepart(depart);
        this.setArrivee(arrivee);
        this.setDateDepart(dateDepart);
        this.setDateArrivee(dateArrivee);
    }

    public Vol(String numero) {
        this.setNumero(numero);
    }

    public Compagnie getCompagnie() {
        return this.compagnie;
    }

    public void setCompagnie(Compagnie compagnie) {
        if(compagnie!=null) {
            compagnie.addVolWithoutBidirectional(this);
        }
        if(this.compagnie!=null){
            this.compagnie.removeVolWithoutBidirectional(this);
        }
        this.compagnie = compagnie;
    }

    protected void setCompagnieWithoutBidirectional(Compagnie compagnie) {
        this.compagnie = compagnie;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) throws IllegalArgumentException {
        Objects.requireNonNull(numero);
        if(numVols.contains(numero)){
            throw new IllegalArgumentException("Numéro de vol existe déja, choisir un autre");
        }
        else{
            numVols.add(numero);
            this.numero = numero;
        }
    }

    public Aeroport getDepart() {
        return this.depart;
    }

    public void setDepart(Aeroport depart) {
        Objects.requireNonNull(depart, "l'aeroport ne peut pas être NULL");
        this.depart = depart;
    }

    public Aeroport getArrivee() {
        Objects.requireNonNull(depart);
        return this.arrivee;
    }

    public void setArrivee(Aeroport arrivee) {
        Objects.requireNonNull(arrivee, "l'aeroport ne peut pas être NULL");
        this.arrivee = arrivee;
    }

    public void ouvrirVol() {
        this.statut = true;
    }

    public void fermerVol() {
        this.statut = false;
    }

    @Override
    public boolean equals(Object obj) {
        try {
            return ((Vol) obj).getNumero().equals(this.numero);
        } catch (Exception e){
            return false;
        }
    }
}
