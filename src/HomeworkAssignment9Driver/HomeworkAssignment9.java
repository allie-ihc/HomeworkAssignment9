package HomeworkAssignment9Driver;

import java.util.Random;

public class HomeworkAssignment9 {

	public static void main(String args[])
	{
		int[] array = RandomizedArray(15, 1);
		for(int i = 0; i < array.length; i++)
		{
			System.out.print(array[i] + " ");
		}
		System.out.println();
		mergeSort(array, 0 , array.length-1);
		for(int i = 0; i < array.length; i++)
		{
			System.out.print(array[i] + " ");
		}
		System.out.println();
		int[] array2 = RandomizedArray(15, 1);
		for(int i = 0; i < array2.length; i++)
		{
			System.out.print(array2[i] + " ");
		}
		System.out.println();
		mergeSortNoArray(array2, 0 , array.length-1);
		for(int i = 0; i < array2.length; i++)
		{
			System.out.print(array2[i] + " ");
		}
	}
	public static int[] RandomizedArray(int size, int start)
	{
		Random rand = new Random();
		int[] tempArray = new int[size];
		for (int i = 0; i<tempArray.length-1; i++)
		{
			tempArray[i] = i + start;
		}
		for (int i = 0; i < 10000; i++)
		{
			//find two random indexes of array
			int firstRandIndex = rand.nextInt(tempArray.length);
			int secondRandIndex = rand.nextInt(tempArray.length);
			int temp = tempArray[firstRandIndex];
			//swap indexes
			tempArray[firstRandIndex] = tempArray[secondRandIndex];
			tempArray[secondRandIndex] = temp;
		}
		return tempArray;
	}
	public static void mergeSort(int[] array, int start, int end)
	{
		if (start != end)
		{
			mergeSort(array, start, (start+end)/2);
			mergeSort(array, (start+end)/2 + 1, end);
			int[] tempArray = new int[end-start+1];
			int pos1 = start;
			int pos2 = ((start+end)/2) + 1;
			for ( int i = 0; i < tempArray.length; i++)
			{
				if(pos1 <= (start + end)/2 && pos2 <= end)
				{
					if (array[pos1] < array[pos2])
					{
						tempArray[i] = array[pos1];
						pos1++;
					}
					else
					{
						tempArray[i] = array[pos2];
						pos2++;
					}
				}
				else if (pos1 <= (start + end)/2)
				{
					tempArray[i] = array[pos1];
					pos1++;
				}
				else
				{
					tempArray[i] = array[pos2];
					pos2++;
				}
			}
			int tempPos = 0;
			for (int i = start; i <= end; i++)
			{
				array[i] = tempArray[tempPos];
				tempPos++;
			}
		}
	}
	public static void mergeSortNoArray(int[] array, int start, int end)
	{
		if (start != end)
		{
			mergeSort(array, start, (start+end)/2);
			mergeSort(array, (start+end)/2 + 1, end);
			//int[] tempArray = new int[end-start+1];
			int pos1 = start;
			int pos2 = ((start+end)/2) + 1;
			while(pos1 < (start+end)/2 + 1)
			{
				if(pos1 <= (start + end)/2 && pos2 <= end)
				{
					if (array[pos1] < array[pos2])
					{
						//tempArray[i] = array[pos1];
						pos1++;
					}
					else
					{
						int temp = array[pos1];
						array[pos1] = array[pos2];
						array[pos2] = temp;
						pos1++;
						pos2++;
					}
				}
				else if (pos1 <= (start + end)/2)
				{
					//tempArray[i] = array[pos1];
					pos1++;
				}
				else
				{
					//tempArray[i] = array[pos2];
					int temp = array[pos1];
					array[pos1] = array[pos2];
					array[pos2] = temp;
					//pos1++;
					pos2++;
				}
			}
			//int tempPos = 0;
			/*for (int i = start; i <= end; i++)
			{
				array[i] = tempArray[tempPos];
				tempPos++;
			} */
		}
	}
}
