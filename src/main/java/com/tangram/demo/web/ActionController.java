package com.tangram.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.mengxianun.core.DataResultSet;
import com.github.mengxianun.core.Translator;

@RestController
public class ActionController {

	@Autowired
	private Translator translator;

	@PostMapping("/action")
	public Object action(@RequestBody String requestJson) {
		DataResultSet dataResultSet = translator.translate(requestJson);
		return dataResultSet.getData();
	}

}
