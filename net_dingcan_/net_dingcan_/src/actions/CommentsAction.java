package actions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import service.CommentsService;
import utils.CreateId;
import utils.Utils;


import entity.Comments;

public class CommentsAction extends BaseAction{
	private CommentsService commentsservice;
	private Comments comments;
	private String jsonString;
	private String comment;
	private int userid;
	private int luxianid;
	private int status;
	private List<Comments> list = new ArrayList<Comments>();
	
	
	
	public String save(){
		comments= new Comments();
		comments.setUserid(userid);
		comments.setStatus(status);
		comments.setContent(comment);
		comments.setCommitdate(new Date());
		comments.setLuxianid(luxianid);
		boolean flag = commentsservice.save(comments);
		if(flag){
			jsonString="1";
		}else{
			jsonString="0";
		}
		
		return SUCCESS;
	}
	
	public String listmsgjson(){
		jsonString = commentsservice.listbyuserid(userid);
		return SUCCESS;
}
	
	public String list(){
		list = commentsservice.list();
		return SUCCESS;
	}
	public String list1(){
		list = commentsservice.list1();
		return SUCCESS;
	}

	
	public String add(){
		return SUCCESS;
	}

	
	
	public String listjson(){
		jsonString = commentsservice.listbyluxian(luxianid);
		return SUCCESS;
}
	
	
	public String delete(){
		commentsservice.del(comments);
		return SUCCESS;
	}





	public String getJsonString() {
		return jsonString;
	}

	public void setJsonString(String jsonString) {
		this.jsonString = jsonString;
	}



	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public CommentsService getCommentsservice() {
		return commentsservice;
	}

	public void setCommentsservice(CommentsService commentsservice) {
		this.commentsservice = commentsservice;
	}

	public Comments getComments() {
		return comments;
	}

	public void setComments(Comments comments) {
		this.comments = comments;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public List<Comments> getList() {
		return list;
	}

	public void setList(List<Comments> list) {
		this.list = list;
	}


	public int getLuxianid() {
		return luxianid;
	}

	public void setLuxianid(int luxianid) {
		this.luxianid = luxianid;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}




	
	
	

}
