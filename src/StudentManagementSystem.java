import java.util.Scanner;

public class StudentManagementSystem {

    static int[] ids = new int[100];
    static String[] names = new String[100];
    static int[] age = new int[100];
    static int count = 0;

    static Scanner sc = new Scanner(System.in);

    static int searchIndex = 0;

    public static void main(String[] args) {

        showMenu();
        
    }


    // APP MENU

    public static void showMenu(){

        //Scanner sc = new Scanner(System.in);
        while (true) {

            System.out.println("\n =========== Welcome to Student Management System ============== ");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();


            switch (choice) {
                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    searchStudents();
                    break;

                case 4:
                    deleteStudent();
                    break;

                case 5:
                    System.out.println("Thank you visit again.");
                    return;

                default:
                    System.out.println("Invalid Choice.");
            }

        }

    }

    static void addStudent(){

        //Scanner sc = new Scanner(System.in);

        System.out.println("You have selected to add student...... ");

        //validate and store student Id.
        int tempId = 0;
        while (true){
            System.out.println("Enter the Student ID: ");

            if(sc.hasNextInt()){
                tempId = sc.nextInt();

                if(validateId(tempId)){
                    break;
                } else {
                    System.out.println("Invalid Id, please try again.");
                }

            } else {
                System.out.println("Please enter a valid number.");
                sc.next();
            }
        }
        ids[count] = tempId;

        //validate and store student Name.
        sc.nextLine();
        String tempName;
        while (true){
            System.out.println("Enter the Student Full Name: ");
            tempName = sc.nextLine();

            if(validName(tempName)){
                break;
            } else {
                System.out.println("Invalid name try again");
            }
        }
        names[count] = tempName;


        int tempAge = 0;
        while(true){
            System.out.println("Enter student's age: ");

            if(sc.hasNextInt()){
                tempAge = sc.nextInt();

                if(validAge(tempAge)){
                    break;
                } else {
                    System.out.println("Invalid Id, please try again.");
                }

            } else {
                System.out.println("Please enter a valid number.");
                sc.next();
            }
        }
        age[count] = tempAge;

        count++;
        System.out.println("count => " + count);
    }

    static Boolean validateId(int id){

        if(id <= 0){
            return false;
        }

        for(int i=0; i<count; i++){
            if(ids[i] == id){
                return false;
            }
        }

        return true;

    }

    static boolean validName(String stdName){
        return stdName != null && !stdName.trim().isEmpty();
    }

    static boolean validAge(int age){
        return age > 0 && age < 30;
    }

    static void viewStudents(){
        if(count == 0){
            System.out.println("No Students found. Please add student records.");
            return;
        }

        System.out.println("+----------+----------------------+----------+");
        System.out.printf("| %-8s | %-20s | %-8s |\n", "ID", "Name", "Age");
        System.out.println("+----------+----------------------+----------+");

        for (int i = 0; i < count; i++) {
            System.out.printf("| %-8d | %-20s | %-8d |\n", ids[i], names[i], age[i]);
        }

        System.out.println("+----------+----------------------+----------+");
    }

    static void searchStudents(){
        System.out.println("Enter the Id of the student: ");
        int provId = sc.nextInt();

        boolean found = false;

        for (int i=0; i<count; i++){
            if(ids[i] == provId){
                System.out.println("ID = " + ids[i] + " Name = " + names[i]  + " Age = " + age[i]);
                found = true;
                searchIndex = i;
                break;
            }
        }

        if(!found){
            System.out.println("Student not found.");
        }
    }

    static void deleteStudent(){
        System.out.println("DELETE STUDENT ");
        System.out.println("Enter the Id of the student: ");

        int provId = sc.nextInt();

        if(count == 0){
            System.out.println("Nothing to delete. ");
            return;
        }

        //shift the array elements to left
        ids[searchIndex] = ids[searchIndex + 1];
        ids[searchIndex + 1 ] = ids[searchIndex + 2];

        names[searchIndex] = names[searchIndex + 1];
        names[searchIndex + 1 ] = names[searchIndex + 2];

        age[searchIndex] = age[searchIndex + 1];
        age[searchIndex + 1] = age[searchIndex + 2];

        //reduce the count
        count --;
        System.out.println("count => " + count);
    }
}
