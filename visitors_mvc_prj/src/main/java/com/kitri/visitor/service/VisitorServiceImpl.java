package com.kitri.visitor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitri.visitor.dao.VisitorDAO;
import com.kitri.visitor.dao.VisitorDAOImpl;
import com.kitri.visitor.vo.VisitorVO;

@Service
public class VisitorServiceImpl implements VisitorService{
	@Autowired
//	private VisitorDAOImpl vdao;
	private VisitorDAO vdao;

	@Override
	public List<VisitorVO> searchVisitors() {
		return vdao.selectVisitors();
	}

	@Override
	public int registVisitor(VisitorVO vvo) {
		return vdao.insertVisitor(vvo);
	}

	@Override
	public int updateVisitor(VisitorVO vvo) {
		return vdao.updateVisitor(vvo);
	}

	@Override
	public int deleteVisitor(int vno) {
		return vdao.deleteVisitor(vno);
	}

}
