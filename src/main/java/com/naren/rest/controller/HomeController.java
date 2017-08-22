/**
 * 
 */
package com.naren.rest.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.naren.rest.exception.GenericException;

/**
 * @author ntanwa
 *
 */
@RestController
public class HomeController {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@GetMapping("/")
	public void home1(HttpServletRequest req, HttpServletResponse resp) {
		try {
			resp.sendRedirect("/index.html");
		} catch (IOException e) {
			System.out.println("Error : "+e.getMessage());
		};
	}

	@GetMapping("/home")
	public String home() {
		return "home";
	}

	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}

	@GetMapping("/user")
	public String user() {
		return "user";
	}

	@GetMapping("/about")
	public String about() {
		return "about";
	}

	@GetMapping("/protected")
	public void error403(HttpServletRequest req) throws GenericException {
		throw new GenericException("access to this url " + req.getRequestURL() + " not allows");
	}

	@GetMapping("/encode/{encodeStr}")
	public String encode(@PathVariable(name = "encodeStr") String encodeString) {
		Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		if (bCryptPasswordEncoder == null)
			return encoder.encodePassword(encodeString, "NARENDER_UIII_@#$$%$$$$");
		else
			return bCryptPasswordEncoder.encode(encodeString);
	}

	@GetMapping("/logout")
	public String logout() {
		return "user succefully logout.";
	}
}
