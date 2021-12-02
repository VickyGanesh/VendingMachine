
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class VendingMachineArray {
    int amountInVendingMachine = 0;
    int itemId , amount ;
    int balanceReturned;
    String previousTransactions = "";
    ArrayList<String> transactionDetails = new ArrayList<>();
    int[] itemNumber = new int[]{1 , 2 , 3};
    String[] itemName = new String[]{"KitKat" , "Perk" , "Munch"};
    int itemPrice[] = new int[]{15 , 5 , 10};
    int temp ;
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

        for(int i = 0; i < itemNumber.length ; i++){
            if(itemId == itemNumber[i]){
                temp = i;
            }
        }
        System.out.println("Dispensing item " + itemName[temp]);
        balanceReturned = amount - itemPrice[temp];
        System.out.println("Returning Balance " + balanceReturned);
        amountInVendingMachine = amountInVendingMachine + itemPrice[temp];
        viewAmountInVendingMachine();
        viewPreviousTransactions();
        displayItems();

    }
    void viewPreviousTransactions(){

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

        LocalDateTime time = LocalDateTime.now();
        String transactionTime = dateTimeFormatter.format(time).toString();

       this.transactionDetails.add(transactionTime + " " + this.itemId + " " + this.amount + " " +
                this.balanceReturned +" "+ this.amountInVendingMachine );

       for(int i = 0; i < transactionDetails.size() ; i++) {
       System.out.println( transactionDetails.get(i) + "\n"); }

    }
    void viewAmountInVendingMachine(){

        System.out.println("The amount in Vending Machine " + amountInVendingMachine);
    }

    public static void main(String[] args) {
        VendingMachineArray vendingMacine = new VendingMachineArray();
        vendingMacine.displayItems();
        vendingMacine.acceptItem();


    }

}

