package push;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;
import cn.jpush.api.device.TagAliasResult;

public class DevcieExample {
	protected static final Logger LOG = LoggerFactory.getLogger(DevcieExample.class);

	private static final String appKey ="72864ad1451cfe16d4351b57";
	private static final String masterSecret = "9f6bbe58f400d84f4568a040";
	private static final String TAG1 = "华泰证券";
	private static final String ALIAS1 = "alias1";
	private static final String ALIAS2 = "alias2";
	private static final String REGISTRATION_ID1 = "0600c246de6";

	private static JPushClient jpushClient = new JPushClient(masterSecret, appKey);

	public static void main(String[] args) {
		testGetDeviceTagAlias();
	}
	
	public static void testGetDeviceTagAlias() {
		try {
			TagAliasResult result = jpushClient.getDeviceTagAlias(REGISTRATION_ID1);
			
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
	
}


