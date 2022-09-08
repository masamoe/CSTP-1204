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

}
