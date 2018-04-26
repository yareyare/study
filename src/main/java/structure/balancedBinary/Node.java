package structure.balancedBinary;


import java.util.List;

/**
 * name: zhangyan
 * date:$[DATE]
 * 平衡二叉树
 */
public class Node {

    private Integer value;
    private Node leftNode;
    private Node rightNode;

    public Node(Integer value, Node leftNode, Node rightNode) {
        this.value = value;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }


    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public List<Node> createTree(int[] array, List<Node>list) {
        //先存上每个节点
        for (int i = 0; i < array.length; i++) {
            Node node = new Node(array[i], null, null);    //创建结点，每一个结点的左结点和右结点为null
            list.add(node); // list中存着每一个结点
        }

        // 设置左右节点 构建二叉树
        if (list.size() > 0) {
            for (int i = 0; i < array.length / 2 - 1; i++) {       // i表示的是根节点的索引，从0开始
                if (list.get(2 * i + 1) != null) {
                    // 左结点
                    list.get(i).leftNode = list.get(2 * i + 1);
                }
                if (list.get(2 * i + 2) != null) {
                    // 右结点
                    list.get(i).rightNode = list.get(2 * i + 2);
                }
            }
            // 判断最后一个根结点：因为最后一个根结点可能没有右结点，所以单独拿出来处理
            int lastIndex = array.length / 2 - 1;
            // 左结点
            list.get(lastIndex).leftNode = list.get(lastIndex * 2 + 1);
            // 右结点，如果数组的长度为奇数才有右结点
            if (array.length % 2 == 1) {
                list.get(lastIndex).rightNode = list.get(lastIndex * 2 + 2);
            }
        }
        return list;
    }

    // 先序
    // 遍历，先序遍历
    public void printRoot(Node node) {
        if (node != null) {
            System.out.print(node.value + " ");
            printRoot(node.getLeftNode());
            printRoot(node.getRightNode());
        }
    }

    // 中序
    public void printLeft(Node node) {
        if (node != null) {
            printLeft(node.getLeftNode());
            System.out.print(node.value + " ");
            printLeft(node.getRightNode());
        }
    }

    //后序
    public void printRight(Node node) {
        if (node != null) {
            printRight(node.getLeftNode());
            printRight(node.getRightNode());
            System.out.print(node.value + " ");
        }
    }
}
