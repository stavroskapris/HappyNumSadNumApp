package happySad.pack;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class NumberController {
	@RequestMapping("/")
	public String ShowForm() {
		return "helloworld-form";
	}

	@RequestMapping("proccesApp")
	public String dotheJob(@RequestParam("number") int x, RedirectAttributes redAtt) {
		boolean result = false;
		ArrayList<Integer> sums = new ArrayList<Integer>();
		int number = x;
		if (x == 1)
			result = true;
		while (number != 1) {
			int sum = 0;
			ArrayList<Integer> digits = new ArrayList<Integer>();
			while (number > 0) {
				digits.add(number % 10);
				number = number / 10;
			}
			for (int i = 0; i < digits.size(); i++) {
				sum = sum + digits.get(i) * digits.get(i);
			}
			// System.out.println(digits);
			number = sum;
			if (sums.contains(number)) {
				result = false;
				break;
			}
			sums.add(number);
			// System.out.println(sums);

			if (sum == 1) {
				result = true;
			}
		}
		if (result) {
			redAtt.addAttribute("number", x);
			redAtt.addFlashAttribute("message1", "is Happy Number");
			return "redirect:/";
		} else {
			redAtt.addAttribute("number", x);
			redAtt.addFlashAttribute("message2", "is Sad Number");
			return "redirect:/";
		}
	}
}
