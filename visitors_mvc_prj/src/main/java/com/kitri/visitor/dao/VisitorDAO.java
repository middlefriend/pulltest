package com.kitri.visitor.dao;

import java.util.List;

import com.kitri.visitor.vo.VisitorVO;

public interface VisitorDAO {
	public List<VisitorVO> selectVisitors();
	public int insertVisitor(VisitorVO vvo);
	public int updateVisitor(VisitorVO vvo);
	public int deleteVisitor(int vno);
}
