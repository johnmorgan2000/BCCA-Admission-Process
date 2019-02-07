public class Question {

    private String question;
    private String answer;

    Question(String question, String answer){
        this.question = question;
        this.answer = answer;
    }

    public String toString(){
        return String.format("Question:\n%s\n\nAnswer:\n%s\n", question, answer);
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    
}
