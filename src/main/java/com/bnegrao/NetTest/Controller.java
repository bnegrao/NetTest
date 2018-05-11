package com.bnegrao.NetTest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Controller {
	
	@RequestMapping(method = RequestMethod.GET, value = "ping")
	public Pong ping() {
		return new Pong();
	}

}
