package app.project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(nullable = false)
    private String title;

    @NonNull
    @Column(nullable = false)
    private Double price;

    @NonNull
    @Column(nullable = false)
    private Integer quantity;

//    public Product() {
//    }
//
//    public Product(Long id, String title, Double price, Integer quantity) {
//        this.id = id;
//        this.title = title;
//        this.price = price;
//        this.quantity = quantity;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public Double getPrice() {
//        return price;
//    }
//
//    public void setPrice(Double price) {
//        this.price = price;
//    }
//
//    public Integer getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(Integer quantity) {
//        this.quantity = quantity;
//    }

//    @Override
//    public String toString() {
//        return "Product{" +
//                "id=" + id +
//                ", title='" + title + '\'' +
//                ", price=" + price +
//                ", quantity=" + quantity +
//                '}';
//    }
}
