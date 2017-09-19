/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculare;

import java.util.Scanner;

/**
 *
 * @author Julian
 */
public class CalcularE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner lec = new Scanner(System.in);
        System.out.print("numero de puntos: ");
        int n = lec.nextInt();
        int[] posX = new int[n];
        int[] posY = new int[n];
        int[] posZ = new int[n];
        double[] carga = new double[n];
        System.out.println(" ");
        for(int i = 0; i < n; i++){
            System.out.println("punto #" + (i+1));
            System.out.print("x: ");
            int x = lec.nextInt();
            posX[i] = x;
            System.out.print("y: ");
            int y = lec.nextInt();
            posY[i] = y;
            System.out.print("z: ");
            int z = lec.nextInt();
            posZ[i] = z;
            System.out.print("carga: ");
            int car = lec.nextInt();
            carga[i] = car;
            System.out.print("10 a la : ");
            double exp = lec.nextInt();
            if(exp >= 0){ //este if es para poder manejar el exponente negativo
                exp = (int) Math.pow(10,exp);
            }else{
                exp = 1.0000000/((int) Math.pow(10,(exp*(-1)))); //utilizo el 1.000000 para que las cargas se guarden con esos decimales
            }    
            carga[i] = carga[i]*exp;
        }
    }
    
}
