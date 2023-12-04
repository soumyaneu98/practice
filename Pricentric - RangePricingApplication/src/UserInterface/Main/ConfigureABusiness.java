/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Main;

import MarketingManagement.MarketingPersonDirectory;
import MarketingManagement.MarketingPersonProfile;
import TheBusiness.Business.Business;
import TheBusiness.CustomerManagement.CustomerDirectory;
import TheBusiness.CustomerManagement.CustomerProfile;
import TheBusiness.MarketModel.Channel;
import TheBusiness.MarketModel.ChannelCatalog;
import TheBusiness.MarketModel.Market;
import TheBusiness.MarketModel.MarketCatalog;
import TheBusiness.MarketModel.MarketChannelAssignment;
import TheBusiness.MarketModel.MarketChannelComboCatalog;
import TheBusiness.MarketModel.SolutionOffer;
import TheBusiness.MarketModel.SolutionOfferCatalog;
import TheBusiness.OrderManagement.MasterOrderList;
import TheBusiness.OrderManagement.Order;
import TheBusiness.OrderManagement.OrderItem;
import TheBusiness.Personnel.EmployeeDirectory;
import TheBusiness.Personnel.EmployeeProfile;
import TheBusiness.Personnel.Person;
import TheBusiness.Personnel.PersonDirectory;
import TheBusiness.ProductManagement.Product;
import TheBusiness.ProductManagement.ProductCatalog;
import TheBusiness.SalesManagement.SalesPersonDirectory;
import TheBusiness.SalesManagement.SalesPersonProfile;
import TheBusiness.SolutionOrders.MasterSolutionOrderList;
import TheBusiness.SolutionOrders.SolutionOrder;
import TheBusiness.Supplier.Supplier;
import TheBusiness.Supplier.SupplierDirectory;
import TheBusiness.UserAccountManagement.UserAccount;
import TheBusiness.UserAccountManagement.UserAccountDirectory;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author kal bugrara
 */
class ConfigureABusiness {

    static Business initialize() {
        Business business = new Business("Xerox");
        SupplierDirectory suplierdirectory = business.getSupplierDirectory();

        String csvFilePath_LenovoProducts = "Lenovo_products.csv";
          
            try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath_LenovoProducts))) {
            String line;
            SupplierDirectory supplierDirectory = business.getSupplierDirectory();
            // Assume the supplier name is "Lenovo" for this example

            Supplier supplier1 = suplierdirectory.newSupplier("Lenovo");     
            ProductCatalog productCatalog = supplier1.getProductCatalog();
 
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");

                    if (data.length >= 4) {
                        String productName = data[0];
                        int productFloorPrice = Integer.parseInt(data[1]);
                        int productCeilingFloorPrice = Integer.parseInt(data[2]);
                        int productTargetPrice = Integer.parseInt(data[3]);

                        productCatalog.newProduct(productName, productFloorPrice, productCeilingFloorPrice, productTargetPrice);
                    }
                }
                System.out.println("Products of Lenovo ----------- "+ productCatalog.getProductList());

            } catch (IOException e) {
                e.printStackTrace();
            }

           String csvFilePath_EpsonProducts = "Epson_products.csv";
          
            try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath_EpsonProducts))) {
            String line;
            SupplierDirectory supplierDirectory = business.getSupplierDirectory();
            Supplier supplier2 = suplierdirectory.newSupplier("Epson");     
            ProductCatalog productCatalog = supplier2.getProductCatalog();
 
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");

                    if (data.length >= 4) {
                        String productName = data[0];
                        int productFloorPrice = Integer.parseInt(data[1]);
                        int productCeilingFloorPrice = Integer.parseInt(data[2]);
                        int productTargetPrice = Integer.parseInt(data[3]);

                        productCatalog.newProduct(productName, productFloorPrice, productCeilingFloorPrice, productTargetPrice);

                    }
                }
                System.out.println("Products of Epson ----------- "+ productCatalog.getProductList());

            } catch (IOException e) {
                e.printStackTrace();
            }

    // Create Persons
        PersonDirectory persondirectory = business.getPersonDirectory();
        CustomerDirectory customerDirectory = business.getCustomerDirectory();
        
    // Person representing sales organization     line 112   
        Person pricentricsalesperson001 = persondirectory.newPerson("Pricentric sales 1");
        Person pricentricsalesperson002 = persondirectory.newPerson("Pricentric sales 2");
        Person pricentricsalesperson003 = persondirectory.newPerson("Pricentric sales 3");
        Person pricentricsalesperson004 = persondirectory.newPerson("Pricentric sales 4");
        
        
        Person xeroxmarketingperson001 = persondirectory.newPerson("Xerox marketing");
        Person xeroxadminperson001 = persondirectory.newPerson("Xerox admin");

        String csvFilePath_customer = "Customers.csv";          
          
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath_customer))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split the line using a comma
                String[] data = line.split(",");
 
                // Create an instance of your class and populate attributes
                Person person = new Person(data[0]);
                CustomerProfile customerProfile = customerDirectory.newCustomerProfile(person);
                // Set other attributes accordingly
 
                // Process or store the object as needed
