import product_exceptions.*;
import product_exceptions.sub_exceptions.*;
import products.*;

public class MaxiVendingMachine extends VendingMachine {

    @Override
    public void buy(Product product) throws ProductNotFoundException {
            throw new InvalidProductException("Not a valid products");
    }

    public void buy(Chocolate chocolate) throws ChocolatesAllGone {
        if (chocolateCounter == 0){
         throw new ChocolatesAllGone("No Chocolates in Vending Machine");
        } else {
            chocolateCounter--;
        }
    }
    public void buy(SoftDrink softdrink) throws SoftDrinksOutOfStockException {
        if (softDrinkCounter == 0){
            throw new SoftDrinksOutOfStockException("No more Soft Drinks in Vending Machine");
        } else {
            softDrinkCounter--;
        }
    }
    public void buy(SaltySnack saltySnack) throws SaltyCracksAllEatenException {
        if (saltySnackCounter == 0){
            throw new SaltyCracksAllEatenException("No Salty Snacks left in Vending Machine");
        } else {
            saltySnackCounter--;
        }
    }

    @Override
    public void addStock(Product product, int add) {
        throw new InvalidProductException("Not a valid product");
    }

    public void addStock(SoftDrink softdrink, int add){
        softDrinkCounter += add;
    }

    public void addStock(SaltySnack saltySnack, int add){
        saltySnackCounter += add;
    }

    public void addStock(Chocolate chocolate, int add){
        chocolateCounter += add;
    }

    public static void main(String[] args) {
        MaxiVendingMachine maxiMachine = new MaxiVendingMachine();
        Chocolate choc = new Chocolate("no");
        maxiMachine.addStock(choc, 2);
        System.out.println(maxiMachine.getStock());
        try {
            maxiMachine.buy(new SoftDrink("Coke"));
        } catch (SoftDrinksOutOfStockException e) {
            e.printStackTrace();
        }
        
    }
}
