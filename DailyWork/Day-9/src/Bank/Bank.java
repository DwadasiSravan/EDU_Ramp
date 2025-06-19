package Bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Branch> branches = new ArrayList<>();

    public void addBranch(Branch branch) {
        branches.add(branch);
    }

    public List<Branch> getBranches() {
        return branches;
    }

    public Branch getBranchByName(String name) {
        for (Branch branch : branches) {
            if (branch.getBranchName().equalsIgnoreCase(name)) {
                return branch;
            }
        }
        return null;
    }
}