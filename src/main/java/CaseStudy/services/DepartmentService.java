package CaseStudy.services;

import CaseStudy.models.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DepartmentService {
    Page<Department> findAll(Pageable pageable);
//    Page<Department> findAllByDepartment(Department department , Pageable pageable);
    Department findById(Long id);
    void save(Department department);
    void remove(Long id);


}
