package com.hum.programming_challenge.questionnaire.model;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Map;

@Data
@Component
@Scope("prototype")
public class QuestionnaireResponse {
    private Questionnaire questionnaire;
    private Map<Question, String> response;
}
