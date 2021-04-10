// Poojan Patel: 5453845 (patel709)

import java.util.Scanner;

public class PList implements PListInterface{
  ObjectNode head = new ObjectNode();

  public void Plist(){
    head = null;
  }//constructor

  /* Method that adds item to the start of the PList. The method checks if the list is empty.
    * If the list is empty, the head points to the new item added. If the list is not
    * empty, the list is set equal to a temporary variable and the item is added in.
  *
    * @param item. An Object that corresponds to the data point the user wants to add
  */
  public void add(Object item){
    if(head == null){
      ObjectNode adding = new ObjectNode(item,null);
      head = new ObjectNode(null, adding);
    }
    else{
      ObjectNode temp = head;
      temp.setData(item);
      head = new ObjectNode(null,temp);
    }
  }

  /* Method that adds item to the end of the PList. While loop is used to get to the
    * very last node in the list. The new keyword is used to create a new node and the
    * setNext method is used to set the last pointer to the new node.
  *
    * @param item. An Object that corresponds to the data point the user wants to add
  */
  public void append(Object item){
    ObjectNode temp = head;
    while(temp.getNext()!=null){
      temp = temp.getNext();
    }
    ObjectNode appending = new ObjectNode(item, null);
    temp.setNext(appending);
  }

  /* Method that joins an existing plist to the one the user just created. The code
    * gets to the last element of the first list, and utilizes the for loop to join
    * the two lists. While the counter(i) is maintained within the valid index, a new
    * ObjectNode is created and the temp pointer is set to the new ObjectNode.
  *
    * @param plist. Hard coded Plist that the user wants to add to end of the list
  */
  public void concatenate(PListInterface plist){
    plist.print();
    ObjectNode temp = head;
    while(temp.getNext() != null){
      temp = temp.getNext();
    }
    Object item;
    int length = plist.length();
    int count = 0;
    for(int i = 0; i<length; i++){
      item = plist.get(count);
      ObjectNode appending = new ObjectNode(item, null);
      temp.setNext(appending);
      temp = temp.getNext();
      count ++;
    }
  }

  /* Method that removes the item at specified index. The method gets the maximum
    * index by using a while loop. If the index exceeds that max index, the index
    * is not found in the list and cannot be deleted. If this is not the case, then
    * the pointer of the previos node is set to the next node so the indicated node
    * is removed.
  *
    * @param index. A number that corresponds to the data point the user wants to remove
  */
  public void delete(int index){
    ObjectNode temp = head;
    int maxindex = -1;
    ObjectNode lengthtemp = head;
    while(lengthtemp.getNext() != null){
      maxindex ++;
      lengthtemp = lengthtemp.getNext();
    }
    if(index > maxindex){
      System.out.println("Index not in list. Choose another option.");
    }
    else{
      for(int count = 0; count<index; count++)
        temp = temp.getNext();
      ObjectNode temp1 = temp.getNext();
      if(temp1.getNext() != null){
        ObjectNode temp2 = temp1.getNext();
        temp.setNext(temp2);
      }
      else{
        temp.setNext(null);
      }
    }
  }

  /* Method that returns the data of a certain index in the list. The length of the
    * list is used to make sure iterations do not occur past the maximum index of
    * the list. If the counter variable is equal to the index the user wants information
    * for, the data for that node is returned. If this condition is never fulfilled,
    * it is that the list has not value for that index.
  *
    * @param index. A number that corresponds to the data point the user wants to recieve
  *
    * @returns the data item at specified index.
  */
  public Object get(int index){
    int count = 0;
    ObjectNode temp = head;
    while(temp.getNext()!=null){
        temp = temp.getNext();
        if(count == index){
          return temp.getData();
        }
        count++;
      }
    return "Invalid Index.";
  }

  /* Method that inserts an item at the specified index by the user. The method uses
    * multiple temporary variables to keep track of the different places on the list.
    * If the index is the last item in the list, the new node needs to have an empty
    * pointer. If the index is in the middle of the list, then iterations occur to
    * get to that point and new pointers are assigned.
  *
    * @param item. Item the user wants to insert
    * @param index. A number that corresponds to the data point the user wants to insert
  */
  public void insert(Object item, int index){
    int count = 0;
    ObjectNode temp = head;
    ObjectNode temp2 = head;
    ObjectNode inserting = new ObjectNode(item, null);
    while(temp.getNext() != null){
      count ++;
      temp = temp.getNext();
    }
    if(index>count-1){
      while(temp.getNext()!=null){
        temp = temp.getNext();
      }
      ObjectNode appending = new ObjectNode(item, null);
      temp.setNext(appending);
    }
    else{
      for(int i = 0; i<count; i++){
        if(i == index){
          ObjectNode temp3 = temp2.getNext();
          temp2.setNext(inserting);
          temp2 = temp2.getNext();
          temp2.setNext(temp3);
        }
        temp2 = temp2.getNext();
      }
    }
  }

  /* Method that returns the length of the list. While loop makes sure that the pointer
    * is not null and adds 1 to the counter. While the pointer exists there is an item
    * at that point in the list.
  *
    * @returns integer length of the list
  */
  public int length(){
    int count = 0;
    ObjectNode temp = head;
    while(temp.getNext() != null){
      count ++;
      temp = temp.getNext();
    }
    return count;
  }

  /* Method prints all items of the list. Checks if the list has items in it and then uses
    * while loop and prints data point from each node.
  *
  */
  public void print(){
    ObjectNode temp = head;
    if(temp.getNext() == null)
      System.out.println("The list is empty");
    while(temp.getNext() != null){
      temp = temp.getNext();
      System.out.println(temp.getData());
    }
  }

