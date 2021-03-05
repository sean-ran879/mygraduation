package com.zxr.mygraduation.tool;

import com.baidu.aip.ocr.AipOcr;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class ApiOrcUtil {

    //设置APPID/AK/SK
    private static String APP_ID = "19118145";
    private static String API_KEY ="hmPTawCebjizhM0VLxTFj9sP";
    private static String SECRET_KEY = "MsoNmfjC5sypsPZwvukyuvDHtLb9tN9n";

    public static String getPictureString(String photoPath){

        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        // 是否检测朝向
        options.put("detect_direction", "false");
        // 是否检测风险
        options.put("detect_risk", "false");

        // 正反面front /back
        String idCardSide = "front";

        // 参数为本地图片二进制数组
        /*byte[] file = new byte[0];
        try {
            file = Util.readFileByBytes(photoPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject res = client.idcard(file, idCardSide, options);
        System.out.println(res.toString(2));*/

        JSONObject res = client.idcard(photoPath, idCardSide, options);
        // 参数为本地图片路径
        try {

//            System.out.println(res.toString(2));
            if (res != null) {
                JSONObject idCard = new JSONObject();
                JSONObject words_result = res.getJSONObject("words_result");
                idCard.put("name", words_result.getJSONObject("姓名").get("words"));
                idCard.put("nation", words_result.getJSONObject("民族").get("words"));
                idCard.put("address", words_result.getJSONObject("住址").get("words"));
                idCard.put("sex", words_result.getJSONObject("性别").get("words"));
                idCard.put("birth", words_result.getJSONObject("出生").get("words"));
                idCard.put("number", words_result.getJSONObject("公民身份号码").get("words"));
                return idCard.toString(2);
            } else {
                idCardSide = "back";
                JSONObject words_result = res.getJSONObject("words_result");
                JSONObject idCard = new JSONObject();
                idCard.put("number","0");
                return idCard.toString(1);
            }
        }catch (JSONException e){
            JSONObject words_result = res.getJSONObject("words_result");
            JSONObject idCard = new JSONObject();
            idCard.put("number","0");
            return idCard.toString(1);
        }

    }

    public static void main(String[] args) {
        System.out.println(getPictureString("F:/intellij IDEA file/upload/aaa.jpg"));
    }
}

