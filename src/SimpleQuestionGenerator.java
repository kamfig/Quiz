import java.util.ArrayList;
import java.util.List;

/*
* klasa ktora implementuje interfejs
* dzieki emu moze byc traktowana jako typ SimpleQuestionGenerator
* ale tez jako typ QuestionGenerator
* */

public class SimpleQuestionGenerator implements QuestionGenerator {

    @Override
    public List<Question> generateQuestions() {
        List<Question>questionList=new ArrayList<>();
        questionList.add(new Question("Czy Polska Leży w Europie?", true));
        questionList.add(new Question("Lubisz placki?", true));
        questionList.add(new Question("Dużo umiesz?", false));
        questionList.add(new Question("Masz kota?", true));
        questionList.add(new Question("Rozumiesz co Robisz?", false));
        questionList.add(new Question("Obojetne", true));
        questionList.add(new Question("Inne", true));
        return questionList;
    }
}
