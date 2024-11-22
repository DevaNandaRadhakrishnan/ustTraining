package com.example.spring_bill_app.controller;

import com.example.spring_bill_app.entity.BillEntity;
import com.example.spring_bill_app.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BillController {

    @Autowired
    BillService billService;

    @GetMapping("/bill/{cid}/{pid}")
    public ResponseEntity<BillEntity> getRecord(@PathVariable long cid, @PathVariable long pid) {
        BillEntity bill = billService.getRecord(cid, pid);
        if (bill == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bill);
    }


    @PostMapping("/bill/add")
    public ResponseEntity<BillEntity> addRecord(@RequestBody BillEntity bill){
        return ResponseEntity.ok(billService.addRecord(bill));
    }

    @GetMapping("/bill/{id}")
    public ResponseEntity<Optional<BillEntity>> getRecordById(@PathVariable long id){
        return ResponseEntity.ok(billService.getRecordById(id));
    }
    
    @GetMapping("/bill")
    public ResponseEntity<List<BillEntity>> getAllRecords(){
        return ResponseEntity.ok(billService.getAllRecords());
    }
}
