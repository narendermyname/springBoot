/**
 * 
 */
package com.naren.rest.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.naren.rest.exception.GenericException;

/**
 * @author ntanwa
 *
 */
@RestController
public class HomeController {

	private static final Logger LOG = Logger.getLogger(HomeController.class);
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@GetMapping("/")
	public void home1(HttpServletRequest req, HttpServletResponse resp) {
		try {
			resp.sendRedirect("/index.html");
		} catch (IOException e) {
			System.out.println("Error : " + e.getMessage());
		}
		;
	}

	@GetMapping("/home")
	public String home() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String name = user.getUsername();
		return "Hello " + name + "!";
	}

	@GetMapping("/admin")
	public String admin() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		return "admin " + name;
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

	@PostMapping("/upload")
	public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
		try {
			if (!file.isEmpty()) {
				LOG.debug("File "+file.getOriginalFilename()+" received");
				try {
					byte[] bytes = file.getBytes();
					BufferedOutputStream stream = new BufferedOutputStream(
							new FileOutputStream(new File("D://" + file.getOriginalFilename())));
					stream.write(bytes);
					stream.close();
					return "You successfully uploaded " + file.getOriginalFilename() + " into " + file.getOriginalFilename()
							+ "-uploaded !";
				} catch (Exception e) {
					return "You failed to upload " + file.getOriginalFilename() + " => " + e.getMessage();
				}
			} else {
				return "You failed to upload " + file.getOriginalFilename() + " because the file was empty.";
			}
		} catch (Exception ee) {
			System.out.println("Error : "+ee.getMessage());
		}
		return "Success...";
	}

	@RequestMapping("/resource")
	public Map<String, Object> resource() {
		LOG.info("Resource callled ----------------------------");
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("id", UUID.randomUUID().toString());
		model.put("content", "Hello World");
		return model;
	}
}
