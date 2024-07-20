package gift.product.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "product")
public class Product {

    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double price;
    private String imageUrl;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WishListProduct> wishListProducts = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


    public Product() {
    }

    public Product(String name, Double price, String imageUrl) {
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<WishListProduct> getWishListProducts() {
        return wishListProducts;
    }

    public void setWishListProducts(List<WishListProduct> wishListProducts) {
        this.wishListProducts = wishListProducts;
    }
}
