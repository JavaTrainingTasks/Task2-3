package ua.training.controllers;

import java.util.regex.Pattern;

/**
* Regular exprassions for validation input data {@linkplain ua.training.controllers.Controller} use them to validate input data
**/
public  final class RegExp {
	public static final String NAME = "^[\\p{L} .'-]+$";
	public static final String TELEPHONE = "(\\s*)?(\\+)?([- _():=+]?\\d[- _():=+]?){10,14}(\\s*)?";
	public static final String EMAIL ="\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b";
	public static final String NICKNAME = "^[a-z0-9_-]{3,15}$";


}
