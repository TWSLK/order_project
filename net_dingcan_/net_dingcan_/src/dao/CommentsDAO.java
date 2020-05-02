package dao;


import java.util.List;

import entity.Comments;



public interface CommentsDAO {

	public boolean save(Comments comments);
	public boolean del(Comments comments);
	public List<Comments> list();
	public List<Comments> list1();
	public List<Comments> listbyluxian(int luxian_id);
//----------------------------------------------------------
}
