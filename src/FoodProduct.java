public class FoodProduct extends Product {
    int discountPercent;

    public FoodProduct(String id, String name, double price, int discountPercent) {
        super(id, name, price);
        this.discountPercent = discountPercent;
    }


    @Override
    public double calculateFinalPrice(){
        return super.price - (super.price * discountPercent / 100);
    }

    @Override
    public String toString() {
        return "FoodProduct{" +
                "price=" + price +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", discountPercent=" + discountPercent +
                '}';
    }
}
