package datastructure;
import java.util.InputMismatchException;
import java.util.Scanner;
//**********Array*************
class Array {
    private static int size;
    private static double[] array;
    static Scanner in = new Scanner(System.in);

    public Array() {
        size = 10;
        array = new double[size];
    }

    public Array(int s) {
        size = s;
        array = new double[size];
    }

    public static void insert() {
        System.out.print("\nEnter the elements of the array: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = in.nextDouble();
        }
    }

    public static void delete(double item) {
        boolean found = false;
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == item) {
                found = true;
                index = i;
                array[i] = 0;
                break;
            }
        }
        if (found) {
            for (int i = index; i < array.length - 1; i++) {
                array[i] = array[i + 1];
            }
            array[array.length - 1] = 0;
        }
    }

    public static void deleteAllIteration(double data) {
        for (int i = 0; i < array.length; i++) {
            delete(data);
        }
    }

    public static void print() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != -1)
                System.out.print(array[i] + "  ");
        }
        System.out.println();
    }

    public static double findMax() {
        double max = array[0];
        for (double num : array) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static double findMin() {
        double min = array[0];
        for (double num : array) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    public static double sum() {
        double total = 0;
        for (double num : array) {
            total += num;
        }
        return total;
    }
        public static void OneArrayADT(){
   int op;
        double ele;
        do {
            System.out.println("1_Insert \n2_Print\n3_Delete\n4_Delete All\n5_Find Max\n6_Find Min\n7_Sum\n0_Exit");
            op = in.nextInt();
            switch (op) {
                case 1:
                    insert();
                    break;
                case 2:
                    print();
                    break;
                case 3:
                    System.out.println("Enter the element to delete:");
                    ele = in.nextDouble();
                    delete(ele);
                    break;
                case 4:
                    System.out.println("Enter the element to delete all:");
                    ele = in.nextDouble();
                    deleteAllIteration(ele);
                    break;
                case 5:
                    System.out.println("Max element: " + findMax());
                    break;
                case 6:
                    System.out.println("Min element: " + findMin());
                    break;
                case 7:
                    System.out.println("Sum of elements: " + sum());
                    break;
                case 0:
                    op = 0;
                    break;
            }
        } while (op != 0);
 }
}
//*************ArrayTow****************
class TwoDArray {
public static Scanner  in = new Scanner(System.in); 
 static   int array[][];
    
static    boolean isEmpty = true;

    public TwoDArray() {
        this.array = new int[4][5];
        in = new Scanner(System.in);
    }

    public TwoDArray(int rows, int column) {
        this.array = new int[rows][column];
        in = new Scanner(System.in);
    }

static    void insert() {
        System.out.println(" Enter The Values : ");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = in.nextInt();
            }
        }
        isEmpty = false;
    }

 static   void print() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print("\t" + array[i][j] + "\t");
            }
            System.out.println("");
        }
        System.out.println("");
    }

  static  int[] search(int item) {
        int arr[] = {0, 0, 0};
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == item) {
                    arr[0] = 1;
                    arr[1] = i;
                    arr[2] = j;
                    break;
                }
            }
            break;
        }
        return arr;
    }

static    void delete(int indexRow, int indexCol) {
        for (int i = indexRow; i < array.length; i++) {
            for (int j = indexCol; j < array[i].length - 1; j++) {
                array[i][j] = array[i][j + 1];
            }

            if (i != array.length - 1) {
                array[i][array[i].length - 1] = array[i + 1][0];
            }

            indexCol = 0;
        }
        array[array.length - 1][array[0].length - 1] = 0;
    }

static    void deleteAll(int indexRow, int indexCol) {
        for (int i = indexRow; i < array.length; i++) {
            for (int j = indexCol; j < array[i].length - 1; j++) {
                array[i][j] = array[i][j + 1];
            }
            if (i != array.length - 1) {
                array[i][array[i].length - 1] = array[i + 1][0];
            }
            indexCol = 0;
        }
        array[array.length - 1][array[0].length - 1] = 0;
        indexCol--;
    }

static    int[] convert() {
        int index = 0;
        int arr[] = new int[array.length * array[0].length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                arr[index] = array[i][j];
                index++;
            }
        }
        return arr;
    }

static    void printODArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("\t" + arr[i] + " \t");
        }
        System.out.println(" ");
    }

 static   void deleteOne(int arr[], int indexRow) {
        for (int j = indexRow; j < arr.length - 1; j++) {
            arr[j] = arr[j + 1];
        }
        arr[arr.length - 1] = 0;
    }

 static   void insertFromODArray(int arr[]) {
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = arr[index];
                index++;
            }
        }
    }

    // دالة لإيجاد أكبر عنصر في المصفوفة
static    int findMax() {
        int max = array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                }
            }
        }
        return max;
    }

    // دالة لإيجاد أصغر عنصر في المصفوفة
static    int findMin() {
        int min = array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] < min) {
                    min = array[i][j];
                }
            }
        }
        return min;
    }

    // دالة لإيجاد مجموع عناصر المصفوفة
 static   int sum() {
        int total = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                total += array[i][j];
            }
        }
        return total;
    }
    static void clean() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void TwoDArrayADT( ){
        String choose;
        int array1[], item;
        boolean found = false;

        do {
            System.out.println(" Enter 1 to insert with size 4,5 : ");
            System.out.println(" Enter 2 to insert with any size : ");
            System.out.println(" Enter 3 to print  : ");
            System.out.println(" Enter 4 to delete without repeat  : ");
            System.out.println(" Enter 5 to delete with repeat by TOArray : ");
            System.out.println(" Enter 6 to delete with repeat by Convert into ODArray : ");
            System.out.println(" Enter 7 to find max element : ");
            System.out.println(" Enter 8 to find min element : ");
            System.out.println(" Enter 9 to find sum of elements : ");
            System.out.println(" Enter 0 to Exit  : ");
            choose = in.next();
            clean();

            switch (choose) {
                case "1":
                    if (isEmpty) {
                        insert();
                    } else
                        System.out.println(" The Matrix is Full ! \n ");
                    break;
                case "2":
                    if (isEmpty) {
                        System.out.println(" Enter number of Rows : ");
                        int rows = in.nextInt();
                        clean();
                        System.out.println(" Enter number of Columns : ");
                        int cols = in.nextInt();
                        clean();
                       TwoDArray obj = new TwoDArray(rows, cols);
                        insert();
                    } else
                        System.out.println(" The Matrix is Full ! \n ");
                    break;
                case "3":
                    if (!isEmpty) {
                        print();
                    } else
                        System.out.println(" Sorry! The Matrix is Empty \n");
                    break;
                case "4":
                    if (!isEmpty) {
                        System.out.println(" Enter the number to delete it : ");
                        item = in.nextInt();
                        clean();
                        array1 = search(item);
                        if (array1[0] == 1) {
                            delete(array1[1], array1[2]);
                            System.out.println(" Deleted Successfully ! ");
                        } else
                            System.out.println(" Sorry ! \n \t The number [ " + item + " ] is not found ");
                    } else
                        System.out.println(" Sorry! The Matrix is Empty \n");
                    break;
                case "5":
                    if (!isEmpty) {
                        System.out.println(" Enter the number to delete it : ");
                        item = in.nextInt();
                        clean();
                        for (int i = 0; i < array.length; i++) {
                            for (int j = 0; j < array[i].length; j++) {
                                if (array[i][j] == item) {
                                    delete(i, j);
                                    found = true;
                                    j--;
                                }
                            }
                        }
                        if (found)
                            System.out.println(" Deleted Successfully \n ");
                        else
                            System.out.println(" The number [  " + item + "  ] is not found ! \n");
                    } else
                        System.out.println(" Sorry! The Matrix is Empty \n");
                    found = false;
                    break;
                case "6":
                    if (!isEmpty) {
                        array1 = convert();
                        System.out.println(" The Matrix in One Dimensional form \n\t Enter 0 to print In One Dimensional form : \n  \tEnter any ITEM to delete it :  ");
                        item = in.nextInt();
                        clean();
                        if (item == 0)
                            printODArray(array1);
                        else
                            for (int i = 0; i < array.length; i++) {
                                if (array1[i] == item) {
                                
                                    deleteOne(array1, i);
                                    found = true;
                                    i--;
                                }
                            }

                        insertFromODArray(array1);
                        if (found)
                            System.out.println(" Deleted Successfully \n ");
                        else
                            System.out.println(" The number [  " + item + "  ] is not found ! \n");
                        found = false;
                    } else
                        System.out.println(" Sorry! The Matrix is Empty \n");
                    break;
                case "7":
                    if (!isEmpty) {
                        System.out.println("Max element: " + findMax());
                    } else {
                        System.out.println(" Sorry! The Matrix is Empty \n");
                    }
                    break;
                case "8":
                    if (!isEmpty) {
                        System.out.println("Min element: " + findMin());
                    } else {
                        System.out.println(" Sorry! The Matrix is Empty \n");
                    }
                    break;
                case "9":
                    if (!isEmpty) {
                        System.out.println("Sum of elements: " + sum());
                    } else {
                        System.out.println(" Sorry! The Matrix is Empty \n");
                    }
                    break;
                case "0":
                    System.out.println("EIXT........");
                    break;
                default:
                    System.out.println("Error\n\t Enter a True operation! \n");
            }
        } while (!choose.equals("0"));
        }
    
}
//*******ArrayListClass************
class ArrayListClass {
    private static int CurrentPosition;
    private static int listItem[];
    static Scanner in = new Scanner(System.in);
        
