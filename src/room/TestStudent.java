package room;

import room.model.Student;
import room.serivce.StudentService;

import java.util.Scanner;

public class TestStudent {

    public static void main(String[] args) {

        StudentService studentService = new StudentService();

        boolean isActive = true;

        Student [] students = new Student[10];
        int index = 0;

        while (isActive) {
            System.out.println("---------Menu--------");
            System.out.println("Enter 1 to create Student");
            System.out.println("Enter 2 to print info of  max student");
            System.out.println("Enter 3 to get all Female Students");
            System.out.println("Enter 4 to get youngest student info");
            System.out.println("Enter 5 to get youngest girl info");
            System.out.println("Enter 6. Exit");

            Scanner scanner = new Scanner(System.in);
            int number = scanner.nextInt();

            switch (number) {
                case 1:
                    students[index] = studentService.create();
                    if (index < students.length - 1)
                        index++;
                    break;
                case 2:
                    Student [] array2 = new Student[index];
                    for (int i = 0; i < array2.length; i++) {
                        array2[i] = students[i];
                    }
                    Student maxStudent = studentService.maxStudent(array2);
                    maxStudent.printInfo();
                    break;
                case 3:
                    if (index > 0) {
                        Student [] array3 = new Student[index];
                        for (int i = 0; i < index; i++) {
                            array3[i] = students[i];
                        }
                        studentService.getGirls(array3);
                        System.out.println("-------------------------");
                    } else {
                        System.out.println("Please the first create Student");
                    }
                    break;
                case 4:
                    Student [] array4 = new Student[index];
                    for (int i = 0; i < array4.length; i++) {
                        array4[i] = students[i];
                    }
                    Student minStudent = studentService.minStudent(array4);
                    minStudent.printInfo();
                    break;
                case 5:
                    if (index > 0) {
                        Student [] array5 = new Student[index];
                        for (int i = 0; i < index; i++) {
                            array5[i] = students[i];
                        }
                        studentService.minGirlStudent(array5);
                    } else {
                        System.out.println("Please the first create Student");
                    }
                    break;
                case 6:
                    isActive = false;
            }
        }
    }
}
