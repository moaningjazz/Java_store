package store.services;

import org.springframework.stereotype.Component;
import store.common.Product;
import store.dal.IProductDao;
import store.dal.IUserDao;

import java.util.List;

@Component
public class ProductService implements IProductService {
    IProductDao productDao;
    IUserDao userDao;

    public ProductService(IProductDao productDao, IUserDao userDao) {
        this.productDao = productDao;
        this.userDao = userDao;
    }

    @Override
    public void buyProduct(int idProduct, int idUser) {
        productDao.buyProduct(productDao.getProductById(idProduct), userDao.getUserById(idUser));
    }

    @Override
    public void sellProduct(Product product) {
        productDao.sellProduct(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return productDao.getAllProduct();
    }

    @Override
    public Product getProductById(int id) {
        return productDao.getProductById(id);
    }

    @Override
    public void editProduct(Product product) {
        productDao.editProduct(product);
    }
}
