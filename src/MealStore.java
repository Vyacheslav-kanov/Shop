import java.util.Scanner;

public class MealStore implements Store{

    private static MealStoreCatalog eatStoreCatalog = new MealStoreCatalog();
    private static MealStore eatStore = new MealStore();


    private static void printCatalog(){
        eatStoreCatalog.printProductCatalog();
        System.out.println();
    }

    @Override
    public void menuStore(){
        printCatalog();

        while(true) {

            Scanner scan = new Scanner(System.in);
            System.out.println(
                    "Выберите действие:" +
                            "\n1)Установить фильтры" +
                            "\n2)Купить продукт" +
                            "\n3)Корзина покупок" +
                            "\n4)Отследить заказ" +
                            "\n5)*Выход*" +
                            "\n"
            );

            int choice = scan.nextInt();
            if(choice == 5) break;

            switch (choice){
                case 1: menuFilter(); break;
                case 2: buy(); break;
                case 3: menuBasket(); break;
                case 4: menuTracker(); break;
            }
            scan.close();
        }
    }

    private static void buy(){
        Scanner scan = new Scanner(System.in);

        printCatalog();

        while(true) {

            System.out.println(
                    "Выберите действие: " +
                            "\n1)Выбрать продукт для покупки по №" +
                            "\n2)Корзина покупок" +
                            "\n3)Отследить заказ" +
                            "\n4)<- Назад в магазин" +
                            "\n"
            );

            int choice = scan.nextInt();
            if (choice == 4) {
                eatStore.menuStore();
                break;
            }

            switch (choice) {
                case 1:
                    System.out.println("Введите № продукта");
                    int index = scan.nextInt();
                    eatStoreCatalog.purchase(eatStoreCatalog.getStoreCatalog().get(index - 1));
                    System.out.println("Продукт помещен в карзину!\n");
                    break;

                case 2:
                    eatStore.menuBasket();
                    break;

                case 3: break; //Трекер !
            }
        }
    }

    private static void menuFilter(){
        Scanner scan = new Scanner(System.in);
        FilterCatalog filterCatalog = new FilterCatalog();
        MealStoreCatalog eatStoreCatalog = new MealStoreCatalog();

        printCatalog();

        while(true){

            System.out.println(
                    "Выберите действие:" +
                            "\n1)Фильтровать по группе" +
                            "\n2)Фильтровать по имени" +
                            "\n3)Фильтровать по промежутку цен \"минимальная\", \"максимальная\" цена" +
                            "\n4)Фильтровать по ключевому слову" +
                            "\n5)Очистить все фильтры" +
                            "\n6)<- Назад в магазин" +
                            "\n"
            );

            int choice = scan.nextInt();
            if(choice == 6) {
                eatStore.menuStore();
                break;
            }

            switch (choice){
                case 1:
                    System.out.println("Введите название группы для фильтрации: ");
                    String group = scan.nextLine();

                    eatStoreCatalog.setFilteredCatalog(filterCatalog.filterGroup(group, eatStoreCatalog.getFilteredCatalog()));
                    System.out.println("Список отфильтрован!");
                    break;

                case 2:
                    System.out.println("Введите название группы для фильтрации: ");
                    String name = scan.nextLine();

                    eatStoreCatalog.setFilteredCatalog(filterCatalog.filterName(name, eatStoreCatalog.getFilteredCatalog()));
                    System.out.println("Список отфильтрован!");
                    break;

                case 3:
                    System.out.println("Введите два числа: ");
                    String value = scan.nextLine();

                    String[] split = value.split(" ");

                    int min = Integer.parseInt(split[0]);
                    int max = Integer.parseInt(split[1]);

                    eatStoreCatalog.setFilteredCatalog(filterCatalog.filterPrice(min, max, eatStoreCatalog.getFilteredCatalog()));
                    System.out.println("Список отфильтрован!");
                    break;

                case 4:
                    System.out.println("Введите клоючевое слово: ");
                    String keyWord = scan.nextLine();

                    eatStoreCatalog.setFilteredCatalog(filterCatalog.filterKeyWord(keyWord, eatStoreCatalog.getFilteredCatalog()));
                    System.out.println("Список отфильтрован!");
                    break;

                case 5:
                    eatStoreCatalog.setFilteredCatalog(filterCatalog.clearFilter(eatStoreCatalog.getStoreCatalog()));
                    System.out.println("Фильтры очищены!");
                    break;
            }
        }
    }

    @Override
    public void menuBasket(){
        Scanner scan = new Scanner(System.in);
        MealStoreBasket eatStoreBasket = new MealStoreBasket();

        eatStoreBasket.printBasket();

        while(true){

            System.out.println(
                    "Выберите действие:" +
                            "\n1)Купить товары в корзине" +
                            "\n2)Удалить товар из корзины" +
                            "\n3)Отследить товары" +
                            "\n4)<- Назад в магазин" +
                            "\n"
            );

            int choice = scan.nextInt();
            if(choice == 4) {
                eatStore.menuStore();
                break;
            }

            switch (choice){
                case 1: break; //Покупка выбраных товаров !
                case 2:
                    System.out.println("Введите номер продукта для удаления ");
                    int index = scan.nextInt();

                    eatStoreBasket.remove(eatStoreBasket.getBasket().get(index));
                    System.out.println("Продукт" + eatStoreBasket.getBasket().get(index) + " удален из корзины !");
                    break;

                case 3: break; //Трекер !
            }
        }
    }

    private static void menuTracker(){

    }
}
