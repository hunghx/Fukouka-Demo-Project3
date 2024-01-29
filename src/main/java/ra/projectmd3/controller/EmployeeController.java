package ra.projectmd3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.projectmd3.model.Employee;
import ra.projectmd3.repository.IEmployeeRepository;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private IEmployeeRepository employeeRepository;
    @RequestMapping
    public String findAll(){
        List<Employee> list= employeeRepository.findAll();
        return "home";
    }
    @RequestMapping("/{id}")
    public String findById(@PathVariable Integer id){
        Employee employee= employeeRepository.findById(id);
        return "home";
    }@RequestMapping("/add")
    public String add(){
        Employee employee = new Employee();
        employee.setName("hung hx");
        employeeRepository.save(employee);
        return "home";
    }
    @RequestMapping("/edit")
    public String edit(){
        Employee employee = new Employee(1,"Nguyễn Văn A");
        employeeRepository.save(employee);
        return "home";
    }@RequestMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        employeeRepository.deleteById(id);
        return "home";
    }
}
