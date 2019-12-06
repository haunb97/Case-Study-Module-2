package CaseStudy.repositories;

import CaseStudy.models.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface  DepartmentRepository extends PagingAndSortingRepository<Department, Long> {
//    Page<Department>findAllByDepartment(Department department, Pageable pageable);
}
