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
public class Contest{
	private String postNo;
	private String postTitle;
	private String postWriter;
	private String postDate;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long index;
	private String contestField;
	private String companyName;
	private String targetName;
	private String hostName;
	private String reward;
	private String startDate;
	private String endDate;
	private String contestLink;
}
