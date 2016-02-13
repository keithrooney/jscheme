package lexical.lang;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import lexical.lang.Operator;
import lexical.lang.Token.Category;

public class OperatorTest {

    @Test
    public void testOperator() {
        Operator operator = new Operator("+");
        assertEquals("+", operator.getLexeme());
        assertEquals(Category.OPERATOR, operator.getCategory());
    }
    
}
