//QUESTION https://leetcode.com/problems/zigzag-conversion
public class ZigZagConversion {
    public static void main(String[] args) {
        String str="ABCD";//PAHNAPLSIIGYIR PINALSIGYAHRPI
        System.out.println(convert(str,3));
    }

    public static String convert(String s,int numRows){
        if(numRows==1 || numRows==s.length())
            return s;

        char[][] chars=new char[numRows][s.length()/2+1];
        int whichDigit=0;
        int col=0;
        for(int j=0;whichDigit!=s.length();j++){
            chars[j][col]=s.charAt(whichDigit++);

            if(whichDigit>=s.length())
                break;

            if(j==chars.length-1){
                j--;
                col++;
                for(;j>=0;j--,col++){
                    if(whichDigit>=s.length())
                        break;
                    chars[j][col]=s.charAt(whichDigit++);
                }
                j++;
                col--;
            }
        }

        String resulStr="";
        for (char[] aChar : chars) {
            for (char a : aChar) {
                if (a != 0)
                    resulStr = resulStr.concat(String.valueOf(a));
            }
        }

        return resulStr;
    }

}
