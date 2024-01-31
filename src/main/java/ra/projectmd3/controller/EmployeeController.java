package ra.projectmd3.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ra.projectmd3.dto.request.EmployeeRequestDto;
import ra.projectmd3.model.Department;
import ra.projectmd3.model.Employee;
import ra.projectmd3.service.IDepartmentService;
import ra.projectmd3.service.IEmployeeService;

@Controller
@RequestMapping("/employee")
@RequiredArgsConstructor
@CrossOrigin("*")
public class EmployeeController {
    private final IEmployeeService employeeService;
    private final IDepartmentService departmentService;
    @RequestMapping
    public String viewDepartment(Model model){
        model.addAttribute("employees",employeeService.findAll());
        return "employee/index";
    }
    @RequestMapping("/delete") // /delete?id=10
    public  String deleteById(@RequestParam Integer id, RedirectAttributes redirectAttributes){
        int count = 0 ; // lấy về số lượng nhân viên trong phòng ban
        if (count>0){
            return "redirect:/employee?error";
        }
        employeeService.deleteById(id);
        return "redirect:/employee";
    }
    @RequestMapping("/form")
    public ModelAndView form(@RequestParam(name = "id" ,required = false) Integer id){
        Employee employee = new Employee();
        if (id!=null){
            employee = employeeService.findById(id);
            if (employee==null){
                throw new RuntimeException("dung co truy cap trai phep nua");
            }
        }
        ModelAndView modelAndView = new ModelAndView("employee/add_edit");
        modelAndView.addObject("employee",employee);
        modelAndView.addObject("departments",departmentService.findAll());
        return modelAndView;
    }
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(@ModelAttribute("employee") Employee employee, @RequestParam("file")MultipartFile file){
        EmployeeRequestDto dto = new EmployeeRequestDto(employee,file); // gộp 2 đối tương thành 1 dto
        employeeService.save(dto);
        return "redirect:/employee";
    }
}
