package previmedical.it.leetcode.problems.easy;

public class N925_LongPressedName {

    /*

        Your friend is typing his name into a keyboard.
        Sometimes, when typing a character c, the key might get long pressed,
        and the character will be typed 1 or more times.

        You examine the typed characters of the keyboard.
        Return True if it is possible that it was your friends name,
        with some characters (possibly none) being long pressed.


        Example 1:
        Input: name = "alex", typed = "aaleex"
        Output: true
        Explanation: 'a' and 'e' in 'alex' were long pressed.


        Example 2:
        Input: name = "saeed", typed = "ssaaedd"
        Output: false
        Explanation: 'e' must have been pressed twice, but it wasn't in the typed output.


        Example 3:
        Input: name = "leelee", typed = "lleeelee"
        Output: true


        Example 4:
        Input: name = "laiden", typed = "laiden"
        Output: true
        Explanation: It's not necessary to long press any character.


        Note:
        name.length <= 1000
        typed.length <= 1000
        The characters of name and typed are lowercase letters.

     */


    /*

    Affinche sia long typed, per ogni carattere della stringa name che ha n occorrenze,
    ci devono essere almeno n occorrenze anche nella stringa typed

    Pertanto inizio a scorrere la stringa name, fintanto che trovo caratteri uguali li conto,
    quando ne trovo uno diverso mi fermo ed inizio un ciclo while nella stringa typed per trovare
    almeno n occorrenze dello stesso carattere.
    Mi fermo all'indice del primo carattere diverso.

    A questo punto ripeto il processo per tutte le lettere.
    Se capita un caso in cui o non trovo corrispondenza di un carattere o nella stringa typed
    ci sono meno occorrenze di un carattere ritorno false.

    Se riesco a raggiungere la fine ritorno true
     */


    public boolean isLongPressedName(String name, String typed) {

        int nameIndex = 0;
        int typedIndex = 0;

        while (nameIndex < name.length()) {

            char c = name.charAt(nameIndex);

            int nameCharIndex = nameIndex + 1;
            while (nameCharIndex < name.length() && name.charAt(nameCharIndex) == c) {
                nameCharIndex++;
            }

            int numOccurrencesName = nameCharIndex - nameIndex;

            int typedCharIndex = typedIndex;
            while (typedCharIndex < typed.length() && typed.charAt(typedCharIndex) == c) {
                typedCharIndex++;
            }

            int numOccurrencesTyped = typedCharIndex - typedIndex;

            if (numOccurrencesTyped < numOccurrencesName) {
                return false;
            }

            nameIndex = nameCharIndex;
            typedIndex = typedCharIndex;
        }

        return true;
    }


    public void test() {

    }
}
