import javafx.scene.layout.Background;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main extends JFrame {

                // ma zawierać pytanie na górze
                // ma zawierać 2 przyciski tak i nie
    private JButton buttonYes;
    private  JButton buttonNo;
    private JLabel labelQuestion;

        public Main() {
            super("Milionerzy"); // title okna
            setSize(500, 500); // wielkosc okna
            setDefaultCloseOperation(1); // sprawia że działa exit
            setVisible(true);  // ustawaia okno jako widoczne - defaultowo - ukryte

            buttonYes = new JButton("Tak");
            buttonNo = new JButton("Nie");
            labelQuestion = new JLabel("Czy Polska Leży w Europie?", 0);
            add(labelQuestion);
            add(buttonYes);
            add(buttonNo);

            setLayout(new GridLayout(3,1));
        }


    public static void main(String[] args) {

            Main main = new Main();

            List<Question>questionList=new ArrayList<>();

        questionList.add(new Question("Czy Polska Leży w Europie?",true));
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
