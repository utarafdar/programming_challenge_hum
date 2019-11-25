package com.hum.programming_challenge.questionnaire.data_sources;

import com.hum.programming_challenge.questionnaire.model.Questionnaire;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class DefaultNoSourceFound  implements QuestionnaireSource{
    @Override
    public void addNextInChain(QuestionnaireSource nextChain) {
    }

    // return empty list when no source found
    @Override
    public List<Questionnaire> handleSourcing() {
        return new CopyOnWriteArrayList<>();
    }
}
