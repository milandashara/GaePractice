package com.testjava;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

@SuppressWarnings("serial")
public class TestjavaServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		

		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
		Entity userEntity = new Entity("Person", 1);
		userEntity.setProperty("firstName", "milan");
		userEntity.setProperty("lastName", "ashara");
		ds.put(userEntity);
		
		resp.setContentType("text/plain");
		resp.getWriter().println("User Entity Saved");
		
	}
}
