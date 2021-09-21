package com.code.dojo.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.code.dojo.Models.Answer;
import com.code.dojo.Models.Question;
import com.code.dojo.Services.AnswerService;
import com.code.dojo.Services.QuestionService;
import com.code.dojo.Services.TagService;

@Controller
public class MainController {
	@Autowired
	private QuestionService qServ;
	@Autowired
	private TagService tServ;
	@Autowired
	private AnswerService aServ;
	
	@GetMapping("/create")
	public String index(@ModelAttribute("newQuestion") Question question) {

		return "question.jsp";
	}
	
	@PostMapping("/create/question")
    public String createQuestion(@ModelAttribute("newQuestion") Question question, RedirectAttributes error) {
		String[] tagsToProcess = question.getTags().split(",");
		System.out.println(tagsToProcess.length);
		
		ArrayList<String> errors= new ArrayList<String>();
		
		if(tagsToProcess.length > 3) {
			errors.add("Tags can not be more than 3");
		}
		
        if(errors.size()>0) {
            for(String e : errors) {
            	error.addFlashAttribute("errors", e);
            }
            return "redirect:/";
        }
		
		Question quest=qServ.createQuestion(question);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/dashboard")
	public String showAllQuestion(Model viewModel) {
		List<Question>allQuest=qServ.allQuestion();
		viewModel.addAttribute("questions",allQuest);
//		viewModel.addAttribute("questionsTag",);
		return "dashboard.jsp";
	}
	
	@GetMapping("/question/{id}")
	public String oneQuestion(@ModelAttribute("answer")Answer answer, @PathVariable("id") Long questionID, Model viewModel){
		Question oneQuestion =qServ.oneQuestionById(questionID);
//		Answer thisAnswer=aServ.createAnswer(answer);
//		thisAnswer.setQuestion(oneQuestion);
		viewModel.addAttribute("question", oneQuestion);
		return "oneQuestion.jsp";
	}
	
	@PostMapping("answer")
	public String addAnswer(@ModelAttribute("answer")Answer answer, Model viewModel){
//		Question oneQuestion =qServ.oneQuestionById(questionID);
//		
//		System.out.println(oneQuestion);
//		Answer thisAnswer=aServ.createAnswer(answer);
		aServ.createAnswer(answer);
		return "redirect:/dashboard";
	}
}
