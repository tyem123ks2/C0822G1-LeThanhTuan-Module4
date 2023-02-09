package com.example.register.controller;

import com.example.register.dto.UserDto;
import com.example.register.model.User;
import com.example.register.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("")
        public String showList(Model model){
        List<User> userList = userService.showUserList();
        model.addAttribute("userList", userList);
        User user = new User();
        model.addAttribute("user", user);
        return "/list";
    }

    @GetMapping("/create")
        public String showCreateUser(Model model){
        model.addAttribute("userDuo", new UserDto());
        return "create";
    }
    @PostMapping("/save")
    public String save(@Validated @ModelAttribute UserDto userDto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes){
        new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("userDto", userDto);
            return "/create";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        redirectAttributes.addFlashAttribute("messasge", "Thêm mới thành công");
        return "redirect:/user";
    }
}
