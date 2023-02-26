//QUESTION https://leetcode.com/problems/reverse-integer
public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }

    public static int reverse(int x){
        if(x==0)
            return x;

        while(x%10==0)
            x/=10;

        boolean isXNegative=x<0;
        if(isXNegative)
            x*=-1;

        StringBuilder str=new StringBuilder(String.valueOf(x));
        str.reverse();

        try{
            int resultX=Integer.parseInt(str.toString());
            if(isXNegative)
                resultX*=-1;

            return resultX;

        }
        catch (Exception ex){
            return 0;
        }

    }
}
