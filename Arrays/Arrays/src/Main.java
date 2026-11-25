public class Main {
    public static void main(String[] args){
        Array baseArray = new Array();
        int[] array = {1, 2, 3, 4};
        baseArray.setArray(array);
        // add items
        baseArray.add(5);
        baseArray.show();
        System.out.println("");
        // copy
        Array copy = baseArray.copy();
        copy.show();
        System.out.println("");
        // delete item
        baseArray.deleteItem(1);
        baseArray.show();
        System.out.println("");
        // add new array
        int[] newArray = {6,7,8,9,10,11,12,13,999,6,7,8,9,10,11,12,13,999,6,7,8,9,10,11,12,13,999};
        baseArray.addArray(newArray);
        baseArray.show();
    }
}
class Array {
    static int incAmount = 5;
    private int[] array;
    private int size;


    public Array(){
        array = new int[5];
        size = 0;
    }
    public void setArray(int[] array){
        this.array = array;
        this.size = array.length;
    }
    public void add(int number){
        int[] temp;
        if (this.size >= (array.length * 0.8)){
             temp = new int[array.length + incAmount];
            for (int i = 0; i < this.size; i++) {
                temp[i] = this.array[i];
            }
            this.array = temp;
        }
        this.array[size] = number;
        this.size++;
    }
    public void deleteItem(int index){
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }
    public Array copy(){
        Array copyOfArray = new Array();
        copyOfArray.array = new int[this.array.length];
        for (int i = 0; i < size; i++) {
            copyOfArray.array[i] = this.array[i];
        }
        copyOfArray.size = this.size;
        return copyOfArray;
    }
    public void addArray(int[] arrayToAdd){
        for (int i = 0; i < arrayToAdd.length; i++) {
            this.add(arrayToAdd[i]);
        }
    }
    public void show(){
        for (int i = 0; i < this.size; i++) {
            System.out.print(array[i] + ", " + "");
        }
    }
}