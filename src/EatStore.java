import java.util.Scanner;

public class EatStore implements Store{

    private static EatStoreCatalog eatStoreCatalog = new EatStoreCatalog();
    private static EatStore eatStore = new EatStore();


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

                case 3: break;
            }
        }
    }

    private static void menuFilter(){
        Scanner scan = new Scanner(System.in);
        EatStoreCatalog eatStoreCatalog = new EatStoreCatalog();

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

            eatStoreCatalog.filter(choice);
        }
    }

    @Override
    public void menuBasket(){
        Scanner scan = new Scanner(System.in);
        EatStoreBasket eatStoreBasket = new EatStoreBasket();

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


        }
    }

    private static void menuTracker(){

    }
}
