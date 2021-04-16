
//  Assignment: ASU CSE205 Spring 2021 #9
//  Name: Joseph Kharzo
//  StudentID: 1218555299
//  Lecture: (TTH) 1:30-2:45
//  Description: The Assignment 9 class reads a sequence of integers from input,
//  and compute the maximum, counts numbers divisible by 3, sum of numbers larger than the last, and
//  compute the largest even integer in the sequence using recursion.

import java.io.*;

public class Assignment9 
{
    public static void main(String[] args) 
    {
        String line;
        
        // Declare integers and int array to store information
        int num, even, max, count, sum, i = 0;
        int[] numbers = new int[100];
        

        // Try-Catch block for input stream and buffered reader io exceptions
        try 
        {

            // Create an input stream reader and buffered reader object
            InputStreamReader isr = new InputStreamReader(System.in );
            BufferedReader stdin = new BufferedReader(isr);
            
            
            // while or do-While loop to store all integers in the array until 0
            // read in the number as a string and parse to an integer and assign it to array element
            // Continue iterating until 0 is entered
            
            do {
                line = stdin.readLine().trim();
                num = Integer.parseInt(line);
                
                if(num != 0){
                    numbers[i] = num;
                    
                    i++;
                }
            } while (num != 0);

        } //end of try block
        catch(IOException ex) // Catch an IO Exception and print out it occured
        {
            System.out.println("IO Exception");
        }

        // Call recursive functions to calculate min, countOdd, largeEven, and sum
        max = findMax(numbers, 0, i);
        even = largestEven(numbers,0,i-1);
        count = countDivisibleBy3(numbers,0,i-1);
        sum = sumLargerThanLast(numbers,0,i-1,numbers[i-1]);
        
        


        // Print out results in required format
        
        System.out.printf("The maximum number is %d\nThe largest even integer in the sequence is %d\nThe count of numbers divisible by 3 is %d\nThe sum of numbers larger than the last is %d\n",max,even,count,sum);
        
    }	// End main method

    // Recursive static method to find maximum array value
    public static int findMax(int[] nums, int startIndex, int endIndex) {

        if(endIndex > startIndex){
            return Math.max(findMax(nums,startIndex,endIndex-1), nums[endIndex-1]);
        }else{
            return nums[endIndex];
        }



    }	// End findMax method



    // Recursive static method to find the largest even number in the array
    public static int largestEven(int[] nums, int startIndex, int endIndex) {


        if(endIndex > startIndex){
            
            if(nums[endIndex] % 2 == 0){
                return Math.max(largestEven(nums,startIndex,endIndex-1), nums[endIndex]);
            }else{
                return largestEven(nums,startIndex,endIndex-1);
            }
            
        }else{
            return (int)Math.pow(-2, 31);
        }

    }	// End computeLargestEven method


    public static int countDivisibleBy3(int[] nums, int startIndex, int endIndex)
    {
        
        if(endIndex >= startIndex){
            
            if(nums[startIndex] % 3 == 0){
                return 1 + countDivisibleBy3(nums,startIndex+1,endIndex);
            }else{
                return countDivisibleBy3(nums,startIndex+1,endIndex);
            }
            
        }else{
            return 0;
        }





    } //end countDivisibleBy3

    // Recursive static method to find the sum of all numbers larger than the last number in the array
    public static int sumLargerThanLast(int[] nums, int startIndex, int endIndex, int lastNumber) {

        if(endIndex >= startIndex){
            if(nums[startIndex] > lastNumber){
                return nums[startIndex] + sumLargerThanLast(nums,startIndex+1,endIndex,lastNumber);
            }else{
                return sumLargerThanLast(nums,startIndex+1,endIndex,lastNumber);
            }
        }else{
            return 0;
        }



    }	// End sumOfNumbersLargerThanFirst method
}//end Assignment9 class