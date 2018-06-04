package structure.balancedBinary;

import java.util.ArrayList;
import java.util.List;

/**
 * name: zhangyan
 * date:$[DATE]
 */
public class Test {

    //获取数的深度
    //先序遍历
    //中序遍历
    //后序遍历

    public static void main(String[] args) {
        int array[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Node> NodeLIst = new ArrayList<Node>();
        Node Node = new Node(1,null,null);
        List<structure.balancedBinary.Node> tree = Node.createTree(array, NodeLIst);
        Node.printRoot(tree.get(0));
        System.out.println();
        Node.printLeft(tree.get(0));
        System.out.println();
        Node.printRight(tree.get(0));
    }


}
