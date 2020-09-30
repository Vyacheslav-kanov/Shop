import java.util.List;

public interface Tracker {
    Tracker addRoute(List<Product> basket);
    void removeRoute(int codeTracker);
    void getStatus(int codeTracker);
}
