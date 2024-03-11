package com.okta.example.autenticacion.login.model;

import java.util.List;

import lombok.Data;

@Data
public class DatosLogin {

	private String name;
	private String email;
	private List<String> attributes;
}
