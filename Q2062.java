public class Q2062 {
   public static int countVowelSubstrings(String word) {
       char[] wordArr = word.toCharArray();
       int count = 0;
       for(int left = 0; left < wordArr.length - 5; left ++) {
           boolean a = false;
           boolean e = false;
           boolean i = false;
           boolean o = false;
           boolean u = false;
           boolean end = false;
           for(int right = left; right < wordArr.length; right ++) {
               switch (wordArr[right]){
                   case 'a': a = true; break;
                   case 'e': e = true; break;
                   case 'i': i = true; break;
                   case 'o': o = true; break;
                   case 'u': u = true; break;
                   default: end = true;
               }
               if (end) {
                   break;
               }
               if (a && e && i && o && u) {
                   count ++;
               }
           }
       }
       return count;
   }

    public static void main(String[] args) {
        System.out.println(countVowelSubstrings("aeiouu"));
    }
}
