package challenge;

import challenge.GenAlgo;
import challenge.Challenge;

public class Fix_FixeStrategie implements GenAlgo {

   boolean   strategie [] = {B,N,B,N,B,N,B,N,B,N,B,N,B,N,B,N,B,N,B,N,B,N,B,N,B,N,B,N,B,N,B,N,B,N,B,N,B,N,B,N,B,N,B,N,B,N,B,N,B,N,B,N,B,N,B,N,B,N,B,N,B,B,B,B};
   
   @Override
   public boolean decision(boolean[][] h) {
      int offset = 0;
      
      if(h[0][0]){
         offset += 32;
      }
      
      if(h[0][1]){
         offset += 16;
      }
      
      if(h[1][0]){
         offset += 8;
      }
      
      if(h[1][1]){
         offset += 4;
      }
      
      if(h[2][0]){
         offset += 2;
      }
      
      if(h[2][1]){
         offset += 1;
      }
      
      return strategie[offset];
   }

   @Override
   public String getGroupName() {
      return "Strategie Fix 1";
   }

}
