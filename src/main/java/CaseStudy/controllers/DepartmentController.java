package CaseStudy.controllers;

import CaseStudy.models.Department;
import CaseStudy.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @ModelAttribute("/admin/departments")
    public Page<Department> departments(Pageable pageable){
        return departmentService.findAll(pageable);
    }


    @GetMapping("/admin")
    public String home(){
        return "home";
    }

    @GetMapping("/admin/department-list")
    public String departmentList(Model model, @PageableDefault(size = 5 ) Pageable pageable){
        Page<Department> departments = departmentService.findAll(pageable);
        model.addAttribute("department", departments);
        return "department/list";
    }

    @GetMapping("/admin/create-department")
    public String showFormCreate(Model model){
        model.addAttribute("department", new Department());
        return "department/create";
    }

    @PostMapping("/admin/create-department")
    public String saveCreate(Department department, Model model, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            model.addAttribute("errorMessage" , bindingResult.getAllErrors());
            return "/department/create";
        }
        departmentService.save(department);
        model.addAttribute("department",new Department());
        model.addAttribute("message","Create success a new department");
        return "/department/create";
    }
    @GetMapping("/admin/edit-department/{id}")
    public String showFormEdit(Model model, @PathVariable Long id){
        Department department = departmentService.findById(id);
        model.addAttribute("department", department);
        return "/department/edit";
    }

    @PostMapping("/admin/edit-department")
    public String saveEdit(Model model , Department department){
        departmentService.save(department);
        model.addAttribute("department",department);
        model.addAttribute("message", "Edit success department");
        return "/department/edit";
    }

    @GetMapping("/admin/delete-department/{id}")
    public String showFormDelete(Model model , @PathVariable Long id){
        Department department = departmentService.findById(id);
        model.addAttribute("department", department);
        return "/department/delete";
    }

    @PostMapping("/admin/delete-department")
    public String deleteDepartment(Department department){
        departmentService.remove(department.getId());
        return "redirect:/admin/department-list";
    }
    @PostMapping("/admin/department-search")
    public String searchDepartment(Model model, @RequestParam("search") String search,@PageableDefault(size = 5)Pageable pageable){
        if (search.equals("")){
            return "redirect:/admin/department-list";
        }
        Page<Department> departments = departmentService.findAll(pageable);
        List<Department> result = new ArrayList<>();
        for (Department department : departments){
            if (department.getDepartmentName().toLowerCase().contains(search.toLowerCase())) {
                result.add(department);
            }
            }
        model.addAttribute("department" , result);
        return "department/list";
        }
}