    public ArrayListClass() {
        CurrentPosition = 0;
        listItem = new int[10];
    }
    public ArrayListClass(int size) {
        CurrentPosition = 0;
        listItem = new int[size];
    }
public static   void addElement(int item) {
        if (isFull()) {
            System.out.println("\t The list is full !");
            return;
        }
        listItem[CurrentPosition++] = item;
    }
public static   void deleteItem(int item) {
        if (isEmpty()) {
            System.out.println("\t Cann't Delete from Empty List !");
            return;
        }
        int index = 0;
        boolean found = false;
        while (index != CurrentPosition) {
            if (item == listItem[index]) {
                int start = index;
                found = true;
                while (start != CurrentPosition) {
                    listItem[start] = listItem[start + 1];
                    start++;
                }
                break;
            }
            index++;
        }
        if (found) {
            CurrentPosition = CurrentPosition - 1;
            System.out.println("\t Item Deleted Successfully ");
            return;
        }
        System.out.println("\t No Item Found On the list;");
    }
 public static  int getNextItem(int item) {
        int indexIfIsFound = search(item);
        if (indexIfIsFound != -1 && indexIfIsFound < CurrentPosition) {
            return listItem[indexIfIsFound + 1];
        }
        return 0;
    }
public static   int search(int item) {
        if (isEmpty()) {
            System.out.println(" the List is empty ..");
            return -1;
        }
        int index = 0;
        boolean found = false;
        while (index != CurrentPosition) {
            if (item == listItem[index]) {
                found = true;
                break;
            }
            index++;
        }
        if (found) {
            return index;
        }
        return -1;
    }
public static   void makeEmpty() {
        for (int i = 0; i < CurrentPosition; i++) {
            listItem[i] = 0;
        }
        CurrentPosition = 0;
    }
public static   boolean isFull() {
        return CurrentPosition == listItem.length - 1;
    }
public static   boolean isEmpty() {
        return CurrentPosition == -1;
    }
public static   int length() {
        return CurrentPosition + 1;
    }
public static   void print() {
        if (isEmpty()) {
            System.out.println("\t Empty list ...");
            return;
        }
        int index = 0;
        System.out.print("\t");
        while (index != CurrentPosition) {
            System.out.print(listItem[index]+"\t");
            index++;
        }
    }
      public static void deleteAllOccurrences(int item) {
        boolean found = false;
        for (int i = 0; i <= CurrentPosition; ) {
            if (  listItem [i] == item) {
                // Start shifting elements
                for (int j = i; j < CurrentPosition; j++) {
                      listItem [j] =   listItem [j + 1];
                }
                  listItem [CurrentPosition--] = 0;
                found = true;
            } else {
                i++;
            }
        }
        if (!found) {
            System.out.println("The element [" + item + "] is not found");
        }
    }

    // 2. إرفاق مصفوفة للقائمة الحالية
    public static void attachArray(int[] arr) {
        for (int val : arr) {
            addElement(val);
        }
    }

    // 3. دمج قائمتين
    public static void mergeList(ArrayListClass otherList) {
        for (int i = 0; i <= otherList.CurrentPosition; i++) {
            addElement(otherList.  listItem [i]);
        }
    }
    public static void ArrayListADT (){
        	int choice = 0;
        do {
            System.out.print("\n\t Unsorted List Operations :");
            System.out.print("\n**********************************************");
            System.out.print("\n\t [ 01 ] - Insert an Element To the Array List. ");
            System.out.print("\n\t [ 02 ] - Search an Element on the Array List. ");
            System.out.print("\n\t [ 03 ] - Check the Array  List Size.");
            System.out.print("\n\t [ 04 ] - Remove an Element from the Array List. ");
            System.out.print("\n\t [ 05 ] - Get the Next Element on the List");
            System.out.print("\n\t [ 06 ] - Print the all Element of the Array List");
            System.out.print("\n\t [ 07 ] - Make the Array List Empty");
           System.out.print("\n\t [ 08 ] - Enter data to remove All ");
           System.out.print("\n\t [ 9  ] - List attaching array: ");
           System.out.print("\n\t [ 10 ] - List merging with another list:");
            System.out.print("\n \t [ 11 ] - Exit. ");
            System.out.print("\n**********************************************");
            System.out.print("\n\t Press your choice ... ");
            choice = in.nextInt();
            switch (choice) {
                case 1: {
                    System.out.print("\n \t Enter data .. \t");
                    int data;
                    data = in.nextInt();
                    addElement(data);
                }
                break;
                case 2: {
                    System.out.print("\n \t Enter data to search.. \t");
                    int data;
                    data = in.nextInt();
                    int isFound = search(data);
                    if (isFound > 0) {
                        System.out.print(" \n\t item is found on " + (isFound + 1));
                    } else {
                        System.out.print("\n\t item " + data + " are not found");
                    }
                }
                break;
                case 3: {
                    System.out.print("\n\t the list Size is " + length());
                }
                break;
                case 4: {
                    System.out.print("\n \t Enter data to remove .. \t");
                    int data;
                    data = in.nextInt();
                    deleteItem(data);
                }
                break;
                case 5: {
                    System.out.print("\n \t Enter data to get next item.. \t");
                    int data;
                    data = in.nextInt();
                    int next = getNextItem(data);
                    if (next != 0) {
                        System.out.print("\n\t the next item of " + data + " is " + next);
                    } else {
                        System.out.print("\n\t no item next to the " + data + " item.");
                    }
                }
                break;
                case 6: {
                    print();
                }
                break;
                case 7: {
                    makeEmpty();
                }
                break;
                case 8: {
                          System.out.print("\n \t Enter data to remove .. \t");
                    int data;
                    data = in.nextInt();
                  deleteAllOccurrences (data);
                     print();
                }
                break;
                case 9 :
                   int[] newArray = {5, 10, 15};
                   attachArray(newArray);
                    System.out.println("List after attaching array:");
                     print();
                    break;
                case 10:
                    ArrayListClass anotherList = new ArrayListClass();
                    anotherList.addElement(500);
                    anotherList.addElement(600);

                    mergeList(anotherList);
                    System.out.println("List after merging with another list:");
                    print();
                    break ;
                case 11: System. out . println("Eixt......");
                break;
                default: {
                    System.out.print("\n\t Choice [ " + choice + "] You Entered is....");
                }
            }
        } while (choice != 11);
        }
}

//***********Stack*********
class Stack {
    private double[] stack;
    private int top;
    public static Scanner in = new Scanner(System.in);

    public Stack() {
        this(10);
    }

    public Stack(int size) {
        this.stack = new double[size];
        this.top = -1;
    }

    public void push(double item) {
        if (isFull()) {
            System.out.println("Stack Overflow !!!");
            return;
        }
        stack[++top] = item;
    }

