using System;
using Hackerrank.Strings;
using NUnit.Framework;

namespace Hackerrank.Tests.Strings
{
    [TestFixture]
    public class TwoCharactersTest
    {
        [TestCase ("abb", 0)]
        [TestCase("beabeefeab", 5)]
        [TestCase("ab", 2)]
        [TestCase("abab", 4)]
        [TestCase("ababc", 4)]
        [TestCase("abababb", 0)]
        [TestCase("abc", 2)]
        [TestCase("a", 0)]
        [TestCase("abcdefg", 2)]
        public void TestTwoCharacters (string s, int expected)
        {
            Assert.AreEqual(expected, TwoCharacters.twoCharacters(s));
        }

    }
}