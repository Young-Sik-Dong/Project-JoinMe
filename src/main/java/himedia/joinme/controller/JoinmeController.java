package himedia.joinme.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import himedia.joinme.domain.Category;
import himedia.joinme.domain.Community;
import himedia.joinme.domain.Contest;
import himedia.joinme.domain.Field;
import himedia.joinme.domain.HostName;
import himedia.joinme.domain.Join;
import himedia.joinme.domain.Member;
import himedia.joinme.domain.Post;
import himedia.joinme.domain.Region;
import himedia.joinme.domain.Reward;
import himedia.joinme.domain.TargetName;
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

	@PostMapping("/contest/post/{postNo}")
	public String contestDelete(@PathVariable int postNo) {
		service.deleteContest(postNo);
		return "redirect:/contest";
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

	@GetMapping("/join/post/add")
	public String joinAddForm(Model model) {
		model.addAttribute("join", new Join());
		return "join/add";

	}

	@PostMapping("/join/post/add")
	public String joinAdd(@ModelAttribute Join join, RedirectAttributes redirectAttributes) {
		Join savedJoin = service.savedJoin(1, join);
		redirectAttributes.addAttribute("postNo", savedJoin.getPostNo());
		return "redirect:/join/post/{postNo}";
	}

	@GetMapping("/join/post/{postNo}")
	public String joinAdd(@PathVariable int postNo, Model model) {
		Post post = service.findPost(postNo);
		Join join = service.findJoin(postNo);
		model.addAttribute("post", post);
		model.addAttribute("join", join);
		return "join/post";
	}

	@PostMapping("/join/post/{postNo}")
	public String joinDelete(@PathVariable int postNo) {
		service.deleteJoin(postNo);
		return "redirect:/join";
	}

	@GetMapping("/join/post/{postNo}/modify")
	public String joinModifyForm(@PathVariable int postNo, Model model) {
		Join join = service.findJoin(postNo);
		model.addAttribute("join", join);
		return "join/modify";
	}

	@PostMapping("/join/post/{postNo}/modify")
	public String joinModify(@ModelAttribute Join join, RedirectAttributes redirectAttributes) {
		Join updatedJoin = service.updateJoin(join.getPostNo(), join);
		redirectAttributes.addAttribute("postNo", updatedJoin.getPostNo());
		return "redirect:/join/post/{postNo}";
	}

	@GetMapping("/community")
	public String community(Model model) {
		List<Community> community = service.findAllReverseCommunity();
		model.addAttribute("postList", community);
		return "community/main";
	}

	@GetMapping("/community/post/add")
	public String communityAddForm(Model model) {
		model.addAttribute("community", new Community());
		return "community/add";
	}

	@PostMapping("/community/post/add")
	public String communityAdd(@ModelAttribute Community community, RedirectAttributes redirectAttributes) {
		Community savedCommunity = service.savedCommunity(1, community);
		redirectAttributes.addAttribute("postNo", savedCommunity.getPostNo());
		return "redirect:/community/post/{postNo}";
	}

	@GetMapping("/community/post/{postNo}")
	public String communityAdd(@PathVariable int postNo, Model model) {
		Post post = service.findPost(postNo);
		Community community = service.findCommunity(postNo);
		model.addAttribute("post", post);
		model.addAttribute("community", community);
		return "community/post";
	}

	@PostMapping("/community/post/{postNo}")
	public String communityDelete(@PathVariable int postNo) {
		service.deleteCommunity(postNo);
		return "redirect:/community";
	}

	@GetMapping("/community/post/{postNo}/modify")
	public String communityModifyForm(@PathVariable int postNo, Model model) {
		Community community = service.findCommunity(postNo);
		model.addAttribute("community", community);
		return "community/modify";
	}

	@PostMapping("/community/post/{postNo}/modify")
	public String communityModify(@ModelAttribute Community community, RedirectAttributes redirectAttributes) {
		Community updatedCommunity = service.updateCommnity(community.getPostNo(), community);
		redirectAttributes.addAttribute("postNo", updatedCommunity.getPostNo());
		return "redirect:/community/post/{postNo}";
	}

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("member", new Member());
		return "login/signin";
	}
	
	@PostMapping("/login")
	public String loginResult(@ModelAttribute Member member, RedirectAttributes redirectAttributes) {
		if(service.login(member)) {
			redirectAttributes.addAttribute("memberNo", member.getMemberNo());
			return "redirect:/login/{memberNo}";
		}
		return "login";
	}
	@GetMapping("/login/{memberNo}")
	public String JoinmeLogin(@PathVariable int memberNo) {
		return "/login/main";
	}
	

	@GetMapping("/login/find")
	public String find() {
		return "login/find";
	}
	@PostMapping("/login/find")
	public String findResult(@RequestBody String memberId) {
		service.findMemberId(memberId);
		return "login/find";
	}

	@GetMapping("/login/registration")
	public String registration(Model model) {
		model.addAttribute("member", new Member());
		return "login/signup";
	}
	
	@PostMapping("/login/registration")
	public String registrationAdd(@ModelAttribute Member member) {
		service.savedMember(member);
		return "redirect:/login/signin";
	}

	@ModelAttribute("fields")
	public List<Field> field() {
		List<Field> fields = new ArrayList<>();
		fields.add(new Field("F001", "기획/아이디어"));
		fields.add(new Field("F002", "광고/마케팅"));
		fields.add(new Field("F003", "논문/리포트"));
		fields.add(new Field("F004", "영상/UCC/사진"));
		fields.add(new Field("F005", "디자인/캐릭터/웹툰"));
		fields.add(new Field("F006", "웹/모바일/IT"));
		fields.add(new Field("F007", "게임/소프트웨어"));
		fields.add(new Field("F008", "과학/공학"));
		fields.add(new Field("F009", "문학/글/시나리오"));
		fields.add(new Field("F010", "건축/건설/인테리어"));
		fields.add(new Field("F011", "네이밍/슬로건"));
		fields.add(new Field("F012", "예체능/미술/음악"));
		fields.add(new Field("F013", "대외활동/서포터즈"));
		fields.add(new Field("F014", "봉사활동"));
		fields.add(new Field("F015", "취업/창업"));
		fields.add(new Field("F016", "해외"));
		fields.add(new Field("F017", "기타"));
		return fields;
	}

	@ModelAttribute("targetNames")
	public List<TargetName> targetName() {
		List<TargetName> targetNames = new ArrayList<>();
		targetNames.add(new TargetName("T001", "제한없음"));
		targetNames.add(new TargetName("T002", "일반인"));
		targetNames.add(new TargetName("T003", "대학생"));
		targetNames.add(new TargetName("T004", "청소년"));
		targetNames.add(new TargetName("T005", "어린이"));
		targetNames.add(new TargetName("T006", "기타"));
		return targetNames;
	}

	@ModelAttribute("hostNames")
	public List<HostName> hostName() {
		List<HostName> hostNames = new ArrayList<>();
		hostNames.add(new HostName("H001", "정부/공공기관"));
		hostNames.add(new HostName("H002", "공기업"));
		hostNames.add(new HostName("H003", "대기업"));
		hostNames.add(new HostName("H004", "신문/방송/언론"));
		hostNames.add(new HostName("H005", "외국계기업"));
		hostNames.add(new HostName("H006", "중견/중소/벤처기업"));
		hostNames.add(new HostName("H007", "비영리/협회/재단"));
		hostNames.add(new HostName("H008", "해외"));
		hostNames.add(new HostName("H009", "기타"));
		return hostNames;
	}

	@ModelAttribute("rewards")
	public List<Reward> Reward() {
		List<Reward> rewards = new ArrayList<>();
		rewards.add(new Reward("R001", "5천만원 이상"));
		rewards.add(new Reward("R002", "5천만원~3천만원"));
		rewards.add(new Reward("R003", "3천만원~1천만원"));
		rewards.add(new Reward("R004", "1천만원이하"));
		rewards.add(new Reward("R005", "취업특전"));
		rewards.add(new Reward("R006", "입사시가산점"));
		rewards.add(new Reward("R007", "인턴채용"));
		rewards.add(new Reward("R008", "정직원채용"));
		rewards.add(new Reward("R009", "기타"));
		return rewards;
	}

	@ModelAttribute("regions")
	public List<Region> Region() {
		List<Region> regions = new ArrayList<>();
		regions.add(new Region("R101", "서울"));
		regions.add(new Region("R102", "경기"));
		regions.add(new Region("R103", "인천"));
		regions.add(new Region("R104", "대전"));
		regions.add(new Region("R105", "대구"));
		regions.add(new Region("R106", "울산"));
		regions.add(new Region("R107", "부산"));
		regions.add(new Region("R108", "강원"));
		regions.add(new Region("R109", "충북"));
		regions.add(new Region("R110", "충남"));
		regions.add(new Region("R111", "전북"));
		regions.add(new Region("R112", "전남"));
		regions.add(new Region("R113", "경북"));
		regions.add(new Region("R114", "경남"));
		regions.add(new Region("R115", "제주"));
		regions.add(new Region("R116", "기타"));
		return regions;
	}

	@ModelAttribute("categories")
	public List<Category> Category() {
		List<Category> categories = new ArrayList<>();
		categories.add(new Category("C001", "공모전"));
		categories.add(new Category("C002", "대외활동"));
		categories.add(new Category("C003", "취업"));
		categories.add(new Category("C004", "공부"));
		categories.add(new Category("C005", "취미"));
		categories.add(new Category("C006", "자유"));
		return categories;
	}
}