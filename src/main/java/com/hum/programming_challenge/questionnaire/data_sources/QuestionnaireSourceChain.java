package com.hum.programming_challenge.questionnaire.data_sources;

import com.hum.programming_challenge.questionnaire.model.Questionnaire;

import java.util.List;

public interface QuestionnaireSourceChain {
    void addNextInChain(QuestionnaireSourceChain nextChain);
    List<Questionnaire> handleSourcing();

}
