package com.github.iamcathal;

import org.joda.time.DateTime;

import java.util.*;

public class Driver {

    Student smartStudent;
    Student okStudent;
    Student lessSmartStudent;

    Module softwareEng;
    Module webDev;
    Module CProgramming;

    Course ComputerScience;
    Course SoftwareDevelopment;

    ArrayList<Module> firstGroupModules;
    ArrayList<Module> secondGroupModules;
//    ArrayList<Student> firstGroupStudents;
//    ArrayList<Student> secondGroupStudents;

    public void initModules() {
        ArrayList<Student> firstGroupStudents = new ArrayList<>();
        firstGroupStudents.add(smartStudent);
        firstGroupStudents.add(lessSmartStudent);

        ArrayList<Student> secondGroupStudents = new ArrayList<>();
        secondGroupStudents.add(okStudent);
        secondGroupStudents.add(lessSmartStudent);

        ArrayList<Course> courseListOne = new ArrayList<>();
        courseListOne.add(SoftwareDevelopment);
        softwareEng = new Module(
          "Software Engineering",
          105,
                firstGroupStudents,
                courseListOne
        );
        webDev = new Module(
                "Web Development",
                106,
                firstGroupStudents,
                courseListOne
        );
        ArrayList<Course> courseListTwo = new ArrayList<>();
        courseListOne.add(ComputerScience);
        CProgramming = new Module(
                "C Programming",
                107,
                secondGroupStudents,
                courseListTwo
        );

        firstGroupModules = new ArrayList<>();
        firstGroupModules.add(CProgramming);
        firstGroupModules.add(webDev);

        secondGroupModules = new ArrayList<>();
        secondGroupModules.add(webDev);
        secondGroupModules.add(softwareEng);
    }

    public void initCourses() {
        ArrayList<Student> firstGroupStudents = new ArrayList<>();
        firstGroupStudents.add(smartStudent);
        firstGroupStudents.add(lessSmartStudent);
//
        ArrayList<Student> secondGroupStudents = new ArrayList<>();
        secondGroupStudents.add(okStudent);
        secondGroupStudents.add(lessSmartStudent);

        ComputerScience = new Course(
                "Computer Science (BSc)",
                firstGroupModules,
                firstGroupStudents,
                new DateTime(),
                new DateTime()
        );
        SoftwareDevelopment = new Course(
                "Software Development (BSc)",
                secondGroupModules,
                secondGroupStudents,
                new DateTime(),
                new DateTime()
        );
    }

    public void initStudents() {
        smartStudent = new Student(
            "Cathal",
                21,
                new DateTime(),
                new ArrayList<>(),
                new ArrayList<>()
        );
        okStudent = new Student(
                "Joe",
                20,
                new DateTime(),
                new ArrayList<>(),
                new ArrayList<>()
        );
        lessSmartStudent = new Student(
                "Ross",
                20,
                new DateTime(),
                new ArrayList<>(),
                new ArrayList<>()
        );
    }

    public void runScenarios() {
        firstGroupModules = new ArrayList<>();
        firstGroupModules.add(softwareEng);
        firstGroupModules.add(webDev);

        secondGroupModules = new ArrayList<>();
        secondGroupModules.add(CProgramming);
        secondGroupModules.add(webDev);

        initStudents();
        initModules();
        initCourses();
    }

    public void printCourseInfo(Course course) {
        System.out.println(course.getCourseName() + " has modules:");
        for (Module module: course.getModules()) {
            System.out.println("\t" + module.getModuleName() + " has students:");
            for (Student students: module.getStudents()) {
                System.out.println("\t\t" + students.getName());
            }
        }
        System.out.println("");
    }

    public void printInformation() {
        System.out.println("Module Information");
        System.out.println(webDev);
        System.out.println(softwareEng);
        System.out.println(CProgramming);

        System.out.println("\n\n");

        System.out.println("Student Information");
        System.out.println(smartStudent);
        System.out.println(okStudent);
        System.out.println(lessSmartStudent);

        System.out.println("\n\n");

        printCourseInfo(SoftwareDevelopment);
        System.out.println("");
        printCourseInfo(ComputerScience);

    }

    public static void main(String[] args) {
        Driver driver = new Driver();
        driver.runScenarios();
        driver.printInformation();
    }
}
