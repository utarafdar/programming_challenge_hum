package com.hum.programming_challenge.questionnaire.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Map;

@Data
@NoArgsConstructor
@Component
@Scope("prototype")
public class Question {
    private String questionDescription;
    private Map<String, Integer> optionPointsMap;
}
