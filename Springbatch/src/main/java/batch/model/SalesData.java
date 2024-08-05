package batch.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="job table")
public class SalesData {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String region;
	    private String country;
	    private String itemType;
	    private String salesChannel;
	    private String orderPriority;
	    private Date orderDate;
	    private Long orderID;
	    private Date shipDate;
	    private Integer unitsSold;
	    private Double unitPrice;
	    private Double unitCost;
	    private Double totalRevenue;
	    private Double totalCost;
	    private Double totalProfit;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getRegion() {
			return region;
		}
		public void setRegion(String region) {
			this.region = region;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public String getItemType() {
			return itemType;
		}
		public void setItemType(String itemType) {
			this.itemType = itemType;
		}
		public String getSalesChannel() {
			return salesChannel;
		}
		public void setSalesChannel(String salesChannel) {
			this.salesChannel = salesChannel;
		}
		public String getOrderPriority() {
			return orderPriority;
		}
		public void setOrderPriority(String orderPriority) {
			this.orderPriority = orderPriority;
		}
		public Date getOrderDate() {
			return orderDate;
		}
		public void setOrderDate(Date orderDate) {
			this.orderDate = orderDate;
		}
		public Long getOrderID() {
			return orderID;
		}
		public void setOrderID(Long orderID) {
			this.orderID = orderID;
		}
		public Date getShipDate() {
			return shipDate;
		}
		public void setShipDate(Date shipDate) {
			this.shipDate = shipDate;
		}
		public Integer getUnitsSold() {
			return unitsSold;
		}
		public void setUnitsSold(Integer unitsSold) {
			this.unitsSold = unitsSold;
		}
		public Double getUnitPrice() {
			return unitPrice;
		}
		public void setUnitPrice(Double unitPrice) {
			this.unitPrice = unitPrice;
		}
		public Double getUnitCost() {
			return unitCost;
		}
		public void setUnitCost(Double unitCost) {
			this.unitCost = unitCost;
		}
		public Double getTotalRevenue() {
			return totalRevenue;
		}
		public void setTotalRevenue(Double totalRevenue) {
			this.totalRevenue = totalRevenue;
		}
		public Double getTotalCost() {
			return totalCost;
		}
		public void setTotalCost(Double totalCost) {
			this.totalCost = totalCost;
		}
		public Double getTotalProfit() {
			return totalProfit;
		}
		public void setTotalProfit(Double totalProfit) {
			this.totalProfit = totalProfit;
		}
	    
	    
}
