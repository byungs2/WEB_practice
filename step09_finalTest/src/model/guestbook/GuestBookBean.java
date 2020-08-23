package model.guestbook;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

@Entity
@NamedQuery(query = "select g from GuestBookBean g order by g.num desc", name = "GuestBookBean.FindAll")
@NamedQuery(query = "select g from GuestBookBean g WHERE g.num = :num and g.password = :password", name = "GuestBookBean.FindBynumPass")
@NamedQuery(query = "select g from GuestBookBean g WHERE g.num = :num", name = "GuestBookBean.FindBynum")
public class GuestBookBean implements Serializable{
	@Id
	@SequenceGenerator(name = "Guest_id_seq", sequenceName = "Guest_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Guest_id_seq")
	private int num;						// 글 번호
	private String title;					// 글 제목
	private String author;				// 글 작성자
	private String email;				// 글 작성자 전자메일
	private String content;				// 글 내용
	private String password;			// 글 비밀번호
	private String writeday;			// 글 작성일
	private int readnum;				// 글 조회수
    
	public GuestBookBean(){	}
	public GuestBookBean(int num){
		this.num=num;
	}
	public GuestBookBean(int num,String title, String author, String email, String content,String password) {
		this.num=num;
		this.title = title;
		this.author = author;
		this.email = email;
		this.content = content;
	   this.password=password;	
		
	}
	public GuestBookBean(int num,String title, String author, String email, String content) {
		this.num=num;
		this.title = title;
		this.author = author;
		this.email = email;
		this.content = content;
		
		
	}
	public GuestBookBean(String title, String author, String email, String content, String password) {
		this.title = title;
		this.author = author;
		this.email = email;
		this.content = content;
		this.password = password;
		
	}
	public GuestBookBean(String title, String author, String email, String content, String password, String writeday) {
		this.title = title;
		this.author = author;
		this.email = email;
		this.content = content;
		this.password = password;
		this.writeday = writeday;
	}
	public GuestBookBean(int num, String title, String author, String email, String content, String password, String writeday, int readnum) {
		this.num = num;
		this.title = title;
		this.author = author;
		this.email = email;
		this.content = content;
		this.password = password;
		this.writeday = writeday;
		this.readnum = readnum;
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getReadnum() {
		return readnum;
	}
	public void setReadnum(int readnum) {
		this.readnum = readnum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriteday() {
		return writeday;
	}
	public void setWriteday(String writeday) {
		this.writeday = writeday;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GuestBookBean [num=");
		builder.append(num);
		builder.append(", title=");
		builder.append(title);
		builder.append(", author=");
		builder.append(author);
		builder.append(", email=");
		builder.append(email);
		builder.append(", content=");
		builder.append(content);
		builder.append(", password=");
		builder.append(password);
		builder.append(", writeday=");
		builder.append(writeday);
		builder.append(", readnum=");
		builder.append(readnum);
		builder.append("]");
		return builder.toString();
	}
}