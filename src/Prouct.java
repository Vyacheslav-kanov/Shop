import java.util.Objects;

public class Prouct {
    protected int price;
    protected String name;
    protected ProductGroup group;

    public Prouct(int price, String name, ProductGroup group) {
        this.price = price;
        this.name = name;
        this.group = group;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductGroup getGroup() {
        return group;
    }

    public void setGroup(ProductGroup group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Prouct{" +
                "price=" + price +
                ", name='" + name + '\'' +
                ", group=" + group +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prouct prouct = (Prouct) o;
        return price == prouct.price &&
                Objects.equals(name, prouct.name) &&
                group == prouct.group;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, name, group);
    }
}