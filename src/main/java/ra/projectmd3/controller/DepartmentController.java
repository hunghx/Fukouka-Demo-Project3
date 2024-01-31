package ra.projectmd3.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ra.projectmd3.model.Department;
import ra.projectmd3.service.IDepartmentService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {
    private  final IDepartmentService departmentService;
    @RequestMapping
    public String viewDepartment(Model model){
        model.addAttribute("departments",departmentService.findAll());
        return "department/index";
    }
    @RequestMapping("/delete") // /delete?id=10
    public  String deleteById(@RequestParam Integer id){
        departmentService.deleteById(id);
        return "redirect:/department";
    }
    @RequestMapping("/form")
    public ModelAndView form(@RequestParam(name = "id" ,required = false) Integer id){
        Department department = new Department();
        if (id!=null){
            department = departmentService.findById(id);
            if (department==null){
                throw new RuntimeException("dung co truy cap trai phep nua");
            }
        }
        ModelAndView modelAndView = new ModelAndView("department/add_edit");
        modelAndView.addObject("department",department);
        return modelAndView;
    }
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(@ModelAttribute("department") Department department){
        departmentService.save(department);
        return "redirect:/department";
    }

}
