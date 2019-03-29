package com.xiongantaoli.grade.form;

import java.math.BigDecimal;

/**
 * 在手机添加页面,接受前端传来参数的Dto类
 *  时间:2019/1/12
 * 最后修改时间:2019/1/12
 * 注意事项:无
* @author 周天
*
*/
public class NewProductDto {
	
	private Long id; //品牌的id值

	private int brand; //品牌的code值

	private int model; //型号的code值

    private int standard; //规格的code值
    
    private BigDecimal basePrice;
    
    private BigDecimal scratchPrice;

    private BigDecimal knockPrice;

    private BigDecimal packingPrice;

    private BigDecimal attachmentPrice;
    
    private BigDecimal baseRoyaltyPrice;
    
    private BigDecimal saleRoyaltyPrice;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getBrand() {
		return brand;
	}

	public void setBrand(int brand) {
		this.brand = brand;
	}

	public int getModel() {
		return model;
	}

	public void setModel(int model) {
		this.model = model;
	}

	public int getStandard() {
		return standard;
	}

	public void setStandard(int standard) {
		this.standard = standard;
	}

	public BigDecimal getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(BigDecimal basePrice) {
		this.basePrice = basePrice;
	}

	public BigDecimal getScratchPrice() {
		return scratchPrice;
	}

	public void setScratchPrice(BigDecimal scratchPrice) {
		this.scratchPrice = scratchPrice;
	}

	public BigDecimal getKnockPrice() {
		return knockPrice;
	}

	public void setKnockPrice(BigDecimal knockPrice) {
		this.knockPrice = knockPrice;
	}

	public BigDecimal getPackingPrice() {
		return packingPrice;
	}

	public void setPackingPrice(BigDecimal packingPrice) {
		this.packingPrice = packingPrice;
	}

	public BigDecimal getAttachmentPrice() {
		return attachmentPrice;
	}

	public void setAttachmentPrice(BigDecimal attachmentPrice) {
		this.attachmentPrice = attachmentPrice;
	}

	public BigDecimal getBaseRoyaltyPrice() {
		return baseRoyaltyPrice;
	}

	public void setBaseRoyaltyPrice(BigDecimal baseRoyaltyPrice) {
		this.baseRoyaltyPrice = baseRoyaltyPrice;
	}

	public BigDecimal getSaleRoyaltyPrice() {
		return saleRoyaltyPrice;
	}

	public void setSaleRoyaltyPrice(BigDecimal saleRoyaltyPrice) {
		this.saleRoyaltyPrice = saleRoyaltyPrice;
	}
	
	public NewProductDto() {
		super();
	}

	public NewProductDto(int brand, int model, int standard, BigDecimal basePrice, BigDecimal scratchPrice,
			BigDecimal knockPrice, BigDecimal packingPrice, BigDecimal attachmentPrice, BigDecimal baseRoyaltyPrice,
			BigDecimal saleRoyaltyPrice) {
		super();
		this.brand = brand;
		this.model = model;
		this.standard = standard;
		this.basePrice = basePrice;
		this.scratchPrice = scratchPrice;
		this.knockPrice = knockPrice;
		this.packingPrice = packingPrice;
		this.attachmentPrice = attachmentPrice;
		this.baseRoyaltyPrice = baseRoyaltyPrice;
		this.saleRoyaltyPrice = saleRoyaltyPrice;
	}

	public NewProductDto(Long id, int brand, int model, int standard, BigDecimal basePrice, BigDecimal scratchPrice,
			BigDecimal knockPrice, BigDecimal packingPrice, BigDecimal attachmentPrice, BigDecimal baseRoyaltyPrice,
			BigDecimal saleRoyaltyPrice) {
		super();
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.standard = standard;
		this.basePrice = basePrice;
		this.scratchPrice = scratchPrice;
		this.knockPrice = knockPrice;
		this.packingPrice = packingPrice;
		this.attachmentPrice = attachmentPrice;
		this.baseRoyaltyPrice = baseRoyaltyPrice;
		this.saleRoyaltyPrice = saleRoyaltyPrice;
	}

	@Override
	public String toString() {
		return "NewProductDto [id=" + id + ", brand=" + brand + ", model=" + model + ", standard=" + standard
				+ ", basePrice=" + basePrice + ", scratchPrice=" + scratchPrice + ", knockPrice=" + knockPrice
				+ ", packingPrice=" + packingPrice + ", attachmentPrice=" + attachmentPrice + ", baseRoyalty="
				+ baseRoyaltyPrice + ", saleRoyalty=" + saleRoyaltyPrice + "]";
	}


}
