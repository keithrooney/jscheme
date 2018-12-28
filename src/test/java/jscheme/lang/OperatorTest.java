package jscheme.lang;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import jscheme.lang.Operator;
import jscheme.lang.Token.Category;

public class OperatorTest {

    @Test
    public void testOperator() {
        Operator operator = new Operator("+");
        assertEquals("+", operator.getLexeme());
        assertEquals(Category.OPERATOR, operator.getCategory());
    }
    
}
