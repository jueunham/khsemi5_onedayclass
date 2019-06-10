package one.dao.face;

import java.util.List;
import java.util.Map;

import one.dto.Member;
import one.dto.UserInterList;

public interface MypageDao {

	public List<Map<String, Object>> selectClass();
	
	public Member selectUserNum(Member member);

	public void updateInfoPhone(Member member);
	
	public void updateInfoInter(UserInterList userinter);
	
	public List<Map<String, Object>> selectWishList();

	List<Map<String, Object>> selectRevQue();



	
}
