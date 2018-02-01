package pkg1;

import java.math.BigInteger;
import java.util.Scanner;

public class PrimeNum {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		// Get Input from the user
		System.out.print("How many primes do you want ? :");
		int n = input.nextInt();

		// Creating an object to hold the primeNums. of BigInteger reference dataType
		BigInteger[] primeNums = new BigInteger[n];
		primeNums[0] = BigInteger.valueOf(2);
		primeNums[1] = BigInteger.valueOf(3);
		primeNums[2] = BigInteger.valueOf(5);
		primeNums[3] = BigInteger.valueOf(7);

		// The primeCounter is an Integer to count the primeNumes
		int primeCounter = 4;

		for (BigInteger r = new BigInteger("8");; r = r.add(BigInteger.valueOf(1))) {

			Integer checkCounter = new Integer("0");

			/*
			 * This is the best algorithm to check if the number is prime: m^r % r == m 
			 * m: is any other primeNumber 
			 * r: is the number you want to test
			 * 
			 * this algorithm someTimes dosen't work correct so to make sure we test it 4
			 * times
			 * 
			 */
			{
				for (int j = 0; j < 4; j++) {

					if (primeNums[j].equals((primeNums[j].pow(r.intValue())).mod(r)))
						checkCounter++;
					else
						break;

				}
				if (checkCounter == 4) {
					primeNums[primeCounter] = (r);
					primeCounter++;
				}
			}

			//break out of the loop if we got the numbers we want  
			if (primeCounter == n)
				break;

		}

		// Closing the input object
		input.close();

		// print the numbers
		printNums(primeNums);
	}

	public static void printNums(BigInteger[] primeNums) {
		int counter = 0;
		for (BigInteger primeNum : primeNums) {

			if ((counter) % 10 == 0)
				System.out.println();
			System.out.print(primeNum + "	");
			counter++;

		}

	}
}
