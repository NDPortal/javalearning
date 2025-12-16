import java.util.ArrayList;
import java.util.Scanner;

class Acc {
    private String username;
    private String password;

    public Acc(String user, String pass) {
        username = user;
        password = pass;
    }

    public boolean checkacc(String user, String pass) {
        return username.equals(user) && password.equals(pass);
    }

    public void changepass(String newpass) {
        password = newpass;
    }
    public String getusername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

public class Main {
    public static boolean Loggedin = false;
    public static boolean exit = false;


    public static void main(String[] args) {
        Acc currentacc = null;
        Scanner scanner = new Scanner(System.in);
        ArrayList<Acc> accounts = new ArrayList<>();

        accounts.add(new Acc("LowkeyLost", "1234"));
        accounts.add(new Acc("fdg", "1234"));
        accounts.add(new Acc("fdgh", "6767"));

        while (!Loggedin && !exit) {

            System.out.print("What do you want to do?: \n1: Create account\n2: Log in\n3: Exit.\nOption choice: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.println("Create Account \n");
                System.out.print("Input username: ");
                String createusername = scanner.nextLine();
                System.out.print("Input password: ");
                String createpassword = scanner.nextLine();
                accounts.add(new Acc(createusername, createpassword));
            } else if (choice.equals("2")) {
                System.out.println("Login \n");
                System.out.print("Input username: ");
                String username = scanner.nextLine();
                System.out.print("Input password: ");
                String password = scanner.nextLine();

                for (Acc acc : accounts) {
                    if (acc.checkacc(username, password)) {
                        System.out.println("Logged in.");
                        currentacc = acc;
                        Loggedin = true;
                        break;
                    }
                }
                if (!Loggedin) {
                    System.out.println("Incorrect username or password.");
                }
            } else if (choice.equals("3")) {
                exit = true;
                System.out.println("Bye!");
            } else {
                System.out.println("Incorrect option.");
            }
        }

        if (Loggedin) {
            System.out.println("Welcome");
        }

        while (Loggedin && !exit) {
            System.out.print("1: View profile\n2: Change password\n3: Exit.\nOption choice: ");
            String choice = scanner.nextLine();
            if (choice.equals("1")) {
                System.out.print("Username: ");
                System.out.println(currentacc.getusername());
            } else if (choice.equals("2")) {
                System.out.print("Input current password: ");
                String currentpass = scanner.nextLine();
                if (currentacc.getPassword().equals(currentpass)) {
                    System.out.print("Input new password: ");
                    String newpass = scanner.nextLine();
                    currentacc.changepass(newpass);
                    System.out.println("Changed password.");
                } else {
                    System.out.println("That is not the current password.");
                }
            } else if (choice.equals("3")) {
                exit = true;
            }
        }
    }
}
