package com.demo.util.pdf;

import java.util.ArrayList;
import java.util.List;

import com.itextpdf.text.Image;

/**
 * pdf 图片 对象
 * @author John
 *
 */
public class PdfModelImage extends PdfModel{
	

	private List<Image> images = new ArrayList<Image>();//相关 Images
	private String defaultValue;//若无图片显示内容
	private int scalePercent = 100;//图片缩放比例；// 默认100% 
	
	public PdfModelImage(){}
	
	public PdfModelImage(String title,Image images){
		this(title,images,null,100);
	}
	public PdfModelImage(String title,Image images,int scalePercent){
		this(title,images,null,scalePercent);
	}
	public PdfModelImage(String title,Image images, String defaultValue){
		this(title,images,defaultValue,100);
	}
	public PdfModelImage(String title,List<Image> images, String defaultValue){
		this(title,images,defaultValue,100);
	}
	public PdfModelImage(String title,List<Image> images){
		this(title,images,null,100);
	}
	public PdfModelImage(String title,Image images, String defaultValue,int scalePercent){
		super.setTitle(title);
		this.images.add(images);
		this.defaultValue = defaultValue;
		this.scalePercent = scalePercent;
	}
	public PdfModelImage(String title,List<Image> images, String defaultValue,int scalePercent) {
		super.setTitle(title);
		this.images = images;
		this.defaultValue = defaultValue;
		this.scalePercent = scalePercent;
	}
	
	public List<Image> getImages() {
		return images;
	}
	public void setImages(List<Image> images) {
		this.images = images;
	}
	public String getDefaultValue() {
		return defaultValue;
	}
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public int getScalePercent() {
		return scalePercent;
	}

	public void setScalePercent(int scalePercent) {
		this.scalePercent = scalePercent;
	}
	
	
}
