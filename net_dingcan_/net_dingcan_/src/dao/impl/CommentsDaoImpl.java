package dao.impl;

import java.util.List;


import dao.CommentsDAO;
import entity.Comments;

public class CommentsDaoImpl extends BaseDAO implements CommentsDAO {

	@Override
	public boolean save(Comments comments) {
		return saveOrUpdate(comments);
	}

	@Override
	public boolean del(Comments comments) {
		// TODO Auto-generated method stub
		return deleteById(Comments.class, comments.getId());
	}

	@Override
	public List<Comments> list() {
		StringBuffer sb = new StringBuffer();
		sb = new StringBuffer("FROM Comments ");

		List<Comments> lst = findByHQL(sb.toString());
		return lst;
	}

	@Override
	public List<Comments> listbyluxian(int luxian_id) {
		StringBuffer sb = new StringBuffer();
		sb = new StringBuffer("FROM Comments where luxianid =").append(luxian_id);

		List<Comments> lst = findByHQL(sb.toString());
		return lst;
	}

	@Override
	public List<Comments> list1() {
		StringBuffer sb = new StringBuffer();
		sb = new StringBuffer("FROM Comments where status=1");

		List<Comments> lst = findByHQL(sb.toString());
		return lst;
	}



}
