package dao;

import model.OrderDetail;

public interface OrderDAO {
	
	public boolean addOrder(OrderDetail orderDetail);
	public boolean updateCart(String userName);
}
