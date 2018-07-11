import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Question>questionList=new ArrayList<>();

        questionList.add(new Question("Czy Polska Leży w Europie",true));
        questionList.add(new Question("Lubisz placki?",true));
        questionList.add(new Question("Dużo umiesz?",false));
        questionList.add(new Question("Masz kota?",true));
        questionList.add(new Question("Rozumiesz co Robisz?",false));
        questionList.add(new Question("Obojetne",true));
        questionList.add(new Question("Inne",true));

            int numberOfPoints = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Witaj w mojej grze milionerzy \n Odpowiedz na pytania");

        for (Question question:questionList) {
            System.out.println(question.getContent());
            String answer = scanner.next();
                if ((answer.equals("tak")&& question.isCorrect())
                        ||(answer.equals("nie")&& !question.isCorrect())){
                    numberOfPoints++;
                }

        }
        System.out.println("Zdobyłeś "+numberOfPoints+" Punktów");
    }
}
