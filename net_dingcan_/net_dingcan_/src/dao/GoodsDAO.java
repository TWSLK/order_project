package dao;


import java.util.List;

import entity.Goods;




public interface GoodsDAO {

	public boolean save(Goods goods);
	public boolean del(Goods goods);
	public Goods load(int id);
	public boolean update(Goods goods);
	public List<Goods> list(String name);
	public boolean tuijian(int goods_id);
	public List<Goods> listall();
	public List<Goods> list0();
	public List<Goods> list_tuijian();
	public List<Goods> list1();
	public List<Goods> list2();
	public List<Goods> list3();
	public List<Goods> list4();
	public List<Goods> list5();
	public List<Goods> list6();
	public List<Goods> list7();
	public List<Goods> list8();
	public List<Goods> list9();
	public List<Goods> list10();
	public List<Goods> list11();
}
