package org.example.App;

// class avec les attribues
public class Employe {
    private int Id;
    private String nom;
    private String poste;
    private double salaire;
// constructeur sans param
    public Employe() {
        this.Id = 0;
        this.nom = "";
        this.poste = "";
        this.salaire = 0.0;
    }
// constructeur avec paramettre
    public Employe(int id, String nom, String poste, double salaire) {
        Id = id;
        this.nom = nom;
        this.poste = poste;
        this.salaire = salaire;
    }
// les getters and setters
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    // methode to string
    @Override
    public String toString(){
        return "Id employe"+Id +"nom"+nom+"poste occupé"+poste+"salaire"+salaire;
    }
    public static int compareParSalaire(Employe e1, Employe e2){
        return Double.compare(e1.getSalaire(),e2.getSalaire());

    }
}


