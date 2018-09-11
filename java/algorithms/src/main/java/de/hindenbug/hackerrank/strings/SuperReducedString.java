package de.hindenbug.hackerrank.strings;

public class SuperReducedString {

    private static final String DEFAULT = "Empty String";

    static String super_reduced_string(String s) {

        StringBuilder newString = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char c2 = i + 1 < s.length()
                      ? s.charAt(i + 1)
                      : ' ';
            if (c == c2) {
                i++;
            } else if (c != c2) {
                newString.append(c);
            }
        }
        return newString.length() == 0
               ? DEFAULT
               : newString.toString().equals(s)
                 ? s
                 : super_reduced_string(newString.toString());
    }

    static void test(String actual, String expected) {
        if (!actual.equals(expected))
            System.out.println("expected: " + expected + " was:" + actual);
    }

    public static void main(String[] args) {
        test(super_reduced_string("aabcc"), "b");
        test(super_reduced_string("aaabccddd"), "abd");
        test(super_reduced_string("baab"), DEFAULT);
        test(super_reduced_string("a"), "a");
        test(super_reduced_string("aa"), DEFAULT);
        test(super_reduced_string("aaa"), "a");
        test(super_reduced_string("aaaa"), DEFAULT);
        test(super_reduced_string("aaaab"), "b");
        test(super_reduced_string("aaaabb"), DEFAULT);
        test(super_reduced_string("abab"), "abab");
        test(super_reduced_string("aabbcc"), DEFAULT);
        test(super_reduced_string("aaabbb"), "ab");
        test(super_reduced_string("zztqooauhujtmxnsbzpykwlvpfyqijvdhuhiroodmuxiobyvwwxupqwydkpeebxmfvxhgicuzdealkgxlfmjiucasokrdznmtlwh"), "tqauhujtmxnsbzpykwlvpfyqijvdhuhirdmuxiobyvxupqwydkpbxmfvxhgicuzdealkgxlfmjiucasokrdznmtlwh");
    }
}
