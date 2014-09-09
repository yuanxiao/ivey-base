package com.ivey.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class BaseController {

	@RequestMapping("noPromission")
	public String noPromission(Model model) {
		return "noPromission";
	}
}
