import java.util.*;
public class Main {	
	
	static Scanner reader=new Scanner(System.in);
	public static void main(String[] args) {
	    
	    BinNode root = new BinNode(1);
        root.setLeft(new BinNode(2));
        root.setRight(new BinNode(1));
        root.getLeft().setLeft(new BinNode(4));
        root.getLeft().setRight(new BinNode(3));
        System.out.println(root);
        BinNode root2 = new BinNode(8);
        root2.setLeft(new BinNode(4));
        root2.setRight(new BinNode(10));
        root2.getLeft().setLeft(new BinNode(2));
        root2.getLeft().setRight(new BinNode(6));
        System.out.println(root2);
        //ex11a(root);
        //System.out.println(ex11b(root));
        //System.out.println(ex11c(root));
        //System.out.println(ex11d(root));
        //System.out.println(ex12(root));
        //System.out.println(ex14(root));
        //System.out.println(ex16(root));
        //System.out.println(ex17(root));
        //System.out.println(ex1(root));
        //System.out.println(ex2(root));
        //System.out.println(ex18(root,root2));
        System.out.println(ex20(root,4));

		BinNode<Range> t = new BinNode<>(new Range(1, 10));
        BinNode<Range> leftChild = new BinNode<>(new Range(1, 4));
        BinNode<Range> rightChild = new BinNode<>(new Range(5, 10));

        // חיבור בין הצמתים
        t.setLeft(leftChild);
        t.setRight(rightChild);

        // יצירת צמתים נוספים
        BinNode<Range> leftLeftChild = new BinNode<>(new Range(1, 1));
        leftChild.setLeft(leftLeftChild);

        BinNode<Range> rightLeftChild = new BinNode<>(new Range(5, 6));
        rightChild.setLeft(rightLeftChild);
        
        BinNode<Range> rightRightChild = new BinNode<>(new Range(8, 10));
        rightChild.setRight(rightRightChild);

        // קריאה לפונקציה ex6 על העץ
        System.out.println(order(t));

	}

	
	public static void ex11a(BinNode<Integer> root) 
	{
        if (root == null)
            return;
            
        boolean even = root.getValue() % 2 == 0;
        boolean leftOk = !root.hasLeft() || root.getLeft().getValue() % 2 == 0;
        boolean rightOk = !root.hasRight() || root.getRight().getValue() % 2 == 0;
        
        if (even && leftOk && rightOk)
            System.out.println(root.getValue());
            
        ex11a(root.getLeft());
        ex11a(root.getRight());
    }
    
    public static int ex11b(BinNode<Integer> root) 
	{
        if (root == null)
            return 0;
            
        boolean even = root.getValue() % 2 == 0;
        boolean leftOk = !root.hasLeft() || root.getLeft().getValue() % 2 == 0;
        boolean rightOk = !root.hasRight() || root.getRight().getValue() % 2 == 0;
        
        if (even && leftOk && rightOk)
            return ex11b(root.getLeft()) + ex11b(root.getRight()) + 1;
        else    
            return ex11b(root.getLeft()) + ex11b(root.getRight());
    }
    
    public static boolean ex11c(BinNode<Integer> root) 
	{
        if (root == null)
            return false;
            
        boolean even = root.getValue() % 2 == 0;
        boolean leftOk = !root.hasLeft() || root.getLeft().getValue() % 2 == 0;
        boolean rightOk = !root.hasRight() || root.getRight().getValue() % 2 == 0;
        
        if (even && leftOk && rightOk)
            return true;
            
        if (ex11c(root.getLeft()) || ex11c(root.getRight()))
            return true;
        else    
            return false;
    }
    
    public static boolean ex11d(BinNode<Integer> root) 
	{
        if (root == null)
            return true;
            
        boolean even = root.getValue() % 2 == 0;
        boolean leftOk = !root.hasLeft() || root.getLeft().getValue() % 2 == 0;
        boolean rightOk = !root.hasRight() || root.getRight().getValue() % 2 == 0;
        
        if (!(even && leftOk && rightOk))
            return false;
            
        if (!(ex11d(root.getLeft()) || ex11d(root.getRight())))
            return false;
        else    
            return true;
    }
    
