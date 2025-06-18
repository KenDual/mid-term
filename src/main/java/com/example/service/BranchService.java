package com.example.service;

import com.example.model.Branch;
import com.example.repository.BranchRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BranchService {

    @Autowired
    private BranchRepository branchRepository;

    public List<Branch> findAll() {
        return branchRepository.findAll();
    }

    public Branch findById(int id) {
        return branchRepository.findById(id);
    }

    public void save(Branch branch) {
        branchRepository.save(branch);
    }

    public void update(Branch branch) {
        branchRepository.update(branch);
    }

    public void delete(int id) {
        branchRepository.delete(id);
    }
}
