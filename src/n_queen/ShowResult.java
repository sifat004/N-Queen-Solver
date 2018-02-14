/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package n_queen;

/**
 *
 * @author Sifat Ullah
 */
public class ShowResult {

    int[] res;
    public ShowResult(int[] r) {
        this.res=r;
        

    }
    
public  void drawQueens(int[] r) {
       
        int numQueens = r.length ;
        System.out.println();

    
        for (int i = 0; i < numQueens; i++){
            for (int j = 0; j < numQueens; j++)
            {         
                      if(r[i]==j)
                      System.out.print("Q ");
                      else  System.out.print("* ");


                }
                 System.out.println();
                

                 


        }
        
         System.out.println();
         System.out.println();
         System.out.print("Congratulations from Sifat ");
}
    
}
