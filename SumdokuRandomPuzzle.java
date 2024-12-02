import java.util.Random;
/**
 * The {@code SumdokuRandomPuzzle} class generates sumdokuPuzzles picking
 * randomly from a pool of built in SumdokuPuzzles.
 *
 * @author rodrigostamartacoelho fc61771
 * @author joãopereira fc63779
 */
public class SumdokuRandomPuzzle {

   // atributes / fields
   private final int size;
   private final Random random = new Random();

   /* invariants
    *
    * 3 <= size <= 9
    */

   /** TODO
    * The {@code SumdokuRandomPuzzle} creates a new SumdokuRandomPuzzle
    * for puzzles of the given size.
    * @param size the size of the puzzle to generate
    * @require {@code size == 3 || size == 5}
    * 
    */
   public SumdokuRandomPuzzle(int size) {
      this.size = size;
   }

   /** TODO
    * The {@code size} function returns the size of the SumdokuRandomPuzzle
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

}