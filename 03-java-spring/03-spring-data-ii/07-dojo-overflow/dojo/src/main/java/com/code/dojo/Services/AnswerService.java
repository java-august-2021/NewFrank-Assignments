package com.code.dojo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.dojo.Models.Answer;
import com.code.dojo.Models.Question;
import com.code.dojo.Repository.AnswerRepo;
@Service
public class AnswerService {
	
	@Autowired
	private AnswerRepo aRepo;
	
	public Answer createAnswer(Answer answer) {
		return aRepo.save(answer);
	}
	
//	public Answer addQuestion(Question question,Answer answer) {
//		answer.setQuestion(question);
//		return aRepo.save(answer);
//	}
	
}
