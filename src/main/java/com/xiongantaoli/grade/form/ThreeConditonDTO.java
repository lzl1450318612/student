package com.xiongantaoli.grade.form;

/**
 * @author Franz.ge [nizhigeng@foxmail.com]
 * @Date 2017/6/6 17:52
 *  三个属性的实体类，后端接受参数使用
 */
public class ThreeConditonDTO {
	
	private Integer brand; //品牌的code值

	private Integer model; //型号的code值

    private Integer standard; //规格的code值


	
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

	public ThreeConditonDTO(Integer brand, Integer model, Integer standard) {
		super();
		this.brand = brand;
		this.model = model;
		this.standard = standard;
	}



	public ThreeConditonDTO() {
		
	}

}
