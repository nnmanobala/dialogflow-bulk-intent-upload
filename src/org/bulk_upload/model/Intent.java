package org.bulk_upload.model;

import java.util.ArrayList;
import java.util.List;

public class Intent {
	private int intent;
	private List<String> questions = new ArrayList<String>();
	private String response;

	public int getIntent() {
		return intent;
	}

	public void setIntent(int intent) {
		this.intent = intent;
	}

	public List<String> getQuestion() {
		return questions;
	}

	public void setQuestion(List<String> question) {
		this.questions = question;
	}

	public void addQuestion(String question) {
		this.questions.add(question);
	}

	public int numberOfQuestions() {
		return questions.size();
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

}
