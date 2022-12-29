package himedia.joinme.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import himedia.joinme.domain.Community;
import himedia.joinme.domain.Contest;
import himedia.joinme.domain.Join;
import himedia.joinme.domain.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Repository
@RequiredArgsConstructor
@Transactional
@Slf4j
public class JPAJoinmeRepository implements JoinmeRepository {
	
	private final EntityManager em;
	
	@Override
	public Member memberSave(Member member) {
		em.persist(member);
		return member;
	}

	@Override
	public void memberUpdate(String memberId, Member updateMember) {
		// TODO Auto-generated method stub
		
	}
}