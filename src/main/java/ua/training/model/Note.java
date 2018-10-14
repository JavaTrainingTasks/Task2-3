package ua.training.model;

/**
  *It is a note wich will get to notebook
  *
  **/
 public class Note {
	private int id = 0;
	private String surname;
	private String name;
	private String patronymic;
	private String nickname;
	private String comment;
	private String mobileTelephone;
	private String email;

	public Note() {id++;}

	public void setFildWithType(String input, InputDataType type) {
		switch (type) {
			case NAME:
				setName(input);
				break;
			case SURNAME:
				setSurname(input);
				break;
			case PATRONYMIC:
				setPatronymic(input);
				break;
			case TELEPHONE:
				setMobileTelephone(input);
				break;
			case COMMENT:
				setComment(input);
				break;
			case NICKNAME:
				setNickname(input);
				break;
		}
	}
	private void setSurname(String surname) {
		this.surname = surname;
	}

	private void setName(String name) {
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

	public int getId(){
		return  id;
	}

	public String getFieldWithType(InputDataType type) {
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
		case NICKNAME:
			output = getNickname();
			break;
	}
	return output;
}
	@Override
	public String toString() {
		String output = "";
		for (InputDataType type: InputDataType.values()) {
			output = output + type.toString().toLowerCase() + ":" + getFieldWithType(type) + "\n";
		}
		return output;
	}


}
