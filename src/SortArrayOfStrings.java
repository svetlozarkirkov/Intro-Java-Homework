import java.util.Arrays;
import java.util.Scanner;

public class SortArrayOfStrings {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String[] array = new String[n];
		for (int i = 0; i < n; i++)
		{
			array[i]=in.next();
		}
		Arrays.sort(array);
		for (int i = 0; i < n; i++)
		{
			System.out.println(array[i]);
		}
		in.close();
	}
}
