/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eshoppe;

import java.sql.*;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Isabelle
 */
public class GestionJoueurs extends javax.swing.JDialog {

    String sql1 = "SELECT NOMUSAGER, MOTDEPASSE, NOM, PRENOM, CAPITAL FROM JOUEURSRPG";
    ConnectionOracle connBD;
    ResultSet rstUsers;
    
    /**
     * Creates new form GestionArmes
     */
    public GestionJoueurs(java.awt.Frame parent, boolean modal) {
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
        jLabel3 = new javax.swing.JLabel();
        BTN_Fermer = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        TBX_User1 = new javax.swing.JTextField();
        BTN_Invetaire = new javax.swing.JButton();
        LB_User = new javax.swing.JLabel();
        LB_Nom = new javax.swing.JLabel();
        LB_Prenom = new javax.swing.JLabel();
        LB_User3 = new javax.swing.JLabel();
        LB_Capital = new javax.swing.JLabel();
        BTN_First = new javax.swing.JButton();
        BTN_Previous = new javax.swing.JButton();
        BTN_Next = new javax.swing.JButton();
        BTN_Last = new javax.swing.JButton();
        BN_Rechercher = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestion Joueurs");
        setResizable(false);

        LBL_AjoutOuModif.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        LBL_AjoutOuModif.setText("Consulter Joueurs");

        jLabel1.setText("Nom");

        jLabel3.setText("Usager");

        BTN_Fermer.setText("FERMER");
        BTN_Fermer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_FermerActionPerformed(evt);
            }
        });

        jLabel2.setText("Prénom");

        jLabel5.setText("Mot de passe");

        jLabel6.setText("Porte-feuille");

        jLabel11.setText("Recherche par Usager");

        TBX_User1.setMinimumSize(new java.awt.Dimension(180, 20));
        TBX_User1.setPreferredSize(new java.awt.Dimension(180, 20));

        BTN_Invetaire.setText("INVENTAIRE");

        LB_User.setText("Usager ici");
        LB_User.setMaximumSize(new java.awt.Dimension(180, 14));
        LB_User.setMinimumSize(new java.awt.Dimension(180, 14));
        LB_User.setPreferredSize(new java.awt.Dimension(180, 14));

        LB_Nom.setText("Nom ici");
        LB_Nom.setMaximumSize(new java.awt.Dimension(180, 14));
        LB_Nom.setMinimumSize(new java.awt.Dimension(180, 14));
        LB_Nom.setPreferredSize(new java.awt.Dimension(180, 14));

        LB_Prenom.setText("Prénom ici");
        LB_Prenom.setMaximumSize(new java.awt.Dimension(180, 14));
        LB_Prenom.setMinimumSize(new java.awt.Dimension(180, 14));
        LB_Prenom.setPreferredSize(new java.awt.Dimension(180, 14));

        LB_User3.setText("Mot de passe ici");
        LB_User3.setMaximumSize(new java.awt.Dimension(180, 14));
        LB_User3.setMinimumSize(new java.awt.Dimension(180, 14));
        LB_User3.setPreferredSize(new java.awt.Dimension(180, 14));

        LB_Capital.setText("Écus ici");
        LB_Capital.setMaximumSize(new java.awt.Dimension(180, 14));
        LB_Capital.setMinimumSize(new java.awt.Dimension(180, 14));
        LB_Capital.setPreferredSize(new java.awt.Dimension(180, 14));

        BTN_First.setText("PREMIER");
        BTN_First.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_FirstActionPerformed(evt);
            }
        });

        BTN_Previous.setText("PRÉCÉDENT");
        BTN_Previous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_PreviousActionPerformed(evt);
            }
        });

        BTN_Next.setText("SUIVANT");
        BTN_Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_NextActionPerformed(evt);
            }
        });

        BTN_Last.setText("DERNIER");
        BTN_Last.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_LastActionPerformed(evt);
            }
        });

        BN_Rechercher.setText("RECHERCHER");
        BN_Rechercher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BN_RechercherActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BTN_Invetaire)
                    .addComponent(jLabel11)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LB_User, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LB_User3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LB_Prenom, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LB_Nom, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LB_Capital, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(BTN_Fermer)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(BTN_First)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(BTN_Previous)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(BTN_Next)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(BTN_Last)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TBX_User1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BN_Rechercher)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LBL_AjoutOuModif)
                .addGap(91, 91, 91))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LBL_AjoutOuModif)
                .addGap(20, 20, 20)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TBX_User1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BN_Rechercher))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(LB_User, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(LB_Nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(LB_Prenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(LB_User3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(LB_Capital, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_First)
                    .addComponent(BTN_Last)
                    .addComponent(BTN_Next)
                    .addComponent(BTN_Previous))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_Fermer)
                    .addComponent(BTN_Invetaire))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_FermerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_FermerActionPerformed
        CloseForm();
    }//GEN-LAST:event_BTN_FermerActionPerformed

    private void BTN_FirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_FirstActionPerformed
        try
        {
            if(rstUsers.first())
            {
                afficherUsers();
            }
        }
        
        catch(SQLException se){ System.out.println(se);}
    }//GEN-LAST:event_BTN_FirstActionPerformed

    private void BTN_PreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_PreviousActionPerformed
        try 
        {
           if(rstUsers.previous())
           {
              afficherUsers();
           }
           else 
           {
             JOptionPane.showMessageDialog(this, "Précedent impossible");
           }

        }

        catch(SQLException se)
        {
           JOptionPane.showMessageDialog(this, "Précedent impossible");
        }
    }//GEN-LAST:event_BTN_PreviousActionPerformed

    private void BTN_NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_NextActionPerformed
        try 
        {
            if(rstUsers.next())
            {
                  afficherUsers();
            }

            else 
            {
               JOptionPane.showMessageDialog(this, "Suivant impossible");
            }
        }

        catch(SQLException se)
        {
           JOptionPane.showMessageDialog(this, "Suivant imposible");
        }
    }//GEN-LAST:event_BTN_NextActionPerformed

    private void BTN_LastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_LastActionPerformed
       try 
       {
           if(rstUsers.last())
           {
                afficherUsers();
           }
       }

       catch(SQLException se){
          JOptionPane.showMessageDialog(this, "Dernier imposible");
       }
    }//GEN-LAST:event_BTN_LastActionPerformed

    private void BN_RechercherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BN_RechercherActionPerformed
        RechercherUser();
    }//GEN-LAST:event_BN_RechercherActionPerformed

    public void setParam(int numitem, ConnectionOracle conn)
    {
        this.connBD = conn;
        formLoad();
    }
    
    private void CloseForm()
    {
        setVisible(false);
        dispose();
    }
    
    private void RechercherUser()
    {
        try 
        {
            String sqlrech = "SELECT NOMUSAGER, MOTDEPASSE, NOM, PRENOM, CAPITAL FROM JOUEURSRPG WHERE NOMUSAGER LIKE ?";
            PreparedStatement stmrech = connBD.getConnection().prepareStatement(sqlrech, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            stmrech.setString(1, TBX_User1.getText() + "%");
            rstUsers = stmrech.executeQuery();

            if (rstUsers.first())
            {
                afficherUsers();
            }
        }
        catch(SQLException se){ System.out.println(se);}
    }
    
    public void afficherUsers()
    {
        try
        {
            LB_User.setText(rstUsers.getString("NOMUSAGER"));
            LB_Nom.setText(rstUsers.getString("NOM"));
            LB_Prenom.setText(rstUsers.getString("PRENOM"));
            LB_User3.setText(rstUsers.getString("MOTDEPASSE"));
            LB_Capital.setText (((Integer)rstUsers.getInt("CAPITAL")).toString());
        }
        
        catch(SQLException se){ System.out.println(se);} 
    }
    
    public void formLoad()
    {
        try
        {
            Statement stm1 = connBD.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rstUsers = stm1.executeQuery(sql1);
            
            if (rstUsers.first())
            {
                afficherUsers();
            }
        }
        
        catch(SQLException se){ System.out.println(se);}
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
            java.util.logging.Logger.getLogger(GestionJoueurs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionJoueurs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionJoueurs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionJoueurs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GestionJoueurs dialog = new GestionJoueurs(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton BN_Rechercher;
    private javax.swing.JButton BTN_Fermer;
    private javax.swing.JButton BTN_First;
    private javax.swing.JButton BTN_Invetaire;
    private javax.swing.JButton BTN_Last;
    private javax.swing.JButton BTN_Next;
    private javax.swing.JButton BTN_Previous;
    private javax.swing.JLabel LBL_AjoutOuModif;
    private javax.swing.JLabel LB_Capital;
    private javax.swing.JLabel LB_Nom;
    private javax.swing.JLabel LB_Prenom;
    private javax.swing.JLabel LB_User;
    private javax.swing.JLabel LB_User3;
    private javax.swing.JTextField TBX_User1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
