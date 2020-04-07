package com.zjzc.jizhikeji;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.zjzc.jizhikeji.DataHandler.DataMsgHandler;
import com.zjzc.jizhikeji.DataHandler.DecentZJZC;
import com.zjzc.jizhikeji.Redis.AlarmMessage;
import com.zjzc.jizhikeji.Redis.OnlineMessage;
import com.zjzc.jizhikeji.Redis.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.text.ParseException;

@RestController
@SpringBootApplication
public class JizhikejiApplication {

	@Autowired
	private Publisher publisher;

	@PostMapping(value = "/receive")
	public String receive(@RequestBody String body) throws ParseException {

		DataMsgHandler dataMsgHandler = new DataMsgHandler();
		DecentZJZC decentZJZC = new DecentZJZC();
		JSONObject jsonMsg = JSONObject.parseObject(body, Feature.OrderedField);
		System.out.println("原始数据为："+jsonMsg.toString());

		//设备数据变化 :告警消息接收
		System.out.println("notifyType的值为："+jsonMsg.getString("notifyType"));
		try {
			if(jsonMsg.getString("notifyType").equals("deviceDataChanged")){
				if(jsonMsg.getJSONObject("service").getString("serviceId").equals("Service") && jsonMsg.getJSONObject("service").getString("serviceType").equals("Service")){
					if(jsonMsg.getJSONObject("service").getJSONObject("data").containsKey("Alarm")){
						String AlarmdataString = dataMsgHandler.AlarmDataHandle(jsonMsg);
						AlarmMessage Alarmzjzc = decentZJZC.Alarm(AlarmdataString,jsonMsg);
						publisher.pushAlarmMessage("NBMessageCTCC",Alarmzjzc);
					} else {
						System.out.println("其他消息："+jsonMsg);
					}
				}else{
					System.out.println("其他消息："+jsonMsg);
				}
			} else if(jsonMsg.getString("notifyType").equals("deviceInfoChanged")){
				//设备信息变化 :设备上下线消息
				OnlineMessage OnlinedataString = decentZJZC.Online(jsonMsg);
				if(OnlinedataString == null){
					System.out.println("该消息有误不推送");
				}else {
					publisher.pushOnlineMessage("NBMessageCTCC",OnlinedataString);
				}
			}else {
				System.out.println("其他消息："+jsonMsg);
			}
		}catch (Exception e){
			System.out.println("错误信息："+e.getMessage());
			e.printStackTrace();
		}finally {
			return "succcess";
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(JizhikejiApplication.class, args);
	}

}
