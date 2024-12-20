package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

//@RestController
//@RequestMapping("/api/payment")
//public class PaymentController {
//
//    @PostMapping("/approve")
//    public Map<String, Object> approvePayment(@RequestBody PaymentRequest paymentRequest) {
//        Map<String, Object> response = new HashMap<>();
//        
//        // Perform payment processing logic here
//        // This is just a stub
//        
//        // Check if payment is successful
//        if (paymentRequest.getAmount() > 0) {
//            response.put("message", "Payment approved");
//            response.put("transactionId", "123456789"); // Mock transaction ID
//        } else {
//            response.put("message", "Payment failed");
//            response.put("error", "Insufficient funds"); // Mock error message
//        }
//
//        return response;
//    }
//}
//
//class PaymentRequest {
//    private double amount;
//    private String currency;
//    private String paymentMethodId;
//
//    // Getters and setters
//    public double getAmount() {
//        return amount;
//    }
//
//    public void setAmount(double amount) {
//        this.amount = amount;
//    }
//
//    public String getCurrency() {
//        return currency;
//    }
//
//    public void setCurrency(String currency) {
//        this.currency = currency;
//    }
//
//    public String getPaymentMethodId() {
//        return paymentMethodId;
//    }
//
//    public void setPaymentMethodId(String paymentMethodId) {
//        this.paymentMethodId = paymentMethodId;
//    }
//}

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @PostMapping("/approve")
    public Map<String, Object> approvePayment(@RequestBody PaymentRequest paymentRequest,  @RequestParam(name = "role") String role) {
        Map<String, Object> response = new HashMap<>();
        
        // Perform payment approval logic based on user role
        double approvalThreshold = getApprovalThreshold(role);
        
        // Check if payment amount exceeds the approval threshold for the user role
        if (paymentRequest.getAmount() <= approvalThreshold) {
            response.put("message", "Payment approved by " + role);
            response.put("transactionId", "123456789"); // Mock transaction ID
        } else {
            response.put("message", "Payment requires higher approval level");
            response.put("nextApprovalRole", getNextApprovalRole(role));
        }

        return response;
    }
    
    // Method to get the approval threshold based on user role
    private double getApprovalThreshold(String role) {
        // Implement logic to retrieve approval threshold based on user role
        // Example: For simplicity, return different thresholds for different roles
        switch (role) {
            case "Manager":
                return 1000.0; // Manager can approve payments up to $1000
            case "Supervisor":
                return 500.0;  // Supervisor can approve payments up to $500
            default:
                return 0.0;    // Default threshold (no approval required)
        }
    }
    
    // Method to get the next approval role based on the current role
    private String getNextApprovalRole(String role) {
        // Implement logic to determine the next approval role based on the current role
        // Example: For simplicity, return the next higher role
        switch (role) {
            case "Supervisor":
                return "Manager"; // Next approval role is Manager
            default:
                return "Admin";   // Default next approval role
        }
    }
}

class PaymentRequest {
    private double amount;
    private String currency;
    private String paymentMethodId;

    // Getters and setters
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }
}
