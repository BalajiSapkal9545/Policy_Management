import java.util.ArrayList;
import java.util.List;

class PolicyManager {
    private List<Policy> policies = new ArrayList<>();

    public void addPolicy(Policy policy) {
        policies.add(policy);
        System.out.println("Policy added successfully.");
    }

    public void removePolicyByNumber(int policyNumber) {
        policies.removeIf(policy -> policy.getPolicyNumber() == policyNumber);
        System.out.println("Policy removed if existed.");
    }

    public void updatePolicy(int policyNumber, String name, String type, double coverage) {
        for (Policy policy : policies) {
            if (policy.getPolicyNumber() == policyNumber) {
                policy.setPolicyHolderName(name);
                policy.setInsuranceType(type);
                policy.setCoverageAmount(coverage);
                System.out.println("Policy updated.");
                return;
            }
        }
        System.out.println("Policy not found.");
    }

    public void listPoliciesByType(String type) {
        boolean found = false;
        for (Policy policy : policies) {
            if (policy.getInsuranceType().equalsIgnoreCase(type)) {
                System.out.println(policy);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No policies found for type: " + type);
        }
    }

    public void listAllPolicies() {
        if (policies.isEmpty()) {
            System.out.println("No policies available.");
        } else {
            for (Policy policy : policies) {
                System.out.println(policy);
            }
        }
    }
}
