package aeroport;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Objects;

public class Vol {

    private static ArrayList<String> numVols = new ArrayList<>();
    private Collection<Escale> mesEscales;

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
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) throws IllegalArgumentException {
        Objects.requireNonNull(dateDepart);
        if(dateDepart.after(this.dateArrivee)) {
            throw new IllegalArgumentException("La date de départ ne peut pas être après celle d'arrivée");
        }
        this.dateDepart = dateDepart;
    }

    public Date getDateArrivee() {
        return dateArrivee;
    }

    public void setDateArrivee(Date dateArrivee) {
        Objects.requireNonNull(dateArrivee);
        if(this.dateDepart.after(dateArrivee)) {
            throw new IllegalArgumentException("La date d'arrivée ne peut pas être avant celle de départ");
        }
        this.dateArrivee = dateArrivee;
    }

    public Vol(){
        this.mesEscales = new ArrayList<Escale>();
    }

    public Vol(String numero) {
        this();
        this.setNumero(numero);
    }

    public Vol(String numero, Aeroport depart, Aeroport Arrivee, Date departDate, Date dateArrivee) {
        this(numero);
        this.setDepart(depart);
        this.setArrivee(arrivee);
        this.setDateDepart(dateDepart);
        this.setDateArrivee(dateArrivee);
    }

    public Compagnie getCompagnie() {
        return compagnie;
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
        return numero;
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
        return depart;
    }

    public void setDepart(Aeroport depart) {
        Objects.requireNonNull(depart, "l'aeroport ne peut pas être NULL");
        this.depart = depart;
    }

    public Aeroport getArrivee() {
        return arrivee;
    }

    public void setArrivee(Aeroport arrivee) {
        Objects.requireNonNull(arrivee, "l'aeroport ne peut pas être NULL");
        this.arrivee = arrivee;
    }

    public Collection<Escale> getEscales(){
        return this.mesEscales;
    }

    public void addEscale(Escale e) throws IllegalArgumentException{
        Objects.requireNonNull(e);
        if(e.getAeroport().equals(this.depart) || e.getAeroport().equals(this.arrivee)){
            throw new IllegalArgumentException("L'Aeroport de l'escale doit être différent de l'aeroport de départ et d'arrivée du vol");
        }
        if(e.getDateArrivee().after(this.dateArrivee) || e.getDateArrivee().before(this.dateDepart)
        || e.getDateArrivee().equals(this.dateArrivee) || e.getDateArrivee().equals(this.dateDepart)){
            throw new IllegalArgumentException("Date d'arrivée de l'escale est invalide");
        }
        if(e.getDateDepart().after(this.dateArrivee) || e.getDateDepart().before(this.dateDepart) 
        || e.getDateDepart().equals(this.dateArrivee) || e.getDateDepart().equals(this.dateDepart)){
            throw new IllegalArgumentException("Date de départ de l'escale est invalide");
        }

        for(Escale p : mesEscales){
            if(p.getAeroport().equals(e.getAeroport())){
                throw new IllegalArgumentException("Escale Invalide ne peut pas être ajouter : nom d'aeroport");
            }
        }
        int index = 0;
        Iterator<Escale> iter = mesEscales.iterator();
        boolean bool = true;
        while(iter.hasNext() && bool == true){
            if(iter.next().getDateArrivee().equals(e.getDateArrivee()) || iter.next().getDateDepart().equals(e.getDateDepart()) 
            || iter.next().getDateDepart().equals(e.getDateArrivee())){
                throw new IllegalArgumentException("Escale Invalide ne peut pas être ajouter");
            }
            if(iter.next().getDateDepart().after(e.getDateArrivee())){
                bool = false;
            }

            index ++;
        }

        ((ArrayList<Escale>)(this.mesEscales)).add(index, e);
    }


    public void ouvrirVol() {
        this.statut = true;
    }

    public void fermerVol() {
        this.statut = false;
    }

    public boolean getStatut(){
        return this.statut;
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
