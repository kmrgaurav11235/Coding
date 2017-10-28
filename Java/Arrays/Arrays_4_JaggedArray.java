class Arrays_4_JaggedArray
{
	public static void main(String args[])
	{
		int n = 5;
		int arr[][] = new int[n][];
		
		for(int i = 0; i < n; i++)
		{
			arr[i] = new int[i + 1];
			for(int j = 0; j <= i; j++)
			{
				arr[i][j] = i + j;
			}
		}
		
		System.out.println("Jagged Array Created:");
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j <= i; j++)
			{
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
