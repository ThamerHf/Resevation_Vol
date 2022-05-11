package aeroport;

import java.util.Objects; 
import java.util.ArrayList;

public class Ville{

    private String nom;
    private ArrayList<Aeroport> mesAeroports; 

    public Ville(String nom){
        this.setNom(nom);
        this.mesAeroports = new ArrayList<Aeroport>();
    }

    public String getNom(){
        return this.nom;
    }

    public void setNom(String nom){
        Objects.requireNonNull(nom, "Nom de la ville doit être non NUll");
        this.nom = nom;
    }

    public ArrayList<Aeroport> getAeroports(){
        return this.mesAeroports;
    }

    public void setAeroport(ArrayList<Aeroport> a) {
        Objects.requireNonNull(a);
        this.mesAeroports = a;
    }

    public void addAeroport(Aeroport a){
        Objects.requireNonNull(a, "l'aeroport ne peut pas être NULL");
        if(!this.mesAeroports.contains(a)){
            this.mesAeroports.add(a);
            a.addVille(this);
        }
    }

    @Override
    public String toString() {
        if(this.mesAeroports.isEmpty()) {
            return this.getNom() + " n'est desservie par aucun aeroport" ;
        }
        String s = new String(this.getNom() + " est desservie par: \n");

        for(Aeroport a : this.mesAeroports){
            s = s + a.getNom() + "\n";
        }
        return s;
    }

}
