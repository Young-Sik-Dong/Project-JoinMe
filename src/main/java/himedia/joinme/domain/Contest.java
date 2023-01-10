package himedia.joinme.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contest {
	@Id
	@Column (name = "post_no")
	private int postNo;
	@Column (name = "contest_no")
	private int contestNo;
	@Column (name = "title")
	private String title;
	@Column (name = "company_name")
	private String companyName;
	//@ElementCollection(targetClass=String.class)
	//private List<String> field = new ArrayList<>();
	@Column (name = "field")
	private String field;
	@Column (name = "target_name")
	private String targetName;
	@Column (name = "host_name")
	private String hostName;
	@Column (name = "reward")
	private String reward;
	@Column (name = "start_date")
	private String startDate;
	@Column (name = "end_date")
	private String endDate;
	@Column (name = "contest_link")
	private String contestLink;
	
	public Contest(String title, String companyName, String field, String targetName, String hostName, String reward,
			String startDate, String endDate, String contestLink) {
		this.title = title;
		this.companyName = companyName;
		this.field = field;
		this.targetName = targetName;
		this.hostName = hostName;
		this.reward = reward;
		this.startDate = startDate;
		this.endDate = endDate;
		this.contestLink = contestLink;
	}
}