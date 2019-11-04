# Puzzle: 

El razonamiento que utilicé fue que al número que le enviemos al método _(sin importar su tamaño)_ en vez de ir ___concatenándolo___ uno tras otro dicho número la cantidad de veces que representa ese número decidí que sería mejor realizar la división en el momento al número(__n__) por cada ciclo(la cantidad que representa) y de esa manera tengo una división más manejable. Al ___resto___ de esta operación en vez de descartarlo lo voy añadiendo a una lista que guarda los restos que se encuentran y se lo concateno al principio del mismo número pero en el siguiente ciclo. Así de manera consecutiva hasta hayar un _resto_ cuyo valor previamente ya lo habíamos obtenido. En el caso que encuentre un valor del resto que ya se obtuvo simplemente pregunto en qué posición se cargó ese resto y lo ___resto___ __(operación de restar)__ de la posición en la que estamos. Con esto último obtengo la cantidad de cifras o conjuntos de los números restantes por dividir en las que hay __periodicidad__ porque una vez 
que se repite un resto los siguientes también se repetirán. Además se necesita restar el valor de __n__(número) menos la posición en la que quedamos parados, para determinar 
cuantas operaciones restantes faltan realizar.
Obtenido ese valor último realizamos la operación de módulo de ese valor con la cantidad de _restos_ que se repiten y el resultado de esto indica la posición 
dentro de la ___lista de los___ __"restos"__ que se repiten para determinar el _resto_ de la operación o del número en sí. 

## OUTPUT:

```console
$javac Puzzle.java
$java Puzzle
1: 1
2: 22
5: 1096
10: 1197
20: 57
58184241583791680: 465
```
