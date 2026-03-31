import java.util.Scanner;

public class StudentManagementSystem {

    static int[] ids = new int[100];
    static String[] names = new String[100];
    static int[] age = new int[100];
    static int count = 0;

    public static void main(String[] args) {
        addStudent();

        System.out.println("Count value in main " + count);
    }

    static void addStudent(){

        Scanner sc = new Scanner(System.in);

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
}
