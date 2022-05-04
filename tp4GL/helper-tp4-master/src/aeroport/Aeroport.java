package aeroport;
import java.util.ArrayList;

import java.util.Objects; 
public class Aeroport {

    private String nom;

    //private String ville;
    private ArrayList<Ville> mesVilles = new ArrayList<Ville>;

    private C

    public Aeroport(String nom, Ville...mesVilles) {
        Objects.requireNonNull(nom, "Nom doit être non null");
        this.nom = nom;
        this.ville = mesVille.getVille();
    }

    public

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getVille() {
        return this.ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
}
