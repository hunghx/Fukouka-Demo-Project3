package ra.projectmd3.serviceimpl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ra.projectmd3.dto.request.EmployeeRequestDto;
import ra.projectmd3.model.Employee;
import ra.projectmd3.repository.IEmployeeRepository;
import ra.projectmd3.service.IEmployeeService;
import ra.projectmd3.service.UploadService;

import java.util.List;

@Service
@RequiredArgsConstructor

public class EmployeeService implements IEmployeeService {
    private final IEmployeeRepository employeeRepository;

    private final UploadService uploadService;
    private  final ModelMapper modelMapper;
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void save(EmployeeRequestDto dto) {
        // upload file nếu có
        // chuyên đổi dto -> entity
        String avatarUrl = null;
        if (dto.getEmployee().getId()!=null){
            // ko  gửi id lên
            avatarUrl = employeeRepository.findById(dto.getEmployee().getId()).getAvatar();
        }
        // up load ảnh nếu có
        if (dto.getFile().getSize()!=0){
            avatarUrl= uploadService.uploadFileToServer(dto.getFile());
        }
        // chuyển đổi tù dto -> model
        Employee employee = dto.getEmployee();
        employee.setAvatar(avatarUrl);
        employeeRepository.save(employee);
    }

    @Override
    public void deleteById(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findByName(String name) {
        return null;
    }
}
