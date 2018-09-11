using System;

namespace Hackerrank.Classes
{
    public class Base
    {
        public void Some()
        {
            Console.WriteLine("Some base");
        }
    }

    public class Sub : Base
    {
        public new void Some()
        {
            Console.WriteLine("Some sub");
        }
    }

    public class Inheritance
    {
        public static void Main(string[] args)
        {
            Base b = new Sub();
            b.Some();
        }
    }
}