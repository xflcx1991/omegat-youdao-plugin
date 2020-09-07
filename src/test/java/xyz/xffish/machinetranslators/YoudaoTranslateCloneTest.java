package xyz.xffish.machinetranslators;

import org.junit.Before;
import org.junit.Test;
import org.omegat.util.Language;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    public void justTest() throws Exception {

        System.out.println("justTest - 仅供测试");
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
    public void getPreferenceNameTest() {
        logger.info("getPreferenceNameTest - {}", youdaoTranslateCloneInstance.getPreferenceName());
    }

    @Test
    public void getNameTest() {
        logger.info("getNameTest - {}", youdaoTranslateCloneInstance.getName());
    }

}
