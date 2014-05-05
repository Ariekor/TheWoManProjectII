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
import java.sql.Types;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.util.Vector;
import oracle.jdbc.OracleTypes;
import oracle.jdbc.oracore.OracleType;

/**
 *
 * @author Isabelle
 */
public class InventaireJoueurs extends javax.swing.JDialog {

    private String nomUsager;
    private ConnectionOracle connBD;
    private ResultSet rst ;
    private Vector Contenu;
    private Vector Entete;
    private JTable ZeCatalogue;
    private String SQL = "SELECT ca.numitem, nomitem, QUANTITEITEM\n" +
"      FROM catalogue ca\n" +
"      INNER JOIN inventairejoueur ij ON ca.numitem = ij.numitem \n" +
"      where nomusager = ? \n" +
"      ORDER BY numitem";
    
    
    public InventaireJoueurs(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public void setParam(String numitem, ConnectionOracle conn)
    {
        this.nomUsager = numitem;
        this.connBD = conn;
        FormLoad();
    }
    
    private void FormLoad(){
        ListInventaire();
        ZeCatalogue.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    private void ListInventaire(){
         try
        {
            PreparedStatement stm = connBD.getConnection().prepareStatement(SQL, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stm.setString(1, nomUsager);
            rst = stm.executeQuery();
            Contenu = remplirVecteur(rst);
            Entete = creerEntete();
            ZeCatalogue = new JTable(Contenu,Entete);
            SP_Catalogue.setViewportView(ZeCatalogue);
            this.getContentPane().add(SP_Catalogue,BorderLayout.CENTER);
            SP_Catalogue.validate();
            
        }
        catch(SQLException e){JOptionPane.showMessageDialog(this, e.getMessage());}
        
    }
    
    private Vector creerEntete()
    {
        Vector vectEntete = new Vector();
        vectEntete.add("NumItem"); //1
        vectEntete.add("NomItem"); //2
        vectEntete.add("Quantite");     //3


        return vectEntete;        
    }
    private Vector remplirVecteur(ResultSet rst){
        Vector v = new Vector();
        Vector ligne = null;
        int i = 0;
        try
        {            
            while (rst.next()){
                ligne = new Vector();
                i++;
                ligne.add(rst.getInt(1));
                i++;
                ligne.add(rst.getString(2));
                i++;
                ligne.add(rst.getInt(3));               
                v.add(ligne); 
            }            
        }
        catch (SQLException se)
        {
            JOptionPane.showMessageDialog(this, se.getMessage() + i);
        }
        return v;
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
        LBL_AjoutOuModif = new javax.swing.JLabel();
        BTN_Fermer1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        LB_User = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Inventaire  Joueurs");

        LBL_AjoutOuModif.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        LBL_AjoutOuModif.setText("Inventaire Joueurs");

        BTN_Fermer1.setText("FERMER");
        BTN_Fermer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_Fermer1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Usager");

        LB_User.setText("Usager ici");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(SP_Catalogue, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
                        .addComponent(LBL_AjoutOuModif))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LB_User, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BTN_Fermer1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(LBL_AjoutOuModif)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(LB_User))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SP_Catalogue, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(BTN_Fermer1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_Fermer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_Fermer1ActionPerformed
        CloseForm();
    }//GEN-LAST:event_BTN_Fermer1ActionPerformed

    private void CloseForm()
    {
        setVisible(false);
        dispose();
    }
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
            java.util.logging.Logger.getLogger(InventaireJoueurs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InventaireJoueurs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InventaireJoueurs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InventaireJoueurs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                InventaireJoueurs dialog = new InventaireJoueurs(new javax.swing.JFrame(), true);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_Fermer1;
    private javax.swing.JLabel LBL_AjoutOuModif;
    private javax.swing.JLabel LB_User;
    private javax.swing.JScrollPane SP_Catalogue;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
