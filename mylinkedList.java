
package data;


public class mylinkedList<T> implements Queue  {
private MyNode<T> head;
private MyNode<T> tail;
private int size=0;
   


    public  void mymethod() {
       if(head != null){
          MyNode<T> my=head,your=head.getNext(),notyour=your;   
          while (your != null && your.getNext()!= null){
              my.setNext(my.getNext().getNext());
              your.setNext(your.getNext().getNext());
              my=my.getNext();
              your=your.getNext();
          }
          my.setNext(notyour);
       }
    }
public int size(){
    return size;
}
public void addlast(T value){
    MyNode<T>newnode=new MyNode<>(value);
    if(head == null){//نفحص ادا فارغة يعني باشر ع فراغ
        head=tail=newnode;
    }
    else{
        tail.setNext(newnode);
        tail=newnode;
    }
    size++;
}   

public String tostring(){
 String s ="";
 MyNode<T>curr=head;
      while(curr != null){
          s+=curr.getValue()+" , ";
          curr=curr.getNext();
  }
   return s;
 }
  public void addfirst(T value){
        MyNode<T>newnode=new MyNode<>(value);
    if(head == null){//نفحص ادا فارغة يعني باشر ع فراغ
        head=tail=newnode;
    }
    else{
        newnode.setNext(head);
        head=newnode;
    }
    size++;
}

   public void addBYindx(T value, int indx){
       if(indx >= 0 && indx <= size ){
           if(indx==0){
               addfirst(value);
           }
           else if(indx == size){
              addlast(value); 
           }
           
           else{
            MyNode<T>newnode=new MyNode<>(value);
            MyNode<T>curr=head;
            int i=0;
            
            while(indx != i  && curr!= null){
                if(i==indx-1){
                    newnode.setNext(curr.getNext());
                    curr.setNext(newnode);
                }
                curr= curr.getNext();
                i++;
            }
           
           }
       
       size++;
   } 
   }
   public void DeleteByIndx(T value , int indx){
       if(indx >= 0 && indx<size){
           if(indx == 0)
               head=head.getNext();
           else if(indx==size-1){
               int i=0;
               MyNode<T>curr=head;
               while(indx != i){
                   if(i==indx-1){
                       tail=curr;
                       tail.setNext(null);
                   }
                   curr=curr.getNext();
                   i++;
               }
           }
           
           else{
               int i=0;
               MyNode<T>curr=head;
               while(indx != i){
                   if(i==indx-1){
                      curr.setNext(curr.getNext().getNext());
                     
                   }
                   curr=curr.getNext();//ع الي بعد الكرنت 
                   i++;
           }
       }
       size--;
   }
   }
   
   
 


   public int indxof(T value){
     MyNode<T>curr= head;
     int indx=0;
       while(curr!=null){
           if(curr.getValue()== value){
               return indx; 
           }
           else{
               curr=curr.getNext();
               indx++;
           }
}
       return -1;
   }
   
   public void DeleteValue(T value){
       if(indxof(value) == -1)return;
      DeleteByIndx( value, indxof(value));
   }
   
   public boolean  contain(T value){
       if(indxof(value)== -1){
           return false;
       }
       else{
           return true;
       }
   }
   
   public boolean isempty(){
       if(head == null){
           return true;
       }
       return false;
   }
   public MyNode<T>getnode(int i){// رح يرجع نود وهو الي باشر ع الاندكس المطلوب للسواب
       int indx =0;
       MyNode<T>curr=head;
       while(curr != null){
           if(indx==i)return curr;
           curr=curr.getNext();
           indx++;
       }
       return null;
   }
   
   public void swapbyindx(int x,int y){//indx
       
       
       
    if(x>=0&&x<size && y>=0&&y<size){   
    MyNode<T>currx=getnode(x);
    MyNode<T>curry=getnode(y);
    MyNode<T>prevx=getnode(x-1);//لازم نعرف النود للانظكس الموجود والنود الي قبله بواحد 
    MyNode<T>prevy=getnode(y-1);
    
    if(prevx != null){//  هل الاكس هواول واحد يعني الهيد
        prevx.setNext(curry);
        
    }
    else{
        head=curry;
    }
    if (prevy != null){
        prevy.setNext(currx);
    }
    else{
        head=currx;
    }
    
    MyNode<T>Temp=currx.getNext();
    currx.setNext(curry.getNext());
    curry.setNext(Temp);

    if (tail == curry){
        tail=currx;   
    }
    else if(tail == currx){
        tail=curry;
    }
   } 
   }

   public void swapbyvalue(T valuex , T valuey){

   swapbyindx(indxof(valuex), indxof(valuey));
}

   public T getvalue(int indx){
       int i=0;
       MyNode<T>curr=head;
       if(indx >=0 && indx<size){
           while(curr != null){
           if(indx==i){
               return curr.getValue();
           }
           i++;
           curr=curr.getNext();
           
 
          
       
   }
           
       } 
       return null;
   }

