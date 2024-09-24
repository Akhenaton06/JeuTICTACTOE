import java.security.SecureRandom;
import java.util.*;

public class TicTacToe {

    private Scanner scanner = new Scanner(System.in);
    private final char[][] board;

    private List<Integer> availablePositions;
    private final Joueur player;
    private final Joueur cpu;
    public TicTacToe(String playerName) {
        this.board = new char[][]{
                {' ', '│', ' ', '│', ' '},
                {'─', '┼', '─', '┼', '─'},
                {' ', '│', ' ', '│', ' '},
                {'─', '┼', '─', '┼', '─'},
                {' ', '│', ' ', '│', ' '}
        };
        this.player= new Joueur(playerName, 'X');
        this.cpu= new Joueur("Cpu", '0');
        this.availablePositions=new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
    }

    private boolean isBoardFull() {
        return availablePositions.isEmpty();
    }

    public void startGame() {

        System.out.println("Welcome to Tic Tac Toe!");
        displayBoard();

        while (true) {
            playerMove();
            displayBoard();

            if (checkWinner(player)) {
                System.out.println(player.getName() + " wins! (✜‿✜)");
                break;
            }
            else if (isBoardFull()) {
                System.out.println("It's a tie! (╥﹏╥)");
                break;
            }
            System.out.println("********The Cpu played********\n");
            cpuMove();
            displayBoard();

            if (checkWinner(cpu)) {
                System.out.println("Cpu wins! ┌П┐(ಠ_ಠ)");
                break;

            }
            else if (isBoardFull()) {
                System.out.println("It's a tie! (╥﹏╥)");
                break;
            }

        }
    }



    private void playerMove() {
        int position = getPlayerMove();
        player.addMove(position);
        placeMove(player, position);
    }
    private int getPlayerMove() {
        int position=0;
        boolean success = false;

        do {
                try {
                    do{
                        System.out.print("Enter a number from the available positions " + availablePositions + ": ");
                        position = getPlayerInput();
                    }while (!isValidMove(position));
                    success = true;
                } catch (InputMismatchException ex) {
                    System.out.println("Your input is invalid.");
                    scanner.next();
                }
        } while (!success);

        return position;
    }

    private int getPlayerInput() {
        return this.scanner.nextInt();
    }


    private void placeMove(Joueur currentPlayer, int position) {
        int row = (position - 1) / 3 * 2;
        int col = ((position - 1) % 3) * 2;

        board[row][col] = currentPlayer.getSymbol();
        availablePositions.remove(Integer.valueOf(position));
    }

    private boolean isValidMove(int position) {
        return availablePositions.contains(position);
    }
    private void displayBoard() {
        for (char[] row : board) {
            System.out.println(row);
        }
    }


    private int getRandomMove() {
        SecureRandom random = new SecureRandom();
        return availablePositions.get(random.nextInt(availablePositions.size()));
    }

    private void cpuMove() {
        int position = getCpuMove();
        cpu.addMove(position);
        placeMove(cpu, position);
    }
    private int getCpuMove() {
        return getRandomMove();
    }


    private boolean checkWinner(Joueur currentPlayer) {

        List<List<Integer>> winningCombinations = Arrays.asList(
                Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9),
                Arrays.asList(1, 4, 7), Arrays.asList(2, 5, 8), Arrays.asList(3, 6, 9),
                Arrays.asList(1, 5, 9), Arrays.asList(3, 5, 7)
        );

        for (List<Integer> combination : winningCombinations) {
            if (currentPlayer.getMoves().containsAll(combination))
                return true;

        }
        return false;
    }
}
