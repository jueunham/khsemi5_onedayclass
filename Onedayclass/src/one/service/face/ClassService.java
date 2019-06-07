package one.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import one.dto.ClassFile;
import one.dto.DayClass;
import one.util.Paging;

public interface ClassService {

 	 public List getList(Paging paging);
 	 
 	 public Paging getCurPage(HttpServletRequest req);
 	 
 	 public void uploadClass(HttpServletRequest req);
 	 
 	 public DayClass getClassnum(HttpServletRequest req);
 	 
 	 public DayClass view(DayClass viewDayclass);
 	 
 	 public void updateClass(HttpServletRequest req);

	public ClassFile viewFile(DayClass viewDayclass);
 	 
 	 
}
