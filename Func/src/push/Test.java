package push;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;
import cn.jpush.api.device.TagAliasResult;
import cn.jpush.api.device.TagListResult;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.audience.AudienceTarget;
import cn.jpush.api.push.model.notification.Notification;

public class Test {

	protected static final Logger LOG = LoggerFactory.getLogger(Test.class);

	private static final String appKey ="72864ad1451cfe16d4351b57";
	private static final String masterSecret = "9f6bbe58f400d84f4568a040";
	
	public static final String TITLE = "测试标题";
    public static final String ALERT = "测试提示信息";
    public static final String TAG = "tag_api";

    private static final int maxRetryTimes = 3;
	private static JPushClient jpushClient = new JPushClient(masterSecret, appKey,maxRetryTimes);
	
	public static void main(String[] args) {
		
		initAccount();
		
		try {
			
//			SystemMessage huodongMsg = tempSysmsg1();
//			sendToAll(huodongAccount, huodongMsg);
			
			Thread.sleep(1000);
			
			SystemMessage sysMsg = tempSysmsg2();
//			sendByTag("中信证券", systemAccount, sysMsg);
//			sendToAll(systemAccount, sysMsg);

			
//			List<String> tags = getTags();//获取全部用户标签

			
			String bd_user_id = "0600c246de6";
//			getDeviceTagAlias(bd_user_id);//获取某个用户的标签和别名
			
//			sendByTarget(bd_user_id, systemAccount, sysMsg);
			
			
//			getDeviceTagAlias("0209ef0cf21");//jinzong
			getDeviceTagAlias("010a3957570");//2015.1.20 演示
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static SystemMessage tempSysmsg1() {
		SystemMessage huodongMsg = new SystemMessage();
		huodongMsg.id = String.valueOf(new Random().nextLong());
		huodongMsg.autoShow = 1;
		huodongMsg.type = 1;
		huodongMsg.date = System.currentTimeMillis();
		huodongMsg.content = "活动模块暂未开放，敬请等待。";
		return huodongMsg;
	}

	public static SystemMessage tempSysmsg2() {
		SystemMessage sysMsg = new SystemMessage();
		sysMsg.id = String.valueOf(new Random().nextLong());
		sysMsg.autoShow = 1;
		sysMsg.type = 1;
		sysMsg.date = System.currentTimeMillis();
//		sysMsg.content = "新版本v1.1.6已发布请进行更新，更新中如遇签名冲突问题请卸载重新安装，系统测试中，给您带来的不便敬请谅解。";
//		sysMsg.content = "1月6日国家开发银行拟增发60亿元人民币5年期金融债券、60亿元7年期金融债券、60亿元10年期金融债券、40亿元1年期金融债券，并发行40亿元3年期金融债券，总量不超过260亿元人民币。";
		sysMsg.content = "根据银监会网站，曹宇于2014年12月任中国银监会副主席。加入银监会前，曹宇长期在国务院办公厅从事经济金融领域政策制定和协调等相关工作。（彭博社）";
		return sysMsg;
	}
	
	public static SystemMessage tempSysmsg3() {
		SystemMessage sysMsg = new SystemMessage();
		sysMsg.id = String.valueOf(new Random().nextLong());
		sysMsg.autoShow = 1;
		sysMsg.type = 1;
		sysMsg.date = System.currentTimeMillis();
		sysMsg.content = "http://help.3g.163.com/14/1231/17/AEQFJ9GA00964LQ9.html";
		return sysMsg;
	}
	
	static SystemAccount systemAccount,huodongAccount;
	
	private static void initAccount(){
		systemAccount = new SystemAccount();
		systemAccount.account = "1000";
		systemAccount.logo = "http://b381.photo.store.qq.com/psb?/V107CrAn4G6DTB/l.rOR5rZ4eyAyo9sXFhrlY*rHMKaTOv6xoZRnasWy2s!/c/dFRCIePlMwAA&bo=kACQAJAAkAADACU!&rf=mood_app";
		systemAccount.nickname = "系统消息";
		
		huodongAccount = new SystemAccount();
		huodongAccount.account = "1001";
		huodongAccount.logo = "http://b381.photo.store.qq.com/psb?/V107CrAn4G6DTB/l.rOR5rZ4eyAyo9sXFhrlY*rHMKaTOv6xoZRnasWy2s!/c/dFRCIePlMwAA&bo=kACQAJAAkAADACU!&rf=mood_app";
		huodongAccount.nickname = "GTC社区";
	}
	
	public static class SystemAccount{
		String account;
		String nickname;
		String logo;
		String desc;
	}
	
	public static class SystemMessage{
		String id;//消息id
		int type;//消息类型 type（系统指令0 /普通消息 1 /卡片新闻 2）
		int autoShow;// 自动展示 0 不展示，1展示
		String content;//消息内容
		long date;//发送时间
	}
	
	public static void sendToAll(SystemAccount sysAccount,SystemMessage msg){
		PushPayload entity = PushPayload.newBuilder()
		        .setPlatform(Platform.android_ios())
		        .setAudience(Audience.all())
		        .setMessage(Message.newBuilder()
		                .setMsgContent(sysAccount.nickname)
		                .addExtra("id", msg.id)
		                .addExtra("fromAccount", sysAccount.account)
		                .addExtra("fromName", sysAccount.nickname)
		                .addExtra("fromLogo", sysAccount.logo)
		                .addExtra("content", msg.content)
		                .addExtra("autoShow", msg.autoShow)
		                .addExtra("type", msg.type)
		                .addExtra("date",msg.date)
		                .build()).build();
		
		doSend(entity);
		
	}
	
	public static void sendByTag(String tag,SystemAccount sysAccount,SystemMessage msg){
		
		PushPayload entity = PushPayload.newBuilder()
				.setPlatform(Platform.android_ios())
				.setAudience(Audience.newBuilder()
						.addAudienceTarget(AudienceTarget.tag(tag))
						.build())
						.setMessage(Message.newBuilder()
								.setMsgContent(sysAccount.nickname)
								.addExtra("id", msg.id)
								.addExtra("fromAccount", sysAccount.account)
								.addExtra("fromName", sysAccount.nickname)
								.addExtra("fromLogo", sysAccount.logo)
								.addExtra("content", msg.content)
								.addExtra("autoShow", msg.autoShow)
								.addExtra("type", msg.type)
								.addExtra("date",msg.date)
								.build()).build();
		
		doSend(entity);
	}
	
	public static void sendByTarget(String regid,SystemAccount sysAccount,SystemMessage msg){
		
		PushPayload entity = PushPayload.newBuilder()
				.setPlatform(Platform.android_ios())
				.setAudience(Audience.newBuilder()
						.addAudienceTarget(AudienceTarget.registrationId(regid))
						.build())
				.setMessage(Message.newBuilder()
						.setMsgContent(sysAccount.nickname)
						.addExtra("id", msg.id)
						.addExtra("fromAccount", sysAccount.account)
						.addExtra("fromName", sysAccount.nickname)
						.addExtra("fromLogo", sysAccount.logo)
						.addExtra("content", msg.content)
						.addExtra("autoShow", msg.autoShow)
						.addExtra("type", msg.type)
						.addExtra("date",msg.date)
						.build()).build();
		
		doSend(entity);
	}
	
	public static void sendByAlias(SystemAccount sysAccount,SystemMessage msg,String...alias){
		PushPayload entity = PushPayload.newBuilder()
				.setPlatform(Platform.android_ios())
				.setAudience(Audience.newBuilder()
						.addAudienceTarget(AudienceTarget.alias(alias))
						.build())
				.setMessage(Message.newBuilder()
						.setMsgContent(sysAccount.nickname)
						.addExtra("id", msg.id)
						.addExtra("fromAccount", sysAccount.account)
						.addExtra("fromName", sysAccount.nickname)
						.addExtra("fromLogo", sysAccount.logo)
						.addExtra("content", msg.content)
						.addExtra("autoShow", msg.autoShow)
						.addExtra("type", msg.type)
						.addExtra("date",msg.date)
						.build()).build();
		
		doSend(entity);
	}
	
	public static void doSend(PushPayload payload) {

		try {
            PushResult result = jpushClient.sendPush(payload);
            LOG.info("Got result - " + result);
        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Code: " + e.getErrorCode());
            LOG.info("Error Message: " + e.getErrorMessage());
            LOG.info("Msg ID: " + e.getMsgId());
        }
	}
	
	/**
	 * 全部标签和别名
	 */
	public static List<String> getTags() {
		try {
			
			TagListResult result = jpushClient.getTagList();
			
			LOG.info(result.tags.toString());

			return result.tags;
			
		} catch (APIConnectionException e) {
			LOG.error("Connection error. Should retry later. ", e);
		} catch (APIRequestException e) {
			LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Code: " + e.getErrorCode());
            LOG.info("Error Message: " + e.getErrorMessage());
		}
		return null;
	}
	
	/**
	 * 获取某台设备的标签和别名
	 * @param registerId 设备jpush注册id
	 */
	public static void getDeviceTagAlias(String registerId) {
		try {
			TagAliasResult result = jpushClient.getDeviceTagAlias(registerId);
			
			LOG.info(result.alias);
			LOG.info(result.tags.toString());
			
		} catch (APIConnectionException e) {
			LOG.error("Connection error. Should retry later. ", e);
			
		} catch (APIRequestException e) {
			LOG.error("Error response from JPush server. Should review and fix it. ", e);
			LOG.info("HTTP Status: " + e.getStatus());
			LOG.info("Error Code: " + e.getErrorCode());
			LOG.info("Error Message: " + e.getErrorMessage());
		}
	}
	
	
	public static PushPayload buildPushObject_all_all_alert() {
	    return PushPayload.alertAll(ALERT);
	}
	
	
}
