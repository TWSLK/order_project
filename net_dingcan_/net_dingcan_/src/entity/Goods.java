package entity;

import java.io.File;
import java.io.Serializable;

public class Goods implements Serializable {
	private int goods_id;
	private float goods_price;
	private float goods_marketprice;
	private String goods_name;
	private String goods_image;
	private int goods_sale_num;
	private int evaluation_good_star;
	private int evaluation_count;
	private boolean group_flag;
	private boolean xianshi_flag;
	private String goods_image_url;
	private String goods_type;
	private int status;
	private File file;
	private String fileFileName;
	
	

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public int getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(int goodsId) {
		goods_id = goodsId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public float getGoods_price() {
		return goods_price;
	}

	public void setGoods_price(float goodsPrice) {
		goods_price = goodsPrice;
	}

	public float getGoods_marketprice() {
		return goods_marketprice;
	}

	public void setGoods_marketprice(float goodsMarketprice) {
		goods_marketprice = goodsMarketprice;
	}

	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goodsName) {
		goods_name = goodsName;
	}

	public String getGoods_image() {
		return goods_image;
	}

	public void setGoods_image(String goodsImage) {
		goods_image = goodsImage;
	}

	public int getGoods_sale_num() {
		return goods_sale_num;
	}

	public void setGoods_sale_num(int goodsSaleNum) {
		goods_sale_num = goodsSaleNum;
	}

	public int getEvaluation_good_star() {
		return evaluation_good_star;
	}

	public void setEvaluation_good_star(int evaluationGoodStar) {
		evaluation_good_star = evaluationGoodStar;
	}

	public int getEvaluation_count() {
		return evaluation_count;
	}

	public void setEvaluation_count(int evaluationCount) {
		evaluation_count = evaluationCount;
	}

	public boolean isGroup_flag() {
		return group_flag;
	}

	public void setGroup_flag(boolean groupFlag) {
		group_flag = groupFlag;
	}

	public boolean isXianshi_flag() {
		return xianshi_flag;
	}

	public void setXianshi_flag(boolean xianshiFlag) {
		xianshi_flag = xianshiFlag;
	}

	public String getGoods_image_url() {
		return goods_image_url;
	}

	public void setGoods_image_url(String goodsImageUrl) {
		goods_image_url = goodsImageUrl;
	}

	public String getGoods_type() {
		return goods_type;
	}

	public void setGoods_type(String goods_type) {
		this.goods_type = goods_type;
	}
	

}
