import product_exceptions.*;
import product_exceptions.sub_exceptions.ChocolatesAllGone;
import product_exceptions.sub_exceptions.SaltyCracksAllEatenException;
import product_exceptions.sub_exceptions.SoftDrinksOutOfStockException;
import products.*;

public class VendingMachine {

    public int saltySnackCounter = 0;
    public int softDrinkCounter = 0;
    public int chocolateCounter = 0;

    public void add(Product product, int add) {
        boolean condition = product instanceof SaltySnack || product instanceof Chocolate || product instanceof SoftDrink;
        if (!condition){
            throw new InvalidProductException("Invalid Product");
        } else {
            if (product instanceof Chocolate){
                chocolateCounter += add;
            } else if (product instanceof SaltySnack){
                saltySnackCounter += add;
            } else {
                softDrinkCounter += add;
            }
        }
    }

    public void getStock() {
        System.out.println(
                "Salty Snacks available: " + saltySnackCounter +
                        "\nSoft Drinks available: " + softDrinkCounter +
                        "\nChocolates available: " + chocolateCounter
        );
    }

    public void buy(Product product) throws ProductNotFoundException {
        if (product instanceof SaltySnack && saltySnackCounter != 0){
            saltySnackCounter--;
        } else if(product instanceof SaltySnack && saltySnackCounter == 0) {
            throw new SaltyCracksAllEatenException("No more Salty Snacks");
        }

        if (product instanceof  SoftDrink && softDrinkCounter != 0) {
            softDrinkCounter--;
        } else if (product instanceof  SoftDrink && softDrinkCounter == 0){
            throw new SoftDrinksOutOfStockException("No Soft Drinks left in the Vending Machine");
        }

        if (product instanceof  Chocolate && chocolateCounter != 0) {
            chocolateCounter--;
        } else if (product instanceof  Chocolate && chocolateCounter == 0){
            throw new ChocolatesAllGone("No Chocolates in Vending Machine");
        }

    }
//    public void buy(Product product, int amount) throws ProductNotFoundException {
//        if (product instanceof  Chocolate && chocolateCounter != 0) {
//            chocolateCounter -= amount;
//        } else {
//            throw new ChocolatesAllGone("No Chocolates in Vending Machine");
//        }
//
//        if (product instanceof SaltySnack && saltySnackCounter != 0){
//            saltySnackCounter -= amount;
//        } else {
//            throw new SaltyCracksAllEatenException("No more Salty Snacks");
//        }
//
//        if (product instanceof  SoftDrink && softDrinkCounter != 0) {
//            softDrinkCounter -= amount;
//        } else {
//            throw new SoftDrinksOutOfStockException("No Soft Drinks left in the Vending Machine");
//        }
//    }



    public static void main(String[] args) {
        VendingMachine machine1 = new VendingMachine();
        machine1.add(new Chocolate("Cadbury"), 5);
        machine1.add(new SoftDrink("Fanta"), 5);
        machine1.add(new SaltySnack("Safari"), 5);
        machine1.getStock();
        System.out.println();
        try {
            machine1.buy(new SaltySnack("Safari"));
        } catch (ProductNotFoundException e) {
            e.printStackTrace();
        }

        machine1.getStock();
    }
}