package com.hum.programming_challenge.lambda_expressions;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
public class LambdaExpressionChallenge {

    public  boolean performOperation(LambdaExpression lambdaExpression, int number) {
        return lambdaExpression.check(number);
    }

    public  LambdaExpression isOdd(){
        return number -> number % 2 != 0;
    }

    public  LambdaExpression isPrime(){
        return number -> number > 1 && IntStream.range(2, number).noneMatch(index -> number % index == 0);
    }

    public  LambdaExpression isPalindrome(){
        return number -> IntStream.iterate(number, num-> num !=0, i -> i / 10)
                .map(reverseDigit -> reverseDigit % 10)
                .reduce(0, (reversedInteger, remainder) -> reversedInteger * 10 + remainder) == number;
    }

}
