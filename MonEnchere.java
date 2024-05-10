import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class MonEnchere extends UnicastRemoteObject implements MonServeurRPCInterface {
    private double prixActuel ;
    private String dernierEncherisseur ;
    protected MonEnchere() throws RemoteException {
         prixActuel = 0.0 ;
         dernierEncherisseur = "aucun";
    }

    public void encherir(String nomclient,double prix)  throws RemoteException {
        if(prix > prixActuel){
           prixActuel = prix ;
           dernierEncherisseur = nomclient ;
           System.out.println(nomclient+" a encherit avec un montant de: "+prixActuel) ;  
           }
           else{ System.out.println(nomclient+" désolé mais l'enchère actuelle est plus élevée") ;
              } 
    }
        public double getprix() throws RemoteException {
                
                return prixActuel ;
                }
                

    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            MonEnchere monService = new MonEnchere();
            Naming.rebind("rmi://localhost:1099/MyServer", monService);
            System.out.println("Serveur RMI prêt.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

