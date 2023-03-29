package vetor;

import java.util.Comparator;

/**
 * Implementação de um vetor de objetos simples para exercitar os conceitos de
 * Generics.
 * 
 * @author Adalberto
 *
 */
public class Vetor<T extends Comparable<T>> {

	// O array interno onde os objetos manipulados são guardados
	private T[] arrayInterno;

	// O tamanho que o array interno terá
	private int tamanho;

	// Indice que guarda a proxima posição vazia do array interno
	private int indice;

	// O Comparators a serem utilizados
	private Comparator<T> comparadorMaximo;
	private Comparator<T> comparadorMinimo;

	public Vetor(int tamanho) {
		super();
		this.tamanho = tamanho;
		this.indice = 0;
		this.arrayInterno = (T[]) new Comparable[tamanho];
	}

	public void setComparadorMaximo(ComparadorMaximo compMax) {
		this.comparadorMaximo = (Comparator<T>) compMax;
	}

	public void setComparadorMinimo(ComparadorMinimo compMin) {
		this.comparadorMinimo = (Comparator<T>) compMin;
	}

	// Insere um objeto no vetor
	// insere do tipo T para um array T
	public void inserir(T o) {
		this.arrayInterno[this.indice] = o;
		this.indice += 1;
	}

	// Remove um objeto do vetor
	public T remover(T o) {
		// a procura se darah usando o equals o tipo T (precisa ser
		// sobrescrito). a remocao
		// nao deixa buracos no array
		T result = null;
		boolean achou = false;
		int i = 0;
		while (i <= indice && !achou) {
			if (arrayInterno[i].equals(o)) {
				result = arrayInterno[i];
				arrayInterno[i] = arrayInterno[indice];
				arrayInterno[indice] = null;
				indice--;
				achou = true;
			}
			i++;
		}
		return result;
	}

	// Procura um elemento no vetor
	public T procurar(T o) {
		for (int i = 0; i < tamanho; i++) {
			if (this.arrayInterno[i].equals(o)) {
				return this.arrayInterno[i];
			}
		}
		return null;
	}

	// Diz se o vetor está vazio
	public boolean isVazio() {
		boolean empty = false;
		for (int i = 0; i < this.arrayInterno.length; i++) {
			if (this.arrayInterno[i] == null) {
				empty = true;
			}
		}
		return empty;
	}

	// Diz se o vetor está cheio
	public boolean isCheio() {
		boolean full = false;
		for (int i = 0; i < this.arrayInterno.length; i++) {
			if (this.arrayInterno[i] != null) {
				full = true;
			}
		}
		return full;
	}

}
