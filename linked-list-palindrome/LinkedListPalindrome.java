import java.util.*;

public class LinkedListPalindrome{

    // CONSTRUCTOR CLASS FOR A LINKED LIST NODE.
    public static class Node{
        Node next = null;
        String data;

        public Node(String d){
            data = d;
        }

        // ADDS A NODE THAT CONTAINS THE STRING d TO THE END OF THE LINKED LIST.
        public void appendToEnd(String d){
            Node end = new Node(d);
            Node n = this;
            while(n.next != null){
                n = n.next;
            }
            n.next = end;
        }

        // RETURNS THE LENGTH OF THE ENTIRE PHRASE.
        public int totalStringLen(){
            Node n = this;
            int count = 0;
            while (n.next != null){
                if (n.data != " "){
                    count++;
                }
                n = n.next;
            }
            if (n.data != " "){
                count++;
            }
            return count;
        }

        // RETURNS THE INDEX RIGHT AT THE HALF WAY POINT OF THE
        // ENTIRE PHRASE NOT INCLUDING WHITESPACE.
        public int indexAtHalf(){
            Node n = this;
            int index = 0;
            int len = n.totalStringLen();
            int i = 0;
            int numOfSpaces = 0;
            while (index < (len/2+i)){
                if (n.data == " "){
                    i++;
                    numOfSpaces++;
                }
                index++;
                n = n.next;
            }
            if (len % 2 == 1){
                 index++;
            }
            if ((numOfSpaces == 0) || (numOfSpaces == 1)){
              return index-1;
            } else{
              return index;
            }
        }
    }

    public static void main(String args[]){
        Node head = new Node("n");
        head.appendToEnd("u");
        head.appendToEnd("r");
        head.appendToEnd("s");
        head.appendToEnd("e");
        head.appendToEnd("s");
        head.appendToEnd(" ");
        head.appendToEnd("r");
        head.appendToEnd("u");
        head.appendToEnd("n");

        System.out.print("(");
        printList(head);
        System.out.print(")");
        boolean result = isPalindrome(head);
        if (result == true){
            System.out.println(" is a palindrome!");
        } else{
            System.out.println(" is not a palindrome.");
        }
    }

    // DETERMINES IF A LINKED LIST IS A PALINDROME.
    public static boolean isPalindrome(Node head){
        Node n = head;
        Stack<String> stack = new Stack<String>();

        int count = 0;
        int len = head.totalStringLen();
        int index = head.indexAtHalf();
        String s = "";
            while (head.next != null){
                // ADD ELEMENTS BEFORE THE PHRASE'S MIDDLE ELEMENT TO THE STACK.
                while (count < index){
                    count++;
                    if (head.data != " "){
                        stack.push(head.data);
                    }
                    head = head.next;

                    // IF THE PHRASE IS OF ODD LENGTH: SKIP THE PHRASE'S MIDDLE ELEMENT.
                    // IF EVEN: INCLUDE THE MIDDLE ELEMENT TO THE STACK.
                    if ((count == index) && (len%2==1)){
                        head = head.next;
                    } else if ((count==index) && (len%2==0)){
                        stack.push(head.data);
                        head = head.next;
                    }
                }

                // BEGIN TO COMPARE ELEMENT POPPED FROM STACK TO PHRASE'S SECOND HALF.
                if (head.data == " "){
                    head = head.next;
                    if (head.next == null){
                      break;
                    }
                }
                s = stack.pop();
                if (s != head.data){
                    return false;
                } else{
                    head = head.next;
                    if (stack.isEmpty()){
                      return true;
                    }
                }
            }
            // MAKE SURE ALL ELEMENTS IN THE STACK ARE POPPED AND COMPARED.
            if (!stack.isEmpty()){
              s = stack.pop();
            }
            if(head==null){
              return true;
            }
            // CHECK THE LINKED LIST'S ELEMENT.
            if (s != head.data){
                return false;
            }
            return true;
  }

    // PRINTS A LINKED LIST.
    public static void printList(Node head){
        while (head != null){
            System.out.print(head.data);
            head = head.next;
        }
    }
}
