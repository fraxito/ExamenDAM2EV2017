/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

/**
 *
 * @author XP
 */
public class Sudoku {

    private boolean chequeaSudoku(int[][]matriz){
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
        //si no ha terminado porque había algún número repetido, saldrá por aquí y devolvera true
        return true;
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
        //una matriz como la del ejercicio, para hacer pruebas
       int [][] matriz = {{5,2,3},{4,5,6},{7,8,9}};
       //imprime la salida del método que hemos creado para el examen
        System.out.println(new Sudoku().chequeaSudoku(matriz));
        System.out.println(new Sudoku().removeAllOccurrences("Perro de San Roque", 'r'));
        System.out.println(new Sudoku().justificaConPuntos("208577e"));
    }
    
}