    public static int ex12(BinNode<Integer> root) 
	{
        if (root == null)
            return 0;
        
        if (root.getValue()>=10 && root.getValue()<100)
            return ex12(root.getLeft()) + ex12(root.getRight()) + 1;
        else    
            return ex12(root.getLeft()) + ex12(root.getRight());
    }
    
    public static int ex14(BinNode<Integer> root) 
	{
        if (root == null)
            return 0;
        
        if (!(root.hasRight() || root.hasLeft()))
            return ex14(root.getLeft()) + ex14(root.getRight()) + 1;
        else    
            return ex14(root.getLeft()) + ex14(root.getRight());
    }
    
    public static boolean ex1(BinNode<Integer> root) 
	{
        if (root == null)
            return true;
        
        if (!(root.hasRight() || root.hasLeft()))
        {
            if (!(root.getValue()%2==0))
                return false;
        }
        
        return (ex1(root.getLeft()) && ex1(root.getRight()));
    }
    
    public static boolean ex2(BinNode<Integer> root) 
	{
        if (root == null)
            return true;
        
        if (root.hasRight())
        {
            if (!(root.hasLeft()))
                return false;
        }
        
        return (ex2(root.getLeft()) && ex2(root.getRight()));
    }
    
    public static int ex16(BinNode<Integer> root) 
	{
        if (root == null)
            return 0;
        
        if (root.hasRight() && root.hasLeft())
            return ex16(root.getLeft()) + ex16(root.getRight()) + root.getValue();
        else    
            return ex16(root.getLeft()) + ex16(root.getRight());
    }
    
    public static int ex17(BinNode<Integer> root) 
	{
        if (root == null)
            return 0;
        
        if (root.hasRight() && root.hasLeft())
        {
            if ((root.getRight().hasRight() || root.getRight().hasLeft()) && (root.getLeft().hasRight() || root.getLeft().hasLeft()))
                return ex17(root.getLeft()) + ex17(root.getRight()) + 1;
            else
                return ex17(root.getLeft()) + ex17(root.getRight());
        }
        else    
            return ex17(root.getLeft()) + ex17(root.getRight());
    }
    
    public static boolean ex18he(BinNode<Integer> t1,int num) 
	{  
        if (t1 == null)
            return false;
            
        if (t1.getValue()==num)
        {
            return true;
        }
        
        return (ex18he(t1.getLeft(),num) || ex18he(t1.getRight(),num));
    }
    
    public static boolean ex18(BinNode<Integer> t1,BinNode<Integer> t2) 
	{
        if (t2 == null)
            return true;
            
        if (!ex18he(t1,t2.getValue()))
        {
            return false;
        }
        
        return (ex18(t1,t2.getLeft()) && ex18(t1,t2.getRight()));
    }
    
    public static boolean ex20he(BinNode<Integer> t1,int num) 
	{  
        if (t1 == null)
            return false;
            
        if (t1.getValue()==num)
        {
            return !(ex20he(t1.getLeft(),num) || ex20he(t1.getRight(),num));
        }
        
        return (ex20he(t1.getLeft(),num) || ex20he(t1.getRight(),num));
    }
    
    public static boolean ex20(BinNode<Integer> t1,int num) 
	{
        if (num == 0)
            return true;
            
        if (!ex20he(t1,num))
        {
            return false;
        }
        
        return ex20(t1,num-1);
    }

	public static boolean order(BinNode<Range> t) 
	{
        if (t == null)
            return true;
        
        if (t.hasLeft())
            if (!(t.getValue().getLow() == t.getLeft().getValue().getLow() && t.getValue().getHigh() >= t.getLeft().getValue().getHigh()))
                return false;
                
        if (t.hasRight())
            if (!(t.getValue().getLow() <= t.getRight().getValue().getLow() && t.getValue().getHigh() == t.getRight().getValue().getHigh()))
                return false;
                
        if (t.hasRight() && t.hasLeft())
            if (!(t.getLeft().getValue().getHigh() < t.getRight().getValue().getLow()))
                return false;
        
        return order(t.getRight()) && order(t.getLeft());
    }
    
    
}