//                System.out.println("Person created ----------- "+ person);
                System.out.println("Customer profile created for ----------- "+ customerProfile);
            }
        }
           catch (IOException e) {
            e.printStackTrace();
        }

    // Create Sales people 
        SalesPersonDirectory salespersondirectory = business.getSalesPersonDirectory();
        SalesPersonProfile salespersonprofile1 = salespersondirectory.newSalesPersonProfile(pricentricsalesperson001);
        SalesPersonProfile salespersonprofile2 = salespersondirectory.newSalesPersonProfile(pricentricsalesperson002);
        SalesPersonProfile salespersonprofile3 = salespersondirectory.newSalesPersonProfile(pricentricsalesperson003);
        SalesPersonProfile salespersonprofile4 = salespersondirectory.newSalesPersonProfile(pricentricsalesperson004);

    // Create Marketing people
        MarketingPersonDirectory marketingpersondirectory = business.getMarketingPersonDirectory();
        MarketingPersonProfile marketingpersonprofile0 = marketingpersondirectory.newMarketingPersonProfile(xeroxmarketingperson001);

    // Create Admins to manage the business
        EmployeeDirectory employeedirectory = business.getEmployeeDirectory();
        EmployeeProfile employeeprofile0 = employeedirectory.newEmployeeProfile(xeroxadminperson001);
    
    // Create User accounts that link to specific profiles
        UserAccountDirectory uadirectory = business.getUserAccountDirectory();
        UserAccount uas1 = uadirectory.newUserAccount(salespersonprofile1, "Sales1", "XXXX");
        UserAccount uas2 = uadirectory.newUserAccount(salespersonprofile2, "Sales2", "XXXX");
        UserAccount uas3 = uadirectory.newUserAccount(salespersonprofile3, "Sales3", "XXXX");
        UserAccount uas4 = uadirectory.newUserAccount(salespersonprofile4, "Sales4", "XXXX");/// order products for one of the customers and performed by a sales person
        UserAccount ua2 = uadirectory.newUserAccount(marketingpersonprofile0, "Marketing", "XXXX"); /// order products for one of the customers and performed by a sales person
        UserAccount ua3 = uadirectory.newUserAccount(employeeprofile0, "Admin", "XXXX"); /// order products for one of the customers and performed by a sales person

        System.out.println("User account created for - " + uas1);
        System.out.println("User account created for - " + uas2);
        System.out.println("User account created for - " + uas3);
        System.out.println("User account created for - " + uas4);
        System.out.println("User account created for - " + ua2);
        System.out.println("User account created for - " + ua3);
        
        System.out.println();

    // Create user account for customers
        for (CustomerProfile cp : business.getCustomerDirectory().getCustomerlist()) {
            uadirectory.newUserAccount(cp, cp.getCustomerId(), "XXXX");
        }
        
    // Process Orders on behalf of sales person and customer
        MasterOrderList masterorderlist = business.getMasterOrderList();
        Order order1 = masterorderlist.newOrder(customerDirectory.getCustomerlist().get(0), salespersonprofile1);
        System.out.println("1st Customer ---- "+ customerDirectory.getCustomerlist().get(0));
          
        String csvFilePath_order1 = "order1.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath_order1))) {
        String line;
        //SupplierDirectory supplierDirectory = business.getSupplierDirectory();
        Supplier supplier1 = suplierdirectory.findSupplier("Lenovo"); 
        ProductCatalog productCatalog = supplier1.getProductCatalog();

