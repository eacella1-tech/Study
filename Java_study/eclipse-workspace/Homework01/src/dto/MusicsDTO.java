package dto;

import java.text.SimpleDateFormat;

public class MusicsDTO {
	private int id;
	private String title;
	private String singer;
//	private long reg_date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

//	public long getReg_date() {
//		return reg_date;
//	}
//
//	public void setReg_date(long reg_date) {
//		this.reg_date = reg_date;
//	}
//
//	public String getFormatTime() {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
//		return sdf.format(this.reg_date);
//	}

	public MusicsDTO(int id, String title, String singer) {
		this.id = id;
		this.title = title;
		this.singer = singer;
	}

	public MusicsDTO() {
		super();
	}

}
