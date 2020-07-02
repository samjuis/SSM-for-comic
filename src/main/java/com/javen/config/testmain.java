package com.javen.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class testmain {
	public static void main(String[] args) {
		
		  List<String> id= new ArrayList<String>() {{
		        add("1");
		        add("5");
		        add("6");
		        add("7");
		        add("8");
		    }};
		  System.out.println(id.contains("1"));
		  System.out.println(id.contains("2"));
//		feedBack fe=new feedBack();
//		fe.setContact("dafdsf");
//		fe.setContent("ssss");
//		fe.setDatetime("fdsafdsxcv");
//		fe.setId(3);
//		List<feedBack> Lfe=new ArrayList<>();
//		Lfe.add(fe);
//		Lfe.add(fe);
//		//List对象转换
//		String str1=JSON.toJSONString(Lfe);
//		System.out.println(str1);
//		List<feedBack> Lfes=JSON.parseArray(str1,feedBack.class);
//		System.out.println(Lfe+""+Lfes);
		//普通对象转换
//		String str1=JSON.toJSONString(fe);
//		System.out.println(str1);
//		JSONObject str=JSONObject.parseObject(str1);
//		System.out.println(str);
//		feedBack fes=JSONObject.toJavaObject(str,feedBack.class);
//		System.out.println(fes);
	}

	  private int id;
	  private String str;
	  private String str1;
	  public  testmain() {
		  
	  }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	public String getStr1() {
		return str1;
	}
	public void setStr1(String str1) {
		this.str1 = str1;
	}
	  

}
	/*
	 * @Autowired pathConfig router;
	 * 
	 * static Object[][] prizeArr = new Object[][]{ //里面的指针转动 {1,"一等奖",0.0001},
	 * {2,"不要灰心",39.9994}, {3,"祝您好运",20.0}, {4,"二等奖",0.0002}, {5,"再接再厉",20.0},
	 * {6,"运气先攒着",10.0}, {7,"三等奖",0.0003}, {8,"谢谢参与",10.0} }; Object result[] =
	 * award(prizeArr);//抽奖后返回奖品等级及奖品描述
	 * 
	 * //抽奖后返回奖品等级及奖品描述 public static Object[] award(Object[][] prizeArr){ //概率数组
	 * float obj[] = new float[prizeArr.length]; for(int i=0;i<prizeArr.length;i++){
	 * obj[i] = Float.parseFloat(prizeArr[i][2].toString()); } Integer prizeId =
	 * getRand(obj); //根据概率获取奖项号码 String msg = (String) prizeArr[prizeId][1];//奖品信息
	 * Integer prizeIds = prizeId +1; System.out.println("奖品号: "+prizeIds
	 * +" 获奖等级:"+msg);
	 * 
	 * return new Object[]{prizeId,msg}; }
	 * 
	 * 
	 * //根据概率获取奖项 public static Integer getRand(float obj[]){ Integer result = null;
	 * try { float sum = 0.0f;//概率数组的总概率精度 float min = 0.0f;// for(int
	 * i=0;i<obj.length;i++){ BigDecimal beforSum = new
	 * BigDecimal(Float.toString(sum)); BigDecimal objValue = new
	 * BigDecimal(Float.toString(obj[i])); sum =
	 * beforSum.add(objValue).floatValue();
	 * 
	 * } System.out.println(sum+min); for(int i=0;i<obj.length;i++){//概率数组循环
	 * BigDecimal db = new BigDecimal(Math.random() * (sum - min) + min); BigDecimal
	 * b = new BigDecimal(Float.toString(obj[i])); if(compareMethod(db,b) ==
	 * -1){//中奖 result = i; break; }else{ sum -=obj[i]; } } } catch (Exception e) {
	 * e.printStackTrace(); }
	 *//**
		 * 奖品控制代码,这里可以控制我们的奖品的等级
	 * @throws ParseException 
		 **//*
			 * return result; }
			 * 
			 * 
			 * 
			 * public static void main(String[] args) { DataRow data = new
			 * DataRow();//此处DataRow为封装了的 HashMap List<DataRow> resultList = new
			 * ArrayList<DataRow>(); for (int i = 0; i < 100; i++) { int k = 1; Object
			 * result[] = award(prizeArr);//抽奖后返回角度和奖品等级 String prize = ""; String comment =
			 * ""; for (Object object : result) { if(k==1){ prize = object.toString(); }else
			 * if(k==2){ comment = object.toString(); } k++; } if(k==3){ data.set("prize",
			 * Integer.valueOf(prize)+1); data.set("comment", comment);
			 * resultList.add(data); } } }
			 * 
			 * public static int compareMethod(BigDecimal a,BigDecimal b){ return
			 * a.compareTo(b); }
*/

//		int j = 0;
//		String[] str=new String[3000];
//		while (j++ < 3000) {
//			int intVal = (int) (Math.random() * 4 + 35);
//			String result = (char) intVal + "";
//			for (int i = 0; i < 3; i++) {
//				intVal = (int) (Math.random() * 26 + 97);
//				result = result + (char) intVal;
//				intVal = (int) (Math.random() * 26 + 65);
//				result = result + (char) intVal;
//				intVal = (int) (Math.random() * 10 + 48);
//				result = result + (char) intVal;
//			}
//			str[j-1]=result;
//		}
//		j=0;
//		for(int i=0;i<3000;i++) {
//			for(int t=i+1;t<3000;t++) {
//				if(str[i].equals(str[t])) {
//					j++;
//					System.out.println("re"+j);
//				}
//			}
//		}
//		List<rankMsg> rank = new ArrayList<>();
//		for (int i = 0; i < 7; i++) {
//			rankMsg r = new rankMsg();
//			if (i == 0) {
//				r.setCount(2);
//				r.setImg("sdfs");
//				r.setNikeName("12");
//				r.setOpenID("one");
//				rank.add(r);
//			}else {
//				
//					r.setCount(0);
//				r.setImg("aaaa");
//				r.setNikeName("i"+i);
//				r.setOpenID("one"+i);
//				rank.add(r);
//			}
//		}
//		System.out.println(reRankRecord(rank,2,"i2",0));
		
	

//	public static int reRankRecord(List<rankMsg> rank, int ranking,String openid, int count) {
//		int t = 1;
//		for (rankMsg r : rank) {
//			if (r.getOpenID().equals(openid))
//				continue;
//			else if (r.getCount() == count) {
//				t++;
//			} else if (count > r.getCount()) {
//				break;
//			}
//			
//		}
//		return rankingRecord(ranking,t);
//	}
//		public static int rankingRecord(int ranking,int t) {
//			if(t==1) {
//				if(ranking==1) {
//					return 1;
//				}else if(ranking<4) {
//					return 2;
//				}else
//					return 3;
//			}else if(t<3) {
//				if(ranking==1) {
//					return 2;
//				}else
//					return 3;
//			}
//			return 3;
//		}

