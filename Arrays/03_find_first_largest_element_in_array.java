//Find first largest element in array


class FirstLargest
{

	
	public static void main(String[] args) {

		int arr [] = new int[] {1,2,3,4,5,6,78,9,1,0,1,9,18,3,92,86,99};

		int firstLargest = arr[0];

		for(int i = 0; i < arr.length; i++)
		{
			if(firstLargest < arr[i] && arr[i] != firstLargest)
			{
				firstLargest = arr[i];
			}
		}

		System.out.println("FirstLargest Element"+firstLargest);
		
	}
}