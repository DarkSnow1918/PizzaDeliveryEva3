package Clases;

public class Promociones {
    private int pizzasPromo, masterPizza, pizzaMax;
    private String pizzasPromoS, masterPizzaS, pizzaMaxS;

    public Promociones(){
        pizzasPromo = 5990;
        masterPizza= 12990;
        pizzaMax= 18500;

        pizzasPromoS="Pizzas promo";
        masterPizzaS="Master pizza";
        pizzaMaxS="Pizza max";

    }

    public String getPizzasPromoS() {
        return pizzasPromoS;
    }

    public void setPizzasPromoS(String pizzasPromoS) {
        this.pizzasPromoS = pizzasPromoS;
    }

    public String getMasterPizzaS() {
        return masterPizzaS;
    }

    public void setMasterPizzaS(String masterPizzaS) {
        this.masterPizzaS = masterPizzaS;
    }

    public String getPizzaMaxS() {
        return pizzaMaxS;
    }

    public void setPizzaMaxS(String pizzaMaxS) {
        this.pizzaMaxS = pizzaMaxS;
    }

    public int getPizzasPromo() {
        return pizzasPromo;
    }

    public void setPizzasPromo(int pizzasPromo) {
        this.pizzasPromo = pizzasPromo;
    }

    public int getMasterPizza() {
        return masterPizza;
    }

    public void setMasterPizza(int masterPizza) {
        this.masterPizza = masterPizza;
    }

    public int getPizzaMax() {
        return pizzaMax;
    }

    public void setPizzaMax(int pizzaMax) {
        this.pizzaMax = pizzaMax;
    }
}
