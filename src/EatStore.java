import java.util.Scanner;

public class EatStore implements Store{

    private static EatStoreCatalog eatStoreCatalog = new EatStoreCatalog();

    @Override
    public void menuStore(){
        printCatalog();

        while(true) {
            Scanner scan = new Scanner(System.in);
            System.out.println(
                    "Выберите действие:" +
                            "\n1)Установить фильтры" +
                            "\n2)Корзина покупок" +
                            "\n3)Отследить заказ" +
                            "\n4)*Выход*"
            );

            int choice = scan.nextInt();
            if(choice == 4) break;

            switch (choice){
                case 1: menuFilter(); break;
                case 2: menuBasket(); break;
                case 3: menuTracker(); break;
            }
            scan.close();
        }
    }

    private static void printCatalog(){
        eatStoreCatalog.printProductCatalog();
        System.out.println();
    }

    private static void menuFilter(){
        printCatalog();

        while(true){
            Scanner scan = new Scanner(System.in);
            EatStoreCatalog eatStoreCatalog = new EatStoreCatalog();

            System.out.println(
                    "Выберите действие:" +
                            "\n1)Фильтровать по группе" +
                            "\n2)Фильтровать по имени" +
                            "\n3)Фильтровать по промежутку цен \"минимальная\", \"максимальная\" цена" +
                            "\n4)Фильтровать по ключевому слову" +
                            "\n5)Очистить все фильтры" +
                            "\n6)<- Назад"
            );

            int choice = scan.nextInt();
            if(choice == 6) new EatStore().menuStore();

            new EatStoreCatalog().filter(choice);
            scan.close();
        }
    }

    @Override
    public void menuBasket(){

    }

    private static void menuTracker(){

    }
}
