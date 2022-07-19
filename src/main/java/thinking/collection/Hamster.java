package thinking.collection;

/**
 * Hamster
 *
 * @author huanghao
 * @version 1.0
 * @date 2022/7/19 17:54
 */
public class Hamster {
    private int hamsterNumber;

    public Hamster(int hamsterNumber) {
        this.hamsterNumber = hamsterNumber;
    }

    @Override
    public String toString() {
        return "Hamster{" +
                "hamsterNumber=" + hamsterNumber +
                '}';
    }
}
