/*
参考了
https://github.com/yoyicue/omegat-tencent-plugin
https://github.com/omegat-org/omegat/blob/854b6b5a66a0306e5c27e74c0b5d656ed80b2bd4/src/org/omegat/core/machinetranslators/YandexTranslate.java
GoogleTranslateWithoutApiKey
的写法，感谢上述作者
彩云小译 API 文档：https://fanyi.caiyunapp.com/#/api
 */
package xyz.xffish.machinetranslators;

import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.omegat.core.Core;
import org.omegat.core.machinetranslators.BaseTranslate;
import org.omegat.gui.exttrans.MTConfigDialog;
import org.omegat.util.Language;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.xffish.machinetranslators.util.ErrorCode2Desc;
import xyz.xffish.machinetranslators.util.OLang2YLang;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/*
1. 多语种
2. 代码结构
3. 增加缓存，减少网络请求
 */
public class YoudaoTranslate extends BaseTranslate {
    /**
     * 设置存储 key 的名字，读取和设置值由 OmegaT 提供 API 来操作
     */
    private static final String PROPERTY_APP_KEY = "youdao.app.key";
    private static final String PROPERTY_APP_ID = "youdao.app.id";
    /**
     * 有道官方没有提供测试 Key
     */
//    protected static final String PROPERTY_API_OFFICIAL_TEST_SECRET_KEY = "";
    /**
     * 有道翻译请求 URL
     */
    protected static final String URL = "https://openapi.youdao.com/api";

    private static final Logger logger = LoggerFactory.getLogger(YoudaoTranslate.class);





    /**
     * 在软件启动时会自动调用该函数来注册插件
     */
    public static void loadPlugins() {
        logger.debug("加载 YoudaoTranslate Plugin");

        Core.registerMachineTranslationClass(YoudaoTranslate.class);
    }

    public static void unloadPlugins() {
    }

    /**
     * 显示该插件介绍性的话
     *
     * @return 介绍性话语
     */
    @Override
    protected String getPreferenceName() {
        System.out.println("YoudaoTranslate - getPreferenceName");
        return "allow_caiyun_Youdao_translate";
    }

    /**
     * 在软件里显示该翻译插件的名字.
     *
     * @return 本翻译插件显示的名字
     */
    @Override
    public String getName() {
        System.out.println("YoudaoTranslate - getName");
        return "Youdao Translate";
    }

    /**
     * 将 OmegaT 的语言代码转换成有道翻译识别的语言代码<br>
     * 找不到就输出 auto
     *
     * @param sLang
     * @return
     */
    private String omegatLang2YoudaoLang(String sLang) {
        String tLang = OLang2YLang.translateOLang2YLang(sLang);
        // 找不到就改成自动识别
        if (tLang == null) {
            tLang = "auto";
        }
        return tLang;
    }

    /**
     * 照抄有道官方 java 示例.
     * http://ai.youdao.com/DOCSIRMA/html/%E8%87%AA%E7%84%B6%E8%AF%AD%E8%A8%80%E7%BF%BB%E8%AF%91/API%E6%96%87%E6%A1%A3/%E6%96%87%E6%9C%AC%E7%BF%BB%E8%AF%91%E6%9C%8D%E5%8A%A1/%E6%96%87%E6%9C%AC%E7%BF%BB%E8%AF%91%E6%9C%8D%E5%8A%A1-API%E6%96%87%E6%A1%A3.html#section-14
     * 截断带翻译的文字以便简化计算签名
     *
     * @param q
     * @return
     */
    public static String truncate(String q) {
        if (q == null) {
            return null;
        }
        int len = q.length();
        String result;
        return len <= 20 ? q : (q.substring(0, 10) + len + q.substring(len - 10, len));
    }

