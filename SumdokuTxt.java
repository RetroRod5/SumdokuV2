/**
 * The {@code SumdokuTxt} class is a textual implementation of the videogame Sumdoku
 *
 * @author rodrigostamartacoelho fc61771
 * @author joãopereira fc63779
 */
public class SumdokuTxt {
   //TODO
   public static void main(String[] args) {
      int[][] matrix = {{2, 3, 1},
                        {1, 2, 3},
                        {3, 1, 2}};
      SumdokuGrid grid = new SumdokuGrid(matrix);
      System.out.println(grid);
      
      matrix[0][0] = 1;
      System.out.println(grid);
   
      grid.fill(0,0,3);
      System.out.println(grid);

   }
}