
package data;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;


public class mybinarytree {

 
  mytreenode root;
  int size=0;

  
  public void inorder(){
      inorder(root);
  }
  
    private void inorder(mytreenode root) {
      if(root != null){
          inorder(root.left);
          System.out.println(root.value);
          inorder(root.right);
      } 
    }
      
  public void preorder(){
      preorder(root);
  } 
 private void preorder(mytreenode root) {
     if(root != null){
         System.out.println(root.value);
         preorder(root.left);
         preorder(root.right);
         
     }
 }     
  public void postorder(){
      postorder(root);
  } 
 private void postorder(mytreenode root) {
     if(root != null){
         postorder(root.left);
         postorder(root.right);
         System.out.println(root.value);
     }
 }
     
  public void add(int value){
      root = add(root,value);
  }
    private mytreenode add(mytreenode root, int value) {
         if(root == null){
             root=new mytreenode(value);
             return root;
         }
         if(root.getValue()>value){
             root.left=add(root.left,value);
         }
         if(root.getValue()<value){
             root.right=add(root.right,value);
         }
         return root;
    }

public int hight(mytreenode root){
    if(root==null){
        return -1;
    }
    int leftHight =hight(root.left);
    int rightHight =hight(root.right);
    
    return Math.max(leftHight,rightHight)+1;
    
}
public int depth(mytreenode root,int x){
    if(root==null){
        return -1;
    }
    int dist=-1;
    if(root.getValue()== x || (dist=depth(root.left,x))>=0||  (dist=depth(root.right,x))>=0){
        return dist+1;
    }
    return dist;
}
public void insert(int data){
    root=insert(root,data);
}

    private mytreenode insert(mytreenode root, int data) {
        if(root ==null){
            root=new mytreenode(data); 
        }
        else if(data<=root.value){
            root.left=insert(root.left,data);
        }
        else{
            root.right=insert(root.right,data);
        }
        
        return root;
    }
    
public boolean search(mytreenode root, int data){
    if(root == null){
        return false;
    }
    else if(data<root.value){
        return search(root.left,data);
    }
    else if(data>root.value){
        return search(root.right,data);
    }
    else{
        return true;
    }
    
}    
    
public void remove(int data){
    remove(root,data);
}    

    private mytreenode remove(mytreenode root, int data) {
       if(root == null){
           return null;
       }
       else if(root.value>data){
           root.left=remove(root.left,data);}
       
       else if (root.value<data){
           root.right=remove(root.right,data);
       }
       else if (root.right==null){
           return root.left;
       }
       else if (root.left==null){
           return root.right;
       }
       
       else{
     //      root.value=minimumEl(root.right).value;
           root.right=remove(root.right,root.value);
       }
       return root;
    }
    
    public int leafsnum(){
       int i= leafnum(root);
        return i;
    }

    private int leafnum(mytreenode root) {
        int count=0;
         Stack<mytreenode >s=new Stack();
         s.add(root);
        while(!s.isEmpty()){
             mytreenode temp=s.peek();
             s.pop();
             if(temp.left!=null && temp.right != null){
                 s.add(temp.left);
                 s.add(temp.right);
             }
            else if(temp.left!=null &&temp.right==null){
                 s.add(temp.left);
             }
            else if(temp.left == null && temp.right !=null){
                 s.add(temp.right);}
        
            else{
                 count++;   
                   
             }
             
     }
    
    return count;
    
    
    }  
    boolean isBST(){
     return  isBST(root);
    }
   
    boolean isBST(mytreenode root)
    {
        if(root ==null || root.right == null || root.left==null){
            return true;
        }
        else if(root.value <root.left.value || root.value>root.right.value){
            return false;
        }
       
         boolean flage1= isBST(root.right);
         boolean flage2= isBST(root.left);
        if(flage1&&flage2){
        return true;}
        else{
            return false;
        }
        
    }
    
    
    void printleftview(){
     print(root);   
    }

