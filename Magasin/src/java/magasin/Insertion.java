package magasin;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

// on accède au servlet avec l'URL "localhost:8084/magasin/insertion"
@WebServlet( name = "Insertion", urlPatterns = {"/insertion"} )
public class Insertion extends HttpServlet
{
   // méthode appelée suite à une requête GET (barre d'adresse du navigateur
   // ou hyperlien
   @Override
   protected void doGet(
         HttpServletRequest request, HttpServletResponse response )
         throws ServletException, IOException
   {
      // avertit le navigateur qu'il va recevoir du code HTML
      response.setContentType( "text/html;charset=UTF-8" );
      // obtention d'un flux pour écrire vers le navigateur
      PrintWriter out = response.getWriter();
      
      try
      {
         // début du document HTML (pourrait être fait dans une méthode
         // spécifique)
         out.println( "<!DOCTYPE html>" );
         out.println( "<html lang='fr'>" );
         out.println( "<head>" );
         out.println( "<meta charset='utf-8'/>" );
         out.println( "<title>Insertion</title>" );            
         out.println( "</head>" );
         out.println( "<body>" );
         out.println( "<h1>Insertion d'un employé</h1>" );
         
         // formulaire de saisie pour insertion
         out.println( "<form action='insertion' method='post'>" );
         out.println( "<table>" );
         out.println( "<tr>" );
         out.println( "<td>Nom</td>" );
         out.println( "<td><input type='text' name='nom'/></td>" );
         out.println( "</tr>" );
         out.println( "<tr>" );
         out.println( "<td>Prénom</td>" );
         out.println( "<td><input type='text' name='prenom'/></td>" );
         out.println( "</tr>" );
         out.println( "<tr>" );
         out.println( "<td>Code de département</td>" );
         out.println( "<td><input type='text' name='dep'/></td>" );
         out.println( "</tr>" );    
         out.println( "<tr>" );
         out.println( "<td colspan='2' style='text-align: center'>" +
               "<input type='submit' value='Insérer'/></td>" );
         out.println( "</tr>" );
         out.println( "</table>" );
         out.println( "</form>" );
         
         // barre de navigation
         out.println( "<a href='insertion'>Insertion</a>" + " | " +
               "<a href='recherche'>Recherche</a>" );
         
         out.println( "</body>" );
         out.println( "</html>" );
      }
      finally
      {
         out.close();
      }
   }

   // méthode appelée suite à une requête POST (envoi d'un formulaire)
   @Override
   protected void doPost(
         HttpServletRequest request, HttpServletResponse response )
         throws ServletException, IOException
   {
      // récupération des paramètres du formulaire
      String nom = request.getParameter( "nom" );
      String prenom = request.getParameter( "prenom" );
      String dep = request.getParameter( "dep" );
        
      // avertit le navigateur qu'il va recevoir du code HTML
      response.setContentType( "text/html;charset=UTF-8" );
      // obtention d'un flux pour écrire vers le navigateur
      PrintWriter out = response.getWriter();
      
      try
      {
         // début du document HTML (pourrait être fait dans une méthode
         // spécifique)
         out.println( "<!DOCTYPE html>" );
         out.println( "<html lang='fr'>" );
         out.println( "<head>" );
         out.println( "<meta charset='utf-8'/>" );        
         out.println( "</head>" );
         out.println( "<body>" );
         out.println( "<h1>Insertion d'un employé</h1>" );
         
         // connexion à la base de données
         ConnexionOracle oradb = new ConnexionOracle();
         oradb.connecter();
            
         //
         String sqlins =
               "insert into employes (nom, prenom, codedep) values (?,?,?)";
            
         try
         {
            //
            PreparedStatement stmins =
                  oradb.getConnexion().prepareStatement( sqlins );
            
            // on affecte les valeurs aux paramètres de la requête
            stmins.setString( 1, nom );
            stmins.setString( 2, prenom );
            stmins.setString( 3, dep );
            stmins.executeUpdate();
            //oradb.getConnexion().commit();
            stmins.close();
         }
         catch( SQLException se ) 
         {
            System.err.println( se.getMessage() );
         }    

         // confirmation de l'insertion
         out.println( "<p>Vous avez ajouté l'employé suivant:</p>" );
         out.println( "<p>" + prenom + " " + nom + " (" + dep + ")</p>" );

         // barre de navigation
         out.println( "<a href='insertion'>Insertion</a>" + " | " +
               "<a href='recherche'>Recherche</a>" );
            
         out.println( "</body>" );
         out.println( "</html>" );
      }
      finally
      {
         out.close();
      }
   }
}