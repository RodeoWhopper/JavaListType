public class JavaList<E> {
    private int DEFAULT_CAPACITY = 10;

    private E[] list;

    public JavaList(){
        this.list = (E[]) new Object[this.DEFAULT_CAPACITY];
    }
    public JavaList(int capacity){
        list = (E[]) new Object[capacity];
    }
    public int size(){
        int size = 0;
        for(int i = 0; i < this.list.length; i++){
            if(this.list[i] == null){
                break;
            }
            size++;
        }
        return size;
    }
    public int getCapacity(){
        return this.list.length;
    }
    public void add(E data){
        for(int i = 0; i < this.list.length; i++){
            if(this.list[i] == null){
                this.list[i] = data;
                break;
            }
            else if(i == this.list.length-1 && this.list[i] != null){
                E[] temporary_list = this.list;
                this.list = (E[]) new Object[this.list.length*2];
                for(int j = 0; j < temporary_list.length; j++){
                    this.list[j] = temporary_list[j];
                }
            }
        }
    }
    public E get(int index){
        if(index < 0 || this.list.length <= index)
            return null;
        else
            return this.list[index];
    }

    public void remove(int index){
        if(index < 0 || this.list.length <= index)
            System.out.println("Geçersiz index girildi");
        else{
            this.list[index] = null;
            while(index < this.list.length){
                if(this.list[index+1] != null){
                    this.list[index] = this.list[index+1];
                }
                else if(this.list[index+1] == null){
                    this.list[index] = null;
                    break;
                }
                index++;
            }
            System.out.println("Belirtilen indexteki değer kaldırıldı");
        }
    }
    public String set(int index,E data){
        if(index < 0 || this.list.length <= index)
            return "Geçersiz index girildi";
        else{
            this.list[index] = data;
            return "Belirtilen indexteki değer tekrar belirlendi";
        }
    }

    public void printList(){
        System.out.print("[");
        for(int i = 0; i < this.list.length; i++){
            if (this.list[i]!=null) {
                System.out.print(this.list[i]+"");
            }
            if(i+1 < this.list.length && this.list[i+1]!=null){
                System.out.print(",");
            }
        }
        System.out.println("]");
    }
    public int indexOf(E data){
        int index = 0;
        for(int i = 0; i < this.list.length; i++){
            if(this.list[i] == data){
                index = i;
                break;
            }
            else if(this.list[i] == null){
                index = -1;
                break;
            }
        }
        return index;
    }

    public int lastIndexOf(E data){
        int index = 0;
        for(int i = this.list.length-1; -2 < i; i--){
            if(this.list[i] == data){
                index = i;
                break;
            }
            else if(i == -1){
                index = -1;
                break;
            }
        }
        return index;
    }

    public boolean isEmpty(){
        boolean temporary_status = false;
        for(int i = 0; i < this.list.length; i++){
            if(this.list[i] != null){
                temporary_status = false;
                break;
            }
            else if(this.list[this.list.length-1] == null){
                temporary_status = true;
            }
        }
        return temporary_status;
    }
    public E[] toArray(){
        Object[] array = this.list;
        return (E[]) array;
    }
    public void clear(){
        E[] temporary_array = (E[]) new Object[this.list.length];
        this.list = temporary_array;
    }
    public JavaList<E> sublist(int start_index, int end_index){
        JavaList<E> output_list = new JavaList<>((end_index - start_index)+1);
        for(int i = start_index; i < end_index+1; i++){
            output_list.add(this.list[i]);
        }
        return output_list;
    }

    public boolean contains(E data){
        boolean temporary_status = false;
        for(int i = 0; i < this.list.length; i++){
            if(this.list[i] == data){
                temporary_status = true;
                break;
            }
            else if(this.list[i] == null || this.list[this.list.length-1] != null){
                temporary_status = false;
            }
        }
        return temporary_status;
    }

}
