	package himedia.joinme.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import himedia.joinme.domain.Community;
import himedia.joinme.domain.Contest;
import himedia.joinme.domain.Join;
import himedia.joinme.domain.Member;
import himedia.joinme.domain.Post;
import himedia.joinme.repository.JPAJoinmeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class JoinmeService {
	private final JPAJoinmeRepository Repository;
	
	public Member savedMember(Member member) {
		Optional<Member> find = Repository.findByMemberId(member.getMemberId());
		
		if(find.isPresent())
			log.info("중복된 ID");
		
		if(find.isEmpty())
			Repository.saveMember(member);
		
		return member;
	}
	public Member updatedMember(Member member) {
		Optional<Member> find = Repository.findByMemberId(member.getMemberId());
		
		if(find.isPresent())
			Repository.updateMember(member.getMemberNo(), member);
		
		return member;
	}
	
	public Contest savedContest(Post post, Contest contest) {
		post.setPostName("CONTEST");
		Repository.savePost(post);
		contest.setPostNo(post.getPostNo());
		return Repository.saveContest(contest);
	}
	
	public Join savedJoin(Post post, Join join) {
		post.setPostName("JOIN");
		Repository.savePost(post);
		join.setPostNo(post.getPostNo());
		return Repository.saveJoin(join);
	}
	
	public Community savedCommunity(Post post, Community community) {
		post.setPostName("COMMUNITY");
		Repository.savePost(post);
		community.setPostNo(post.getPostNo());
		return Repository.saveCommunity(community);
	}
	public Post findPost(int postNo) {
		return Repository.findByPostNo(postNo).get();
	}
	public Contest findContest(int postNo) {
		return Repository.findByContest(postNo).get();
	}
	public Join findJoin(int postNo) {
		return Repository.findByJoin(postNo).get();
	}
	public Community findCommunity(int postNo) {
		return Repository.findByCommunity(postNo).get();
	}
	public List<Post> findAllPost(String postName) {
		return Repository.findAllPostName(postName);
	}
	
	public List<Post> findReversePost(String postName) {
		return Repository.findReversePostName(postName);
	}
}
