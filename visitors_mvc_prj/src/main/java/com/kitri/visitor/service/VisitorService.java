package com.kitri.visitor.service;

import java.util.List;

import com.kitri.visitor.vo.VisitorVO;

public interface VisitorService {
	public List<VisitorVO> searchVisitors();
	public int registVisitor(VisitorVO vvo);
	public int updateVisitor(VisitorVO vvo);
	public int deleteVisitor(int vno);
}
