/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eshoppe;

import java.sql.*;
import javax.swing.*;
/**
 *
 * @author Isabelle
 */
public class GestionHabilites extends javax.swing.JDialog {

    /**
     * Creates new form GestionArmes
     */
    private int numitem;
    private ConnectionOracle connBD;
    private String SQLGenre = "Select Distinct Genre From Catalogue";
    private ResultSet rst;
    
    //Méthode appellée par le catalogue et qui initialise le form et les attributs
    public void setParam(int numitem, ConnectionOracle conn)
    {
        this.numitem = numitem;
        this.connBD = conn;
        remplirCBX();
        afficherTitre();
    }
    public GestionHabilites(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        LBL_AjoutOuModif = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        LBL_Key = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        BTN_Cancel = new javax.swing.JButton();
        BTN_OK = new javax.swing.JButton();
        TBX_nom = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TBX_Stock = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TBX_Prix = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        CBX_Genre = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        TBX_Poids = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        TA_Description = new javax.swing.JTextArea();
        CBX_Dispo = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        TBX_Image = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestion Armes");
        setResizable(false);

        LBL_AjoutOuModif.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        LBL_AjoutOuModif.setText("Ajouter / modifier Habilités");

        jLabel1.setText("Nom");

        LBL_Key.setText("#");

        jLabel3.setText("# item");

        BTN_Cancel.setText("ANNULER");
        BTN_Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_CancelActionPerformed(evt);
            }
        });

        BTN_OK.setText("OK");
        BTN_OK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_OKActionPerformed(evt);
            }
        });

        jLabel2.setText("Stock");

        jLabel4.setText("Genre");

        jLabel5.setText("Prix");

        CBX_Genre.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText("Poids");

        jLabel7.setText("Disponible");

        jLabel8.setText("Description");

        TA_Description.setColumns(20);
        TA_Description.setRows(5);
        jScrollPane1.setViewportView(TA_Description);

        CBX_Dispo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel11.setText("Image");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(LBL_AjoutOuModif)
                        .addGap(55, 55, 55))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(BTN_Cancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTN_OK)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(CBX_Genre, javax.swing.GroupLayout.Alignment.LEADING, 0, 182, Short.MAX_VALUE)
                                    .addComponent(TBX_nom, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LBL_Key, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(TBX_Prix)
                                        .addComponent(TBX_Poids, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(TBX_Stock, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CBX_Dispo, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TBX_Image, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LBL_AjoutOuModif)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LBL_Key)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TBX_nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TBX_Stock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TBX_Prix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CBX_Genre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TBX_Poids, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(CBX_Dispo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(TBX_Image, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_OK)
                    .addComponent(BTN_Cancel))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_OKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_OKActionPerformed
        if(numitem == -1)
        {
            ajouterItem();  //attributs communs à tous
            ajouterHabilete();//attributs spécifiques
            CloseForm();
        }
        else
        {
       //     modifierItem();  // a coder   le catalogue passe le numitiem a modifier dans setparam.
            CloseForm();
        }
    }//GEN-LAST:event_BTN_OKActionPerformed

    private void BTN_CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_CancelActionPerformed
        CloseForm();
    }//GEN-LAST:event_BTN_CancelActionPerformed

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
            java.util.logging.Logger.getLogger(GestionHabilites.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionHabilites.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionHabilites.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionHabilites.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GestionHabilites dialog = new GestionHabilites(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    // Procédure générique pour tout genre d'items
    private void ajouterItem()
    {
        try{
            CallableStatement cstmS = connBD.getConnection().prepareCall("{call Gestion_Catalogue.insertion(?,?,?,?,?,?,?)}");
            cstmS.setString(1,TBX_nom.getText());
            cstmS.setInt(2, Integer.parseInt(TBX_Stock.getText()));
            cstmS.setInt(3, Integer.parseInt(TBX_Prix.getText()));
            cstmS.setString(4, CBX_Genre.getSelectedItem().toString());
            cstmS.setInt(5, CBX_Dispo.getSelectedIndex());
            cstmS.setInt(6, Integer.parseInt(TBX_Poids.getText()));
            cstmS.setString(7, TBX_Image.getText());
            cstmS.executeUpdate();
        }catch(SQLException sqe){
            JOptionPane.showMessageDialog(this, sqe.getMessage());
        }
    }
    //Exécuté après ajouterItem() pour récupérer le numitem qui a été donné par le trigger.
    //Le numitem sera utilisé pour l'insertion à la table genre.
    private int trouverNumItem()
    {
        int num = 0;
        try{
            CallableStatement cstmS = connBD.getConnection().prepareCall("{call Gestion_Catalogue.chercherItem(?,?,?,?,?,?,?,?)}");
            cstmS.registerOutParameter(1, java.sql.Types.INTEGER);
            cstmS.setString(2,TBX_nom.getText());
            cstmS.setInt(3, Integer.parseInt(TBX_Stock.getText()));
            cstmS.setInt(4, Integer.parseInt(TBX_Prix.getText()));
            cstmS.setString(5, CBX_Genre.getSelectedItem().toString());
            cstmS.setInt(6, CBX_Dispo.getSelectedIndex());
            cstmS.setInt(7, Integer.parseInt(TBX_Poids.getText()));
            cstmS.setString(8, TBX_Image.getText());
            cstmS.execute();
            
            num = cstmS.getInt(1);  // on récupère le numitem retourné en "out"
        }catch(SQLException sqe){
            JOptionPane.showMessageDialog(this, sqe.getMessage());
        }
        
        return num;
    }
    //fait l'ajout à la table genre spécifique après avoir récupéré le numitem selon les parametres communs.
    private void ajouterHabilete()
    {
        int num = trouverNumItem();        
        try{
            CallableStatement cstmS = connBD.getConnection().prepareCall("{call Gestion_Catalogue.ajouterHabileté(?,?)}");            
            cstmS.setInt(1, num);
            cstmS.setString(2, TA_Description.getText());            
            cstmS.executeUpdate();       
        }catch(SQLException sqe){
            JOptionPane.showMessageDialog(this, sqe.getMessage());
        }
    }
    //rempli les trois menus déroulants.  Appelé par setParam à l'appel du form par catalogue.
    private void remplirCBX()
    {
        CBX_Dispo.removeAllItems();   
        // on aurait pu faire une méthode comme listGenre pour Disponible
        // mais les valeurs sont simples à ajouter "à la main".
        CBX_Dispo.addItem("0");
        CBX_Dispo.addItem("1");        
        ListGenre();        
    }
        
    //Récupère les genres de la BD pour remplir le menu déroulant
    private void ListGenre()
    {
        int i = 0;
        try
        {
            Statement stm1 = connBD.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rst = stm1.executeQuery(SQLGenre);
            CBX_Genre.removeAllItems();
            while ( rst.next())
            {
                CBX_Genre.addItem(rst.getString("genre"));                
                i ++;
            }
        }
        catch(SQLException e) {}
    }
    //Le nom le dit...  Est appelé par les boutons OK et ANNULER.
    private void CloseForm()
    {
        setVisible(false);
        dispose();
    }
    
    //Affiche le but de la fenêtre selon la façon que catalogue a appelé le form.
    //Soit ajouter un nouvel item ou modifier un item existant (lorsque cette option sera disponible.
    private void afficherTitre()
    {
        if (numitem == -1)
        {
            LBL_AjoutOuModif.setText("Ajouter Habileté");
        }
        else
        {
            LBL_AjoutOuModif.setText("Modifier Habileté");
        }        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_Cancel;
    private javax.swing.JButton BTN_OK;
    private javax.swing.JComboBox CBX_Dispo;
    private javax.swing.JComboBox CBX_Genre;
    private javax.swing.JLabel LBL_AjoutOuModif;
    private javax.swing.JLabel LBL_Key;
    private javax.swing.JTextArea TA_Description;
    private javax.swing.JTextField TBX_Image;
    private javax.swing.JTextField TBX_Poids;
    private javax.swing.JTextField TBX_Prix;
    private javax.swing.JTextField TBX_Stock;
    private javax.swing.JTextField TBX_nom;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
