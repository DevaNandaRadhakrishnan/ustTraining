package com.example.spring_bill_app.repository;

import com.example.spring_bill_app.entity.BillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<BillEntity, Long> {
    BillEntity findByCustomerIdAndProductId(long customerId, long productId);
}
