package nextGreaterNumber;

import java.util.Arrays;
import java.util.Scanner;

public class NumberSearcher
{
    public static void main(String[] args)
    {
        System.out.println("Please input number:");
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        if (isValidateNumber(s))
        {
            String result = findNextGreaterNumber(s);
            System.out.println(result == null ? "Unable to find the a greater number"
                    : "The next greater number is " + s);
        }
        else
        {
            System.out.println("The number given is not valid.");
        }
        in.close();
    }

    private static void swapChar(char ar[], int i, int j)
    {
        char temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }

    public static String findNextGreaterNumber(String number)
    {
        if (number != null)
        {
            Integer index = null;
            char[] ar = number.toCharArray();
            int n = ar.length;
            for (int i = n - 1; i > 0; i--)
            {
                if (ar[i] > ar[i - 1])
                {
                    index = i;
                    break;
                }
            }
            if (index != null)
            {
                int x = ar[index - 1];
                int minIndex = index;

                for (int j = index + 1; j < n; j++)
                {
                    if (ar[j] > x && ar[j] < ar[minIndex])
                    {
                        minIndex = j;
                    }
                }
                swapChar(ar, index - 1, minIndex);
                Arrays.sort(ar, index, n);
                return new String(ar);
            }
        }
        return null;
    }

    public static boolean isValidateNumber(String s)
    {
        if (s == null || s.length() == 0)
        {
            return false;
        }
        for (char eachChar : s.toCharArray())
        {
            if (!Character.isDigit(eachChar))
            {
                return false;
            }
        }
        return true;
    }
}
