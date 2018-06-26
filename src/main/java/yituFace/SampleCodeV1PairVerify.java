package yituFace;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

public class SampleCodeV1PairVerify {

    
	private static String pemPath ;
	private static String accessId;
	private static String accessKey;
	private static String userDefinedContent;
	private static String ip;

	/**
	 * 测试上传登记照并进行身份比对 将从测试数据文件中读取若干对比对数据(登记照和查询照)，依次调用服务，最终得到比对分数和正确答案进行比较
	 * 
	 * @throws IllegalStateException
	 *             , 未初始化URL或公钥文件
	 * @throws JsonProcessingException
	 * @throws SocketTimeoutException
	 * @throws UnknownHostException
	 * @throws IOException
	 * @throws Md5EncodingException
	 * @throws PublicKeyException
	 */
	public static void PairVerify() throws Exception {
		System.out.println("Test PairVerify Begin.");
		
		/*
		 * Step 1 生成HTTP body 
		 */
		String databaseImageContent = FileHelper.getImageBase64Content("Z:\\产品部\\公共文件夹\\zhangyan\\海外现金贷\\身份认证\\zhou1.jpg"); //  设置上传图片并编码为base64字符串
		int databaseImageType = 1; // 设置上传图片的类型，类型编号请参见接口文档

		String queryImageContent = FileHelper.getImageBase64Content("Z:\\产品部\\公共文件夹\\zhangyan\\海外现金贷\\身份认证\\yao2.jpg"); // 设置查询照图片并编码为base64字符串
		int queryImageType = 301; // 设置查询照图片类型
		
	    ObjectMapper mapper = new ObjectMapper();
	    Map<String, Object> requestData = new HashMap<String, Object>();
	    requestData.put("database_image_content", databaseImageContent);
	    requestData.put("database_image_type", databaseImageType);
	    requestData.put("query_image_content", queryImageContent);
	    requestData.put("query_image_type", queryImageType);
	    
	    String requestBodyString = mapper.writeValueAsString(requestData);
	    
		
		/*
		 * Step 2 生成 signature
		 */
	    PublicKey publicKey = EncryptionHelper.RSAHelper.loadPublicKey(pemPath);
	    String signature = HttpRequestHelper.generateSignature(publicKey, accessKey, requestBodyString, userDefinedContent);
		System.out.println("生成signature : " + signature);
	    
		/*
		 * Step 3 发送 HTTP请求 
		 */
	    String url = ip + "/face/v1/algorithm/recognition/face_pair_verification";
	    
		String result = HttpRequestHelper.sendPost(url, accessId, signature, requestBodyString);

		/*
		 * Step 4 校验答案
		 */
		JSONObject responseJson = new JSONObject(result);

		if (responseJson.getInt("rtn") == 0) {
			if (responseJson.getInt("pair_verify_result") == 0) {
				System.out.println("比对通过");
			} else {
				System.out.println("比对不通过");
			}
			System.out.println("相似度为" + responseJson.getDouble("pair_verify_similarity"));
		} else {
			System.err.println(responseJson.getString("message"));
		}
	}

	/**
	 * 载入配置文件
	 * 
	 * @throws JsonProcessingException
	 */
	@SuppressWarnings("unchecked")
	public static void loadConfig() throws Exception {

		ObjectMapper mapper = new ObjectMapper();
		//Map<String, Object> config = mapper.readValue(new File("config.json"), Map.class);

		ip = "http://staging.yitutech.com/";

		String dir  = "C:\\Users\\admin\\Downloads\\Yitu_Client_Sample_Code\\";
		pemPath = dir+"staging.public.pem";
		accessId = "93002";
		accessKey = "8a2647f8a5c3c50b0ff49be6a7db55c7";
		userDefinedContent = "\"abc\"";
	}

	public static void main(String[] args) throws Exception {
		loadConfig();
		PairVerify();
		System.out.println("Test PairVerify End.");
	}
}