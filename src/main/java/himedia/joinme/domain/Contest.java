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
	@Column (name = "company_name")
	private String companyName;

	private String field;
	@Column (name = "target_name")
	private String targetName;
	@Column (name = "host_name")
	private String hostName;

	private String reward;
	@Column (name = "start_date")
	private String startDate;
	@Column (name = "end_date")
	private String endDate;
	@Column (name = "contest_link")
	private String contestLink;
}