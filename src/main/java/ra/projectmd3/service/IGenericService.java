package ra.projectmd3.service;

import java.util.List;

public interface IGenericService <T,E,U>{
    List<T> findAll();
    T findById(E id);
    void save(U dto);
    void deleteById(E id);
    List<T> findByName(String name);
}
