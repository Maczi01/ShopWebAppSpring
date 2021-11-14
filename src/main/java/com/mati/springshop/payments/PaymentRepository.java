package com.mati.springshop.payments;

import com.mati.springshop.products.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository  extends JpaRepository<Payment, Long> {

}
