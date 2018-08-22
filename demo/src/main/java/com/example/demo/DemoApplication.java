package com.example.demo;

import org.bson.Document;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.MongoDbFactory;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class DemoApplication {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("application-context.xml");
		/*MongoClient client=(MongoClient) context.getBean("mongoClient");
		DB db= client.getDB("mydb");
		DBCollection collection=db.getCollection("book");*/
		
		MongoDbFactory factory=context.getBean(MongoDbFactory.class);
		MongoDatabase db=factory.getDb();
		MongoCollection<Document> collection=db.getCollection("book");
		//collection.insert(new BasicDBObject().append("title", "MongoDB").append("author", "Levan J"));
		collection.insertOne(new Document("title", "MongoDB").append("author", "Levan J"));
		
	}
}
