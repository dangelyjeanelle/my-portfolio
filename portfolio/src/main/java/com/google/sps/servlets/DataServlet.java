// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.sps.servlets;

import java.util.*;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Servlet that returns some example content. TODO: modify this file to handle comments data */
@WebServlet("/data")
public class DataServlet extends HttpServlet {
    private ArrayList<String> message;

  @Override
  public void init() {
      message = new ArrayList<String>();
      message.add("Hello Dangely");
      message.add("This is a test");
      message.add("Have a nice day!");
  }

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String json = convertMsgtoJason(message);
    response.setContentType("application/json;");
    response.getWriter().println(json);
  }

  private String convertMsgtoJason(ArrayList<String> msg) {
      String json = "{";
    json += "\"line1\": ";
    json += "\"" + msg.get(0) + "\"";
    json += ", ";
    json += "\"line2\": ";
    json += "\"" + msg.get(1) + "\"";
    json += ", ";
    json += "\"line3\": ";
    json += "\"" + msg.get(2) + "\"";
    json += "}";
    return json;
  }
}
