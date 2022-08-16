package teoria;

import java.util.*;

class Vertex implements Comparable<Vertex> {
	public final String name;
	public Edge[] adjacencies;
	public double minDistance = Double.POSITIVE_INFINITY;
	public Vertex previous;

	public Vertex(String argName) {
		name = argName;
	}

	public String toString() {
		return name;
	}

	public int compareTo(Vertex other) {
		return Double.compare(minDistance, other.minDistance);
	}

}

class Edge {
	public final Vertex target;
	public final double weight;

	public Edge(Vertex argTarget, double argWeight) {
		target = argTarget;
		weight = argWeight;
	}
}

public class Dijkstra {
	public static void computePaths(Vertex source) {
		source.minDistance = 0.;
		PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
		vertexQueue.add(source);

		while (!vertexQueue.isEmpty()) {
			Vertex u = vertexQueue.poll();

			// Visit each edge exiting u
			for (Edge e : u.adjacencies) {
				Vertex v = e.target;
				double weight = e.weight;
				double distanceThroughU = u.minDistance + weight;
				if (distanceThroughU < v.minDistance) {
					vertexQueue.remove(v);

					v.minDistance = distanceThroughU;
					v.previous = u;
					vertexQueue.add(v);
				}
			}
		}
	}

	public static List<Vertex> getShortestPathTo(Vertex target) {
		List<Vertex> path = new ArrayList<Vertex>();
		for (Vertex vertex = target; vertex != null; vertex = vertex.previous) {
			path.add(vertex);
		}
			
		Collections.reverse(path);
		return path;
	}
	
	public static void main(String[] args) {

		Vertex cerro = new Vertex("Cerro Colorado");
		Vertex cercado = new Vertex("Cercado");
		Vertex cayma = new Vertex("Cayma");
		Vertex jacoboHunter = new Vertex("Jacobo Hunter");
		Vertex sachaca = new Vertex("Sachaca");
		Vertex miraflores = new Vertex("Miraflores");
		Vertex marianoMelgar = new Vertex("Mariano Melgar");
		Vertex tiabaya = new Vertex("Tiabaya");
		Vertex paucarpata = new Vertex("Paucarpata");
		Vertex sabandia = new Vertex("Sabandia");
		Vertex socabaya = new Vertex("Socabaya");
		Vertex joseluisbustamante = new Vertex("Jose luis Bustamante");
		Vertex unsa = new Vertex("Unsa");

		cerro.adjacencies = new Edge[] { new Edge(unsa, 39) };
		cerro.adjacencies = new Edge[] { new Edge(cayma, 13) };
		cerro.adjacencies = new Edge[] { new Edge(cercado, 34) };
		
		cercado.adjacencies = new Edge[] { new Edge(unsa, 9) };
		cercado.adjacencies = new Edge[] { new Edge(jacoboHunter, 17) };
		
		cayma.adjacencies = new Edge[] { new Edge(unsa, 26) };
		cayma.adjacencies = new Edge[] { new Edge(miraflores, 19) };
		
		jacoboHunter.adjacencies = new Edge[] { new Edge(unsa, 19) };
		jacoboHunter.adjacencies = new Edge[] { new Edge(sachaca, 15) };
		
		sachaca.adjacencies = new Edge[] { new Edge(unsa, 17) };
		sachaca.adjacencies = new Edge[] { new Edge(joseluisbustamante, 18) };
		//sachaca.adjacencies = new Edge[] { new Edge(jacoboHunter, 15) };
		
		joseluisbustamante.adjacencies = new Edge[] { new Edge(unsa, 12) };
		joseluisbustamante.adjacencies = new Edge[] { new Edge(socabaya, 13) };
		//joseluisbustamante.adjacencies = new Edge[] { new Edge(sachaca, 18) };
		
		socabaya.adjacencies = new Edge[] { new Edge(unsa, 24) };
		socabaya.adjacencies = new Edge[] { new Edge(paucarpata, 31) };
		socabaya.adjacencies = new Edge[] { new Edge(sabandia, 25) };
		//socabaya.adjacencies = new Edge[] { new Edge(joseluisbustamante, 13) };
		
		sabandia.adjacencies = new Edge[] { new Edge(unsa, 32) };
		sabandia.adjacencies = new Edge[] { new Edge(paucarpata, 33) };
		//sabandia.adjacencies = new Edge[] { new Edge(socabaya, 25) };
		
		paucarpata.adjacencies = new Edge[] { new Edge(unsa, 21) };
		paucarpata.adjacencies = new Edge[] { new Edge(tiabaya, 41) };
		paucarpata.adjacencies = new Edge[] { new Edge(sabandia, 33) };
		//paucarpata.adjacencies = new Edge[] { new Edge(socabaya, 31) };
		
		tiabaya.adjacencies = new Edge[] { new Edge(unsa, 27) };
		tiabaya.adjacencies = new Edge[] { new Edge(marianoMelgar, 31) };
		//tiabaya.adjacencies = new Edge[] { new Edge(paucarpata, 41) };
		
		marianoMelgar.adjacencies = new Edge[] { new Edge(unsa, 12) };
		marianoMelgar.adjacencies = new Edge[] { new Edge(miraflores, 10) };
		//marianoMelgar.adjacencies = new Edge[] { new Edge(tiabaya, 31) };
		
		miraflores.adjacencies = new Edge[] { new Edge(unsa, 12) };
		//miraflores.adjacencies = new Edge[] { new Edge(marianoMelgar, 10) };
		//miraflores.adjacencies = new Edge[] { new Edge(cayma, 19) };
		
		unsa.adjacencies = new Edge[] { new Edge(unsa, 0) };
		unsa.adjacencies = new Edge[] { new Edge(cerro, 39) };
		unsa.adjacencies = new Edge[] { new Edge(sachaca, 17) };
		//unsa.adjacencies = new Edge[] { new Edge(cercado, 9) };
		//unsa.adjacencies = new Edge[] { new Edge(jacoboHunter, 19) };
		//unsa.adjacencies = new Edge[] { new Edge(sabandia, 32) };
		//unsa.adjacencies = new Edge[] { new Edge(joseluisbustamante, 12) };
		//unsa.adjacencies = new Edge[] { new Edge(tiabaya, 27) };
		//unsa.adjacencies = new Edge[] { new Edge(miraflores, 12) };
		
		
		
		double tiempoInicio = System.nanoTime();
		computePaths(tiabaya); // run Dijkstra
		System.out.println("Distancia de Tiabaya a " + sachaca + ": " + sachaca.minDistance);
		List<Vertex> path2 = getShortestPathTo(sachaca);
		System.out.println("Path: " + path2);
		double tiempoFinal = System.nanoTime()-tiempoInicio;
		System.out.print("El tiempo en nanosegundos es: "+tiempoFinal);
		
		
		/*computePaths(cerro); // run Dijkstra
		System.out.println("Distancia de Cerro Colorado a " + jacoboHunter + ": " + jacoboHunter.minDistance);
		List<Vertex> path1 = getShortestPathTo(jacoboHunter);
		System.out.println("Path: " + path1);
		 * */
		
		
		
	}
}
