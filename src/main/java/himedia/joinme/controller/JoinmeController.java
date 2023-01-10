package himedia.joinme.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
	 public String contestAdd(Model model) {
			model.addAttribute("post", new Post());
		 model.addAttribute("contest", new Contest());
		 return "contest/add";
	}
	@PostMapping("contest/post/add")

	@ModelAttribute("field")
	public Map<String, String> field() {
		Map<String, String> field = new LinkedHashMap<>();
		field.put("F001", "기획/아이디어");
		field.put("F002", "광고/마케팅");
		field.put("F003", "논문/리포트");
		field.put("F004", "영상/UCC/사진");
		field.put("F005", "디자인/캐릭터/웹툰");
		field.put("F006", "웹/모바일/IT");		
		field.put("F007", "게임/소프트웨어");
		field.put("F008", "과학/공학");
		field.put("F009", "문학/글/시나리오");
		field.put("F010", "건축/건설/인테리어");
		field.put("F011", "네이밍/슬로건");
		field.put("F012", "예체능/미술/음악");
		field.put("F013", "대외활동/서포터즈");
		field.put("F014", "봉사활동");
		field.put("F015", "취업/창업");
		field.put("F016", "해외");
		field.put("F017", "기타");
		return field;
	}
}
