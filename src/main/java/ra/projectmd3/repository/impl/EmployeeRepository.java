package ra.projectmd3.repository.impl;

import org.springframework.stereotype.Repository;
import ra.projectmd3.model.Employee;
import ra.projectmd3.repository.IEmployeeRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional // quản lí transaction
public class EmployeeRepository implements IEmployeeRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> typedQuery = entityManager.createQuery("select E from Employee E", Employee.class);
        return typedQuery.getResultList();
    }

    @Override
    public Employee findById(Integer id) {
        TypedQuery<Employee> typedQuery = entityManager.createQuery("select E from Employee E where  E.id= :id", Employee.class);
        typedQuery.setParameter("id",id);
        return typedQuery.getSingleResult();
    }

    @Override
    public void save(Employee employee) {
        if (employee.getId()==null){
            // thêm mới
            entityManager.persist(employee);
        }else {
            // cập nhật
            entityManager.merge(employee);
        }
    }

    @Override
    public void deleteById(Integer id) {
        entityManager.remove(findById(id));
    }

    @Override
    public List<Employee> findByName(String name) {
        return null;
    }
}
