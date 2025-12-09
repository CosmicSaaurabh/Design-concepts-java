package com.saurabh.uml;

// both class are associated with each other but they both can exist independently
class Student {
    private String name;

    Student(String name) {
        this.name = name;
    }

    public String getStudentName() {
        return name;
    }
}

class Teacher {
    private String name;

    Teacher(String name) {
        this.name = name;
    }

    public void teaches(Student student) {
        System.out.println("Teacher name " + name + " teaches student " + student.getStudentName());
    }
}
public class AssociationExample {
    public static void main(String[] args) {
        Student st = new Student("Saurabh");
        Teacher t = new Teacher("Anjali");

        t.teaches(st);
    }
}
