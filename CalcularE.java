/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculare;

import java.util.Scanner;
import java.lang.Math;

/**
 *
 * @author Dago G
 */
public class CalcularE {

    public static void main(String[] args) {
        String opcion;
        opcion = "Y";
        do {
            
            System.out.println("\tINTEGRANTES");
            System.out.println("Gonzalez Vasquez Julian David\t20151020046");
            System.out.println("Arciniegas Varon Eric Santiago\t20151020056");
            System.out.println("Acista Pelaez Luisa Maria\t20152015813");
            System.out.println("Guerra Nuñez Diego Dayan\t20152020024");
            System.out.println("Quintero Edwin\t\t\t20162020066\n");
            System.out.println("\tCALCULO DE CAMPO\n");
            Scanner lec = new Scanner(System.in);
            System.out.print("Digite el numero de cargas: ");
            int n = lec.nextInt();
            int[] posX = new int[n];
            int[] posY = new int[n];
            int[] posZ = new int[n];
            double[] carga = new double[n];
            double[] p = new double[n];
            double[] resultado = new double[3];
            double magnitud = 0;
            double anguloX = 0;
            double anguloY = 0;
            double anguloZ = 0;
            System.out.println(" ");
            // para ingresar todos los puntos
            for (int i = 0; i < n; i++) {
                System.out.println("Carga #" + (i + 1));
                System.out.print("Coordenada en x: ");
                int x = lec.nextInt();
                posX[i] = x;
                System.out.print("Coordenada en y: ");
                int y = lec.nextInt();
                posY[i] = y;
                System.out.print("Coordenada en z: ");
                int z = lec.nextInt();
                posZ[i] = z;
                System.out.print("Valor de la Carga: ");
                int car = lec.nextInt();
                carga[i] = car;
                System.out.print("10 a la : ");
                double exp = lec.nextInt();
                if (exp >= 0) { //este if es para poder manejar el exponente negativo
                    exp = (int) Math.pow(10, exp);
                } else {
                    exp = 1.0000 / ((int) Math.pow(10, (exp * (-1)))); //utilizo el 1.000000 para que las cargas se guarden con esos decimales
                }
                carga[i] = carga[i] * exp;
            }
            //para ingresar los datos del punto p
            System.out.println("Punto P");
            System.out.print("Coordenada de P en x: ");
            int xp = lec.nextInt();
            System.out.print("Coordenada de P en y: ");
            int yp = lec.nextInt();
            System.out.print("Coordenada de P en z: ");
            int zp = lec.nextInt();
            //se calcula el campo 
            for (int j = 0; j < n; j++) {
                double distancia = Math.sqrt(Math.pow((xp - posX[j]), 2) + Math.pow((yp - posY[j]), 2) + Math.pow((zp - posZ[j]), 2));
                double campo = ((9 * (Math.pow(10, 9)) * (carga[j]))) / (Math.pow((distancia * (Math.pow(10, 2))), 2));
                double vx = (xp - posX[j]) / distancia;
                double vy = (yp - posY[j]) / distancia;
                double vz = (zp - posZ[j]) / distancia;
                resultado[0] = resultado[0] + (campo * vx);
                resultado[1] = resultado[1] + (campo * vy);
                resultado[2] = resultado[2] + (campo * vz);
            }
            resultado[0] = resultado[0] * 100;
            resultado[1] = resultado[1] * 100;
            resultado[2] = resultado[2] * 100;
            magnitud = Math.sqrt(Math.pow((resultado[0]), 2) + Math.pow((resultado[1]), 2) + Math.pow((resultado[2]), 2));
            anguloX = Math.acos((resultado[0]) / magnitud);
            anguloX = Math.toDegrees(anguloX);
            anguloY = Math.acos((resultado[1]) / magnitud);
            anguloY = Math.toDegrees(anguloY);
            anguloZ = Math.acos((resultado[2]) / magnitud);
            anguloZ = Math.toDegrees(anguloZ);
            System.out.println(" ");
            System.out.println("El campo resultante es ");
            System.out.println(String.format("%.4f", resultado[0]) + " *10^6" + " i + " + String.format("%.4f", resultado[1]) + " *10^6" + " j + " + String.format("%.4f", resultado[2]) + " *10^6" + " k");
            System.out.println("Con una magnitud de: " + String.format("%.4f", magnitud) + " *10^6 N/Coul");
            System.out.println("Y angulos correspondientes a: ");
            System.out.println("Angulo X: " + String.format("%.4f", anguloX) + "°");
            System.out.println("Angulo Y: " + String.format("%.4f", anguloY) + "°");
            System.out.println("Angulo Z: " + String.format("%.4f", anguloZ) + "°");
            System.out.print("\nDigite Y si desea calcular otro campo, de lo contrario digite N: ");
            opcion = lec.next();
        }
        while(opcion.equals("Y"));
    }
    
    
}
