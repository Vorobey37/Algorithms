import java.util.ArrayList;
import java.util.List;

/**
 * Класс бинарное дерево - структура данных, представленная в 
 * виде связанных узлов между собой.
 */
public class BinaryTree {
    Node root;
    Node parrent = null;

    
    
    /** Конструктор с обязательным заполнением корня.
     * @param rootValue - обязательный параметр для создания элемента класса. 
     */
    public BinaryTree(int rootValue) {
        this.root = new Node(rootValue);
    }
    
    /** Метод для добавления элемента дерева по заданному
     *  значению элемента
     * @param value - задаваемое значение добавляемого элемента.
     */
    public void addValue(int value) {

        List<Node> result = search(root, value, parrent);

        if (result.get(0) == null) {

            Node newNode = new Node(value);

            if (value > result.get(1).value) {
                result.get(1).right = newNode;
            }
            if (value < result.get(1).value) {
                result.get(1).left = newNode;
            }
        } else {
            System.out.println("Ой, всё! Хорош!");
        }
    }
    

    /** Метод для поиска элемента по задаваемому значению, который 
     *  возвращает список из найденного(или ненайденного) элемента  
     *  и ближайшего к значению элемента-родителя.
     * @param node - задаваемый элемент
     * @param value - значение для поиска элемента
     * @param parrent - родитель задаваемого элемента
     * @return - список из найденного(или ненайденного) элемента и ближайшего к значению элемента-родителя
     */
    public List<Node> search (Node node, int value, Node parrent) {

        List<Node> searchResult = new ArrayList<Node>();

        if (node == null || value == node.value) {
            searchResult.add(node);
            searchResult.add(parrent);
            return searchResult;
        }
        
        if (value > node.value) {
            return search(node.right, value, node);
        } else {
            return search(node.left, value, node);
        }
    }

    /** Метод для вычисления количества элементов
     *  относительно корня данного дерева.
     * @return
     */
    public int count(){

        return countNode(root);
    }

    /** Метод для вычисления количества элементов дерева 
     * ниже заданного элемента (корня). Является частью метода count(). 
     * @param node - заданный элемент дерева, от которого начнется вычисление элементов (корень)
     * @return - вычисляемое количество элементов.
     */
    private int countNode(Node node) {
        
        if (node == null) {
            return 0;
        } else {
            return 1 + countNode(node.left) + countNode(node.right);
        }
    }

    /** К сожалению, я так и не сумел создать данный метод для удаления элемента
     * @param value
     */
    public void deleteNode(int value) {

        List<Node> result = search(root, value, parrent);

        if (result.get(0) == null) {
            System.out.println("Нечего удалять, нет такого элемента!");
        }
        
        Node currentNode;
        
        if (result.get(0).right != null) {
            currentNode = result.get(0).right;
        } else if (result.get(0).left != null) {
            currentNode = result.get(0).left;
        } else {
            // result.get(0) = null;
        }

    }

    /** Метод написания текста, содержащего список элементов дерева
     * относительно заданного элемента (корня).
     * Является частью переопределенного метода toString().
     * @param node - заданный элемент дерева, от которого начнется список элементов (корень)
     * @return - текст, содержащий список элементов дерева.
     */
    private String toStringBT(Node node) {

        if (node == null) {
            return "";
        } else if (node.left == null) {
            return node.toString() + toStringBT(node.right);
        } else if (node.right == null) {
            return node.toString() + toStringBT(node.left);
        } else if (node.left == null && node.right == null) {
            return node.toString();
        } else {
            return node.toString() + toStringBT(node.left) + toStringBT(node.right);
        }  
    }

    /**
     * Переопределенный метод для вывода всего дерева на экран.
     */
    @Override
    public String toString() {

        return toStringBT(root);
    }
}
