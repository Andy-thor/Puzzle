import java.math.BigInteger;
import java.util.List;
import java.util.ArrayList;


/**
 * @author: Andrés Segovia
 * Clase que contiene un método mucho más eficiente para obtener el resto dado un número
 * sin importar su longitud. Éste los calcula operando el número en sí sin realizar la
 * concatenación que se realizaba previamente. Cada operación devuelve un resto y a éste
 * lo concatenamos al principio del siguiente número en el ciclo posterior.
 * El algoritmo, al detectar que una operación obtiene un resto cuyo valor previamente
 * ya se obtuvo, cuenta la cantidad de todos los restos encontrados pero desde donde ocurre
 * la periodicidad hasta donde se encuentra en ese momento y, desde esa posición, 
 * cuenta la cantidad de conjuntos de números que faltan operar menos la cantidad de restos 
 * encontrados; a este número le aplico la operación de módulo de la cantidad 
 * de números que es periódica(NO la lista entera de restos ya encontrados) y así
 * obtenemos como resultado cuál índice de los restos que son períodicos sería.
 * Como bien se sabe dónde inicia la periodicidad sólo le sumamos el resto del anterior valor
 * calculado.
 */

class Puzzle {
    final static BigInteger M = new BigInteger("2017");
    private static List<BigInteger> listRestos = new ArrayList<BigInteger>();
    private static BigInteger compute(long n) {
        listRestos.clear();
        long sizeList = 0;
        long index = 0;
        int cont = 0;
        String str = "";
        BigInteger tmpNumber = new BigInteger(Long.toString(n));
        BigInteger resto = tmpNumber.mod(M); // Obtenemos el 1er resto
        listRestos.add(resto);

        for (long i = 0; i < n - 1; i++) { // Le restamos 1 porque ya calculamos el resto de la 1ra parte previamente
            str = resto + Long.toString(n);
            tmpNumber = new BigInteger(str);
            resto = tmpNumber.mod(M);
            sizeList = listRestos.size();
            
            // Antes de agregarlo a la lista preguntamos si ya se encuentra
            if (listRestos.contains(resto)) {
                long indexResto = listRestos.indexOf(resto); // Para tomar en cuenta la posición desde donde empieza la periodicidad
                long length_group = sizeList - indexResto; // Para obtener la cantidad de los restos únicos
                long sobranteConjunto = n - sizeList; // El resto de los conjuntos que faltan dividir
                long diff = sobranteConjunto % length_group;
                index = indexResto + diff - 1;
                
                if (index < 0) {
                    index = length_group - 1;
                }

                break;
            } else {
                listRestos.add(resto);
                index = listRestos.size() - 1; // Así obtenemos el último resto que añadimos
                cont++;
            }
        }
        return listRestos.get((int)index);
    }

    public static void main(String args[]) {
        for (long n : new long[] { 1L, 2L, 5L, 10L, 20L, 58184241583791680L }) {
            System.out.println("" + n + ": " + compute(n));
        }

        /* OUTPUT:
        1: 1
        2: 22
        5: 1096
        10: 1197
        20: 57
        58184241583791680: 465
        */
    }
}

