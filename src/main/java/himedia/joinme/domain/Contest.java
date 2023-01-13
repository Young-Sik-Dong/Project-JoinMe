package himedia.joinme.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
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
	@CreatedDate
	@Column (name = "registration_date")
	private String regiDate;
	@LastModifiedDate
	@Column (name = "modify_date")
	private String modifyDate;
	
    @PrePersist
    public void onPrePersist() {
        this.regiDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
        this.modifyDate = this.regiDate;
    }
    
    @PreUpdate
    public void onPreUpdate() {
        this.modifyDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
    }
	
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
	
	public void update(Contest contest) {
		this.title = contest.getTitle();
		this.companyName = contest.getCompanyName();
		this.field = contest.getField();
		this.targetName = contest.getTargetName();
		this.hostName = contest.getHostName();
		this.reward = contest.getReward();
		this.startDate = contest.getStartDate();
		this.endDate = contest.getEndDate();
		this.contestLink = contest.getContestLink();
	}
}