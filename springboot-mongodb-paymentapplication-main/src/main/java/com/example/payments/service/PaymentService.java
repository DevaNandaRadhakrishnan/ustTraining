package com.example.payments.service;

import com.example.payments.dto.ItemsDto;
import com.example.payments.dto.Paymentdto;
import com.example.payments.model.Items;
import com.example.payments.model.Payment;
import com.example.payments.repository.PaymentRepository;
import net.sf.jasperreports.engine.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public Payment getPaymentById(String id) {
        Optional<Payment> payment = paymentRepository.findById(id);
        return payment.orElse(null);
    }

    public Payment initiatePayment(Paymentdto paymentDto) {

        double totalAmount = calculateTotalAmount(paymentDto.getItems());

        double tdsAmount = calculateTDS(totalAmount, paymentDto.getTds());

        double netAmount = calculateNetAmount(totalAmount, tdsAmount);

        Payment payment = Payment.builder()
                .totalAmount(totalAmount)
                .tdsAmount(tdsAmount)
                .netAmount(netAmount)
                .currency(paymentDto.getCurrency())
                .username(paymentDto.getUsername())
                .poNumber(paymentDto.getPoNumber())
                .invoiceNumber(paymentDto.getInvoiceNumber())
                .targetBankAccount(paymentDto.getTargetBankAccount())
                .sourceBankAccount(paymentDto.getSourceBankAccount())
                .tds(paymentDto.getTds())
                .status(paymentDto.getStatus())
                .paymentDate(paymentDto.getPaymentDate())
                .vendorName(paymentDto.getVendorName())
                .vendorAddress(paymentDto.getVendorAddress())
                .vendorNumber(paymentDto.getVendorNumber())
                .clientName(paymentDto.getClientName())
                .clientAddress(paymentDto.getClientAddress())
                .clientNumber(paymentDto.getClientNumber())
                .items(convertToItems(paymentDto.getItems())) // Convert ItemDTOs to Items
                .build();

        return paymentRepository.save(payment);
    }

    private List<Items> convertToItems(List<ItemsDto> itemDTOs) {
        return itemDTOs.stream()
                .map(itemDTO -> new Items(itemDTO.getName(), itemDTO.getQuantity(), itemDTO.getPrice()))
                .collect(Collectors.toList());
    }

    public List<Payment> initiatePayments(List<Paymentdto> paymentsDto) {

        List<Payment> paymentList = paymentsDto.stream().map(paymentDTO -> {

            double totalAmount = calculateTotalAmount(paymentDTO.getItems());
            double tdsAmount = calculateTDS(totalAmount, paymentDTO.getTds());
            double netAmount = calculateNetAmount(totalAmount, tdsAmount);

            return Payment.builder()
                    .totalAmount(totalAmount)
                    .tdsAmount(tdsAmount)
                    .netAmount(netAmount)
                    .currency(paymentDTO.getCurrency())
                    .username(paymentDTO.getUsername())
                    .poNumber(paymentDTO.getPoNumber())
                    .invoiceNumber(paymentDTO.getInvoiceNumber())
                    .targetBankAccount(paymentDTO.getTargetBankAccount())
                    .tds(paymentDTO.getTds())
                    .sourceBankAccount(paymentDTO.getSourceBankAccount())
                    .status(paymentDTO.getStatus())
                    .paymentDate(paymentDTO.getPaymentDate())
                    .vendorName(paymentDTO.getVendorName())
                    .vendorAddress(paymentDTO.getVendorAddress())
                    .vendorNumber(paymentDTO.getVendorNumber())
                    .clientName(paymentDTO.getClientName())
                    .clientAddress(paymentDTO.getClientAddress())
                    .clientNumber(paymentDTO.getClientNumber())
                    .items(convertToItems(paymentDTO.getItems()))
                    .build();
        }).collect(Collectors.toList());

        return paymentRepository.saveAll(paymentList);
    }

    private double calculateTotalAmount(List<ItemsDto> items) {
        return items.stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();
    }

    private double calculateTDS(double totalAmount, int tdsPercentage) {
        return (totalAmount * tdsPercentage) / 100;
    }

    private double calculateNetAmount(double totalAmount, double tdsAmount) {
        return totalAmount - tdsAmount;
    }




    // 1. Find pending payments
    public List<Payment> findPendingPayments() {
        return paymentRepository.findByStatus("PENDING");
    }

    // 2. Find total amount
    public Double getTotalAmount() {
        return paymentRepository.sumAllAmounts();
    }

    // 3. Find amount by invoice number
    public Double getAmountByInvoiceNumber(String invoiceNumber) {
        Payment payment = paymentRepository.findByInvoiceNumber(invoiceNumber);
        return payment != null ? payment.getTotalAmount() : 0.0;
    }

    // 4. Find complete and pending payments by payment date
    public Map<String, List<Payment>> getPaymentsByStatusAndDate(String paymentDate) {
        Map<String, List<Payment>> paymentsByStatus = new HashMap<>();
        paymentsByStatus.put("completed", paymentRepository.findByPaymentDateAndStatus(paymentDate, "PAID"));
        paymentsByStatus.put("pending", paymentRepository.findByPaymentDateAndStatus(paymentDate, "PENDING"));
        return paymentsByStatus;
    }

    // 5. Edit payment
    public Payment editPayment(String id, Paymentdto paymentdto) {
        Optional<Payment> optionalPayment = paymentRepository.findById(id);
        if (optionalPayment.isPresent()) {
            Payment payment = optionalPayment.get();
            payment.setCurrency(paymentdto.getCurrency());
            payment.setUsername(paymentdto.getUsername());
            payment.setPoNumber(paymentdto.getPoNumber());
            payment.setInvoiceNumber(paymentdto.getInvoiceNumber());
            payment.setTargetBankAccount(paymentdto.getTargetBankAccount());
            payment.setSourceBankAccount(paymentdto.getSourceBankAccount());
            payment.setTds(paymentdto.getTds());
            payment.setStatus(paymentdto.getStatus());
            payment.setPaymentDate(paymentdto.getPaymentDate());
            return paymentRepository.save(payment);
        }
        throw new RuntimeException("Payment not found");
    }

    // 6. Delete payment
    public void deletePayment(String id) {
        paymentRepository.deleteById(id);
    }


    public void generateInvoicePDF(Payment payment) throws JRException {
        // Load Jasper template
        JasperReport jasperReport = JasperCompileManager.compileReport("src/main/resources/invoices/invoice_template.jrxml");

        // Prepare parameters
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("invoiceNumber", payment.getInvoiceNumber());
        parameters.put("paymentDate", payment.getPaymentDate());
        parameters.put("poNumber", payment.getPoNumber());
        parameters.put("targetBankAccount", payment.getTargetBankAccount());
        parameters.put("sourceBankAccount", payment.getSourceBankAccount());
        parameters.put("clientName", payment.getClientName());
        parameters.put("clientAddress", payment.getClientAddress());
        parameters.put("clientNumber", payment.getClientNumber());
        parameters.put("vendorName", payment.getVendorName());
        parameters.put("vendorAddress", payment.getVendorAddress());
        parameters.put("vendorNumber", payment.getVendorNumber());
        parameters.put("netAmount", payment.getNetAmount());
        parameters.put("tdsAmount", payment.getTdsAmount());
        parameters.put("totalAmount", payment.getTotalAmount());
        parameters.put("items", payment.getItems());

        // Fill the report
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());

        // Export to PDF
        JasperExportManager.exportReportToPdfFile(jasperPrint, "invoice_" + payment.getInvoiceNumber() + ".pdf");
    }
}
