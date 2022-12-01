package permutationcipher;

public class PermutationCipher {

    /**
     * Encrypts a string by generating a permutation of the characters in the
     * string. The permutation is specified by permutationArray and the
     * characters may be permuted more than once depending on the number of
     * rounds indicated.
     * 
     * @param plaintext
     *                         the text to encrypt.
     * @param permutationArray
     *                         the array the specifies how to permute the plain
     *                         text. A
     *                         suitable permutation array must be equal in length to
     *                         the
     *                         plain text and must be a permutation of integers in
     *                         [0 ..
     *                         permutationArray.length-1].
     * @param rounds
     *                         the number of rounds of encryption needed; rounds
     *                         should be at
     *                         least 1.
     * @return the encrypted text (ciphertext).
     * @throws IllegalKeyException
     *                             if the permutation array is not suitable.
     */
    public static String encrypt(String plaintext, int[] permutationArray, int rounds) throws Exception {
        if (permutationArray.length != plaintext.length()) {
            throw new Exception("Permutation array length must be equal to the length of the plain text.");
        }
        if (!isPermutation(permutationArray)) {
            throw new Exception(
                    "Permutation array must be a permutation of integers in [0 .. permutationArray.length-1].");
        }
        if (rounds < 1) {
            throw new Exception("Number of rounds must be at least 1.");
        }
        String ciphertext = plaintext;
        for (int i = 0; i < rounds; i++) {
            ciphertext = permute(ciphertext, permutationArray);
        }
        return ciphertext;
    }

    private static String permute(String ciphertext, int[] permutationArray) {
        char[] chars = ciphertext.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = ciphertext.charAt(permutationArray[i]);
        }
        return new String(chars);
    }

    private static boolean isPermutation(int[] permutationArray) {
        int[] count = new int[permutationArray.length];
        for (int i = 0; i < permutationArray.length; i++) {
            if (permutationArray[i] < 0 || permutationArray[i] >= permutationArray.length) {
                return false;
            }
            count[permutationArray[i]]++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 1) {
                return false;
            }
        }
        return true;
    }
}
