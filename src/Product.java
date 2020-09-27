import java.util.Comparator;
import java.util.Objects;

public class Product implements Comparable<Product>{
    private int price;
    private int quantity;
    private String name;
    private String group;
    private String teg;
    private int rating;

    public Product(int price,int quantity, String name, String group, String teg) {
        this.price = price;
        this.quantity = quantity;
        this.name = name;
        this.group = group;
        this.teg = teg;
        this.rating = 0;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getTeg() {
        return teg;
    }

    public void setTeg(String teg) {
        this.teg = teg;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public int compareTo(Product o) {
        if(rating > o.rating) return 1;
        else if(rating < o.rating) return -1;
        else return 0;
    }

    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +
                ", name='" + name + '\'' +
                ", group=" + group +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price &&
                Objects.equals(name, product.name) &&
                group == product.group;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, name, group);
    }
}