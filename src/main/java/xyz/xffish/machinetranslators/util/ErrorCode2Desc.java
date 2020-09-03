package xyz.xffish.machinetranslators.util;

import cn.hutool.core.map.MapUtil;

import java.util.Map;

public class ErrorCode2Desc {
    // 换一个批量向 HashMap插入值的方法
    // 复制粘贴 http://ai.youdao.com/DOCSIRMA/html/%E8%87%AA%E7%84%B6%E8%AF%AD%E8%A8%80%E7%BF%BB%E8%AF%91/API%E6%96%87%E6%A1%A3/%E6%96%87%E6%9C%AC%E7%BF%BB%E8%AF%91%E6%9C%8D%E5%8A%A1/%E6%96%87%E6%9C%AC%E7%BF%BB%E8%AF%91%E6%9C%8D%E5%8A%A1-API%E6%96%87%E6%A1%A3.html#section-10
    // TODO:还没有把所有的错误码描述信息写完
    private static final Map<Object, Object> errorCode2DescMap = MapUtil.of(new String[][]{
            {"101", "缺少必填的参数,首先确保必填参数齐全，然后确认参数书写是否正确。"},
            {"102", "不支持的语言类型"},
            {"103", "翻译文本过长"},
            {"104", "不支持的API类型"},
            {"105", "不支持的签名类型"},
            {"106", "不支持的响应类型"},
            {"107", "不支持的传输加密类型"},
            {"108", "应用ID无效，注册账号，登录后台创建应用和实例并完成绑定，可获得应用ID和应用密钥等信息"},
            {"109", "batchLog格式不正确"},
            {"110", "无相关服务的有效实例,应用没有绑定服务实例，可以新建服务实例，绑定服务实例。注：某些服务的翻译结果发音需要tts实例，需要在控制台创建语音合成实例绑定应用后方能使用。"},
            {"111", "开发者账号无效"},
            {"112", "请求服务无效"},
            {"113", "q不能为空"},
            {"114", "不支持的图片传输方式"},
            {"116", "strict字段取值无效，请参考文档填写正确参数值"},
            {"201", "解密失败，可能为DES,BASE64,URLDecode的错误"},
            {"202", "签名检验失败,如果确认应用ID和应用密钥的正确性，仍返回202，一般是编码问题。请确保翻译文本 q 为UTF-8编码."},
            {"203", "访问IP地址不在可访问IP列表"},
            {"205", "请求的接口与应用的平台类型不一致，确保接入方式（Android SDK、IOS SDK、API）与创建的应用平台类型一致。如有疑问请参考入门指南"},
            {"206", "因为时间戳无效导致签名校验失败"},
            {"207", "重放请求"},
            {"301", "辞典查询失败"},
            {"302", "翻译查询失败"},
            {"303", "服务端的其它异常"},
            {"304", "会话闲置太久超时"},
            {"401", "账户已经欠费停"},
            {"402", "offlinesdk不可用"},
            {"411", "访问频率受限,请稍后访问"},
            {"412", "长请求过于频繁，请稍后访问"},
            {"1001", "无效的OCR类型"},
            {"1002", "不支持的OCR image类型"},
            {"1003", "不支持的OCR Language类型"},
            {"1004", "识别图片过大"},
            {"1201", "图片base64解密失败"},
            {"1301", "OCR段落识别失败"},
            {"1411", "访问频率受限"},
            {"1412", "超过最大识别字节数"},
            {"2003", "不支持的语言识别Language类型"},
            {"2004", "合成字符过长"},
            {"2005", "不支持的音频文件类型"},
            {"2006", "不支持的发音类型"},
            {"2201", "解密失败"},
            {"2301", "服务的异常"},
            {"2411", "访问频率受限,请稍后访问"},
            {"2412", "超过最大请求字符数"},
            {"3001", "不支持的语音格式"},
            {"3002", "不支持的语音采样率"},
            {"3003", "不支持的语音声道"},
            {"3004", "不支持的语音上传类型"},
            {"3005", "不支持的语言类型"},
            {"3006", "不支持的识别类型"},
            {"3007", "识别音频文件过大"},
            {"3008", "识别音频时长过长"},
            {"3009", "不支持的音频文件类型"},
            {"3010", "不支持的发音类型"},
            {"3201", "解密失败"},
            {"3301", "语音识别失败"},
            {"3302", "语音翻译失败"},
            {"3303", "服务的异常"},
            {"3411", "访问频率受限,请稍后访问"},
            {"3412", "超过最大请求字符数"},
            {"4001", "不支持的语音识别格式"},
            {"4002", "不支持的语音识别采样率"},
            {"4003", "不支持的语音识别声道"},
            {"4004", "不支持的语音上传类型"},
            {"4005", "不支持的语言类型"},
            {"4006", "识别音频文件过大"},
            {"4007", "识别音频时长过长"},
            {"4201", "解密失败"},
            {"4301", "语音识别失败"},
            {"4303", "服务的异常"},
            {"4411", "访问频率受限,请稍后访问"},
            {"4412", "超过最大请求时长"},
            {"5001", "无效的OCR类型"},
            {"5002", "不支持的OCR image类型"},
            {"5003", "不支持的语言类型"},
            {"5004", "识别图片过大"},
            {"5005", "不支持的图片类型"},
            {"5006", "文件为空"},
    });

    /**
     * 根据错误码给出错误描述信息
     * @param errorCode 错误码
     * @return 错误描述信息
     */
    public static String translateErrorCode2Desc(String errorCode){
        String errorCodeDesc = (String) errorCode2DescMap.get(errorCode);
        if (errorCodeDesc == null) {
            errorCodeDesc = "未知错误码";
        }
        return errorCodeDesc;
    }
}