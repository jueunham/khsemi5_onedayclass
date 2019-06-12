package one.dao.face;

import java.util.List;

import one.dto.ClassFile;
import one.dto.DayClass;

public interface ClassDao {
	
	public List selectAll();

	/**
	 * 클래스 번호 반환
	 * 	새 클래스의 번호를 추출
	 * 
	 * @return int
	 */
	public int selectClassnum();

	/**
	 * 클래스 등록
	 * 
	 * @param dayClass - 삽입될 클래스 내용
	 */
	public void insert(DayClass dayClass);
	
	
	/**
	 * 첨부파일 입력
	 * 
	 * @param classFile - 업로드 된 첨부파일 내용
	 */
	public void insertFile(ClassFile classFile);
	
	
	
	
}
