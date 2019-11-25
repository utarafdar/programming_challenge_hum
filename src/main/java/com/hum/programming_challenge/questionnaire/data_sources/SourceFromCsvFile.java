package com.hum.programming_challenge.questionnaire.data_sources;

import com.hum.programming_challenge.questionnaire.model.Questionnaire;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class SourceFromCsvFile implements QuestionnaireSource {

    private QuestionnaireSource nextChain;
    private Path path = Paths.get( "src/main/resources", "default.csv");

    @Override
    public void addNextInChain(QuestionnaireSource nextChain) {

    }

    @Override
    public List<Questionnaire> handleSourcing() {
        return null;
    }

    protected boolean checkIfFileExists() {
        //System.out.println(path.toAbsolutePath());
        return Files.exists(path);
    }

}
