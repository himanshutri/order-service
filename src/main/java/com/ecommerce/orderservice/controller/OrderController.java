package com.ecommerce.orderservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.orderservice.enums.OrderStatus;
import com.ecommerce.orderservice.exception.CardNumberNotValidException;
import com.ecommerce.orderservice.exception.ProductQuantityUnavailableException;
import com.ecommerce.orderservice.model.Order;

@RestController
public class OrderController {

	@PostMapping("/order")
	public ResponseEntity<Order> orderPurchase(@RequestBody Order order) throws ProductQuantityUnavailableException, CardNumberNotValidException{
		
		if(!isProductQuantityAvailable(order)){
			throw new ProductQuantityUnavailableException("product quantity "+order.getQuantity()+" is uanavailable");
		}
		
		if(!isCardValid(order.getCardNumber())) {
			throw new CardNumberNotValidException("card is in-valid");
		}
		order.setStatus(OrderStatus.COMPLETE);
		return new ResponseEntity<>(order,HttpStatus.OK);
	}

	private boolean isCardValid(String cardNumber) {
		// TODO Auto-generated method stub
		return true;
	}

	boolean isProductQuantityAvailable(Order order) {
		// TODO Auto-generated method stub
		return true;
	}
}
