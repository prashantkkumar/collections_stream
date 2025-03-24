package java_collections.map_interface.insurancePolicyManagement;
import java.time.*;
public class Policy {
    private String policyNumber;
    private String policyHolder;
    private LocalDate expiryDate;

    public Policy(String policyNumber, String policyHolder, LocalDate expiryDate) {
        this.policyNumber = policyNumber;
        this.policyHolder = policyHolder;
        this.expiryDate = expiryDate;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getPolicyHolder() {
        return policyHolder;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    @Override
    public String toString() {
        return "PolicyNumber: " + policyNumber + ", PolicyHolder: " + policyHolder + ", ExpiryDate: " + expiryDate;
    }
}
