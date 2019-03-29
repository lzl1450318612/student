package com.xiongantaoli.grade.form;

import java.math.BigDecimal;

public class ProductInfoForm {
	 	private Long id;

	    private Long purchaseId;

	    private Integer brand;

	    private Integer model;

	    private Integer standard;

	    private BigDecimal baseRoyalty;

	    private BigDecimal saleRoyalty;

	    private BigDecimal scratchPrice;

	    private BigDecimal knockPrice;

	    private BigDecimal packingPrice;

	    private BigDecimal attachmentPrice;

	    private BigDecimal basePrice;

	    private BigDecimal purchasePrice;

	    private BigDecimal finalPrice;

	    private String brandname;
	    
	    private String modelname;
	    
	    private String standardname;

		@Override
		public String toString() {
			return "ProductInfo_form [id=" + id + ", purchaseId=" + purchaseId + ", brand=" + brand + ", model=" + model
					+ ", standard=" + standard + ", baseRoyalty=" + baseRoyalty + ", saleRoyalty=" + saleRoyalty
					+ ", scratchPrice=" + scratchPrice + ", knockPrice=" + knockPrice + ", packingPrice=" + packingPrice
					+ ", attachmentPrice=" + attachmentPrice + ", basePrice=" + basePrice + ", purchasePrice="
					+ purchasePrice + ", finalPrice=" + finalPrice + ", brandname=" + brandname + ", modelname="
					+ modelname + ", standardname=" + standardname + "]";
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getPurchaseId() {
			return purchaseId;
		}

		public void setPurchaseId(Long purchaseId) {
			this.purchaseId = purchaseId;
		}

		public Integer getBrand() {
			return brand;
		}

		public void setBrand(Integer brand) {
			this.brand = brand;
		}

		public Integer getModel() {
			return model;
		}

		public void setModel(Integer model) {
			this.model = model;
		}

		public Integer getStandard() {
			return standard;
		}

		public void setStandard(Integer standard) {
			this.standard = standard;
		}

		public BigDecimal getBaseRoyalty() {
			return baseRoyalty;
		}

		public void setBaseRoyalty(BigDecimal baseRoyalty) {
			this.baseRoyalty = baseRoyalty;
		}

		public BigDecimal getSaleRoyalty() {
			return saleRoyalty;
		}

		public void setSaleRoyalty(BigDecimal saleRoyalty) {
			this.saleRoyalty = saleRoyalty;
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

		public BigDecimal getBasePrice() {
			return basePrice;
		}

		public void setBasePrice(BigDecimal basePrice) {
			this.basePrice = basePrice;
		}

		public BigDecimal getPurchasePrice() {
			return purchasePrice;
		}

		public void setPurchasePrice(BigDecimal purchasePrice) {
			this.purchasePrice = purchasePrice;
		}

		public BigDecimal getFinalPrice() {
			return finalPrice;
		}

		public void setFinalPrice(BigDecimal finalPrice) {
			this.finalPrice = finalPrice;
		}

		public String getBrandname() {
			return brandname;
		}

		public void setBrandname(String brandname) {
			this.brandname = brandname;
		}

		public String getModelname() {
			return modelname;
		}

		public void setModelname(String modelname) {
			this.modelname = modelname;
		}

		public String getStandardname() {
			return standardname;
		}

		public void setStandardname(String standardname) {
			this.standardname = standardname;
		}

		public ProductInfoForm(Long id, Long purchaseId, Integer brand, Integer model, Integer standard,
				BigDecimal baseRoyalty, BigDecimal saleRoyalty, BigDecimal scratchPrice, BigDecimal knockPrice,
				BigDecimal packingPrice, BigDecimal attachmentPrice, BigDecimal basePrice, BigDecimal purchasePrice,
				BigDecimal finalPrice, String brandname, String modelname, String standardname) {
			super();
			this.id = id;
			this.purchaseId = purchaseId;
			this.brand = brand;
			this.model = model;
			this.standard = standard;
			this.baseRoyalty = baseRoyalty;
			this.saleRoyalty = saleRoyalty;
			this.scratchPrice = scratchPrice;
			this.knockPrice = knockPrice;
			this.packingPrice = packingPrice;
			this.attachmentPrice = attachmentPrice;
			this.basePrice = basePrice;
			this.purchasePrice = purchasePrice;
			this.finalPrice = finalPrice;
			this.brandname = brandname;
			this.modelname = modelname;
			this.standardname = standardname;
		}
}
