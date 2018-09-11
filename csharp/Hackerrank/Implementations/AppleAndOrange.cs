using System;

namespace implementations 
{

    public class AppleAndOrange 
    {
        static int countFruits (int houseLeft, int houseRight, int treePos, int[] fruits) 
        {
            int count = 0;
            foreach (var fruit in fruits) 
            {
                int fallPosition = treePos + fruit;
                if (houseLeft <= fallPosition && houseRight >= fallPosition) 
                {
                    count++;
                }
            }
            return count;
        }

        static void countApplesAndOranges (int s, int t, int a, int b, int[] apples, int[] oranges) 
        {
            int appleHits = countFruits (s, t, a, apples);
            int orangeHits = countFruits (s, t, b, oranges);

            Console.WriteLine (appleHits);
            Console.WriteLine (orangeHits);
        }

        // public static void Main (string[] args) 
        // {
        //     Console.WriteLine ("Some value");
        // }
    }
}