package com.example.restdemo.restdemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class SurveyService {
	
	private static List<Survey> surveys= new ArrayList<>();
	
	static {
		Question question1 = new Question("Question1",
                "Most Popular Cloud Platform Today", "AWS", Arrays.asList(
						        "AWS", "Azure", "Google Cloud", "Oracle Cloud"));
        Question question2 = new Question("Question2",
                "Fastest Growing Cloud Platform", "Google Cloud", Arrays.asList(
						        "AWS", "Azure", "Google Cloud", "Oracle Cloud"));
        Question question3 = new Question("Question3",
                "Most Popular DevOps Tool", "Kubernetes", Arrays.asList(
						        "Kubernetes", "Docker", "Terraform", "Azure DevOps"));
 
        List<Question> questions = new ArrayList<>(Arrays.asList(question1,
                question2, question3));
 
        Survey survey = new Survey("Survey1", "My Favorite Survey",
                "Description of the Survey", questions);
 
        surveys.add(survey);
	}

	

	public List<Survey> retriveAllSurvey() {
		return surveys;
	}

	public Survey retriveSurveyId(String surveyId) {
		
		Predicate <? super Survey> predicate =
				s->s.getId().equalsIgnoreCase(surveyId);
		Optional<Survey> os = surveys.stream().filter(predicate).findFirst();
		 if(os.isEmpty()) {
			 return null;
		 }
		return os.get();
	}

	public List<Question> retriveQuestion(String surveyId) {
		// TODO Auto-generated method stub
		Survey sur = retriveSurveyId(surveyId);
		if(sur == null) return null;
		return sur.getQuestions();
	}
	
	public Question retriveQuestion(String surveyId,String questionId) {
		// TODO Auto-generated method stub
		List<Question> qs =retriveQuestion(surveyId);
		if(qs == null) return null;
		
		Optional<Question> que= qs.stream().filter(q->q.getId().equalsIgnoreCase(questionId)).findFirst();
		if(que.isEmpty()) return null;
		
		return que.get();
	}

	
	public void addNewSurveyQuestion(String surveyId, Question question) {
		// TODO Auto-generated method stub
		List<Question> rs= retriveQuestion(surveyId);
		rs.add(question);
	}
	
	
	

}
