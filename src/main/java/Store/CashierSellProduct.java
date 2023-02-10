package Store;

import java.util.Scanner;

public class CashierSellProduct{

    public static void sellProduct(Customer c, String item, int total ,Store store){
        System.out.println(" ");
        System.out.println("Store intial income is: $"+ store.income);
        if(c.moneyOwned>= total){
            store.income += total;
            System.out.println(" ");
            System.out.println("Store income after purchase: $"+ store.income);
            c.moneyOwned -= total;

            System.out.println("---------------------");
            System.out.println("Pick a cashier to attend to you");
            System.out.println("  ");

            int noCashier = store.list.size();

            DisplayCashier.display(store);
            System.out.println("");
            Scanner cashPicker = new Scanner(System.in);
            int selectedCash;
             do {

                 System.out.print("Enter Cashier number here: ");
                  selectedCash = cashPicker.nextInt();
                  selectedCash -=1;
                   if(selectedCash<0){
                     selectedCash = noCashier +1;
                     System.out.println("");
                       System.out.println("Please enter a valid number");
                   }else if(selectedCash> (noCashier-1)){
                       System.out.println("Please enter a valid number");
                   }

             }while(!(selectedCash<noCashier));

             Cashier pickCash = store.list.get(GetCashierDetails.getdetail(selectedCash, store));
             IssueReceipt.cashierReceipt(c,pickCash,item,total,c.moneyOwned);
        }else{
            System.out.println("insufficient balance. Please try again or get the fuck out of this store");
        }
    }
}


class IssueReceipt{

public static void cashierReceipt(Customer cu, Cashier c, String item,int total, int balance ){

    System.out.println("-----------------");
    System.out.println("Receipt issued by\nStaff name: " + c.name+ " \nStaff Id : " + c.id);
    System.out.println("***");
    System.out.println("To:\nCustomer name: "+ cu.name);
    System.out.println("");
    System.out.println(item);
    System.out.println("");
    System.out.println("Total cost of purchase: $" + total);
    System.out.println("");
    System.out.println("Balance left: $" + balance);
    System.out.println("");
    System.out.println("----------------------");
    System.out.println("Thanks for yor patronage");



}
}