    /**
     * 插件主体功能函数，接收原文，获得译文并返回
     *
     * @param sLang 原文的语言
     * @param tLang 译文的语言
     * @param text  原文内容
     * @return 译文内容
     * @throws Exception
     */
    @Override
    protected String translate(Language sLang, Language tLang, String text) throws Exception {
        logger.debug("translate,sLang={},tLang={},text={}", sLang, tLang, text);
        /*
         * 请求用 post+表单形式
         * 调用API需要向接口发送以下字段来访问服务。
         * 字段名	类型	    含义                                          必填	备注
         * q	    text	待翻译文本                                     True	必须是UTF-8编码
         * from	    text	源语言                                        True	参考下方 支持语言 (可设置为auto)
         * to	    text	目标语言                                       True	参考下方 支持语言 (可设置为auto)
         * appKey	text	应用ID	                                       True	可在 应用管理 查看
         * salt	    text	UUID	                                       True	UUID
         * sign	    text	签名      	                                   True	sha256(应用ID+input+salt+curtime+应用密钥)
         * signType	text	签名类型	                                      True	v3
         * curtime	text	当前UTC时间戳(秒)     	                      true	TimeStamp
         * ext	    text	翻译结果音频格式，支持mp3                         false	mp3
         * voice	text	翻译结果发音选择	                              false	0为女声，1为男声。默认为女声
         * strict	text	是否严格按照指定from和to进行翻译：true/false       false	如果为false，则会自动中译英，英译中。默认为false
         *
         *     签名生成方法如下：
         *     signType=v3；
         *     sign=sha256(应用ID+input+salt+curtime+应用密钥)；
         *     其中，input的计算方式为：input=q前10个字符 + q长度 + q后10个字符（当q长度大于20）或 input=q字符串（当q长度小于等于20）；
         *
         * 注意：
         *
         *     voice 没有男声的，会输出女声。
         *     发音需要在控制台创建tts实例，并绑定应用才能使用，否则点击发音会报110错误。
         *     接口salt+curtime来防重放（即一个请求不可以被请求2次），所以salt最好为UUID。
         */
        // -----------------处理带翻译文本-----------------
        //判断翻译缓存里有没有
        // U+2026 HORIZONTAL ELLIPSIS 水平省略号 …
        String lvShortText = text.length() > 5000 ? text.substring(0, 4997) + "\u2026" : text;
        // TODO:不写 putToCache 这里的cache是无用的
        String prev = getFromCache(sLang, tLang, lvShortText);
        if (prev != null) {
            // 啊，有缓存，那就直接返回不用请求了
            logger.debug("啊，有缓存，太美妙了：{}", prev);
            return prev;
        }


        // -----------------转换语言代码-----------------
        String lvSourceLang = sLang.getLanguageCode().substring(0, 2).toLowerCase();
        lvSourceLang = omegatLang2YoudaoLang(lvSourceLang);

        String lvTargetLang = tLang.getLanguageCode().substring(0, 2).toLowerCase();
        lvTargetLang = omegatLang2YoudaoLang(lvTargetLang);

        // 获取应用 ID——appKey
        String appKey = getCredential(PROPERTY_APP_ID);

        // -----------------获取UUID-----------------
        // 官方 python3 示例就是带“-”的 UUID
        String uuid = IdUtil.randomUUID();
        ;

        // -----------------计算签名 sign-----------------
        // sha256(应用ID+input+salt+curtime+应用密钥)

        // 应用密钥
        String secretKey = getCredential(PROPERTY_APP_KEY);


        logger.debug("secretKey = {}", secretKey);
        String curtime = String.valueOf(System.currentTimeMillis() / 1000);
        // 开始计算
        String originSign = appKey + truncate(lvShortText) + uuid + curtime + secretKey;
        String sign = SecureUtil.sha256(originSign);


        // -----------------构造接口调用参数-----------------
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("q", lvShortText); //待翻译文本
        paramMap.put("from", lvSourceLang); //源语言
        paramMap.put("to", lvTargetLang); //目标语言
        paramMap.put("appKey", appKey);
        paramMap.put("salt", uuid); //UUID
        paramMap.put("sign", sign); //签名
        paramMap.put("signType", "v3"); //签名类型 写死 v3
        paramMap.put("curtime", curtime); //当前UTC时间戳(秒)
        //省略 ext 和 voice 参数
        paramMap.put("strict", "true"); //是否严格按照指定from和to进行翻译


        String paramMapStr = JSONUtil.toJsonStr(paramMap);
        logger.debug("paramMap = {}", paramMapStr);
        // -----------------发 POST 请求-----------------
        String responseBody = HttpUtil.post(URL, paramMap);


        logger.debug("response body = {}", responseBody);


        JSONObject jsonObject = JSONUtil.parseObj(responseBody);

        String translation = "";

        String errorCode = jsonObject.getStr("errorCode");

        if (errorCode.equals("0")) {
            translation = jsonObject.getStr("translation");
            // 把这次结果添加进缓存
            putToCache(sLang, tLang, lvShortText, translation);
        } else {
            // 出错了，从 errorCode2DescMap 找错误描述信息
            String errorCodeDesc = ErrorCode2Desc.translateErrorCode2Desc(errorCode);
            translation = errorCodeDesc;
        }

        return translation;
    }


    /**
     * 是否在设置界面允许该插件的配置按钮可用，如果 false，配置按钮是灰色不可点的，也就没法配置 Token 了
     */
    @Override
    public boolean isConfigurable() {
        return true;
    }

    /**
     * 设置里面该插件的配置按钮被按下后弹出的界面、控制逻辑、获取数据，存储数据
     */
    @Override
    public void showConfigurationUI(Window parent) {
        MTConfigDialog dialog = new MTConfigDialog(parent, getName()) {
            @Override
            protected void onConfirm() {
                String id = panel.valueField1.getText().trim();
                String key = panel.valueField2.getText().trim();
                boolean temporary = panel.temporaryCheckBox.isSelected();

                // 利用 OmegaT 提供的 API 来设置 PROPERTY_API_SECRET_KEY 变量代表的名字的值
                // 可以想象 OmegaT 提供了一个类似 HashMap 的结构，
                // setCredential 就是用指定 key 存储值，getCredential 就是用指定 key 取值
                // 第三个参数是是否启用“仅为本次会话保存”
                setCredential(PROPERTY_APP_ID, id, temporary);
                setCredential(PROPERTY_APP_KEY, key, temporary);
            }
        };
        // 弹出 Token 设置窗口的 label 显示的文字
        dialog.panel.valueLabel1.setText("应用ID");
        // 利用 OmegaT 提供的 API 来获取 PROPERTY_API_SECRET_KEY 变量代表的名字的值
        dialog.panel.valueField1.setText(getCredential(PROPERTY_APP_ID));

        dialog.panel.valueLabel2.setText("应用密钥");
        dialog.panel.valueField2.setText(getCredential(PROPERTY_APP_KEY));



        // 设置是否勾选“仅为本次会话保存”。
        dialog.panel.temporaryCheckBox.setSelected(isCredentialStoredTemporarily(PROPERTY_APP_KEY));
        dialog.show();
    }
}
