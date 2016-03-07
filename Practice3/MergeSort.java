package Practice3;

import java.util.Arrays;

public class MergeSort 
{

	public static void main(String[] args) 
	{
		MergeSort ms = new MergeSort();
		int testList[] = { 3, 41, 52, 26, 38, 57, 9, 49 };
		System.out.println("Before Merge: " + Arrays.toString(testList));
		ms.mergeSort(testList, 0, testList.length - 1);
		System.out.println("After Merge: " + Arrays.toString(testList));
	}

	protected void merge(int list[], int p, int q, int r) 
	{
		int n = q - p + 1;
		int m = r - q;
		int L[] = new int[n + 1];
		int R[] = new int[m + 1];
		System.out.println("p: " + p + " q: " + q + " r: " + r);
		System.out.println("n: " + n + " m: " + m);
		int i, j, k;
		for (i = 0; i < n; i++) 
		{
			L[i] = list[p + i];
		}

		for (j = 0; j < m; j++)
		{
			R[j] = list[q + j + 1];
		}

		L[n] = Integer.MAX_VALUE;
		R[m] = Integer.MAX_VALUE;

		i = 0;
		j = 0;
		for (k = p; k <= r; k++) 
		{
			if (L[i] <= R[j]) 
			{
				list[k] = L[i];
				i = i + 1;
			} 
			else 
			{
				list[k] = R[j];
				j = j + 1;
			}
		}
		System.out.println("Array L: " + Arrays.toString(L));
		System.out.println("Array R: " + Arrays.toString(R));
	}

	protected void mergeSort(int list[], int p, int r) 
	{
		int q;
		System.out.println("Merge Sort, p: " + p + " r: " + r);
		if (p < r) {
			q = (p + r) / 2;
			mergeSort(list, p, q);
			System.out.println("Second Merge Sort");
			mergeSort(list, q + 1, r);
			System.out.println("Doing Merge");
			merge(list, p, q, r);
		}
	}

}
