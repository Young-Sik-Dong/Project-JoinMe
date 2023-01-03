package himedia.joinme.service;

import org.springframework.stereotype.Service;

import himedia.joinme.repository.JPAJoinmeRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JoinmeService {
	private final JPAJoinmeRepository joinmeRepository;
	
}
