/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UserInterface.Customer;

import TheBusiness.Business.Business;
import TheBusiness.CustomerManagement.CustomerProfile;
import TheBusiness.SolutionOrders.SolutionOrder;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class OrderHistoryJPanel extends javax.swing.JPanel {
    
    /**
     * Creates new form OrderSolutionOfferJPanel
     */
    
    JPanel CardSequencePanel;
    Business business;
    CustomerProfile cp;

    
    public OrderHistoryJPanel(Business b, JPanel CardSequencePanel, CustomerProfile cp) {
        
        business = b;
        this.CardSequencePanel = CardSequencePanel;
        this.cp = cp;
        initComponents();
        populateOrderHistoryTable();
    }
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrderHistory = new javax.swing.JTable();
        Back = new javax.swing.JButton();

        setBackground(new java.awt.Color(214, 173, 96));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText(" Order History");

        tblOrderHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Products", "Quantity", "Bill Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblOrderHistory);
        if (tblOrderHistory.getColumnModel().getColumnCount() > 0) {
            tblOrderHistory.getColumnModel().getColumn(0).setResizable(false);
            tblOrderHistory.getColumnModel().getColumn(1).setResizable(false);
            tblOrderHistory.getColumnModel().getColumn(2).setResizable(false);
        }

        Back.setBackground(new java.awt.Color(0, 0, 0));
        Back.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        Back.setForeground(new java.awt.Color(255, 255, 255));
        Back.setText("<< Back");
        Back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(335, 335, 335)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel3)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(Back)
                .addContainerGap(57, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        // TODO add your handling code here:
        CardSequencePanel.remove(this);
        ((java.awt.CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);
    }//GEN-LAST:event_BackActionPerformed


    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblOrderHistory;
    // End of variables declaration//GEN-END:variables

    private void populateOrderHistoryTable() {
        
        DefaultTableModel dtm=(DefaultTableModel)tblOrderHistory.getModel();
        dtm.setRowCount(0);
        
        for (SolutionOrder so : business.getMasterSolutionOrderList().getSolutionorderlist()) {
            
            if(so.getCustomer().getCustomerId().equals(cp.getCustomerId()))
            {
                Object[] row = new Object[3];
                row[0] = so.getSelectedsolutionoffer().getProducts();
                row[1] = so.getQuantity();
                row[2] = so.getActualPrice() * so.getQuantity();
                
                dtm.addRow(row);

             
            }
            
        }
        
    }
}
