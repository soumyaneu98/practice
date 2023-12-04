/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.SolutionOrders;

import TheBusiness.CustomerManagement.CustomerProfile;
import TheBusiness.MarketModel.MarketChannelAssignment;
import TheBusiness.MarketModel.SolutionOffer;
import TheBusiness.SalesManagement.SalesPersonProfile;

/**
 *
 * @author kal bugrara
 */

public class SolutionOrder {
    
    SalesPersonProfile salesperson;
    CustomerProfile customer;
    int quantity;
    int actualPrice;
    SolutionOffer selectedsolutionoffer;
  //  CustomerProfile customerprofile;
    MarketChannelAssignment marketChannelAssignment; 
    public SolutionOrder(SolutionOffer so,  MarketChannelAssignment mca){
        selectedsolutionoffer = so;
        marketChannelAssignment = mca;

    }
    public SolutionOrder(SolutionOffer so,  MarketChannelAssignment mca, SalesPersonProfile sp, CustomerProfile cp, int quantity){
        selectedsolutionoffer = so;
        marketChannelAssignment = mca;
        salesperson = sp;
        customer = cp;
        this.quantity=quantity;

    }
    public SalesPersonProfile getSalesperson() {
        return salesperson;
    }

    public CustomerProfile getCustomer() {
        return customer;
    }
    
    public int getSolutionPrice(){
        return selectedsolutionoffer.getSolutionPrice();
    }
    
    public int getSolutionTargetPrice(){
        return selectedsolutionoffer.getTp();
    }
    
    public MarketChannelAssignment getMarketChannelCombo(){
        
        return marketChannelAssignment;
                
    }

    public SolutionOffer getSelectedsolutionoffer() {
        return selectedsolutionoffer;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public int getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(int actualPrice) {
        this.actualPrice = actualPrice;
    }
    
   
}
