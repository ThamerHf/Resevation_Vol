package aeroport;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Objects; 

public class Escale{

    private Aeroport aeroport;
    private Date dateDepart;
    private Date dateArrivee;

    public Escale(Date dateDepart, Date dateArrivee, Aeroport aeroport) throws IllegalArgumentException{
        setAeroport(aeroport);
        setDateDepart(dateDepart);
        setDateArrivee(dateArrivee);
    }

    public Duration obtenirDuree() {
        if(this.dateDepart != null && this.dateArrivee != null) {
            return Duration.of(dateArrivee.getTime() - dateDepart.getTime(), ChronoUnit.MILLIS);
        }
        return null;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
        Objects.requireNonNull(dateDepart);
        if(dateDepart.after(dateArrivee) || dateArrivee.equals(dateDepart)){
            throw new IllegalArgumentException("Erreur date de depart doit être supérieur au date d'arrivée");
        }
        else{
            this.dateDepart = dateDepart;
        }
    }

    public Date getDateArrivee() {
        return dateArrivee;
    }

    public void setDateArrivee(Date dateArrivee) {
        Objects.requireNonNull(dateArrivee);
        if(dateDepart.after(dateArrivee) || dateArrivee.equals(dateDepart)){
            throw new IllegalArgumentException("Erreur date de depart doit être supérieur au date d'arrivée");
        }
        else{
            this.dateArrivee = dateArrivee;
        }
    }

    public Aeroport getAeroport(){
        return this.aeroport;
    }

    public void setAeroport(Aeroport a){
        Objects.requireNonNull(a);
        this.aeroport = a;
    }
}