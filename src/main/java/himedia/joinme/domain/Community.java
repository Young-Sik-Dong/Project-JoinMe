package himedia.joinme.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Community {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int communityNo;
	private String postNo;
	private String postTitle;
	private String postWriter;
	private String postDate;
	private String category;
	private String text;
	private String joinLink;
}