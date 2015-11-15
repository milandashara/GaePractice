package com.testjava.api;

import javax.inject.Named;

import com.google.api.server.spi.config.AnnotationBoolean;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;

import entity.Message;

@Api(version = "v1", description = "Sample API", name = "helloworld", resource = "message")
public class HelloWorld {
	
	
	//http://localhost:8888/_ah/api/helloworld/v1/helloworld/adasd
	@ApiMethod(name = "sayHelloWorld", path = "helloworld/{Name}", httpMethod = ApiMethod.HttpMethod.GET)
	public Message sayHelloWorld(@Named("Name") String name) {
		Message message = new Message();
		message.setName(name);
		return message;
	}
}
