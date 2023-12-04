/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.SolutionOrders;

import TheBusiness.CustomerManagement.CustomerProfile;
import TheBusiness.MarketModel.Channel;
import TheBusiness.MarketModel.Market;
import TheBusiness.MarketModel.MarketChannelAssignment;
import TheBusiness.MarketModel.SolutionOffer;
import TheBusiness.SalesManagement.SalesPersonProfile;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class MasterSolutionOrderList {
        ArrayList<SolutionOrder> solutionorderlist;

    public MasterSolutionOrderList() {
        solutionorderlist = new ArrayList();
    }

//    public SolutionOrder newSolutionOrder(SolutionOffer soloffer,  MarketChannelAssignment mca) {
//
//        SolutionOrder so = new SolutionOrder(soloffer,   mca);
//        solutionorderlist.add(so);
//        soloffer.addSolutionOrder(so);
//        return so;
//
//    }
    
    public SolutionOrder newSolutionOrderwithqty(SolutionOffer soloffer,  MarketChannelAssignment mca, SalesPersonProfile sp, CustomerProfile cp, int qty) {

        SolutionOrder so = new SolutionOrder(soloffer, mca, sp, cp, qty);
        solutionorderlist.add(so);
        soloffer.addSolutionOrder(so);
        
        System.out.println("Placed------"+cp+"---"+sp.getPerson().getPersonId());
        System.out.println(solutionorderlist.size());
//        System.out.println("Solution order list ---"+solutionorderlist.get(8).getSalesperson().getPerson().getPersonId());
        return so;

    }

    public int getRevenueByMarket(Market m) {
        int sum = 0;
        for(SolutionOrder so: solutionorderlist){
         
         MarketChannelAssignment mcc =   so.getMarketChannelCombo();
         if(mcc.getMarket()==m) sum = sum +so.getSolutionPrice();
           
        }

        return sum;

    }
    public int getRevenueByChannel(Channel c) {
        int sum = 0;
        for(SolutionOrder so: solutionorderlist){
         
         MarketChannelAssignment mcc =   so.getMarketChannelCombo();
         if(mcc.getChannel()==c) sum = sum +so.getSolutionPrice();
           
        }

        return sum;

    }
    public int getRevenueByMarketChannelCombo(MarketChannelAssignment mca) {
        int sum = 0;
        for(SolutionOrder so: solutionorderlist){
         
         MarketChannelAssignment mcc =   so.getMarketChannelCombo();
         if(mcc==mca) sum = sum +so.getSolutionPrice(); 
           
        }
        return sum;

    }

    // New method to get solution orders by customer
//    public ArrayList<SolutionOrder> getSolutionOrdersByCustomer(CustomerProfile customer) {
//        ArrayList<SolutionOrder> customerSolutionOrders = new ArrayList<>();
//        for (SolutionOrder solutionOrder : customerSolutionOrders) {
//            if (solutionOrder.getCustomer() == customer) {
//                customerSolutionOrders.add(solutionOrder);
//            }
//        }
//        return customerSolutionOrders;
//    }

    public ArrayList<SolutionOrder> getSolutionorderlist() {
        return solutionorderlist;
    }
    
    // Function to find a SolutionOrder based on a given SolutionOffer
    public SolutionOrder findSolutionOrderBySolutionOffer(SolutionOffer solutionOffer) {
        for (SolutionOrder solutionOrder : solutionorderlist) {
            if (solutionOrder.getSelectedsolutionoffer() == solutionOffer) {
                return solutionOrder;
            }
        }
        return null; // Return null if no match is found
    }
}
