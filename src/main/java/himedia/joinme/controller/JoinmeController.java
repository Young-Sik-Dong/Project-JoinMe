package himedia.joinme.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import himedia.joinme.service.JoinmeService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class JoinmeController {
	
	private JoinmeService service;
	
	@GetMapping("/contest")
	public String contest(/*Model model*/) {
//		List<Post> contest = service.findAllPost("CONTEST");
//		model.addAttribute("contest", contest);
		return "contest/main";
	}
	
	@GetMapping("/join")
	public String join(/*Model model*/) {
//		List<Post> contest = service.findAllPost("CONTEST");
//		model.addAttribute("contest", contest);
		return "join/main";
	}
	
	@GetMapping("/community")
	public String community(/*Model model*/) {
//		List<Post> contest = service.findAllPost("CONTEST");
//		model.addAttribute("contest", contest);
		return "community/main";
	}
	
	@GetMapping("/mypage")
	public String mypage(/*Model model*/) {
//		List<Post> contest = service.findAllPost("CONTEST");
//		model.addAttribute("contest", contest);
		return "mypage/main";
	}
}
