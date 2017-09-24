/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import java.util.Scanner;

/**
 *
 * @author Julian
 */
public class CalcularE {
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner lec = new Scanner(System.in);
        System.out.print("numero de puntos: ");
        int n = lec.nextInt();
        int[] posX = new int[n];
        int[] posY = new int[n];
        int[] posZ = new int[n];
        double[] carga = new double[n];
        double[] p = new double[n];
        double[] resultado = new double[3];
        System.out.println(" ");
        // para ingresar todos los puntos
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
                exp = 1.0000/((int) Math.pow(10,(exp*(-1)))); //utilizo el 1.000000 para que las cargas se guarden con esos decimales
            }    
            carga[i] = carga[i]*exp;
        }
        //para ingresar los datos del punto p
        System.out.println("punto p");
        System.out.print("x: ");
        int xp = lec.nextInt();
        System.out.print("y: ");
        int yp = lec.nextInt();
        System.out.print("z: ");
        int zp = lec.nextInt();
        //se calcula el campo 
        for(int j = 0; j < n; j++){
            double distancia = Math.sqrt(Math.pow((xp-posX[j]),2)+Math.pow((yp-posY[j]),2)+Math.pow((zp-posZ[j]),2));
            double campo = ((9*(Math.pow(10,9))*(carga[j])))/(Math.pow((distancia*(Math.pow(10,2))),2));
            double vx = (xp-posX[j])/distancia;
            double vy = (yp-posY[j])/distancia;
            double vz = (zp-posZ[j])/distancia;
            resultado[0] = resultado[0] + (campo*vx);
            resultado[1] = resultado[1] + (campo*vy);
            resultado[2] = resultado[2] + (campo*vz);
        }
        resultado[0] = resultado[0]*100;
        resultado[1] = resultado[1]*100;
        resultado[2] = resultado[2]*100;
        System.out.println(" ");
        System.out.println("El campo resultante es ");
        System.out.println(resultado[0] + "*10^6" + " i + " + resultado[1] + "*10^6" + " j + " + resultado[2] + "*10^6" + " k");
    }
    
}
