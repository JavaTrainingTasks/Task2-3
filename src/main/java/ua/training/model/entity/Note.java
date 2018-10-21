package ua.training.model.entity;

import ua.training.model.DataType;

import java.time.LocalDateTime;

/**
 * It is a component of {@linkplain Notebook}
 * Created 15.10.18
 * @author or Yaroslav Kratt

 */
 public class Note {
	private  static int id;
	private String surname;
	private String name;
	private String patronymic;
	private String nickname;
	private String comment;
	private String mobileTelephone;
	private String email;
	private String date;

	public Note(String name, String surname, String patronymic, String nickname, String comment, String mobileTelephone, String email) {
		this.name = name;
		this.surname = surname;
		this.patronymic = patronymic;
		this.nickname = nickname;
		this.comment = comment;
		this.mobileTelephone = mobileTelephone;
		this.email = email;
		id++;
		 setDateNow();
	}
	public Note(){}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

	public void setMobileTelephone(String mobileTelephone) {
		this.mobileTelephone = mobileTelephone;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void setId(int id) {
		Note.id = id;
	}


	public void setDateNow(){
	    this.date = LocalDateTime.now().toString();

	}

	public void setDate(String date) {
		this.date = date;
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

	public int getId(){
		return  id;
	}
	public String getDate() {
		return this.date;
	}


	/**
	 * invoke necessary method due to type of input
	 * @param input validated data from console
	 * @param type type of the input data
	 */


	/**
	 * get the definite field of note due to type of data
	 * @param type data type
	 * @return value of data type
	 */
	public String getFieldWithType(DataType type) {
		String output = null;
	switch (type) {
		case NAME:
			output = getName();
			break;
		case SURNAME:
			output = getSurname();
			break;
		case PATRONYMIC:
			output = getPatronymic();
			break;
		case TELEPHONE:
			output = getMobileTelephone();
			break;
		case COMMENT:
			output = getComment();
			break;
		case DATE:
			output = getDate();
			break;
		case NICKNAME:
			output = getNickname();
			break;
		case EMAIL:
			output = getEmail();
			break;
        case ID:
            output = String.valueOf(getId());
	}
	return output;
}


	/**
	 *
	 * @return string with all fields of note
	 */
	@Override
	public String toString() {
		String output = "";
		for (DataType type: DataType.values()) {
			output = output + type.toString().toLowerCase() + ":" + getFieldWithType(type) + "\n";
		}
		return output;
	}


}
