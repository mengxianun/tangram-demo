package com.tangram.demo;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.h2.tools.RunScript;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.mengxianun.core.DataResultSet;
import com.github.mengxianun.core.DefaultTranslator;
import com.github.mengxianun.core.Translator;
import com.google.common.io.Resources;

@RestController
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public Translator translator() {
		return new DefaultTranslator();
	}

	@Autowired
	private Translator translator;

	@PostMapping("/action")
	public Object action(@RequestBody String requestJson) {
		DataResultSet dataResultSet = translator.translate(requestJson);
		return dataResultSet.getData();
	}

	@Value("classpath:examples/*")
	private Resource[] resources;

	@GetMapping("/examples")
	public Map<String, String> examples() throws IOException {
		Map<String, String> examples = new HashMap<>();
		for (int i = 0; i < resources.length; i++) {
			Resource resource = resources[i];
			String title = resource.getFilename().split("\\.")[0];
			String content = Resources.toString(resource.getURL(), StandardCharsets.UTF_8);
			examples.put(title, content);
		}
		return examples;
	}

	@PostMapping("/reset")
	public void reset() throws SQLException {
		String url = "jdbc:h2:mem:test";
		String username = "test";
		String password = "";
		String schemaPath = Resources.getResource("db/schema.sql").getPath();
		String dataPath = Resources.getResource("db/data.sql").getPath();
		RunScript.execute(url, username, password, schemaPath, StandardCharsets.UTF_8, false);
		RunScript.execute(url, username, password, dataPath, StandardCharsets.UTF_8, false);
	}

}
