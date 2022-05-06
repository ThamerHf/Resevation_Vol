package aeroport;
import java.util.ArrayList;

import java.util.Objects; 
public class Aeroport {

    private String nom;

    //private String ville;
    private ArrayList<Ville> mesVilles;

    public Aeroport(String nom, Ville...villes) {
        Objects.requireNonNull(nom, "Nom doit être non null");
        Objects.requireNonNull(villes, "Ville doit être non null");
        this.nom = nom;
        this.mesVilles = new ArrayList<Ville>();
        for(Ville i: villes){
            addVille(i);
        }
    }

    public String getNom(){
        return this.nom;
    }

    public void setNom(String nom) {
        Objects.requireNonNull(nom, "Nom doit être non null");
        this.nom = nom;
    }

    public ArrayList<Ville> getVilles(){
        return this.mesVilles;
    }

    public void addVille(Ville v){
        Objects.requireNonNull(v, "Ville doit être non null");
        if(!this.mesVilles.contains(v)){
            this.mesVilles.add(v);
            v.addAeroport(this);
        }
    }

    /* public String getVille() {
        return this.ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
*/

}
