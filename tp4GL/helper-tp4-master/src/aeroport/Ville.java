package aeroport;

import java.util.Objects; 
import java.util.ArrayList;

public class Ville{

    private String nom;
    private ArrayList<Aeroport> aeroportList = new ArrayList<Aeroport>; 

    public Ville(String nom){
        this.nom = Objects.requireNonNull(nom, "Nom de la ville doit être non NUll");
    }

    public String getNom(){
        return this.nom;
    }

    public void addAeroport(Aeroport a){
        this.aeroportList.add(a);
    }
}
