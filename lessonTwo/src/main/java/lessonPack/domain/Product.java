package lessonPack.domain;


import javax.persistence.*;

@Entity
@Table(name="products_tbl")
public class Product{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_fld_id")
    private Long id;

    @Column(name = "product_fld_title")
    private String title;

    @Column(name = "product_fld_cost")
    private Double cost;

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
}
