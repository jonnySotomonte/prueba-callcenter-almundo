Obedeciendo al requerimiento del ejercicio se crea la clase CallDispacher que juega el papel de la central
donde se reciben las llamadas y realiza el proceso de asignación de los empleados para su correspondiente
atención, dado que se trabaja con Hilos este proceso se realiza de manera asincrona asignando las llamdas
que se encuentran en la cola de Llamadas a los empleados que se encuentran en la cola priorizada de empleados.
 Adicionalmente existe otro hilo que despues del tiempo de duración de la llamada vuelve a insertar al empleado
 en la cola de empleados disponibles para que asi pueda tomar una nueva llamada.
 
 Para la implementación de priorizar los empleados se utiliza una cola priorizada PriorityBlockingQueue la cual
 junto con la sobreescritura del metodo CompareTo de la clase implementada Comparable permite realizar la ordenación
 de los empleados dependiendo de su tipo, la cual tiene como caracteristica el poner un hilo en espera cuando 
 dicha cola no tiene elementos en un momento dado.
 
 Para la cola de llamadas se utiliza la clase LinkedBlockingQueue la cual tiene el mismo comportamiento de la cola
 de los empleados con la unica diferencia de que dicha cola no es priorizada y por ende los elementos de la cola
 son atendidos en orden de llegada a la misma.
 
 Mediante la implementación de dichas clases se da solución a los puntos Extra/Plus del ejercicio que contemplan la
 posibilidad de no tener un empleado disponible para una llamada o tener mas de 10 llamadas concurrentes.