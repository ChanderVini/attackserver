/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.attacklabs;

import java.io.*;
import java.net.*;

import java.util.*;
import java.util.Enumeration;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author csingh
 */
public class AttackServlet extends HttpServlet {
   
    /** 
    * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    * @param request servlet request
    * @param response servlet response
    */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        Enumeration parameterNamesEnum = request.getParameterNames();
        ServletContext context = getServletContext();
        Object sessionvals = context.getAttribute("SESSIONVAL");
        ArrayList sessionValsAL = new ArrayList ();
        if (sessionvals != null) {
            String[] sessionVals = (String[]) sessionvals;
            sessionValsAL = new ArrayList (Arrays.asList (sessionVals));
        }
        while (parameterNamesEnum.hasMoreElements()) {
            String parameterName = (String) parameterNamesEnum.nextElement();
            String paramvalue = request.getParameter(parameterName);
            String sessionval = parameterName + ":" + paramvalue;
            sessionValsAL.add (sessionval);
        }
        String[] sessionvalues = (String[]) sessionValsAL.toArray(new String [sessionValsAL.size()]);
        sessionValsAL = null;
        context.setAttribute("SESSIONVAL", sessionvalues);        
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
    * Handles the HTTP <code>GET</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
    * Handles the HTTP <code>POST</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
    * Returns a short description of the servlet.
    */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
