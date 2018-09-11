using System;
using System.Collections.Generic;
using System.Text;

namespace Hackerrank.Strings
{
    public class TwoCharacters
    {
        static bool IsAlternating (string s)
        {
            Char first, second;
            switch (s.Length)
            {
                case 1:
                    return false;
                case 2:
                    return true;
                case 3:
                default:

                    first = s[0];
                    second = s[1];
                    bool isAlternating = true;
                    int i = 2;
                    while (isAlternating && i < s.Length)
                    {
                        isAlternating = i % 2 == 0 ?
                            s[i] == first :
                            s[i] == second;
                        i++;
                    }
                    return isAlternating;
            }
        }

        static bool ContainsTwoChars (string s)
        {
            HashSet<char> chars = new HashSet<char> (s.ToCharArray ());
            return chars.Count == 2;
        }

        static string RemoveChars (string s, HashSet<char> expect)
        {
            StringBuilder sb = new StringBuilder ();
            for (int i = 0; i < s.Length; i++)
            {
                if (expect.Contains (s[i]))
                {
                    sb.Append (s[i]);
                }
            }
            return sb.ToString ();
        }

        public static int twoCharacters (string s)
        {
            List<char> chars = new List<char> (new HashSet<char> (s.ToCharArray ()));
            List<HashSet<char>> pairs = new List<HashSet<char>> ();

            for (int i = 0; i < chars.Count; i++)
            {
                for (int j = 1; j < chars.Count; j++)
                {
                    HashSet<char> pair = new HashSet<char> ();
                    pair.Add (chars[i]);
                    pair.Add (chars[j]);
                    if (pair.Count == 2 && !pairs.Contains (pair))
                        pairs.Add (pair);
                }
            }

            List<int> counts = new List<int> ();
            foreach (HashSet<char> pair in pairs)
            {

                string optional = RemoveChars (s, pair);
                if (IsAlternating (optional))
                {
                    counts.Add (optional.Length);
                }
            }
            counts.Sort ();

            return counts.Count > 0 ?
                counts[counts.Count - 1] :
                0;
        }

        // public static void Main (string[] args) {
        //     string[] samples = { "beabeefeab", "ab", "abababb", "abc", "a", "abcdefg" };

        //     foreach (string sample in samples) {
        //         Console.WriteLine ("{0,40:s}: {1:d}", sample, twoCharacters (sample));
        //     }
        // }
    }
}