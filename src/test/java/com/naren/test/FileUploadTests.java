/**
 * 
 */
package com.naren.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author ntanwa
 *
 */
public class FileUploadTests {
	@Autowired
	private MockMvc mvc;

	@Test
	public void shouldSaveUploadedFile() throws Exception {
		MockMultipartFile multipartFile = new MockMultipartFile("file", "D:\\Workspace\\springBoot\\src\\main\\resources\\DB.sql", "text/plain",
				"Spring Framework".getBytes());
		this.mvc.perform(fileUpload("/").file(multipartFile)).andExpect(status().isFound())
				.andExpect(header().string("Location", "/"));

	}
}
