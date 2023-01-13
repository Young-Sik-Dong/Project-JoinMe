package himedia.joinme.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Member {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "member_no")
	private int memberNo;
	@Column (name = "member_id")
	private String memberId;
	@Column (name = "member_password")
	private String memberPassword;
	@Column (name = "nickname")
	private String nickname;
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
	
	public Member(String memberId, String memberPassword, String nickname) {
		this.memberId = memberId;
		this.memberPassword = memberPassword;
		this.nickname = nickname;
	}
}