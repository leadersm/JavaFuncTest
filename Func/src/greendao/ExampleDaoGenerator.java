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
public class ExampleDaoGenerator {

    public static void main(String[] args) throws Exception {
        Schema schema = new Schema(3, "com.tianwen.news.data.db");

//        addNote(schema);
//        addCustomerOrder(schema);
//        addTask(schema);
//        addHistory(schema);
//        addAttention(schema);
//        addCatalog(schema);
//        addWeiboTrack(schema);

        addNewsType(schema);
        addStock(schema);
        addStockHistory(schema);
        
        new DaoGenerator().generateAll(schema, "./src-gen");
        
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
    

    private static void addNote(Schema schema) {
        Entity note = schema.addEntity("Note");
        note.addIdProperty();
        note.addStringProperty("text").notNull();
        note.addStringProperty("comment");
        note.addDateProperty("date");

    }

    private static void addCustomerOrder(Schema schema) {
        Entity customer = schema.addEntity("Customer");
        customer.addIdProperty();
        customer.addStringProperty("name").notNull();

        Entity order = schema.addEntity("Order");
        order.setTableName("ORDERS"); // "ORDER" is a reserved keyword
        order.addIdProperty();
        Property orderDate = order.addDateProperty("date").getProperty();
        Property customerId = order.addLongProperty("customerId").notNull().getProperty();
        order.addToOne(customer, customerId);

        ToMany customerToOrders = customer.addToMany(order, customerId);
        customerToOrders.setName("orders");
        customerToOrders.orderAsc(orderDate);
    }
    
    private static void addTask(Schema schema){
//    	int status;
//
//    	String taskId;
//    	String title;
//    	String desc;
//    	long date;
//    	List<NODE> nodes;
//    	List<User> users;
//    	String from;//发起人
    	Entity task = schema.addEntity("Task");
    	task.addIdProperty();
    	task.addStringProperty("title");
    	task.addStringProperty("desc");
    	task.addLongProperty("date");
    	task.addStringProperty("endDate");
    	task.addLongProperty("from");
    	task.addIntProperty("status");
    	task.addStringProperty("usersJson");
    	task.addBooleanProperty("isNew");
    	task.addStringProperty("statusJson");
    	
//    	String userId;
//    	String name;
//    	String description;
//    	String gender;
//    	int level;
//		String deviceId;    	
//    	String phone;
//    	String email;
//      "description": "",
    	

    	Entity user = schema.addEntity("User");
    	user.setTableName("USERS");
    	user.addIdProperty();
    	user.addStringProperty("name");
    	user.addStringProperty("deviceId");
    	user.addStringProperty("description");
    	user.addStringProperty("gender");
    	user.addIntProperty("level");
    	user.addStringProperty("phone");
    	user.addStringProperty("email");
    	
//    	String id;
//    	String taskId;
//    	String filePath;
//    	int status;
//    	long date;
//    	String from,to;
//    	String desc;
//    	
//    	String textMsg;
//		String voiceMsg;
    	
    	
    	Entity node = schema.addEntity("NODE");
    	node.setTableName("NODES");
    	node.addIdProperty();
    	Property nodeTaskId = node.addLongProperty("taskId").notNull().getProperty();
    	node.addStringProperty("filePath");
    	node.addIntProperty("status");
    	node.addStringProperty("from");
    	node.addStringProperty("to");
    	node.addStringProperty("textMsg");
    	node.addStringProperty("usersJson");
    	
    	Property date = node.addLongProperty("date").getProperty();
    	
    	ToMany nodes = task.addToMany(node, nodeTaskId);
    	nodes.setName("nodes");
    	nodes.orderDesc(date);
    	
    }
    
    private static void addCatalog(Schema schema){
    	Entity entity = schema.addEntity("Catalog");
    	entity.addIdProperty();
    	entity.addStringProperty("tagName");
    	entity.addStringProperty("catalogDisplayName");
    	entity.addStringProperty("catalogCode");
    	entity.addStringProperty("newsIndex");
    	entity.addStringProperty("nickname");
    	entity.addStringProperty("hotNumber");
    }
    
    private static void addAttention(Schema schema){
    	Entity entity = schema.addEntity("Attention");
    	entity.addIdProperty();
    	entity.addIntProperty("attentionType");
    	entity.addStringProperty("subject");
    	entity.addStringProperty("label");
    	entity.addStringProperty("type");
    	entity.addStringProperty("childType");
    	entity.addStringProperty("userId");
    	entity.addStringProperty("startTime");
    	entity.addIntProperty("trackDays");
    	entity.addStringProperty("addTime");
    }
    
    private static void addWeiboTrack(Schema schema){
    	Entity entity = schema.addEntity("WeiboTrack");
    	entity.addIdProperty();
    	entity.addStringProperty("mark");
    	entity.addLongProperty("trackTime");
    	
    	entity.addLongProperty("addTime");
    	entity.addLongProperty("weiboCreateAt");
    	entity.addIntProperty("weiboType");
    	entity.addStringProperty("isRetweeted");
    	entity.addStringProperty("retweetedText");
    	entity.addStringProperty("weiboCommectsCount");
    	entity.addStringProperty("weiboRepostsCount");
    	entity.addStringProperty("weiboId");
    	entity.addStringProperty("weiboText");
    	entity.addStringProperty("weiboScreenName");
    	entity.addStringProperty("transWeiboId");
    }
    
    private static void addHistory(Schema schema){
    	Entity history = schema.addEntity("SearchHistory");
        history.addIdProperty();
        history.addStringProperty("type");
        history.addStringProperty("childType");
        history.addStringProperty("keywords");
        history.addStringProperty("fbr");
        history.addIntProperty("minRepostCount");
        history.addIntProperty("minCommentCount");
        history.addLongProperty("date");
        history.addStringProperty("startTime");
        history.addStringProperty("endTime");
    }

}
