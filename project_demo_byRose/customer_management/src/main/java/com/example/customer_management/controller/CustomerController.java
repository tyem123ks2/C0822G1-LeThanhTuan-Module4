package com.example.customer_management.controller;

import com.example.customer_management.model.Customer;
import com.example.customer_management.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping(value = "/show-list")
    public String showCustomerList(Model model) {
        List<Customer> customerList = customerService.showCustomerList();
        model.addAttribute("customerList", customerList);
        return "customer/list";
    }

    @GetMapping(value = "/detail/{id}")
    public String showDetail(Model model, @PathVariable("id") Long id) {
        Optional<Customer> customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        return "customer/detail";
    }

    @GetMapping(value = "/show-form-create")
    public String showFormCreate(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "customer/create";
    }

    @PostMapping(value = "/create")
    public String createNewCustomer(Model model,Customer customer, RedirectAttributes redirectAttributes) {
        boolean check = customerService.addNewCustomer(customer);
        String message;
        if (check) {
            message = "Thêm mới khách hàng thành công!";
        } else {
            message = "Thêm mới thất bại!";
        }
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/customer/show-list";
    }

    @PostMapping(value = "/edit")
    public String editCustomer(Customer customer, RedirectAttributes redirectAttributes) {
        boolean check = customerService.updateCustomer(customer);
        String message;
        if (check) {
            message = "Chỉnh sửa thành công";
        } else {
            message = "Chỉnh sửa thất bại";
        }
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/customer/list";
    }

    @GetMapping(value = "/delete")
    public String deleteCustomer(Customer customer, RedirectAttributes redirectAttributes) {
        boolean check = customerService.removeCustomer(customer.getId());
        String message;
        if (check) {
            message = "Xóa khách hàng thành công";
        } else {
            message = "Xóa thất bại";
        }
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/customer/list";
    }
}
