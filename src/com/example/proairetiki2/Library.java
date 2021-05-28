package com.example.proairetiki2;
import com.example.proairetiki2.MyUtils;

import java.util.Scanner;

import static com.example.proairetiki2.MyUtils.*;
import static java.util.Arrays.binarySearch;


public class Library {
    public static void main(String[] args){
        Book books[] = new Book[10];
        int sort_isbn =0, sort_year=0;
        String ISBN;
        short year;
        Scanner sc = new Scanner(System.in);
        int search_type,search_method;
        Menu();
        int choice = sc.nextInt();

        while(choice !=6) {
            while (choice < 1 || choice > 6) {      //ελεγχος εγκυροτητας σε περιπτωση λαθος επιλογης του χρηστη
                Menu();
                System.out.println("Invalid Choice");
                System.out.println("Please set another choice:");
                choice = sc.nextInt();
            }
            if (choice == 1) {
                System.out.println("Set book title:");
                String title = sc.next();
                System.out.println("Set author's name:");
                String author = sc.next();
                System.out.println("Set book's ISBN:");
                ISBN = sc.next();
                int isbn_ch=1;
                while(correctISBN(ISBN) == 1 && isbn_ch==1){    //ελγχος εγκυροτητας ISBN
                    System.out.println("You set invalid ISBN");    //χρησιμοποιηται το λογικο και γιατι αν γινουν και τα 2 αληθη τοτε σταματαει η επαναληψη
                    System.out.println("1. Set new one");
                    System.out.println("2. Επιστροφη στο αρχικο μενου");
                    System.out.println("Select Choice (1-2):");
                    isbn_ch = sc.nextInt();
                    if(isbn_ch == 1){
                        System.out.println("Set new ISBN:");
                        ISBN = sc.next();
                        correctISBN(ISBN);
                    }
                    else if(isbn_ch == 2){
                        continue;
                    }
                }
                if(correctISBN(ISBN)==0 || isbn_ch!=2) {
                    System.out.println("Set publisher:");
                    String publisher = sc.next();
                    System.out.println("Set book's pages:");
                    int pages = sc.nextInt();
                    System.out.println("Set book's year published:");
                    year = sc.nextShort();
                    System.out.println("Set the price:");
                    float price = sc.nextFloat();
                    for (int i = 0; i < books.length; i++) {    //καταχωριση νεου βιβλιου
                        if (books[i] == null) {
                            books[i] = new Book(title, author, ISBN, publisher, pages, year, price);
                            break;
                        }
                    }
                }
            }
            else if (choice == 2) {      //τυπος αναζητησης
                searchMenu();           //δηλαδη ISBN η ετος κυκλοφοριας
                search_type = sc.nextInt();
                while (search_type < 1 || search_type > 3) {    //ελεγχος εγκυροτητας
                    System.out.println("You set invalid choice");
                    System.out.println("Please set a new one:");
                    search_type = sc.nextInt();
                }
                if (search_type == 1) {         //αμα ο χρηστης επελεξε αναζητηση με βαση το ISBN
                    System.out.println("Give the ISBN");
                    ISBN = sc.next();
                    while(correctISBN(ISBN) == 1){
                        System.out.println("Invalid Choice");
                        System.out.println("Please Give new ISBN:");
                        ISBN = sc.next();
                    }
                    if(sort_isbn == 0){        //αμα ο πινακας δεν εχει ταξινομηθει με βαση το ISBN
                        if (seqSearch(books,ISBN) != -1 ){  //σειριακη αναζητηση
                            System.out.println("The Book found");
                            System.out.println("Title:"+books[seqSearch(books,ISBN)].getTitle());
                            System.out.println("Author:"+books[seqSearch(books,ISBN)].getAuthor());
                            System.out.println("Pages:"+books[seqSearch(books,ISBN)].getPages());
                            System.out.println("Year Published:"+books[seqSearch(books,ISBN)].getYear_published());
                            System.out.println("Price:"+books[seqSearch(books,ISBN)].getPrice());
                        }
                        else{
                            System.out.println("The book doesn't exist");
                        }
                    }
                    else{
                        if(binSearch(books,ISBN) != -1){    //αμα ο πινακας ειναι ταξινομημενος με βαση το ISBN
                            System.out.println("The Book found");
                            System.out.println("Title:"+books[seqSearch(books,ISBN)].getTitle());
                            System.out.println("Author:"+books[seqSearch(books,ISBN)].getAuthor());
                            System.out.println("Pages:"+books[seqSearch(books,ISBN)].getPages());
                            System.out.println("Year Published:"+books[seqSearch(books,ISBN)].getYear_published());
                            System.out.println("Price:"+books[seqSearch(books,ISBN)].getPrice());
                        }
                        else{
                            System.out.println("The book doesn't exist");
                        }
                    }
                }
                else if(search_type == 2){
                    System.out.println("Give the year:");
                    year = sc.nextShort();
                    if(sort_year == 0){ //αμα ο πινακας δεν ειναι ταξινομημενος με βαση τον χρονο
                        if(seqSearch(books,year) != -1){
                            System.out.println("The Book found");
                            System.out.println("Title:"+books[seqSearch(books,year)].getTitle());
                            System.out.println("Author:"+books[seqSearch(books,year)].getAuthor());
                            System.out.println("Pages:"+books[seqSearch(books,year)].getPages());
                            System.out.println("ISBN:"+books[seqSearch(books,year)].getISBN());
                            System.out.println("Price:"+books[seqSearch(books,year)].getPrice());
                        }
                        else{
                            System.out.println("The book doesn't exist");
                        }
                    }
                    else{
                        if(binSearch(books,year) !=-1){
                            System.out.println("The Book found");
                            System.out.println("Title:"+books[seqSearch(books,year)].getTitle());
                            System.out.println("Author:"+books[seqSearch(books,year)].getAuthor());
                            System.out.println("Pages:"+books[seqSearch(books,year)].getPages());
                            System.out.println("ISBN:"+books[seqSearch(books,year)].getISBN());
                            System.out.println("Price:"+books[seqSearch(books,year)].getPrice());
                        }
                        else {
                            System.out.println("The book doesn't exist");
                        }
                    }
                }
                else{
                    continue;
                }
            }
            else if (choice == 3) {
                float x, y;
                System.out.println("Set the minimum price:");
                x = sc.nextFloat();
                System.out.println("Set the maximum price:");
                y = sc.nextFloat();
                valueSearch(books, x, y);
            }
            else if (choice ==4){
                sortFieldMenu();
                int sort_field = sc.nextInt();
                while(sort_field<1 || sort_field>5){    //ελεγχος εγκυροτητας
                    System.out.println("Invalid Choice");
                    System.out.println("Please Select another:");
                    sortFieldMenu();
                    sort_field = sc.nextInt();
                }
                if (sort_field!=5){
                    int sorting_method;
                    sortMethodMenu();
                    sorting_method = sc.nextInt();
                    while(sorting_method < 1 || sorting_method > 6){
                        System.out.println("Invalid Choice");
                        System.out.println("Please select another one");
                        sortMethodMenu();
                        sorting_method = sc.nextInt();
                    }
                    if(sorting_method ==1){
                        if (sort_field==1){
                            bubsortAuthor(books);
                        }
                        else if(sort_field == 2){
                            bubsortISBN(books);
                            sort_isbn++;
                        }
                        else if(sort_field==3){
                            bubsortYear(books);
                            sort_year++;
                        }
                        else if(sort_field == 4){
                            bubsortPrice(books);
                        }
                        /*else {
                            continue;
                        }*/
                    }
                    else if(sorting_method == 2){
                        if (sort_field == 1){
                            insertSortAuthor(books);
                        }
                        else if(sort_field == 2){
                            insertSortISBN(books);
                            sort_isbn++;
                        }
                        else if(sort_field == 3){
                            insertSortYear(books);
                            sort_year++;
                        }
                        else if(sort_field == 4){
                            insertSortPrice(books);
                        }
                    }
                    else if(sorting_method == 3){
                        if (sort_field==1){
                            selSortAuthor(books);
                        }
                        else if(sort_field==2){
                            selSortISBN(books);
                            sort_isbn++;
                        }
                        else if(sort_field == 3){
                            selSortYear(books);
                            sort_year++;
                        }
                        else if(sort_field == 4){
                            selSortPrice(books);
                        }
                    }
                    else if(sorting_method == 4){
                        if(sort_field == 1){
                            quickSortAuthor(books, 1, findLastElement(books));
                        }
                        else if(sort_field == 2){
                            quickSortISBN(books, 1, findLastElement(books));
                            sort_isbn++;
                        }
                        else if(sort_field == 3){
                            quickSortYear(books, 1, findLastElement(books));
                            sort_isbn++;
                        }
                        else if(sort_field == 4){
                            quickSortPrice(books, 1, findLastElement(books));
                        }
                    }
                    else{
                        if (sort_field == 1){
                            mergeAuthor(books);
                        }
                        else if (sort_field==2){
                            mergeISBN(books);
                            sort_isbn++;
                        }
                        else if(sort_field == 3){
                            mergeYear(books);
                            sort_year++;
                        }
                        else {
                            mergePrice(books);
                        }
                    }
                }
                
                
            }
            else if (choice == 5) {
                for(int i = 0; i<books.length; i++){
                    if(books[i] != null){
                        System.out.println(books[i]);
                        System.out.println("");
                    }
                    else{
                        break;
                    }
                }
            }

            else{
                break;
            }
            Menu();                 //αφου ο χρηστης πραγματοποιησει 1 ενεργεια του ζηταει ξανα επιλογη
            choice = sc.nextInt();  //μεχρι ο χρηστης να δωσει επιλογη 5
        }
    }

