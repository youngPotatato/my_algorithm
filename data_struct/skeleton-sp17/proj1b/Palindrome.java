public class Palindrome {
    public static Deque<Character> wordToDeque(String word){
        ArrayDeque<Character> dd = new ArrayDeque<>() ;
        if(word.length() == 0){

        } else {
            for (int i = 0; i < word.length(); i++) {
                dd.addLast(word.charAt(i));
            }
        }
        return dd;
    }
    public static boolean isPalindrome(String word){
        if((word.length() == 0) || (word.length() == 1)) {
            return true;
        } else{
          if(word.charAt(0) == wordToDeque(word).removeLast()){
              return isPalindrome(word.substring(1,word.length()-1));
          }else{
              return false;
          }
        }
    }

    public static boolean isPalindrome(String word, CharacterComparator cc){
        if((word.length() == 0)||(word.length() == 1)) {
            return true;
        }else {
            if(cc.equalChars(word.charAt(0),wordToDeque(word).removeLast())){
                return isPalindrome(word.substring(1,word.length()-1),cc);
            } else {
                return false;
            }
        }
    }
    public static void main(String [] args){
        String ss = "bilic";
        OffByOne oo = new OffByOne();
        wordToDeque(ss).printDeque();
        System.out.println(isPalindrome(ss,oo));
        //ss = "A";
        //wordToDeque(ss).printDeque();
        //System.out.println(isPalindrome(ss));
        //ss = "";
        //wordToDeque(ss).printDeque();
        //System.out.println(isPalindrome(ss));
        //ss = "AsskkssA";
        //wordToDeque(ss).printDeque();
        //System.out.println(isPalindrome(ss));
    }
}
