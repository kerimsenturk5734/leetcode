
//QUESTION LINK --->https://leetcode.com/problems/add-two-numbers/

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1=new ListNode(9);

        //[1,9,9,9,9,9,9,9,9,9]
        ListNode l2=new ListNode(1),temp=l2;

        int[] nums={9,9,9,9,9,9,9,9,9};
        for (int val:nums) {
            temp.next=new ListNode(val);
            temp=temp.next;
        }
        printLinkedList(l1);
        System.out.println();
        printLinkedList(l2);
        System.out.println();
        addTwoNumbers(l1,l2);

    }

    //This solution is for nonoutofboundinteger results.
    //We are using String concat to get list int value
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String num1="";
        String num2="";

        ListNode temp=l1;
        while(temp!=null){
           num1=temp.val+num1;
           temp=temp.next;
        }

        temp=l2;
        while(temp!=null){
            num2=temp.val+num2;
            temp=temp.next;

        }

        int sum=0;
        try{
            sum=Integer.parseInt(num1)+Integer.parseInt(num2);
            String strSum=Integer.toString(sum);

            int val = getIntFromChar(strSum.charAt(strSum.length()-1));

            ListNode result=new ListNode(val);
            temp=result;
            for(int i=2;i<=strSum.length();i++){
                int digit = getIntFromChar(strSum.charAt(strSum.length()-i));
                temp.next=new ListNode(digit);
                temp=temp.next;
            }

            return result;

        }catch (Exception e){
           return calculateForOutOfInt(l1,l2);
        }

    }

    public static int getIntFromChar(Character ch){
        return Integer.
                parseInt(String.
                        valueOf(ch));
    }

    //This solution for every result.
    //calculating each digit
    public static ListNode calculateForOutOfInt(ListNode l1,ListNode l2){
        ListNode result=new ListNode();
        ListNode temp1=l1,temp2=l2,tempForResult=result;
        int carry=0;

        int actualSum=temp1.val+temp2.val+carry;
        tempForResult.val=actualSum%10;;
        carry=actualSum/10;
        temp1=temp1.next;
        temp2=temp2.next;

        while(temp1!=null || temp2!=null){
            if(temp1!=null && temp2!=null){
                actualSum=temp1.val+temp2.val+carry;
                tempForResult.next=new ListNode(actualSum%10);
                carry=actualSum/10;
            }
            else if(temp1==null){
                actualSum= temp2.val+carry;
                tempForResult.next=new ListNode(actualSum%10);
                carry=actualSum/10;
            }
            else if(temp2==null){
                actualSum= temp1.val+carry;
                tempForResult.next=new ListNode(actualSum%10);
                carry=actualSum/10;
            }



            if(temp1!=null)
                temp1=temp1.next;
            if(temp2!=null)
                temp2=temp2.next;

            tempForResult=tempForResult.next;
        }
        if(carry!=0)
            tempForResult.next=new ListNode(carry);

        printLinkedList(result);
        return result;
    }
    
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static void printLinkedList(ListNode l){
        ListNode temp=l;
        while(temp!=null){
            System.out.print(temp.val);
            temp=temp.next;
        }
    }
}
