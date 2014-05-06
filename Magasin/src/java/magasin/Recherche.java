package magasin;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

// on accède au servlet avec l'URL "localhost:8084/magasin/recherche"
@WebServlet( name = "Recherche", urlPatterns = {"/recherche"} )
public class Recherche extends HttpServlet
{
   // méthode appelée par doGet() et doPost()
   protected void processRequest(
         HttpServletRequest request, HttpServletResponse response )
         throws ServletException, IOException
   {
      // avertit le navigateur qu'il va recevoir du code HTML
      response.setContentType( "text/html;charset=UTF-8" );
      // obtention d'un flux pour écrire vers le navigateur
      PrintWriter out = response.getWriter();
        
      // début du document HTML (pourrait être fait dans une méthode
      // spécifique)
      out.println( "<!DOCTYPE html>" );
      out.println( "<html lang='fr'>" );
      out.println( "<head>" );
      out.println( "<meta charset='utf-8'/>" );
      out.println( "<title>Recherche</title>" );            
      out.println( "</head>" );
      out.println( "<body>" );
      out.println( "<h1>Recherche d'employés</h1>" );

      // connexion à la base de données
      ConnexionOracle oradb = new ConnexionOracle();
      oradb.connecter();
      
      //
      String sql= "select nom, prenom from employes e inner join " +
            "departements d  on e.codedep = d.codedep where d.nomdep = ?";

      try
      {
         // passer la requête par le PreparedStatement
         PreparedStatement stm = oradb.getConnexion().prepareStatement( sql );
         // affecter la valeur "informatique" au paramètre de la requête sql
         // le paramètre est représenté par le ?
         stm.setString( 1, "informatique" );
         ResultSet rst = stm.executeQuery();

         // parcours du ResultSet
         out.println( "<ol>" );
         while( rst.next() )
         {
            String nom = rst.getString( "nom" );
            String prenom = rst.getString( "prenom" );
            out.println( "<li>" + nom + ", " +  prenom + "</li>" );
         }
         out.println( "</ol>" );
                  
         stm.close();
         rst.close();    
      }
      catch( SQLException se ) 
      {
         System.err.println( se );
      }    

      oradb.deconnecter();

      // barre de navigation
      out.println( "<a href='insertion'>Insertion</a>" + " | " +
            "<a href='recherche'>Recherche</a>" );
      
      out.println( "</body>" );
      out.println( "</html>" );
   }
   
   // méthode appelée suite à une requête GET (barre d'adresse du navigateur
   // ou hyperlien
   @Override
   protected void doGet( HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException
   {
      processRequest( request, response );
   }

   // méthode appelée suite à une requête POST (envoi d'un formulaire)
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException
   {
      processRequest( request, response );
   }
}