 /*  public void sorting(){
    for(int i=0 ;i<size;i++){
      int indx=0;
      MyNode<T>curr=head;
      while(curr != null){
          if(curr.getValue() > curr.getNext().getValue()){
          
              swapbyindx( indx ,indx+1);
              curr=curr.getNext();
              indx++;
          }
      }
      indx = 0;
      curr =head;
  }
}  */

    @Override
    public boolean add(Object value) {
     MyNode<T> newnode=new MyNode(value);
     if(head == null){
         head=tail=newnode;
         size++;
     }else{
         tail.setNext(newnode);
         tail=newnode;
         size++;
     }
     return true;
    }

    @Override
    public boolean offer(Object value) {
    
       try{
       MyNode<T> newnode=new MyNode(value);
     if(head == null){
         head=tail=newnode;
         size++;
     }else{
         tail.setNext(newnode);
         tail=newnode;
         size++;
     }
     return true;
       }
       catch(Exception e){
           return false;
       }
    }

    @Override
    public T remove() {
        if(head == null){
        throw new UnsupportedOperationException(" queue is empty"); //To change body of generated methods, choose Tools | Templates.
    }
        else{
            T ob = head.getValue();
            MyNode<T>curr=head;
            head=head.getNext();
            curr.setNext(null);
            size--;
            return ob;
        }
    
    }

    @Override
    public Object poll() {
         if(head == null){
        return null;
    }
        else{
            T ob = head.getValue();
            MyNode<T>curr=head;
            head=head.getNext();
            curr.setNext(null);
            size--;
            return ob;
        }
    }

    @Override
    public Object element() {
        if(head == null){
        throw new UnsupportedOperationException("IS EMPTY"); //To change body of generated methods, choose Tools | Templates.
    }
        else{
            return head.getValue();
        }
    }

    @Override
    public Object peek() {
       if(head == null){
           return null;
       }  
       
       else{
        return head.getValue();
    }
    }
    
    
    public void rotation(mylinkedList<T> list, int r) {
          MyNode<T> curr=head;
           MyNode<T> oldtail=tail;
           int jump=list.size-1-r;
           for(int i=jump;i>0;i--){
               curr=curr.getNext();
           }
           
           MyNode<T> returnhead=curr.getNext();
           curr.setNext(null);
           oldtail.setNext(head);
           head=returnhead;
            
           for(int i=0;i<list.size;i++){
               System.out.print(list.getvalue(i));
           }
        }
    
    public mylinkedList swapbyindx11(int indx1, int indx2,mylinkedList list){
        if(indx1>=0 && indx1<size && indx2>=0 && indx2<size){
         MyNode<T> curr1=list.getnode(indx1);
         MyNode<T> curr2=list.getnode(indx2);
         MyNode<T> prev1=list.getnode(indx1-1);
         MyNode<T> prev2=list.getnode(indx2-1);
         
         if(prev1 != null){prev1.setNext(curr2);}
         else{
                 head=curr2;
                 }
          if(prev2 != null){
              prev2.setNext(curr1);
          }
          else{
              head=curr1;
          }
          
          MyNode<T> temp = curr1;
          curr1.setNext(curr2.getNext());
          curr2.setNext(temp);
          if(tail==curr2){
              tail=curr1;
          }
          if(tail == curr1){
              tail=curr2;
          }
          
          
      
    }
        return list;
          
}
    
    public mylinkedList deletedublicat(mylinkedList a){
         MyNode<T> curr=head;
          MyNode<T> curr1=head;
       while(curr != null){
             curr1=head;
           while(curr1 != null){
               if(curr.getValue().equals(curr1.getValue())){
                   a.DeleteValue(curr.getValue());
               }
               curr1=curr1.getNext();
           }
         
           curr=curr.getNext();
           
       } 
       return a;
       
    }
    
    public  MyNode<T> merge2list( MyNode<T> l1,  MyNode<T>l2){
        if(l1==null)return l2;
        if(l2 == null) return l1;
         MyNode<T> temp= new  MyNode(0);
         MyNode<T> curr=temp;
         
         while(l1 != null && l2 !=null){
             if(l1.getValue().equals(l2.getValue())){//comperto ....<0
                 curr.setNext(l1);
                 l1=l1.getNext();
             }
             else{
                 curr.setNext(l2);
                 l2=l2.getNext();
             }
             curr=curr.getNext();
             
         }
                 
                 
          return curr;     
        
    }
    
   public T find(int n){ 
    int t=size-n+ 1;
     MyNode<T> curr=head;
     if(t<=size && t>=0 ){
    for(int i=1;i<t;i++){
      curr=curr.getNext();
    }
    
    return curr.getValue();
   }
   return null;
}
}