public class ElectronicProduct extends Product {
    private int warrantyMonths;

    public ElectronicProduct(String id, String name, double price, int warrantyMonths) {
        super(id, name, price);
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public double calculateFinalPrice(){
        if(warrantyMonths > 12){
            return super.price + 1000000;
        }else{
            return super.price;
        }
    }

    @Override
    public String toString() {
        return "ElectronicProduct{" +
                "price=" + price +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", warrantyMonths=" + warrantyMonths +
                '}';
    }
}
