/**
 * The class {@code SumdokuGrid} represents a square grid of ints
 * to be used in a SumdokuPuzzle.
 *
 * @author rodrigostamartacoelho fc61771
 * @author joãopereira fc63779
 */
public class SumdokuGrid{
   // atributes / fields
   private int[][] squares;

   /* invariants
    *
    * 3 <= size <= 9
    * 1 <= square[i][j] <= size
    */

   /**
    * The {@code SumdokuGrid} function is a constructor of SumdokuGrid
    * that creates a SumdokuGrid of a given size, with all squares with 
    * the value 0.
    * @param size The size of the SumdokuGrid ,i.e., the number of rows or columns it has.
    * @require {@code 3 >= size && size <= 9}
    */
   public SumdokuGrid(int size) {
      squares = new int[size][size];

      for (int r = 0; r < size; r++) {
         for (int c = 0; c < size; c++) {
            fill(r, c, 0);
         }
      }
   }

   /**
    * The {@code SumdokuGrid} function is a constructor of SumdokuGrid
    * that creates a SumdokuGrid with a given matrix.
    * @param matrix The matrix to create the new Sumdokugrid
    * @requires {@code isValidMatrix(matrix) == true}
    * 
    */
   public SumdokuGrid(int[][] matrix) {
      squares = SumdokuGrid.copyMatrix(matrix);
   }

   /**
    * The {@code isValidMatrix} function checks if the given matrix is
    * valid for constructing a SumdokuGrid.
    * A matrix is valid for contructing a SumdokuGrid if it is a square 
    * matrix and if it only has values between 0 and its size
    * @param matrix The matrix to evaluate
    * @return If the matrix is valid
    */
   public static boolean isValidMatrix(int[][] matrix) {
      boolean isValid = true;
      int i = 0;
      int arraysize = matrix[0].length;
      // while we don't know if it is invalid
      while(isValid && i < matrix.length) {
         // check if it's all lines have the same length
         if (arraysize != matrix[i].length)
            isValid = false;
         // check if it only has valid values
         for (int j = 0; j < matrix[i].length; j++) {
            if (-1 >= matrix[i][j] || matrix[i][j] > matrix.length)
            isValid = false;
         }
      }
      return isValid;
   }

   /**
    * The {@code Value} funtion returns the value of a square, given it's
    * row and column.
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
      return squares.length;
   }

   /** TODO
    * The {@code fill} function fills a specified square with a given value.
    * @param r The row of the square
    * @param c The column of the square
    * @param value The value to fill the square with
    * @requires {@code r <= this.size() && c <= this.size()}
    */
   public void fill(int r, int c, int value) {
      squares[r][c] = value;
   }

   /** TODO
    * The {@code isFilled} function checks if a square is filled,
    * given it's row and column.
    * @param r The row of the square
    * @param c The column of the square
    * @return If the square is filled
    * @requires {@code sumdokugrid != null}
    */
   public boolean isFilled(int r, int c) {

      return !(squares[r][c] == 0);
   }

   /**
    * The {@code toString} returns a string representation of the SumdokuGrid object
    * @return a String representation of SumdokuGrid.
    */
   public String toString() {
      StringBuilder str = new StringBuilder();
      str.append("╔");
      str.repeat("═", squares.length*2+1);
      str.append("╗\n");
      for (int[] rows : squares) {
         str.append("║ ");
         for (int i : rows) {
            str.append(i + " ");
         }
         str.append("║\n");
      }
      str.append("╚");
      str.repeat("═", squares.length*2+1);
      str.append("╝\n");

      return str.toString();
   }

   /**
    * The {@code copyMatrix} function returns a copy of the given matrix.
    * @param matrix the matrix to copy
    * @return an independent copy of matrix
    */
   static private int[][] copyMatrix(int[][] matrix) {
      // the new independent matrix of same size
      int[][] copy = new int[matrix.length][matrix.length];

      // copy values to the copy matrix
      for (int row = 0; row < matrix.length; row++) {
         for (int col = 0; col < matrix.length; col++) {
            copy[row][col] = matrix[row][col];
         }
      }
      return copy;
   }
} 