    public static void Menu(){
        System.out.println("   Choice List");
        System.out.println("1.  Add new book data");
        System.out.println("2.  Search for a book");
        System.out.println("3.  Search for book in specified values");
        System.out.println("4.  Books Classification");
        System.out.println("5.  Print all book data");
        System.out.println("6.  Quit");
        System.out.println("");
        System.out.println("  Give Choice(1-6):");
    }

    public static void searchMenu(){
        System.out.println("   Select Search Field");
        System.out.println("1.  ISBN");
        System.out.println("2.  Year Published");
        System.out.println("3.  Back to the Starting Menu ");
        System.out.println("");
        System.out.println("  Select Choice(1-3):");
    }

    /*public static void searchMethodMenu(){
        System.out.println("   Search Method Selection");
        System.out.println("1.  Serial Search");
        System.out.println("2.  Binary Search");
        System.out.println("3.  Back to Search Field Selection");
        System.out.println("");
        System.out.println("   Δώσε Επιλογή(1-3):");
    }*/

    public static void sortFieldMenu(){
        System.out.println("   Sorting Field Selection");
        System.out.println("1.  Author");
        System.out.println("2.  ISBN");
        System.out.println("3.  Year Published");
        System.out.println("4.  Price");
        System.out.println("5.  Back to Start Menu");
        System.out.println("");
        System.out.println("Select Choice(1-5)");
    }

