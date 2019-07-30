package com.tangram.demo.web;

//@RestController
public class ActionController {

	//	@Autowired
	//	private Translator translator;
	//
	//	@PostMapping("/action")
	//	public Object action(@RequestBody String requestJson) {
	//		DataResultSet dataResultSet = translator.translate(requestJson);
	//		return dataResultSet.getData();
	//	}
	//
	//	@PostMapping("/reset")
	//	public void reset() {
	//		String url = "jdbc:h2:mem:test";
	//		String username = "test";
	//		String password = "";
	//		try {
	//			String schemaPath = Resources.getResource("db/schema.sql").getPath();
	//			String dataPath = Resources.getResource("db/data.sql").getPath();
	//			RunScript.execute(url, username, password, schemaPath, StandardCharsets.UTF_8, false);
	//			RunScript.execute(url, username, password, dataPath, StandardCharsets.UTF_8, false);
	//		} catch (SQLException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		}
	//	}

}
