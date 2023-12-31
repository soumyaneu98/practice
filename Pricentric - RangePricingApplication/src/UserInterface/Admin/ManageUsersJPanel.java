/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UserInterface.Admin;

import TheBusiness.Business.Business;
import TheBusiness.CustomerManagement.CustomerDirectory;
import TheBusiness.CustomerManagement.CustomerProfile;
import TheBusiness.MarketModel.MarketChannelAssignment;
import TheBusiness.MarketModel.MarketChannelComboCatalog;
import TheBusiness.OrderManagement.MasterOrderList;
import TheBusiness.OrderManagement.Order;
import TheBusiness.SalesManagement.SalesPersonDirectory;
import TheBusiness.SalesManagement.SalesPersonProfile;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import static jdk.internal.net.http.common.Log.channel;

/**
 *
 * @author malin
 */
public class ManageUsersJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageUsersJPanel
     */
    JPanel CardSequencePanel;
    Business business;
    public ManageUsersJPanel(Business bz, JPanel jp) {
        CardSequencePanel = jp;
        this.business = bz;
        initComponents();
        populateSalesTable();
        populateCustomersTable();
        populateSalesCustomerTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblSalesPerson = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCustomers = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblSC = new javax.swing.JTable();
        btnMapSC = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(214, 173, 96));

        tblSalesPerson.setBackground(new java.awt.Color(0, 0, 0));
        tblSalesPerson.setForeground(new java.awt.Color(255, 255, 255));
        tblSalesPerson.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Sales Department"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSalesPerson.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblSalesPerson);
        if (tblSalesPerson.getColumnModel().getColumnCount() > 0) {
            tblSalesPerson.getColumnModel().getColumn(0).setResizable(false);
        }

        tblCustomers.setBackground(new java.awt.Color(0, 0, 0));
        tblCustomers.setForeground(new java.awt.Color(255, 255, 255));
        tblCustomers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Customers"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCustomers.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblCustomers);
        if (tblCustomers.getColumnModel().getColumnCount() > 0) {
            tblCustomers.getColumnModel().getColumn(0).setResizable(false);
        }

        tblSC.setBackground(new java.awt.Color(0, 0, 0));
        tblSC.setForeground(new java.awt.Color(255, 255, 255));
        tblSC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Sales", "Customer"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSC.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tblSC);
        if (tblSC.getColumnModel().getColumnCount() > 0) {
            tblSC.getColumnModel().getColumn(0).setResizable(false);
            tblSC.getColumnModel().getColumn(1).setResizable(false);
        }

        btnMapSC.setBackground(new java.awt.Color(0, 0, 0));
        btnMapSC.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        btnMapSC.setForeground(new java.awt.Color(255, 255, 255));
        btnMapSC.setText("Map");
        btnMapSC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMapSCLoginButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Manage Users");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(287, 287, 287)
                                .addComponent(btnMapSC, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(139, 139, 139)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 46, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(39, 39, 39)
                .addComponent(btnMapSC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(229, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnMapSCLoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMapSCLoginButtonActionPerformed
        // TODO add your handling code here:

        int selectedRow = tblSalesPerson.getSelectedRow();
        int selectedRow1 = tblCustomers.getSelectedRow();

        if (selectedRow < 0 || selectedRow1 < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row from both sales and customer tables to create assignment", "Warning", JOptionPane.WARNING_MESSAGE);
            //return;
        }
        else
        {
            SalesPersonDirectory salespersondirectory=business.getSalesPersonDirectory();
            CustomerDirectory customerdirectory=business.getCustomerDirectory();
            MasterOrderList masterorderlist = business.getMasterOrderList();
            String salesperson=tblSalesPerson.getValueAt(selectedRow, 0).toString();
            String customer= tblCustomers.getValueAt(selectedRow1, 0).toString();
            SalesPersonProfile salespersonprofile=salespersondirectory.findSalesPerson(salesperson);
            CustomerProfile customerprofile=customerdirectory.findCustomer(customer);
 
            //CustomerProfile linkedustomer=
            Order findorder=business.getMasterOrderList().findOrder(customerprofile);
 
            if(findorder==null)
            {
                Order order = masterorderlist.newOrder(customerprofile, salespersonprofile);
                populateSalesCustomerTable();
            }
            else
            {
               JOptionPane.showMessageDialog(null, "Customer already linked to the salesperson", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }

    }//GEN-LAST:event_btnMapSCLoginButtonActionPerformed

}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMapSC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblCustomers;
    private javax.swing.JTable tblSC;
    private javax.swing.JTable tblSalesPerson;
    // End of variables declaration//GEN-END:variables

    private void populateSalesTable() {
        
        DefaultTableModel dtm=(DefaultTableModel)tblSalesPerson.getModel();
        dtm.setRowCount(0);
        
        for(SalesPersonProfile sp: business.getSalesPersonDirectory().getSalespersonlist())
        {
           Object[] row=new Object[1];
           row[0]=sp.getPerson().getPersonId();
           dtm.addRow(row);
        } 
    }

    private void populateCustomersTable() {
        
        DefaultTableModel dtm=(DefaultTableModel)tblCustomers.getModel();
        dtm.setRowCount(0);
        
        for(CustomerProfile cp: business.getCustomerDirectory().getCustomerlist())
        {
           Object[] row=new Object[1];
           row[0]=cp.getPerson().getPersonId();
           dtm.addRow(row);
        } 
    }

    private void populateSalesCustomerTable() {
        
         DefaultTableModel dtm=(DefaultTableModel)tblSC.getModel();
        dtm.setRowCount(0);
        
        for(Order order: business.getMasterOrderList().getOrders())
        {
           Object[] row=new Object[2];
           row[0]=order.getSalesperson().getPerson().getPersonId();
           row[1]=order.getCustomer().getPerson().getPersonId();
           
           dtm.addRow(row);
        } 
    }
}
