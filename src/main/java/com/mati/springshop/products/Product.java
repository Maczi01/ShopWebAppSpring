package com.mati.springshop.products;

import lombok.*;
import org.hibernate.annotations.Columns;
import org.javamoney.moneta.FastMoney;

import javax.persistence.*;

@NamedQuery(name = Product.SELECT_PRODUCTS, query = "select p from Product p")
@Table(name = "products", indexes = @Index(name = "payment_type", columnList = "type"))
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "id")
@Builder
public class Product {

    public static final String SELECT_PRODUCTS = "selectProducts";

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    @Columns(columns = {
            @Column(name = "currency", length = 3),
            @Column(name = "value", length = 15)
    })
    private FastMoney price;
    @Enumerated(EnumType.STRING)
    private ProductsType type;

}
