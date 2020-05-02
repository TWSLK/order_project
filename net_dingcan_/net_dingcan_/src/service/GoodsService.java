package service;

import java.util.List;

import entity.Goods;





public interface GoodsService {
	
	public boolean save(Goods goods);
	public void del(Goods goods);
	public String list();
	public String detail(int goods_id);
	public Goods load(int goods_id);
	public List<Goods> search(String name);
	public String loadAllJson();
	public String loadAllJson2(String keyword);
	public String detailjson(String goods_id);;
	
	public String listall();
	public String list_tuijian();
	public String list0();
	public String  list1();
	public String  list2();
	public String  list3();
	public String  list4();
	public String  list5();
	public String  list6();
	public String  list7();
	public String  list8();
	public String  list9();
	public String  list10();
	public String  list11();
	
	public boolean tuijian(int goods_id);
	

}
