package store.services;

import store.common.Product;

import java.util.List;

public interface IProductService {
    void buyProduct(int idProduct, int idUser);
    void sellProduct(Product product);
    List<Product> getAllProduct();
    Product getProductById(int id);
    void editProduct(Product product);
}