    public static void sortMethodMenu(){
        System.out.println("   Sorting Method Selection");
        System.out.println("1.  Bubblesort");
        System.out.println("2.  Insertion Sort");
        System.out.println("3.  Selection Sort");
        System.out.println("4.  Quick Sort");
        System.out.println("5.  Merge Sort");
        System.out.println("6.  Back to Field Selection");
    }

    public static int correctISBN(String ISBN){
        //returns 0 if correct and 1 if false
        int check=1;
        Scanner scanner = new Scanner(System.in);
        if (ISBN.length() == 10){
            int[] digits=new int[10];
            for (int i = 0;i < ISBN.length(); i++){
                digits[i] = Integer.parseInt(String.valueOf(ISBN.charAt(i)));
            }
            digits[0] *= 10;
            digits[1] *= 9;
            digits[2] *= 8;
            digits[3] *= 7;
            digits[4] *= 6;
            digits[5] *= 5;
            digits[6] *= 4;
            digits[7] *= 3;
            digits[8] *= 2;
            digits[8] *= 1;
            int sum=0;
            for(int i=0; i<digits.length;i++){
                sum+=digits[i];
            }
            if (sum%11 == 0){
                check = 0;
            }
        }

        else if(ISBN.length() == 13){
            int[] digits = new int[13];
            for (int i = 0; i < ISBN.length(); i++){
                digits[i] = Integer.parseInt(String.valueOf(ISBN.charAt(i)));
            }
            digits[0] *= 1;
            for(int i=1; i<ISBN.length(); i++){
                if (i % 2 == 1){      //επειδη το πρωτο ψηφιο ειναι στην θεση 0
                    digits[i]*=3;     //απο αυτα που απομενουν τα ζυγα θα πρεπει να πολλαπλασιαζονται με 3 και τα μονα με 1
                }
                else {
                    digits[i]*=1;
                }
            }
            int sum=0;
            for (int i=0; i<digits.length; i++){
                sum+=digits[i];
            }
            if(sum%10 == 0){
                check = 0;
            }
        }
        return check;
    }

    public static int findLastElement(Book arr[]){
        int i;
        for(i=0; i<arr.length; i++){
            if(arr[i]==null){
                break;
            }
        }
        return i;
    }
}
