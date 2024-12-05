/**
 * The class {@code SumdokuPuzzle} represents a SumdokuPuzzle
 *
 * @author rodrigostamartacoelho fc61771
 * @author joãopereira fc63779
 */
public class SumdokuPuzzle {

   private final int SIZE;
   private final int NUM_SQUARES;
   private final int[][] GROUPMEMBERSHIP;
   private final int[] GROUPVALUES;

   /** TODO
    * The {@code definesPuzzle} function checks if the given 
    * groupMembership and groupsValues
    * defines a SumdokuPuzzle with a single solution.
    * 
    * @param groupMembership The matrix representing the groups of the Puzzle
    * @param groupsValues The vector of the sums of each group in groupMembership
    * @requires {@code groupMembership != null && groupValues != null}
    * @return  if groupMembership and groupValues defines a valid Puzzle
    */
   public static boolean definesPuzzle(int[][] groupMembership, int[] groupsValues){
      //
      boolean groupMembershipSize = validGroupMembershipSize(groupMembership);

      //
      boolean groupValuesValidated = validGroupsValues(groupMembership,groupsValues);

      //
      boolean groupMembershipEntriesValidated = validGroupMembershipEntries(groupMembership,groupsValues);

      //
      boolean groupValuesNumbers = validNumberOfGroups(groupMembership,groupsValues);

      //
      boolean puzzleUniqueSolutionValied = puzzleUniqueSolution(groupMembership,groupsValues); 

      return (groupMembershipSize && groupValuesValidated && groupMembershipEntriesValidated && groupValuesNumbers && puzzleUniqueSolutionValied);
   }

   /**
    * 
    * @param groupMembership
    * @return 
    */
   public static boolean validGroupMembershipSize(int[][] groupMembership){
      if (groupMembership.length < 3 || groupMembership.length > 9){
         return false;
      }

      for(int row = 0; row < groupMembership.length; row++){
         if(groupMembership[row].length != groupMembership.length){
            return false;
         }
      }
      return true;
   }

   /**
    * 
    * @param groupMembership
    * @param groupsValues
    * @return
    */
   public static boolean validGroupsValues(int[][] groupMembership, int[]groupsValues){
      //
      int totalSquares = groupMembership.length*groupMembership.length;

      //
      if (groupsValues.length < 1 || groupsValues.length > (totalSquares)){
         return false;
      }

      //
      for (int i = 0; i < groupsValues.length; i++){
         if(groupsValues[i] == 0){
            return false;
         }
         else{
            if(groupsValues[i] < 1 || groupsValues[i] > ((totalSquares) + (totalSquares*groupMembership.length))/2){
               return false;
            }
         }
      }
      return true;
   }

   /**
    * 
    * @param groupMembership
    * @param groupsValues
    * @return
    */
   public static boolean validGroupMembershipEntries (int[][] groupMembership, int[] groupsValues){
      for(int row = 0; row < groupMembership.length; row++){
         for (int col = 0; col < groupMembership.length; col++){
            if (groupMembership[col][row] <= 0 || groupMembership[col][row] >= (groupsValues.length - 1)){
               return false;
            }
         }
      }
      return true;
   }

   /**
    * 
    * @param groupMembership
    * @param groupsValues
    * @return
    */
   public static boolean validNumberOfGroups (int[][] groupMembership, int[] groupsValues){
      for (int g = 0; g < groupsValues.length; g++){
         boolean isFound = false;
         for(int row = 0; row < groupMembership.length; row++){
            for(int col = 0; col < groupMembership.length; col++){
               if(groupMembership[col][row] == g){
                  isFound = true;
               }
            }
         }
         if (isFound == false){
            return false;
         }
      }
      return true;
   }

   /** TODO
    * 
    * @param groupMembership
    * @param groupsValues
    * @return
    */
   public static boolean puzzleUniqueSolution (int[][] groupMembership, int[] groupsValues){

   }

   /** TODO
    * The {@code SumdokuPuzzle} constructor creates a new SumdokuPuzzle with 
    * given groupMembership and groupValues.
    *
    * @param groupMembership The matrix representing the groups of the Puzzle
    * @param groupsValues The vector of the sums of each group in groupMembership
    * @require {@code definesPuzzle(groupMembership, groupValues) == true}
    */
   public SumdokuPuzzle(int[][] groupMembership, int[] groupsValues){
      //
      this.SIZE = groupMembership.length;

      //
      this.GROUPMEMBERSHIP = new int[SIZE][SIZE];
      for(int row = 0; row < SIZE; row++){
         for(int col = 0; col < SIZE; col++){
            this.GROUPMEMBERSHIP[col][row] = groupMembership[col][row];
         }
      }

      //
      this.GROUPVALUES = new int[groupsValues.length];
      for(int i = 0; i < groupsValues.length; i++){
         this.GROUPVALUES[i] = groupsValues[i];
      }

   }

   /**
    * The {@code size} function returns the size of the SumdokuPuzzle
    * ,i.e., the number of rows or columns it has.
    *
    * @return the size of the SumdokuPuzzle
    */
   public int size() {
      return this.SIZE;
   }

   /** TODO
    * The {@code numberOfGroups} function returns the number 
    * of groups of the SumdokuPuzzle.
    *
    * @return The number of groups in SumdokuPuzzle
    */
   public int numberOfGroups() {
      return this.GROUPVALUES.length;
   }

   /** TODO
    * The {@code groupNumber} function returns the group of a 
    * specified square of the SumdokuPuzzle.
    *
    * @param col The column of the square 
    * @param row The row of the square
    * @return The group of the given square
    */
   public int groupNumber(int col, int row) {
      return this.GROUPMEMBERSHIP[col][row];
   }

   /** TODO
    * The {@code valueGroup} function returns the sum of the given group.
    *
    * @param group The specified group
    * @return The sum of the squares in the group
    */
   public int valueGroup(int group) {
      return this.GROUPVALUES[group];
   }

   /** TODO
    * The {@code isSolvedBy} function checks if the SumdokuGrid is the
    * solution to this SumdokuPuzzle.
    *
    * @param playedGrid The SumdokuGrid to check if is a solution
    * @return If the playedGrid is a solution to this puzzle
    */
   public boolean isSolvedBy(SumdokuGrid playedGrid) {
      boolean equal = false;
      if(playedGrid)
      return false;
   }
   
   /** TODO
    * The {@code isPartiallySolvedBy} function checks if the given SumdokuGrid
    * is a partial solution of the SumdokuPuzzle, i.e., the values of the 
    * filled squares of the given playedGrid are equal to the corresponding
    * squares of the solution to this puzzle.
    * 
    * @param playedGrid The SumdokuGrid to check if is a partial solution
    * @return If the playedGrid is a partial solution to this puzzle
    */
   public boolean isPartiallySolvedBy(SumdokuGrid playedGrid) {
      return false;
   }

   /** TODO
    * The {@code cluesToString} function returns a String representation of
    * the clues to the puzzle, i.e., the groups and their sums.
    *
    * @return A String representation of the clues
    */
   public String cluesToString() {
      return "this is a clue to a SumdokuPuzzle";
   }

   /** TODO
    * The {@code toString} function returns a String representation of SumdokuPuzzle.
    *
    * @return The String representation of SumdokuPuzzle
    */
   public String toString() {
      return "This is a SumdokuPuzzle";
   }
}