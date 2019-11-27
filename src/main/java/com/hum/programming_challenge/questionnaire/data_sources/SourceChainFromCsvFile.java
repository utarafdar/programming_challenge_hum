package com.hum.programming_challenge.questionnaire.data_sources;

import com.hum.programming_challenge.questionnaire.model.Questionnaire;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SourceChainFromCsvFile implements QuestionnaireSourceChain {

    private QuestionnaireSourceChain nextChain;
    //private Path path = Paths.get( "src/main/resources", "default.csv");

    @Override
    public void addNextInChain(QuestionnaireSourceChain nextChain) {
        this.nextChain = nextChain;
    }

    @Override
    public List<Questionnaire> handleSourcing() {
        if (isCsvFound()){
            // if found, get the questionnaire data from the CSV file, return the list of questionnaires
            return new CopyOnWriteArrayList<>();
        }
        else
        {
            return nextChain.handleSourcing();
        }

    }

    private boolean isCsvFound(){
        //here one can check if it is possible to get the questionnaires from a CSV file
        // since I did not implement such data sourcing, return false so that next in chain is executed
        return false;
    }


}
