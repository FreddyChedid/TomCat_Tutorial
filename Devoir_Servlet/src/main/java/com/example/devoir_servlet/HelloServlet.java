package com.example.devoir_servlet;

import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Bonjour! Veuillez entrer votre nom et prénom.";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");

        // Formulaire pour entrer le nom et prénom
        out.println("<form method='POST' action='/Devoir_Servlet_war_exploded/hello-servlet'>");
        out.println("Nom: <input type='text' name='nom'><br>");
        out.println("Prénom: <input type='text' name='prenom'><br>");
        out.println("<input type='submit' value='Envoyer'>");
        out.println("</form>");

        out.println("</body></html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");

        if (nom != null && prenom != null) {
            out.println("<h1>Bonjour, " + prenom + " " + nom + "!</h1>");
        } else {
            out.println("<h1>Nom et prénom non fournis.</h1>");
        }

        out.println("</body></html>");
    }

    public void destroy() {
    }
}
