package GeeksforGeeks_problem;

public class PalindromicArray {
    public static void main(String[] args) {
        int[] a = {1001, 2002, 3121, 3003, 5005, 6006};
//        int[] a = {111, 222, 333, 444, 555};
        int n = a.length;
        System.out.println(palinArray(a, n));
    }

    public static int palinArray(int[] a, int n){
        //add code here.
        String chkStr = "";
        for(int i=0; i<n; i++){
            String[] numArr = String.valueOf(a[i]).split("");
            int arrLen = numArr.length;
            int condition = arrLen%2 == 0 ? arrLen/2 : (arrLen-1)/2;

            for(int j=0; j<condition; j++){
                if(Integer.parseInt(numArr[j]) == Integer.parseInt(numArr[--arrLen])){
                    chkStr += "1";
                }else{
                    chkStr += "0";
                }
            }
        }

        return (chkStr.indexOf("0")>-1 ? 0 : 1);
    }
}
