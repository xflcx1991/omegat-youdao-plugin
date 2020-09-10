package xyz.xffish.machinetranslators;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.omegat.util.Language;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

public class YoudaoTranslateCloneTest {
    private static final Logger logger = LoggerFactory.getLogger(YoudaoTranslateCloneTest.class);

    private YoudaoTranslateClone youdaoTranslateCloneInstance;

    private static final String PROPERTY_APP_KEY = "youdao.app.key";
    private static final String PROPERTY_APP_ID = "youdao.app.id";

    @Before
    public void setUp() throws Exception {
        System.out.println(logger.isTraceEnabled());
        System.out.println(logger.isDebugEnabled());
        System.out.println(logger.isInfoEnabled());
        System.out.println(logger.isWarnEnabled());
        System.out.println(logger.isErrorEnabled());

//        logger.setLevel(Level.WARN);

        logger.trace("Trace Message!");
        logger.debug("Debug Message!");
        logger.info("Info Message!");
        logger.warn("Warn Message!");
        logger.error("Error Message!");
        System.out.println("==========================");
        logger.info("开始 YoudaoTranslateTest");
        logger.info("setUp - {}", youdaoTranslateCloneInstance.URL);
        logger.debug("debug - setUp - {}", youdaoTranslateCloneInstance.URL);


        youdaoTranslateCloneInstance = new YoudaoTranslateClone();

        boolean temporary = false;
        String id = "06402c112e52cadf";
        String key = "UHVujVcLc82UkCoIpBvXTl82tJMOFH3n";
        youdaoTranslateCloneInstance.setCredential(PROPERTY_APP_ID, id, temporary);
        youdaoTranslateCloneInstance.setCredential(PROPERTY_APP_KEY, key, temporary);


    }

    @Test
    @Ignore
    public void translate_en2zh_Test() throws Exception {

        System.out.println("translate_en2zh_Test - 测试翻译");
        Locale l1 = Locale.US;
        Locale l2 = Locale.CHINA;
        Language sLang = new Language(l1);
        Language tLang = new Language(l2);
        String text = "apple";
        String translate = youdaoTranslateCloneInstance.translate(sLang, tLang, text);
        System.out.println(translate);
        System.out.println("--------测试缓存----------");
        translate = youdaoTranslateCloneInstance.translate(sLang, tLang, text);
        System.out.println(translate);


    }

    @Test
    @Ignore
    public void translate_zh2en_Test() throws Exception {

        System.out.println("translate_zh2en_Test - 测试翻译");
        Locale l1 = Locale.CHINA;
        Locale l2 = Locale.US;
        Language sLang = new Language(l1);
        Language tLang = new Language(l2);
        String text = "苹果";
        String translate = youdaoTranslateCloneInstance.translate(sLang, tLang, text);
        System.out.println(translate);
        System.out.println("--------测试缓存----------");
        translate = youdaoTranslateCloneInstance.translate(sLang, tLang, text);
        System.out.println(translate);


    }

    @Test
    public void getPreferenceNameTest() {
        String result = youdaoTranslateCloneInstance.getPreferenceName();
        Assert.assertEquals("should be \"allow_Youdao_translate\"", "allow_Youdao_translate", result);

    }


    @Test
    public void getNameTest() {
        String result = youdaoTranslateCloneInstance.getName();
        Assert.assertEquals("should be \"Youdao Translate\"", "Youdao Translate", result);
    }

    @Test
    public void omegatLang2YoudaoLangTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //测试没有参数的echoRequest()方法
        Method testMethod = youdaoTranslateCloneInstance.getClass().getDeclaredMethod("omegatLang2YoudaoLang", String.class);
        //Method对象继承自java.lang.reflect.AccessibleObject，父类方法setAccessible可调
        //将此对象的 accessible 标志设置为指示的布尔值。值为 true 则指示反射的对象在使用时应该取消 Java 语言访问检查。值为 false 则指示反射的对象应该实施 Java 语言访问检查。
        //要访问私有方法必须将accessible设置为true，否则抛java.lang.IllegalAccessException
        testMethod.setAccessible(true);
        //只检查常用语言和一个auto
        Object result = testMethod.invoke(youdaoTranslateCloneInstance, "zh");
        Assert.assertEquals("should be zh-CHS", "zh-CHS", result);

        result = testMethod.invoke(youdaoTranslateCloneInstance, "en");
        Assert.assertEquals("should be en", "en", result);

        result = testMethod.invoke(youdaoTranslateCloneInstance, "ja");
        Assert.assertEquals("should be ja", "ja", result);

        result = testMethod.invoke(youdaoTranslateCloneInstance, "ko");
        Assert.assertEquals("should be ko", "ko", result);

        result = testMethod.invoke(youdaoTranslateCloneInstance, "de");
        Assert.assertEquals("should be de", "de", result);

        result = testMethod.invoke(youdaoTranslateCloneInstance, "vi");
        Assert.assertEquals("should be auto", "auto", result);


    }


}
