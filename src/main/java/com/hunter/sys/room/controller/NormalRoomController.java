package com.hunter.sys.room.controller;import org.springframework.stereotype.Controller;import org.springframework.ui.ModelMap;import org.springframework.web.bind.annotation.RequestMapping;import javax.servlet.http.HttpServletRequest;/** * @Author zhangcl * @Date 17/5/30  下午10:04 */@Controller@RequestMapping("/sys/room/normal/")public class NormalRoomController {    @RequestMapping(value = "list")    public String list(HttpServletRequest request, ModelMap modelMap){        return "/sys/room/listNormalRoom";    }}