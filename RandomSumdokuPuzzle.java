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

   /* invariants
    *
    * 3 <= size <= 9
    *
    */

   /** TODO
    * The {@code RandomSumdokuPuzzle} creates a new RandomSumdokuPuzzle
    * for puzzles of the given size.
    * @param size the size of the puzzle to generate
    * @require {@code size == 3 || size == 5}
    * 
    */
   public RandomSumdokuPuzzle(int size) {
      this.size = size;
   }

   /**
    * The {@code size} function returns the size of the RandomSumdokuPuzzle
    * that generates.
    * @return The size of the SumdokuPuzzle to generate
    */
   public int size() {
      return size;
   }

   /** TODO
    * The {@code hasNextPuzzle} function checks if it has at least one more
    * puzzle for it's size.
    *
    * @return if it has a SumdokuPuzzle
    */
   public boolean hasNextPuzzle() {
      return false;
   }

   /** TODO
    * The (@code nextPuzzle) function returns the next Sumdokupuzzle for it's size.
    * if it doesnt have one, returns {@code null}.
    *
    * @return The next SumdokuPuzzle
    */
   public SumdokuPuzzle nextPuzzle() {
      return null;
   }

   /**
    * 
    * @return
    */
   private SumdokuPuzzle SumPuzle3A() {
      int[][] groupMembership = {{0, 1, 1},
                                  {2, 3, 1},
                                  {3, 3, 4}};
      int[] groupValues = {2, 4, 3, 6, 2};
      SumdokuPuzzle puzzle = new SumdokuPuzzle(groupMembership, groupValues);
      return puzzle;
   }

   private SumdokuPuzzle SumPuzle3B() {
      int[][] groupMembership = {{0, 1, 2},
                                 {1, 2, 0},
                                 {2, 0, 1}};
      int[] groupValues = {9, 6, 3};
      SumdokuPuzzle puzzle = new SumdokuPuzzle(groupMembership, groupValues);
      return puzzle;
   }

   private SumdokuPuzzle SumPuzle3C() {
      int[][] groupMembership = {{0, 1, 1},
                                 {0, 2, 3},
                                 {4, 4, 3}};
      int[] groupValues = {3, 5, 3, 3, 4};
      SumdokuPuzzle puzzle = new SumdokuPuzzle(groupMembership, groupValues);
      return puzzle;
   }

   private SumdokuPuzzle SumPuzle5A() {
      int[][] groupMembership = {};
      int[] groupValues = {0};
      SumdokuPuzzle puzzle = new SumdokuPuzzle(groupMembership, groupValues);
      return puzzle;
   }

   private SumdokuPuzzle SumPuzle5B() {
      int[][] groupMembership = {0};
      int[] groupValues = {0};
      SumdokuPuzzle puzzle = new SumdokuPuzzle(groupMembership, groupValues);
      return puzzle;
   }

   private SumdokuPuzzle SumPuzle5C() {
      int[][] groupMembership = {0};
      int[] groupValues = {0};
      SumdokuPuzzle puzzle = new SumdokuPuzzle(groupMembership, groupValues);
      return puzzle;
   }

}