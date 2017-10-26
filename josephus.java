//assignment 3
//This program implements the Josephus problem using a Circular Linked List
import java.io.*;
import java.util.Scanner;

class Link
{
   public int iData;
   public Link next;

   public Link(int id)
   {
      iData = id;
   }//end of constructor

   public void displayLink()
   {
      System.out.print(" " + iData + " ");
   }//end of displayLink
}//end of class Link

class CircleLinkedList
{
   private Link current;
   private Link first;
   private Link last;
   private Link previous;
 
   public CircleLinkedList(int nElems, int startPoint)
   {
      current = null;
      first = null;
      last = null;
      createCircle(nElems);
      setCurrent(startPoint);
   }//CircleLinkedList
 
   public void createCircle(int nElems)
   {
   //Creat the first link
      Link firstLink = new Link(nElems);
      first = firstLink;
   
   //Create the body of the linked circle
      for(int i = nElems-1; i > 1; i--)
      {
         createLink(i);
      }//for
   
   //Create the last link
      Link lastLink = new Link(1);
      lastLink.next = first; //set next reference to first link
      first = lastLink;
   
   //Point the first created link to the last created link making a 'circle'
      last = lastLink;
      firstLink.next = last;
      
   }//createCircle
 
   public void createLink(int value)
   {
      Link newLink = new Link(value);
      newLink.next = first;
      first = newLink;
   }//createLink
   
   public void setCurrent(int key)
   {
      //start at beggining
      current = first;
      previous = first;
      
      while(current.iData != key) //until we find the key
      {
         previous = current; //set previous to current
         current = current.next; //move current to next
      }//while
   }//setCurrent
   
   public void removeCurrent()
   {
      previous.next = current.next;//bypass current link
      current = current.next;//move current to next link
   }
   
   public void printCurrent()
   {
      current.displayLink();
   }//printCurrent
   
   public void pushCurrent()
   {
   //push the current forward by one
      previous = current;
      current = current.next;
   }
 

}//end CircleLinkedList

class josephus
{
   public static void main(String[] args)
   {
      Scanner scan = new Scanner(System.in);//create scanner
      String input = null;//set input to null
      do{
      //user input
         System.out.println("\nThis program simulates the Josephus Problem.");
         System.out.println("The first int is how many people are in the circle.");
         System.out.println("The second int is which person in the circle starts the count.");
         System.out.println("The second int is how many times the circle counts until removed.");



         System.out.println("\nEnter three integers or stop to exit: ");
         input = scan.nextLine();
         
         if(input.equals("stop"))//if exit break
            break;
         else //else play the game
         {
         //Split string and parse into integers
            String tokens[] = input.split(" ");
            System.out.print(tokens[0] + " " + tokens[1] + " " + tokens[2]);
         
            int a = Integer.parseInt(tokens[0]);
            int b = Integer.parseInt(tokens[1]);
            int c = Integer.parseInt(tokens[2]);
         
         //Create new linked list based on input
            CircleLinkedList game = new CircleLinkedList(a, b);
         
         //Do the Josephus Problem
            for(int j = 0; j < a-1; j++)
            {
               for(int i = 0; i < c; i++)
               {
                  game.pushCurrent();
               }//for i
               game.removeCurrent();
            }//for j
            
            System.out.println("\nWinner is: ");
            game.printCurrent();
            
         }//else
         
      }
      while(!(input.equals("stop")));
   
      System.out.println("Exitting");
   
   //create circleLinkedList
   
   //play the 'game'
   //count by nCount
   //remove the current link
   //repeat until only one link is left   
   //return survivor
   
   }//main

}//class josephus