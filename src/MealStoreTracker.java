import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MealStoreTracker implements Tracker{

    Map<Integer, List<Product>> route = new HashMap<>();

    @Override
    public Tracker addRoute(List<Product> basket) {
        return null;
    }

    @Override
    public void removeRoute(int codeTracker) {

    }

    @Override
    public void getStatus(int codeTracker) {

    }
}