//        System.out.println("found supplier ---"+ supplier1.getName());
        System.out.println("Product catalog of Lenovo --"+ productCatalog.getProductList());
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");

            if (data.length >= 3) {
                String productName = data[0];
                int actualPrice = Integer.parseInt(data[1]);
                int quantity = Integer.parseInt(data[2]);

                Product prod = productCatalog.searchProduct(productName);

                // Assume the supplier name is "Lenovo" for this example

                OrderItem oi = order1.newOrderItem(prod, actualPrice, quantity);
                System.out.println("Order item for lenovo's product ----------- "+ oi);

                }
            }
        } catch (IOException e) {
        e.printStackTrace();
        }

    // Second customer is placing order for Lenovo supplier
    
        Order order2 = masterorderlist.newOrder(customerDirectory.getCustomerlist().get(1), salespersonprofile1);
        System.out.println("2nd Customer ---- "+ customerDirectory.getCustomerlist().get(1));
//            String csvFilePath_order2 = "order2.csv";
          
            try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath_order1))) {
            String line;
            //SupplierDirectory supplierDirectory = business.getSupplierDirectory();
            Supplier supplier1 = suplierdirectory.findSupplier("Lenovo"); 
            ProductCatalog productCatalog = supplier1.getProductCatalog();
 
            System.out.println("Product catalog of Lenovo --"+ productCatalog.getProductList());
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
 
                if (data.length >= 3) {
                    String productName = data[0];
                    int actualPrice = Integer.parseInt(data[1]);
                    int quantity = Integer.parseInt(data[2]);
                    
                    Product prod = productCatalog.searchProduct(productName);
//                    System.out.println("found product ---"+ prod);
                     
                    // Assume the supplier name is "Epson" for this example
                    
                    OrderItem oi = order2.newOrderItem(prod, actualPrice, quantity);
                    System.out.println("Order item for lenovo's product ----------- "+ oi);
                
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
            
        //=============== Define markets and channels...
        System.out.println();
        MarketCatalog mc = business.getMarketCatalog();
        
        String csvFilePath_market = "Market.csv";
          
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath_market))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                i++;
                // Split the line using a comma
                String[] data = line.split(",");
 
                // Create an instance of your class and populate attributes
                Market market = mc.newMarket(data[0]);
 
                // Process or store the object as needed
                System.out.println("Market" + i + " --- "+ market);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        ChannelCatalog channelCatalog = business.getChannelCatalog();
        String csvFilePath_channel = "Channel.csv";
          
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath_channel))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                i++;
                // Split the line using a comma
                String[] data = line.split(",");
 
                // Create an instance of your class and populate attributes
                Channel channel = channelCatalog.newChannel(data[0]);
 
                // Process or store the object as needed
                System.out.println("Channel" + i + " --- "+ channel);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Associating customers with market
        
        System.out.println();
        
        ArrayList<CustomerProfile> customerList = business.getCustomerDirectory().getCustomerlist();
        ArrayList<Market> marketsList = business.getMarketCatalog().getMarkets();
       
        Random randomIndex = new Random();

        for (CustomerProfile customer : customerList) {
            // Initialize the custMList for each customer
            ArrayList<Market> custMList = new ArrayList<>();

            // Generate and add the first random market
            int rand1 = randomIndex.nextInt(marketsList.size());
            Market market1 = marketsList.get(rand1);
            custMList.add(market1);
            
            // Generate and add the second random market (make sure it's different from the first)
//            int rand2;
//            do {
//                rand2 = randomIndex.nextInt(marketsList.size());
//            } while (rand2 == rand1);
//            Market market2 = marketsList.get(rand2);
//            custMList.add(market2);
 
            // Set the updated custMList to the customer
            customer.setMarkets(custMList);
        }

        for (CustomerProfile customer : customerList){
            System.out.println("--- Customer " + customer.getCustomerId()+" is assigned to the markets --- "+customer.getMarkets());
        }
        
        // Assigning valid channel for Market
        
        // Assuming you have already populated your MarketCatalog and ChannelCatalog from CSV files
        MarketCatalog marketCat = business.getMarketCatalog();
        ChannelCatalog channelCat = business.getChannelCatalog();

        // Retrieve markets from the MarketCatalog
        Market students = marketCat.findMarket("Students");
        Market dentists = marketCat.findMarket("Dentists");
        Market graduateStudents = marketCat.findMarket("Graduate Students");
        Market seniors = marketCat.findMarket("Seniors");
        Market professors = marketCat.findMarket("Professors");
        Market doctors = marketCat.findMarket("Doctors");
        Market accountants = marketCat.findMarket("Accountants");
        Market healthProfessionals = marketCat.findMarket("Health Professionals");
        Market itProfessionals = marketCat.findMarket("IT Professionals");
        Market gamers = marketCat.findMarket("Gamers");


        // Retrieve channels from the ChannelCatalog
        Channel tv = channelCat.findChannel("Tv");
        Channel magazine = channelCat.findChannel("Magazine");
        Channel conference = channelCat.findChannel("Conference");
        Channel linkedin = channelCat.findChannel("LinkedIn");
        Channel facebook = channelCat.findChannel("Facebook");
        Channel youtube = channelCat.findChannel("YouTube");
        Channel event = channelCat.findChannel("Event");
        Channel instagram = channelCat.findChannel("Instagram");
        Channel newsletter = channelCat.findChannel("Newsletter");
        Channel webinar = channelCat.findChannel("Webinar");


        // Add valid channels to markets
        seniors.addValidChannel(tv);
        seniors.addValidChannel(magazine);

        students.addValidChannel(event);
        students.addValidChannel(facebook);

        dentists.addValidChannel(conference);
        dentists.addValidChannel(newsletter);

        graduateStudents.addValidChannel(webinar);
        graduateStudents.addValidChannel(event);
        
        professors.addValidChannel(conference);
        professors.addValidChannel(facebook);
        
        doctors.addValidChannel(magazine);
        doctors.addValidChannel(newsletter);
        
        accountants.addValidChannel(linkedin);
        accountants.addValidChannel(tv);
        
        healthProfessionals.addValidChannel(youtube);
        healthProfessionals.addValidChannel(instagram);
        
        itProfessionals.addValidChannel(linkedin);
        itProfessionals.addValidChannel(instagram);
        
        gamers.addValidChannel(event);
        gamers.addValidChannel(youtube);
        
        System.out.println();
        // Print information about each market and its valid channels
        System.out.println("Seniors Valid Channels: " + seniors.getValidchannels());
        System.out.println("Students Valid Channels: " + students.getValidchannels());
        System.out.println("Dentists Valid Channels: " + dentists.getValidchannels());
        System.out.println("GraduateStudents Valid Channels: " + graduateStudents.getValidchannels());
        System.out.println("Professors Valid Channels: " + professors.getValidchannels());
        System.out.println("Doctors Valid Channels: " + doctors.getValidchannels());
        System.out.println("Accountants Valid Channels: " + accountants.getValidchannels());
        System.out.println("HealthProfessionals Valid Channels: " + healthProfessionals.getValidchannels());
        System.out.println("ItProfessionals Valid Channels: " + itProfessionals.getValidchannels());
        System.out.println("Gamers Valid Channels: " + gamers.getValidchannels());

        MarketChannelComboCatalog mccc = business.getMarketChannelComboCatalog();
        
        MarketChannelAssignment tvchannelseniorsmarket = mccc.newMarketChannelCombo(seniors, tv);
        MarketChannelAssignment magazinechannelseniorsmarket = mccc.newMarketChannelCombo(seniors, magazine);
        
        MarketChannelAssignment eventChannelsStudentsMarket = mccc.newMarketChannelCombo(students, event);
        MarketChannelAssignment facebookChannelsStudentsMarket = mccc.newMarketChannelCombo(students, facebook);

        MarketChannelAssignment conferenceChannelsDentistsMarket = mccc.newMarketChannelCombo(dentists, conference);
        MarketChannelAssignment newsletterChannelsDentistsMarket = mccc.newMarketChannelCombo(dentists, newsletter);

        MarketChannelAssignment webinarChannelsGraduateStudentsMarket = mccc.newMarketChannelCombo(graduateStudents, webinar);
        MarketChannelAssignment eventChannelsGraduateStudentsMarket = mccc.newMarketChannelCombo(graduateStudents, event);

        MarketChannelAssignment conferenceChannelsProfessorsMarket = mccc.newMarketChannelCombo(professors, conference);
        MarketChannelAssignment facebookChannelsProfessorsMarket = mccc.newMarketChannelCombo(professors, facebook);

        MarketChannelAssignment magazineChannelsDoctorsMarket = mccc.newMarketChannelCombo(doctors, magazine);
        MarketChannelAssignment newsletterChannelsDoctorsMarket = mccc.newMarketChannelCombo(doctors, newsletter);

        MarketChannelAssignment linkedinChannelsAccountantsMarket = mccc.newMarketChannelCombo(accountants, linkedin);
        MarketChannelAssignment tvChannelsAccountantsMarket = mccc.newMarketChannelCombo(accountants, tv);

        MarketChannelAssignment youtubeChannelsHealthProfessionalsMarket = mccc.newMarketChannelCombo(healthProfessionals, youtube);
        MarketChannelAssignment instagramChannelsHealthProfessionalsMarket = mccc.newMarketChannelCombo(healthProfessionals, instagram);

        MarketChannelAssignment linkedinChannelsITProfessionalsMarket = mccc.newMarketChannelCombo(itProfessionals, linkedin);
        MarketChannelAssignment instagramChannelsITProfessionalsMarket = mccc.newMarketChannelCombo(itProfessionals, instagram);

        MarketChannelAssignment eventChannelsGamersMarket = mccc.newMarketChannelCombo(gamers, event);
        MarketChannelAssignment youtubeChannelsGamersMarket = mccc.newMarketChannelCombo(gamers, youtube);

        System.out.println();
        
        // Print information about each market and channel combo
        System.out.println("Seniors Market and TV Channel Combo: " + tvchannelseniorsmarket.getMarket()+ "->" + tvchannelseniorsmarket.getChannel() );
        System.out.println("Seniors Market and Magazine Channel Combo: " + magazinechannelseniorsmarket.getMarket()+ "->" + magazinechannelseniorsmarket.getChannel() );
        
        System.out.println("Students Market and Events Channel Combo: " + eventChannelsStudentsMarket.getMarket()+ "->" + eventChannelsStudentsMarket.getChannel() );
        System.out.println("Students Market and Facebook Channel Combo: " + facebookChannelsStudentsMarket.getMarket()+ "->" + facebookChannelsStudentsMarket.getChannel() );

        System.out.println("Dentists Market and Conference Channel Combo: " + conferenceChannelsDentistsMarket.getMarket()+ "->" + conferenceChannelsDentistsMarket.getChannel() );
        System.out.println("Dentists Market and Newsletter Channel Combo: " + newsletterChannelsDentistsMarket.getMarket()+ "->" + newsletterChannelsDentistsMarket.getChannel() );
        
        System.out.println("Graduate Students Market and Webinar Channel Combo: " + webinarChannelsGraduateStudentsMarket.getMarket()+ "->" + webinarChannelsGraduateStudentsMarket.getChannel() );
        System.out.println("Graduate Students Market and Event Channel Combo: " + eventChannelsGraduateStudentsMarket.getMarket()+ "->" + eventChannelsGraduateStudentsMarket.getChannel() );

        System.out.println("Professors Market and Conference Channel Combo: " + conferenceChannelsProfessorsMarket.getMarket()+ "->" + conferenceChannelsProfessorsMarket.getChannel() );
        System.out.println("Professors Students Market and Facebook Channel Combo: " + facebookChannelsProfessorsMarket.getMarket()+ "->" + facebookChannelsProfessorsMarket.getChannel() );
        
        System.out.println("Doctors Market and Magazine Channel Combo: " + magazineChannelsDoctorsMarket.getMarket()+ "->" + magazineChannelsDoctorsMarket.getChannel() );
        System.out.println("Doctors Market and Newsletter Channel Combo: " + newsletterChannelsDoctorsMarket.getMarket()+ "->" + newsletterChannelsDoctorsMarket.getChannel() );

        System.out.println("Accountants Market and LinkedIn Channel Combo: " + linkedinChannelsAccountantsMarket.getMarket()+ "->" + linkedinChannelsAccountantsMarket.getChannel() );
        System.out.println("Accountants Market and Tv Channel Combo: " + tvChannelsAccountantsMarket.getMarket()+ "->" + tvChannelsAccountantsMarket.getChannel() );

        System.out.println("Health Professionals Market and Youtube Channel Combo: " + youtubeChannelsHealthProfessionalsMarket.getMarket()+ "->" + youtubeChannelsHealthProfessionalsMarket.getChannel() );
        System.out.println("Health Professionals Market and Instagram Channel Combo: " + instagramChannelsHealthProfessionalsMarket.getMarket()+ "->" + instagramChannelsHealthProfessionalsMarket.getChannel() );

        System.out.println("IT Professionals Market and LinkedIn Channel Combo: " + linkedinChannelsITProfessionalsMarket.getMarket()+ "->" + linkedinChannelsITProfessionalsMarket.getChannel() );
        System.out.println("IT Professionals Market and Instagram Channel Combo: " + instagramChannelsITProfessionalsMarket.getMarket()+ "->" + instagramChannelsITProfessionalsMarket.getChannel() );

        System.out.println("Gamers Market and Event Channel Combo: " + eventChannelsGamersMarket.getMarket()+ "->" + eventChannelsGamersMarket.getChannel() );
        System.out.println("Gamers Market and Youtube Channel Combo: " + youtubeChannelsGamersMarket.getMarket()+ "->" + youtubeChannelsGamersMarket.getChannel() );


        Supplier lenovoSup = suplierdirectory.findSupplier("Lenovo");     
        ProductCatalog lenovoProductCatalog = lenovoSup.getProductCatalog();
        
        Supplier epsonSup = suplierdirectory.findSupplier("Epson");     
        ProductCatalog epsonProductCatalog = epsonSup.getProductCatalog();
        
