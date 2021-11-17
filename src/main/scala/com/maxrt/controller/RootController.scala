package com.maxrt.controller

import org.springframework.stereotype.Controller
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping

@Controller
class RootController {
  @GetMapping(path = Array("/"))
  def addData = "redirect:/swagger-ui.html"
}
