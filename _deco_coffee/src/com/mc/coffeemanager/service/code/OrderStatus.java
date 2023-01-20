package com.mc.coffeemanager.service.code;

// enum : 열거형
// 서로연관된 상수들의 집합
// 서로 연관된 상수들을 편하게 다루기 위한 enum만의 문법과 메서드가 제공된다.

/**
 * 주문 상태 코드
 * @author KimJaeHyun
 *
 */
public enum OrderStatus {
	//public static final OrderStatus Ok = new OrderStatus(0,"주문생성성공");
	//Ok = new OrderStatus(0,"주문생성성공"); 위와 동일
	
	/** 주문생성성공 */
	Ok(0,"주문생성성공"),
	/** 품절로 인한 주문 실패 */
	Fail_CAUSE_SOLDOUT(1,"품절로 인한 주문 실패"),
	/** 재고 부족으로 인한 주문 실패 */
	Fail_CAUSE_STOCK(2,"재고 부족으로 인한 주문 실패"),
	/** 시즌 상품은 시즌 기간에만 구매가 가능합니다 */
	Fail_CAUSE_SEASON(3,"시즌 상품은 시즌 기간에만 구매가 가능합니다"),
	/** 주문완료*/
	COMPLITE(4,"주문완료");
	
	/** 주문 상태 코드 */
	private int code;
	/** 주문 상태 상세 */
	private String decs;

	private OrderStatus(int code,String decs) {
		this.code = code;
		this.decs=decs; 
	}
	/** 주문 상태 ok */
	public boolean isok() {
		return code == Ok.code;
	}
	/** 주문 상태 Complete */
	public boolean isComplete() {
		return code == COMPLITE.code;
	}
	
	/** 주문 상태 Fail 3가지  SEASON,SOLDDOUT,STOCK */
	public boolean isFail() {
		if(code==Fail_CAUSE_SEASON.code||
				code==Fail_CAUSE_SOLDOUT.code||
				code==Fail_CAUSE_STOCK.code) {
			return true;
		}
		return false;
	}
	
	public String decs() {
		return decs;
	}
	

	
}
