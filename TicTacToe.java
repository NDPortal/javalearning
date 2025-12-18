import java.util.Scanner;

class TicTacToe {

    public static char player = 'x';

    public static char[] places = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};

    public static void printboard() {
        System.out.println(places[0] + " | " + places[1] + " | " + places[2]);
        System.out.println(places[3] + " | " + places[4] + " | " + places[5]);
        System.out.println(places[6] + " | " + places[7] + " | " + places[8]);
    }

    public static int checkWin() { // Used ai for this cus i was too lasy to code the check win part, everything else i coded myself
        for (int i = 0; i < 9; i += 3) {
            if (places[i] == places[i+1] && places[i+1] == places[i+2] && places[i] != ' ') {
                if (places[i] == 'x') {
                    return 1;
                } else if (places[i] == 'o') {
                    return 2;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            if (places[i] == places[i+3] && places[i+3] == places[i+6] && places[i] != ' ') {
                if (places[i] == 'x') {
                    return 1;
                } else if (places[i] == 'o') {
                    return 2;
                }
            }
        }

        return 0;
    }

    public static void play() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Player " + player + " choose: ");
            String choice = scanner.nextLine();

            if (places[Integer.parseInt(choice) - 1] == ' ') {
                places[Integer.parseInt(choice) - 1] = player;
                if (player == 'x') {
                    player = 'o';
                } else {
                    player = 'x';
                }
                break;
            } else {
                System.out.println("Pick again");
            }

        }
    }

    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            if (checkWin() == 0) {
                printboard();
                play();
            } else if (checkWin() == 1) {
                printboard();
                System.out.println("Player x won");
                break;
            } else if (checkWin() == 2) {
                printboard();
                System.out.println("Player O won");
                break;
            } else {
                System.out.println("Error with checkwin return");
                break;
            }
        }

        if (checkWin() == 0) {
            printboard();
        }
    }
}
