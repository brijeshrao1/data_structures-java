//Serching an element in array


class Searching{

	int [] arr = {9,8,7,6,5,4,3,2,1};

	int linearSearch (int val){

		for(int i = 0; i < arr.length ; i++)
		{
			if( val  == arr [i] )
			{
				return i;
			}
		}

		return -1;
	}

    // int  {

	// }


	public static void main(String[] args) {

		Searching find = new Searching ();

		System.out.println("found at "+find.linearSearch(0));
		
	}
}


//Cases
// If Array is sorted
// If 