package challenge;

import challenge.GenAlgo;

/**
 * The Class Challenge.
 * The Class who manages the simulation of the Betray/NotBetray game between
 * two implementations of GenAlgo interfaces.
 *
 * @author D. Z.
 * @version 00.01.003
 */
public class Challenge {
   
   /** The ROUNDS. 
    * Defines how many times two players play again each other in a row
    */
   public static int    ROUNDS = 100;
   
   /** The HISTORY. 
    * Defines how many results, back in the past, each player gets.
    */
   public static int    HISTORY = 3;
   
   /** The NRMEMBERS. 
    * The number of Players that participate in one duel
    */
   public static int    NRMEMBERS = 2;
   
   /**
    * Duel.
    * <p>
    * This method simulates the game of 2 {@link GenAlgo}-implementations against 
    * each other. The simulation requires a random start history of three 
    * rounds which aren't actually played. </p>
    * 
    * <p>
    * The method gives the possibility to show a detailed output of each round on 
    * the console.</p>
    * 
    * <p>
    * The simulation of the game is a betray/notbetray simulation. If both {@link GenAlgo} 
    * betray, each player gets 5 months in jail.<br />
    * If both {@link GenAlgo} do not Betray, each one gets 1 months of jail.<br />
    * In the other cases, the {@link GenAlgo} which betrays, gets 0 months, while the  
    * one which does not betray gets 10 months in jail.
    * </p>
    *
    * @param startHistory is the start history used for the first round of the duel 
    * @param a1 the {@link GenAlgo} interface implementation of Player 1
    * @param a2 the {@link GenAlgo} interface implementation of Player 2
    * @param detailOutput activates/desactivates the detailed output
    * @return the int[] Returns a 2 dimensional array which contains the months
    * in jail for each Player ( [GenAlgo1, GenAlgo2]).
    */
   public static int[] duel(boolean startHistory[][], GenAlgo a1, GenAlgo a2, boolean detailOutput) {
        
      int             timeInJail_a1 = 0, timeInJail_a2 = 0;
      boolean         desition_a1, desition_a2;
      boolean [] []   input_a1 = new boolean [HISTORY][NRMEMBERS];
      boolean [] []   input_a2 = new boolean [HISTORY][NRMEMBERS];
      int            montInPrison [] = new int[NRMEMBERS];
      
      //Random      rnd = new Random();
      
      // ---- Create random input ----
      for(int i = 0; i < HISTORY; i++){
         input_a1[i][0] = startHistory[i][0];
         input_a2[i][1] = startHistory[i][0];
         
         input_a1[i][1] = startHistory[i][1];
         input_a2[i][0] = startHistory[i][1];
      }
      
      // ---- make Challenge ----
      for(int i = 0; i < ROUNDS; i++){
         if(detailOutput){
            System.out.println("next Step:");
         }
            
         desition_a1 = a1.decision(input_a1);
         desition_a2 = a2.decision(input_a2);
         
         // Control output
         if(((desition_a1 == GenAlgo.B) || (desition_a1 == GenAlgo.N)) 
               && ((desition_a2 == GenAlgo.B) || (desition_a2 == GenAlgo.N))){
            
            if(desition_a1){
               // Second Algo Betray
               if(desition_a2){
               
                  if(detailOutput){
                     System.out.println(a1.getGroupName() + " has Betray and " 
                        + a2.getGroupName() + "has Betray !!!");
                  }
                     
                  // Increase time in Jail
                  timeInJail_a1 += 5;
                  timeInJail_a2 += 5;
               }
              
               // Second Algo Not Betray
               else {
                  if(detailOutput){
                     System.out.println(a1.getGroupName() + " has Betray and " 
                        + a2.getGroupName() + "has NOT Betray !!!");
                  }
                  
                  // Increase time in Jail
                  timeInJail_a1 += 0;
                  timeInJail_a2 += 10;      
                }
            }      
            // First Algo not Betray   
            else {   
                  
               // Second Algo Betray
               if(desition_a2){
                  if(detailOutput){
                     System.out.println(a1.getGroupName() + " has NOT Betray and " 
                        + a2.getGroupName() + "has Betray !!!");
                  }
                  
                  // Increase time in Jail
                  timeInJail_a1 += 10;
                  timeInJail_a2 += 0;
               }
                         
               // Second Algo not Betray
               else{
                  if(detailOutput){
                     System.out.println(a1.getGroupName() + " has NOT Betray and " 
                        + a2.getGroupName() + "has NOT Betray !!!");
                  }
                  
                  // Increase time in Jail
                  timeInJail_a1 += 1;
                  timeInJail_a2 += 1;
               }
            }
            
            // Make next input for decision
            nextDesition(input_a1, input_a2, desition_a1, desition_a2);
            
         }
        // else {
        //    System.out.println("ERROR: Not allowed output from GenAlgo !!!! Stop Challenge.");
        //    return;
        // }
      }
      
      // Display Result:
      
      System.out.println("\n ------------------ \n");
      
      System.out.println("Time in Jail for Team " + a1.getGroupName() 
                           + ": " + timeInJail_a1 + " month");
      System.out.println("Time in Jail for Team " 
                           + a2.getGroupName() + ": " + timeInJail_a2 + " month");
      
      if(timeInJail_a1 < timeInJail_a2){
         System.out.println("---> Team " + a1.getGroupName() + " had the better Strategie/Algorithm");
      }
      else if(timeInJail_a1 > timeInJail_a2){
         System.out.println("---> Team " + a2.getGroupName() + " had the better Strategie/Algorithm");
      }
      else{
         System.out.println("---> 'Ex equo': Both teams received the same amount of months in jail ");
      }
      
      //----- return result ----
      montInPrison[0]=timeInJail_a1;
      montInPrison[1]=timeInJail_a2;
      
      return montInPrison;
   }
   
   //---------------------------------------------------------------------------
   
   /**
    * Next decision.
    * Make new history array with the new decisions of the {@link GenAlgo}.
    *
    * @param tbl_a1 the decision array for GenAlgo 1
    * @param tbl_a2 the decision array for GenAlgo 2
    * @param des_a1 the new decision of GenAlgo 1
    * @param des_a2 the new decision of GenAlgo 1
    */
   private static void nextDesition(boolean tbl_a1 [][],boolean [][] tbl_a2, boolean des_a1, boolean des_a2){
      for(int j = 0; j < HISTORY-1; j++){
         tbl_a1[j][0] = tbl_a1[j+1][0];
         tbl_a1[j][1] = tbl_a1[j+1][1];
         tbl_a2[j][0] = tbl_a2[j+1][0];
         tbl_a2[j][1] = tbl_a2[j+1][1];
      }
      
      tbl_a1[HISTORY-1][0] = des_a1;
      tbl_a1[HISTORY-1][1] = des_a2;
      tbl_a2[HISTORY-1][0] = des_a2;
      tbl_a2[HISTORY-1][1] = des_a1;
   }
}
