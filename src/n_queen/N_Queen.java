/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package n_queen;

import java.util.Scanner;

/**
 *
 * @author Sifat Ullah
 */
public class N_Queen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.print("Welcome to Sifat's N-Queen Solver ");
        System.out.println();


        Scanner S=new Scanner(System.in);
        System.out.print("Enter no. of Queens: ");
            int N = S.nextInt();
        System.out.print("Enter Max Iterations: ");
            int I = S.nextInt();
        System.out.print("Enter Number of States: ");
            int ST = S.nextInt();

         LocalBeamSearch localBeamSearch = new LocalBeamSearch();

        int[] res = localBeamSearch.solve(N,I,ST);
    
        try{
            ShowResult show= new ShowResult(res);
            show.drawQueens(res);
       }
       catch(Exception e){
            System.out.print(" Sifat's AI Could not solve. Try again by increasing number of iterations ");
       }
    }
}
    
     
    

