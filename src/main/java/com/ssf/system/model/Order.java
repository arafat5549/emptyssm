package com.ssf.system.model;

import java.util.Date;

/**
 * 订单实体类
 * @author wyy
 * 2017年3月31日
 *
 */
public class Order{

	private Integer id;
	private String ordercode;//唯一的订单号(为什么我们不用id作为唯一订单号)
	private Integer userId; //属于哪个用户
	private String address;//收货地址    
	private String post;   //邮政编号
	private String receiver;//收件人
	private String mobile; //手机
	private String message; //备注
	private String status;//订单状态 # 枚举类型(常量的集合)待付款-待发货-待收货-待评价
	//运维记录时间
	private Date payDate;    //付款时间
	private Date deliveryDate;//发货时间
	private Date confirmDate;//确认收货时间
	
	/**
	 * 临时变量
	 */
	//所有的商品集合
//	private List<OrderItem> items = new ArrayList<OrderItem>();
//	private Integer totalCount;//所有商品的数量
//	private BigDecimal total;  //所有商品的价格
//	public Integer getTotalCount() {
//		int totalCount = 0;
//		for (OrderItem item : items) {
//			totalCount+=item.getCount();
//		}
//		return totalCount;
//	}
//	public BigDecimal getTotal() {
//		BigDecimal total = new BigDecimal(0);
//		for (OrderItem item : items) {
//			total = total.add(item.getProduct().getPromotoPrice());
//		}
//		//System.out.println(total);
//		return total;
//	}

	public enum OrderStatus{
		WAIT_PAY("waitPay"),
		WAIT_DELIVER("waitDeliver"),
		WAIT_CONFIRM("waitConfirm"),
		WAIT_REVIEW("waitReview");
		
		private String status;
		public String getValue(){
			return status;
		}
		OrderStatus(String status){
			this.status = status;
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrdercode() {
		return ordercode;
	}

	public void setOrdercode(String ordercode) {
		this.ordercode = ordercode;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Date getConfirmDate() {
		return confirmDate;
	}

	public void setConfirmDate(Date confirmDate) {
		this.confirmDate = confirmDate;
	}

//	public List<OrderItem> getItems() {
//		return items;
//	}
//
//	public void setItems(List<OrderItem> items) {
//		this.items = items;
//	};
	
}
