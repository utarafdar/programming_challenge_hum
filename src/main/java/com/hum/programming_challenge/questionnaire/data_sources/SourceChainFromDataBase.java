package com.hum.programming_challenge.questionnaire.data_sources;

import com.hum.programming_challenge.questionnaire.model.Questionnaire;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SourceChainFromDataBase implements QuestionnaireSourceChain {

    private QuestionnaireSourceChain nextChain;


    @Override
    public void addNextInChain(QuestionnaireSourceChain nextChain) {
        this.nextChain = nextChain;
    }

    @Override
    public List<Questionnaire> handleSourcing() {
        if (isDataBaseFound()){
            // if found, get the questionnaire data from database, return the list of questionnaires
            return new CopyOnWriteArrayList<>();
        }
        else
        {
            return nextChain.handleSourcing();
        }

    }

    private boolean isDataBaseFound(){
        //here one can check if it is possible to get the questionnaires from a data base
        // since I did not implement database for this, return false so that next in chain is executed
        return false;
    }
}
