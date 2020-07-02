package com.javen.config;



import com.javen.Http.HttpRequest;

import net.sf.json.JSONObject;

public class iptest {

	public static String ip2addr(String ip) {
		try {
		String str = HttpRequest.sendPost("http://ip.taobao.com/service/getIpInfo.php?", "ip=" + ip);
		JSONObject js=JSONObject.fromObject(str);
		JSONObject es=JSONObject.fromObject(js.get("data"));
		
		return es.toString();
		}catch(Exception e){
			return "";
		}
	}

}
