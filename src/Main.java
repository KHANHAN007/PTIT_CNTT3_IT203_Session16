import java.util.Map;

public class Main {
    static void main() {
        ProductRepository repo = new ProductRepository();
        repo.add(new ElectronicProduct("1", "Laptop", 1000000, 12));
        repo.add(new ElectronicProduct("2", "Smartphone", 500000, 24));
        repo.add(new FoodProduct("3", "Bread", 20000, 10));
        repo.add(new FoodProduct("4", "Rice", 15000, 20));

        System.out.println("=== Danh sách sản phầm ===");
        for (Product product : repo.findAll()) {
            product.displayInfo();
            System.out.println("Giá sau giảm: " + product.calculateFinalPrice());
            System.out.println("-------------------------");
        }

        System.out.println("===== TÌM SẢN PHẨM E01 =====");
        Product found = repo.findById("E01");
        if (found != null) {
            found.displayInfo();
        } else {
            System.out.println("Không tìm thấy!");
        }

        repo.sortByPriceAsc();
        System.out.println("===== SAU KHI SẮP XẾP =====");
        for (Product p : repo.findAll()) {
            System.out.println(p.getId() + " - " + p.getPrice());
        }

        System.out.println("===== THỐNG KÊ =====");
        Map<String, Integer> statistics = repo.countByType();
        for (String key : statistics.keySet()) {
            System.out.println(key + ": " + statistics.get(key));
        }
    }
}
