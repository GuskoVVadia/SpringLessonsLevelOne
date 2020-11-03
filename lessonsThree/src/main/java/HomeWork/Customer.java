package HomeWork;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers_tbl")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_fld_id")
    private Long id;

    @Column(name = "customer_fld_name")
    private String name;

    //я установил режим выборки LAZY, так как в примере не будет использоваться большое количество объектов
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "purchase_tbl",
            joinColumns = @JoinColumn(name = "customer_fld_id"),
            inverseJoinColumns = @JoinColumn(name = "product_fld_id")
    )
    private List<Product> products;

    public Customer() {
        this.products = new ArrayList<>();
    }

    public Customer(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public boolean addProducts(Product product){
        return this.products.add(product);
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", products=" + products +
                '}';
    }
}
