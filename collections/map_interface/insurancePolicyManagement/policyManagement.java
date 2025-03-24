package java_collections.map_interface.insurancePolicyManagement;
import java.util.*;
import java.time.*;
public class policyManagement {
    private Map<String, Policy> policyMap = new HashMap<>();
    private Map<String, Policy> orderedPolicyMap = new LinkedHashMap<>();
    private NavigableMap<LocalDate, Policy> sortedPolicyMap = new TreeMap<>();

    public void addPolicy(Policy policy) {
        policyMap.put(policy.getPolicyNumber(), policy);
        orderedPolicyMap.put(policy.getPolicyNumber(), policy);
        sortedPolicyMap.put(policy.getExpiryDate(), policy);
    }

    public Policy getPolicy(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    public List<Policy> listExpiringPolicies() {
        LocalDate now = LocalDate.now();
        LocalDate threshold = now.plusDays(30);
        return new ArrayList<>(sortedPolicyMap.subMap(now, true, threshold, true).values());
    }

    public List<Policy> listPoliciesByHolder(String policyHolder) {
        List<Policy> result = new ArrayList<>();
        for (Policy policy : orderedPolicyMap.values()) {
            if (policy.getPolicyHolder().equalsIgnoreCase(policyHolder)) {
                result.add(policy);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        policyManagement system = new policyManagement();

        system.addPolicy(new Policy("P001", "Alice", LocalDate.now().plusDays(10)));
        system.addPolicy(new Policy("P002", "Bob", LocalDate.now().plusDays(40)));
        system.addPolicy(new Policy("P003", "Alice", LocalDate.now().plusDays(20)));

        System.out.println("Policies expiring in the next 30 days: " + system.listExpiringPolicies());
        System.out.println("Policies for Alice: " + system.listPoliciesByHolder("Alice"));
    }
}
