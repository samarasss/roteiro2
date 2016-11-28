package sorting.divideAndConquer.quicksort3;

import sorting.AbstractSorting;
import util.Util;

/**
 * A classe QuickSortMedianOfThree representa uma variação do QuickSort que
 * funciona de forma ligeiramente diferente. Relembre que quando o pivô
 * escolhido divide o array aproximadamente na metade, o QuickSort tem um
 * desempenho perto do ótimo. Para aproximar a entrada do caso ótimo, diversas
 * abordagens podem ser utilizadas. Uma delas é usar a mediana de 3 para achar o
 * pivô. Essa téc nica consiste no seguinte: 1. Comparar o elemento mais a
 * esquerda, o central e o mais a direita do intervalo. 2. Ordenar os elemento,
 * tal que: A[left] < A[center] < A[right]. 3. Adotar o A[center] como pivô. 4.
 * Colocar o pivô na penúltima posição A[right-1]. 5. Aplicar o particionamento
 * considerando o vetor menor, de A[left+1] até A[right-1]. 6. Aplicar o
 * algoritmo na metade a esquerda e na metade a direita do pivô.
 */
public class QuickSortMedianOfThree<T extends Comparable<T>> extends AbstractSorting<T> {

	public void sort(T[] array, int leftIndex, int rightIndex) {

		int median = medianaOf3(array, leftIndex, rightIndex);
		int particion = particiona(array, leftIndex, median);
		sort(array, leftIndex, particion );
		sort(array, particion + 1, rightIndex);
	}

	public int medianaOf3(T[] array, int leftIndex, int rightIndex) {

		int med = (leftIndex + rightIndex) / 2;

		if (array[leftIndex].compareTo(array[med]) < 0) {
			Util.swap(array, leftIndex, med);
		} else if (array[med].compareTo(array[rightIndex]) < 0) {
			Util.swap(array, med, rightIndex);
		} else if (array[leftIndex].compareTo(array[rightIndex]) < 0) {
			Util.swap(array, leftIndex, rightIndex);
		}
		return med;
	}

	public int particiona(T[] array, int leftIndex, int rightIndex) {
		T pivot = array[leftIndex];
		int i = leftIndex;
		for (int j = leftIndex + 1; j <= rightIndex; j++) {
			if (array[j].compareTo(pivot) < 0) {
				i += 1;
				Util.swap(array, i, j);

			}
		}
		Util.swap(array, leftIndex, i);
		return i;

	}

}

//// if(array.length < 3){
//// this.menor3(array, leftIndex, rightIndex);
//// }
// int median = medianaOf3(array, leftIndex, rightIndex);
// int particion = particiona(array, leftIndex, median);
// sort(array, leftIndex, particion -1);
// sort(array, particion +1, rightIndex);
// }
//
//// public void menor3(T[] array, int leftIndex, int rightIndex){
//// if(array.length == 2){
//// if(leftIndex > rightIndex){
//// Util.swap(array, leftIndex, rightIndex);
//// }
//// }
//// }
//
// public int medianaOf3(T[] array, int leftIndex, int rightIndex){
//
// int med = (leftIndex + rightIndex) / 2;
//
// if(array[leftIndex].compareTo(array[med])< 0){
// Util.swap(array, leftIndex, med);
// }
// else if(array[med].compareTo(array[rightIndex]) < 0){
// Util.swap(array, med, rightIndex);
// }
// else if(array[leftIndex].compareTo(array[rightIndex]) < 0){
// Util.swap(array, leftIndex, rightIndex);
// }
// return med;
// }
//
// public int particiona(T[] array, int leftIndex, int rightIndex){
// T pivot = array[leftIndex];
// int i = leftIndex;
// for(int j = leftIndex + 1; j<= rightIndex; j++){
// if(array[j].compareTo(pivot) < 0){
// i += 1;
// Util.swap(array, i, j);
//
// }
// }
// Util.swap(array, leftIndex, i);
// return i;
// }
// }
