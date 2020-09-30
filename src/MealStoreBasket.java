import java.util.ArrayList;
import java.util.List;

public class MealStoreBasket implements Basket {

    private List<Product> basket = new ArrayList<>();

    public List<Product> getBasket(){
        return basket;
    }

    @Override
    public void printBasket() {
        basket.forEach(System.out::println);
    }

    @Override
    public void append(Product product) {
        basket.add(product);
    }

    @Override
    public void remove(Product product) {
        basket.remove(product);
    }

    @Override
    public void toPay() {

    }
}
