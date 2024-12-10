import java.util.Scanner;

/**
 * The {@code SumdokuTxt} class is a textual implementation of the videogame Sumdoku.
 *
 * @author rodrigostamartacoelho
 * @author joãopereira
 */
public class SumdokuTxt {

   public static void main(String[] args) {
      if (args.length == 0) {
         System.out.println("Por favor, insira o tamanho da grelha ao executar o programa.");
      }
      else{
         Scanner scanner = new Scanner(System.in);
         int gridNumber = Integer.parseInt(args[0]);
         int totalSquares = gridNumber * gridNumber;

         if (gridNumber >= 3 && gridNumber <= 9) {
               RandomSumdokuPuzzle puzzleGenerator = new RandomSumdokuPuzzle(gridNumber);

               if (!puzzleGenerator.hasNextPuzzle()) {
                  System.out.println("Não existem mais puzzles de tamanho " + gridNumber + " para jogar.");
               } else {
                  boolean playAgain = true;
                  while (playAgain && puzzleGenerator.hasNextPuzzle()) {
                     SumdokuPuzzle puzzle = puzzleGenerator.nextPuzzle();
                     System.out.println("Bem vindo ao jogo Sumdoku!");
                     System.out.println("As pistas do puzzle:");
                     System.out.println(puzzle.cluesToString());
                     System.out.println("Tens " + totalSquares + " tentativas para o resolver. Boa sorte!");

                     play(puzzle, totalSquares, scanner);

                     System.out.println("Queres tentar resolver um novo puzzle (true/false)?");
                     String playerChoice = scanner.next();
                     playAgain = playerChoice.equals("true");
                  }
               }
               System.out.println("Espero que tenhas gostado. Volta sempre!");
         } else {
            System.out.println("Tamanho inválido. Introduza um valor entre 3 e 9.");
         }
         scanner.close();
      }
   }

   public static void play(SumdokuPuzzle puzzle, int maxAttempts, Scanner scanner) {
      SumdokuGrid grid = new SumdokuGrid(puzzle.size());
      int attempts = 0;
      boolean solved = false;

      while (attempts < maxAttempts && !solved) {
         int position;
         int value;

         // Obter e validar a posição
         do {
            System.out.println("Casa a preencher?");
            while (!scanner.hasNextInt()) {
               System.out.println("Entrada inválida. Insira um número.");
               scanner.next(); // Limpa entrada inválida
            }
            position = scanner.nextInt();
            if (position < 1 || position > puzzle.size() * puzzle.size()) {
               System.out.println("Posição inválida. Selecione uma posição entre 1 e " + puzzle.size() * puzzle.size());
            }
         } while (position < 1 || position > puzzle.size() * puzzle.size());

         int row = (position - 1) / puzzle.size() + 1;
         int col = (position - 1) % puzzle.size() + 1;

         // Obter e validar o valor
         do {
            System.out.println("Valor a preencher?");
            while (!scanner.hasNextInt()) {
               System.out.println("Entrada inválida. Insira um número.");
               scanner.next(); // Limpa entrada inválida
            }
            value = scanner.nextInt();
            if (value < 1 || value > puzzle.size()) {
              System.out.println("Valor inválido. Selecione um valor entre 1 e " + puzzle.size());
            }
         } while (value < 1 || value > puzzle.size());

         // Preencher a grade
         grid.fill(row, col, value);
         System.out.println(grid); // Mostrar grade atualizada

         attempts++;

         if (puzzle.isSolvedBy(grid)) {
            System.out.println("Parabéns! Você resolveu o puzzle!");
            solved = true;
         } //else if (!puzzle.isPartiallySolvedBy(grid)) {
            //System.out.println("Valor incorreto! Tente novamente.");
            //grid.fill(row,col,0);
            //System.out.println(grid);
         //}
      }

      if (!solved) {
         System.out.println("Ops, tentativas esgotadas!");
      }
   }
}
