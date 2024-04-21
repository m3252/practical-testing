package sample.cafekiosk.spring.domain.product;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ProductNumber;

    @Enumerated(EnumType.STRING)
    private ProductType type;

    @Enumerated(EnumType.STRING)
    private ProductSellingStatus sellingStatus;

    private String name;

    private int price;

    public Long getId() {
        return id;
    }

    public String getProductNumber() {
        return ProductNumber;
    }

    public ProductType getType() {
        return type;
    }

    public ProductSellingStatus getSellingStatus() {
        return sellingStatus;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
