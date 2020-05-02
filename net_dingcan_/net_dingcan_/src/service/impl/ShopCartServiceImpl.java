package service.impl;

import java.util.ArrayList;
import java.util.List;

import dao.GoodsDAO;
import dao.ShopCartDAO;
import entity.Goods;
import entity.ShopCart;

import service.ShopCartService;

import net.sf.json.JSONArray;


public class ShopCartServiceImpl implements ShopCartService {

	private ShopCartDAO shopcartdao;
	private GoodsDAO goodsdao;
	@Override
	public boolean save(ShopCart cart) {
		return shopcartdao.save(cart);
	}
	public ShopCartDAO getShopcartdao() {
		return shopcartdao;
	}
	public void setShopcartdao(ShopCartDAO shopcartdao) {
		this.shopcartdao = shopcartdao;
	}
	@Override
	public String list(int userid) {
		// TODO Auto-generated method stub
		List<ShopCart> shopcartlst = shopcartdao.list(userid);
		List<ShopCart> shopcartlst2 = new ArrayList<ShopCart>();
		for(ShopCart cart:shopcartlst){
			if(cart.getStatus() ==0){
				Goods goods = goodsdao.load(cart.getGoods_id());
				cart.setGoods_image(goods.getGoods_image());
				cart.setGoods_name(goods.getGoods_name());
				cart.setGoods_price(goods.getGoods_price());
				shopcartlst2.add(cart);
			}
		
		}
		JSONArray jsonarr = JSONArray.fromObject(shopcartlst2);
		return jsonarr.toString();
		
	}
	public GoodsDAO getGoodsdao() {
		return goodsdao;
	}
	public void setGoodsdao(GoodsDAO goodsdao) {
		this.goodsdao = goodsdao;
	}
	@Override
	public boolean del(ShopCart cart) {
		// TODO Auto-generated method stub
		return shopcartdao.del(cart);
	}
	
	
	

	
}
