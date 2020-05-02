package service.impl;


import java.util.List;

import dao.GoodsDAO;
import entity.Goods;

import service.GoodsService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class GoodsServiceImpl implements GoodsService {
	private GoodsDAO goodsdao;

	@Override
	public String detail(int goodsId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(Goods goods) {
		// TODO Auto-generated method stub
		return goodsdao.save(goods);
	}

	public GoodsDAO getGoodsdao() {
		return goodsdao;
	}

	public void setGoodsdao(GoodsDAO goodsdao) {
		this.goodsdao = goodsdao;
	}

	@Override
	public List<Goods> search(String name) {
		// TODO Auto-generated method stub
		return goodsdao.list(name);
	}

	@Override
	public Goods load(int goodsId) {
		// TODO Auto-generated method stub
		return goodsdao.load(goodsId);
	}

	@Override
	public void del(Goods goods) {
		// TODO Auto-generated method stub
		goodsdao.del(goods);
	}

	@Override
	public String loadAllJson() {
		List<Goods> list = goodsdao.list(null);
		if(list.size()>0){
			JSONArray jsonarr = JSONArray.fromObject(list);
			return jsonarr.toString();
		}else{
			return null;
		}
	}

	@Override
	public String detailjson(String goodsId) {
		// TODO Auto-generated method stub
		Integer goodid= Integer.parseInt(goodsId);
		Goods good = this.load(goodid);
		if(good != null){
			JSONObject obj = JSONObject.fromObject(good);
			return obj.toString();
		}else{
			return null;
		}
		
	}

	@Override
	public String loadAllJson2(String keyword) {
		List<Goods> list = goodsdao.list(keyword);
		if(list.size()>0){
			JSONArray jsonarr = JSONArray.fromObject(list);
			return jsonarr.toString();
		}else{
			return null;
		}
	}

	@Override
	public String list0() {
		List<Goods> list = goodsdao.list0();
		if(list.size()>0){
			JSONArray jsonarr = JSONArray.fromObject(list);
			return jsonarr.toString();
		}else{
			return null;
		}
	}

	@Override
	public String list1() {
		List<Goods> list = goodsdao.list1();
		if(list.size()>0){
			JSONArray jsonarr = JSONArray.fromObject(list);
			return jsonarr.toString();
		}else{
			return null;
		}
	}

	@Override
	public String list2() {
		List<Goods> list = goodsdao.list2();
		if(list.size()>0){
			JSONArray jsonarr = JSONArray.fromObject(list);
			return jsonarr.toString();
		}else{
			return null;
		}
	}

	@Override
	public String list3() {
		List<Goods> list = goodsdao.list3();
		if(list.size()>0){
			JSONArray jsonarr = JSONArray.fromObject(list);
			return jsonarr.toString();
		}else{
			return null;
		}
	}

	@Override
	public String list4() {
		List<Goods> list = goodsdao.list4();
		if(list.size()>0){
			JSONArray jsonarr = JSONArray.fromObject(list);
			return jsonarr.toString();
		}else{
			return null;
		}
	}

	@Override
	public String list5() {
		List<Goods> list = goodsdao.list5();
		if(list.size()>0){
			JSONArray jsonarr = JSONArray.fromObject(list);
			return jsonarr.toString();
		}else{
			return null;
		}
	}

	@Override
	public String list6() {
		List<Goods> list = goodsdao.list6();
		if(list.size()>0){
			JSONArray jsonarr = JSONArray.fromObject(list);
			return jsonarr.toString();
		}else{
			return null;
		}
	}

	@Override
	public String list7() {
		List<Goods> list = goodsdao.list7();
		if(list.size()>0){
			JSONArray jsonarr = JSONArray.fromObject(list);
			return jsonarr.toString();
		}else{
			return null;
		}
	}

	@Override
	public String list8() {
		List<Goods> list = goodsdao.list8();
		if(list.size()>0){
			JSONArray jsonarr = JSONArray.fromObject(list);
			return jsonarr.toString();
		}else{
			return null;
		}
	}

	@Override
	public String list9() {
		List<Goods> list = goodsdao.list9();
		if(list.size()>0){
			JSONArray jsonarr = JSONArray.fromObject(list);
			return jsonarr.toString();
		}else{
			return null;
		}
	}

	@Override
	public String list10() {
		List<Goods> list = goodsdao.list10();
		if(list.size()>0){
			JSONArray jsonarr = JSONArray.fromObject(list);
			return jsonarr.toString();
		}else{
			return null;
		}
	}

	@Override
	public String list11() {
		List<Goods> list = goodsdao.list11();
		if(list.size()>0){
			JSONArray jsonarr = JSONArray.fromObject(list);
			return jsonarr.toString();
		}else{
			return null;
		}
	}

	@Override
	public String listall() {
		List<Goods> list = goodsdao.listall();
		if(list.size()>0){
			JSONArray jsonarr = JSONArray.fromObject(list);
			return jsonarr.toString();
		}else{
			return null;
		}
	}

	@Override
	public boolean tuijian(int goods_id) {
		// TODO Auto-generated method stub
		return goodsdao.tuijian(goods_id);
	}

	@Override
	public String list_tuijian() {
		List<Goods> list = goodsdao.list_tuijian();
		if(list.size()>0){
			JSONArray jsonarr = JSONArray.fromObject(list);
			return jsonarr.toString();
		}else{
			return null;
		}
	}

}
