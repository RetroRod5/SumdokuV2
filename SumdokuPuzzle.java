/**
 * The class {@code SumdokuPuzzle} represents a SumdokuPuzzle
 *
 *
 */
public class SumdokuPuzzle {

   /** TODO
    * The {@code definesPuzzle} function checks if the given 
    * groupMembership and groupsValues
    * defines a SumdokuPuzzle with a single solution
    * 
    * @param groupMembership The matrix representing the groups of the Puzzle
    * @param groupsValues The vector of the sums of each group in groupMembership
    * @return  if groupMembership and groupValues defines a valid Puzzle
    */
   public static boolean definesPuzzle(int[][] groupMembership, int[] groupsValues) {
      return false;
   }

   /** TODO
    * The {@code SumdokuPuzzle} constructor creates a new SumdokuPuzzle with 
    * given groupMembership and groupValues
    *
    * @param groupMembership The matrix representing the groups of the Puzzle
    * @param groupsValues The vector of the sums of each group in groupMembership
    * @require {@code definesPuzzle(groupMembership, groupValues) == true}
    */
   public SumdokuPuzzle(int[][] groupMembership, int[] groupsValues) {
   
   }

   /** TODO
    * The {@code size} function returns the size of the SumdokuPuzzle
    * ,i.e., the number of rows or columns it has.
    *
    * @return the size of the SumdokuPuzzle
    */
   public int size() {
      return -1;
   }

   /** TODO
    * The {@code numberOfGroups} function returns the number 
    * of groups of the SumdokuPuzzle
    *
    * @return The number of groups in SumdokuPuzzle
    */
   public int numberOfGroups() {
      return -1;
   }

   /** TODO
    * The {@code groupNumber} function returns the group of a 
    * specified square of the SumdokuPuzzle
    *
    * @param col The column of the square 
    * @param row The row of the square
    * @return The group of the given square
    */
   public int groupNumber(int col, int row) {
      return -1;
   }

   /** TODO
    * The {@code valueGroup} function returns the sum of the given group
    *
    * @param group The specified group
    * @return The sum of the squares in the group
    */
   public int valueGroup(int group) {
      return -1;
   }

   /** TODO
    * The {@code isSolvedBy} function checks if the SumdokuGrid is the
    * solution to this SumdokuPuzzle
    *
    * @param playedGrid The SumdokuGrid to check if is a solution
    * @return If the playedGrid is a solution to this puzzle
    */
   public boolean isSolvedBy(SumdokuGrid playedGrid) {
      return false;
   }
   
   /** TODO
    * The {@code isPartiallySolvedBy} function checks if the given SumdokuGrid
    * is a partial solution of the SumdokuPuzzle, i.e., the values of the 
    * filled squares of the given playedGrid are equal to the corresponding
    * squares of the solution to this puzzle
    * 
    * @param playedGrid The SumdokuGrid to check if is a partial solution
    * @return If the playedGrid is a partial solution to this puzzle
    */
   public boolean isPartiallySolvedBy(SumdokuGrid playedGrid) {
      return false;
   }

   /** TODO
    * The {@code cluesToString} function returns a String representation of
    * the clues to the puzzle, i.e., the groups and their sums
    *
    * @return A String representation of the clues
    */
   public String cluesToString() {
      return "this is a clue to a SumdokuPuzzle";
   }

   /** TODO
    * The {@code toString} function returns a String representation of SumdokuPuzzle
    *
    * @return The String representation of SumdokuPuzzle
    */
   public String toString() {
      return "This is a SumdokuPuzzle";
   }
}