package com.company;

enum Currency{
    Dollar,
    Euro,
    Rubles
}

public class BankDeposit implements Changing {
    public String name;
    public int depositDuration;
    public String depositType;
    public Currency currency;

    public BankDeposit(String name, int depositDuration,
                       String depositType, Currency currency){
        this.name = name;
        this.depositDuration = depositDuration;
        this.depositType = depositType;
        this.currency = currency;
    }

    public BankDeposit(BankDeposit oldDeposit,Currency newCurrency){
        oldDeposit.currency = newCurrency;
    }

    public String TypeOfDuration(){
        if(this.depositDuration < 365 && this.depositDuration > 0){
            return "Short-Term";
        }
        if(this.depositDuration >= 365){
            return "Long-Term";
        }
        else{
            return "Termless";
        }
    }

    public int interestСontribution(){
        int result = 0;
        switch (this.TypeOfDuration()){
            case ("Short-Term"):
                result += 3;
                break;
            case("Long-Term"):
                result += 6;
                break;
            case("Termless")    :
                break;
        }
        switch (this.DepositTypeName()){
            case("Revocable"):
                result += 0;
                break;
            case("Irrevocable"):
                result += 3;
                break;
        }
        switch(this.currency){
            case Dollar:
                result*=0.7;
                break;
            case Euro:
                result*=0.5;
                break;
            case Rubles:
                result*=1.5;
                break;
        }
        return result;
    }

    @Override
    public void ChangeDepositDuration(int newDuration) {
        this.depositDuration = newDuration;
    }

    @Override
    public String DepositTypeName(){
        return this.depositType;
    }
}