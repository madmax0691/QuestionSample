package com.mkaz;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuestionServlet extends HttpServlet {
    static final int CAR_QUESTION_YES = 0;
    static final int CAR_QUESTION_NO = 1;
    static final int DOG_QUESTION_YES = 2;
    static final int DOG_QUESTION_NO = 3;

    static final String TEMPLATE = "<html>" +
            "<head><title>mkaz.com</title></head>" +
            "<body><h1>%s</h1></body></html>";

    final int[] results = new int[4];

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String q1 = req.getParameter("car");
        final String q2 = req.getParameter("dog");

        final int idx1 = "yes".equals(q1) ? CAR_QUESTION_YES : CAR_QUESTION_NO;
        final int idx2 = "yes".equals(q2) ? DOG_QUESTION_YES : DOG_QUESTION_NO;

        results[idx1]++;
        results[idx2]++;

        String res = "<p>Cars: yes = " + results[CAR_QUESTION_YES] + ", no = " +
                results[CAR_QUESTION_NO] + "</p>";
        res += "<p>Dogs: yes = " + results[DOG_QUESTION_YES] + ", no = " +
                results[DOG_QUESTION_NO] + "</p>";

        resp.getWriter().println(String.format(TEMPLATE, res));
    }
}
