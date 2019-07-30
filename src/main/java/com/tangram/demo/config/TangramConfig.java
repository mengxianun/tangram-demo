package com.tangram.demo.config;

import com.github.mengxianun.core.DefaultTranslator;
import com.github.mengxianun.core.Translator;

//@Configuration
public class TangramConfig {

	//	@Bean
	public Translator translator() {
		return new DefaultTranslator();
	}

}
