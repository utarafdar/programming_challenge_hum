package com.hum.programming_challenge.questionnaire.model;

import lombok.Data;

import java.util.Map;

@Data
public class Question {
    private String questionDescription;
    private Map<String, Integer> optionPointsMap;
}
