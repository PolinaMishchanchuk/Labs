package com.company;

public class Main {

    public static void main(String[] args) {
        BankDeposit dep1 = new BankDeposit("Deposit №1", 100,
                "Revocable", Currency.Rubles);
        BankDeposit dep2 = new BankDeposit("Deposit №2", 1000,
                "Revocable", Currency.Dollar);
        BankDeposit dep3 = new BankDeposit("Deposit №3", 0,
                "Irrevocable", Currency.Euro);

        System.out.println(dep1.name + " is " + dep1.TypeOfDuration());

        dep1.ChangeDepositDuration(366);

        System.out.println(dep1.name + " is " + dep1.TypeOfDuration());

        System.out.println(dep2.DepositTypeName());

        BankDeposit dep4 = new BankDeposit(dep1, Currency.Dollar);
        System.out.println("Interest Contribution of " + dep1.name + " " + dep1.interestСontribution() + "%");
        System.out.println("Interest Contribution of " + dep2.name + " " + dep2.interestСontribution() + "%");
        System.out.println("Interest Contribution of " + dep3.name + " " + dep3.interestСontribution() + "%");

    }
}
