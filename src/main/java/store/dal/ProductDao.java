package store.dal;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import store.common.Product;
import store.common.User;

import java.util.List;

@Component
public class ProductDao implements IProductDao {
    IHibernateFactory hibernateFactory;

    public ProductDao(IHibernateFactory hibernateFactory) {
        this.hibernateFactory = hibernateFactory;
    }

    @Override
    public void buyProduct(Product product, User user) {
        Session session = hibernateFactory.getSessionFactory().openSession();

        if (user.balance >= product.cost) {
            user.purchasedProduct.add(product);
            session.update(user);
        }
    }

    @Override
    public void sellProduct(Product product) {
        Session session = hibernateFactory.getSessionFactory().openSession();
        session.save(product);
    }

    @Override
    public List<Product> getAllProduct() {
        Session session = hibernateFactory.getSessionFactory().openSession();
        List<Product> products;
        products = session.createQuery("From Product").list();
        return products;
    }

    @Override
    public Product getProductById(int id) {
        Session session = hibernateFactory.getSessionFactory().openSession();
        Product product;
        product = session.get(Product.class, id);
        return product;
    }

    @Override
    public void editProduct(Product product) {
        Session session = hibernateFactory.getSessionFactory().openSession();
        session.update(product);
    }
}
