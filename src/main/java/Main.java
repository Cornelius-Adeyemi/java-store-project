import Store.*;

import java.awt.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String owner;

        //the owner of store start the store process
        do{
            System.out.println("  Welcome to Bisi's store\nEnter you ID as the owner to open the store");
            System.out.println(" ");
            System.out.print("Enter Id(it is case sensitive): ");
            String id = sc.nextLine();
            if(id.equals(StoreOwner.id)){
                owner="pass";
            }else{
                owner = "continue";
            }


        }while(!owner.equals("pass"));

        System.out.println("id is correct");
        System.out.println(" ");


        // hire a manager to the store
        System.out.println("You need to hire a manager to take charge of your day to day activities");
        System.out.println(" ");
        String managerName;

        Scanner managerSc = new Scanner(System.in);
        System.out.print("The name of the manager you want to employ: ");
        managerName = managerSc.nextLine();

        String mResult =  Manager.employManager(managerName);
        Manager currentManger = (Manager) Manager.getCurretManager();
        System.out.println(mResult);
        System.out.println(" ");


        // initialize store

        Store store = new Store(500000,currentManger);


        //add product to the store

        System.out.println("You need to add products to your store as the owner so your new manager can work in your store");

        int number =1;
        int productNum;
        System.out.print("How many products do you want to have in your store? ");
        productNum = sc.nextInt();

        do{
            Scanner productSc = null;
            productSc = new Scanner(System.in);
            System.out.println("");
            System.out.print("Enter product " + number + " name :");
            String productName = productSc.nextLine();
            System.out.println(" ");
            System.out.print("Enter the price for one quanity of "+ productName + ":");
            double productPrice = sc.nextDouble();
            System.out.println("");
            System.out.print("Enter the quanity of "+ productName +" to add to store: ");
            int qty = sc.nextInt();

            Addproduct.addproduct(productName,productPrice,qty,store);



            number++;
        }while(number<= productNum);

        System.out.println("You've successfully added product to your store");
        System.out.println(" ");

        System.out.println("As the manager, you are responsible for hiring the cashier. The store can only take a maximum \n of 5 cashiers ");
        System.out.println(" ");

        // verify with the manager id

        String managerId;
        do{
            managerId=null;
            Scanner verifySc = null;
                    verifySc =new Scanner(System.in);
           System.out.print("Enter your manager id to proceed: ");
           managerId = verifySc.nextLine();

           if(!(managerId.equals(((Manager)Manager.getCurretManager()).id))){
               System.out.println(" ");
               System.out.println("Wrong id: please try again");
           }
        }while(!(managerId.equals(((Manager)Manager.getCurretManager()).id)));


        // Hire a cashier to the store


        int numCashier=1;
        int numberOfCahsier;
        System.out.print("How many cashier do you want to have in your store? ");
        numberOfCahsier = sc.nextInt();
        if(numberOfCahsier >5 ){
            numberOfCahsier=5;
        }else if(numberOfCahsier<0){
            numberOfCahsier=1;
        }
        System.out.println("The number of cashier you want is: "+ numberOfCahsier);


        do{

            System.out.println(" ");
            Scanner cashierSc = null;
            cashierSc =new Scanner(System.in);

            String cashierName=null;
            System.out.print("Enter the name of cashier "+numCashier +" : ");
            cashierName = cashierSc.nextLine();

            HireCashier.hireCashier(cashierName,store);

            numCashier++;
        }while(numCashier<=numberOfCahsier);

        // the store interface
        System.out.println(" ");
        System.out.println("Store is now live!!!");
         int selectedOption;
        do{

            Scanner mainSc = null;
            mainSc = new Scanner(System.in);
            System.out.println("");

            System.out.println("Who are you? ");

            System.out.println("");

            System.out.println("1.Enter 1 if you are a Manager");
            System.out.println("");
            System.out.println("2. Enter 2 if you are a Customer ");

            System.out.println("");
            System.out.println("3. Enter three if you are a cashier");
            System.out.println("");

            System.out.println("4. Press 4 to exit ");

            System.out.println("");

            System.out.print("Pick between 1-4: ");
            selectedOption = mainSc.nextInt();

            switch (selectedOption){
                case 1:

                    managerSection(store);

                    break;

                case 2:
                    customerSection(store);
                    break;

                case 3:
                    System.out.println(" ");
                   System.out.println("Wait till a customer pick you");
                    break;

                case 4:
                    System.out.println("Bye! we hope to see you soon");
                    break;
            }



        }while(!(selectedOption==4));

    }


    public static void managerSection(Store store){

        String id = ((Manager)Manager.getCurretManager()).id;
        Scanner sc = new Scanner(System.in);
        String check;
        do{
            System.out.print("Enter your id: ");
            check = sc.nextLine();

            if(!(id.equals(check))){
                System.out.println(" ");
                System.out.println("Incorrect id. Try again");
            }
        }while(!(id.equals(check)));

            System.out.println("id is correct");

            System.out.println("");
            System.out.println("What do you want to do?");
            System.out.println(" ");
            System.out.println("1. Sack a cashier?");
            System.out.println(" ");
            System.out.println("2. Hire a cashier?");
            System.out.println(" ");
            System.out.println("3. Go back");
            System.out.println(" ");
            System.out.print("Enter either 1-3 : ");
            int number = sc.nextInt();
            Scanner subSc = new Scanner(System.in);
            System.out.println(" ");

            String cashierId;
            switch(number){

                case 1:
                    System.out.print("Enter Cashier id : ");
                    cashierId = subSc.nextLine();
                    SackCashier.sackCashier(cashierId,store);
                    break;
                case 2:
                    System.out.print("Enter name : ");
                    cashierId = subSc.nextLine();
                    HireCashier.hireCashier(cashierId,store);
                    break;

                case 3:

                    break;
            }
             System.out.println(" ");
        System.out.println("Remaining cashier in the store");
            DisplayCashier.display(store);

    }


    public static void customerSection(Store store){
        Scanner sc = new Scanner(System.in);
        System.out.println(" ");
        System.out.print("Please enter your name : ");
        String name =  sc.nextLine();
        System.out.println(" ");
        System.out.print("How much do you have with you? : ");
        int amount = sc.nextInt();
        Customer c = new Customer(name,amount);
        System.out.println("************************");
        System.out.println("Product catalog");
        int productlength = GetLengthOfProductList.getlength(store);
        int checker;
        String purchasedProducts = "";
        int totalCost = 0;

        DIsplayProducts.displayproducts(store);
        do{

            System.out.println(" ");
            Scanner productSc;
            int selectedProduct;

            do{
                productSc = null;
                productSc= new Scanner(System.in);
                System.out.print("Select product number ");

                selectedProduct= productSc.nextInt();
                System.out.println("");
                selectedProduct -=1;
                if(selectedProduct<0){
                    selectedProduct = productlength+1;
                    System.out.println("");
                    System.out.println("Please Enter a valid number");
                }else if(selectedProduct>productlength){
                    System.out.println(" ");
                    System.out.println("Please Enter a valid product number");
                }
            }while(!(selectedProduct<=productlength));

            Product prodDetails = store.productList.get(selectedProduct);
            System.out.println(" ");
            int quantity;
            System.out.print("How many do you want? ");
            quantity = productSc.nextInt();

            purchasedProducts += prodDetails.name + " " + quantity + "qty"+ " = $" + (quantity*prodDetails.price) +"\n";
            totalCost += (quantity*prodDetails.price);

            System.out.println("---------------------- ");

            System.out.println("1. Do you want to get more product? ");
            System.out.println("   ");
            System.out.println("2. Proceed with purchase.");
            System.out.println("   ");

            Scanner checkSc = new Scanner(System.in);

            do{
                System.out.print("select either 1 or 2: ");
               checker = checkSc.nextInt();
               if(checker !=1 || checker !=2 ){
                   System.out.println("Please, enter either 1 or 2");
               }
            }while(!(checker==1 || checker==2));



        }while(!(checker ==2));

        System.out.println("---------------------");

        CashierSellProduct.sellProduct(c,purchasedProducts,totalCost,store);




    }
}