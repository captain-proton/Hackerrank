using System;

namespace Hackerrank.Strings
{
    public class CamelCase
    {
        static int camelcase (string s)
        {
            int result = 0;
            for (int i = 0; i < s.Length; i++)
            {
                result += i == 0 || Char.IsUpper (s[i]) ? 1 : 0;
            }
            return result;
        }

        // static void Main (String[] args) 
        // {
        //     string[] words = { "none", "saveChangesInTheEditor", "lOL" };
        //     foreach (var word in words) 
        //     {
        //         Console.WriteLine ("{0,30}: {1:d}", word, CamelCase.camelcase (word));
        //     }
        // }
    }
}