    public double pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow !!!");
            return -1;
        }
        return stack[top--];
    }

    public double peek() {
        return (isEmpty() ? -1 : stack[top]);
    }

    @Override
    public String toString() {
        StringBuilder item = new StringBuilder();
        for (int i = top; i >= 0; i--) {
            item.append("[ ").append(stack[i]).append(" ]\n");
        }
        return item.toString();
    }

    public int getSize() {
        return top + 1;
    }

    public void deleteItem(double item) {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return;
        }
        Stack tempStack = new Stack(this.getSize());
        while (!isEmpty()) {
            if (peek() == item) {
                System.out.println("Value " + pop() + " is deleted successfully");
                break;
            }
            tempStack.push(pop());
        }
        while (!tempStack.isEmpty()) {
            push(tempStack.pop());
        }
    }

    private boolean isEmpty() {
        return top == -1;
    }

    private boolean isFull() {
        return top == (stack.length - 1);
    }

    public void transe() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return;
        }
        Stack s1 = new Stack(this.getSize());
        Stack s2 = new Stack(this.getSize());
        while (!isEmpty()) {
            s1.push(pop());
        }
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        while (!s2.isEmpty()) {
            push(s2.pop());
        }
    }

    public void StackADT() {
        int choose;
        do {
            System.out.print("****************StackADT*********\n");
            System.out.print("\n\t Choose any Number ");
            System.out.print("\n\t [1] push ");
            System.out.print("\n\t [2] pop ");
            System.out.print("\n\t [3] peek ");
            System.out.print("\n\t [4] toString");
            System.out.print("\n\t [5] getSize");
            System.out.print("\n\t [6] deleteItem");
            System.out.print("\n\t [7] transe");
            System.out.print("\n\t [8] Exit");
            System.out.print("\n*******************************\n");
            choose = in.nextInt();
            switch (choose) {
                case 1:
                    System.out.println("Enter the item:");
                    double item = in.nextDouble();
                    push(item);
                    break;
                case 2:
                    System.out.println("The pop: " + pop());
                    break;
                case 3:
                    System.out.print("The peek: " + peek());
                    break;
                case 4:
                    System.out.println("The stack:\n" + toString());
                    break;
                case 5:
                    System.out.println("The size: " + getSize());
                    break;
                case 6:
                    System.out.println("Enter the element to delete:");
                    double ele = in.nextDouble();
                    deleteItem(ele);
                    break;
                case 7:
                    System.out.print("The transe:\n");
                    transe();
                    break;
                case 8:
                    System.out.print("Exit.......\n");
                    break;
                default:
                    System.out.println("The choice is not valid.");
            }
        } while (choose != 8);
    }
}
//*************Queue**********
class Queue {
    private int front, rear;
    private Student[] data;
    public Scanner scanner = new Scanner(System.in);

    // تهيئة الطابور
    public Queue() {
        this(50); // الحجم الافتراضي
    }

    public Queue(int size) {
        front = rear = -1;
        data = new Student[size];
    }

    public boolean isFull() {
        return (rear == data.length - 1);
    }

    public boolean isEmpty() {
        return (front == rear);
    }

    public void Enqueue(Student student) {
        if (isFull()) {
            System.out.println("Queue Overflow (The queue is full)");
            return;
        }
        data[++rear] = student;
        System.out.println("Student added: " + student);
    }

    public Student Dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow (The queue is empty)");
            return null;
        }
        return data[++front];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println("Students in the queue:");
        for (int i = front + 1; i <= rear; i++) {
            System.out.println(data[i]);
        }
    }

    public Student getFront() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return null;
        }
        return data[front + 1];
    }

    public Student getRear() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return null;
        }
        return data[rear];
    }

    public void QueueADT() {
        int choice = 0;
        do {
            try {
                System.out.println("\nQueue Operations Menu:");
                System.out.println("1. Add student");
                System.out.println("2. Remove student");
                System.out.println("3. Display students");
                System.out.println("4. Show front student");
                System.out.println("5. Show rear student");
                System.out.println("6. Check if queue is full");
                System.out.println("7. Check if queue is empty");
                System.out.println("8. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // لاستهلاك الخط الجديد

                switch (choice) {
                    case 1: // إضافة طالب
                        System.out.print("Enter student details (Name, Department, Birthdate, ID): ");
                        String name = scanner.next();
                        String department = scanner.next();
                        String birthdate = scanner.next();
                        int id = scanner.nextInt();
                        Student newStudent = new Student(name, department, birthdate, id);
                        Enqueue(newStudent);
                        break;

                    case 2: // إزالة طالب
                        Student removedStudent = Dequeue();
                        if (removedStudent != null) {
                            System.out.println("Removed student: " + removedStudent);
                        }
                        break;

                    case 3: // عرض جميع الطلاب
                        display();
                        break;

                    case 4: // عرض الطالب الأمامي
                        Student frontStudent = getFront();
                        if (frontStudent != null) {
                            System.out.println("Front student: " + frontStudent);
                        }
                        break;

                    case 5: // عرض الطالب الأخير
                        Student rearStudent = getRear();
                        if (rearStudent != null) {
                            System.out.println("Rear student: " + rearStudent);
                        }
                        break;

                    case 6: // التحقق إذا كان الطابور ممتلئًا
                        if (isFull()) {
                            System.out.println("The queue is full.");
                        } else {
                            System.out.println("The queue is not full.");
                        }
                        break;

                    case 7: // التحقق إذا كان الطابور فارغًا
                        if (isEmpty()) {
                            System.out.println("The queue is empty.");
                        } else {
                            System.out.println("The queue is not empty.");
                        }
                        break;

                    case 8: // الخروج
                        System.out.println("Exiting the program.");
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // مسح المدخل غير الصحيح
            }
        } while (choice != 8);
    }
}
//*******Student**********
class Student {
    public String Name;
    public String Department;
    public String Birthdate;
    public int Id;

    public Student(String name, String department, String birthdate, int id) {
        Name = name;
        Department = department;
        Birthdate = birthdate;
        Id = id;
    }

    @Override
    public String toString() {
        return "Student [Name=" + Name + ", Department=" + Department + ", Birthdate=" + Birthdate + ", Id=" + Id + "]";
    }
}
//*******CircularQueue***********
class CircularQueue {
    private int front, rear;
    private Student[] data;
public Scanner scanner = new Scanner(System.in);
    // Constructor to initialize the circular queue with a specified size
    public CircularQueue(int size) {
        front = rear = -1;
        data = new Student[size];
    }

    public boolean isEmpty() {
        return (front == rear);
    }

    public boolean isFull() {
        return ((rear + 1) % data.length == front);
    }

    public void Enqueue(Student student) {
        if (isFull()) {
            System.out.println("Queue Overflow (The queue is full)");
            return;
        }
        rear = (rear + 1) % data.length;
        data[rear] = student;
        if (front == -1) {
            front = 0;
        }
    }

    public Student Dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow (The queue is empty)");
            return null;
        }
        front = (front + 1) % data.length;
        Student student = data[front];
        if (front == rear) {
            front = rear = -1;
        }
        return student;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println("Students in the queue:");
        int i = (front + 1) % data.length;
        while (i != (rear + 1) % data.length) {
            System.out.println(data[i]);
            i = (i + 1) % data.length;
        }
    }

    public Student getFront() {
        if (isEmpty()) {
            return null;
        }
        return data[(front + 1) % data.length];
    }

    public Student getRear() {
        if (isEmpty()) {
            return null;
        }
        return data[rear];
    }

    public void clear() {
        front = rear = -1;
        System.out.println("Queue cleared.");
    }

    public int size() {
        if (isEmpty()) {
            return 0;
        }
        return (rear - front + 1 + data.length) % data.length;
    }

    public void QueueADT() {
    
        int choice;

        do {
            System.out.println("\nCircular Queue Operations:");
            System.out.println("1. Enqueue a student");
            System.out.println("2. Dequeue a student");
            System.out.println("3. Display all students");
            System.out.println("4. View front student");
            System.out.println("5. View rear student");
            System.out.println("6. Check queue size");
            System.out.println("7. Clear the queue");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1: // Enqueue
                    if (!isFull()) {
                        System.out.print("Enter student name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter department: ");
                        String department = scanner.nextLine();
                        System.out.print("Enter birthdate (dd-mm-yyyy): ");
                        String birthdate = scanner.nextLine();
                        System.out.print("Enter student ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // Consume newline character
                        Enqueue(new Student(name, department, birthdate, id));
                    } else {
                        System.out.println("Queue is full. Cannot add more students.");
                    }
                    break;
                case 2: // Dequeue
                    Student dequeuedStudent = Dequeue();
                    if (dequeuedStudent != null) {
                        System.out.println("Dequeued student: " + dequeuedStudent);
                    }
                    break;
                case 3: // Display all students
                    display();
                    break;
                case 4: // View front student
                    Student frontStudent = getFront();
                    if (frontStudent != null) {
                        System.out.println("Front student: " + frontStudent);
                    } else {
                        System.out.println("Queue is empty.");
                    }
                    break;
                case 5: // View rear student
                    Student rearStudent = getRear();
                    if (rearStudent != null) {
                        System.out.println("Rear student: " + rearStudent);
                    } else {
                        System.out.println("Queue is empty.");
                    }
                    break;
                case 6: // Check queue size
                    System.out.println("Queue size: " + size());
                    break;
                case 7: // Clear the queue
                    clear();
                    break;
                case 8: // Exit
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 8);

   
    }
}
//*********linkedlist***********
class Node1 {
    private double data;
    private Node1 next;

