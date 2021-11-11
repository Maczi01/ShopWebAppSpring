package com.mati.springshop.order;

import com.mati.springshop.payments.LocalMoney;
import com.mati.springshop.payments.Payment;
import com.mati.springshop.products.Product;
import lombok.*;
import org.javamoney.moneta.FastMoney;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;
import java.util.List;

@Table(name = "orders")
@RequiredArgsConstructor
@NoArgsConstructor
@Data
@Entity
@AllArgsConstructor
@EqualsAndHashCode(exclude = "id")
public class Order {

    @Id
    private Long id;
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @NonNull
    @NotEmpty
    private List<Product> products;
    @Valid
    @OneToOne(cascade = CascadeType.PERSIST)
    private Payment payment;
    private Instant timestamp;

    public FastMoney getTotalPrice() {
        return products.stream().map(Product::getPrice).reduce(LocalMoney.zero(), FastMoney::add);
    }

}
