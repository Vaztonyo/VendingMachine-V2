import product_exceptions.*;
import product_exceptions.sub_exceptions.*;
import products.*;

public class VendingMachine {
    protected int saltySnackCounter = 0;
    protected int softDrinkCounter = 0;
    protected int chocolateCounter = 0;

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

    public String getStock() {
        return "Salty Snacks available: " + saltySnackCounter +
                        "\nSoft Drinks available: " + softDrinkCounter +
                        "\nChocolates available: " + chocolateCounter;
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

//    public static void main(String[] args) {
//        VendingMachine machine1 = new VendingMachine();
//        machine1.add(new Chocolate("Cadbury"), 5);
//        machine1.add(new SoftDrink("Fanta"), 5);
//        machine1.add(new SaltySnack("Safari"), 5);
//        System.out.println( machine1.getStock());
//        try {
//            machine1.buy(new SaltySnack("Safari"));
//            machine1.buy(new SaltySnack("Safari"));
//        } catch (ProductNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println( machine1.getStock());
//    }
}
