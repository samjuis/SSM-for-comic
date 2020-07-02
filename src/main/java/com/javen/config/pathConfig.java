package com.javen.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class pathConfig {
	@Value("${picURL}")
	public String picURL;
	@Value("${msgPath}")
	public String msgPath;

}
