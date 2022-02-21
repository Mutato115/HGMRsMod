package mutato115.mods.hgmrs.json;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Questions {
	
	
	private List<Question> questions;
	
	
	public Questions(List<Question> questionList) {
		this.questions = questionList;
	}
	
	
	public List<Question> getQuestions() {
		return questions;
	}
	
	public void addQuestion(Question question) {
		this.questions.add(question);
	}
	
	public void clearQuestions() {
		this.questions.clear();
	}
	
	public Question getRandomQuestion() {
		if (!this.questions.isEmpty()) {
			Random r = new Random();
			return questions.get(r.nextInt(this.questions.size()));
		} else {
			return new Question("Who created this awesome Mod :P?", "Mutato_115");
		}
	}

	
}
