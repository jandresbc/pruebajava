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
public class Prime extends Pagination {
    
    int SQUARE;
    int ORD;
    int K;
    int N;
    int J;
    final int ORDMAX = 30;
    final int M = 1000;
    int P[] = new int[M+1];
    int MULT[] = new int[ORDMAX+1];
    boolean JPRIME;
    
    //Constructor
    public Prime(){
        P[1] = 2;
        ORD = 2;
        SQUARE = 9;
        K=1;
        N=0;
        J=1;
    }
    
    //to get the number primes
    public void getPrimes(){
        while (K < M) {
            do {
                J += 2;
                if( J == SQUARE) {
                    ORD++;
                    SQUARE=P[ORD]*P[ORD];
                    MULT[ORD-1]=J;
                }
                N=2;
                JPRIME=true;
                while (N < ORD && JPRIME) {
                    while (MULT[N]<J)
                    MULT[N] += P[N] + P[N];
                    if(MULT[N] == J){
                        JPRIME=false;
                    } 
                    N++;
                }
            } while (!JPRIME);
            K++;
            P[K]=J;
        }
    }
    
    //Paginate the number primes generated
    public void paginate(){
        paginate(P,M);
    }
}
