package id.wisataone.api;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import id.wisataone.model.UserCtrl;

@WebServlet(
    name = "HelloAppEngine",
    urlPatterns = {"/hello"}
)
public class HelloAppEngine extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException {

    response.setContentType("text/plain");
    response.setCharacterEncoding("UTF-8");
    
    // buat 2 user baru
    new UserCtrl().createUser("Usop", "usop@gmail.com");
    new UserCtrl().createUser("Sanji", "sanji@gmail.com");
    response.getWriter().print("Hello App Engine!\r\n");

  }
}