package magasin;

import java.sql.Connection;
import java.sql.SQLException;
import oracle.jdbc.pool.*;

public class ConnexionOracle
{
   private String nomUsager = "user1";
   private String motDePasse = "oracle1";
   private String url = "jdbc:oracle:thin:@205.237.244.251:1521:orcl";
   private Connection connexion = null;
   
   public void connecter()
   {
      try
      {
         OracleDataSource ods = new OracleDataSource();
         ods.setURL( url );
         ods.setUser( nomUsager );
         ods.setPassword( motDePasse );
         connexion = ods.getConnection();
      }
      catch( SQLException se )
      {
         System.err.println( se );       
      }
   }
    
   public void deconnecter()
   {
      try 
      { 
         connexion.close();
      }
      catch( SQLException se )
      {
         connexion = null;  
      }
   }
    
   public Connection getConnexion()
   {
      return connexion;
   }
}