package co.uk.newsint.tos.controller;

import java.io.InputStream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@SuppressWarnings("unused")
@Controller
public class IncomingTransactionsController {

  @RequestMapping(value = "/notify", method = RequestMethod.POST)
  public @ResponseBody String invoke(@RequestBody InputStream json) {

      return "done";
  }
	
}
