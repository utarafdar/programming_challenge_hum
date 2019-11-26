package com.hum.programming_challenge.questionnaire.data_sources;

import com.hum.programming_challenge.questionnaire.model.Questionnaire;

import java.util.List;

public class SourceChainFromCsvFile implements QuestionnaireSourceChain {

    private QuestionnaireSourceChain nextChain;
    //private Path path = Paths.get( "src/main/resources", "default.csv");

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
