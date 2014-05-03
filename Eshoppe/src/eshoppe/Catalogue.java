/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eshoppe;
import java.awt.BorderLayout;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Simon
 */
public class Catalogue extends javax.swing.JFrame {
// <editor-fold defaultstate="collapsed" desc="Attributs">
    private ConnectionOracle conn = new ConnectionOracle();
    private String SQLGenre = "Select Distinct Genre From Catalogue";
    private String SQLCatalogue = "Select * from vuearmes ";
    private String sqlArme = "SELECT ca.numitem, nomitem, quantite, prix, genre, disponible, poids, image, efficacité, composition, mains\n" +
                             "FROM catalogue ca\n" +
                             "INNER JOIN armes ar ON ca.numitem = ar.numitem  where nomitem like ? \n" +
                             "ORDER BY numitem ";
    private String sqlArmure = "SELECT ca.numitem, nomitem, quantite, prix, genre, disponible, poids, image, efficacité, composition, taille\n" +
                               "FROM catalogue ca\n" +
                               "INNER JOIN armures ar ON ca.numitem = ar.numitem where nomitem like ? \n" +
                               "ORDER BY numitem ";
    private String sqlPotion = "SELECT ca.numitem, nomitem, quantite, prix, genre, disponible, poids, image, effetattendu, duréeeffet\n" +
                               "FROM catalogue ca\n" +
                               "INNER JOIN potions po ON ca.numitem = po.numitem where nomitem like ? \n" +
                               "ORDER BY numitem ";
    private String sqlHabilite = "SELECT ca.numitem, nomitem, quantite, prix, genre, disponible, poids, image, description\n" +
                                 "FROM catalogue ca\n" +
                                 "INNER JOIN habiletés ha ON ca.numitem = ha.numitem where nomitem like ? \n" +
                                 "ORDER BY numitem ";
    private int Numint;
    ResultSet rst ;
    Vector Contenu;
    Vector Entete;
    JTable ZeCatalogue;
    // </editor-fold>
    public Catalogue() {
        initComponents();
        conn.setConnection("kellylea", "oracle2");
        conn.connecter();
        ListCBX();
        RemplirList();
    }
    
