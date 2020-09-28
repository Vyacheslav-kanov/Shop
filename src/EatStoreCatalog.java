import java.util.*;

public class EatStoreCatalog implements Catalog{

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

    private EatStoreBasket eatStoreBasket = new EatStoreBasket();


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

    public void filter(int choice){
        Scanner scan = new Scanner(System.in);
        FilterCatalog filterCatalog = new FilterCatalog();

        switch (choice){
            case 1:
                System.out.println("Введите название группы для фильтрации: ");
                String group = scan.nextLine();

                filteredCatalog = filterCatalog.filterGroup(group, filteredCatalog);
                System.out.println("Список отфильтрован!");
                break;

            case 2:
                System.out.println("Введите название группы для фильтрации: ");
                String name = scan.nextLine();

                filteredCatalog = filterCatalog.filterName(name, filteredCatalog);
                System.out.println("Список отфильтрован!");
                break;

            case 3:
                System.out.println("Введите два числа: ");
                String value = scan.nextLine();

                String[] split = value.split(" ");

                int min = Integer.parseInt(split[0]);
                int max = Integer.parseInt(split[1]);

                filteredCatalog = filterCatalog.filterPrice(min, max, filteredCatalog);
                System.out.println("Список отфильтрован!");
                break;

            case 4:
                System.out.println("Введите клоючевое слово: ");
                String keyWord = scan.nextLine();

                filteredCatalog = filterCatalog.filterKeyWord(keyWord, filteredCatalog);
                System.out.println("Список отфильтрован!");
                break;

            case 5:
                filteredCatalog = filterCatalog.clearFilter(storeCatalog);
                System.out.println("Фильтры очищены!");
                break;
        }
    }
}
