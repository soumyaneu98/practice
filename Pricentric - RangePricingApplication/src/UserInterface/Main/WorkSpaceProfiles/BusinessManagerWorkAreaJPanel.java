/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 /*
 * WorkAreaJPanel.java
 *
 * Created on May 17, 2020, 8:35:29 AM
 */
package UserInterface.Main.WorkSpaceProfiles;

import TheBusiness.Business.Business;
import UserInterface.Admin.ManageUsersJPanel;
import UserInterface.Admin.ReportMenuJPanel;
import UserInterface.ManageTheBusiness.ManageTheBusinessJPanel;
import UserInterface.ProductManagement.ManageSuppliersJPanel;
import javax.swing.JPanel;

/**
 *
 * @author kal
 */
public class BusinessManagerWorkAreaJPanel extends javax.swing.JPanel {

    javax.swing.JPanel CardSequencePanel;
    Business business;

    /**
     * Creates new form UnitRiskWorkArea
     */

    public BusinessManagerWorkAreaJPanel(Business b, JPanel clp) {

        business = b;
        this.CardSequencePanel = clp;
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

        jButton4 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        btnManageUsers = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(214, 173, 96));
        setForeground(new java.awt.Color(51, 51, 51));

        jButton4.setBackground(new java.awt.Color(0, 0, 0));
        jButton4.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Manage The Business");
        jButton4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.setMaximumSize(new java.awt.Dimension(200, 40));
        jButton4.setMinimumSize(new java.awt.Dimension(20, 23));
        jButton4.setPreferredSize(new java.awt.Dimension(240, 30));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4IdentifyResourceAssetsActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(0, 0, 0));
        jButton10.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("Manage Suppliers");
        jButton10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton10.setMaximumSize(new java.awt.Dimension(200, 40));
        jButton10.setMinimumSize(new java.awt.Dimension(20, 20));
        jButton10.setPreferredSize(new java.awt.Dimension(240, 25));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        btnManageUsers.setBackground(new java.awt.Color(0, 0, 0));
        btnManageUsers.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        btnManageUsers.setForeground(new java.awt.Color(255, 255, 255));
        btnManageUsers.setText("Manage Users");
        btnManageUsers.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnManageUsers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnManageUsers.setMaximumSize(new java.awt.Dimension(200, 40));
        btnManageUsers.setMinimumSize(new java.awt.Dimension(20, 20));
        btnManageUsers.setPreferredSize(new java.awt.Dimension(240, 25));
        btnManageUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageUsersActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(0, 0, 0));
        jButton11.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("Performance Reports");
        jButton11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton11.setMaximumSize(new java.awt.Dimension(200, 40));
        jButton11.setMinimumSize(new java.awt.Dimension(20, 20));
        jButton11.setPreferredSize(new java.awt.Dimension(240, 25));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Admin Dashboard");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(387, 387, 387)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnManageUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(346, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnManageUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(212, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4IdentifyResourceAssetsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4IdentifyResourceAssetsActionPerformed
        // TODO add your handling code here:
       //CardSequencePanel.removeAll();

        ManageTheBusinessJPanel aos = new ManageTheBusinessJPanel(business, CardSequencePanel);

        CardSequencePanel.add("ManageVulns", aos);
        ((java.awt.CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);

    }//GEN-LAST:event_jButton4IdentifyResourceAssetsActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:

        ManageSuppliersJPanel iet = new ManageSuppliersJPanel(business, CardSequencePanel);

        CardSequencePanel.add("FindResourceAsset", iet);
        ((java.awt.CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);

    }//GEN-LAST:event_jButton10ActionPerformed

    private void btnManageUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageUsersActionPerformed
        // TODO add your handling code here:
        CardSequencePanel.removeAll();

        ManageUsersJPanel mus = new ManageUsersJPanel(business, CardSequencePanel);

        CardSequencePanel.add("ManageUsers", mus);
        ((java.awt.CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);

        
        //      ViewBusinessUnitRiskProfile drpd= new ViewBusinessUnitRiskProfile(businessunit, CardSequencePanel);
//        ManageHazards drpd = new ManageHazards(businessunit, CardSequencePanel);
//        CardSequencePanel.add("ManageRiskProfiles", drpd);
        ((java.awt.CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);
}//GEN-LAST:event_btnManageUsersActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:

        CardSequencePanel.removeAll();

        ReportMenuJPanel rmjp = new ReportMenuJPanel(business, CardSequencePanel);

        CardSequencePanel.add("ReportMenu", rmjp);
        ((java.awt.CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);
}//GEN-LAST:event_jButton11ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnManageUsers;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

}
