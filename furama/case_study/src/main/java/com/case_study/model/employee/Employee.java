package com.case_study.model.employee;

import com.case_study.model.Person;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Employee extends Person {
    private double salary;
    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "positionId")
    private Position position;
    @ManyToOne
    @JoinColumn(name = "education_id", referencedColumnName = "educationId")
    private EducationDegree educationDegree;
    @ManyToOne
    @JoinColumn(name = "division_id", referencedColumnName = "divisionId")
    private Division division;

    public Employee() {
    }

    public Employee(Long id, String name, LocalDate dateOfBirth, String idCard, String phoneNumber, String email, String address, double salary, Position position, EducationDegree educationDegree, Division division) {
        super(id, name, dateOfBirth, idCard, phoneNumber, email, address);
        this.salary = salary;
        this.position = position;
        this.educationDegree = educationDegree;
        this.division = division;
    }

    public Employee(String name, LocalDate dateOfBirth, String idCard, String phoneNumber, String email, String address, double salary, Position position, EducationDegree educationDegree, Division division) {
        super(name, dateOfBirth, idCard, phoneNumber, email, address);
        this.salary = salary;
        this.position = position;
        this.educationDegree = educationDegree;
        this.division = division;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }
}
