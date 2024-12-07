/**
 * The class {@code SumdokuPuzzle} represents a SumdokuPuzzle
 *
 * @author rodrigostamartacoelho fc61771
 * @author joãopereira fc63779
 */
public class SumdokuPuzzle {

   private final int size;
   private final int[][] groupMembership;
   private final int[] groupsValues;

   /** TODO
    * The {@code definesPuzzle} function checks if the given 
    * groupMembership and groupsValues
    * defines a SumdokuPuzzle with a single solution.
    * 
    * @param groupMembership The matrix representing the groups of the Puzzle
    * @param groupValues The vector of the sums of each group in groupMembership
    * @requires {@code groupMembership != null && groupValues != null}
    * @return  if groupMembership and groupValues defines a valid Puzzle
    */
   public static boolean definesPuzzle(int[][] groupMembership, int[] groupValues){
      //
      return ( validGroupMembershipSize(groupMembership) 
              && validGroupsValues(groupMembership,groupValues) 
              && validGroupMembershipEntries(groupMembership,groupValues) 
              && validNumberOfGroups(groupMembership,groupValues)
              && puzzleUniqueSolution(groupMembership,groupValues));
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
    * @param groupValues
    * @return
    */
   public static boolean validGroupsValues(int[][] groupMembership, int[]groupValues){
      //
      int totalSquares = groupMembership.length*groupMembership.length;

      //
      if (groupValues.length < 1 || groupValues.length > (totalSquares)){
         return false;
      }

      //
      for (int i = 0; i < groupValues.length; i++){
         if(groupValues[i] == 0){
            return false;
         }
         else{
            if(groupValues[i] < 1 || groupValues[i] > ((totalSquares) + (totalSquares*groupMembership.length))/2){
               return false;
            }
         }
      }
      return true;
   }

   /**
    * 
    * @param groupMembership
    * @param groupValues
    * @return
    */
   public static boolean validGroupMembershipEntries (int[][] groupMembership, int[] groupValues){
      for(int row = 0; row < groupMembership.length; row++){
         for (int col = 0; col < groupMembership.length; col++){
            if (groupMembership[col][row] < 0 || groupMembership[col][row] >= groupValues.length){
               return false;
            }
         }
      }
      return true;
   }

   /**
    * 
    * @param groupMembership
    * @param groupValues
    * @return
    */
   public static boolean validNumberOfGroups (int[][] groupMembership, int[] groupValues){
      for (int g = 0; g < groupValues.length; g++){
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

   /** 
    * 
    * @param groupMembership
    * @param groupValues
    * @return
    */
   public static boolean puzzleUniqueSolution (int[][] groupMembership, int[] groupValues){
      SumdokuSolver solver = new SumdokuSolver(groupMembership, groupValues);
      if(solver.howManySolutions(1) != 1){
         return false;
      }
      return true;
   }

   /** 
    * The {@code SumdokuPuzzle} constructor creates a new SumdokuPuzzle with 
    * given groupMembership and groupValues.
    *
    * @param groupMembership The matrix representing the groups of the Puzzle
    * @param groupValues The vector of the sums of each group in groupMembership
    * @require {@code definesPuzzle(groupMembership, groupValues) == true}
    */
   public SumdokuPuzzle(int[][] groupMembership, int[] groupValues){
      //
      this.size = groupMembership.length;

      //
      this.groupMembership = new int[size][size];
      for(int row = 0; row < size; row++){
         for(int col = 0; col < size; col++){
            this.groupMembership[col][row] = groupMembership[col][row];
         }
      }

      //
      this.groupsValues = new int[groupValues.length];
      for(int i = 0; i < groupValues.length; i++){
         this.groupsValues[i] = groupValues[i];
      }
   }

   /**
    * The {@code size} function returns the size of the SumdokuPuzzle
    * ,i.e., the number of rows or columns it has.
    *
    * @return the size of the SumdokuPuzzle
    */
   public int size() {
      return this.size;
   }

   /**
    * The {@code numberOfGroups} function returns the number 
    * of groups of the SumdokuPuzzle.
    *
    * @return The number of groups in SumdokuPuzzle
    */
   public int numberOfGroups() {
      return this.groupsValues.length;
   }

   /**
    * The {@code groupNumber} function returns the group of a 
    * specified square of the SumdokuPuzzle.
    *
    * @param col The column of the square 
    * @param row The row of the square
    * @return The group of the given square
    */
   public int groupNumber(int col, int row) {
      return this.groupMembership[col][row];
   }

   /**
    * The {@code valueGroup} function returns the sum of the given group.
    *
    * @param group The specified group
    * @return The sum of the squares in the group
    */
   public int valueGroup(int group) {
      return groupsValues[group];
   }

   /** TODO
    * The {@code isSolvedBy} function checks if the SumdokuGrid is the
    * solution to this SumdokuPuzzle.
    *
    * @param playedGrid The SumdokuGrid to check if is a solution
    * @requires {@code playedGrid != null && playedGrid.size() == this.size}
    * @return If the playedGrid is a solution to this puzzle
    */
   public boolean isSolvedBy(SumdokuGrid playedGrid){
      //
      if(playedGrid.size() != this.size){
         return false;
      }

      //
      for(int group = 0; group < this.groupValues.length; group++){
         int sum = 0;
         for (int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
               if (this.groupMembership[col][row] == group){
                  sum += playedGrid.value(col,row);
               }
            }
         }
         if(sum != groupsValues[group]){
            return false;
         }
      }
      return true;
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
      //
      if (playedGrid.size() != this.size) {
         return false;
      }

      //
      for (int group = 0; group < groupsValues.length; group++) {
         int sum = 0;
         for (int row = 0; row < size; row++) {
             for (int col = 0; col < size; col++) {
                 if (groupMembership[col][row] == group) {
                     int value = playedGrid.value(col, row);
                     if (value != 0) {
                         sum += value;
                     }
                 }
             }
         }
         if (sum > groupsValues[group]) {
             return false;
         }
     }
     return true;
   }

   /** TODO
    * The {@code cluesToString} function returns a String representation of
    * the clues to the puzzle, i.e., the groups and their sums.
    *
    * @return A String representation of the clues
    */
   public String cluesToString() {
      StringBuilder clues = new StringBuilder();
      //
      for(int group = 0; group < groupsValues.length; group++){
         clues.append("G").append(group + 1).append(" = ").append(groupsValues[group]).append(" ");
      }
      
      // 
      clues.append(" \n");

      //
      return clues.toString();
   }

   /** TODO
    * The {@code toString} function returns a String representation of SumdokuPuzzle.
    *
    * @return The String representation of SumdokuPuzzle
    */
   public String toString() {
      StringBuilder str = new StringBuilder();
      str.append("╔");
      //
      str.append("╗\n");
      for (int[] rows : groupMembership) {
         str.append("║ ");
         for (int i : rows) {
            str.append(i + " ");
         }
         str.append("║\n");
      }
      str.append("╚");
      //
      str.append("╝\n");

      return str.toString();
   }
}