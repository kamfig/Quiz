import javafx.scene.layout.Background;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main extends JFrame implements ActionListener {

                // ma zawierać pytanie na górze
                // ma zawierać 2 przyciski tak i nie
    private JButton buttonYes;
    private  JButton buttonNo;
    private JLabel labelQuestion;

        // zmienna typu interfejsowego,
    //co oznacza, że musimy przekazać klasę,
    // ktora bedzie implementowala interfejs Question Generator,
    //mowimy ogólnie o typie, ale nie mowi konkretnie o klasie
    // podajemy kategorie do ktorej bedzie nalezala klasa
    private QuestionGenerator questionGenerator;
    private int currentQuestion=0;
    private int numberOfPoints = 0;

    // lista pytan
    private List<Question> questionList = new ArrayList<>();

    public void setQuestionGenerator(QuestionGenerator questionGenerator) {
        //ustawiamy zmienna z 22 linijki na ta ktora jest podana w argumencie metody
        this.questionGenerator = questionGenerator;

        /*tutaj zakladamy ze juz mamy jakis obiekt klasy
        * na etapie pisania kody nie wiemy kompletnie jaka to bedzie klasa
        * tylko wiemy ze musi omplementowac interfejs QuestionGenerator
        * wypelniamu liste pytaniami,ktore sa genetowane za pomoca metody generateQuestions
        *
        * */

        questionList = questionGenerator.generateQuestions();
    }

    public Main() {
            super("Milionerzy"); // title okna
        createDefaultComponents();
            labelQuestion = new JLabel(questionList.get(0).getContent(),0);

        buttonYes.addActionListener(this); // wskazanie dla słuchacza (obiekt main (okno)), że (this) wskazuje na niego

        buttonNo.addActionListener(this);

            add(labelQuestion);
            add(buttonYes);
            add(buttonNo);


            setLayout(new GridLayout(3,1)); // uklad okna 3 row 1 kolumn
        }

    private void createDefaultComponents() {
        setSize(500, 500); // wielkosc okna
        setDefaultCloseOperation(1); // sprawia że działa exit
        setVisible(true);  // ustawaia okno jako widoczne - defaultowo - ukryte
        setQuestionGenerator(new SimpleQuestionGenerator()); // ustawienie konkretnej klasy ktora bedzie generowala pytania
        //do gornej linijki za pomoca new NazwaKlasy mozemy podmienic nasz generator - 1 linijka.
        buttonYes = new JButton("Tak");
        buttonNo = new JButton("Nie");
    }


    public static void main(String[] args) {

//            Main main = new Main();
        //odpalenie okna w watku
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    // stworzenie nowej zmiennej typu Main = nowe okno
                    Main main = new Main();
                }
            });
//
//            List<Question>questionList=new ArrayList<>();
//
//        questionList.add(new Question("Czy Polska Leży w Europie?",true));
//        questionList.add(new Question("Lubisz placki?",true));
//        questionList.add(new Question("Dużo umiesz?",false));
//        questionList.add(new Question("Masz kota?",true));
//        questionList.add(new Question("Rozumiesz co Robisz?",false));
//        questionList.add(new Question("Obojetne",true));
//        questionList.add(new Question("Inne",true));
//
//            int numberOfPoints = 0;
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Witaj w mojej grze milionerzy \n Odpowiedz na pytania");
//
//        for (Question question:questionList) {
//            System.out.println(question.getContent());
//            String answer = scanner.next();
//                if ((answer.equals("tak")&& question.isCorrect())
//                        ||(answer.equals("nie")&& !question.isCorrect())){
//                    numberOfPoints++;
//                }
//
//        }
//        System.out.println("Zdobyłeś "+numberOfPoints+" Punktów");
    }
        // ta metoda jest wywolana gdy klikniemy na przycisk - yes, albo no
    @Override
    public void actionPerformed(ActionEvent e) {
        // kolejne pytanie musi sie miescic w liscie
        if(currentQuestion<questionList.size()){
            JButton clikedButton = (JButton) e.getSource();
            Question currentQuestion = questionList.get(this.currentQuestion);
            if(clikedButton==buttonYes&&currentQuestion.isCorrect()
                    ){
                numberOfPoints++;
            }
            if(clikedButton==buttonNo&& !currentQuestion.isCorrect()){
                numberOfPoints++;
            }
        }

        if (questionList.size() > currentQuestion + 1){
            labelQuestion.setText(questionList.get(++currentQuestion).getContent());
    }
    else
        {
            JOptionPane.showMessageDialog(this,"Koniec quizu!"+" Zdobyles " +numberOfPoints+" punktow");
            buttonNo.setEnabled(false);
            buttonYes.setEnabled(false);
        }

        System.out.println("Klik Klik Klik");// przekazanie do consoli - co by pokazac ze dziala klikacz

    }
}
