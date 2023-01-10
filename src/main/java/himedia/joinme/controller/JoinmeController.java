package himedia.joinme.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import himedia.joinme.domain.Contest;
import himedia.joinme.domain.Post;
import himedia.joinme.service.JoinmeService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class JoinmeController {
	
	private final JoinmeService service;
	
	@GetMapping("/contest")
	public String contest(Model model) {
		List<Post> postList = service.findReversePost("CONTEST");
		model.addAttribute("postList", postList);
		return "contest/main";
	}
	
	 @GetMapping("/join")
	 public String join(Model model) {
	 	List<Post> join = service.findReversePost("JOIN");
	 	model.addAttribute("postList", join);
	 	return "join/main";
	 }
	
	 @GetMapping("/community")
	 public String community(Model model) {
	 	List<Post> community = service.findReversePost("COMMUNITY");
	 	model.addAttribute("postList", community);
	 	return "community/main";
	 }
	 @GetMapping("contest/post/{postNo}")
		public String contestAdd(@PathVariable int postNo, Model model) {
			Post post = service.findPost(postNo);
			Contest contest = service.findContest(postNo);
		 	model.addAttribute("post", post);
			model.addAttribute("contest", contest);
			return "contest/post";
	 }
	 @GetMapping("contest/post/add")
	 public String contestAddFrom(Model model) {
			model.addAttribute("post", new Post());
		 	model.addAttribute("contest", new Contest());
		 return "contest/add";
	}
	@PostMapping("contest/post/add")
	public String contestAdd(@ModelAttribute Post post, @ModelAttribute Contest contest, RedirectAttributes redirectAttributes) {
		service.savedPost(post);
		Contest savedContest = service.savedContest(null, null, null, contest);
		redirectAttributes.addAttribute("postNo", savedContest.getPostNo());
		return "redirect:/contest/post/{postNo}";
	}

	@GetMapping("contest/post/{postNo}/modify")
	public String contestModify(@PathVariable int postNo, Model model) {

		service.updatedMember(null);
		return "redirect:/contest/post/{postNo}";
	}

}
