package com.hum.programming_challenge.lamda_expressions;

import jdk.jfr.StackTrace;

import java.util.stream.IntStream;

interface LambdaExpression {
    boolean check(int number);
}

public class LambdaExpressionChallenge {

    public static boolean performOperation(LambdaExpression lambdaExpression, int number) {
        return lambdaExpression.check(number);
    }

    public static LambdaExpression isOdd(){
        return number -> number % 2 != 0;
    }

    public static LambdaExpression isPrime(){
        return number -> number > 1 && IntStream.range(2, number).noneMatch(index -> number % index == 0);
    }

    public static LambdaExpression isPalindrome(){
        return number -> IntStream.iterate(number, num-> num !=0, i -> i / 10).map(reverseDigit -> reverseDigit % 10).
                reduce(0, (reversedInteger, remainder) -> reversedInteger * 10 + remainder) == number;
    }
}