    Node1() {
        this.data = 0.0;
        this.next = null;
    }

    Node1(double data) {
        this.data = data;
        this.next = null;
    }

    public double getData() {
        return data;
    }

    public void setData(double data) {
        this.data = data;
    }

    public Node1 getNext() {
        return next;
    }

    public void setNext(Node1 next) {
        this.next = next;
    }
}

// تعريف كلاس العمليات على القائمة المرتبطة LinkedListOp
class LinkedListOp {
    private Node1 head;

    public LinkedListOp() {
        this.head = null;
    }

    private boolean isEmpty() {
        return head == null;
    }

    public void addFirst(Node1 node) {
        if (isEmpty()) {
            this.head = node;
            return;
        }
        node.setNext(head);
        head = node;
    }

    public void addLast(Node1 node) {
        if (isEmpty()) {
            this.head = node;
            return;
        }
        Node1 temp = this.head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(node);
    }

    public void deleteAtIndex(int index) {
        if (isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }
        if (index >= getSize() || index < 0) {
            System.out.println("The index exceeds the size of list or is invalid.");
            return;
        }
        if (index == 0) {
            Node1 temp = head;
            head = head.getNext();
            temp.setNext(null);
            return;
        }
        int i = 0;
        Node1 temp = head;
        while (i + 1 != index) {
            temp = temp.getNext();
            i++;
        }
        Node1 nodeToDelete = temp.getNext();
        temp.setNext(nodeToDelete.getNext());
        nodeToDelete.setNext(null);
    }

    public void deleteLast() {
        if (isEmpty()) {
            System.out.println("Error: Empty list.");
            return;
        }
        if (head.getNext() == null) {
            head = null;
            return;
        }
        Node1 temp = this.head;
        while (temp.getNext().getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(null);
    }

    public void deleteNode(double data) {
        if (isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }
        if (head.getData() == data) {
            Node1 temp = head;
            head = head.getNext();
            temp.setNext(null);
            return;
        }
        Node1 prev = null, curr = head;
        while (curr != null && curr.getData() != data) {
            prev = curr;
            curr = curr.getNext();
        }
        if (curr == null) {
            System.out.println("The node with data " + data + " was not found.");
            return;
        }
        prev.setNext(curr.getNext());
        curr.setNext(null);
    }

    public int getSize() {
        if (isEmpty()) {
            return 0;
        }
        int size = 0;
        Node1 temp = this.head;
        while (temp != null) {
            size++;
            temp = temp.getNext();
        }
        return size;
    }

    public String toString() {
        StringBuilder items = new StringBuilder("{ ");
        Node1 temp = this.head;
        while (temp != null) {
            items.append("[ ").append(temp.getData()).append(" ] ");
            temp = temp.getNext();
        }
        return items + "}";
    }

    public Node1 searchNode(double item) {
        Node1 temp = head;
        while (temp != null) {
            if (temp.getData() == item) {
                return temp;
            }
            temp = temp.getNext();
        }
        return null;
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }
        System.out.println("The list items are: " + toString());
    }

    public void LinkedListMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice=0;

        do {
            try {
                System.out.println("\nLinked List Operations Menu:");
                System.out.println("1. Add node at the beginning");
                System.out.println("2. Add node at the end");
                System.out.println("3. Delete node by index");
                System.out.println("4. Delete the last node");
                System.out.println("5. Delete node by value");
                System.out.println("6. Search for a node");
                System.out.println("7. Display all nodes");
                System.out.println("8. Display the size of the list");
                System.out.println("9. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter the value to add at the beginning: ");
                        double dataFirst = scanner.nextDouble();
                        addFirst(new Node1 (dataFirst));
                        System.out.println("Node added successfully.");
                        break;

                    case 2:
                        System.out.print("Enter the value to add at the end: ");
                        double dataLast = scanner.nextDouble();
                        addLast(new Node1 (dataLast));
                        System.out.println("Node added successfully.");
                        break;

                    case 3:
                        System.out.print("Enter the index to delete: ");
                        int index = scanner.nextInt();
                        deleteAtIndex(index);
                        break;

                    case 4:
                        deleteLast();
                        System.out.println("Last node deleted.");
                        break;

                    case 5:
                        System.out.print("Enter the value to delete: ");
                        double value = scanner.nextDouble();
                        deleteNode(value);
                        break;

                    case 6:
                        System.out.print("Enter the value to search for: ");
                        double searchValue = scanner.nextDouble();
                        Node1 searchNode = searchNode(searchValue);
                        if (searchNode != null) {
                            System.out.println("Node found in the list.");
                        } else {
                            System.out.println("Node not found in the list.");
                        }
                        break;

                    case 7:
                        show();
                        break;

                    case 8:
                        System.out.println("Current size of the list: " + getSize());
                        break;

                    case 9:
                        System.out.println("Exiting the program.");
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // لإزالة المدخل الخاطئ
            }
        } while (choice != 9);

       
    }
}
//*********DoublelinkedList*********

class Node<E> {
    private E data;
    private Node<E> Next;
    private Node<E> Previous;

    public Node(E data) {
        this.data = data;
        this.Next = null;
        this.Previous = null;
    }

    public void setData(E data) {
        this.data = data;
    }

    public void setPrevious(Node<E> Previous) {
        this.Previous = Previous;
    }

    public void setNext(Node<E> Next) {
        this.Next = Next;
    }

    public Node<E> getNext() {
        return this.Next;
    }

    public Node<E> getPervious() {
        return this.Previous;
    }

    public E getData() {
        return this.data;
    }
}

class DoubleLinkedListADT<E> implements ListADT<E> {
    private Node<E> Head;
    private Node<E> Tail;

    public DoubleLinkedListADT() {
        this.Head = null;
        this.Tail = null;
    }

    @Override
    public void AddFirst(Node<E> e) {
        if (isEmpty()) {
            this.Head = e;
            this.Tail = e;
            return;
        }
        e.setNext(this.Head);
        this.Head.setPrevious(e);
        this.Head = e;
    }

    @Override
    public void AddLast(Node<E> e) {
        if (isEmpty()) {
            this.Head = e;
            this.Tail = e;
            return;
        }
        this.Tail.setNext(e);
        e.setPrevious(this.Tail);
        this.Tail = e;
    }

    @Override
    public void AddBetween(Node<E> pre, Node<E> e, Node<E> next) {
        if (isEmpty()) {
            this.Head = e;
            this.Tail = e;
            return;
        }
        e.setPrevious(pre);
        e.setNext(next);
        pre.setNext(e);
        next.setPrevious(e);
    }

    @Override
    public void RemoveFirst() {
        if (isEmpty()) {
            System.out.println(" Empty List");
            return;
        }
        Node<E> temp = this.Head;
        this.Head = temp.getNext();
        if (this.Head != null) {
            this.Head.setPrevious(null);
        } else {
            this.Tail = null; // List is now empty
        }
        temp.setNext(null);
        System.out.println(" First Item removed Successfully");
    }

    @Override
    public void RemoveLast() {
        if (isEmpty()) {
            System.out.println(" Empty List");
            return;
        }
        Node<E> temp = this.Tail;
        this.Tail = temp.getPervious();
        if (this.Tail != null) {
            this.Tail.setNext(null);
        } else {
            this.Head = null; // List is now empty
        }
        temp.setPrevious(null);
        System.out.println(" Last Item removed Successfully");
    }

    @Override
    public void Remove(E data) {
        if (isEmpty()) {
            System.out.println(" Empty List");
            return;
        }
        Node<E> v = Search(data);
        if (v != null) {
            if (v == this.Head) {
                RemoveFirst();
            } else if (v == this.Tail) {
                RemoveLast();
            } else {
                v.getPervious().setNext(v.getNext());
                v.getNext().setPrevious(v.getPervious());
                v.setNext(null);
                v.setPrevious(null);
                System.out.println(" Node with Data [ " + data + " ] are removed Successfully.");
            }
            return;
        }
        System.out.println(" Data are not Exist to delete it.");
    }

    @Override
    public int Length() {
        if (isEmpty()) {
            System.out.println(" List is Empty");
            return 0;
        }
        int j = 0;
        for (Node<E> i = this.Head; i != null; i = i.getNext()) {
            j++;
        }
        return j;
    }

    @Override
    public void Print() {
        if (isEmpty()) {
            System.out.println(" List is Empty");
            return;
        }
        Node<E> t = this.Head;
        while (t != null) {
            System.out.print(t.getData().toString() + "  ");
            t = t.getNext();
        }
        System.out.println();
    }

