package service.impl;


import java.util.List;

import dao.DeskDAO;
import entity.Desk;

import service.DeskService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class DeskServiceImpl implements DeskService {
	private DeskDAO deskdao;



	@Override
	public boolean save(Desk desk) {
		// TODO Auto-generated method stub
		return deskdao.save(desk);
	}


	public DeskDAO getDeskdao() {
		return deskdao;
	}


	public void setDeskdao(DeskDAO deskdao) {
		this.deskdao = deskdao;
	}



	@Override
	public Desk load(int goodsId) {
		// TODO Auto-generated method stub
		return deskdao.load(goodsId);
	}

	@Override
	public void del(Desk desk) {
		// TODO Auto-generated method stub
		deskdao.del(desk);
	}

	@Override
	public String loadAllJson() {
		List<Desk> list = deskdao.list();
		if(list.size()>0){
			JSONArray jsonarr = JSONArray.fromObject(list);
			return jsonarr.toString();
		}else{
			return null;
		}
	}


	@Override
	public List<Desk> list() {
		// TODO Auto-generated method stub
		return deskdao.list();
	}



}
