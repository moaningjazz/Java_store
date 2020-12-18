package store.dal;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import store.common.Product;
import store.common.User;

@Component
@Profile("dev")
public class H2HibernateFactory implements IHibernateFactory {
    @Override
    public SessionFactory getSessionFactory() {
        SessionFactory sessionFactory;

        Configuration configuration = new Configuration().configure("hibernate.cfg.h2.xml");

        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Product.class);

        StandardServiceRegistryBuilder builder =
                new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());

        sessionFactory = configuration.buildSessionFactory(builder.build());

        return sessionFactory;
    }
}
