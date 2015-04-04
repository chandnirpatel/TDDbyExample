/** Expressino Interface
 * Created by Chandni on 4/3/15.
 */

public interface Expression {
    Money reduce(Bank bank, String to);

    Expression plus(Expression addend);

    Expression times(int multiplier);
}
