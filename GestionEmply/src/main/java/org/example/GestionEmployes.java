package org.example;

import org.example.App.Employe;

import java.util.Scanner;


public class GestionEmployes {

    // tableau avec 50 salarié
    private static Employe[] employes=new Employe[50];

    // ici c'est un counter pour conter le nombre des salaries dans le tableau pour ajouter des nouveax
    private static int count=0;

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        // declaration pour le switch
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
    // pour afficher le menu
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
    //
    public static void ajouterEmploye(Employe employe){
        // verifier ci le nombre d'employer est inferieur à 50
        if(count<50){
            // ajouter un nouveau employé a l'index 'count'
            employes[count]=employe;
            // incrementer le compteur pour passer a la prochaine position dispo
            count++;
            System.out.println("employer ajouter avec succes");
        }else {
            // si la liste est plein affiche message  ci-dessus
            System.out.println("la liste est plein");
        }

    }
    public static void modifierEmploye(int Id, String nouveauNom, String nouveauPoste, double nouveauSalaire){
        // Parcours de la liste des employés
        for (int i=0; i<count;i++){
           // On cherche l'employé par son ID, puis on modifie ses informations.
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
        // Parcours de la liste des employés
        // Si l'employé trouvé a le même ID que celui passé en paramètre
        for (int i=0; i<count;i++){
            if (employes[i].getId()==Id){
                // Déplacement des éléments suivants dans le tableau vers la gauche
                // Ceci permet de "supprimer" l'employé en écrasant sa place
                for (int a=i; a<count-1;a++){
                    employes[a]=employes[a+1];{
                    }
                    employes[count -1]=null;
                     // Mettre la dernière place du tableau à null (l'élément "supprimé")
                    count--;
                    // Décrémenter le compteur d'employés pour refléter la suppression
                    System.out.println("employe supprime du la liste");
                    return;
                }
            }
        }
        // Si aucun employé avec l'ID donné n'est trouvé, afficher un message d'erreur
        System.out.println("employer non trouvé");
    }
    public static void afficherEmployes(){
        // Méthode pour afficher tous les employés de la liste
        for (int i =0; i<count;i++){
            // Affichage de la représentation sous forme de chaîne de caractères de chaque employé
            System.out.println(employes[i].toString());
        }
    }

    // Méthode pour rechercher un employé en fonction d'un critère (nom ou poste)
    public static void rechercherEmploye(String critere) {
        boolean trouve = false;
        // Variable pour suivre si l'employé a été trouvé ou non
        for (int i = 0; i < count; i++) {
            // Vérification si le nom ou le poste de l'employé correspond au critère
            if (employes[i].getNom().equalsIgnoreCase(critere) || employes[i].getPoste().equalsIgnoreCase(critere)) {
                System.out.println(employes[i]);
                // Mettre 'trouve' à true pour indiquer qu'un employé correspondant a été trouvé
                trouve = true;
            }
        }
        // Si aucun employé n'a été trouvé, afficher un message d'information
        if (!trouve) {
            System.out.println("Aucun employé trouvé avec ce critère.");
        }
    }
    public static void calculerMasseSalariale(){
        // Initialisation de la variable pour stocker la masse salariale totale
        double massSalariale=0;
        for (int i=0;i<count;i++){
            // Ajouter le salaire de chaque employé à la masse salariale totale
            massSalariale+=employes[i].getSalaire();
        }
        System.out.println("la masse salariale est de : "+massSalariale);
    }
    public static void trierEmployesParSalaire(boolean ordreCroissant){
        // Vérifier si le tri doit être effectué dans l'ordre croissant
        if (ordreCroissant) {
            // Si ordreCroissant est vrai, trier les employés par salaire dans l'ordre croissant
            // La méthode Arrays.sort() est utilisée pour trier le tableau d'employés
            // Le comparateur compare les employés par leur salaire via la méthode compareParSalaire()
            java.util.Arrays.sort(employes, 0, count, (e1, e2) -> Employe.compareParSalaire(e1, e2));
        } else {
            // Si ordreCroissant est faux, trier les employés par salaire dans l'ordre décroissant
            // En inversant les paramètres du comparateur (e1, e2) pour obtenir un tri décroissant
            java.util.Arrays.sort(employes, 0, count, (e1, e2) -> Employe.compareParSalaire(e2, e1));
        }
        // Après le tri, afficher tous les employés triés
        afficherEmployes();
    }
    }



