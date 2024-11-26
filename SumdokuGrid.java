/**
 * The class {@code SumdokuGrid} represents a square grid of ints
 * to be used in a SumdokuPuzzle.
 *
 *
 */
public class SumdokuGrid{
   // atributos / campos
   private final int size;
   private int[][] squares;

   /**
    * 
    * @param size
    */
   public SumdokuGrid(int size) {
         this.size = size;
         squares = new int[size][size];
   }
   /**
    * 
    * @param r
    * @param c
    * @return
    */
   public int Value(int r, int c) {
      return squares[r][c];
   }

   public int size() {
      return size;
   }

   public void fill(int r, int c, int value) {
   
   }

   public boolean isFilled(int r, int c) {
      return false;
   }

   public String toString() {
      return null;
   }
} 