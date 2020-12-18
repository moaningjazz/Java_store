package store.dal;

import store.common.Product;
import store.common.User;

import java.util.List;

public interface IProductDao {
    void buyProduct(Product product, User user);
    void sellProduct(Product product);
    List<Product> getAllProduct();
    Product getProductById(int id);
    void editProduct(Product product);
}
