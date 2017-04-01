package com.demo.util.pdf;

import java.util.ArrayList;
import java.util.List;

/**
 * pdf Phrase 对象
 * @author John
 *
 */
public class PdfModelPhrase extends PdfModel{

	private List<PdfModelPhraseContext> context = new ArrayList<PdfModelPhraseContext>(); // 具体内容
	private Boolean defaultNull;//若无 对应的默认值
	private String defaultValue;//对应 的 默认值.
	private float indent;//缩进
	
	
	public PdfModelPhrase(){
		this.indent = 30F;
	}
	public PdfModelPhrase(String title,List<PdfModelPhraseContext>  context, Boolean defaultNull, String defaultValue) {
		super.setTitle(title);
		this.context = context;
		this.defaultNull = defaultNull;
		this.defaultValue = defaultValue;
		this.indent = 30F;
	}
	
	public PdfModelPhrase(String title,PdfModelPhraseContext  context, Boolean defaultNull, String defaultValue) {
		super.setTitle(title);
		this.context.add(context);
		this.defaultNull = defaultNull;
		this.defaultValue = defaultValue;
		this.indent = 30F;
	}
	
	public PdfModelPhrase(String title,PdfModelPhraseContext  context) {
		this(title,context,false,null);
	}
	
	
	
	public Boolean getDefaultNull() {
		return defaultNull;
	}
	public void setDefaultNull(Boolean defaultNull) {
		this.defaultNull = defaultNull;
	}
	public String getDefaultValue() {
		return defaultValue;
	}
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	


	public List<PdfModelPhraseContext> getContext() {
		return context;
	}
	public void setContext(List<PdfModelPhraseContext> context) {
		this.context = context;
	}
	public float getIndent() {
		return indent;
	}


	public void setIndent(float indent) {
		this.indent = indent;
	}

	
	
}
