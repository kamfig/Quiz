public class Question {
        // tresc pytania
    private String content;
    // czy tak - poprawne
    private boolean isCorrect;

        // konstruktor z 2 parametrami
    public Question(String content, boolean isCorrect) {
        this.content = content;
        this.isCorrect = isCorrect;
    }
    // getter otrzymuje dane
    public String getContent() {
        return content;
    }
    // seter zmienia tresc pytania - setContent
    public void setContent(String content) {
        this.content = content;
    }
    // getter dla booleana
    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    @Override
    public String toString() {
        return "Question{" +
                "content='" + content + '\'' +
                ", isCorrect=" + isCorrect +
                '}';
    }
}
