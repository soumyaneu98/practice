/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MarketAnalytics;

import TheBusiness.MarketModel.Market;
import TheBusiness.SolutionOrders.SolutionOrder;
import TheBusiness.Business.Business;
import TheBusiness.CustomerManagement.CustomerProfile;
import TheBusiness.MarketModel.MarketChannelAssignment;
import TheBusiness.SalesManagement.SalesPersonProfile;
import java.util.ArrayList;
import java.util.Collections;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author HP
 */
public class AnalysisHelper {
    
    Business business;

    public AnalysisHelper(Business b) {
        business = b;
        System.out.println("Report generation");
        System.out.println();

    }

    // REPORT 1: TOP 3 BEST NEGOTIATED SOLUTIONS BY MARKET SEGMENTS
    
    public Map<Market, List<SolutionOrder>> getTopNegotiatedSolutions() {
        Map<Market, List<SolutionOrder>> topSolutionsByMarket = new HashMap<>();

        // Iterate over the solution order list
        for (SolutionOrder solutionOrder : business.getMasterSolutionOrderList().getSolutionorderlist()) {
            MarketChannelAssignment marketChannelCombo = solutionOrder.getMarketChannelCombo();
            Market market = marketChannelCombo.getMarket();

            // Check if the solution was negotiated (sold above target)
            if (solutionOrder.getActualPrice() > solutionOrder.getSelectedsolutionoffer().getTp()) {
                // Check if the market is already in the map
                if (topSolutionsByMarket.containsKey(market)) {
                    // Update the list of top solutions for the market
                    List<SolutionOrder> topSolutions = topSolutionsByMarket.get(market);
                    updateTopSolutionsList(topSolutions, solutionOrder);
                } else {
                    // If the market is not in the map, create a new list with the current solution
                    List<SolutionOrder> topSolutions = initializeTopSolutionsList(solutionOrder);
                    topSolutionsByMarket.put(market, topSolutions);
                }
            }
        }

        return topSolutionsByMarket;
    }

    // Helper method to update the list of top solutions
    private void updateTopSolutionsList(List<SolutionOrder> topSolutions, SolutionOrder newSolution) {
        // Add the new solution
        topSolutions.add(newSolution);

        // Sort the list in descending order based on solution price
        Collections.sort(topSolutions, (a, b) -> Integer.compare(b.getActualPrice(), a.getActualPrice()));

        // Keep only the top 3 solutions

        if (topSolutions.size() > 3) {
            topSolutions.subList(3, topSolutions.size()).clear();
        }
    }

    // Helper method to initialize the list of top solutions
    private List<SolutionOrder> initializeTopSolutionsList(SolutionOrder initialSolution) {
        List<SolutionOrder> topSolutions = new ArrayList<>();
        topSolutions.add(initialSolution);
        return topSolutions;
    }
    
    // Display top 3 negotiated solutions
    public void printTopNegotiatedSolutions() {
        System.out.println("\n\nREPORT 1:");

        Map<Market, List<SolutionOrder>> topSolutionsByMarket = getTopNegotiatedSolutions();
 
        // Iterate over the map to print the results
        for (Map.Entry<Market, List<SolutionOrder>> entry : topSolutionsByMarket.entrySet()) {
            Market market = entry.getKey();
            List<SolutionOrder> topSolutions = entry.getValue();
 
            System.out.println("Market: " + market.getName());
            System.out.println("Top Negotiated Solutions:");
 
            for (SolutionOrder solutionOrder : topSolutions) {
                System.out.println("  Solution order products : " + solutionOrder.getSelectedsolutionoffer().getProducts());
                System.out.println("  Solution Price: " + solutionOrder.getActualPrice());
                
 
                System.out.println(); // Separate entries with a blank line
            }
 
            System.out.println("-------------------------------");
        }
    }
    
    // REPORT 2: TOP 3 BEST CUSTOMERS (BUY ABOVE TARGET PRICE)
    public void printTopCustomers() {
        Map<CustomerProfile, Integer> customerTotalSpending = new HashMap<>();

        // Iterate over the solution order list
        for (SolutionOrder solutionOrder : business.getMasterSolutionOrderList().getSolutionorderlist()) {
            CustomerProfile customer = solutionOrder.getCustomer();
            int solutionPrice = solutionOrder.getActualPrice();
            int targetPrice = solutionOrder.getSelectedsolutionoffer().getTp();

            // Check if the customer's spending is above the target price
            if (solutionPrice > targetPrice) {
                // Update the total spending for the customer
                customerTotalSpending.put(customer, customerTotalSpending.getOrDefault(customer, 0) + solutionPrice);
            }
        }

        // Sort customers by total spending in descending order
        List<Map.Entry<CustomerProfile, Integer>> sortedCustomers = new ArrayList<>(customerTotalSpending.entrySet());
        sortedCustomers.sort((a, b) -> Integer.compare(b.getValue(), a.getValue()));

        // Print the top 3 customers
        System.out.println("Top 3 Best Customers (Above Target Price):");
        for (int i = 0; i < Math.min(3, sortedCustomers.size()); i++) {
            CustomerProfile customer = sortedCustomers.get(i).getKey();
            int totalSpending = sortedCustomers.get(i).getValue();

            System.out.println("Customer ID: " + customer.getCustomerId());
            System.out.println("Total Spending: " + totalSpending);

            System.out.println(); // Separate entries with a blank line
            System.out.println("-------------------------------");

        }
    }
    
