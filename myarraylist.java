
package data;

public class myarraylist<T> {
    private T arr[]=(T[])new Object [3];
    private int size=0;

    public myarraylist() {
    }
    
    public T get(int indx){
      if(indx >= 0 && indx<size){
          return arr[indx];
      }  
      return null;
    }
    
    public int getsize(){
        return size;
    }
    public void Deletevalue(T value){
        if(indxof(value) >= 0){
            Delete(indxof(value));
        }
    

}
    public int indxof(T value){
        for(int i =0;i<size;i++){
            if(arr[i]== value){
                return i;
            }
        } 
        return -1;
    }
    public T Delete(int indx){ 
        T t=arr[indx];
        if(indx>=0&&indx<size){
           
        for(int i=indx;i<size-1;i++){
            
            arr[i]=arr[i+1];
        }
        
        size--; 
        ensurecapacity();
        
       
    }
        return t;
    }
    public void add(T value){//عمل اضافة لرقم من اخر الارري  
         if(arr.length==size){
            ensurecapacity();
        }
        arr[size]=value;
        size++;
    }
    public String tosrting(){
        String s ="";
       for(int i=0;i<size;i++){
        s=s+arr[i]+",";
    }
       return s;
    }

    private void ensurecapacity() {
      T temp[]=(T[])new Object [arr.length*2];
      for(int i=0;i<arr.length;i++){
          temp[i]=arr[i];
      }
      arr=temp;
    }
    
    public void addfirst(T value){//الاافة من الاماام 
        addByindx(value,0);
    }
    
    public void addByindx(T value,int indx){//ضافة رقم للاري ليست باندكس عشوائي من ادخال المستخدم وعمل ازاحة للقيم وليس حذف وتكون الازاحة من الاخر 
        
       
      if(indx >=0 && indx <= size){
            if(arr.length==size){
            ensurecapacity();
        }
          for(int i=size-1;i>=indx;i--){
              arr[i+1]=arr[i];
          }
           arr[indx]=value;
            size++;
                
              }
          }
     public myarraylist rotation(int r,myarraylist a){
       for(int i=0;i<r;i++){
           Object t=a.Delete(i);
           a.add(t);
           
       }
       
       return a;
     }
     
     public myarraylist merge(myarraylist l1,myarraylist l2){
         int count1=0;
         int count2=0;
         int m=l1.size;
         int n=l2.size;
         myarraylist temp=new myarraylist();
         for(int i=0;i<m+n;i++){
             if(count1==m){
                temp.add(l2.get(count2++));
             }
             else if(count2==n) {
                 temp.add(l1.get(count1++));
             }
             else if(l1.get(count1).equals(l2.get(count2))){// comperto  ..... <0
                 temp.add(l1.get(count1++));
             }
             else{
                 temp.add(l2.get(count2++));
             }
         }
         
         return temp;
     }
     
     
     public myarraylist revers(myarraylist a ){
         
         for(int i=0;i<size;i++){
             T t= (T) a.Delete(size);
             a.addfirst(t);
         }
         return a;
     }
     
     public void removefromto(int from , int to,myarraylist a){
         for(int i =from+1;i<to;i++){
                 a.Delete(i);
             }
             
          
         System.out.println(a.tosrting()); 
     
    
     }
}
   


    