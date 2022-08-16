package teoria;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BFS {

	private Queue<Nodo> cola;
	static ArrayList<Nodo> nodo = new ArrayList<>();

	static class Nodo {
		String dato;
		boolean visitado;

		List<Nodo> siguiente;

		Nodo(String dato) {
			this.dato = dato;
			this.siguiente = new ArrayList<>();
		}

		public void aggSiguiente(Nodo nodosiguiente) {
			this.siguiente.add(nodosiguiente);
		}

		public List<Nodo> getSiguiente() {
			return siguiente;
		}
		
		public void setSiguiente(List<Nodo> siguiente) {
			this.siguiente = siguiente;
		}
	}

	public BFS() {
		cola = new LinkedList<Nodo>();
	}

	public void busqueda(Nodo nodo) {
		cola.add(nodo);
		nodo.visitado = true;
		while (!cola.isEmpty()) {
			Nodo elemento = cola.remove();
			System.out.println(elemento.dato);
			List<Nodo> siguiente = elemento.getSiguiente();
			for (int i = 0; i < siguiente.size(); i++) {
				Nodo nod = siguiente.get(i);
				if (nod != null && !nod.visitado) {
					cola.add(nod);
					nod.visitado = true;
				}
			}
		}
	}

	public static void main(String[] args) {

		Nodo cerroColorado = new Nodo("Cerro Colorado");
		Nodo cercado = new Nodo("Cercado");
		Nodo cayma = new Nodo("Cayma");
		Nodo jacoboHunter = new Nodo("Jacobo Hunter");
		Nodo sachaca = new Nodo("Sachaca");
		Nodo miraflores = new Nodo("Miraflores");
		Nodo marianoMelgar = new Nodo("Mariano Melgar");
		Nodo tiabaya = new Nodo("Tiabaya");
		Nodo paucarpata = new Nodo("Paucarpata");
		Nodo sabandia = new Nodo("Sabandia");
		Nodo socabaya = new Nodo("Socabaya");
		Nodo joseluisbustamante = new Nodo("Jose luis Bustamante");
		Nodo unsa = new Nodo("Unsa");
		
		cerroColorado.aggSiguiente(cayma);
		cerroColorado.aggSiguiente(unsa);
		cerroColorado.aggSiguiente(cercado);
		
		cayma.aggSiguiente(unsa);
		cayma.aggSiguiente(miraflores);
		
		cercado.aggSiguiente(unsa);
		cercado.aggSiguiente(jacoboHunter);
		
		jacoboHunter.aggSiguiente(unsa);
		jacoboHunter.aggSiguiente(sachaca);
		
		sachaca.aggSiguiente(unsa);
		sachaca.aggSiguiente(joseluisbustamante);
		
		joseluisbustamante.aggSiguiente(unsa);
		joseluisbustamante.aggSiguiente(socabaya);
		
		socabaya.aggSiguiente(unsa);
		socabaya.aggSiguiente(sabandia);
		socabaya.aggSiguiente(paucarpata);
		
		paucarpata.aggSiguiente(unsa);
		paucarpata.aggSiguiente(sabandia);
		
		sabandia.aggSiguiente(unsa);
		sabandia.aggSiguiente(socabaya);
		
		tiabaya.aggSiguiente(unsa);
		tiabaya.aggSiguiente(paucarpata);
		tiabaya.aggSiguiente(marianoMelgar);
		
		marianoMelgar.aggSiguiente(unsa);
		marianoMelgar.aggSiguiente(miraflores);
		
		miraflores.aggSiguiente(unsa);
		
		unsa.aggSiguiente(joseluisbustamante);
		unsa.aggSiguiente(cerroColorado);
		unsa.aggSiguiente(jacoboHunter);
		unsa.aggSiguiente(marianoMelgar);
		unsa.aggSiguiente(paucarpata);
		unsa.aggSiguiente(miraflores);
		unsa.aggSiguiente(sachaca);
		unsa.aggSiguiente(tiabaya);
		
		
		System.out.println("La busqueda en anchura es:");
		BFS bfs = new BFS();
		double tiempoInicio = System.nanoTime();
		bfs.busqueda(unsa);
		double tiempoFinal = System.nanoTime()-tiempoInicio;
		System.out.print("El tiempo en nanosegundos es: "+tiempoFinal);
		
		
		
		
		
		
		
		
		
		
		
	}

}
