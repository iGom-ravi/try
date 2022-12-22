package com.example.restdemo.restdemo;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class SurveyResource {
	
	private SurveyService surveyService;


	public SurveyResource(SurveyService surveyService) {
		super();
		this.surveyService = surveyService;
	}
	@RequestMapping("survey")
	public List<Survey> retriveAllSurvey(){
		return surveyService.retriveAllSurvey();
	}
	
	@RequestMapping("/survey/{surveyId}")
	public Survey retriveSurveyId(@PathVariable String surveyId){
		return surveyService.retriveSurveyId(surveyId);
	}
	
	@RequestMapping("/survey/{surveyId}/question/{questionId}")
	public Question retriveQuestion(@PathVariable String surveyId,@PathVariable String questionId){
		Question qs = surveyService.retriveQuestion(surveyId, questionId);
		//List<Question> ss = surveyService.retriveQuestion(questionId);
		if(qs == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		return surveyService.retriveQuestion(surveyId, questionId);
	}
	
	@RequestMapping(value="/survey/{surveyId}/question/{questionId}",method=RequestMethod.POST)	
	public void retriveQuestionPost(@PathVariable String surveyId,@RequestBody Question question){
		surveyService.addNewSurveyQuestion(surveyId,question);
		
		
	}

}
