// Written by: Adriel Adasa and Class: CPSC1103 S10

#include <iostream>

using namespace std;

void getValues(int[], int);
void displayValues(const int[], int);
int largest(const int[], int);
int smallest(const int[], int);
void displayLargestSmallest(int, int);


int main()
{
	const int arraySize = 10;
	int array[arraySize];
	getValues(array, arraySize);
	cout << endl;
	displayValues(array, arraySize);
	cout << endl;
	int largestInt = largest(array, arraySize);
	int smallestInt = smallest(array, arraySize);
	displayLargestSmallest(largestInt, smallestInt);
}

void getValues(int arr[], int arrSize)
{
	for (int i = 0; i < arrSize; i++)
	{
		int value;
		cout << "Enter number " << i + 1 << " : ";
		cin >> value;
		while (value < 0)
		{
			cout << "Negative number not accepted, please re-enter number " << i + 1 << ": ";
			cin >> value;
		}
		arr[i] = value;
	}
}

void displayValues(const int arr[], int arrSize)
{
	for (int i = 0; i < arrSize; i++)
	{
		cout << "Number " << i + 1 << " is: " << arr[i] << endl;
	}
}

int largest(const int arr[], int arrSize)
{
	int largest = 0;
	for (int i = 0; i < arrSize; i++)
	{
		if (arr[i] > largest)
		{
			largest = arr[i];
		}
	}
	return largest;
}

int smallest(const int arr[], int arrSize)
{
	int smallest = INT_MAX;
	for (int i = 0; i < arrSize; i++)
	{
		if (arr[i] < smallest)
		{
			smallest = arr[i];
		}
	}
	return smallest;
}

void displayLargestSmallest(int lar, int sml)
{
	cout << "The largest value is : " << lar << endl;
	cout << "The smallest value is : " << sml << endl;
	cout << "Written by: Adriel Adasa and Class: CPSC1103 S10";
}