//        for (Product p : lenovoProductCatalog.getProductList()) {
//            System.out.println("Lenovo product list -- "+ p.getName());
//        }
//        
//        for (Product p : epsonProductCatalog.getProductList()) {
//            System.out.println("Epson product list -- "+ p.getName());
//        }

       
        // Create a Random object
        Random random = new Random();
        
        // LENOVO PRODUCTS

        // Generate a random index
        int randomIndex1 = random.nextInt(lenovoProductCatalog.getProductList().size());
        int randomIndex2;
        do {
            randomIndex2 = random.nextInt(lenovoProductCatalog.getProductList().size());
        } while (randomIndex2 == randomIndex1);

        int randomIndex3;
        do {
            randomIndex3 = random.nextInt(lenovoProductCatalog.getProductList().size());
        } while (randomIndex3 == randomIndex1 || randomIndex3 == randomIndex2);
        
        int randomIndex4;
        do {
            randomIndex4 = random.nextInt(lenovoProductCatalog.getProductList().size());
        } while (randomIndex4 == randomIndex1 || randomIndex4 == randomIndex2 || randomIndex4 == randomIndex3);


        // Get the products at the random indices
        Product lenovoProd1 = lenovoProductCatalog.getProductList().get(randomIndex1);
        Product lenovoProd2 = lenovoProductCatalog.getProductList().get(randomIndex2);
        Product lenovoProd3 = lenovoProductCatalog.getProductList().get(randomIndex3);
        Product lenovoProd4 = lenovoProductCatalog.getProductList().get(randomIndex4);
        
        System.out.println();
        
        System.out.println("Random 4 lenovo products -- "+ lenovoProd1 + " -- " +lenovoProd2 + " -- " + lenovoProd3 + " -- " + lenovoProd4);
        
        // EPSON PRODUCTS
        
        int erandomIndex1 = random.nextInt(epsonProductCatalog.getProductList().size());
        int erandomIndex2;
        do {
            erandomIndex2 = random.nextInt(epsonProductCatalog.getProductList().size());
        } while (erandomIndex2 == erandomIndex1);

        int erandomIndex3;
        do {
            erandomIndex3 = random.nextInt(epsonProductCatalog.getProductList().size());
        } while (erandomIndex3 == erandomIndex1 || erandomIndex3 == erandomIndex2);
        
        int erandomIndex4;
        do {
            erandomIndex4 = random.nextInt(lenovoProductCatalog.getProductList().size());
        } while (erandomIndex4 == erandomIndex1 || erandomIndex4 == erandomIndex2 || erandomIndex4 == erandomIndex3);


        // Get the products at the random indices
        Product epsonProd1 = epsonProductCatalog.getProductList().get(erandomIndex1);
        Product epsonProd2 = epsonProductCatalog.getProductList().get(erandomIndex2);
        Product epsonProd3 = epsonProductCatalog.getProductList().get(erandomIndex3);
        Product epsonProd4 = epsonProductCatalog.getProductList().get(erandomIndex4);
        
        System.out.println("Random 4 epson products -- "+ epsonProd1 + " -- " +epsonProd2 + " -- " + epsonProd3 + " -- " + epsonProd4);
        
        // Create Solution Offers for each market channel assignment

        SolutionOfferCatalog solutionoffercatalog = business.getSolutionOfferCatalog();

        SolutionOffer solutiontvseniors = solutionoffercatalog.newSolutionOffer(tvchannelseniorsmarket);
        solutiontvseniors.addProduct(lenovoProd1);
        solutiontvseniors.addProduct(epsonProd1);
        
        SolutionOffer solutionmagseniors = solutionoffercatalog.newSolutionOffer(magazinechannelseniorsmarket);
        solutionmagseniors.addProduct(lenovoProd1);
        solutionmagseniors.addProduct(epsonProd2);
        
        SolutionOffer solutionevestu = solutionoffercatalog.newSolutionOffer(eventChannelsStudentsMarket);
        solutionevestu.addProduct(lenovoProd1);
        solutionevestu.addProduct(epsonProd3);
        
        SolutionOffer solutionfbstu = solutionoffercatalog.newSolutionOffer(facebookChannelsStudentsMarket);
        solutionfbstu.addProduct(lenovoProd1);
        solutionfbstu.addProduct(epsonProd4);
        
        SolutionOffer solutionconfden = solutionoffercatalog.newSolutionOffer(conferenceChannelsDentistsMarket);
        solutionconfden.addProduct(lenovoProd2);
        solutionconfden.addProduct(epsonProd1);
        
        SolutionOffer solutionnewsden = solutionoffercatalog.newSolutionOffer(newsletterChannelsDentistsMarket);
        solutionnewsden.addProduct(lenovoProd2);
        solutionnewsden.addProduct(epsonProd2);
        
        SolutionOffer solutionwebgrad = solutionoffercatalog.newSolutionOffer(webinarChannelsGraduateStudentsMarket);
        solutionwebgrad.addProduct(lenovoProd2);
        solutionwebgrad.addProduct(epsonProd3);
        
        SolutionOffer solutionevegrad = solutionoffercatalog.newSolutionOffer(eventChannelsGraduateStudentsMarket);
        solutionevegrad.addProduct(lenovoProd2);
        solutionevegrad.addProduct(epsonProd4);
        
        SolutionOffer solutionconfprof = solutionoffercatalog.newSolutionOffer(conferenceChannelsProfessorsMarket);
        solutionconfprof.addProduct(lenovoProd3);
        solutionconfprof.addProduct(epsonProd1);
        
        SolutionOffer solutionfbprof = solutionoffercatalog.newSolutionOffer(facebookChannelsProfessorsMarket);
        solutionfbprof.addProduct(lenovoProd3);
        solutionfbprof.addProduct(epsonProd2);
        
        SolutionOffer solutionmagdoc = solutionoffercatalog.newSolutionOffer(magazineChannelsDoctorsMarket);
        solutionmagdoc.addProduct(lenovoProd3);
        solutionmagdoc.addProduct(epsonProd3);
        
        SolutionOffer solutionnewsdoc = solutionoffercatalog.newSolutionOffer(newsletterChannelsDoctorsMarket);
        solutionnewsdoc.addProduct(lenovoProd3);
        solutionnewsdoc.addProduct(epsonProd4);
        
        SolutionOffer solutionlinacc = solutionoffercatalog.newSolutionOffer(linkedinChannelsAccountantsMarket);
        solutionlinacc.addProduct(lenovoProd4);
        solutionlinacc.addProduct(epsonProd1);
        
        SolutionOffer solutiontvacc = solutionoffercatalog.newSolutionOffer(tvChannelsAccountantsMarket);
        solutiontvacc.addProduct(lenovoProd4);
        solutiontvacc.addProduct(epsonProd2);
        
        SolutionOffer solutionythp = solutionoffercatalog.newSolutionOffer(youtubeChannelsHealthProfessionalsMarket);
        solutionythp.addProduct(lenovoProd4);
        solutionythp.addProduct(epsonProd3);
        
        SolutionOffer solutioninstahp = solutionoffercatalog.newSolutionOffer(instagramChannelsHealthProfessionalsMarket);
        solutioninstahp.addProduct(lenovoProd4);
        solutioninstahp.addProduct(epsonProd4);
        
        System.out.println("Solution Offers are auto populated");
        
