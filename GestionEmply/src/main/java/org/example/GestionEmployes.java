package org.example;

import org.example.App.Employe;

import java.util.Scanner;


public class GestionEmployes {
    private static Employe[] employes=new Employe[50];
    private static int count=0;

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int option;
        do {
            printMenu();
            option = scanner.nextInt();
            scanner.nextLine();  // Consommer le saut de ligne

            switch (option) {
                case 1:
                    System.out.print("Entrez l'ID : ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consommer le saut de ligne
                    System.out.print("Entrez le nom : ");
                    String nom = scanner.nextLine();
                    System.out.print("Entrez le poste : ");
                    String poste = scanner.nextLine();
                    System.out.print("Entrez le salaire : ");
                    double salaire = scanner.nextDouble();
                    ajouterEmploye(new Employe(id, nom, poste, salaire));
                    break;

                case 2:
                    System.out.print("Entrez l'ID de l'employé à modifier : ");
                    int idModif = scanner.nextInt();
                    scanner.nextLine(); // Consommer le saut de ligne
                    System.out.print("Entrez le nouveau nom : ");
                    String nouveauNom = scanner.nextLine();
                    System.out.print("Entrez le nouveau poste : ");
                    String nouveauPoste = scanner.nextLine();
                    System.out.print("Entrez le nouveau salaire : ");
                    double nouveauSalaire = scanner.nextDouble();
                    modifierEmploye(idModif, nouveauNom, nouveauPoste, nouveauSalaire);
                    break;

                case 3:
                    System.out.print("Entrez l'ID de l'employé à supprimer : ");
                    int idSupp = scanner.nextInt();
                    supprimerEmploye(idSupp);
                    break;

                case 4:
                    afficherEmployes();
                    break;

                case 5:
                    System.out.print("Entrez le nom ou le poste à rechercher : ");
                    String critere = scanner.nextLine();
                    rechercherEmploye(critere);
                    break;

                case 6:
                    calculerMasseSalariale();
                    break;

                case 7:
                    System.out.print("Trier par salaire croissant (true/false) : ");
                    boolean ordreCroissant = scanner.nextBoolean();
                    trierEmployesParSalaire(ordreCroissant);
                    break;

                case 8:
                    System.out.println("Au revoir !");
                    break;

                default:
                    System.out.println("Option invalide. Essayez encore.");
                    break;
            }
        } while (option != 8);

        scanner.close();
    }
    public static void printMenu(){
        System.out.println("------------- Gestion des Employés --------------");
        System.out.println("1. Ajouter un employé");
        System.out.println("2. Modifier un employé");
        System.out.println("3. Supprimer un employé");
        System.out.println("4. Afficher les employés");
        System.out.println("5. Rechercher un employé");
        System.out.println("6. Calculer la masse salariale");
        System.out.println("7. Trier les employés par salaire");
        System.out.println("8. Quitter");
        System.out.print("Choisissez une option : ");
    }
    public static void ajouterEmploye(Employe employe){
        if(count<50){
            employes[count]=employe;
            count++;
            System.out.println("employer ajouter avec succes");
        }else {
            System.out.println("la liste est plein");
        }

    }
    public static void modifierEmploye(int Id, String nouveauNom, String nouveauPoste, double nouveauSalaire){
        for (int i=0; i<count;i++){
            if (employes [i].getId() == Id) {
                employes[i].setNom(nouveauNom);
                employes[i].setPoste(nouveauPoste);
                employes[i].setSalaire(nouveauSalaire);
                System.out.println("les informations de l'employer modifie avec succes");
                return;
            }
        }
        System.out.println("employe non trouvé");

    }
    public static void supprimerEmploye(int Id){
        for (int i=0; i<count;i++){
            if (employes[i].getId()==Id){
                for (int a=i; a<count-1;a++){
                    employes[a]=employes[a+1];{
                    }
                    employes[count -1]=null;
                    count--;
                    System.out.println("employe supprime du la liste");
                    return;
                }
            }
        }
        System.out.println("employer non trouvé");
    }
    public static void afficherEmployes(){
        for (int i =0; i<count;i++){
            System.out.println(employes[i].toString());
        }
    }
    public static void rechercherEmploye(String critere) {
        boolean trouve = false;
        for (int i = 0; i < count; i++) {
            if (employes[i].getNom().equalsIgnoreCase(critere) || employes[i].getPoste().equalsIgnoreCase(critere)) {
                System.out.println(employes[i]);
                trouve = true;
            }
        }
        if (!trouve) {
            System.out.println("Aucun employé trouvé avec ce critère.");
        }
    }
    public static void calculerMasseSalariale(){
        double massSalariale=0;
        for (int i=0;i<count;i++){
            massSalariale+=employes[i].getSalaire();
        }
        System.out.println("la masse salariale est de : "+massSalariale);
    }
    public static void trierEmployesParSalaire(boolean ordreCroissant){
        if (ordreCroissant) {
            java.util.Arrays.sort(employes, 0, count, (e1, e2) -> Employe.compareParSalaire(e1, e2));
        } else {
            java.util.Arrays.sort(employes, 0, count, (e1, e2) -> Employe.compareParSalaire(e2, e1));
        }
        afficherEmployes();
    }
    }


