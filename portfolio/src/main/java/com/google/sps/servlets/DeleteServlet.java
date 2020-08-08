package com.google.sps.servlets;

import com.google.appengine.api.datastore.DatastoreFailureException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.SortDirection;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Servlet that handles the deletion of comments through a post request */
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet{
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Query query = new Query("Comment");
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        PreparedQuery results = datastore.prepare(query);
        for (Entity commentEntity : results.asIterable()){
            try {
                datastore.delete(commentEntity.getKey());
            } 
            catch(DatastoreFailureException exception) {
                System.out.println(exception.toString());
            }
        } 
        response.sendRedirect("/comments.html");
    }
}