 // <editor-fold defaultstate="collapsed" desc="Remplir catalogue">   
    private void RemplirList()
    {
        if (CB_Genre.getSelectedItem().toString().equalsIgnoreCase("Arme") )
        {
            RemplirListArme();
        }
        else if (CB_Genre.getSelectedItem().toString().equalsIgnoreCase("Armure") )
        {
            RemplirListArmure();
        }
        else if (CB_Genre.getSelectedItem().toString().equalsIgnoreCase("Habileté"))
        {
            RemplirListHabilete();
        }
        else if ( CB_Genre.getSelectedItem().toString().equalsIgnoreCase("Potion"))
        {
            RemplirListPotion();
        }
        ZeCatalogue.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    
    private void RemplirListArme()
    {
        try
        {
            PreparedStatement stm = conn.getConnection().prepareStatement(sqlArme, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stm.setString(1, TB_Type.getText() + "%");
            rst = stm.executeQuery();
            Contenu = remplirVecteurArme(rst);
            Entete = creerEnteteArme();
            ZeCatalogue = new JTable(Contenu,Entete);
            SP_Catalogue.setViewportView(ZeCatalogue);
            this.getContentPane().add(SP_Catalogue,BorderLayout.CENTER);
            SP_Catalogue.validate();
            
        }
        catch(SQLException e){JOptionPane.showMessageDialog(this, e.getMessage());}
        
    }
    
     private void RemplirListPotion()
    {
        try
        {
            PreparedStatement stm = conn.getConnection().prepareStatement(sqlPotion, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stm.setString(1, TB_Type.getText() + "%");
            rst = stm.executeQuery();
            Contenu = remplirVecteurPotion(rst);
            Entete = creerEntetePotion();
            ZeCatalogue = new JTable(Contenu,Entete);
            SP_Catalogue.setViewportView(ZeCatalogue);
            this.getContentPane().add(SP_Catalogue,BorderLayout.CENTER);
            SP_Catalogue.validate();
            
        }
        catch(SQLException e){JOptionPane.showMessageDialog(this, e.getMessage());}
        
    }
     
    private void RemplirListArmure()
    {
        try
        {
            PreparedStatement stm = conn.getConnection().prepareStatement(sqlArmure, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stm.setString(1, TB_Type.getText() + "%");
            rst = stm.executeQuery();
            Contenu = remplirVecteurArmure(rst);
            Entete = creerEnteteArmure();
            ZeCatalogue = new JTable(Contenu,Entete);
            SP_Catalogue.setViewportView(ZeCatalogue);
            this.getContentPane().add(SP_Catalogue,BorderLayout.CENTER);
            SP_Catalogue.validate();
            
        }
        catch(SQLException e){JOptionPane.showMessageDialog(this, e.getMessage());}
        
    }
    
    private void RemplirListHabilete()
    {
        try
        {
            PreparedStatement stm = conn.getConnection().prepareStatement(sqlHabilite, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stm.setString(1, TB_Type.getText() + "%");
            rst = stm.executeQuery();
            Contenu = remplirVecteurHabilete(rst);
            Entete = creerEnteteHabilete();
            ZeCatalogue = new JTable(Contenu,Entete);
            SP_Catalogue.setViewportView(ZeCatalogue);
            this.getContentPane().add(SP_Catalogue,BorderLayout.CENTER);
            SP_Catalogue.validate();
            
        }
        catch(SQLException e){JOptionPane.showMessageDialog(this, e.getMessage());}
        
    }
    
    private Vector creerEnteteArme()
    {
        Vector vectEntete = new Vector();
        vectEntete.add("NumItem"); //1
        vectEntete.add("NomItem"); //2
        vectEntete.add("Prix");     //3
        vectEntete.add("Quantite"); //4
        vectEntete.add("Genre");    //5
        vectEntete.add("Disponible");//6
        vectEntete.add("Poids");     //7
        vectEntete.add("Image");        //8
        vectEntete.add("Efficacité");   //9
        vectEntete.add("Composition");  //10
        vectEntete.add("Mains");     //11
        return vectEntete;        
    }
    
    private Vector creerEntetePotion()
    {
        Vector vectEntete = new Vector();
        vectEntete.add("NumItem"); //1
        vectEntete.add("NomItem"); //2
        vectEntete.add("Prix");     //3
        vectEntete.add("Quantite"); //4
        vectEntete.add("Genre");    //5
        vectEntete.add("Disponible");//6
        vectEntete.add("Poids");     //7
        vectEntete.add("Image");        //8
        vectEntete.add("Effet Attendu");   //9
        vectEntete.add("Durée éffet");  //10

        return vectEntete;        
    }
    
    private Vector creerEnteteHabilete()
    {
        Vector vectEntete = new Vector();
        vectEntete.add("NumItem"); //1
        vectEntete.add("NomItem"); //2
        vectEntete.add("Prix");     //3
        vectEntete.add("Quantite"); //4
        vectEntete.add("Genre");    //5
        vectEntete.add("Disponible");//6
        vectEntete.add("Poids");     //7
        vectEntete.add("Image");        //8
        vectEntete.add("Desrcitpion");   //9

        return vectEntete;        
    }
    
    private Vector creerEnteteArmure()
    {
        Vector vectEntete = new Vector();
        vectEntete.add("NumItem"); //1
        vectEntete.add("NomItem"); //2
        vectEntete.add("Prix");     //3
        vectEntete.add("Quantite"); //4
        vectEntete.add("Genre");    //5
        vectEntete.add("Disponible");//6
        vectEntete.add("Poids");     //7
        vectEntete.add("Image");        //8
        vectEntete.add("Efficacité");   //9
        vectEntete.add("Composition");  //10
        vectEntete.add("Taille");     //11

        return vectEntete;        
    }
    

    
    private Vector remplirVecteurHabilete(ResultSet rst){
        Vector v = new Vector();
        Vector ligne = null;
        try
        {            
            while (rst.next()){
                ligne = new Vector();
                ligne.add(rst.getInt(1));
                ligne.add(rst.getString(2));
                ligne.add(rst.getInt(3));
                ligne.add(rst.getInt(4));
                ligne.add(rst.getString(5));
                ligne.add(rst.getInt(6));
                ligne.add(rst.getInt(7));
                ligne.add(rst.getString(8));
                ligne.add(rst.getString(9));
                
                v.add(ligne); 
            }            
        }
        catch (SQLException se)
        {
            JOptionPane.showMessageDialog(this, se);
        }
        return v;
    }
    
    private Vector remplirVecteurArmure(ResultSet rst){
        Vector v = new Vector();
        Vector ligne = null;
        try
        {            
            while (rst.next()){
                ligne = new Vector();
                ligne.add(rst.getInt(1));
                ligne.add(rst.getString(2));
                ligne.add(rst.getInt(3));
                ligne.add(rst.getInt(4));
                ligne.add(rst.getString(5));
                ligne.add(rst.getInt(6));
                ligne.add(rst.getInt(7));
                ligne.add(rst.getString(8));
                ligne.add(rst.getInt(9));
                ligne.add(rst.getString(10));
                ligne.add(rst.getString(11));
                v.add(ligne); 
            }            
        }
        catch (SQLException se)
        {
            JOptionPane.showMessageDialog(this, se);
        }
        return v;
    }
    
    private Vector remplirVecteurPotion(ResultSet rst){
        Vector v = new Vector();
        Vector ligne = null;
        try
        {            
            while (rst.next()){
                ligne = new Vector();
                ligne.add(rst.getInt(1));
                ligne.add(rst.getString(2));
                ligne.add(rst.getInt(3));
                ligne.add(rst.getInt(4));
                ligne.add(rst.getString(5));
                ligne.add(rst.getInt(6));
                ligne.add(rst.getInt(7));
                ligne.add(rst.getString(8));
                ligne.add(rst.getString(9));
                ligne.add(rst.getInt(10));

                v.add(ligne); 
            }            
        }
        catch (SQLException se)
        {
            JOptionPane.showMessageDialog(this, se);
        }
        return v;
    }
    
    private Vector remplirVecteurArme(ResultSet rst){
        Vector v = new Vector();
        Vector ligne = null;
        try
        {            
            while (rst.next()){
                ligne = new Vector();
                ligne.add(rst.getInt(1));
                ligne.add(rst.getString(2));
                ligne.add(rst.getInt(3));
                ligne.add(rst.getInt(4));
                ligne.add(rst.getString(5));
                ligne.add(rst.getInt(6));
                ligne.add(rst.getInt(7));
                ligne.add(rst.getString(8));
                ligne.add(rst.getInt(9));
                ligne.add(rst.getString(10));
                ligne.add(rst.getInt(11));
                v.add(ligne); 
            }            
        }
        catch (SQLException se)
        {
            JOptionPane.showMessageDialog(this, se);
        }
        return v;
    }
    
    // </editor-fold>
    
    private void ListCBX()
    {
        try
        {
            Statement stm = conn.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rst = stm.executeQuery(SQLGenre);
            CB_Genre.removeAllItems();
            while(rst.next())
            {
                CB_Genre.addItem(rst.getString("genre"));
            }
        }
        catch (SQLException e){}
    }
    
    private void CloseForm()
    {
        setVisible(false);
        dispose();
    }
    
     // <editor-fold defaultstate="collapsed" desc="Ajout">   
    private void Ajouter()
    {
        String genreSelectionner = CB_Genre.getSelectedItem().toString();
        if (genreSelectionner.equalsIgnoreCase("Arme"))
        {
            AjouterArme();
        }
        else if (genreSelectionner.equalsIgnoreCase("potion"))
        {
            AjouterPotion();
        }
        else if( genreSelectionner.equalsIgnoreCase("Habileté"))
        {
            AjouterHabilete();
        }
        else if( genreSelectionner.equalsIgnoreCase("Armure"))
        {
            AjouterArmure();
        }
        RemplirList();
    }
      
    private void AjouterArme()
    {
        Numint= -1;
        GestionArmes Dialog = new GestionArmes(this, true);
        Dialog.setParam(Numint, conn);
        Dialog.setLocationRelativeTo(this);
        Dialog.setVisible(true);
    }
    private void AjouterArmure()
    {
        Numint= -1;
        GestionArmures Dialog = new GestionArmures(this, true);
        Dialog.setParam(Numint, conn);
        Dialog.setLocationRelativeTo(this);
        Dialog.setVisible(true);
    }
    private void AjouterHabilete()
    {
        Numint= -1;
        GestionHabilites Dialog = new GestionHabilites(this, true);
        Dialog.setParam(Numint, conn);
        Dialog.setLocationRelativeTo(this);
        Dialog.setVisible(true);
    }
    private void AjouterPotion()
    {
        Numint= -1;
        GestionPotions Dialog = new GestionPotions(this, true);
        Dialog.setParam(Numint, conn);
        Dialog.setLocationRelativeTo(this);
        Dialog.setVisible(true);
    }
    
     // </editor-fold>
    
    private void AppelerModifierPrix()
    {
        if (ZeCatalogue.getSelectedColumnCount() != 0)
        {
            Numint = ObtenirNumSelectedItem();
            ModifierPrix dialog = new ModifierPrix(this, true);
            dialog.setParam(Numint, conn);
            dialog.setLocationRelativeTo(this);
            dialog.setVisible(true); 
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Veuillez sélectionner une ligne !" );
        }
    }
    
    private int ObtenirNumSelectedItem ()
    {
        int retour = Integer.parseInt(ZeCatalogue.getValueAt(ZeCatalogue.getSelectedRow(), 0).toString());
        return retour;
    }
    
    private void AppelerModifierQte()
    {
        if (ZeCatalogue.getSelectedColumnCount() != 0)
        {
            Numint = ObtenirNumSelectedItem();
            ModifierQte dialog = new ModifierQte(this, true);
            dialog.setParam(Numint, conn);
            dialog.setLocationRelativeTo(this);
            dialog.setVisible(true); 
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Veuillez sélectionner une ligne !" );
        }
    }
    
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SP_Catalogue = new javax.swing.JScrollPane();
        CB_Genre = new javax.swing.JComboBox();
        BTN_Ajouter = new javax.swing.JButton();
        BTN_ModPrix = new javax.swing.JButton();
        BTN_ModQte = new javax.swing.JButton();
        BTN_Mod = new javax.swing.JButton();
        BTN_Retirer = new javax.swing.JButton();
        BTN_Fermer = new javax.swing.JButton();
        TB_Type = new javax.swing.JTextField();
        BTN_Filtrer = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        Menu_Item = new javax.swing.JMenu();
        MI_Ajouteritem = new javax.swing.JMenuItem();
        Menu_Joueur = new javax.swing.JMenu();
        MI_ConsultJoueur = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Catalogue");

        CB_Genre.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        BTN_Ajouter.setText("AJOUTER");
        BTN_Ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_AjouterActionPerformed(evt);
            }
        });

        BTN_ModPrix.setText("MODIFIER PRIX");
        BTN_ModPrix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_ModPrixActionPerformed(evt);
            }
        });

        BTN_ModQte.setText("MODIFIER QTÉ");
        BTN_ModQte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_ModQteActionPerformed(evt);
            }
        });

        BTN_Mod.setText("MODIFIER");

        BTN_Retirer.setText("RETIRER");

        BTN_Fermer.setText("FERMER");
        BTN_Fermer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_FermerActionPerformed(evt);
            }
        });

        BTN_Filtrer.setText("Filtrer");
        BTN_Filtrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_FiltrerActionPerformed(evt);
            }
        });

        Menu_Item.setText("Item");

        MI_Ajouteritem.setText("Ajouter Item");
        MI_Ajouteritem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_AjouteritemActionPerformed(evt);
            }
        });
        Menu_Item.add(MI_Ajouteritem);

        jMenuBar1.add(Menu_Item);

        Menu_Joueur.setText("Joueurs");

        MI_ConsultJoueur.setText("Consulter Joueur...");
        Menu_Joueur.add(MI_ConsultJoueur);

        jMenuBar1.add(Menu_Joueur);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CB_Genre, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TB_Type, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTN_Filtrer))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(SP_Catalogue, javax.swing.GroupLayout.DEFAULT_SIZE, 862, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BTN_Ajouter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BTN_ModPrix, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BTN_ModQte, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BTN_Mod, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BTN_Retirer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BTN_Fermer, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BTN_Ajouter, BTN_Mod, BTN_ModPrix, BTN_ModQte, BTN_Retirer});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CB_Genre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TB_Type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTN_Filtrer))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(BTN_Ajouter)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTN_ModPrix)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BTN_ModQte)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BTN_Mod)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTN_Retirer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 273, Short.MAX_VALUE)
                        .addComponent(BTN_Fermer))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SP_Catalogue)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {BTN_Ajouter, BTN_Mod, BTN_ModPrix, BTN_ModQte, BTN_Retirer});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_FermerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_FermerActionPerformed
        CloseForm();
    }//GEN-LAST:event_BTN_FermerActionPerformed

    private void BTN_FiltrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_FiltrerActionPerformed
        RemplirList();
    }//GEN-LAST:event_BTN_FiltrerActionPerformed

    private void BTN_AjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_AjouterActionPerformed
       Ajouter();
    }//GEN-LAST:event_BTN_AjouterActionPerformed

    private void MI_AjouteritemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_AjouteritemActionPerformed
        Ajouter();
    }//GEN-LAST:event_MI_AjouteritemActionPerformed

    private void BTN_ModPrixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_ModPrixActionPerformed
        AppelerModifierPrix();
    }//GEN-LAST:event_BTN_ModPrixActionPerformed

    private void BTN_ModQteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_ModQteActionPerformed
        AppelerModifierQte();
    }//GEN-LAST:event_BTN_ModQteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Catalogue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Catalogue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Catalogue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Catalogue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Catalogue().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_Ajouter;
    private javax.swing.JButton BTN_Fermer;
    private javax.swing.JButton BTN_Filtrer;
    private javax.swing.JButton BTN_Mod;
    private javax.swing.JButton BTN_ModPrix;
    private javax.swing.JButton BTN_ModQte;
    private javax.swing.JButton BTN_Retirer;
    private javax.swing.JComboBox CB_Genre;
    private javax.swing.JMenuItem MI_Ajouteritem;
    private javax.swing.JMenuItem MI_ConsultJoueur;
    private javax.swing.JMenu Menu_Item;
    private javax.swing.JMenu Menu_Joueur;
    private javax.swing.JScrollPane SP_Catalogue;
    private javax.swing.JTextField TB_Type;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
