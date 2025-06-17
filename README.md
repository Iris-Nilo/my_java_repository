# Java Repository
_This Java Repository consists of eight (8) files which is divided into:_
* Laboratory Activities
  * Lab1
  * Lab2
  * Lab3
  * Lab4
  * Lab5
  * Lab6   
* Laboratory Exams
  * MyMidtermLabExam
  * Calculator

### 📁Lab1 | 📄LabActivity1EmployeeInformationSystem

_✏️Brief Description_
#### This program is responsible for processing and sorting employee inputs regarding their work information.

_✅Function and Output_
#### It promps the user to enter the following information:
* First name
* Last name
* Age
* Number of hours worked in a day
* Hourly Wage
#### After collecting the required data, the program will:
* Complete the full name of the employee by concatenating the first name and last name.
* Compute the employee's daily wage by getting the product of the number of hours worked and the hourly wage.

#### It should then display the following:
Enter your first name: Firstname\
Enter your last name: Lastname\
Enter hours worked: 0.00\
Enter hourly wage: 00.00\
\
Employee Information\
--------------------\
Full Name: Firstname Lastname\
Age: 00 years old\
Daily Salary: PHP 000.00


### 📁Lab2 | 📄LabActivity2EmployeeInformationSystemPart2

_✏️Brief Description_
#### This program is responsible for processing and sorting employee inputs regarding their work information requiring more numerical inputs.

_✅Function and Output_
#### It promps the user to enter the following information:
* First name
* Last name
* Age
* Number of hours worked in a day
* Hourly Wage
#### After collecting the required data, the program will:
* Complete the full name of the employee by concatenating the first name and last name.
* Compute for the employee's years to retirement by deducting the inputted age to the retirement age. _Note: In any case of negative inputs, Math.abs() is used._
* Compute the employee's daily wage by getting the product of the number of hours worked and the hourly wage. Then, rounded to the nearest whole number.
* Compute the employee's weekly wage by getting the product of the rounded daily wage and five (5) days.
* Compute the employee's monthly wage by getting the product of the weekly wage and four (4) weeks.
* Compute the employee's gross yearly wage by getting the product of the monthly wage for twelve (12) months.
* Compute the employee's net yearly wage by deducting the 32% of the gross yearly wage and government-mandated benefits amounting to Php 1,500.00, to the gross yearly wage.

#### It should then display the following:
Enter your first name: Firstname\
Enter your last name: Lastname\
Enter your age: 00\
Enter hours worked: 0.00\
Enter hourly wage: 00.00\

Employee Information\
--------------------\
Full Name: FIRSTNAME LASTNAME\
Age: 00 years old\
Years to Retirement: 00 years\
Daily Salary: PHP 000.00\
Weekly Salary: PHP 000.00\
Monthly Salary: PHP 000.00\
Gross Yearly Salary: PHP 000.00\
Net Yearly Salary: PHP 000.00


### 📁Lab3 | 📄LabActivity3ConditionalStatement

_✏️Brief Description_
#### This program is responsible for processing and sorting employee inputs regarding their work information which also utilizes conditional statements.

_✅Function and Output_
#### It promps the user to enter the following information:
* First name
* Last name
* Age
* Job role
* Number of hours worked in a day
* Hourly wage
#### By using the Lab1 and Lab2 programs as a foundation, the following conditional statements will be integrated:
* If the daily work hours inputted is more than 24, output "Number of hours worked cannot exceed 24 hours" then terminate the program.
* If the daily work hours inputted is equal to zero (0) or any other values, output "Wrong input on daily work hours", then terminate the program.
* If the yearly salary is more than 250,000, apply the 32% tax deduction and the 1,500 government-mandated benefits. If less than or equal, then only deduct the government-mandated benefits.
* If the age is below 18, output "Minors are not allowed", then terminate the program
* If the age is greater than or equal to 65, output "Senior Citizens are not allowed", then terminate the program
* Using a switch case based on the job role, set the following:
    -    For Role Code 1, set the role to "Manager"
    -    For Role Code 2, set the role to "Supervisor"
    -    For Role Code 3, set the role to "Staff
    -    For Role Code 4, set the role to "Intern"
    -    For other role, set the role to "Undefined"

