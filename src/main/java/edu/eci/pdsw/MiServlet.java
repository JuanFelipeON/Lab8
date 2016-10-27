/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw;


import java.io.IOException;
import java.io.Writer;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.eci.pdsw.stubs.datasourcestub.*;

/**
 *
 * @author 2092815
 */

@WebServlet(
        urlPatterns = "/JFOServlet"
)
public class MiServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Writer respWriter=resp.getWriter();
        int numCC = Integer.parseInt(req.getParameter("cc"));

        DataSourceStub info = DataSourceStub.getInstance();
        try{
            Client pepito = info.getClientById(numCC);
            resp.setStatus(200);
            String html = "<!DOCTYPE html>\n<html>\n<head>\n<title>Datos del cliente</title>\n</head>\n<body>\n<table>\n<tr>\n<td>Nombre:</td><td>"+pepito.getName()+"</td>\n</tr><tr>\n<td>Cedula:</td><td>"+req.getParameter("cc")+"</td>\n</tr><tr>\n<td>Salario:</td><td>"+Integer.toString(pepito.getSallary())+"</td>\n</tr><tr>\n<td>Direccion:</td><td>"+pepito.getAddress()+"</td>\n</tr><tr>\n<td>Email:</td><td>"+pepito.getEmail()+"</td>\n</tr>\n</table></body>\n</html>";
            respWriter.write(html);
            respWriter.flush();
        }catch(ClientNotFoundException e){
            resp.setStatus(404);
            respWriter.write("CLiente no existe con el identificador dado");
            
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Writer respWriter=resp.getWriter();
        int numCC = Integer.parseInt(req.getParameter("cc"));

        DataSourceStub info = DataSourceStub.getInstance();
        try{
            Client pepito = info.getClientById(numCC);
            resp.setStatus(200);
            String html = "<!DOCTYPE html>\n<html>\n<head>\n<title>Datos del cliente</title>\n</head>\n<body>\n<table>\n<tr>\n<td>Nombre:</td><td>"+pepito.getName()+"</td>\n</tr><tr>\n<td>Cedula:</td><td>"+req.getParameter("cc")+"</td>\n</tr><tr>\n<td>Salario:</td><td>"+Integer.toString(pepito.getSallary())+"</td>\n</tr><tr>\n<td>Direccion:</td><td>"+pepito.getAddress()+"</td>\n</tr><tr>\n<td>Email:</td><td>"+pepito.getEmail()+"</td>\n</tr>\n</table></body>\n</html>";
            respWriter.write(html);
            respWriter.flush();
        }catch(ClientNotFoundException e){
            resp.setStatus(404);
            respWriter.write("CLiente no existe con el identificador dado");
            
        }    
    } 
}