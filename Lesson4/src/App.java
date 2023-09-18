public class App {
    public static void main(String[] args) throws Exception {
        
        BinaryTree bt = new BinaryTree(5);

        System.out.println(bt.root);
        
        //System.out.println(bt.search(bt.root, 5, bt.parrent));

        bt.addValue(10);
        bt.addValue(15);
        bt.addValue(3);
        bt.addValue(4);
        bt.addValue(1);
        System.out.println(bt.root);
        System.out.println(bt.root.left);
        System.out.println(bt.root.right);
        

        //System.out.println(bt.search(bt.root, 3, bt.parrent));
        System.out.println(bt.count());
        System.out.println(bt);
    }    
}
