package ua.training.model;
 /**
  *It is a note wich will get to notebook
  *
  **/
public class Note {
	private String surname;
	private String name;
	private String patronymic;
	private String nickname;
	private String comment;
	private String mobileTelephone;
	private String email;

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setMobileTelephone(String mobileTelephone) {
		this.mobileTelephone = mobileTelephone;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getSurname() {
		return surname;
	}

	public String getName() {
		return name;
	}

	public String getPatronymic() {
		return patronymic;
	}

	public String getNickname() {
		return nickname;
	}

	public String getMobileTelephone() {
		return mobileTelephone;
	}

	public String getComment() {
		return comment;
	}

	public String getEmail() {
		return email;
	}
}
