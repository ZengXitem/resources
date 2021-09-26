package org.example.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import demo.pay.api.model.PayModel;
import demo.pay.api.util.PayUtil;

@Controller
@RequestMapping("/pay")
public class PayController {

	@RequestMapping("/pay")
	@ResponseBody
	public Map<String, Object> pay(HttpServletRequest request, float money, int pay_type) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> remoteMap = new HashMap<String, Object>();
		remoteMap.put("money", money);
		remoteMap.put("pay_type", pay_type);
		remoteMap.put("order_no", PayUtil.getOrderIdByUUId());
		remoteMap.put("subject", "商品名称");
		remoteMap.put("app_id", PayUtil.APP_ID);
		remoteMap.put("extra", "");
		resultMap.put("data", PayUtil.payOrder(remoteMap));
		return resultMap;
	}

	@RequestMapping("/notifyPay")
	public void notifyPay(HttpServletRequest request, HttpServletResponse response, PayModel payModel) {
		// 保证密钥一致性
		if (PayUtil.checkSign(payModel)) {
			// TODO 支付成功的业务处理
			//这里业务处理
			//如果支付金额是前端传递过来的，这里还要验证支付金额
			
			response.getWriter().println("success");
		} else {
			// 签名错误
			response.getWriter().println("签名错误");
		}
	}

	@RequestMapping("/returnPay")
	public ModelAndView returnPay(HttpServletRequest request, HttpServletResponse response, PayModel payModel) {
		// 保证密钥一致性
		if (PayUtil.checkSign(payModel)) {
			// 建议本面仅显示支付结果,支付成功的业务处理放在如上的notifyPay里			
			response.getWriter().println("恭喜支付成功！订单号：" + payModel.getOrder_no());
		} else {
			// 签名错误
			response.getWriter().println("签名错误");
		}
	}
}
