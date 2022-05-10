package reservation;

import java.util.Objects;

public class Client {

    private String nom;

    private String reference;

    private boolean paiment;

    private String contact;

    public Client(String nom, String reference, String contact) {
        this.setNom(nom);
        this.setReference(reference);
        this.paiment = false;
        this.setContact(contact);
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        Objects.requireNonNull(nom, "nom doit être non NULL");
        this.nom = nom;
    }

    public String getContact() {
        return this.contact;
    }

    public void setContact(String contact) {
        Objects.requireNonNull(contact, "contact doit être non NULL");
        this.contact = contact;
    }

    public boolean isPaiment() {
        return this.paiment;
    }

    public void PaimentValide() {
        this.paiment = true;
    }

    public String getReference() {
        return this.reference;
    }

    public void setReference(String reference) {
        Objects.requireNonNull(reference, "reference doit être non NULL");
        this.reference = reference;
    }


    
    
}
