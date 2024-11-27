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
    * The {@code SumdokuGrid} function is a constructor of SumdokuGrid
    * that creates a SumdokuGrid of a given size, with all squares with 
    * the value 0
    * @param size The size of the SumdokuGrid ,i.e., the number of rows or columns it has.
    * @require {@code 2 > size && size < 10}
    */
   public SumdokuGrid(int size) {
      this.size = size;
      squares = new int[size][size];

      for (int r = 0; r < size; r++) {
         for (int c = 0; c < size; c++) {
            fill(r, c, 0);
         }
      }
   }

   /**
    * The {@code Value} funtion returns the value of a square, given it's
    * row and column
    * @param r The row of the square
    * @param c The column of the square
    * @return The value of the square
    */
   public int Value(int r, int c) {
      return squares[r][c];
   }

   /**
    * The {@code size} function returns the size of this SumdokuGrid
    * ,i.e., the number of rows or columns it has.
    * @return The size of this SumdokuGrid.
    */
   public int size() {
      return size;
   }

   /**
    * The {@code fill} function fills a specified square with a given value
    * @param r The row of the square
    * @param c The column of the square
    * @param value The value to fill the square with
    * @requires {@code r <= this.size() && c <= this.size()}
    */
   public void fill(int r, int c, int value) {
   
   }

   /**
    * The {@code isFilled} function checks if a square is filled,
    * given it's row and column.
    * @param r The row of the square
    * @param c The column of the square
    * @return If the square is filled
    * @requires {@code sumdokugrid != null}
    */
   public boolean isFilled(int r, int c) {

      return false;
   }

   /**
    * The {@code toString} returns a string representation of the SumdokuGrid object
    * @return a String representation of SumdokuGrid
    */
   public String toString() {
      return null;
   }
} 