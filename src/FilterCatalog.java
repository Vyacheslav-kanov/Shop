import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterCatalog {

        List<Product> filterGroup(String group, List<Product> catalogList) {
            MealStoreCatalog eatStoreCatalog = new MealStoreCatalog();
            List<Product> productList = catalogList;
            Stream<Product> streamFilterGroup = productList.stream();

            return streamFilterGroup
                    .filter(x -> x.getGroup().contains(group))
                    .collect(Collectors.toList());
        }

        List<Product> filterName(String name, List<Product> catalogList) {
            List<Product> productList = catalogList;
            Stream<Product> streamFilterName = productList.stream();

            return streamFilterName
                    .filter(x -> x.getName().contains(name))
                    .collect(Collectors.toList());
        }

        List<Product> filterPrice(int min, int max, List<Product> catalogList) {
            List<Product> productList = catalogList;
            Stream<Product> streamFilterPrice = productList.stream();

            return streamFilterPrice
                    .filter(x -> x.getPrice() >= min)
                    .filter(x -> x.getPrice() <= max)
                    .collect(Collectors.toList());
        }

        List<Product> filterKeyWord(String keyWord, List<Product> catalogList) {
            List<Product> productList = catalogList;
            Stream<Product> streamFilterKeyWord = productList.stream();

            return streamFilterKeyWord
                    .filter(x -> x.getName().contains(keyWord))
                    .collect(Collectors.toList());
        }

        List<Product> clearFilter(List<Product> catalogList) {
            return catalogList;
        }
}