#### It should then display the following:
Enter your first name: Firstname\
Enter your last name: Lastname\
Enter your age: 00\
Enter hours worked: 0.00\
Enter hourly wage: 00.00\

Employee Information\
--------------------\
Full Name: FIRSTNAME LASTNAME\
Age: 00 years old\
Position: Manager/Supervisor/Staff/Intern/Undefined\
Years to Retirement: 00 years\
Daily Salary: PHP 000.00\
Weekly Salary: PHP 000.00\
Monthly Salary: PHP 000.00\
Gross Yearly Salary: PHP 000.00\
Net Yearly Salary: PHP 000.00


### 📁Lab4 | 📄LabActivity4EmpInfoSystemGUI

_✏️Brief Description_
#### This program is responsible for processing and sorting employee inputs regarding their work information while integrating Java's GUI AWT components and containers.

_✅Function and Output_
#### It promps the user to enter the following information:
* First name
* Last name
* Age
* Number of hours worked in a day
* Hourly wage
#### After collecting the data, it will:
* Complete the employee's full name by concatenating the first name and last name.
* Compute the employee's daily wage by getting the product of the number of hours worked and the hourly wage.

#### It should then:
* Be displayed by using the necessary Java AWT components, layout and container.
* Handle all possible errors that might be encountered while running the program.

### 📁Lab5 | 📄LabActivity5QuizAppAWT

_✏️Brief Description_
#### This program is responsible for displaying a functional quiz app.
  
_✅Function and Output_
#### This program:
* Displays one question at a time from a fixed list of 3 multiple choice questions.
* Shows the question in a label above the multiple choices
* Includes 4 radio buttons that will contain the answer choices, and a Button below the multiple choices to proceed to the next question.
  - When the button is clicked, it should automatically proceed to the next question and reset the selection in the answer choices.
* At the end of the quiz:
  - Display the final score (e.g., “You got 2 out of 3 correct!”).
  - Disable the buttons and the choices.
* Will terminate the program when the Close button in the Window is clicked.

### 📁Lab6 | 📄 LabActivity6SwingToDoList

_✏️Brief Description_
#### This program is responsible for displaying a functional To-Do List.
  
_✅Function and Output_
#### This program:
* Displays two windows that will handle the following:
  - To-Do List Viewer
  - To-Do List Form
* Contains a To-Do List Viewer which:
    - Uses JTable to display the To-Do list. The table should contain the following:
        - Task Name
        - Task Description
        - Status
    - Consists a button with the value "Add Task" in the upper part of the window. Upon clicking, the To-Do List Form appears.
* Contains a To-Do List Form which:
    - Consists of a form for the following data:
      - Task Name - text field
      - Task Description - text area
      - Status - dropdown list containing Not Started, Ongoing, Completed
    - Consists of a button in the lower part of the window that will enable you saving these details and be added into the JTable.
 
### 📁MyMidtermLabExam | 📄 MyMidtermLabExam

_✏️Brief Description_
#### The purpose of this Java application is to handle IT support tickets.
  
_✅Function and Output_
#### This program:
* Adds tickets
* Updates tickets
* Displays tickets
* Generates report on IT tickets
* Stores up to five tickets in an array.
* Implements a graceful exit upon user request.

### 📁Calculator | 📄 CalculatorGUI

_✏️Brief Description_
#### The program exhibits a function calculator using Java Swing. 
  
_✅Function and Output_
#### This program:
* Handles inputs via number buttons.
* Performs basic arithmetic operations: addition (+), subtraction (-), division (/), multiplication (*),  and percentage (%).
* Supports negative and decimal numbers.
* Perform advanced mathematical operations: square root (√), square (^2), and reciprocals (1/x).
* Includes clear entry (CE), clear (C), and delete (DEL) functionalities.
* Include a calculation history feature which:
  - Dedicates a history button, when clicked:
    - It will show the history of calculations everytime an operation is performed. 
