
package data;

////// بالاعتماد على الارري ليستت
public class Mystack<T> {
    private myarraylist<T>list=new myarraylist<>();

    public Mystack() {
    }
    
    public void puch(T ob){
        list.add(ob);
    }
    
    public T pop(){//بحدف اخر عنر وبرجع اخر عنر بعد الحدف
        T ob=list.get(list.getsize()-1);
        list.Delete(list.getsize()-1);
        return ob;
    }
    public int size(){
        return list.getsize();
    }
    public int indxof(T ob){
        return list.indxof(ob);       
    }
    
    public int srarch(T ob){//برجع موقع اخر عنحر بالنسبة للقاع يعني من الاخر ببلش 1وبكمل 
       int i=1;
       for(int j=0;j<list.getsize();j++){
          if(list.get(j)== ob)
              return i;
          i++;
       }
      return -1; 
    }
 public T peek(){//برجع اخر قيمة فقطاي الموجود بالقمة 
     return list.get(list.getsize()-1);
 } 
 
 
 
}
