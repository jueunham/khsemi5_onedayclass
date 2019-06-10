package one.service.face;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import one.dto.Member;


public interface MypageService {
	
	public List<Map<String, Object>> getList();
	
	public Member getUserNum(HttpServletRequest req);
	
	public Member view(Member member);
	
	public void updateInfo(HttpServletRequest req);
	
	public List<Map<String, Object>> getWishList();
	
	public List<Map<String, Object>> getRevQue();
	
}
