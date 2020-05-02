package entity;

public class ShopCart {
	private int id;
	private int goods_id;
	private int user_id;
	private int goods_num;
	private int status;
	private String goods_name;
	private float goods_price;
	private String goods_image;
	private String table_name;

	public ShopCart() {
		super();
	}

	public ShopCart(int goodsId, int userId, int goodsNum, int status,String table_name) {
		super();
		goods_id = goodsId;
		user_id = userId;
		goods_num = goodsNum;
		this.status = status;
		this.table_name = table_name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(int goodsId) {
		goods_id = goodsId;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int userId) {
		user_id = userId;
	}

	public int getGoods_num() {
		return goods_num;
	}

	public void setGoods_num(int goodsNum) {
		goods_num = goodsNum;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goodsName) {
		goods_name = goodsName;
	}

	public float getGoods_price() {
		return goods_price;
	}

	public void setGoods_price(float goodsPrice) {
		goods_price = goodsPrice;
	}

	public String getGoods_image() {
		return goods_image;
	}

	public void setGoods_image(String goodsImage) {
		goods_image = goodsImage;
	}

	public String getTable_name() {
		return table_name;
	}

	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}

}
