public class MySet {
    int [] arr = new int[100];
    int size;
    MySet(){
        size = 0;
    }
    void add(int a){
        for(int i = 0; i < size; i++)
            if(arr[i] == a)
                return;
        arr[size++] = a;
    }
    int size(){
        return size;
    }
    void remove(int b){
        for(int i = 0; i < size; i++)
            if(arr[i] == b) {
                for (int j = i; j < size; j++)
                    arr[j] = arr[j + 1];
                size--;
            }
    }
    boolean contains(int c){
        for(int i = 0; i < size; i++) {
            if (arr[i] == c)
                return true;
        }
        return false;
    }

    void duplicateZeros(int[] arr) {
        int zeroes = 0;
        int length = arr.length - 1;

        for (int i = 0; i <= length - zeroes; i++) {
            if (arr[i] == 0) {
                if (i == length - zeroes) {
                    arr[length] = 0;
                    length -= 1;
                    break;
                }
                zeroes++;
            }
        }
        int j = length - zeroes;

        for (int i = j; i >= 0; i--) {
            if (arr[i] == 0) {
                arr[i + zeroes] = 0;
                zeroes--;
                arr[i + zeroes] = 0;
            } else {
                arr[i + zeroes] = arr[i];
            }
        }
    }

}