    @Override
    public Node<E> Search(E e) {
        if (isEmpty()) {
            System.out.println("Empty List");
            return null;
        }
        Node<E> temp = this.Head;
        while (temp != null) {
            if (temp.getData().equals(e)) {
                return temp;
            }
            temp = temp.getNext();
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return (this.Head == null && this.Tail == null);
    }

    @Override
    public void Reset() {
        this.Head = null;
        this.Tail = null;
    }

    public void operatorlinkedDouble() {
        Scanner in = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("\t  Double Linked List Operations :");
            System.out.println("**********************************************");
            System.out.println(" [ 01 ] - Create Double Linked List. ");
            System.out.println(" [ 02 ] - Insert an Element To First of the Double Linked List. ");
            System.out.println(" [ 03 ] - Insert to the Last of Double Linked List. ");
            System.out.println(" [ 04 ] - Add Value After Data on the Double Linked List. ");
            System.out.println(" [ 05 ] - Search an Element on the Linked List. ");
            System.out.println(" [ 06 ] - Check the Double Linked List Size.");             
            System.out.println(" [ 07 ] - Remove the First Element on the Linked List. ");
            System.out.println(" [ 08 ] - Remove an Element from Double Linked List. ");
            System.out.println(" [ 09 ] - Remove the Last Element on the Double Linked List");
            System.out.println(" [ 10 ] - Print all Elements of the Double Linked List");
            System.out.println(" [ 11 ] - Exit. ");
            System.out.println("**********************************************");
            System.out.println("\t Press your choice ...  ");
            choice = in.nextInt();
            switch (choice) {
                case 1: {
                    Reset();
                    System.out.println(" Double Linked List Created Successfully.");
                } break;
                case 2: {
                    System.out.println(" Enter data ..");
                    E data = (E) Integer.valueOf(in.nextInt());
                    AddFirst(new Node<>(data));
                } break;
                case 3: {
                    System.out.println(" Enter data ..");
                    E data = (E) Integer.valueOf(in.nextInt());
                    AddLast(new Node<>(data));
                } break;
                case 4: {
                    System.out.println(" Enter data ..");
                    E data = (E) Integer.valueOf(in.nextInt());
                    System.out.println(" Enter data to add after..");
                    E data2 = (E) Integer.valueOf(in.nextInt());
                    Node<E> node = Search(data2);
                    if (node == null) {
                        System.out.println(" No data found by this value");
                        break;
                    }
                    AddBetween(node, new Node<>(data), node.getNext());
                } break;
                case 5: {
                    System.out.println(" Enter data to search..");
                    E data = (E) Integer.valueOf(in.nextInt());
                    Node<E> node = Search(data);
                    if (node == null) {
                        System.out.println(" No data found by this value");
                    } else {
                        System.out.println(" Data found: " + node.getData());
                    }
                } break;
                case 6: {
                    System.out.println("The size of the list is : " + Length());
                } break;
                case 7: {
                    RemoveFirst();
                } break;
                case 8: {
                    System.out.println(" Enter data to remove..");
                    E data = (E) Integer.valueOf(in.nextInt());
                    Remove(data);
                } break;
                case 9: {
                    RemoveLast();
                } break;
                case 10: {
                    Print();
                } break;
                case 11: {
                    System.out.println(" Exiting...");
                } break;
                default: {
                    System.out.println(" Invalid choice. Try again.");
                }
            }
        } while (choice != 11);
    }
}

interface ListADT<E> {
    void AddFirst(Node<E> e);

    void AddLast(Node<E> e);

    void AddBetween(Node<E> pre, Node<E> e, Node<E> next);

    void RemoveFirst();

    void RemoveLast();

    void Remove(E data);

    int Length();

    void Print();

    Node<E> Search(E e);

    boolean isEmpty();

    void Reset();
}
//************linkedStack********
class LinkedStackADT<E> implements StackADT<E> {

    private Node<E> Top;

    public LinkedStackADT() {
        this.Top = null;
    }

    @Override
    public void Push(Node<E> e) {
        if (isEmpty()) {
            this.Top = e;
            return;
        }
        e.setNext(this.Top);
        this.Top = e;
    }

    @Override
    public void Pop() {
        if (isEmpty()) {
            System.out.println("Empty Stack");
            return;
        }
        Node<E> temp = this.Top;
        this.Top = temp.getNext();
        temp.setNext(null);
        System.out.println("Item popped successfully");
    }

    @Override
    public int Length() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return 0;
        }
        int length = 0;
        for (Node<E> current = this.Top; current != null; current = current.getNext()) {
            length++;
        }
        return length;
    }

    @Override
    public void Print() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return;
        }
        Node<E> current = this.Top;
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

    @Override
    public Node<E> Search(E e) {
        if (isEmpty()) {
            System.out.println("Empty Stack");
            return null;
        }
        Node<E> current = this.Top;
        while (current != null) {
            if (current.getData().equals(e)) {
                return current;
            }
            current = current.getNext();
        }
        System.out.println("Element not found");
        return null;
    }

    @Override
    public boolean isEmpty() {
        return (this.Top == null);
    }

    @Override
    public void Reset() {
        this.Top = null;
    }

    public void linkedstackOperator() {
        Scanner in = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n\tLinked Stack Operations:");
            System.out.println("**********************************************");
            System.out.println("[1] - Push an Element");
            System.out.println("[2] - Pop an Element");
            System.out.println("[3] - Search for an Element");
            System.out.println("[4] - Print Stack");
            System.out.println("[5] - Check Stack Length");
            System.out.println("[6] - Reset Stack");
            System.out.println("[7] - Exit");
            System.out.println("**********************************************");
            System.out.print("Enter your choice: ");
            choice = in.nextInt();

            switch (choice) {
                case 1: {
                    System.out.print("Enter element to push: ");
                    E data = (E) Integer.valueOf(in.nextInt()); // Assuming integer stack
                    Push(new Node<>(data));
                    System.out.println("Element pushed successfully.");
                }
                break;

                case 2: {
                    Pop();
                }
                break;

                case 3: {
                    System.out.print("Enter element to search: ");
                    E data = (E) Integer.valueOf(in.nextInt()); // Assuming integer stack
                    Node<E> result = Search(data);
                    if (result != null) {
                        System.out.println("Element found: " + result.getData());
                    }
                }
                break;

                case 4: {
                    System.out.println("Stack elements:");
                    Print();
                }
                break;

                case 5: {
                    System.out.println("Stack length: " + Length());
                }
                break;

                case 6: {
                    Reset();
                    System.out.println("Stack reset successfully.");
                }
                break;

                case 7: {
                    System.out.println("Exiting...");
                }
                break;

                default: {
                    System.out.println("Invalid choice! Please try again.");
                }
            }
        } while (choice != 7);
    }
}

interface StackADT<E> {
    void Push(Node<E> e);

    void Pop();

    int Length();

    void Print();

    Node<E> Search(E e);

    boolean isEmpty();

    void Reset();
}

//*******GArray********
class GArray<T> {
    private int size;
    private T[] array;
    static Scanner in = new Scanner(System.in);

    @SuppressWarnings("unchecked")
    public GArray() {
        this.size = 10;
        this.array = (T[]) new Object[size];
    }

    @SuppressWarnings("unchecked")
    public GArray(int s) {
        this.size = s;
        this.array = (T[]) new Object[size];
    }

    public void insert() {
        System.out.print("\nEnter the elements of the array: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = (T) in.next();
        }
    }

