import java.util.ArrayList;
import java.util.List;

public class EatStoreBasket implements Basket {

    private List<Product> basket = new ArrayList<>();

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
}
