package com.example.proairetiki2;

public class MyUtils {
    public static int seqSearch(Book arr[], String str) {
        int found = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {   //για να μην υπαρχει null pointer exception
                if (arr[i].getISBN().equals(str)) {
                    found = i;
                    break;
                }
            }
            else{
                break;
            }
        }
        return found;
    }

    public static int seqSearch(Book arr[],short year){
        int found = -1;
        for(int i=0; i<arr.length; i++) {
            if (arr[i] != null) {   //για να μην υπαρχει null pointer exception
                if (arr[i].getYear_published() == year) {
                    found = i;
                    break;
                }
            }
            else{
                break;
            }
        }
        return found;
    }

    public static int binSearch(Book arr[],short year){
        int len;
        for (len=0; len<arr.length; len++){
            if (arr[len] == null){
                break;
            }
        }
        int left=0, right = len-1;
        int mid,pos=-1;
        short key = year;
        if(arr[right] != null) {
            while (pos == -1 && left <= right) {
                mid = (left + right) / 2;
                if (key < arr[mid].getYear_published()) {
                    right = mid - 1;
                } else if (key > arr[mid].getYear_published()) {
                    left = mid + 1;
                } else {
                    pos = mid;
                }
            }
        }
        return pos;
    }

    public static int binSearch(Book arr[],String str){
        int len;
        for (len=0; len<arr.length; len++){
            if (arr[len] == null){
                break;
            }
        }
        int left = 0, right = len-1;
        int mid, pos = -1;
        String key = str;
        if(arr[right] != null) {
            while (pos == -1 && left <= right) {
                mid = (left + right) / 2;
                if (key.compareTo(arr[mid].getISBN()) < 0) {
                    mid = right - 1;
                } else if (key.compareTo(arr[mid].getISBN()) > 0) {
                    left = mid + 1;
                } else {
                    pos = mid;
                }
            }
        }
        return pos;
    }

    public static void valueSearch(Book arr[], float s_price, float f_price){
        for(int i=0; i< arr.length; i++){
            if(arr[i] != null) {    //για να μην υπαρχει null pointer exception
                if (arr[i].getPrice() >= s_price && arr[i].getPrice() < f_price) {
                    System.out.println("Title:" + arr[i].getTitle());
                    System.out.println("Author:" + arr[i].getAuthor());
                    System.out.println("ISBN:" + arr[i].getISBN());
                    System.out.println("Publisher:" + arr[i].getPublisher());
                    System.out.println("Pages:" + arr[i].getPages());
                    System.out.println("Year published:" + arr[i].getYear_published());
                    System.out.println("Price:" + arr[i].getPrice());
                }
            }
            else{
                break;
            }
        }
    }


    public static void bubsortAuthor(Book arr[]){
        Book temp;
        int len;
        for(len=0; len<arr.length;len++){
            if(arr[len]==null){
                break;
            }
        }
        for (int i=0; i<len; i++){
            for(int j=1; j<len-i; j++){
                if (arr[j].getAuthor().compareTo(arr[j-1].getAuthor()) < 0){
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }
    
    public static void bubsortISBN(Book arr[]){
        Book temp;
        int len;
        for( len=0; len<arr.length;len++){
            if(arr[len]==null){
                break;
            }
        }
        for (int i=0; i<len; i++){
            for (int j=1; j<len-i; j++){
                if (arr[j].getISBN().compareTo(arr[j-1].getISBN()) < 0){
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }

    public static void bubsortYear(Book arr[]){
        Book temp;
        int len;
        for(len=0; len<arr.length;len++){
            if(arr[len] == null){
                break;
            }
        }
        for (int i=0; i<len; i++){
            for (int j=1; j<len; j++){
                if (arr[j].getYear_published() < arr[j-1].getYear_published()){
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }

    public static void bubsortPrice(Book arr[]){
        Book temp;
        int len;
        for(len=0; len<arr.length; len++){
            if(arr[len]==null){
                break;
            }
        }
        for (int i=0; i<len; i++){
            for (int j=1; j<len-i; j++){
                if (arr[j].getPrice() > arr[j-1].getPrice()){
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }

    public static void insertSortAuthor(Book arr[]){
        int len;
        for (len=0; len<arr.length; len++){
            if(arr[len] == null){
                break;
            }
        }
        Book temp;
        for (int i=1; i<len; i++){
            String key = arr[i].getAuthor();
            int j = i-1;
            while((j>-1) && arr[j].getAuthor().compareTo(key)>0){
                temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
            }
        }
    }

    public static void insertSortISBN(Book arr[]){
        int len;
        for(len=0; len<arr.length; len++){
            if(arr[len]==null){
                break;
            }
        }
        Book temp;
        for (int i=1; i<len; i++){
            String key = arr[i].getISBN();
            int j = i-1;
            while((j>-1) && arr[j].getISBN().compareTo(key)>0){
                temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
            }
        }
    }

    public static void insertSortYear(Book arr[]){
        int len;
        for(len=0;len<arr.length; len++){
            if(arr[len]==null){
                break;
            }
        }
        Book temp;
        for (int i=1; i<len; i++){
            short key = arr[i].getYear_published();
            int j = i-1;
            while((j>-1) && arr[j].getYear_published() > key){
                temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
            }
        }
    }

    public static void insertSortPrice(Book arr[]){
        int len;
        for(len=0; len<arr.length; len++){
            if(arr[len]==null){
                break;
            }
        }
        Book temp;
        for (int i=1; i<len; i++){
            float key = arr[i].getPrice();
            int j = i-1;
            while((j>-1) && arr[j].getPrice() > key){
                temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
            }
        }
    }


    public static void quickSortAuthor(Book arr[], int f, int l){
        if(l-f>0){
            int pivotIndex = partitionAuthor(arr, f, l);
            quickSortAuthor(arr, f, pivotIndex-1);
            quickSortAuthor(arr,pivotIndex+1,l);
        }
    }

    public static int partitionAuthor(Book arr[], int f, int l) {
        Book temp = new Book();
        int rentValue = 0;
        int lowerLimit = f;
        int mid = (f + 1) / 2;
        temp = arr[f];
        arr[f] = arr[mid];
        arr[mid] = temp;
        String pivot = arr[f].getAuthor();
        f++;

        while (f < l) {
            while (arr[f].getAuthor().compareTo(pivot) <= 0 && f < l) {
                f++;
            }
            while (arr[l].getAuthor().compareTo(pivot) >= 0 && f <= l) {
                l--;
            }
            if (f < l) {
                temp = arr[f];
                arr[f] = arr[l];
                arr[l] = temp;
            }
            if (pivot.compareTo(arr[f].getAuthor()) >= 0){
                temp = arr[f];
                arr[f] = arr[lowerLimit];
                arr[lowerLimit] = temp;
                rentValue = f;
            }
            else{
                if(pivot.compareTo(arr[l].getAuthor())>=0){
                    temp = arr[l];
                    arr[l] = arr[lowerLimit];
                    arr[lowerLimit] = temp;
                    rentValue = l;
                }
            }
        }
        return rentValue;
    }
    
    public static void quickSortISBN(Book arr[], int f, int l){
        if(l-f>0){
            int pivotIndex = partitionISBN(arr, f, l);
            quickSortISBN(arr, f, pivotIndex-1);
            quickSortISBN(arr,pivotIndex+1,l);
        }
    }
    
    public static int partitionISBN(Book arr[] ,int f, int l){
        Book temp = new Book();
        int rentValue = 0;
        int lowerLimit = f;
        int mid = (f + 1) / 2;
        temp = arr[f];
        arr[f] = arr[mid];
        arr[mid] = temp;
        String pivot = arr[f].getISBN();
        f++;

        while (f < l) {
            while (arr[f].getISBN().compareTo(pivot) <= 0 && f < l) {
                f++;
            }
            while (arr[l].getISBN().compareTo(pivot) >= 0 && f <= l) {
                l--;
            }
            if (f < l) {
                temp = arr[f];
                arr[f] = arr[l];
                arr[l] = temp;
            }
            if (pivot.compareTo(arr[f].getISBN()) >= 0){
                temp = arr[f];
                arr[f] = arr[lowerLimit];
                arr[lowerLimit] = temp;
                rentValue = f;
            }
            else{
                if(pivot.compareTo(arr[l].getISBN())>=0){
                    temp = arr[l];
                    arr[l] = arr[lowerLimit];
                    arr[lowerLimit] = temp;
                    rentValue = l;
                }
            }
        }
        return rentValue;
    }
    
    public static void quickSortYear(Book arr[], int f, int l){
        if(l-f>0){
            int pivotIndex = partitionISBN(arr, f, l);
            quickSortAuthor(arr, f, pivotIndex-1);
            quickSortAuthor(arr,pivotIndex+1,l);
        }
    }

    public static int partitionYear(Book arr[], int f, int l){
        Book temp = new Book();
        int rentValue = 0;
        int lowerLimit = f;
        int mid = (f + 1) / 2;
        temp = arr[f];
        arr[f] = arr[mid];
        arr[mid] = temp;
        short pivot = arr[f].getYear_published();
        f++;

        while (f < l) {
            while (arr[f].getYear_published() <= pivot && f < l) {
                f++;
            }
            while (arr[l].getYear_published() >= pivot && f <= l) {
                l--;
            }
            if (f < l) {
                temp = arr[f];
                arr[f] = arr[l];
                arr[l] = temp;
            }
            if (pivot >= arr[f].getYear_published() ){
                temp = arr[f];
                arr[f] = arr[lowerLimit];
                arr[lowerLimit] = temp;
                rentValue = f;
            }
            else{
                if(pivot >= arr[l].getYear_published()){
                    temp = arr[l];
                    arr[l] = arr[lowerLimit];
                    arr[lowerLimit] = temp;
                    rentValue = l;
                }
            }
        }
        return rentValue;
    }

    public static void quickSortPrice(Book arr[], int f, int l){
        if(l-f>0){
            int pivotIndex = partitionPrice(arr, f, l);
            quickSortPrice(arr, f, pivotIndex-1);
            quickSortPrice(arr,pivotIndex+1,l);
        }
    }

    public static int partitionPrice(Book arr[], int f, int l){
        Book temp = new Book();
        int rentValue = 0;
        int lowerLimit = f;
        int mid = (f + 1) / 2;
        temp = arr[f];
        arr[f] = arr[mid];
        arr[mid] = temp;
        float pivot = arr[f].getPrice();
        f++;

        while (f < l) {
            while (arr[f].getPrice() <= pivot && f < l) {
                f++;
            }
            while (arr[l].getPrice() >= pivot && f <= l) {
                l--;
            }
            if (f < l) {
                temp = arr[f];
                arr[f] = arr[l];
                arr[l] = temp;
            }
            if (pivot >= arr[f].getPrice() ){
                temp = arr[f];
                arr[f] = arr[lowerLimit];
                arr[lowerLimit] = temp;
                rentValue = f;
            }
            else{
                if(pivot >= arr[l].getPrice()){
                    temp = arr[l];
                    arr[l] = arr[lowerLimit];
                    arr[lowerLimit] = temp;
                    rentValue = l;
                }
            }
        }
        return rentValue;
    }

    public static void selSortAuthor(Book arr[]){
        int min,len;
        for(len=0;len<arr.length;len++){
            if (arr[len] == null) {
                break;
            }
        }
        Book temp = new Book();
        for(int i=0; i<len-1; i++){
            min = i;
            for (int j=i+1; j< len; j++){
                if(arr[j].getAuthor().compareTo(arr[min].getAuthor()) < 0){
                    min = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    public static void selSortISBN(Book arr[]){
        int min,len;
        for(len=0; len<arr.length; len++){
            if (arr[len] == null) {
                break;
            }
        }
        Book temp = new Book();
        for (int i = 0; i<len-1; i++){
            min = i;
            for (int j = i+1; j< len; j++){
                if(arr[j].getISBN().compareTo(arr[min].getISBN()) < 0){
                    min = j;
                }
            }
            temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

    public static void selSortYear(Book arr[]){
        int min,len;
        for(len=0; len<arr.length; len++){
            if (arr[len] == null) {
                break;
            }
        }
        Book temp = new Book();
        for (int i = 0; i<len-1; i++){
            min = i;
            for (int j = i+1; j<len; j++){
                if(arr[j].getYear_published() < arr[min].getYear_published()){
                    min = j;
                }
            }
            temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

    public static void selSortPrice(Book arr[]){
        int min,len;
        for(len=0; len<arr.length; len++){
            if (arr[len] == null) {
                break;
            }
        }
        Book temp = new Book();
        for (int i = 0; i<len-1; i++){
            min = i;
            for (int j = i+1; j < len; j++){
                if(arr[j].getPrice() < arr[min].getPrice()){
                    min = j;
                }
            }
            temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

    public static Book[] mergeAuthor(Book[] arr){
        int len;
        for(len=0;len<arr.length;len++) {
            if (arr[len] == null)
                break;
        }
        if (len <= 1) {
            return arr;
        }

        //Split the array in half in two parts
        Book[] first = new Book[len / 2];
        Book[] second = new Book[len - first.length];
        System.arraycopy(arr, 0, first, 0, first.length);
        System.arraycopy(arr, first.length, second, 0, second.length);

        //Sort each half recursively
        mergeAuthor(first);
        mergeAuthor(second);

        //Merge both halfs together, overwriting to original array

        mergeSortAuthor(first, second, arr);
        return arr;
    }

    private static void mergeSortAuthor(Book[] first, Book[] second, Book[] result){
        int iFirst = 0;

        int iSecond = 0;

        //Index Position in merged array - starting with first position
        int iMerged = 0;

        //Compare elements at iFirst and iSecond,
        //and move smaller element at iMerged
        while (iFirst < first.length && iSecond < second.length) {
            if (first[iFirst].getAuthor().compareTo(second[iSecond].getAuthor()) < 0) {
                result[iMerged] = first[iFirst];
                iFirst++;
            } else {
                result[iMerged] = second[iSecond];
                iSecond++;
            }
            iMerged++;
        }
        //copy remaining elements from both halves - each half will have already sorted elements
        System.arraycopy(first, iFirst, result, iMerged, first.length - iFirst);
        System.arraycopy(second, iSecond, result, iMerged, second.length - iSecond);
    }

    public static Book[] mergeISBN(Book[] arr){
        int len;
        for(len=0;len<arr.length;len++) {
            if (arr[len] == null)
                break;
        }
        if (len <= 1) {
            return arr;
        }

        //Split the array in half in two parts
        Book[] first = new Book[len / 2];
        Book[] second = new Book[len - first.length];
        System.arraycopy(arr, 0, first, 0, first.length);
        System.arraycopy(arr, first.length, second, 0, second.length);

        //Sort each half recursively
        mergeISBN(first);
        mergeISBN(second);

        //Merge both halfs together, overwriting to original array

        mergeSortISBN(first, second, arr);
        return arr;
    }

    public static void mergeSortISBN(Book[] first, Book[] second, Book[] result){
        int iFirst = 0;

        int iSecond = 0;

        //Index Position in merged array - starting with first position
        int iMerged = 0;

        //Compare elements at iFirst and iSecond,
        //and move smaller element at iMerged
        while (iFirst < first.length && iSecond < second.length) {
            if (first[iFirst].getISBN().compareTo(second[iSecond].getISBN()) < 0) {
                result[iMerged] = first[iFirst];
                iFirst++;
            } else {
                result[iMerged] = second[iSecond];
                iSecond++;
            }
            iMerged++;
        }
        //copy remaining elements from both halves - each half will have already sorted elements
        System.arraycopy(first, iFirst, result, iMerged, first.length - iFirst);
        System.arraycopy(second, iSecond, result, iMerged, second.length - iSecond);
    }

    public static Book[] mergeYear(Book[] arr){
        int len;
        for(len=0;len<arr.length;len++) {
            if (arr[len] == null)
                break;
        }
        if (len <= 1) {
            return arr;
        }

        //Split the array in half in two parts
        Book[] first = new Book[len / 2];
        Book[] second = new Book[len - first.length];
        System.arraycopy(arr, 0, first, 0, first.length);
        System.arraycopy(arr, first.length, second, 0, second.length);

        //Sort each half recursively
        mergeYear(first);
        mergeYear(second);

        //Merge both halfs together, overwriting to original array

        mergeSortYear(first, second, arr);
        return arr;
    }


    public static void mergeSortYear(Book[] first, Book[] second, Book[] result){
        int iFirst = 0;

        int iSecond = 0;

        //Index Position in merged array - starting with first position
        int iMerged = 0;

        //Compare elements at iFirst and iSecond,
        //and move smaller element at iMerged
        while (iFirst < first.length && iSecond < second.length) {
            if (first[iFirst].getYear_published() < second[iSecond].getYear_published()) {
                result[iMerged] = first[iFirst];
                iFirst++;
            } else {
                result[iMerged] = second[iSecond];
                iSecond++;
            }
            iMerged++;
        }
        //copy remaining elements from both halves - each half will have already sorted elements
        System.arraycopy(first, iFirst, result, iMerged, first.length - iFirst);
        System.arraycopy(second, iSecond, result, iMerged, second.length - iSecond);
    }

    public static Book[] mergePrice(Book[] arr){
        int len;
        for(len=0;len<arr.length;len++) {
            if (arr[len] == null)
                break;
        }
        if (len <= 1) {
            return arr;
        }

        //Split the array in half in two parts
        Book[] first = new Book[len / 2];
        Book[] second = new Book[len - first.length];
        System.arraycopy(arr, 0, first, 0, first.length);
        System.arraycopy(arr, first.length, second, 0, second.length);

        //Sort each half recursively
        mergePrice(first);
        mergePrice(second);

        //Merge both halfs together, overwriting to original array

        mergeSortPrice(first, second, arr);
        return arr;
    }

    public static void mergeSortPrice(Book[] first, Book[] second, Book[] result){
        int iFirst = 0;

        int iSecond = 0;

        //Index Position in merged array - starting with first position
        int iMerged = 0;

        //Compare elements at iFirst and iSecond,
        //and move smaller element at iMerged
        while (iFirst < first.length && iSecond < second.length) {
            if (first[iFirst].getPrice() < second[iSecond].getPrice()) {
                result[iMerged] = first[iFirst];
                iFirst++;
            } else {
                result[iMerged] = second[iSecond];
                iSecond++;
            }
            iMerged++;
        }
        //copy remaining elements from both halves - each half will have already sorted elements
        System.arraycopy(first, iFirst, result, iMerged, first.length - iFirst);
        System.arraycopy(second, iSecond, result, iMerged, second.length - iSecond);
    }

    public static void sortYear(Book arr[]){  //ταξινομηση με βαση τον χρονο εκδοσης
        Book temp;                            //σε περιπτωση που ο χρηστης επιλεξει δυαδικη αναζητηση
        int len;
        for(len=0;len<arr.length;len++){
            if(arr[len] == null)
                break;
        }
        for (int i=0; i<len; i++){
            for (int j = 1; j < len - i; j++) {
                if (arr[j].getYear_published() < arr[j - 1].getYear_published()) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }

    public static void sortISBN(Book arr[]){    //ταξινομηση με βαση το ISBN
        Book temp;                              //σε περιπτωση που ο χρηστης επιλεξει δυαδικη αναζητηση
        int len;
        for(len=0;len<arr.length;len++){
            if (arr[len] == null)
                break;
        }
        for (int i=0; i<len; i++){
            for (int j = 1; j < len - i; j++) {
                if (arr[j].getISBN().compareTo(arr[j - 1].getISBN()) > 0) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }

}
