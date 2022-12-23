package new1.kcs.appIntro;

import jakarta.json.bind.annotation.JsonbAnnotation;



@JsonbAnnotation
public class appDetails {
	private int id;
	private String desc;
	private String title;
	private String img_url;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	@Override
	public String toString() {
		return "appDetails [id=" + id + ", desc=" + desc + ", title=" + title + ", img_url=" + img_url + "]";
	}
}