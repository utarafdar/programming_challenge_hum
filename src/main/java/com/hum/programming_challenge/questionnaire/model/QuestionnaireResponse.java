package com.hum.programming_challenge.questionnaire.model;

import lombok.Data;

import java.util.Map;

@Data
public class QuestionnaireResponse {
    private Questionnaire questionnaire;
    private Map<Question, String> response;
}
