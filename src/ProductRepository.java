import java.util.*;

public class ProductRepository implements IRepository<Product> {
    private List<Product> products = new ArrayList<>();
    private Map<String, Product> productMap = new HashMap<>();

    @Override
    public boolean add(Product item) {
       if(item == null){
           return false;
       }
       products.add(item);
       productMap.put(item.id, item);
       return true;
    }

    @Override
    public boolean removeById(String id){
        if(id == null || !productMap.containsKey(id)){
            return false;
        }
        Product product = productMap.get(id);
        products.remove(product);
        productMap.remove(id);
        return true;
    }

    @Override
    public Product findById(String id){
        if(id == null || !productMap.containsKey(id)){
            return null;
        }
        return productMap.get(id);
    }

    @Override
    public List<Product> findAll(){
        return products;
    }

    public void sortByPriceAsc() {
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return Double.compare(p1.getPrice(), p2.getPrice());
            }
        });
    }

    public Map<String, Integer> countByType() {
        Map<String, Integer> result = new HashMap<>();
        for (Product p : products) {
            if (p instanceof ElectronicProduct) {
                result.put("Electronic",
                        result.getOrDefault("Electronic", 0) + 1);
            } else if (p instanceof FoodProduct) {
                result.put("Food",
                        result.getOrDefault("Food", 0) + 1);
            }
        }
        return result;
    }
}
