package com.hum.programming_challenge;


import com.hum.programming_challenge.lambda_expressions.LambdaExpression;
import com.hum.programming_challenge.lambda_expressions.LambdaExpressionChallenge;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class LambdaExpressionTests {

    @Autowired
    LambdaExpressionChallenge lambdaExpressionChallenge;

    /*
    These test cases test true and false cases for lambda expressions
    1. isOdd
    2. isPrime
    3. isPalindrome
     */

    @Test
    void testLambdaExpressionOddTrue(){
        LambdaExpression lambdaExpression;
        lambdaExpression = lambdaExpressionChallenge.isOdd();
        assertEquals(true, lambdaExpressionChallenge.performOperation(lambdaExpression, 111));

    }

    @Test
    void testLambdaExpressionOddFalse(){
        LambdaExpression lambdaExpression;
        lambdaExpression = lambdaExpressionChallenge.isOdd();
        assertEquals(false, lambdaExpressionChallenge.performOperation(lambdaExpression, 200));

    }

    @Test
    void testLambdaExpressionPrimeTrue(){
        LambdaExpression lambdaExpression;
        lambdaExpression = lambdaExpressionChallenge.isPrime();
        assertEquals(true, lambdaExpressionChallenge.performOperation(lambdaExpression, 7));

    }

    @Test
    void testLambdaExpressionPrimeFalse(){
        LambdaExpression lambdaExpression;
        lambdaExpression = lambdaExpressionChallenge.isPrime();
        assertEquals(false, lambdaExpressionChallenge.performOperation(lambdaExpression, 9));

    }

    @Test
    void testLambdaExpressionPalindromeTrue(){
        LambdaExpression lambdaExpression;
        lambdaExpression = lambdaExpressionChallenge.isPalindrome();
        assertEquals(true, lambdaExpressionChallenge.performOperation(lambdaExpression, 12344321));

    }

    @Test
    void testLambdaExpressionPalindromeFalse(){
        LambdaExpression lambdaExpression;
        lambdaExpression = lambdaExpressionChallenge.isPalindrome();
        assertEquals(false, lambdaExpressionChallenge.performOperation(lambdaExpression, 12345));

    }

}
