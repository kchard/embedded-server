package com.kevinchard.server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.webapp.WebAppContext;


public class EmbeddedServer {

	public static void main(String[] args) throws Exception {
		
		Server server = new Server(8080);
		 
        WebAppContext context = new WebAppContext();
        
        context.setBaseResource(Resource.newResource(EmbeddedServer.class.getClassLoader().getResource("webapp")));
        context.setDescriptor("WEB-INF/web.xml");
        context.setContextPath("/");
        context.setParentLoaderPriority(true);
 
        server.setHandler(context);
 
        server.start();
        server.join();
	}
}
