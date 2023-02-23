package com.example.furama_resort_management.controller;


import com.example.furama_resort_management.dto.FacilityDto;
import com.example.furama_resort_management.model.facility.Facility;
import com.example.furama_resort_management.model.facility.FacilityType;
import com.example.furama_resort_management.model.facility.RentType;
import com.example.furama_resort_management.service.facility.IFacilityService;
import com.example.furama_resort_management.service.facility.IFacilityTypeService;
import com.example.furama_resort_management.service.facility.IRentTypeService;
import exception.FacilityNameDuplicationException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "facility")
public class FacilityController {

    @Autowired
    private IFacilityService facilityService;

    @Autowired
    private IFacilityTypeService facilityTypeService;

    @Autowired
    private IRentTypeService rentTypeService;

    @GetMapping(value = "/show-list")
    public String showList(Model model, @RequestParam(value = "searchName", defaultValue = "") String name,
                           @RequestParam(value = "searchTypeId", defaultValue = "") String typeId,
                           @PageableDefault(size = 3) Pageable pageable) {
        Page<Facility> facilityPage;
        if (typeId.equals("")) {
            facilityPage = facilityService.searchName(name, pageable);
        } else {
            facilityPage = facilityService.searchNameAndFacilityType(name, Integer.parseInt(typeId), pageable);
        }
        List<RentType> rentTypeList = rentTypeService.getAllRentType();
        List<FacilityType> facilityTypeList = facilityTypeService.getAllType();
        model.addAttribute("facility", new FacilityDto());
        model.addAttribute("facilityPage", facilityPage);
        model.addAttribute("facilityTypeList", facilityTypeList);
        model.addAttribute("rentTypeList", rentTypeList);
        return "facility/list";
    }

    @PostMapping(value = "/add-facility")
    public String addNewFacility(@Validated @ModelAttribute("facility") FacilityDto facilityDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Pageable pageable, Model model) {
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto, facility);
        try {
            boolean check = facilityService.addFacility(facility);
            String mess;
            if (check) {
                mess = "Thêm mới dịch vụ thành công";
            } else {
                mess = "Đã xảy ra lỗi";
            }
            redirectAttributes.addFlashAttribute("mess", mess);
            return "redirect:/facility/show-list";
        } catch (FacilityNameDuplicationException e) {
            bindingResult.rejectValue("name", "name", "Tên dịch vụ đã tồn tại");
        }
        Page<Facility> facilityPage = facilityService.searchName("", pageable);
        List<RentType> rentTypeList = rentTypeService.getAllRentType();
        List<FacilityType> facilityTypeList = facilityTypeService.getAllType();
        model.addAttribute("facility", facilityDto);
        model.addAttribute("facilityPage", facilityPage);
        model.addAttribute("facilityTypeList", facilityTypeList);
        model.addAttribute("rentTypeList", rentTypeList);
        model.addAttribute("isModal",true);
        return "facility/list";

    }

    @PostMapping(value = "/edit-facility")
    public String editFacility(@Validated @ModelAttribute("facility") FacilityDto facilityDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Pageable pageable, Model model) {
        if (bindingResult.hasErrors()) {
            Page<Facility> facilityPage = facilityService.searchName("", pageable);
            List<RentType> rentTypeList = rentTypeService.getAllRentType();
            List<FacilityType> facilityTypeList = facilityTypeService.getAllType();
            model.addAttribute("facility", facilityDto);
            model.addAttribute("facilityPage", facilityPage);
            model.addAttribute("facilityTypeList", facilityTypeList);
            model.addAttribute("rentTypeList", rentTypeList);
            return "facility/list";
        }
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto, facility);
        boolean check = facilityService.editFacility(facility);
        String mess;
        if (check) {
            mess = "Chỉnh sửa dịch vụ thành công";
        } else {
            mess = "Đã xảy ra lỗi";
        }
        redirectAttributes.addFlashAttribute("mess", mess);
        return "redirect:/facility/show-list";
    }

    @PostMapping(value = "/delete-facility")
    public String deleteFacility(@ModelAttribute("facility") FacilityDto facilityDto, RedirectAttributes redirectAttributes) {
        Facility facility = facilityService.findById(facilityDto.getId());
        String mess;
        if (facility == null) {
            mess = "Không tìm thấy dịch vụ muốn xóa";
        } else {
            facility.setDeleted(true);
            boolean check = facilityService.editFacility(facility);
            if (check) {
                mess = "Xóa dịch vụ thành công";
            } else {
                mess = "Đã xảy ra lỗi";
            }
        }
        redirectAttributes.addFlashAttribute("mess", mess);
        return "redirect:/facility/show-list";
    }
}