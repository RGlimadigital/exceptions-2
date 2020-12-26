package application;

import model.entities.Account;
import model.exceptions.DomainException;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Account Data: ");
        System.out.print("Number: ");
        int number = sc.nextInt();
        sc.nextLine();
        System.out.print("Holder: ");
        String holder = sc.nextLine();
        System.out.print("Inital Balance: ");
        double balance = sc.nextDouble();
        System.out.print("Withdraw Limit: ");
        double withdrawLimit = sc.nextDouble();

        Account acc = new Account(number, holder, balance, withdrawLimit);

        System.out.println();
        System.out.print("Enter amount for withdraw: ");
        double amount = sc.nextDouble();
        try{
            acc.withdraw(amount);
            System.out.println("New Balance: $" + String.format("%.2f", acc.getBalance()));
        }
        catch (DomainException e){
            System.out.println("Withdraw error: " + e.getMessage());
        }

    }
}
