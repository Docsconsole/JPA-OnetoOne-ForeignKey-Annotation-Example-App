package com.docsconsole.tutorials.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "EMPLOYEE_DETAILS")
public class EmployeeDetails implements Serializable {

    private static final long serialVersionUID = 88889999999L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMP_DET_ID")
    private Long empDetId;

    @Column(name = "EMP_PHONE_NUMBER")
    private Long empPhoneNum;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "EMP_ID", referencedColumnName = "EMP_ID")
    private Employee employee;

    public EmployeeDetails() {
    }

}