    private void print(mytreenode root) {
       if(root==null){
           return;
       }
      if(root.left==null&&root.right!=null){
          System.out.println(root.right.value);
      }
      if(root.left==null&&root.right==null){
          return;
      }
        System.out.println(root.value);
        print(root.left);
    }
  
    
  void printrightview(){
     printr(root);   
    }

    private void printr(mytreenode root) {
       if(root==null){
           return;  
       }
       
      print(root.right);
      if(root.right==null&&root.left!=null){
          System.out.println(root.left.value);
      }
     //   System.out.println(root.value);
    }
    
  public void printleaf(){
      printl(root);
  }  

    private void printl(mytreenode root) {
        
        if(root==null){
            return;
        }
        if(root.right==null&&root.left==null){
            System.out.println(root.value);
        }
        printl(root.left);
        printl(root.right);
    
    }
    public void dimeter(){
        dimeter(root);
    }
    public void dimeter(mytreenode root){
       mytreenode currL=root.left;
       mytreenode currR=root.right;
       int countL=1;
       int countR=1;
       while(currL != null){
           if(currL.left==null&&currL.right!=null){
               countL++;
               currL=currL.right;
           }
           else{
               countL++;
               currL=currL.left;
           }
       }
       
        while(currR != null){
           if(currR.left==null&&currR.right!=null){
               countR++;
               currR=currR.right;
           }
           else{
               countR++;
               currR=currR.left;
           }
       }
       
       
        if(countR-countL>1){
            System.out.println("not balanced");
        }   
        else{
            System.out.println("balanced");
        }
    }
    public boolean isSubtree(mybinarytree tree,mybinarytree tree2){
        return isSubtree(tree.root,tree2.root);
    }
        public  boolean isSubtree(mytreenode T,mytreenode S) {
        ArrayList<Integer>listT=new ArrayList();
        ArrayList<Integer>listS=new ArrayList();
        
        listT=fun(T);
        listS=fun(S);
        
       for(int i=0 ; i<listT.size();i++){
       
       }
        
         return true;
        }
    

       private static ArrayList<Integer> fun(mytreenode root) {
         ArrayList<Integer>list=new ArrayList();
         if(root==null){
             return null;
         }
         list.add(root.value);
         fun(root.left);
         fun(root.right);
         
       
        return list; 
    }
   public int countlraf(){
     return  countleaf(root);
   } 

    private int countleaf(mytreenode root) {
       if(root.left==null || root.right==null){
           return 1;
       }
 
       return countleaf(root.left)+countleaf(root.right);
    }
    
    
    public boolean cousin(mytreenode n1, mytreenode n2){
        
        return cousin(root,n1,n2);
    }

    private boolean cousin(mytreenode root, mytreenode n1, mytreenode n2) {
       mytreenode curr1=root;
       mytreenode curr2=root;
       if(n1.value>root.value&&n2.value>root.value||n1.value<root.value&&n2.value<root.value){
           return false;
       }   
      if(counteroflevel(curr1,n1.value,1)== counteroflevel(curr2,n2.value,1)){
          return true;   
       }  
          else{   
        return false;
    }
       
    }
    
    
    
 //   public int counteroflevel(int data){
 //   return counteroflevel(root,data,1);
  //  }
public int counteroflevel(mytreenode root,int data,int srarch){
    
    
    if(root==null){
        return 0;
    }
    if(data<root.value){
        srarch=1+counteroflevel(root.left,data,srarch);
    }
    if(data>root.value){
        srarch=1+counteroflevel(root.right,data,srarch);
    }
 
    return  srarch ;
}


public void verticalsum(){
     verticalsum(root,0); 
}

    private int verticalsum(mytreenode root,int sum) {
        if(root ==null){
            return 0;
        }
        if(root.left != null){
            sum=verticalsum(root.left,sum)+root.value;
            System.out.println(sum);
        }     
        
       // System.out.println(sum);
        else if(root.right!=null){
            sum=verticalsum(root.right,sum)+root.value;
            System.out.println(sum);
        }
       
        return sum;
    }

}
 

