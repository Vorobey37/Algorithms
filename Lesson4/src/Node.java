/**
 * Класс - элемент бинарного дерева
 * Содержит ссылки на правого и левого ребенка, а также свое значение.
 */
public class Node {
    int value;
    Node left;
    Node right;

    /** Конструктор для создания элемента класса.
     *  Обязательное заполнение поля со значением при создании.
     *  Создается изначально с пустыми ссылками на детей.
     * @param value
     */
    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    /**
     * Метод для вывода элемента на экран 
     */
    @Override
    public String toString() {
        String result = "Значение узла: " + value + " ";
        if (left != null) {
            result = result + "Значение левого: " + left.value + " ";   
        }
        if (right != null) {
            result = result + "Значение правого: " + right.value + " ";
        }
        return "[" + result + "]";
    }
   
}
