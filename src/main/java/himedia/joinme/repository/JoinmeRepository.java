package himedia.joinme.repository;

import java.util.List;
import java.util.Optional;

import himedia.joinme.domain.Community;
import himedia.joinme.domain.Contest;
import himedia.joinme.domain.Join;
import himedia.joinme.domain.Member;
import himedia.joinme.domain.Post;

public interface JoinmeRepository {

	Member memberSave(Member member);
	Post postSave(Post post);
	Contest contestSave(Contest contest);
	Join joinSave(Join join);
	Community communitySave(Community community);
	
	Optional<Member> findByMemberNo(int memberNo);
	Optional<Member> findByMemberId(String memberId);
	Optional<Post> findByPostNo(int postNo);
	Optional<Contest> findByContest(int postNo);
	Optional<Join> findByJoin(int postNo);
	Optional<Community> findByCommunity(int postNo);
	List<Post> findAllPostName(String postName);
	
	void updateMember(int memberNo, Member updateMember);
	void updatePost(int postNo, Post updatePost);
	void updateContest(int postNo, Contest updateContest);
	void updateJoin(int postNo, Join updateJoin);
	void updateCommunity(int postNo, Community updateCommunity);
	
	void deleteMember(int memberNo);
	void deletePost(int postNo);
}