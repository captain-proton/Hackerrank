using System;

namespace Hackerrank.Strings
{
    public class StrongPassword
    {
        private static int MinPasswordLength = 6;
        private static string SpecialChars = "!@#$%^&*()-+";

        private static char[][] PasswordChars = {
            StrongPassword.SpecialChars.ToCharArray (),
            "0123456789".ToCharArray (),
            "abcdefghijklmnopqrstuvwxyz".ToCharArray (),
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ".ToCharArray (),
        };

        static string AddChar (string password, char[] oneOf)
        {
            password += oneOf[0];
            return password;
        }

        static int minimumNumber (int n, string password)
        {
            int result = 0;

            foreach (char[] chars in PasswordChars)
            {
                if (password.IndexOfAny (chars) < 0)
                {
                    result++;
                    password = AddChar (password, chars);
                }
            }
            while (password.Length < MinPasswordLength)
            {
                result++;
                password = AddChar (password, PasswordChars[0]);

            }

            return result;
        }

        // static void Main (string[] args) 
        // {
        //     Console.WriteLine ("Strong Password");
        //     Console.WriteLine ("---------------");

        //     string[] passwords = { "Ab1", "a", "", "aBaBaB", "123456", "abCD1(", "P4ssword!", "reallylongbutweakpassword", "4700" };
        //     foreach (string password in passwords) 
        //     {
        //         Console.WriteLine ("{0,40:s}: {1:d}", password, minimumNumber (password.Length, password));
        //     }
        // }
    }
}