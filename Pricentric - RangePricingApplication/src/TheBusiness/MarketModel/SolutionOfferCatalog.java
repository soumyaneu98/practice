/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.MarketModel;

import TheBusiness.ProductManagement.Product;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class SolutionOfferCatalog {

    ArrayList<SolutionOffer> solutionoffers;

    public SolutionOfferCatalog() {
        solutionoffers = new ArrayList();
    }
    
    public SolutionOffer newSolutionOffer(MarketChannelAssignment mca){
        
        SolutionOffer so = new SolutionOffer(mca);
        solutionoffers.add(so);
        
        return so;
    }
    
    

    //return all solution offers that match m/c combination
    public ArrayList<SolutionOffer> findSolutionsForMarketChannelCombo(MarketChannelAssignment mcc) {
        ArrayList<SolutionOffer> foundsolutions = new ArrayList();

        for (SolutionOffer so : solutionoffers) {

            if (so.isSolutionOfferMatchMarketChannel(mcc) == true) {
                foundsolutions.add(so);
            }
            //find all solution offers available in the market/channel combin
        }
        return foundsolutions;

    }

    public ArrayList<SolutionOffer> getSolutionoffers() {
        return solutionoffers;
    }

    // Method to find a single solution offer based on a criterion
    public SolutionOffer findSingleSolutionOffer(MarketChannelAssignment mcc, int targetPrice) {
        for (SolutionOffer so : solutionoffers) {
            if (so.isSolutionOfferMatchMarketChannel(mcc) && so.getTp() == targetPrice) {
                return so;
            }
        }
        return null; // If no matching solution offer is found
    }
    
        
    public SolutionOffer findMatchingSolutionOffer(MarketChannelAssignment mca, ArrayList<Product> selectedProducts) {
        for (SolutionOffer solutionOffer : mca.getSolutionofferlist()) {
            if (compareProductLists(solutionOffer.getProducts(), selectedProducts)) {
                return solutionOffer;
            }
        }
        return null; // Return null if no match is found
    }
    
    public static boolean compareProductLists(ArrayList<Product> list1, ArrayList<Product> list2) {
        // Check if the sizes are equal

        if (list1.size() != list2.size()) {
            return false;
        }

        // Check if each element is equal
        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                return false;
            }
        }

        return true;
    }
}
