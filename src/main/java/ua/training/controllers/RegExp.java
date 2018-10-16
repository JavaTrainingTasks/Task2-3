package ua.training.controllers;

import java.util.regex.Pattern;

/**
* Regular exprassions for validation input data {@linkplain ua.training.controllers.Controller} use them to validate input data
**/
public  final class RegExp {
	public static final String NAME = "^[\\p{L} .'-]+$";
	public static final String TELEPHONE = "(\\s*)?(\\+)?([- _():=+]?\\d[- _():=+]?){10,14}(\\s*)?";
	public static final String EMAIL ="^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$";
	public static final String NICKNAME = "^[a-z0-9_-]{3,15}$";


}
