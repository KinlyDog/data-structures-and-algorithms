package part02.balancedsimpletree;

// промежуточный результат поиска
class BSTFind<T> {
    // null если в дереве вообще нету узлов
    public BSTNode<T> node;

    // true если узел найден
    public boolean nodeHasKey;

    // true, если родительскому узлу надо добавить новый левым
    public boolean toLeft;

    public BSTFind() {
        this.node = null;
    }
}
