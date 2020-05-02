package actions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import entity.Desk;

import service.DeskService;

public class DeskAction extends BaseAction{
	private DeskService deskservice;
	private Desk desk;
	private String jsonString;
	private String goods_id;
	private List<Desk> list = new ArrayList<Desk>();
	private String keyword;
	
	
	
	public String save(){
		
		deskservice.save(desk);
		
		return SUCCESS;
	}
	
	public String list(){
			list = deskservice.list();
		
		return SUCCESS;
	}

	
	public String add(){
	
		return SUCCESS;
	}
	
	
	public String listjson(){
			jsonString=deskservice.loadAllJson();
		
	return SUCCESS;
}
	
	
	public String delete(){
		deskservice.del(desk);
		return SUCCESS;
	}
	public String edit(){
		desk = deskservice.load(desk.getId());
		return SUCCESS;
	}






	public String getJsonString() {
		return jsonString;
	}

	public void setJsonString(String jsonString) {
		this.jsonString = jsonString;
	}

	public DeskService getDeskservice() {
		return deskservice;
	}

	public void setDeskservice(DeskService deskservice) {
		this.deskservice = deskservice;
	}

	public Desk getDesk() {
		return desk;
	}

	public void setDesk(Desk desk) {
		this.desk = desk;
	}

	public String getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(String goods_id) {
		this.goods_id = goods_id;
	}

	public List<Desk> getList() {
		return list;
	}

	public void setList(List<Desk> list) {
		this.list = list;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	
	

}
