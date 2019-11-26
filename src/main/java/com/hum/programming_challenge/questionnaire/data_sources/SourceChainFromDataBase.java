package com.hum.programming_challenge.questionnaire.data_sources;

import com.hum.programming_challenge.questionnaire.model.Questionnaire;

import java.util.List;

public class SourceChainFromDataBase implements QuestionnaireSourceChain {

    private QuestionnaireSourceChain nextChain;


    @Override
    public void addNextInChain(QuestionnaireSourceChain nextChain) {
        this.nextChain = nextChain;
    }

    @Override
    public List<Questionnaire> handleSourcing() {
        return nextChain.handleSourcing();
        //return new CopyOnWriteArrayList<>();
    }
}
