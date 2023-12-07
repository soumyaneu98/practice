/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UserInterface.Sales;

import TheBusiness.Business.Business;
import TheBusiness.CustomerManagement.CustomerProfile;
import TheBusiness.MarketModel.Channel;
import TheBusiness.MarketModel.Market;
import TheBusiness.MarketModel.MarketChannelAssignment;
import TheBusiness.MarketModel.SolutionOffer;
import TheBusiness.OrderManagement.MasterOrderList;
import TheBusiness.ProductManagement.Product;
import TheBusiness.SalesManagement.SalesPersonProfile;
import TheBusiness.SolutionOrders.MasterSolutionOrderList;
import TheBusiness.SolutionOrders.SolutionOrder;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author HP
 */
public class ServeCustomersJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ServeCustomersJPanel
     */
    
    JPanel CardSequencePanel;
    Business business;
    SalesPersonProfile salesperson;
    private ArrayList<SolutionOrder> selectedSolutionOrders = new ArrayList<>();

    public ServeCustomersJPanel(Business bz, JPanel jp,SalesPersonProfile salesperson) {
        initComponents();
        CardSequencePanel = jp;
        this.business = bz;
        this.salesperson=salesperson;
        populateCombo();
        populateOrderTable();
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
        tblOrder = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        CustComboBox = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtAP = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblFinalOrder = new javax.swing.JTable();
        btnConfirm = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 153, 153));

        tblOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Products", "Market", "Channel", "Floorprice", "Ceilingprice", "Targetprice", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblOrder.getTableHeader().setReorderingAllowed(false);
        tblOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblOrderMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblOrder);
        if (tblOrder.getColumnModel().getColumnCount() > 0) {
            tblOrder.getColumnModel().getColumn(0).setResizable(false);
            tblOrder.getColumnModel().getColumn(0).setPreferredWidth(250);
            tblOrder.getColumnModel().getColumn(1).setResizable(false);
            tblOrder.getColumnModel().getColumn(2).setResizable(false);
            tblOrder.getColumnModel().getColumn(3).setResizable(false);
            tblOrder.getColumnModel().getColumn(4).setResizable(false);
            tblOrder.getColumnModel().getColumn(5).setResizable(false);
            tblOrder.getColumnModel().getColumn(6).setResizable(false);
        }

        jLabel1.setText("Select Customer Name");

        CustComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustComboBoxActionPerformed(evt);
            }
        });

        jLabel5.setText("Actual Price:");

        txtAP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAPActionPerformed(evt);
            }
        });

        tblFinalOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Customer", "Solution", "Quantity", "Target Price", "Actual Price", "Total Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblFinalOrder);
        if (tblFinalOrder.getColumnModel().getColumnCount() > 0) {
            tblFinalOrder.getColumnModel().getColumn(0).setResizable(false);
            tblFinalOrder.getColumnModel().getColumn(1).setResizable(false);
            tblFinalOrder.getColumnModel().getColumn(1).setPreferredWidth(250);
            tblFinalOrder.getColumnModel().getColumn(2).setResizable(false);
            tblFinalOrder.getColumnModel().getColumn(3).setResizable(false);
            tblFinalOrder.getColumnModel().getColumn(4).setResizable(false);
            tblFinalOrder.getColumnModel().getColumn(5).setResizable(false);
        }

        btnConfirm.setText("Confirm Deal");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        jLabel2.setText("Placed orders:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel1)
                        .addGap(49, 49, 49)
                        .addComponent(CustComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(jLabel5)
                        .addGap(40, 40, 40)
                        .addComponent(txtAP, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnConfirm))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE)
                                .addComponent(jScrollPane3)))))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(CustComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtAP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConfirm))
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(223, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void CustComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustComboBoxActionPerformed
        // TODO add your handling code here:
        populateOrderTable();
    }//GEN-LAST:event_CustComboBoxActionPerformed

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblOrder.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a solution offer to finalize the deal!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
                
        String selectedCustomer=(String) CustComboBox.getSelectedItem();
        System.out.println("Customername--"+selectedCustomer);
        CustomerProfile customer=business.getCustomerDirectory().findCustomer(selectedCustomer);
        ArrayList<SolutionOrder>  solutions=business.getMasterSolutionOrderList().getSolutionorderlist();
        
        ArrayList<Product> selectedProducts = (ArrayList<Product>) tblOrder.getValueAt(selectedRow, 0);
        System.out.println("pro --"+selectedProducts);
        
        Market market = (Market) tblOrder.getValueAt(selectedRow, 1);
        Channel channel = (Channel) tblOrder.getValueAt(selectedRow, 2);
        Boolean check = false;

        MarketChannelAssignment mca = business.getMarketChannelComboCatalog().finMarketChannelCombo(market, channel);
        for(int i=0; i<mca.getSolutionofferlist().size(); i++){
            check = business.getSolutionOfferCatalog().compareProductLists(mca.getSolutionofferlist().get(i).getProducts(), selectedProducts);
            if(check){
                break;
            }
        }
        
        SolutionOffer solOffer = new SolutionOffer();
        if(check){
            solOffer = business.getSolutionOfferCatalog().findMatchingSolutionOffer(mca, selectedProducts);
        }
        System.out.println("sol offer got --"+solOffer.getProducts());
                        
        SolutionOrder foundSolutionOrder = business.getMasterSolutionOrderList().findSolutionOrderBySolutionOffer(solOffer);
        System.out.println("sol order --"+foundSolutionOrder);
        System.out.println("sol order --"+foundSolutionOrder.getCustomer().getCustomerId());
        System.out.println("sol order --"+foundSolutionOrder.getSelectedsolutionoffer().getProducts());

        System.out.println(foundSolutionOrder.getQuantity());

        int actualPrice = Integer.parseInt(txtAP.getText());
        if(actualPrice < solOffer.getFp() || actualPrice > solOffer.getCp()){
            JOptionPane.showMessageDialog(null, "Deal Price for the selected solution offer should be between: " + solOffer.getFp() + " and " + solOffer.getCp(), "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        foundSolutionOrder.setActualPrice(actualPrice);
        selectedSolutionOrders.add(foundSolutionOrder);
        
        // Populated table of final deal
        DefaultTableModel dtm=(DefaultTableModel)tblFinalOrder.getModel();
        dtm.setRowCount(0);
        
        for (SolutionOrder selectedOrder : selectedSolutionOrders) {
            Object[] row = new Object[6];
            row[0] = selectedOrder.getCustomer().getCustomerId();
            row[1] = selectedOrder.getSelectedsolutionoffer().getProducts();
            row[2] = selectedOrder.getQuantity();
            row[3] = selectedOrder.getSelectedsolutionoffer().getTp();
            row[4] = selectedOrder.getActualPrice();
            row[5] = selectedOrder.getActualPrice() * selectedOrder.getQuantity();
            dtm.addRow(row);
        }
        
        JOptionPane.showMessageDialog(null, "Purchased order!", "Information", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_btnConfirmActionPerformed

    private void tblOrderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOrderMousePressed
        // TODO add your handling code here:
        int selectedRow = tblOrder.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a solution offer to finalize the deal!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String selectedCustomer=(String) CustComboBox.getSelectedItem();
        System.out.println("Customername--"+selectedCustomer);
        CustomerProfile customer=business.getCustomerDirectory().findCustomer(selectedCustomer);
        ArrayList<SolutionOrder>  solutions=business.getMasterSolutionOrderList().getSolutionorderlist();
        
        ArrayList<Product> selectedProducts = (ArrayList<Product>) tblOrder.getValueAt(selectedRow, 0);
        System.out.println("pro --"+selectedProducts);
        
        Market market = (Market) tblOrder.getValueAt(selectedRow, 1);
        Channel channel = (Channel) tblOrder.getValueAt(selectedRow, 2);
        Boolean check = false;

        MarketChannelAssignment mca = business.getMarketChannelComboCatalog().finMarketChannelCombo(market, channel);
        for(int i=0; i<mca.getSolutionofferlist().size(); i++){
            check = business.getSolutionOfferCatalog().compareProductLists(mca.getSolutionofferlist().get(i).getProducts(), selectedProducts);
            if(check){
                break;
            }
        }
        
        SolutionOffer solOffer = new SolutionOffer();
        if(check){
            solOffer = business.getSolutionOfferCatalog().findMatchingSolutionOffer(mca, selectedProducts);
            txtAP.setText(Integer.toString(solOffer.getTp()));
        }
        
        SolutionOrder foundSolutionOrder = business.getMasterSolutionOrderList().findSolutionOrderBySolutionOffer(solOffer);

        System.out.println("sol order in order mouse pressed--"+foundSolutionOrder);
    }//GEN-LAST:event_tblOrderMousePressed

    private void txtAPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAPActionPerformed
    
    private void populateCombo() {
        CustComboBox.removeAllItems();
        ArrayList<CustomerProfile> custList = salesperson.getCustomers();
        for(CustomerProfile c: custList){
                CustComboBox.addItem(c.getCustomerId());
        }
    }
    
    private void populateOrderTable() {
        String selectedCustomer=(String) CustComboBox.getSelectedItem();
        System.out.println("Customername--"+selectedCustomer);
        CustomerProfile customer=business.getCustomerDirectory().findCustomer(selectedCustomer);
        ArrayList<SolutionOrder>  solutions=business.getMasterSolutionOrderList().getSolutionorderlist();
        System.out.println(solutions);
                System.out.println(salesperson);

//        for(SolutionOrder so: solutions){
//            System.out.println(so.getCustomer().getCustomerId() + "====" + so.getSalesperson().getPerson().getPersonId());
//        }
//        System.out.println("Solution order list newwww ---"+solutions.get(8).getSalesperson().getPerson().getPersonId()+"---"+solutions.get(8).getCustomer().getCustomerId()+"---"+salesperson.getPerson().getPersonId()+selectedCustomer);
 
        DefaultTableModel dtm=(DefaultTableModel)tblOrder.getModel();
        dtm.setRowCount(0);
        for(SolutionOrder sol : solutions)
        {
            if(sol.getCustomer()==null || sol.getSalesperson()==null )
            {
              continue;
            }
            if(sol.getCustomer().getCustomerId()==selectedCustomer && sol.getSalesperson().getPerson().getPersonId()==salesperson.getPerson().getPersonId())
            {
                //System.out.println("Trueeee");
                Object[] row=new Object[7];
                row[0] = sol.getSelectedsolutionoffer().getProducts();
                row[1] = sol.getMarketChannelCombo().getMarket();
                row[2]=sol.getMarketChannelCombo().getChannel();
                row[3] = sol.getSelectedsolutionoffer().getFp();
                row[4] = sol.getSelectedsolutionoffer().getCp();
                row[5]=sol.getSelectedsolutionoffer().getTp();
                row[6] = sol.getQuantity();
                dtm.addRow(row); 
            }
        }      
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CustComboBox;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblFinalOrder;
    private javax.swing.JTable tblOrder;
    private javax.swing.JTextField txtAP;
    // End of variables declaration//GEN-END:variables
}
