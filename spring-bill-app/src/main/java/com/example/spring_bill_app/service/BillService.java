package com.example.spring_bill_app.service;

import com.example.spring_bill_app.entity.BillEntity;
import com.example.spring_bill_app.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillService {

    @Autowired
    BillRepository billRepository;

    public BillEntity getRecord(long customerId, long productId){
        return billRepository.findByCustomerIdAndProductId(customerId, productId);
    }

    public BillEntity addRecord(BillEntity bill){
        return billRepository.save(bill);
    }

    public Optional<BillEntity> getRecordById(long billNo){
        return billRepository.findById(billNo);
    }

    public List<BillEntity> getAllRecords(){
        return billRepository.findAll();
    }
}