    // REPORT 3: TOP 3 BEST CUSTOMERS (BUY ABOVE TARGET PRICE)
    public void printTopSalespeople() {
        Map<SalesPersonProfile, Integer> salespersonTotalSales = new HashMap<>();

        // Iterate over the solution order list
        for (SolutionOrder solutionOrder : business.getMasterSolutionOrderList().getSolutionorderlist()) {
            SalesPersonProfile salesperson = solutionOrder.getSalesperson();
            int solutionPrice = solutionOrder.getActualPrice();
            int targetPrice = solutionOrder.getSelectedsolutionoffer().getTp();

            // Check if the solution was sold above the target price
            if (solutionPrice > targetPrice) {
                // Update the total sales for the salesperson
                salespersonTotalSales.put(salesperson, salespersonTotalSales.getOrDefault(salesperson, 0) + solutionPrice);
            }
        }

        // Sort salespeople by total sales in descending order
        List<Map.Entry<SalesPersonProfile, Integer>> sortedSalespeople = new ArrayList<>(salespersonTotalSales.entrySet());
        sortedSalespeople.sort((a, b) -> Integer.compare(b.getValue(), a.getValue()));

        // Print the top 3 salespeople
        System.out.println("Top 3 Best Salespeople (Sell Higher Than Target):");
        for (int i = 0; i < Math.min(3, sortedSalespeople.size()); i++) {
            SalesPersonProfile salesperson = sortedSalespeople.get(i).getKey();
            int totalSales = sortedSalespeople.get(i).getValue();

            System.out.println("Salesperson ID: " + salesperson.getPerson().getPersonId());
            System.out.println("Total Sales: " + totalSales);
            System.out.println(); // Separate entries with a blank line
            System.out.println("-------------------------------");

        }
    }
    
    // REPORT 4: TOTAL MARGINAL REVENUE BROKEN DOWN BY MARKET
    public Map<Market, Integer> getTotalMarginalRevenueByMarket() {
        Map<Market, Integer> marginalRevenueByMarket = new HashMap<>();

        // Iterate over the solution order list
        for (SolutionOrder solutionOrder : business.getMasterSolutionOrderList().getSolutionorderlist()) {
            MarketChannelAssignment marketChannelCombo = solutionOrder.getMarketChannelCombo();
            Market market = marketChannelCombo.getMarket();
            int solutionPrice = solutionOrder.getActualPrice();
            int targetPrice = solutionOrder.getSelectedsolutionoffer().getTp();

            // Calculate marginal revenue (actual minus target)
            int marginalRevenue = solutionPrice - targetPrice;

            // Update the total marginal revenue for the market
            marginalRevenueByMarket.put(market, marginalRevenueByMarket.getOrDefault(market, 0) + marginalRevenue);
        }

        return marginalRevenueByMarket;
    }
    
    public void printTotalMarginalRevenueByMarket() {
        Map<Market, Integer> marginalRevenueByMarket = getTotalMarginalRevenueByMarket();

        System.out.println("Total Marginal Revenue by Market:");
        for (Map.Entry<Market, Integer> entry : marginalRevenueByMarket.entrySet()) {
            Market market = entry.getKey();
            int totalMarginalRevenue = entry.getValue();

            System.out.println("Market: " + market.getName() + ", Total Marginal Revenue: " + totalMarginalRevenue);
            System.out.println("-------------------------------");

        }
    }
    
    // REPORT 5: DETERMINE IF THE COMPANY IS PRICING ITS SOLUTIONS CORRECTLY
    public void analyzePricing() {
        System.out.println("Pricing Strategy: ");

        List<SolutionOrder> solutionOrders = business.getMasterSolutionOrderList().getSolutionorderlist();

        int aboveTargetCount = 0;
        int belowTargetCount = 0;

        for (SolutionOrder solutionOrder : solutionOrders) {
            int actualPrice = solutionOrder.getActualPrice();
            int targetPrice = solutionOrder.getSelectedsolutionoffer().getTp();

            // Determine if the solution is priced correctly
            if (actualPrice < targetPrice) {
                belowTargetCount++;
            } 
            
            if (actualPrice > targetPrice) {
                aboveTargetCount++;
            } 
        }

        // Report on counts
        System.out.println("Number of solutions sold above target: " + aboveTargetCount);
        System.out.println("Number of solutions sold below target: " + belowTargetCount);

        // Determine if pricing is good or needs modification
        if (aboveTargetCount > belowTargetCount) {
            System.out.println("Pricing is good. Keep current pricing strategy.");
        } else {
            System.out.println("Pricing needs modification. Consider adjusting price ranges.");
        }
    }

}
