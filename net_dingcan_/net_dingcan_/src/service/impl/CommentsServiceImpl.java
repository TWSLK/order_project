package service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import service.CommentsService;

import net.sf.json.JSONArray;


import dao.CommentsDAO;
import dao.UserDAO;
import entity.Comments;
import entity.User;

public class CommentsServiceImpl implements CommentsService {
	private CommentsDAO commentsdao;
	private UserDAO userdao;

	@Override
	public boolean save(Comments comments) {
		// TODO Auto-generated method stub
		return commentsdao.save(comments);
	}

	@Override
	public boolean del(Comments comments) {
		// TODO Auto-generated method stub
		return commentsdao.del(comments);
	}

	@Override
	public List<Comments> list() {
		// TODO Auto-generated method stub
		List<Comments> list2= new ArrayList<Comments>();
		List<Comments> list = commentsdao.list();
		
		for(Comments c :list){
			User user = userdao.load(c.getUserid());
			c.setUsername(user.getUsername());
			String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(c.getCommitdate());
			c.setCdate(date);
			list2.add(c);
		}
		return list2;
	}

	@Override
	public String listbyluxian(int luxianid) {
		// TODO Auto-generated method stub
		List<Comments> list2= new ArrayList<Comments>();
		List<Comments> list = commentsdao.listbyluxian(luxianid);
		
		for(Comments c :list){
			User user = userdao.load(c.getUserid());
			c.setUsername(user.getUsername());
			String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(c.getCommitdate());
			c.setCdate(date);
			list2.add(c);
		}
		
		
		
		JSONArray js = JSONArray.fromObject(list2);
		
		return js.toString();
	}

	public CommentsDAO getCommentsdao() {
		return commentsdao;
	}

	public void setCommentsdao(CommentsDAO commentsdao) {
		this.commentsdao = commentsdao;
	}

	public UserDAO getUserdao() {
		return userdao;
	}

	public void setUserdao(UserDAO userdao) {
		this.userdao = userdao;
	}

	@Override
	public String listbyuserid(int touserid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comments> list1() {
		// TODO Auto-generated method stub
		return commentsdao.list1();
	}

	

}
