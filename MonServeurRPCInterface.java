import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MonServeurRPCInterface extends Remote {
  void encherir(String nomclient,double prix) throws RemoteException ;
  double getprix() throws RemoteException ;
}

