package com.czhappy.commonindexdemo.model;

public class ImageModel
{
	public int id;
	public String imgUrl;
	public String desc;
	public int type;

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ImageModel()
	{
		super();
	}

	public ImageModel(int id, String desc, int type)
	{
		super();
		this.id = id;
		this.desc = desc;
		this.type = type;
	}

	@Override
	public String toString()
	{
		return "ImageModel [id=" + id + ", imgUrl=" + imgUrl + ", desc=" + desc + ", type=" + type + "]";
	}
}