//        MasterSolutionOrderList msol = business.getMasterSolutionOrderList();
//
//        SolutionOrder so1 = msol.newSolutionOrder(solutiontvseniors, tvchannelseniorsmarket);
//        SolutionOrder so2 = msol.newSolutionOrder(solutionmagseniors, magazinechannelseniorsmarket);
//        
//        SolutionOrder so3 = msol.newSolutionOrder(solutionlinmillenials, linkedinchannelmillennialsmarket);
//        SolutionOrder so4 = msol.newSolutionOrder(solutionfbmillenials, fbchannelmillennialsmarket);
//        
//        SolutionOrder so5 = msol.newSolutionOrder(solutiontiktokteen, tiktokchannelteenmarket);
//        SolutionOrder so6 = msol.newSolutionOrder(solutionytteen, youtubechannelteenmarket);
//        
//        SolutionOrder so7 = msol.newSolutionOrder(solutionsnapzgen, snapchatchannelzgenmarket);
//        SolutionOrder so8 = msol.newSolutionOrder(solutioninstazgen, instagramchannelzgenmarket);
//
//        System.out.println("Solution order products --- "+ so1.getSelectedsolutionoffer().getProducts());
//        System.out.println("Solution order price --- "+ so1.getSelectedsolutionoffer().getSolutionPrice());

//        int rev = msol.getRevenueByMarketChannelCombo(tvchannelseniorsmarket);
//        System.out.println("rev --"+ rev);
//        System.out.println("rev --"+ msol.getRevenueByChannel(so1.getMarketChannelCombo().getChannel()));
        
        return business;

    }

}
