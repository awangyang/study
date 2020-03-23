package com.example.leetcode;

/**
 * @Description:
 * @author: WangYang
 * @date: 2019-10-09 19:56:26
 */
public class Solution5 {
    public static String longestPalindrome(String s) {
//        String result = "";
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = 0; j <= i; j++) {
//                result = s.substring(j, s.length() + j - i);
//                if (result.contentEquals(new StringBuffer(result).reverse().toString())) {
//                    return result;
//                }
//            }
//        }
//        return result;

//        String result = "";
//        int length = 0;
//        String temp;
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            for (int j = s.length() - 1; j > i; j--) {
//                if (c == s.charAt(j)) {
//                    temp = s.substring(i, j + 1);
//                    if (temp.contentEquals(new StringBuffer(temp).reverse().toString())) {
//                        return temp;
//                    }
//                }
//            }
//            temp = String.valueOf(c);
//            if (length < temp.length()) {
//                length = temp.length();
//                result = temp;
//            }
//
//        }
//        return result;






        return "";
    }

    public static void main(String[] args) {
//        System.out.println(longestPalindrome("abacdef"));
//        System.out.println(longestPalindrome("lejyqjcpluiggwlmnumqpxljlcwdsirzwlygexejhvojztcztectzrepsvwssiixfmpbzshpilmojehqyqpzdylxptsbvkgatzdlzphohntysrbrcdgeaiypmaaqilthipjbckkfbxtkreohabrjpmelxidlwdajmkndsdbbaypcemrwlhwbwaljacijjmsaqembgtdcskejplifnuztlmvasbqcyzmvczpkimpbbwxdtviptzaenkbddaauyvqppagvqfpednnckooxzcpuudckakutqyknuqrxjgfdtsxsoztjkqvfvelrklforpjnrbvyyvxigjhkjmxcphjzzilvbjbvwiwnnkbmboiqamgoimujtswdqesighoxsprhnsceshotakvmoxqkqjvbpqucvafiuqwmrlfjpjijbctfupywkbawquchbclgvhxbanybret"));
        long t = System.currentTimeMillis();
        System.out.println(longestPalindrome("lphbehiapswjudnbcossedgioawodnwdruaaxhbkwrxyzaxygmnjgwysafuqbmtzwdkihbwkrjefrsgjbrycembzzlwhxneiijgzidhngbmxwkhphoctpilgooitqbpjxhwrekiqupmlcvawaiposqttsdgzcsjqrmlgyvkkipfigttahljdhtksrozehkzgshekeaxezrswvtinyouomqybqsrtegwwqhqivgnyehpzrhgzckpnnpvajqevbzeksvbezoqygjtdouecnhpjibmsgmcqcgxwzlzztdneahixxhwwuehfsiqghgeunpxgvavqbqrelnvhnnyqnjqfysfltclzeoaletjfzskzvcdwhlbmwbdkxnyqappjzwlowslwcbbmcxoiqkjaqqwvkybimebapkorhfdzntodhpbhgmsspgkbetmgkqlolsltpulgsmyapgjeswazvhxedqsypejwuzlvegtusjcsoenrcmypexkjxyduohlvkhwbrtzjnarusbouwamazzejhnetfqbidalfomecehfmzqkhndpkxinzkpxvhwargbwvaeqbzdhxzmmeeozxxtzpylohvdwoqocvutcelgdsnmubyeeeufdaoznxpvdiwnkjliqtgcmvhilndcdelpnilszzerdcuokyhcxjuedjielvngarsgxkemvhlzuprywlypxeezaxoqfges"));
//        System.out.println(longestPalindrome(""));
//        System.out.println(longestPalindrome("0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"));
        System.out.println(System.currentTimeMillis() - t);
    }

}
