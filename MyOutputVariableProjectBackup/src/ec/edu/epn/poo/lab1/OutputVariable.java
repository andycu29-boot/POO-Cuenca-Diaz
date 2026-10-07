package ec.edu.epn.poo.lab1;

import java.text.*;
import java.util.Locale;

public class OutputVariable {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        long numero = 123098;
        double pi = Math.PI;
        String status ="";
        int grade= 8 ;
        
        System.out.printf("%d %n", numero);
        System.out.printf("%08d %n", numero);
        System.out.printf("%+d %n", numero);

        Locale.setDefault(Locale.US); //Use the US format to print out numbers
        DecimalFormat formato1 = new DecimalFormat("###,###.###");
        String valorFormateado1 = formato1.format(numero);

        System.out.printf("%s %n", valorFormateado1);

        /* continue generating the code ...

        ...

        */
        System.out.printf("Manejo de operador condicional");
        
        status =(grade >=7) ? " Passed" : "Fail";
        
        System.out.printf(status); 
    
    
    
    
    
    
    
    
    
    }
}