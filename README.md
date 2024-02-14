**Student Management System**

This Java application serves as a simple yet effective Student Management System that allows users to perform various operations on a student database. 
Developed as part of an assignment, the system enables users to add, view, search, update, and delete student records. 
The program is organized into two main classes: Student and StudentFunctions. 
The Student class encapsulates the properties of a student, including PRN (Personal Registration Number), name, date of birth, marks, and position. 
On the other hand, the StudentFunctions class provides methods for user interaction, such as adding students, displaying details, searching by PRN or name, updating by PRN, deleting by PRN, and searching by position.

A brief description of each function in the StudentFunctions class:

1. addStudent():
  Prompts the user to input the number of students to add.
  Takes user input for each student's PRN, name, date of birth, and marks.
  Creates a new Student object for each input and adds it to the student database.
2. printStudentDetails():
  Displays a formatted table of PRN, Name, and Marks for all students in the database.
3. deleteStudent():
  Prompts the user to enter the PRN of the student to be deleted.
  Searches for the student with the given PRN and removes them from the database.
4. updateByPrn():
  Prompts the user to enter the PRN of the student to be updated.
  Searches for the student with the given PRN and allows the user to update the student's name, date of birth, and marks.
5. searchByPrn():
  Prompts the user to enter the PRN to be searched.
  Searches for the student with the given PRN and displays their details if found.
6. searchByName():
  Prompts the user to enter the name to be searched.
  Searches for the student with the given name (case-insensitive) and displays their details if found.
7. searchByPosition():
  Prompts the user to enter the position to be searched.
  Searches for the student with the given position and displays their details if found.
