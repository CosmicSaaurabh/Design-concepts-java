package com.saurabh.uml;

import java.util.Arrays;
import java.util.List;

// Department class have a weak has-a relationship with professor class
// as professor objects are still available if we delete the department object
class Department {
    private String name;

    private List<Professor> professorList;

    Department(String name, List<Professor> professorList) {
        this.name = name;
        this.professorList = professorList;
    }

    public void showAllProfessors() {
        System.out.println("Department: " + name + " have these professors");
        for (Professor professor : professorList) {
            System.out.println(professor.getProfessorName());
        }
    }
}

class Professor {
    private String name;

    Professor(String name) {
        this.name = name;
    }

    public String getProfessorName() {
        return name;
    }
}
public class AggregationExample {
    public static void main(String[] args) {
        Professor prof1 = new Professor("prof 1");
        Professor prof2 = new Professor("prof 2");

        List<Professor> professorList = Arrays.asList(prof2, prof1);
        Department dept = new Department("Department 1", professorList);
        dept.showAllProfessors();
    }
}
