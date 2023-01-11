package himedia.joinme.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HostName {
	private String code;
	private String displayName;
}