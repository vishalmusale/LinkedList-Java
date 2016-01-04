/*
 * Adding 2 numbers using linked list
 */

import java.util.Scanner;

public class Adding2NumbersUsingLL {

	public static void main(String args[])
	{
		
		System.out.println("Enter 2 Numbers : ");
		
		Scanner s = new Scanner(System.in);
    	int n1 = s.nextInt();
    	int n2 = s.nextInt();
    	
    	MyLinkedList no1 = new MyLinkedList();
    	MyLinkedList no2 = new MyLinkedList();
    	
    	// Number to list converter
    	no1 = noToList(n1);
    	no2 = noToList(n2);
    	
    	// Display the List
    	System.out.println(no1);
    	System.out.println(no2);
    	
    	// Add no1 and no2 and store the addition in no1
    	no1 = addition(no1, no2);
    	
    	// Print the list in reverse
    	int s1 = no1.size();
    	while(s1!=0){
    		System.out.print(no1.get(s1));
    		s1--;
    	}
	}

	private static MyLinkedList addition(MyLinkedList no1, MyLinkedList no2) {
		// TODO Auto-generated method stub
		int carry = 0, s1 = no1.size(), s2 = no2.size();
		
		MyLinkedList sum = new MyLinkedList();
		
		if(s1>=s2)
		{
			while(s1!=0){
				int s=0;	// Temp to store sum
				if(s2>0)
				{
					s = Integer.parseInt(no1.get(no1.size() - s1 + 1).toString()) + Integer.parseInt(no2.get(no2.size() - s2 + 1).toString()) + carry;
					if(s>9)
					{
						sum.add(s%10);
						carry = 1;
					}
					else{
						sum.add(s);
						carry = 0;						
					}
						
					s2--;
					s1--;
				}
				else{
					s = Integer.parseInt(no1.get(no1.size() - s1 + 1).toString()) + carry;
					if(s<10)
					{
						sum.add(s);
						carry = 0;
					}
					else{
						sum.add(s%10);
						carry = 1;			
					}
						
					s1--;
				}
				
			}
			
			if(carry == 1)
				sum.add(1);
			return sum;
		}
		else{
			while(s2!=0){
				int s=0;	// Temp to store sum
				if(s1>0)
				{
					s = Integer.parseInt(no2.get(no2.size() - s2 + 1).toString()) + Integer.parseInt(no1.get(no1.size() - s1 + 1).toString()) + carry;
					if(s>9)
					{
						sum.add(s%10);
						carry = 1;
					}
					else{
						sum.add(s);
						carry = 0;						
					}
						
					s2--;
					s1--;
				}
				else{
					s = Integer.parseInt(no2.get(no2.size() - s2 + 1).toString()) + carry;
					if(s<9)
					{
						sum.add(s);
						carry = 0;
					}
					else{
						sum.add(s%10);
						carry = 1;			
					}
						
					s2--;
				}
				
			}
			if(carry == 1)
				sum.add(1);
			return sum;
		}
	}

	private static MyLinkedList noToList(int n1) {
		// TODO Auto-generated method stub
		
		MyLinkedList no = new MyLinkedList();
		while(n1>0)
		{
			int temp = n1%10;
			no.add(temp);
			n1=n1/10;
		}
		return no;
	}
	
}

class MyLinkedList{
	
	Node head;
	int lCount;
	//Object data;
	
	MyLinkedList()	// Constructor
	{
		head = new Node(null);
		lCount = 0;
	}
	
	public void add(Object data){
		
		Node temp = new Node(data);
		Node cur = head;
		
		while(cur.getNext() != null)
		{
			cur = cur.getNext();
		}
		
		cur.setNext(temp);
		lCount++;
	}
	
	public int size()
	{
		return lCount;
	}
	
	
	public Object get(int index){
		
		if(index <= 0)
			return null;
		
		Node cur = head.getNext();
		for(int i=1; i<index; i++)
		{
			if(cur.getNext() == null)
				return null;
			
			cur = cur.getNext();
		}
		
		return cur.getData();
	}
	
	public String display(){
		String output = "";
		
		Node cur = head.getNext();
		while(cur!=null)
		{
			output += cur.getData().toString();
			cur = cur.getNext();
		}
		
		return output;
	}
	
	public String toString() {
        Node currentNode = head.getNext();
        String output = "";
        while (currentNode != null) {
            output += currentNode.getData().toString();
            currentNode = currentNode.getNext();
        }
        return output;
    }
	
	private class Node{
		
		Node next;
		Object data;
		
		public Node(Object val){
			next = null;
			data = val;
		}
		
		public Object getData(){
			return data;
		}
		
		public void setData(Object val){
			data = val;
		}
		
		public Node getNext(){
			return next;
		}
		
		public void setNext(Node nextValue) {
            next = nextValue;
        }
	}
}

