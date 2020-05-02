package service;

import java.util.List;

import entity.Comments;




public interface CommentsService {
	
	public boolean save(Comments comments);
	public boolean del(Comments comments);
	public List<Comments> list();
	public List<Comments> list1();
	public String listbyluxian(int luxianid);
	//----------------------------------------
	//----------------------------------------------------------
	public String listbyuserid(int touserid);
	

}
