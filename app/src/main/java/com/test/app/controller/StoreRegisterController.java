package com.test.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.app.form.StoreForm;
import com.test.app.service.StoreService;

@Controller
public class StoreRegisterController {

	@Autowired
	private StoreService storeService;

	@GetMapping("/store_register")
	public String storeForm(Model model) {
		model.addAttribute("storeForm", new StoreForm());
		return "store_register";
	}

	@PostMapping("/store_register")
	public String store_register(@ModelAttribute @Validated StoreForm storeForm, BindingResult result, Model model) {

		try {
			if (result.hasErrors()) {
				model.addAttribute("PhoneNumberError", "正しい形式で入力してください。");
				return "store_register"; // バリデーションエラーがあれば、同じフォームにリダイレクト
			}

			model.addAttribute("storeName", storeForm.getStoreName());
			model.addAttribute("address", storeForm.getAddress());
			model.addAttribute("phoneNumber", storeForm.getPhoneNumber());
			model.addAttribute("openDate", storeForm.getOpenDate());
			model.addAttribute("user", storeForm.getUser());

			storeService.save(storeForm);
			return "index";

		} catch (DataIntegrityViolationException e) {
			// 既に存在するユーザー名の場合のエラー処理
			model.addAttribute("StoreNameError", "既に登録済みの店舗です。");
			// 結果画面へ
			return "store_register";
		}
	}
}

// 下記で店舗登録自体は可能	
//	@GetMapping("/store_register")
//	public String store_registerForm() {
//		return "store_register";
//	}
//
//	@PostMapping("/store_register")
//	public String store_register(@ModelAttribute StoreDto storeDto) {
//		Store existing = storeService.findByStoreName(storeDto.getStoreName());
//		if (existing != null) {
//			return "store_register";
//		}
//		storeService.save(storeDto);
//		return "index";
//	}
