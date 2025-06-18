package com.example.controller;

import com.example.model.Branch;
import com.example.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/branches")
public class BranchController {

    @Autowired
    private BranchService branchService;

    // Hiển thị danh sách 
    @GetMapping
    public String listBranches(Model model) {
        List<Branch> branches = branchService.findAll();
        model.addAttribute("branches", branches);
        return "view";
    }

    // Hiển thị form thêm mới 
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("branch", new Branch());
        return "list-form-branch";
    }

    // Hiển thị form cập nhật
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Branch branch = branchService.findById(id);
        model.addAttribute("branch", branch);
        return "list-form-branch";
    }

    // Xử lý cập nhật
    @PostMapping("/edit")
    public String updateBranch(@ModelAttribute Branch branch) {
        branchService.update(branch);
        return "redirect:/branches";
    }
    
    @PostMapping("/save")
    public String saveBranch(@ModelAttribute Branch branch) {
        if (branch.getId() == 0 || branch.getId() <0){
            branchService.save(branch);
        } else {
            branchService.update(branch);
        }
        return "redirect:/branches";
    }

    // Xử lý xóa
    @GetMapping("/delete/{id}")
    public String deleteBranch(@PathVariable("id") int id) {
        branchService.delete(id);
        return "redirect:/branches";
    }
}
