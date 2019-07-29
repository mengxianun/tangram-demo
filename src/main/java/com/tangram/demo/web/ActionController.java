package com.tangram.demo.web;

import java.nio.charset.StandardCharsets;
import java.sql.SQLException;

import org.h2.tools.RunScript;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.mengxianun.core.DataResultSet;
import com.github.mengxianun.core.Translator;
import com.google.common.io.Resources;

@RestController
public class ActionController {

	@Autowired
	private Translator translator;

	@PostMapping("/action")
	public Object action(@RequestBody String requestJson) {
		DataResultSet dataResultSet = translator.translate(requestJson);
		return dataResultSet.getData();
	}

	@PostMapping("/reset")
	public void reset() {
		String url = "jdbc:h2:mem:test";
		String username = "test";
		String password = "";
		try {
			String schemaPath = Resources.getResource("db/schema.sql").getPath();
			String dataPath = Resources.getResource("db/data.sql").getPath();
			RunScript.execute(url, username, password, schemaPath, StandardCharsets.UTF_8, false);
			RunScript.execute(url, username, password, dataPath, StandardCharsets.UTF_8, false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
