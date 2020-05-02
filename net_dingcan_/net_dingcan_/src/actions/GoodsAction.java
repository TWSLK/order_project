package actions;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import entity.Goods;

import service.GoodsService;
import utils.CreateId;
import utils.Utils;


public class GoodsAction extends BaseAction{
	private GoodsService goodsservice;
	private Goods goods;
	private String jsonString;
	private String goods_id;
	private List<Goods> list = new ArrayList<Goods>();
	private String keyword;
	
	
	
	public String save(){
		String realpath = ServletActionContext.getServletContext().getRealPath(
		"/upload");

		File file_= new File(realpath);
		if (!file_.exists()) {
			file_.mkdirs();
		}
		String filename = goods.getFileFileName();
		String extention = Utils.getExtensionName(filename);
		filename = CreateId.getId()+"."+extention;
		goods.setGoods_image(filename);

		try {
			FileUtils.copyFile(goods.getFile(), new File(file_, filename));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		goods.setGoods_image_url("upload" + "\\" + filename);
		
		goodsservice.save(goods);
		
		return SUCCESS;
	}
	public String saveclient() {
		String realpath = ServletActionContext.getServletContext().getRealPath(
				"/upload");

		File file_ = new File(realpath);
		if (!file_.exists()) {
			file_.mkdirs();
		}
		String filename = goods.getFileFileName();
		String extention = Utils.getExtensionName(filename);
		filename = CreateId.getId() + "." + extention;
		// jingdian.setImage_url(filename);

		try {
			FileUtils.copyFile(goods.getFile(), new File(file_, filename));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			goods.setGoods_image(filename);
			goods.setGoods_name(URLDecoder.decode(goods.getGoods_name(), "utf-8"));
			goods.setGoods_marketprice(goods.getGoods_marketprice());
			goods.setGoods_price(goods.getGoods_price());
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		goods.setGoods_image_url("upload" + "\\" + filename);
	
		
		boolean flag = goodsservice.save(goods);
		if (flag) {
			jsonString = "1";
		} else {
			jsonString = "0";
		}
		return SUCCESS;
	}
	public String list(){
		if(goods == null){
			list = goodsservice.search(null);
		}else{
			list = goodsservice.search(goods.getGoods_name());
		}
		
		return SUCCESS;
	}

	
	public String add(){
	
		return SUCCESS;
	}
	public String tuijian(){
		goodsservice.tuijian(goods.getGoods_id());
		return SUCCESS;
	}
	
	
	public String goodsjson(){
		if(keyword !=null&& !keyword.equals("")){
			jsonString=goodsservice.loadAllJson2(keyword);
		}else{
			jsonString=goodsservice.loadAllJson();
		}
		
	return SUCCESS;
}
	public String listall(){
		jsonString=goodsservice.listall();
		return SUCCESS;
	}
	public String list_tuijian(){
		jsonString=goodsservice.list_tuijian();
		return SUCCESS;
	}
	public String list0(){
		jsonString=goodsservice.list0();
		return SUCCESS;
	}
	public String list1(){
		jsonString=goodsservice.list1();
		return SUCCESS;
	}
	public String list2(){
		jsonString=goodsservice.list2();
		return SUCCESS;
	}
	public String list3(){
		jsonString=goodsservice.list3();
		return SUCCESS;
	}
	public String list4(){
		jsonString=goodsservice.list4();
		return SUCCESS;
	}
	public String list5(){
		jsonString=goodsservice.list5();
		return SUCCESS;
	}
	public String list6(){
		jsonString=goodsservice.list6();
		return SUCCESS;
	}
	public String list7(){
		jsonString=goodsservice.list7();
		return SUCCESS;
	}
	public String list8(){
		jsonString=goodsservice.list8();
		return SUCCESS;
	}
	public String list9(){
		jsonString=goodsservice.list9();
		return SUCCESS;
	}
	public String list10(){
		jsonString=goodsservice.list10();
		return SUCCESS;
	}
	public String list11(){
		jsonString=goodsservice.list11();
		return SUCCESS;
	}
	
	public String detailjson(){
		jsonString=goodsservice.detailjson(goods_id);
	return SUCCESS;
}
	
	public String delete(){
		goodsservice.del(goods);
		return SUCCESS;
	}
	public String edit(){
		goods = goodsservice.load(goods.getGoods_id());
		return SUCCESS;
	}


	public GoodsService getGoodsservice() {
		return goodsservice;
	}



	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public void setGoodsservice(GoodsService goodsservice) {
		this.goodsservice = goodsservice;
	}



	public Goods getGoods() {
		return goods;
	}



	public String getJsonString() {
		return jsonString;
	}

	public void setJsonString(String jsonString) {
		this.jsonString = jsonString;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public List<Goods> getList() {
		return list;
	}

	public void setList(List<Goods> list) {
		this.list = list;
	}

	public String getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(String goodsId) {
		goods_id = goodsId;
	}
	
	
	

}
