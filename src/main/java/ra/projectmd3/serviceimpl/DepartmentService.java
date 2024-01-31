package ra.projectmd3.serviceimpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ra.projectmd3.model.Department;
import ra.projectmd3.repository.IDepartmentRepository;
import ra.projectmd3.service.IDepartmentService;

import java.util.List;
@Service
@RequiredArgsConstructor // tạo constructor vói các trường được khai báo final
public class DepartmentService implements IDepartmentService {
    private final IDepartmentRepository departmentRepository;
    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department findById(Integer id) {
        return departmentRepository.findById(id);
    }

    @Override
    public void save(Department dto) {
        departmentRepository.save(dto);
    }

    @Override
    public void deleteById(Integer id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public List<Department> findByName(String name) {
        return null;
    }
}
