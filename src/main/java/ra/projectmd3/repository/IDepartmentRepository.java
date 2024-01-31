package ra.projectmd3.repository;

import ra.projectmd3.model.Department;

public interface IDepartmentRepository extends IGenericRepository<Department,Integer> {
    int countEmployeeByDepartmentId(Integer id);
}
