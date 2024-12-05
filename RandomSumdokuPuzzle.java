import java.util.Random;
/**
 * The {@code RandomSumdokuPuzzle} class generates sumdokuPuzzles picking
 * randomly from a pool of built in SumdokuPuzzles.
 *
 * @author rodrigostamartacoelho fc61771
 * @author joãopereira fc63779
 */
public class RandomSumdokuPuzzle {

   // atributes / fields
   private final int size;
   private final Random random = new Random();
   private final SumdokuPuzzle[] puzzles;
   private int puzzlesUsed;

   private final int NUM_SIZE_3_PUZZLES = 3;
   private final int NUM_SIZE_5_PUZZLES = 3;

   /* invariants
    *
    * 3 <= size <= 9
    *
    */

   /**
    * The {@code RandomSumdokuPuzzle} creates a new RandomSumdokuPuzzle
    * for puzzles of the given size.
    * @param size the size of the puzzle to generate
    * @require {@code size == 3 || size == 5}
    * 
    */
   public RandomSumdokuPuzzle(int size) {
      this.size = size;
      puzzlesUsed = 0;

      switch (size) {
         case 3:
            puzzles = size3Puzzles();
            shuffleArray(puzzles);
            break;
      
         case 5:
            puzzles = size5Puzzles();
            shuffleArray(puzzles);
            break;
         default:
            puzzles = null;
      }
   }

   /**
    * The {@code size} function returns the size of the RandomSumdokuPuzzle
    * that generates.
    * @return The size of the SumdokuPuzzle to generate
    */
   public int size() {
      return size;
   }

   /**
    * The {@code hasNextPuzzle} function checks if it has at least one more
    * puzzle for it's size.
    *
    * @return if it has a SumdokuPuzzle
    */
   public boolean hasNextPuzzle() {
      return (puzzlesUsed != puzzles.length);
   }

   /**
    * The (@code nextPuzzle) function returns the next SumdokuPuzzle for it's size.
    * if it doesnt have one, returns {@code null}.
    *
    * @return The next SumdokuPuzzle
    */
   public SumdokuPuzzle nextPuzzle() {
      puzzlesUsed++;
      return (puzzlesUsed >= puzzles.length)? null : puzzles[puzzlesUsed-1];
   }

   /**
    * The {@code size3Puzzles} function returns a array of built-in SumdokuPuzzles
    * with size 3
    * @return The array of SumdokuPuzzles
    */
   private SumdokuPuzzle[] size3Puzzles() {
      SumdokuPuzzle[] puzzles = new SumdokuPuzzle[NUM_SIZE_3_PUZZLES];
      puzzles[0] = SumPuzzle3A();
      puzzles[1] = SumPuzzle3B();
      puzzles[2] = SumPuzzle3C();
      return puzzles;
   }

   /**
    * The {@code size3Puzzles} function returns a array of built-in SumdokuPuzzles
    * with size 5
    * @return The array of SumdokuPuzzles
    */
   private SumdokuPuzzle[] size5Puzzles() {
      SumdokuPuzzle[] puzzles = new SumdokuPuzzle[NUM_SIZE_5_PUZZLES];
      puzzles[0] = SumPuzzle5A();
      puzzles[1] = SumPuzzle5B();
      puzzles[2] = SumPuzzle5C();
      return puzzles;
   }
   


   private SumdokuPuzzle SumPuzzle3A() {
      int[][] groupMembership = {{0, 1, 1},
                                 {2, 3, 1},
                                 {3, 3, 4}};
      int[] groupValues = {2, 4, 3, 6, 2};
      SumdokuPuzzle puzzle = new SumdokuPuzzle(groupMembership, groupValues);
      return puzzle;
   }

   /**
    * TODO
    * @return
    */
   private SumdokuPuzzle SumPuzzle3B() {
      int[][] groupMembership = {{0, 1, 2},
                                 {1, 2, 0},
                                 {2, 0, 1}};
      int[] groupValues = {9, 6, 3};
      SumdokuPuzzle puzzle = new SumdokuPuzzle(groupMembership, groupValues);
      return puzzle;
   }

   /**
    * TODO
    * @return
    */
   private SumdokuPuzzle SumPuzzle3C() {
      int[][] groupMembership = {{0, 1, 1},
                                 {0, 2, 3},
                                 {4, 4, 3}};
      int[] groupValues = {3, 5, 3, 3, 4};
      SumdokuPuzzle puzzle = new SumdokuPuzzle(groupMembership, groupValues);
      return puzzle;
   }

   /**
    * TODO
    * @return
    */
   private SumdokuPuzzle SumPuzzle5A() {
      int[][] groupMembership = {{},
                                 {},
                                 {},
                                 {},
                                 {}};
      int[] groupValues = {0};
      SumdokuPuzzle puzzle = new SumdokuPuzzle(groupMembership, groupValues);
      return puzzle;
   }

   /**
    * TODO
    * @return
    */
   private SumdokuPuzzle SumPuzzle5B() {
      int[][] groupMembership = {{},
                                 {},
                                 {},
                                 {},
                                 {}};
      int[] groupValues = {0};
      SumdokuPuzzle puzzle = new SumdokuPuzzle(groupMembership, groupValues);
      return puzzle;
   }

   /**
    * TODO
    * @return
    */
   private SumdokuPuzzle SumPuzzle5C() {
      int[][] groupMembership = {{},
                                 {},
                                 {},
                                 {},
                                 {}};
      int[] groupValues = {0};
      SumdokuPuzzle puzzle = new SumdokuPuzzle(groupMembership, groupValues);
      return puzzle;
   }

   /**
    * The {@code shuffleArray} method shuffles the elements of the given
    * SumdokuPuzzle
    * 
    */
   private void shuffleArray(SumdokuPuzzle[] puzzles) {
      SumdokuPuzzle[] shufflePuzzles = new SumdokuPuzzle[puzzles.length];
      
      for (int i = 0; i < shufflePuzzles.length; i++) {

         int position = random.nextInt(shufflePuzzles.length - i);
         int step = 0;
         for (int j = 0; j < position; j++) {
               
             if(shufflePuzzles[j] != null)
               step++;
            step++;
         }
         shufflePuzzles[step] = puzzles[i];
      }  

      puzzles = shufflePuzzles;
   }
}

