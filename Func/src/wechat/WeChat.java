package wechat;


public class WeChat {

//	http://mp.weixin.qq.com/s?__biz=MzA3OTAzNzAxMw==&mid=200979052&idx=1&sn=7d98bc1e210a06f7ada53f88658a0363#rd
	public static void main(String[] args) {
		HttpUtil.sendPost("http://szshort.weixin.qq.com/cgi-bin/micromsg-bin/geta8key",
				"__biz=3079037013" +
				"&mid=200979052" +
				"&idx=1" +
				"&rawUrl=http://mp.weixin.qq.com/s?__biz=MzA3MTI3MDQxNg==&mid=201240881&idx=4&sn=21adfceb77415e222eeaa813175da80d#rd" +
				"&sn=7d98bc1e210a06f7ada53f88658a0363" );
	}
	
	
}
