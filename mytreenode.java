
package data;


public class mytreenode {
    Integer value;
    mytreenode left;
    mytreenode right;

    public mytreenode(int value) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public mytreenode() {
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }


    public mytreenode getLeft() {
        return left;
    }

    public void setLeft(mytreenode left) {
        this.left = left;
    }

    public mytreenode getRight() {
        return right;
    }

    public void setRight(mytreenode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "mytreenode{" + "value=" + value + ", left=" + left + ", right=" + right + '}';
    }
    
    
}
