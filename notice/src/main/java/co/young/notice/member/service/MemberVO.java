package co.young.notice.member.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//DTO
public class MemberVO {
	private String memberId;
	private String memberPassword;
	private String memberName;
	private int memberAge;
	private String memberTel;
	private String memberGender;


}
