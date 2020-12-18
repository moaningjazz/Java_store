package store.common;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    @Column(name = "title")
    public String title;
    @Column(name = "cost")
    public int cost;
    @Column(name = "sellerName")
    public String sellerName;
}
