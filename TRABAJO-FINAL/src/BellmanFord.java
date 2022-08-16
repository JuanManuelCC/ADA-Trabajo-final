import java.util.Scanner;
 
public class BellmanFord
{
    private int distancias[];
    private int numero_de_vertices;
    public static final int MAX_VALUE = 999;
 
    public BellmanFord(int numero_de_vertices)
    {
        this.numero_de_vertices = numero_de_vertices;
        distancias = new int[numero_de_vertices + 1];
    }
 
    public void BellmanFordEvaluacion(int origen, int matriz_de_adyacencia[][])
    {
        for (int nodo = 1; nodo <= numero_de_vertices; nodo++)
        {
        	distancias[nodo] = MAX_VALUE;
        }
 
        distancias[origen] = 0;
        for (int nodo = 1; nodo <= numero_de_vertices - 1; nodo++)
        {
            for (int nodo_origen = 1; nodo_origen <= numero_de_vertices; nodo_origen++)
            {
                for (int nodo_destino = 1; nodo_destino <= numero_de_vertices; nodo_destino++)
                {
                    if (matriz_de_adyacencia[nodo_origen][nodo_destino] != MAX_VALUE)
                    {
                        if (distancias[nodo_destino] > distancias[nodo_origen] 
                                + matriz_de_adyacencia[nodo_origen][nodo_destino])
                            distancias[nodo_destino] = distancias[nodo_origen]
                                + matriz_de_adyacencia[nodo_origen][nodo_destino];
                    }
                }
            }
        }
 
        for (int nodo_origen = 1; nodo_origen <= numero_de_vertices; nodo_origen++)
        {
            for (int nodo_destino = 1; nodo_destino <= numero_de_vertices; nodo_destino++)
            {
                if (matriz_de_adyacencia[nodo_origen][nodo_destino] != MAX_VALUE)
                {
                    if (distancias[nodo_destino] > distancias[nodo_origen]
                           + matriz_de_adyacencia[nodo_origen][nodo_destino])
                        System.out.println("El grafo contiene un ciclo de arista negativo");
                }
            }
        }
 
        for (int vertice = 1; vertice <= numero_de_vertices; vertice++)
        {
            System.out.println("La distancia del origen  " + origen + " a "
                      + vertice + " es " + distancias[vertice]);
        }
    }
 
    public static void main(String... arg)
    {
        int numero_de_vertices = 0;
        int origen;
        Scanner scanner = new Scanner(System.in);
 
        System.out.println("Ingrese el número de vértices:");
        numero_de_vertices = scanner.nextInt();
 
        int matriz_de_adyacencia[][] = new int[numero_de_vertices + 1][numero_de_vertices + 1];
        System.out.println("Ingrese la matriz de adyacencia:");
        for (int nodo_origen = 1; nodo_origen <= numero_de_vertices; nodo_origen++)
        {
            for (int nodo_destino = 1; nodo_destino <= numero_de_vertices; nodo_destino++)
            {
            	matriz_de_adyacencia[nodo_origen][nodo_destino] = scanner.nextInt();
 	        if (nodo_origen == nodo_destino)
                {
 	        	matriz_de_adyacencia[nodo_origen][nodo_destino] = 0;
                    continue;
                }
                if (matriz_de_adyacencia[nodo_origen][nodo_destino] == 0)
                {
                	matriz_de_adyacencia[nodo_origen][nodo_destino] = MAX_VALUE;
                }
            }
        }
 
        System.out.println("Ingrese vértice de origen");
        origen = scanner.nextInt();
 
        BellmanFord bellmanford = new BellmanFord(numero_de_vertices);
        double tiempo_inicio = System.nanoTime();
        bellmanford.BellmanFordEvaluacion(origen, matriz_de_adyacencia);
        double tiempo_final = System.nanoTime();
        System.out.println("El tiempo en nanosegundos es: "+(tiempo_final-tiempo_inicio));
        scanner.close();	
    }
}