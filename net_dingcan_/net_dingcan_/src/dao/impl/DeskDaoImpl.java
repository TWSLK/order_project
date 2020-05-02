package dao.impl;

import java.util.List;

import dao.DeskDAO;
import entity.Desk;


public class DeskDaoImpl extends BaseDAO implements DeskDAO {

	@Override
	public Desk load(int id) {
		StringBuffer sb = new StringBuffer("FROM Desk WHERE id = ").append(id);

		List<Desk> lst = findByHQL(sb.toString());
		if (lst.size() > 0) {
			return lst.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<Desk> list() {
		// TODO Auto-generated method stub
		StringBuffer sb;
		sb = new StringBuffer("FROM Desk");

		List<Desk> lst = findByHQL(sb.toString());
		return lst;
	}

	@Override
	public boolean save(Desk desk) {
		// TODO Auto-generated method stub
		return saveOrUpdate(desk);
	}

	@Override
	public boolean update(Desk desk) {
		// TODO Auto-generated method stub
		return saveOrUpdate(desk);
	}

	@Override
	public boolean del(Desk desk) {
		// TODO Auto-generated method stub
		this.delete(desk);
		return true;
	}

	@Override
	public boolean update0(String name) {
		StringBuffer sb = new StringBuffer(
				"update Desk set status =0 WHERE name = '").append(name)
				.append("'");
		try {
			this.executeHql(sb.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean update1(String name) {
		StringBuffer sb = new StringBuffer(
				"update Desk set status =1 WHERE name = '").append(name)
				.append("'");
		try {
			this.executeHql(sb.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

}
