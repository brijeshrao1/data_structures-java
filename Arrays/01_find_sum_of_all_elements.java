//Find Sum of all elements in array


class SumOfElements{

	public static void main(String[] args) {
		int [] arr = {5,4,3,2,1,0};

		System.out.println(arr.length);

		int sum = 0;

		for(int i = 0; i < arr.length; i++)
		{
			sum = sum + arr[i];
		}

		System.out.println("Sum Of Elements: "+ sum);
	}
}