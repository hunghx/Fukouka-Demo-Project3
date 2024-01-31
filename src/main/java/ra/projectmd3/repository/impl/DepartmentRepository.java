package ra.projectmd3.repository.impl;

import org.springframework.stereotype.Repository;
import ra.projectmd3.model.Department;
import ra.projectmd3.repository.IDepartmentRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class DepartmentRepository implements IDepartmentRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Department> findAll() {
        TypedQuery<Department> typedQuery = entityManager.createQuery("select  D from Department  D" , Department.class);
        return typedQuery.getResultList();
    }

    @Override
    public Department findById(Integer id) {
        TypedQuery<Department> typedQuery = entityManager.createQuery("select  D from Department  D where D.id=:id" , Department.class);
       typedQuery.setParameter("id",id);
        return typedQuery.getSingleResult();
    }

    @Override
    public int countEmployeeByDepartmentId(Integer id) {
      return 0;
    }

    @Override
    public void save(Department department) {
        if (department.getId()==null){
            // thêm mới
            entityManager.persist(department);
        }else {
            // cập nhật
            entityManager.merge(department);
        }
    }

    @Override
    public void deleteById(Integer id) {
        entityManager.remove(findById(id));
    }

    @Override
    public List<Department> findByName(String name) {
        return null;
    }
}
