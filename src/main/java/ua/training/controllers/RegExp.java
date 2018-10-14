package ua.training.controllers;

import java.util.regex.Pattern;

/**
* Regular exprassions lie here, Controller use them to validate input data
**/
public  final class RegExp {
	public static final String NAME = "/^[a-z ,.'-]+$/i";
	public static final String telephone = "[1-9]\\d{2}-[1-9]\\d{2}-\\d{4}";
	public static final String email ="\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b";
	public static final String nickname = "^[a-z0-9_-]{3,15}$";


}