    public void delete(T item) {
        boolean found = false;
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && array[i].equals(item)) {
                found = true;
                index = i;
                break;
            }
        }
        if (found) {
            for (int i = index; i < array.length - 1; i++) {
                array[i] = array[i + 1];
            }
            array[array.length - 1] = null;
        }
    }

    public void deleteAllIteration(T data) {
        for (int i = 0; i < array.length; i++) {
            delete(data);
        }
    }

    public void print() {
        for (T element : array) {
            if (element != null)
                System.out.print(element + "  ");
        }
        System.out.println();
    }

    // دالة الجمع
    public double sum() {
        double total = 0.0;
        for (T element : array) {
            if (element != null) {
                try {
                    total += Double.parseDouble(element.toString());
                } catch (NumberFormatException e) {
                    System.out.println("Non-numeric element found: " + element + ". Ignoring it.");
                }
            }
        }
        return total;
    }

    // دالة الطرح
    public double subtract() {
        double total = 0.0;
        boolean isFirst = true;
        for (T element : array) {
            if (element != null) {
                try {
                    double value = Double.parseDouble(element.toString());
                    if (isFirst) {
                        total = value; // البدء بأول عنصر عددي
                        isFirst = false;
                    } else {
                        total -= value;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Non-numeric element found: " + element + ". Ignoring it.");
                }
            }
        }
        return total;
    }

    // دالة حساب المتوسط
    public double average() {
        double total = 0.0;
        int count = 0;
        for (T element : array) {
            if (element != null) {
                try {
                    total += Double.parseDouble(element.toString());
                    count++;
                } catch (NumberFormatException e) {
                    System.out.println("Non-numeric element found: " + element + ". Ignoring it.");
                }
            }
        }
        return count == 0 ? 0.0 : total / count;
    }

    // دالة العمليات التي كانت في OneArrayADT
    public void operations() {
        int op;
        T ele;
        do {
            System.out.println("1_Insert \n2_Print\n3_Delete\n4_Delete All\n5_Sum\n6_Subtract\n7_Average\n0_Exit");
            op = in.nextInt();
            switch (op) {
                case 1:
                    insert();
                    break;
                case 2:
                    print();
                    break;
                case 3:
                    System.out.println("Enter the element to delete:");
                    ele = (T) in.next();
                    delete(ele);
                    break;
                case 4:
                    System.out.println("Enter the element to delete all:");
                    ele = (T) in.next();
                    deleteAllIteration(ele);
                    break;
                case 5:
                    System.out.println("Sum of elements: " + sum());
                    break;
                case 6:
                    System.out.println("Subtraction of elements: " + subtract());
                    break;
                case 7:
                    System.out.println("Average of elements: " + average());
                    break;
                case 0:
                    op = 0;
                    break;
                default:
                    System.out.println("Invalid operation! Try again.");
            }
        } while (op != 0);
    }
}
//*******GArrayTow********
class GArrayTow<T extends Comparable<T>> {
    private int rows;
    private int cols;
    private T[][] array;
    static Scanner in = new Scanner(System.in);

    @SuppressWarnings("unchecked")
    public GArrayTow (int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.array = (T[][]) new Comparable[rows][cols];
    }

    public void insert() {
        System.out.println("\n\tEnter the elements of the array:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("\tElement [" + (i + 1) + "][" + (j + 1) + "]: ");
                array[i][j] = (T) in.next();
            }
        }
    }

    public void delete(T item) {
        boolean found = false;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (array[i][j] != null && array[i][j].equals(item)) {
                    array[i][j] = null;
                    found = true;
                    break;
                }
            }
            if (found) break;
        }
        if (found) {
            System.out.println("\tItem deleted successfully.");
        } else {
            System.out.println("\tItem not found.");
        }
    }

    public void deleteAllOccurrences(T item) {
        boolean found = false;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (array[i][j] != null && array[i][j].equals(item)) {
                    array[i][j] = null;
                    found = true;
                }
            }
        }
        if (found) {
            System.out.println("\tAll occurrences deleted successfully.");
        } else {
            System.out.println("\tItem not found.");
        }
    }

    public void print() {
        System.out.println("\n\tArray Elements:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (array[i][j] != null) {
                    System.out.print(array[i][j] + "  ");
                } else {
                    System.out.print("null  ");
                }
            }
            System.out.println();
        }
    }

    public double sum() {
        double total = 0.0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (array[i][j] != null) {
                    try {
                        total += Double.parseDouble(array[i][j].toString());
                    } catch (NumberFormatException e) {
                        System.out.println("\tNon-numeric element found: " + array[i][j] + ". Ignoring it.");
                    }
                }
            }
        }
        return total;
    }

    public double subtract() {
        double total = 0.0;
        boolean isFirst = true;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (array[i][j] != null) {
                    try {
                        double value = Double.parseDouble(array[i][j].toString());
                        if (isFirst) {
                            total = value;
                            isFirst = false;
                        } else {
                            total -= value;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("\tNon-numeric element found: " + array[i][j] + ". Ignoring it.");
                    }
                }
            }
        }
        return total;
    }

    public double average() {
        double total = 0.0;
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (array[i][j] != null) {
                    try {
                        total += Double.parseDouble(array[i][j].toString());
                        count++;
                    } catch (NumberFormatException e) {
                        System.out.println("\tNon-numeric element found: " + array[i][j] + ". Ignoring it.");
                    }
                }
            }
        }
        return count == 0 ? 0.0 : total / count;
    }

    public T findMax() {
        T max = null;
        boolean firstElement = true;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (array[i][j] != null && (firstElement || array[i][j].compareTo(max) > 0)) {
                    max = array[i][j];
                    firstElement = false;
                }
            }
        }
        return max;
    }

    public T findMin() {
        T min = null;
        boolean firstElement = true;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (array[i][j] != null && (firstElement || array[i][j].compareTo(min) < 0)) {
                    min = array[i][j];
                    firstElement = false;
                }
            }
        }
        return min;
    }

    public void operations() {
        int choice;
        do {
            System.out.println("\n\tArray Operations:");
            System.out.println("**********************************************");
            System.out.println("\t [01] - Insert Elements.");
            System.out.println("\t [02] - Print Array.");
            System.out.println("\t [03] - Delete an Element.");
            System.out.println("\t [04] - Delete All Occurrences.");
            System.out.println("\t [05] - Sum of Numeric Elements.");
            System.out.println("\t [06] - Subtract Numeric Elements.");
            System.out.println("\t [07] - Average of Numeric Elements.");
            System.out.println("\t [08] - Find Maximum Element.");
            System.out.println("\t [09] - Find Minimum Element.");
            System.out.println("\t [10] - Exit.");
            System.out.println("**********************************************");
            System.out.print("\tPress your choice: ");
            choice = in.nextInt();

            switch (choice) {
                case 1:
                    insert();
                    break;
                case 2:
                    print();
                    break;
                case 3:
                    System.out.print("\n\tEnter the element to delete: ");
                    T element = (T) in.next();
                    delete(element);
                    break;
                case 4:
                    System.out.print("\n\tEnter the element to delete all occurrences: ");
                    element = (T) in.next();
                    deleteAllOccurrences(element);
                    break;
                case 5:
                    System.out.println("\tSum: " + sum());
                    break;
                case 6:
                    System.out.println("\tSubtraction: " + subtract());
                    break;
                case 7:
                    System.out.println("\tAverage: " + average());
                    break;
                case 8:
                    System.out.println("\tMaximum Element: " + findMax());
                    break;
                case 9:
                    System.out.println("\tMinimum Element: " + findMin());
                    break;
                case 10:
                    System.out.println("\tExiting...");
                    break;
                default:
                    System.out.println("\tInvalid choice! Try again.");
            }
        } while (choice != 10);
    }
}
//******GArrayListADT********
class GArrayListClass<T> {
    private int currentPosition;
    private T[] listItem;

    // Constructor to initialize the ArrayList with default size
    public GArrayListClass() {
        currentPosition = 0;
        listItem = (T[]) new Object[10];
    }

    // Constructor to initialize the ArrayList with a specified size
    public GArrayListClass(int size) {
        currentPosition = 0;
        listItem = (T[]) new Object[size];
    }

    public void addElement(T item) {
        if (isFull()) {
            System.out.println("List Overflow (The list is full)");
            return;
        }
        listItem[currentPosition++] = item;
    }

    public void deleteItem(T item) {
        if (isEmpty()) {
            System.out.println("List Underflow (The list is empty)");
            return;
        }
        int index = 0;
        boolean found = false;
        while (index < currentPosition) {
            if (item.equals(listItem[index])) {
                found = true;
                for (int i = index; i < currentPosition - 1; i++) {
                    listItem[i] = listItem[i + 1];
                }
                listItem[--currentPosition] = null;
                break;
            }
            index++;
        }
        if (found) {
            System.out.println("Item deleted successfully.");
        } else {
            System.out.println("Item not found in the list.");
        }
    }

    public int search(T item) {
        for (int i = 0; i < currentPosition; i++) {
            if (item.equals(listItem[i])) {
                return i;
            }
        }
        return -1;
    }

    public void deleteAllOccurrences(T item) {
        boolean found = false;
        for (int i = 0; i < currentPosition; ) {
            if (listItem[i].equals(item)) {
                for (int j = i; j < currentPosition - 1; j++) {
                    listItem[j] = listItem[j + 1];
                }
                listItem[--currentPosition] = null;
                found = true;
            } else {
                i++;
            }
        }
        if (!found) {
            System.out.println("The element [" + item + "] is not found.");
        }
    }

