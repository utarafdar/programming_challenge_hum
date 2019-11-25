package com.hum.programming_challenge.questionnaire.model;

import lombok.Data;

import java.util.List;

@Data
public class Questionnaire {
    private String questionnaireDescription;
    private List<Question> questions;
}
