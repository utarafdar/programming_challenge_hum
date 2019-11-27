package com.hum.programming_challenge.questionnaire.model;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Map;

/*
Model class for questionnaire response
 */
@Data
@Component
@Scope("prototype")
public class QuestionnaireResponse {
    private Questionnaire questionnaire;
    private Map<String, String> response;
}
