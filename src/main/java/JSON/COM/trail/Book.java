package JSON.COM.trail;

import java.util.ArrayList;
import java.util.List;

public class Book {
	private int idbn;
	private String title;
	private List<String> catogery = new ArrayList<>();
	private Authour author;
	private Editior editor;
	public int getIdbn() {
		return idbn;
	}
	public void setIdbn(int idbn) {
		this.idbn = idbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<String> getCatogery() {
		return catogery;
	}
	public void setCatogery(List<String> catogery) {
		this.catogery = catogery;
	}
	public Authour getAuthor() {
		return author;
	}
	public void setAuthor(Authour author) {
		this.author = author;
	}
	public Editior getEditor() {
		return editor;
	}
	public void setEditor(Editior editor) {
		this.editor = editor;
	}

}
