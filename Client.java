import java.rmi.Naming;

public class Client {
    public static void main(String[] args) {
        try {
            MonServeurRPCInterface remoteObject = (MonServeurRPCInterface) Naming.lookup("rmi://localhost:1099/MyServer");

       String name = "kaleb" ;
       double price = 15665 ;
       String name1 = "Valentino" ;
       double price1 = 156647 ;
       String name2 = "Cadnell" ;
       double price2 = 1566;
       remoteObject.encherir(name,price) ;
       System.out.println(remoteObject.getprix()) ;
       remoteObject.encherir(name1,price1) ;
       System.out.println(remoteObject.getprix()) ;
       remoteObject.encherir(name2,price2) ;
       System.out.println(remoteObject.getprix()) ;

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}

