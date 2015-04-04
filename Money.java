/** Money Class
 * Created by Chandni on 4/3/15.
 */

public class Money implements Expression{
    protected int amount;
    protected String currency;

    Money (int amount, String currency){
        this.amount = amount;
        this.currency = currency;
    }

    public String toString(){
        return amount + " " + currency;
    }

    public boolean equals(Object object) {
        Money money = (Money) object;
        return amount == money.amount && currency == money.currency;
    }

    public Expression times(int multiplier){
        return new Money(amount * multiplier, currency);
    }

    String currency(){
        return currency;
    }

    static Money dollar(int amount){
        return new Money(amount, "USD");
    }

    static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }

    public Money reduce(Bank bank, String to){
        int rate =bank.rate(currency, to);
        return new Money(amount / rate, to);
    }
}