    @SuppressWarnings("unchecked")
    public void attachArray(T[] arr) {
        for (T val : arr) {
            addElement(val);
        }
    }

    public void mergeList(GArrayListClass<T> otherList) {
        for (int i = 0; i < otherList.currentPosition; i++) {
            addElement(otherList.listItem[i]);
        }
    }

    public void makeEmpty() {
        for (int i = 0; i < currentPosition; i++) {
            listItem[i] = null;
        }
        currentPosition = 0;
        System.out.println("List cleared.");
    }

    public boolean isFull() {
        return currentPosition == listItem.length;
    }

    public boolean isEmpty() {
        return currentPosition == 0;
    }

    public int size() {
        return currentPosition;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Empty list...");
            return;
        }
        System.out.println("Elements in the list:");
        for (int i = 0; i < currentPosition; i++) {
            System.out.print(listItem[i] + " ");
        }
        System.out.println();
    }

    public void ArrayListOperations() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nArray List Operations:");
            System.out.println("1. Add an element to the list");
            System.out.println("2. Search for an element in the list");
            System.out.println("3. Check the size of the list");
            System.out.println("4. Remove an element from the list");
            System.out.println("5. Display all elements in the list");
            System.out.println("6. Make the list empty");
            System.out.println("7. Delete all occurrences of an element");
            System.out.println("8. Attach an array to the list");
            System.out.println("9. Merge with another list");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element: ");
                    T data = (T) scanner.next();
                    addElement(data);
                    break;
                case 2:
                    System.out.print("Enter element to search: ");
                    T searchData = (T) scanner.next();
                    int index = search(searchData);
                    if (index >= 0) {
                        System.out.println("Element found at position: " + (index + 1));
                    } else {
                        System.out.println("Element not found.");
                    }
                    break;
                case 3:
                    System.out.println("The list size is: " + size());
                    break;
                case 4:
                    System.out.print("Enter element to remove: ");
                    T removeData = (T) scanner.next();
                    deleteItem(removeData);
                    break;
                case 5:
                    print();
                    break;
                case 6:
                    makeEmpty();
                    break;
                case 7:
                    System.out.print("Enter element to delete all occurrences: ");
                    T removeAllData = (T) scanner.next();
                    deleteAllOccurrences(removeAllData);
                    break;
                case 8:
                    System.out.print("Enter array size: ");
                    int n = scanner.nextInt();
                    T[] array = (T[]) new Object[n];
                    System.out.println("Enter array elements:");
                    for (int i = 0; i < n; i++) {
                        array[i] = (T) scanner.next();
                    }
                    attachArray(array);
                    break;
                case 9:
                    GArrayListClass<T> anotherList = new GArrayListClass<>();
                    anotherList.addElement((T) "Sample1");
                    anotherList.addElement((T) "Sample2");
                    mergeList(anotherList);
                    System.out.println("List after merging:");
                    print();
                    break;
                case 10:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 10);

        
    }
}
////*********GQueue**********
class GQueue<T> {
    int front, rear;
    T[] data;
    static Scanner scanner = new Scanner(System.in);

    public GQueue() {
        this(50);
    }

    @SuppressWarnings("unchecked") // إزالة تحذير التحويل عند إنشاء مصفوفة Generics
    public GQueue(int size) {
        front = rear = 0; // بدء المؤشرات من الصفر
        data = (T[]) new Object[size]; // إنشاء مصفوفة عامة
    }

    boolean isFull() {
        return (rear == data.length); // عندما يصل rear إلى حجم المصفوفة، يصبح ممتلئًا
    }

    boolean isEmpty() {
        return (front == rear); // عندما تكون front و rear متساويتين، يكون الطابور فارغًا
    }

    public void Enqueue(T item) {
        if (isFull()) {
            System.out.println("Queue Overflow (The queue is full)");
            return;
        }
        data[rear++] = item; // إضافة العنصر وزيادة rear
        System.out.println("Item added: " + item);
    }

