import java.util.*;

public class MealStoreCatalog implements Catalog{

    private static List<Product> accortment = Arrays.asList(
            new Product(20, 10, "Бабушкино", "Выпечка", "Хлеб"),
            new Product(17, 5, "Хрустишко", "Выпечка", "Хлеб"),
            new Product(15, 40, "Danon", "кисломолочные ", "йогурт"),
            new Product(30, 15, "Коровка", "кисломолочные ", "молоко"),
            new Product(39, 10, "Сочный сад", "фрукты", "Ананас"),
            new Product(50, 5, "Сочный сад", "фрукты", "Дыня"),
            new Product(35, 20, "Овощной рай", "фрукты", "Кабачок")
    );

    private static List<Product> storeCatalog = new ArrayList<>(accortment);
    private static List<Product> filteredCatalog = new ArrayList<>(storeCatalog);

    private MealStoreBasket eatStoreBasket = new MealStoreBasket();


    @Override
    public void printProductCatalog() {
        storeCatalog.forEach(System.out::println);
    }

    @Override
    public void purchase(Product product) {
        if(product.getQuantity() != 0) {
            eatStoreBasket.append(product);

            product.setQuantity(product.getQuantity() - 1);
            product.setRating(product.getRating() + 1);
        }
        else System.out.println("Ошибка! Этот продукт закончился!");

        if(product.getQuantity() == 0){
            storeCatalog.remove(product);
        }
    }

    public List<Product> getStoreCatalog(){
        return storeCatalog;
    }

    public void setStoreCatalog(List<Product> list){
        storeCatalog = list;
    }

    public List<Product> getFilteredCatalog(){
        return filteredCatalog;
    }

    public void setFilteredCatalog(List<Product> list){
        filteredCatalog = list;
    }
}
