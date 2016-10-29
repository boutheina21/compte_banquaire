import java.util.ArrayList;
import java.util.Scanner;
// tout les méthode juste mais dans la méthode choix il ne entre pas dans le bloc de if
public class Client {
    private Scanner clavier=new Scanner(System.in);
    private ArrayList<Client> liste =new  ArrayList<Client>();
    private String nom;
    private int solde;
    private final int LeTaux=5;
    private int NumDeCheque;

    public Client(String nom, int solde, int NumDeCheque) {
        this.nom = nom;
        this.solde = solde;
        this.NumDeCheque= NumDeCheque;
    }
    public Client(String nom, int NumDeCheque) {
        this.nom = nom;
        this.NumDeCheque= NumDeCheque;
    }

    public Client(){}

    public void menuPrincipale() {
        boolean reponse = false;
        while (!reponse) {
            System.out.println("bienvenus dans la banque");
            System.out.println("1)j'ai déjà un compte ");
            System.out.println("2)crée un compte");
            System.out.println("3)quitté la banque");
            switch (clavier.nextInt()) {
                case 1:
                    this.liste=CréationDeCompte();

                    break;
                case 2:
                    choix();
                    break;
                case 3:
                    reponse = true;
                    break;
            }
        }
    }
    public String toString(){
        return "le compte " + liste ;
    }

    public double ClculeIntérets(){
        return((LeTaux*solde)/100)/12;
    }

    public void Depot (int montant ){
        solde=solde+montant;
        System.out.println("ton nouveau solde est " +  solde);
    }

    public void Retrait(int montant){
        if(montant>solde){
            System.out.println("le solde est insufisont ");
        }
        else{
            solde=solde-montant;
            System.out.println("ton nouveau solde est " +  solde);
        }
    }

    public ArrayList<Client> CréationDeCompte(){
        // ArrayList<Client> liste;
        int i=0;boolean b=true;
        while((i<1000) && (b==true)) {
            System.out.print(" svp ton nom : ");
            clavier.nextLine();
            nom = clavier.nextLine();
            NumDeCheque = Lancer();
            Client n = new Client(nom, solde, NumDeCheque);
            this.liste.add(n);
            b=false;
        }
        System.out.println("le client est " + nom  + " ton solde est " + solde +
                " ton num de cheque est " +  NumDeCheque);
        return liste;
    }

    public int Lancer() {return (int) (1000000+ Math.random() * 20000000 );}

    public void choix(  ) {
        System.out.println(" entrer votre nom svp : ");
        nom = clavier.nextLine();
        clavier.nextLine();
        System.out.println(" entrer votre num de cheque svp : ");
        NumDeCheque = clavier.nextInt();
        Client n=new Client(nom,NumDeCheque);
        for(int i=0;i<liste.size();i++){
            System.out.println("le client est " + liste.get(i).NumDeCheque);
            if(n.equals(liste.get(i))){                 //?????????????????????????????
                System.out.println("le client est " + liste.get(i).NumDeCheque);
                boolean reponse = false;
                while (!reponse) {
                    System.out.println(" 1) voir mon taut et mes intérets ");
                    System.out.println(" 2) ajouter                       ");
                    System.out.println(" 3) retrait               ");
                    System.out.println(" 4) revenir au menu principale ");
                    switch (clavier.nextInt()) {
                        case 1:
                            System.out.println("ton taut est " + LeTaux + " % ");
                            ClculeIntérets();
                            System.out.println("tes intérets est : "  + ClculeIntérets() );
                            break;
                        case 2:
                            System.out.print("svp entrer le mantont ");
                            int montant = clavier.nextInt();
                            Depot(montant);
                            break;
                        case 3:
                            System.out.print("svp entrer le mantont ");
                            int montant2 = clavier.nextInt();
                            Retrait(montant2);
                            break;
                        case 4:
                            menuPrincipale();
                            break;
                    }
                }    }
            else

                System.out.println("les information entrer est fausses ");

        }
    }
}
