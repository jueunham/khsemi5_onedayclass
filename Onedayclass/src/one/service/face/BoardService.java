package one.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import one.dto.Board;

public interface BoardService {

	public List getList();

	public List getnoticeList();
	
	public List getbulletinList();
	
	public List getreportList();
}
