/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.pruebajava;

/**
 *
 * @author juliobarrera
 */
public class Pagination {
    
    final int RR;
    final int CC;
    int PAGENUMBER;
    int PAGEOFFSET;
    int ROWOFFSET;
    int C;
    
    //constructor
    public Pagination(){
        RR = 50;
        CC = 4;
        
        PAGENUMBER = 1;
        PAGEOFFSET = 1;
    }
    
    public void paginate(int[] data,int nbrPerPage){
        while (PAGEOFFSET <= nbrPerPage) {
            System.out.print("The First ");
            System.out.print(Integer.toString(nbrPerPage));
            System.out.print(" Prime Numbers === Page ");
            System.out.print(Integer.toString(PAGENUMBER));
            System.out.println("\n");
            for (ROWOFFSET=PAGEOFFSET; ROWOFFSET <= PAGEOFFSET+RR-1; ROWOFFSET++) {
                for (C = 0; C <= CC - 1; C++)
                    if (ROWOFFSET + C * RR <= nbrPerPage)
                        System.out.printf("%10d", data[ROWOFFSET + C * RR]);
                        System.out.println();
            }
            System.out.println("\f");
            PAGENUMBER++;
            PAGEOFFSET += RR*CC;
        }
    }
}
