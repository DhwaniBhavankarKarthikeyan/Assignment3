package Assignment3;

public class Student {

	private int prn;
	private String name;
	private String dob;
	private double marks;
	
	public int getPrn() {
		return prn;
	}
	
	public void setPrn(int prn) {
		this.prn = prn;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}
	
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	public double getMarks() {
		return marks;
	}
	
	public void setMarks(double marks) {
		this.marks = marks;
	}
	
	@Override
	public String toString() {
		return "Student [prn=" + prn + ", name=" + name + ", dob=" + dob + ", marks=" + marks + "]";
	}

	public Student(int prn) {
		this.prn = prn;
	}
	
	public Student(int prn,String name) {
		this(prn);
		this.name=name;
	}
	
	public Student(int prn,String name,double marks) {
		this(prn,name);
		this.marks=marks;
	}
	
	public Student(int prn,String name,double marks,String dob) {
		this(prn,name,marks);
		this.dob=dob;
	}

	private int position;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
}
}

package Assignment3;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentFunctions {

    private ArrayList<Student> studentDatabase = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void addStudent() {
        System.out.println("How many Students ? ");
        int noOfStudent = sc.nextInt();
        for (int i = 0; i < noOfStudent; i++) {
            System.out.println("Enter PRN : ");
            int prn = sc.nextInt();

            System.out.println("Enter Name : ");
            String name = sc.next();

            System.out.println("Enter dob : ");
            String dob = sc.next();

            System.out.println("Enter marks : ");
            double marks = sc.nextDouble();

            Student s = new Student(prn, name, marks, dob);
            studentDatabase.add(s);
        }
    }

    public void printStudentDetails() {
        System.out.println("------Student Details-----");
        System.out.println("PRN" + "  " + "Name" + "  " + "Marks");

        for (Student student : studentDatabase) {
            int prn = student.getPrn();
            String name = student.getName();
            double marks = student.getMarks();

            System.out.println(prn + "   " + name + "    " + marks);
        }
    }

    public boolean deleteStudent() {
        System.out.println("Delete Student");
        System.out.println("Enter PRN: ");
        int prn = sc.nextInt();

        for (Student student : studentDatabase) {
            if (student.getPrn() == prn) {
                System.out.println(student.getName() + " removed from the Database");
                studentDatabase.remove(student);
                return true;
            }
        }
        System.out.println("Student with PRN " + prn + " not found.");
        return false;
    }

    public void updateByPrn() {
        System.out.println("Enter PRN : ");
        int prn = sc.nextInt();

        for (Student student : studentDatabase) {
            if (student.getPrn() == prn) {
                System.out.println("Enter New name : ");
                String newName = sc.next();
                student.setName(newName);

                System.out.println("Enter dob : ");
                String dob = sc.next();
                student.setDob(dob);

                System.out.println("Enter marks : ");
                double marks = sc.nextDouble();
                student.setMarks(marks);

                System.out.println("Student with PRN " + prn + " updated successfully.");
                return;
            }
        }
        System.out.println("Student with PRN " + prn + " not found.");
    }

    public void searchByPrn() {
        System.out.println("Enter PRN to search: ");
        int prn = sc.nextInt();

        for (Student student : studentDatabase) {
            if (student.getPrn() == prn) {
                System.out.println("Student found: " + student);
                return;
            }
        }
        System.out.println("Student with PRN " + prn + " not found.");
    }

    public void searchByName() {
        System.out.println("Enter Name to search: ");
        String desiredName = sc.nextLine();  // Read the entire line

        for (Student student : studentDatabase) {
            if (student.getName().equalsIgnoreCase(desiredName)) {
                System.out.println("Student found: " + student);
                return;
            }
        }

        System.out.println("Student with name '" + desiredName + "' not found.");
    }

  

    public void searchByPosition() {
        System.out.println("Enter Position to search: ");
        int desiredPosition = sc.nextInt();
        boolean found = false;

        for (Student student : studentDatabase) {
            int studentPosition = student.getPosition();

            if (studentPosition == desiredPosition) {
                System.out.println("Student found: " + student);
                found = true;
                break;  // Exit the loop once the student is found
            }
        }

        if (!found) {
            System.out.println("Student with position '" + desiredPosition + "' not found.");
        }
    }
}


package Assignment3;

import java.util.Scanner;

public class StudentDemo {

    public static void main(String[] args) {
        StudentFunctions studentFunctions = new StudentFunctions();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Add students");
            System.out.println("2. Display students");
            System.out.println("3. Search students by PRN");
            System.out.println("4. Search students by Name");
            System.out.println("5. Search students by Position");
            System.out.println("6. Update students by PRN");
            System.out.println("7. Delete student by PRN");
            System.out.println("8. Exit");

            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    studentFunctions.addStudent();
                    break;
                case 2:
                    studentFunctions.printStudentDetails();
                    break;
                case 3:
                    studentFunctions.searchByPrn();
                    break;
                case 4:
                    studentFunctions.searchByName();
                    break;
                case 5:
                    studentFunctions.searchByPosition();
                    break;
                case 6:
                    studentFunctions.updateByPrn();
                    break;
                case 7:
                    studentFunctions.deleteStudent();
                    break;
                case 8:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 8.");
            }

        } while (choice != 8);

        // Close the scanner to avoid resource leak
        scanner.close();
    }
}
