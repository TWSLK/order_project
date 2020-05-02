package dao.impl;

import java.util.List;

import dao.GoodsDAO;
import entity.Goods;


public class GoodsDaoImpl extends BaseDAO implements GoodsDAO {

	@Override
	public Goods load(int id) {
		StringBuffer sb = new StringBuffer("FROM Goods WHERE goods_id = ")
		.append(id);
		
		List<Goods> lst = findByHQL(sb.toString());
		if(lst.size()>0){
			return lst.get(0);
		}else{
			return null;
		}
	}

	@Override
	public List<Goods> list(String name) {
		// TODO Auto-generated method stub
		StringBuffer sb;
		if(name !=null && !name.equals("")){
			 sb = new StringBuffer("FROM Goods WHERE goods_name like '%")
			.append(name).append("%'");
		}else{
			 sb = new StringBuffer("FROM Goods");
		}
		
		List<Goods> lst = findByHQL(sb.toString());
		 return lst;
	}

	@Override
	public boolean save(Goods goods) {
		// TODO Auto-generated method stub
		return saveOrUpdate(goods);
	}

	@Override
	public boolean update(Goods goods) {
		// TODO Auto-generated method stub
		return saveOrUpdate(goods);
	}

	@Override
	public boolean del(Goods goods) {
		// TODO Auto-generated method stub
		this.delete(goods);
		return true;
	}
//<!--> 机械及行业设备  低压配电  低压控制  仪器、仪表  电子元器件   主令控制元件
	@Override
	public List<Goods> list0() {
		StringBuffer sb;
			 sb = new StringBuffer("FROM Goods where goods_type = '机械及行业设备'");
		
		List<Goods> lst = findByHQL(sb.toString());
		 return lst;
	}

	@Override
	public List<Goods> list1() {
		 StringBuffer sb;
		 sb = new StringBuffer("FROM Goods where goods_type = '低压配电'");
		 List<Goods> lst = findByHQL(sb.toString());
	     return lst;
	}

	@Override
	public List<Goods> list2() {
		 StringBuffer sb;
		 sb = new StringBuffer("FROM Goods where goods_type = '低压控制'");
		 List<Goods> lst = findByHQL(sb.toString());
	     return lst;
	}

	@Override
	public List<Goods> list3() {
		 StringBuffer sb;
		 sb = new StringBuffer("FROM Goods where goods_type = '仪器、仪表'");
		 List<Goods> lst = findByHQL(sb.toString());
	     return lst;
	}

	@Override
	public List<Goods> list4() {
		 StringBuffer sb;
		 sb = new StringBuffer("FROM Goods where goods_type = '电子元器件'");
		 List<Goods> lst = findByHQL(sb.toString());
	     return lst;
	}

	@Override
	public List<Goods> list5() {
		 StringBuffer sb;
		 sb = new StringBuffer("FROM Goods where goods_type = '主令控制元件'");
		 List<Goods> lst = findByHQL(sb.toString());
	     return lst;
	}

	@Override
	public List<Goods> list6() {
		 StringBuffer sb;
		 sb = new StringBuffer("FROM Goods where goods_type = '乳品饮料'");
		 List<Goods> lst = findByHQL(sb.toString());
	     return lst;
	}

	@Override
	public List<Goods> list7() {
		 StringBuffer sb;
		 sb = new StringBuffer("FROM Goods where goods_type = '厨卫品'");
		 List<Goods> lst = findByHQL(sb.toString());
	     return lst;
	}

	@Override
	public List<Goods> list8() {
		 StringBuffer sb;
		 sb = new StringBuffer("FROM Goods where goods_type = '海产品'");
		 List<Goods> lst = findByHQL(sb.toString());
	     return lst;
	}

	@Override
	public List<Goods> list9() {
		 StringBuffer sb;
		 sb = new StringBuffer("FROM Goods where goods_type = '特产'");
		 List<Goods> lst = findByHQL(sb.toString());
	     return lst;
	}

	@Override
	public List<Goods> list10() {
		 StringBuffer sb;
		 sb = new StringBuffer("FROM Goods where goods_type = '低价促销'");
		 List<Goods> lst = findByHQL(sb.toString());
	     return lst;
	}

	@Override
	public List<Goods> list11() {
		 StringBuffer sb;
		 sb = new StringBuffer("FROM Goods where goods_type = '特色商品'");
		 List<Goods> lst = findByHQL(sb.toString());
	     return lst;
	}

	@Override
	public List<Goods> listall() {
		 StringBuffer sb;
		 sb = new StringBuffer("FROM Goods ");
		 List<Goods> lst = findByHQL(sb.toString());
	     return lst;
	}

	@Override
	public boolean tuijian(int goods_id) {
		StringBuffer sb;
		sb = new StringBuffer("update Goods set status =1").append(" WHERE goods_id = ").append(goods_id);
		try {
			this.executeHql(sb.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public List<Goods> list_tuijian() {
		 StringBuffer sb;
		 sb = new StringBuffer("FROM Goods where status =1");
		 List<Goods> lst = findByHQL(sb.toString());
	     return lst;
	}

}
