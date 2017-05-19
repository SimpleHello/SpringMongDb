package com.demo.test.test1;

import java.util.ArrayList;
import java.util.List;

import com.demo.entity.test1.Assort;
import com.demo.entity.test1.EqLevelEntity;
/**
 * @author John
 *
 */
public class Cx01 {

	public static List<EqLevelEntity> getEqLevel() {
		// TODO Auto-generated method stub
		List<String> colorList = Assort.getlistColor();
		List<EqLevelEntity> list = new ArrayList<EqLevelEntity>();
		for(int i=0;i<colorList.size();i++){
			EqLevelEntity entity = new EqLevelEntity();
			String str = colorList.get(i);
			entity.setLevel(String.valueOf(i+1));
			entity.setColor(str);
			entity.setAssort(Assort.getlistDetail(getLevel(i)));
			list.add(entity);
		}
		return list;
	}
	public static int getLevel(int i){
		switch(i+1){
			case 1:
			case 2:
			case 3:return (i+1)*3;
			case 4:return 14;
			case 5:return 17;
			case 6:return 18;
			case 7:
			case 8:
			case 9:
			case 10:
			case 11:return 20;
		}
		return 0;
	}
}
