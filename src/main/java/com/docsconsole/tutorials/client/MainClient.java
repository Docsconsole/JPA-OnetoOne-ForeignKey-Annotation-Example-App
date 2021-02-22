package com.docsconsole.tutorials.client;

import com.docsconsole.tutorials.entity.Employee;
import com.docsconsole.tutorials.entity.EmployeeDetails;
import com.docsconsole.tutorials.utils.JPAUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class MainClient {


    public static void main(String[] args) {
        System.out.println("the main method");

        EntityManager entityManager = JPAUtils.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = null;
        try {

            transaction = entityManager.getTransaction();
            transaction.begin();

            // creates a new product
            Employee employee = new Employee();
            employee.setEmpName("Dan");
            employee.setEmpSal(new Long(100000));

            // creates product detail
            EmployeeDetails empDet = new EmployeeDetails();
            empDet.setEmpPhoneNum(new Long("9976453111"));

            // Save employee
            //entityManager.persist(employee);
            empDet.setEmployee(employee);

            // Save employee
            entityManager.persist(empDet);

            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            entityManager.close();
        }
    }
}
