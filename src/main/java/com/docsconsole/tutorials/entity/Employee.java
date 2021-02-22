package com.docsconsole.tutorials.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "EMPLOYEE")
public class Employee implements Serializable {

    private static final long serialVersionUID = 88889999998L;
    @Id
    @Column(name = "EMP_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empId;

    @Column(name = "EMP_NAME")
    private String empName;

    @Column(name = "EMP_SAL")
    private Long empSal;

    @OneToOne(mappedBy = "employee")
    private EmployeeDetails empDet;

    public Employee() {
    }

}
