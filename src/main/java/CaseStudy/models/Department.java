package CaseStudy.models;

import javax.persistence.*;

@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String departmentCode;

    private String departmentName ;

    private double departmentPhone ;

    public Department(){}

    public Department(Long id, String departmentCode, String departmentName, double departmentPhone){
        this.id = id ;
        this.departmentCode = departmentCode;
        this.departmentName = departmentName ;
        this.departmentPhone = departmentPhone ;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public double getDepartmentPhone() {
        return departmentPhone;
    }

    public void setDepartmentPhone(double departmentPhone) {
        this.departmentPhone = departmentPhone;
    }
}
