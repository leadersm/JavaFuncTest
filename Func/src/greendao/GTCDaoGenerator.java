package greendao;
/*
 * Copyright (C) 2011 Markus Junginger, greenrobot (http://greenrobot.de)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;
import de.greenrobot.daogenerator.ToMany;

/**
 * Generates entities and DAOs for the example project DaoExample.
 * 
 * Run it as a Java application (not Android).
 * 
 * @author Markus
 */
public class GTCDaoGenerator {

	static String packageName = "com.tianwen.news.data.db";
	
    public static void main(String[] args) throws Exception {
        Schema schema = new Schema(3, packageName);

        //新闻类型
        addNewsType(schema);
        //股票
        addStock(schema);
        //搜索历史
        addStockHistory(schema);
        //阅读记录
        addReadHistory(schema);
        //自动报告记录
        addAutoReportRecord(schema);
        //消息记录表
        addMessageTable(schema);
        
        
        new DaoGenerator().generateAll(schema, "./src-gen");
    }
    
    private static void addMessageTable(Schema schema) {
		// TODO Auto-generated method stub
    	Entity temp = schema.addEntity("Messages");
    	//消息id
    	temp.addStringProperty("id").primaryKey().notNull();
		//发送账号fromAccount
    	temp.addStringProperty("fromAccount");
    	//发送账号昵称：fromName
    	temp.addStringProperty("fromName");
    	//消息内容content
    	temp.addStringProperty("content");
    	//时间date
    	temp.addLongProperty("date");
    	//自动弹出autoShow (0 or 1)
    	temp.addIntProperty("autoShow");
    	//消息类型 type（普通消息 0 /自媒体消息 1 / 活动2）
    	temp.addIntProperty("type");
	}

	private static void addAutoReportRecord(Schema schema) {
    	Entity temp = schema.addEntity("AutoReport");
    	//id
    	temp.addIdProperty().primaryKey();
    	//stockName
    	temp.addStringProperty("stockName");
    	//stockCode
    	temp.addStringProperty("stockCode");
    	//fileName
    	temp.addStringProperty("fileName").notNull();
    	//date
    	temp.addLongProperty("date");
	}

	private static void addReadHistory(Schema schema) {
    	Entity temp = schema.addEntity("Read");
    	temp.addStringProperty("newsId").primaryKey().notNull();
    	temp.addLongProperty("date");
    }
    
    private static void addNewsType(Schema schema) {
    	Entity temp = schema.addEntity("NewsType");
//    	String id;//: "stock_dcbk",
    	temp.addStringProperty("id").primaryKey().notNull();
//    	String name;//: "地产行业",
    	temp.addStringProperty("name").notNull();
//    	String desc;//: "聚焦地产行业热点新闻",
    	temp.addStringProperty("desc");
//    	String mode;//: "000",
    	temp.addStringProperty("mode");
//    	String boss;//: "30",
    	temp.addStringProperty("boss");
//    	String market;//: "0",
    	temp.addStringProperty("market");
//    	String color;//: "1"
    	temp.addStringProperty("color");
		temp.addIntProperty("sort");
	}

	private static void addStock(Schema schema){
    	Entity stock = schema.addEntity("Stock");
    	stock.addStringProperty("stockCode").primaryKey().notNull();
    	stock.addStringProperty("stockName").notNull();
    	stock.addStringProperty("pinyin");
    	stock.addStringProperty("mtype");
    }
    
    private static void addStockHistory(Schema schema){
    	Entity history = schema.addEntity("SearchHistory");
        history.addStringProperty("stockCode").primaryKey().notNull();
        history.addStringProperty("stockName").notNull();
        history.addStringProperty("pinyin");
        history.addStringProperty("mtype");
        history.addLongProperty("date");
    }
    

}
