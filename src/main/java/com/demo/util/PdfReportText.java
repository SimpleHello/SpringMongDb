/** *****************************************************
 * Copyright (C) Kongtrolink techology Co.ltd - All Rights Reserved
 *
 * This file is part of Kongtrolink techology Co.Ltd property.
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 ****************************************************** */
package com.demo.util;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.demo.entity.Student;
import com.demo.util.pdf.PdfFont;
import com.demo.util.pdf.PdfModel;
import com.demo.util.pdf.PdfModelImage;
import com.demo.util.pdf.PdfModelPhrase;
import com.demo.util.pdf.PdfModelPhraseContext;
import com.demo.util.pdf.PdfModelTable;
import com.demo.util.pdf.PdfReportEntity;
import com.demo.util.pdf.PdfReportManager;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * PDF 生成 demo
 */

public class PdfReportText {
	public static void main(String[] args){
		PdfReportText pdf = new PdfReportText();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
		String i = sdf.format(new Date());
		String pdfName = i+".pdf";
		String pdfPath = "E:\\111";
		String docTitle = "超级测试";
		try {
			pdf.create(pdfPath,pdfName,docTitle);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @param pdfPath pdf 存放路径
	 * @param pdfName pdf 文件名
	 * @param docTitle 
	 * @throws Exception
	 */
    public void create(String pdfPath,String pdfName,String docTitle)
            throws Exception {
        Document document = new Document(PageSize.A4);
        float cont = PageSize.A4.getWidth() - 75;
        PdfReportManager manager = new PdfReportManager(cont);
        FileOutputStream outputStream = null ;
        try {
        	if(!new File(pdfPath).exists())   {
        	    new File(pdfPath).mkdirs();
        	  }
            outputStream = new FileOutputStream(new File(pdfPath+File.separator+pdfName));
            PdfWriter.getInstance(document, outputStream);
            document.addTitle(docTitle);//设置文件标题
            document.addCreationDate();//设置文件创建时间
            document.open();
            /**
             *  测试 pdf 内容 标题
             */
            PdfModel model = new PdfModel();
            model.setTitle("PDF报表");
            manager.addTitle(document, model);
            /**
             *  测试 pdf 。单个属性加载- 横向展现
             */
            Object s = getDemoEntity();
	        String[] infos={"name","age","classs","str1","str2"};
        	String[] tableHeader = {"姓名","年龄","班级","备注","备注"};
        	PdfReportEntity entity = new PdfReportEntity("测试用表头0",s,tableHeader,infos);
        	entity.setConnect("#");//连接符
        	entity.setTableWidthPercent(90);//比例缩小到 90
           /**
             *  测试 pdf 。单个属性加载- 纵向展现
             */
        	PdfReportEntity entity1 = new PdfReportEntity(null,s,tableHeader,infos);
        	entity1.setConnect(" : ");//连接符
        	entity1.setType(1);// 0 横向 ；1 纵向
        	entity1.setIfTitle(false);//不展现 标题
        	entity1.setCellAlign(Element.ALIGN_RIGHT);//内容布局- 靠右
        	manager.addEntity(document, entity);
        	manager.addEntity(document, entity1);
        	/**
        	 * 测试 pdf table 展现
        	 */
        	List<Object> list = getDemoList();
            PdfModelTable table = new PdfModelTable("测试表数据1",list,tableHeader,infos);
            
            /**
             * 测试 pdf table 
             *  复合表头 的展现
             *  单位 ，布局的 展现
             */
            String[] infos2={"_id","name","age","classs","classBefore","str1","str2"};
            String[] tableHeader2 = {"编号","姓名","年龄","班级#现有班级,调班前班级","备注#备注(℃),备注(Ω)"};
        	Map<Integer,String> unitMap  = new HashMap<Integer,String>();//单位
        	Map<Integer,Integer> alian  = new HashMap<Integer,Integer>();//列布局
        	unitMap.put(5, "℃"); // 5 是子列 的顺序 对应备注(℃) 从 0 开始编号
        	unitMap.put(6, "Ω");// 6 是子列 的顺序 对应备注(Ω) 从 0 开始编号
        	alian.put(2, Element.ALIGN_LEFT);//第二列靠左 // 2 是子列 的顺序 对应 年龄  从 0 开始编号
            PdfModelTable table1 = new PdfModelTable("测试表数据2",list,tableHeader2,infos2);
            table1.setAlian(alian);
            table1.setUnitMap(unitMap);
            
            /**
             * 测试 pdf table
             * 展现 部分列
             */
            String[] infos3={"_id","name","age","classs"};
        	String[] tableHeader3 = {"编号","姓名","年龄","班级"};
            PdfModelTable table2 = new PdfModelTable("测试表数据3",list,tableHeader3,infos3);
            manager.addTable(document, table);
            manager.addTable(document, table1);
            manager.addTable(document, table2);
            
            /**
             * 测试 pdf 段落 文字
             */
            PdfModelPhraseContext con1 = new PdfModelPhraseContext("测试文字111.。。。。");
            PdfModelPhraseContext con2 = new PdfModelPhraseContext("测试文字222测试文字222测试文字222测试文字222测试文字222测试文2。。");
            PdfModelPhraseContext con3 = new PdfModelPhraseContext("测试文字333.。。。。");
            PdfModelPhraseContext con4 = new PdfModelPhraseContext("This is new message.。。。。");
            List<PdfModelPhraseContext> phrList = new ArrayList<PdfModelPhraseContext>();
            con1.setCellFont(PdfFont.font10);
            con2.setCellFont(PdfFont.font14);
            con4.setCellFont(PdfFont.font20);
            phrList.add(con1);
            phrList.add(con2);
            phrList.add(con3);
            phrList.add(con4);
            /**
             * "文字段说明", -- 标题
             * phrList, -- 具体展现内容
             * true,--若无内容 是否展现默认
             * "这个是默认无的字段" --无内容 展现的默认值
             */
            PdfModelPhrase phrase = new PdfModelPhrase("文字段说明",phrList,true,"这个是默认无的字段");
            phrase.setNextPage(false);//是否 pdf新增一页
            manager.addPhrase(document, phrase);
            phrase.setIfTitle(false);//是否 展现标题
            phrase.setIndent(0f);//首行缩进
            manager.addPhrase(document, phrase);
            
            
            PdfModelPhrase phrase2 = new PdfModelPhrase("文字段说明",new PdfModelPhraseContext("测试文字-靠右.。。。。",Element.ALIGN_RIGHT),true,"这个是默认无的字段");
            phrase2.setNextPage(false);//是否 pdf新增一页
            manager.addPhrase(document, phrase2);

            /**
             * 测试 pdf 图片
             */
            List<Image> imList = getDemoImageList();
            PdfModelImage pdfModelImage = new PdfModelImage("图片测试说明",imList,"此处无图");
            manager.addImages(document, pdfModelImage);
            /**
             * 测试 pdf 图片 比例缩放
             */
            Image jpeg=Image.getInstance("D:\\title.JPG");
            PdfModelImage pdfModelImage1 = new PdfModelImage("图片缩放测试说明",jpeg,50);
            pdfModelImage1.setCellAlign(Element.ALIGN_CENTER);//图片 水平居中
            manager.addImages(document, pdfModelImage1);
            document.close();
            System.out.println("生成 pdf 成功");
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally{
        	if(outputStream!=null){
        		outputStream.close();
        	}
        }
    }

    public Object getDemoEntity(){
    	return new Student("张三",22,"三班","备注1","备注2");
    }

    public List<Object> getDemoList(){
    	Student s1 = new Student("张三",21,"三班","备注1","备注2");
        Student s2 = new Student("张三",22,"三班","备注1","备注2");
        Student s3 = new Student("张三",23,"三班","备注1","备注2");
        Student s4 = new Student("张三",24,"三班","备注1","备注2");
        Student s5 = new Student("张三",25,null,null,null);
        s3.setClassBefore("一班");
        List<Object> list = new ArrayList<Object>();
        list.add(s1);list.add(s2);list.add(s3);list.add(s4);list.add(s5);
        return list;
    }
    
    public List<Image> getDemoImageList() throws Exception{
//    	 Image jpeg=Image.getInstance("D:\\title.JPG");
//         Image jpeg1=Image.getInstance("D:\\tim1.JPG");
         Image jpeg2=Image.getInstance("D:\\tim2.JPG");
         Image jpeg3=Image.getInstance("D:\\tim3.JPG");
         List<Image> imList = new ArrayList<Image>();

         imList.add(jpeg2);
         imList.add(jpeg3);
         return imList;
    }
}