  /* Method revoves first occurence of item in the list. First, the function checks if the
    * list is empty. If not, the data of each node is compared to the inputed item. If the
    * item in the node is the same as the input, the pointers for the nodes are re-assigned.
  *
    * @param item. Item the user wants to remove
  */
  public void remove(Object item){
    ObjectNode temp = head.getNext();
    ObjectNode temp1 = head;
    int count = 0;
    if(temp1.getNext() == null){
      System.out.println("List is empty, cannot remove from list");
    }
    else{
      while(temp.getNext() != null && !(temp.getData().equals(item))){
        temp = temp.getNext();
        count ++;
      }
      for(int i = 0; i<count; i++){
        temp1 = temp1.getNext();
      }
      if(temp.getData().equals(item)){
        ObjectNode temp3 = temp.getNext();
        temp1.setNext(temp3);
      }
    }
  }

  /* Method that sorts a list lexographically. A bubble sort is used in this method
   * If the list is empty or only has one element, appropriate messages are displayed
   * to show the user the list may already be sorted. If the list is not sorted, the
   * nested for loops iterate through the list and compare adjacent elements and drop
   * the lexographically largest values to the bottom of the list and the smaller ones
   * to the top.
  *
  */
  public void sort(){
    ObjectNode lengthtemp = head;
    int length = 0;
    boolean swapped = true;
    while(lengthtemp.getNext() != null){
      length ++;
      lengthtemp = lengthtemp.getNext();
    }
    ObjectNode newtemp = head;
    if(newtemp.getNext() == null){
      System.out.println("List is Empty.");
    }
    else{
      newtemp = newtemp.getNext();
      if(newtemp.getNext() == null){
        System.out.println("List is sorted.");
      }
      else{
        Object holder;
        System.out.println("List is sorted.");
        for(int i = 0; i<length && swapped == true; i++){
          ObjectNode temp = new ObjectNode();
          ObjectNode next = new ObjectNode();
          temp = head.getNext();
          next = temp.getNext();
          swapped = false;
          for(int j = 0; j<=length -2; j++){
            if(temp.toString().compareTo(next.toString()) > 0){
              swapped = true;
              holder = next.getData();
              next.setData(temp.getData());
              temp.setData(holder);
            }
            temp = temp.getNext();
            next = next.getNext();
          }
        }
      }
    }
  }

  /* Method returns a string representation of the list. In this case the string
   * is represented by its length.
  */
  public String toString(){
    ObjectNode temp = head;
    int length = 0;
    while(temp.getNext() != null){
      temp = temp.getNext();
      length++;
    }
    return getClass().getName()+" has a length of "+length;
  }


  /* Method that checks to see if inputed plist has the exact same length as the
   * original list. It was up to us to decide what the equals method does, so I
   * decided to simply check the lengths of the two lists and compare them
  *
    * @param plist. Hard coded Plist that the user wants to compare to the original list
  */
  public void equals(PListInterface plist){
    ObjectNode temp = head;
    ObjectNode temp2 = head.getNext();
    int length = 0;
    while(temp.getNext() != null){
      length ++;
      temp = temp.getNext();
    }
    if(length != plist.length()){
      System.out.println("Lists are not equal length.");
    }
    else{
      System.out.println("Lists are equal in length.");
    }
  }

  public static void main(String[] args){
    Scanner s1 = new Scanner(System.in);
    PList p1 = new PList();
    boolean x = true;
    while(x){
      System.out.println("Choose an option:  ~ create  ~ add  ~ append  ~ concatenate  ~ delete  ~ get  ~ insert  ~ length  ~ print  ~ remove  ~ sort  ~ exit ");
      String input = s1.nextLine();
      switch (input){
        case "create":
          p1 = new PList();
          System.out.println("Empty list has been created.");
          break;
        case "add":
          System.out.println("Enter the item you would like to add: ");
          String item = s1.nextLine();
          p1.add(item);
          break;
        case "append":
          System.out.println("Enter the item you would like to append: ");
          String item1 = s1.nextLine();
          p1.append(item1);
          break;
        case "concatenate":
            PList p2 = new PList();
            p2.add(8);
            p2.add(6);
            p2.add(4);
            p2.add(2);
            p1.concatenate(p2);
        //does not work
          break;
        case "delete":
          System.out.println("Enter the index you would like to delete: ");
          int index1 = s1.nextInt();
          p1.delete(index1);
          s1.nextLine();
          break;
        case "get":
          System.out.println("Enter the index you would like to recieve data for: ");
          int index = s1.nextInt();
          System.out.println(p1.get(index));
          s1.nextLine();
          break;
        case "insert":
          System.out.println("Enter the item you would like to insert: ");
          String item2 = s1.nextLine();
          System.out.println("Enter the index you would like to insert add: ");
          int index2 = s1.nextInt();
          p1.insert(item2, index2);
          s1.nextLine();
          break;
        case "length":
          System.out.println("The list has a length: " + p1.length());
          break;
        case "print":
          System.out.println("\n");
          p1.print();
          break;
        case "remove":
          System.out.println("Enter the item you would like to remove: ");
          Object item3 = s1.nextLine();
          p1.remove(item3);
          break;
        case "sort":
          System.out.println("\n");
          p1.sort();
          break;
        case "exit":
          x = false;
          System.out.println("Exiting Program.");
          break;
        default:
          System.out.println("Invalid Command. Try again.");
          break;
      }
    }
  }
}
