package himedia.joinme.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import himedia.joinme.domain.Community;
import himedia.joinme.domain.Contest;
import himedia.joinme.domain.Join;
import himedia.joinme.domain.Post;
import himedia.joinme.service.JoinmeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class JoinmeController {
	
	private final JoinmeService service;
	
	@GetMapping("/contest")
	public String contest(Model model) {
		List<Contest> contestList = service.findAllReverseContest();
		model.addAttribute("postList", contestList);
		return "contest/main";
	}
	
	@GetMapping("/contest/post/add")
	public String contestAddForm(Model model) {
		model.addAttribute("contest", new Contest());
		return "contest/add";
	}
	 
	@PostMapping("/contest/post/add")
	public String contestAdd(@ModelAttribute Contest contest, RedirectAttributes redirectAttributes) {
		Contest savedContest = service.savedContest(1, contest);
		redirectAttributes.addAttribute("postNo", savedContest.getPostNo());
		return "redirect:/contest/post/{postNo}";
	}
	
	@GetMapping("/contest/post/{postNo}")
	public String contestAdd(@PathVariable int postNo, Model model) {
		Post post = service.findPost(postNo);
		Contest contest = service.findContest(postNo);
		model.addAttribute("post", post);
		model.addAttribute("contest", contest);
		return "contest/post";
	}

	@GetMapping("/contest/post/{postNo}/modify")
	public String contestModifyForm(@PathVariable int postNo, Model model) {
		Contest contest = service.findContest(postNo);
		model.addAttribute("contest", contest);
		return "contest/modify";
	}
	
	@PostMapping("/contest/post/{postNo}/modify")
	public String contestModify(@ModelAttribute Contest contest, RedirectAttributes redirectAttributes) {
		Contest updatedContest = service.updateContest(contest.getPostNo(), contest);
		redirectAttributes.addAttribute("postNo", updatedContest.getPostNo());
		return "redirect:/contest/post/{postNo}";
	}
	
	@GetMapping("/join")
	public String join(Model model) {
		List<Join> join = service.findAllReverseJoin();
	 	model.addAttribute("postList", join);
	 	return "join/main";
	}
//	@GetMapping("/join/post/add")
//	public String joinAddForm(Model model) {
//		
//	}
//	@PostMapping("/join/post/add")
//	@GetMapping("/join/post/{postNo}")
//	@GetMapping("/join/post/{postNo}/modify")
//	@PostMapping("/join/post/{postNo}/modify")
	
	@GetMapping("/community")
	public String community(Model model) {
		List<Community> community = service.findAllReverseCommunity();
	 	model.addAttribute("postList", community);
	 	return "community/main";
	}
//	@GetMapping("/community/post/add")
//	@PostMapping("/community/post/add")
//	@GetMapping("/community/post/{postNo}")
//	@GetMapping("/community/post/{postNo}/modify")
//	@PostMapping("/community/post/{postNo}/modify")
	
//	@getMapping("/login")
}