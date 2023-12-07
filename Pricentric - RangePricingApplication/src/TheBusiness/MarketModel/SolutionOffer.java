/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.MarketModel;

import java.util.ArrayList;
import TheBusiness.ProductManagement.Product;
import TheBusiness.SolutionOrders.SolutionOrder;

/**
 *
 * @author kal bugrara
 */
public class SolutionOffer {
    ArrayList<Product> products;
    int price;//floor, ceiling, and target ideas
    int fp;
    int cp;
    int tp;
    String ad;
    MarketChannelAssignment marketchannelcomb;
    ArrayList<SolutionOrder> solutionorders;
    
    public SolutionOffer(MarketChannelAssignment m){
        marketchannelcomb = m;
        products = new ArrayList();
        solutionorders = new ArrayList();
        m.addSolutionOffer(this); 
       
    } 

    public SolutionOffer() {
    }

    public SolutionOffer(int fp, int cp, int tp, MarketChannelAssignment m) {
        this.fp = fp;
        this.cp = cp;
        this.tp = tp;
        marketchannelcomb = m;
        products = new ArrayList();
        solutionorders = new ArrayList();
        m.addSolutionOffer(this);
    }
    
    public void addProduct(Product p){
        products.add(p);
        calculateOfferPrices();
        
    }
    public void setTotalPrice(int p){
        price = p;
        
    }
    public int getSolutionPrice(){
        return price;
    }
    
    public int getRevenues(){
        int sum = 0;
        for(SolutionOrder so: solutionorders){
            sum = sum + so.getSolutionPrice();
            
        }
        return sum;
    }
    
    public void addSolutionOrder(SolutionOrder so){
        solutionorders.add(so);
    }
    // this will allow one to retrieve all offers meant for this market/channel combo
    public boolean isSolutionOfferMatchMarketChannel(MarketChannelAssignment mca){
        
        if (marketchannelcomb==mca) return true;
        else return false;
    }
    public String getAd(){
        return ad;
    }
    public void setAd(String a){ //this an amazing solution for people like
        ad = a;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public MarketChannelAssignment getMarketchannelcomb() {
        return marketchannelcomb;
    }

    public int getFp() {
        return fp;
    }

    public void setFp(int fp) {
        this.fp = fp;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public int getTp() {
        return tp;
    }

    public void setTp(int tp) {
        this.tp = tp;
    }
    public void calculateOfferPrices() {
        int totalFloorPrice = 0;
        int totalCeilingPrice = 0;
        int totalTargetPrice = 0;
 
        for (Product product : products) {
            totalFloorPrice += product.getFloorPrice();
            totalCeilingPrice += product.getCeilingPrice();
            totalTargetPrice += product.getTargetPrice();
        }
 
        // Set the calculated values to the offer
        setFp(totalFloorPrice);
        setCp(totalCeilingPrice);
        setTp(totalTargetPrice);
    }

    
}
