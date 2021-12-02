import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class VendingMachineWithArray {
    int amountInVendingMachine = 0;
    int itemId , amount ;
    int balanceReturned;
    String previousTransactions = "";
    String[] transactionDetailsInArray = new String[5];
    int numberOfTransaction = 0;

    void displayItems(){
        System.out.println("\nItemId\tname\tPrice");
        System.out.println("\n1\tKitKat\t15");
        System.out.println("\n2\tPerk\t5");
        System.out.println("\n3\tMunch\t10");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the item id:");
        this.itemId = scanner.nextInt();
        System.out.println("Enter the amount:");
        this.amount = scanner.nextInt();
        acceptItem();

    }

    void acceptItem(){
        if( itemId == 1){
            if(amount >= 15){
                System.out.println("Dispensing item KitKat ");
                balanceReturned = amount - 15;
                System.out.println("Returning Balance " + balanceReturned);
                amountInVendingMachine = amountInVendingMachine + 15;

            }

        }
        else if(itemId == 2) {
            if (amount >= 5) {
                balanceReturned = amount - 5;
                System.out.println("Dispensing item Perk ");
                System.out.println("Returning Balance " + balanceReturned);
                amountInVendingMachine = amountInVendingMachine + 5;
            }
        }
        else if(itemId == 3) {
            if (amount >= 10) {
                balanceReturned = amount - 10;
                System.out.println("Dispensing item Munch ");
                System.out.println("Returning Balance " + balanceReturned);
                amountInVendingMachine = amountInVendingMachine + 10;

            }
        }
        viewAmountInVendingMachine();
        viewPreviousTransactions();

    }
    void viewPreviousTransactions(){

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:ss");

        LocalDateTime time = LocalDateTime.now();
        String transactionTime = dateTimeFormatter.format(time).toString();

        transactionDetailsInArray[numberOfTransaction] = transactionTime + " " + this.itemId + " " + this.amount + " " +
                this.balanceReturned +" "+ this.amountInVendingMachine;
        numberOfTransaction++;


        for(int i = 0; i <5; i++) {
            System.out.println( transactionDetailsInArray[i] + "\n"); }

    }
    void viewAmountInVendingMachine(){

        System.out.println("The amount in Vending Machine " + amountInVendingMachine);
    }

    public static void main(String[] args) {
        VendingMachineWithArray vendingMachine = new VendingMachineWithArray();
       // System.out.println(vendingMachine.transactionDetailsInArray.length);
        int i =0;
        while( i < vendingMachine.transactionDetailsInArray.length){
        vendingMachine.displayItems();
        i++;
        }
       // vendingMachine.acceptItem();

    }

}
