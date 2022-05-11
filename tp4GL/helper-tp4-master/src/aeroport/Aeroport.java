package aeroport;
import java.util.ArrayList;

import java.util.Objects; 
public class Aeroport {

    private String nom;

    //private String ville;
    private ArrayList<Ville> mesVilles;

    public Aeroport(String nom){
        this.setNom(nom);
        this.mesVilles = new ArrayList<Ville>();
    }

    public Aeroport(String nom, ArrayList<Ville> villes) {
        this(nom);
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

    public void setVille(ArrayList<Ville> villes) {
        Objects.requireNonNull(villes);
        for(Ville i : villes){
            addVille(i);
        }
    }

    @Override
    public boolean equals(Object obj){
        try {
            return ((Aeroport) obj).getNom().equals(this.getNom());
        } catch (Exception e){
            return false;
        }
    }

}
