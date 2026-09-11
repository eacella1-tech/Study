package dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StudentsDTO {

	private int id;
	private String name;
	private int kor;
	private int eng;
	private int math;
//	private String regdate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

//	public String getRegdate() {
//		return regdate;
//	}
//
//	public void setRegdate(String regdate) {
//		this.regdate = regdate;
//	}

	public StudentsDTO(int id, String name, int kor, int eng, int math) {
		this.id = id;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public StudentsDTO(int id, int kor, int eng, int math) {
		this.id = id;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
//	public String getFormatTime() {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
//		return sdf.format(new Date(regdate));
//	}

}
