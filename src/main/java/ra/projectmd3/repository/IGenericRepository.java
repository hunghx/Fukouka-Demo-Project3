package ra.projectmd3.repository;

import java.util.List;

public interface IGenericRepository <T,E>{
    List<T> findAll();
    T findById(E id);
    void save(T t);
    void deleteById(E id);
}
