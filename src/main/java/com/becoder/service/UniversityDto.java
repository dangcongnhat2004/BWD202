package com.becoder.service;
import org.hibernate.validator.constraints.NotBlank;
public class UniversityDto {
    @NotBlank
    private String username;

    @NotBlank
    private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UniversityDto(@NotBlank String username, @NotBlank String password) {
		super();
		this.username = username;
		this.password = password;
	}



    // constructors, getters, setters, ...
}
