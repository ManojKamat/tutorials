import java.util.Arrays;
class ArrayCompare
{
	public static void main (String[] args)
	{
		int inarr1[] = {1, 2, 3};
		int inarr2[] = {1, 2, 3};
		Object[] arr1 = {inarr1}; // arr1 contains only one element
		Object[] arr2 = {inarr2}; // arr2 also contains only one element
		if (Arrays.deepEquals(arr1, arr2))
			System.out.println("Same");
		else
			System.out.println("Not same");
	}
}
