package com.ysdpk.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ysdpk.model.LuckyBoy;
import com.ysdpk.model.Message;
import com.ysdpk.utils.LuckyNumberUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "api.RotateServlet",urlPatterns = "/api/rotate")
public class RotateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //编码
        response.setHeader("Content-type", "application/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        //输出流
        PrintWriter printWriter=response.getWriter();

        //java Obejct转Json
        ObjectMapper objectMapper=new ObjectMapper();

        //全局变量servletContext
        ServletContext servletContext=this.getServletContext();

        //返回信息
        Message message=new Message();

        List<LuckyBoy> luckyBoyList=(ArrayList<LuckyBoy>)servletContext.getAttribute("luckyBoyList");
        if (luckyBoyList==null){
            luckyBoyList=new ArrayList<LuckyBoy>();
            servletContext.setAttribute("luckyBoyList",luckyBoyList);
        }
        int num= LuckyNumberUtil.generate();
        if (num==-1){

            message.setCode(-1);
            message.setLuckyBoys(luckyBoyList);

            printWriter.print(objectMapper.writeValueAsString(message));
        }else if (num==1){
            LuckyBoy luckyBoy=new LuckyBoy();
            luckyBoy.setHost(request.getRemoteHost());
            luckyBoy.setGrade("一等奖");
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yy/MM/dd HH:mm");
            luckyBoy.setDate(simpleDateFormat.format(new Date()));
            luckyBoyList.add(luckyBoy);
            message.setCode(num);
            message.setLuckyBoys(luckyBoyList);
            printWriter.print(objectMapper.writeValueAsString(message));
        }else if (num==2){
            LuckyBoy luckyBoy=new LuckyBoy();
            luckyBoy.setHost(request.getRemoteHost());
            luckyBoy.setGrade("二等奖");
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yy/MM/dd HH:mm");
            luckyBoy.setDate(simpleDateFormat.format(new Date()));
            luckyBoyList.add(luckyBoy);
            message.setCode(num);
            message.setLuckyBoys(luckyBoyList);
            printWriter.print(objectMapper.writeValueAsString(message));
        }else {
            LuckyBoy luckyBoy=new LuckyBoy();
            luckyBoy.setHost(request.getRemoteHost());
            luckyBoy.setGrade("三等奖");
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yy/MM/dd HH:mm");
            luckyBoy.setDate(simpleDateFormat.format(new Date()));
            luckyBoyList.add(luckyBoy);
            message.setCode(num);
            message.setLuckyBoys(luckyBoyList);
            printWriter.print(objectMapper.writeValueAsString(message));
        }

    }

}
