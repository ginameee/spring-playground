package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	@GetMapping("hello")
	public String hello(Model model) {
		model.addAttribute("data", "hello!!");
		return "hello";
	}

	@GetMapping("hello-mvc")
	public String helloMvc(@RequestParam(value = "name", required = false) String name, Model model) {
		model.addAttribute("name", name);
		return "hello-template";
	}

	@GetMapping("hello-string")
	@ResponseBody
	public String helloString(@RequestParam(value = "name") String name) {
		return "hello " + name;
	}

	@GetMapping("hello-json")
	@ResponseBody
	public Hello helloJson(@RequestParam(value = "name") String name) {
		Hello hello = new Hello();
		hello.setName(name);

		return hello; // 기본으로 json format으로 변경된다.
	}

	static class Hello {
		private String name;

		public String getName() {
			return name;
		}

		public String setName(String name) {
			return this.name = name;
		}
	}
}
