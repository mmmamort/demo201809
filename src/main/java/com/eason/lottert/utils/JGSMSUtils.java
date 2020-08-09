//package com.eason.lottert.utils;
//
//import cn.jiguang.common.resp.APIConnectionException;
//import cn.jiguang.common.resp.APIRequestException;
//import cn.jsms.api.SendSMSResult;
//import cn.jsms.api.ValidSMSResult;
//import cn.jsms.api.common.SMSClient;
//import cn.jsms.api.common.model.SMSPayload;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
///**
// * @ 文件名:   JGSMSUtils
// * @ 创建者:   Eason
// * @ 时间:    2018/9/30 0:31
// * @ 描述:
// */
//public class JGSMSUtils {
//    private static final String appkey = "e3b455eebe199c07b60dd057";
//    private static final String masterSecret = "d08f8c5f18ed822256f76826";
//
//    public static String sendSms(String phone) throws APIConnectionException, APIRequestException {
//        SMSClient client = new SMSClient(masterSecret, appkey);
//        SMSPayload payload = SMSPayload.newBuilder()
////                短信接收方
//                .setMobileNumber(phone)
//                .setTempId(1)
//                .build();
////            此为短信编号msg_id，本地不校验验证码，由平台通过编号校验
//        SendSMSResult res = client.sendSMSCode(payload);
//        String messageId = res.getMessageId();
//        System.out.println(messageId);
//        return messageId;
//    }
//
//    public static boolean sendValidSms(String msgId, String code) {
//        SMSClient client = new SMSClient(masterSecret, appkey);
//        try {
//            ValidSMSResult res = client.sendValidSMSCode(msgId, code);
//            System.out.println(res.toString());
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            return false;
//        }
//        return true;
//    }
//
//}