    public T Dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow (The queue is empty)");
            return null;
        }
        return data[front++]; // إزالة العنصر وزيادة front
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println("Items in the queue:");
        for (int i = front; i < rear; i++) { // العرض من front إلى rear
            System.out.println(data[i]);
        }
    }

    public T getFront() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return null;
        }
        return data[front]; // العنصر عند المؤشر front
    }

    public T getRear() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return null;
        }
        return data[rear - 1]; // العنصر عند المؤشر rear-1
    }

    public void operations() {
        int choice;
        do {
            System.out.println("\nQueue Operations Menu:");
            System.out.println("1. Add item");
            System.out.println("2. Remove item");
            System.out.println("3. Display items");
            System.out.println("4. Show front item");
            System.out.println("5. Show rear item");
            System.out.println("6. Check if queue is full");
            System.out.println("7. Check if queue is empty");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // لاستهلاك الخط الجديد

            switch (choice) {
                case 1: // إضافة عنصر
                    System.out.print("Enter item (String, Integer, etc.): ");
                    String input = scanner.nextLine();
                    try {
                        // محاولة تحويل المدخلات إلى أعداد إذا كانت ممكنة
                        int number = Integer.parseInt(input);
                        this.Enqueue((T) Integer.valueOf(number));
                    } catch (NumberFormatException e) {
                        // إذا لم يكن العدد صحيحًا، يُفترض أنه نص
                        this.Enqueue((T) input);
                    }
                    break;

                case 2: // إزالة عنصر
                    T removedItem = this.Dequeue();
                    if (removedItem != null) {
                        System.out.println("Removed item: " + removedItem);
                    }
                    break;

                case 3: // عرض جميع العناصر
                    this.display();
                    break;

                case 4: // عرض العنصر الأمامي
                    T frontItem = this.getFront();
                    if (frontItem != null) {
                        System.out.println("Front item: " + frontItem);
                    }
                    break;

                case 5: // عرض العنصر الأخير
                    T rearItem = this.getRear();
                    if (rearItem != null) {
                        System.out.println("Rear item: " + rearItem);
                    }
                    break;

                case 6: // التحقق إذا كان الطابور ممتلئًا
                    if (this.isFull()) {
                        System.out.println("The queue is full.");
                    } else {
                        System.out.println("The queue is not full.");
                    }
                    break;

                case 7: // التحقق إذا كان الطابور فارغًا
                    if (this.isEmpty()) {
                        System.out.println("The queue is empty.");
                    } else {
                        System.out.println("The queue is not empty.");
                    }
                    break;

                case 8: // الخروج
                    System.out.println("Exiting the program.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 8);
    }
}
//*******GCircularQueue*********
class GCircularQueue<T> {
    int front, rear;
    T[] data;
    Scanner scanner = new Scanner(System.in);

    @SuppressWarnings("unchecked")
    public GCircularQueue(int size) {
        front = rear = -1;
        data = (T[]) new Object[size];
    }

    boolean isEmpty() {
        return (front == rear);
    }

    boolean isFull() {
        return ((rear + 1) % data.length == front);
    }

    public void Enqueue(T item) {
        if (isFull()) {
            System.out.println("Queue Overflow (The queue is full)");
            return;
        }
        rear = (rear + 1) % data.length;
        data[rear] = item;
        if (front == -1) {
            front = 0;
        }
    }

    public T Dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow (The queue is empty)");
            return null;
        }
        front = (front + 1) % data.length;
        T item = data[front];
        if (front == rear) {
            front = rear = -1;
        }
        return item;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println("Items in the queue:");
        int i = (front + 1) % data.length;
        while (i != (rear + 1) % data.length) {
            System.out.println(data[i]);
            i = (i + 1) % data.length;
        }
    }

    public T getFront() {
        if (isEmpty()) {
            return null;
        }
        return data[(front + 1) % data.length];
    }

    public T getRear() {
        if (isEmpty()) {
            return null;
        }
        return data[rear];
    }

    public void clear() {
        front = rear = -1;
        System.out.println("Queue cleared.");
    }

    public int size() {
        if (isEmpty()) {
            return 0;
        }
        return (rear - front + 1 + data.length) % data.length;
    }

    // دالة لإضافة عناصر مختلفة الأنواع
    public void enqueueItem() {
        System.out.println("Enter the type of data you want to enqueue:");
        System.out.println("1. Integer\n2. String\n3. Student");
        int dataType = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        switch (dataType) {
            case 1: // Integer
                System.out.print("Enter an integer: ");
                int intValue = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
                Enqueue((T) Integer.valueOf(intValue));
                break;
            case 2: // String
                System.out.print("Enter a string: ");
                String stringValue = scanner.nextLine();
                Enqueue((T) stringValue);
                break;
            case 3: // Student
                System.out.print("Enter student name: ");
                String name = scanner.nextLine();
                System.out.print("Enter department: ");
                String department = scanner.nextLine();
                System.out.print("Enter birthdate (dd-mm-yyyy): ");
                String birthdate = scanner.nextLine();
                System.out.print("Enter student ID: ");
                int id = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
                Enqueue((T) new Student(name, department, birthdate, id));
                break;
            default:
                System.out.println("Invalid type.");
        }
    }

    // دالة لعرض قائمة العمليات
    public void displayOperations() {
        int choice=0;
        do {
            System.out.println("\nCircular Queue Operations:");
            System.out.println("1. Enqueue an item");
            System.out.println("2. Dequeue an item");
            System.out.println("3. Display all items");
            System.out.println("4. View front item");
            System.out.println("5. View rear item");
            System.out.println("6. Check queue size");
            System.out.println("7. Clear the queue");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                switch (choice) {
                    case 1: // Enqueue
                        enqueueItem();
                        break;
                    case 2: // Dequeue
                        T dequeuedItem = Dequeue();
                        if (dequeuedItem != null) {
                            System.out.println("Dequeued item: " + dequeuedItem);
                        }
                        break;
                    case 3: // Display all items
                        display();
                        break;
                    case 4: // View front item
                        T frontItem = getFront();
                        if (frontItem != null) {
                            System.out.println("Front item: " + frontItem);
                        } else {
                            System.out.println("Queue is empty.");
                        }
                        break;
                    case 5: // View rear item
                        T rearItem = getRear();
                        if (rearItem != null) {
                            System.out.println("Rear item: " + rearItem);
                        } else {
                            System.out.println("Queue is empty.");
                        }
                        break;
                    case 6: // Check queue size
                        System.out.println("Queue size: " + size());
                        break;
                    case 7: // Clear the queue
                        clear();
                        break;
                    case 8: // Exit
                        System.out.println("Exiting the program...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
           } catch (Exception e) {
                System.out.println("Invalid input! Please enter a valid choice.");
                scanner.nextLine(); // Clear invalid input
            //    choice = -1; // Reset choice to avoid premature exit
            break;
            }
        } while (choice != 8);
    }
}

public class Main{
    public static void main (String[] args) {
        Scanner in =new Scanner(System.in);
        int choose=0;
        do{
                   System.out.print("|***************************|\n");
    System.out.print("|[ 1 ] ArrayOneADT          |\n");
    System.out.print("|[ 2 ] ArrayTowADT          |\n");
    System.out.print("|[ 3 ] ArrayListADT         |\n");
    System.out.print("|[ 4 ] StackADT             |\n");
    System.out.print("|[ 5 ] QueueADT             |\n");
    System.out.print("|[ 6 ] CiclureQueueADT      |\n");
    System.out.print("|[ 7 ] GinericesADT         |\n");
    System.out.print("|[ 8 ] LinkedListADT        |\n");
    System.out.print("|[ 9 ] Eixt                 |\n");
    System.out.print("|***************************|\n");
    System.out.print("The Choose : ");
        choose=in.nextInt();
        switch (choose) {
            case 1 :
                  System.out.print("|*************************************|\n");
                  System.out.print("|                ArrayOneADT          |\n");
                  System.out.print("|*************************************|\n");
                  Array a = new Array();
                  a.OneArrayADT();
               
                break;
            case 2 :
                  System.out.print("|*************************************|\n");
                  System.out.print("|                ArrayTwoADT          |\n");
                  System.out.print("|*************************************|\n");
                TwoDArray obj = new TwoDArray();
                obj.TwoDArrayADT();
                break;
            case 3 :
                  System.out.print("|*************************************|\n");
                  System.out.print("|                ArrayListADT         |\n");
                  System.out.print("|*************************************|\n");
                     ArrayListClass list = new ArrayListClass();
                     list. ArrayListADT();
               
                break;
            case 4 :
                  System.out.print("|*************************************|\n");
                  System.out.print("|                StackADT             |\n");
                  System.out.print("|*************************************|\n");
                     Stack st = new Stack();
                     st.StackADT();
               
                break;
            case 5 :
                  System.out.print("|*************************************|\n");
                  System.out.print("|                QueueADT             |\n");
                  System.out.print("|*************************************|\n");
                  Queue queue = new Queue(10); 
                  queue.QueueADT(); 
                break;
            case 6 :
                  System.out.print("|*************************************|\n");
                  System.out.print("|          CircularQueueADT          |\n");
                  System.out.print("|*************************************|\n");
                  CircularQueue cq = new CircularQueue(5);
                   cq.QueueADT();
                break;
            case 7 :
                  System.out.print("|*************************************|\n");
                  System.out.print("|                GenericsADT          |\n");
                  System.out.print("|*************************************|\n");
                  int ch;
        do{ 
        System.out.println("choose any oprator ");
        System.out.print("[1]  GenericsArrayOne             \n");
      System.out.print("[2] GenericsArrayTow              \n");
      System.out.print("[3] GenericsArrayList             \n");
     System.out.print("[4] GenericsStack                 \n");
     System.out.print("[5] GenericsQueue                 \n");
    System.out.print("[6] GenericsCiculerQueue          \n");
    System.out.print("[7]EIXT                           \n");
   System.out.print("The choose : ");
                 
         ch=in.nextInt();
        switch (ch) {
            case 1 :
                  System.out.print("|*************************************|\n");
                  System.out.print("|               GArrayOneADT          |\n");
                  System.out.print("|*************************************|\n");
                  GArray<String> a1= new GArray<>();
                  a1.operations(); 
                break;
            case 2 :
                  System.out.print("|*************************************|\n");
                  System.out.print("|               GArrayTwoADT          |\n");
                  System.out.print("|*************************************|\n");
                  GArrayTow<String> array2= new GArrayTow<>(3, 3);
                  array2.operations();
                break;
            case 3 :
                  System.out.print("|*************************************|\n");
                  System.out.print("|               GArrayListADT         |\n");
                  System.out.print("|*************************************|\n");
                  GArrayListClass<String> list1 = new GArrayListClass<>(10);
                  list1.ArrayListOperations();
                break;
            case 4 :
                  System.out.print("|*************************************|\n");
                  System.out.print("|                GStackADT            |\n");
                  System.out.print("|*************************************|\n");
               
                break;
            case 5 :
                  System.out.print("|*************************************|\n");
                  System.out.print("|               GQueueADT             |\n");
                  System.out.print("|*************************************|\n");
                  GQueue<Object> queue1 = new GQueue<>(10); 
                  queue1.operations(); 
                break;
            case 6 :
                  System.out.print("|*************************************|\n");
                  System.out.print("|          GCircularQueueADT           |\n");
                  System.out.print("|*************************************|\n");
                  GCircularQueue<Object> cq1 = new GCircularQueue<>(5); 
                  cq1.displayOperations(); 
                break;
            case 7 :
                  System.out.print("|*************************************|\n");
                  System.out.print("|                   Exit              |\n");
                  System.out.print("|*************************************|\n");
               
                break;
            default:
                System.out.println("nnoooooo");
        }
        }while (ch!=7) ;
                break;
            case 8 :
                  System.out.print("|*************************************|\n");
                  System.out.print("|                LinkedADT            |\n");
                  System.out.print("|*************************************|\n");
                   int cho=0;
                do{
                     System.out.println("choose any number");
                     System.out.print("[ 1 ] linkedList          \n");
                     System.out.print("[ 2 ] DoublelinkedList    \n");
                     System.out.print("[ 3 ] linkedList          \n");
                     System.out.print("[ 4 ] Eixt                \n");
                     System.out.print("The choose : ");
                  cho=in.nextInt();
                 switch (cho) {
                      case 1:
                          LinkedListOp linkedlist= new LinkedListOp();
                          linkedlist.LinkedListMenu();
                          break;
                      case 2:
                           DoubleLinkedListADT<Integer> dList = new DoubleLinkedListADT<>();
                           dList.operatorlinkedDouble();
                              break;
                      case 3:
                          LinkedStackADT<Integer> Lstack = new LinkedStackADT<>();
                       Lstack.linkedstackOperator();
                          break;
                      case 4:System.out.println("EIXT.......");
                          break;
                       default:
                           System.out.println("errorr");
                             }
                        }while(cho!=4);
               
                break;
            case 9 :
                  System.out.print("|*************************************|\n");
                  System.out.print("|                   Exit              |\n");
                  System.out.print("|*************************************|\n");
               
                break;
            default:
                System.out.println("");
        }
        }while (choose!=9) ;
    }
}