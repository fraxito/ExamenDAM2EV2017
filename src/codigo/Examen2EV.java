/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

/**
 *
 * @author Jorge HP
 */
public class Examen2EV {

    private boolean chequeaSudoku(int[][] matriz){
        int[] listaNumeros = {1,2,3,4,5,6,7,8,9};
        
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                int k=0;
                while (k<9 && listaNumeros[k] != matriz[i][j]){
                    k++;
                }
                if (k<9){
                    listaNumeros[k] = 0; //el número sí esta en el array de 3x3, así que en la lista de números
                                        // a buscar lo ponemos a 0 para indicar que sí que está
                }
                else{
                    return false;  //el número no está en el array de 3x3
                }
            }
        }
        
        return true;  //si llega aquí sin haber ejecutado el return false, es que sí están los números del 1 al 9
    }
    
    private boolean chequeaSudokuV2(int[][] matriz) {
        int[] listaNumeros = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        boolean encontrado = false;
        for (int k = 0; k < listaNumeros.length; k++) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (listaNumeros[k] == matriz[i][j]) {
                        encontrado = true;
                    }
                }
            }
            if (!encontrado){
                return false; //el número que buscamos de la lista de números no está en el array 3x3
            }
            encontrado = false;
        }

        return true; //si llega aquí sin haber ejecutado el return false, es que sí están los números del 1 al 9
    }
    
   private boolean chequeaSudokuV3(int[][]matriz){
        //declaro un array auxiliar para guardar las veces que aparecen los numeros del 1 al 9
        int numeros[] = new int[10];
        //recorro la matriz, que es un simple for anidado 
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                //incremento en uno la posición almacenada en la matriz. Como los numeros del sudoku solo pueden ir
                //del 1 al 9, no se puede salir del array
                numeros[matriz[i][j]]++;
                //si en algún momento la suma de veces que tiene esa posición es mayor que 1 es que está repetido el número
                if (numeros[matriz[i][j]]>1){
                    return false;
                }
            }
        }
        
        return true; //si llega aquí sin haber ejecutado el return false, es que sí están los números del 1 al 9
    }

    private String removeAllOccurrences(String str, char ch){
        String auxiliar = "";
        str = str.toLowerCase();
        for (int i=0; i< str.length(); i++){
            if (str.charAt(i) != ch){
                auxiliar = auxiliar + str.charAt(i);
            }
        }
        return auxiliar;
    }
    
    private String justificaConPuntos(String digitos){
        String auxiliar="";
        if (digitos.length() <= 3){
            return digitos;
        }
        else{
            int contadorTriples=0;
            for (int i=digitos.length()-1; i>=0; i--){
                auxiliar = digitos.charAt(i) + auxiliar;
                contadorTriples++;
                if (contadorTriples % 3 == 0 && i!=0){
                    auxiliar = '.' + auxiliar;
                }
            }
            return auxiliar;
        }
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Examen2EV ex = new Examen2EV();
        int[][] matriz = {{1,2,3},{4,5,6},{7,8,1}};
        System.out.println(ex.chequeaSudoku(matriz));
        System.out.println(ex.chequeaSudokuV2(matriz));
        System.out.println(ex.chequeaSudokuV3(matriz));
        System.out.println(ex.removeAllOccurrences("Perro de San Roque", 'r'));
        System.out.println(ex.justificaConPuntos("208577e"));
    }
    
}
