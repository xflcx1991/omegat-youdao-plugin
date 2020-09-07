package xyz.xffish.machinetranslators;


import org.omegat.util.Language;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseTranslateClone implements IMacineTranslationClone {
    //    protected boolean enabled;
    private final Map<String, String> cache = Collections.synchronizedMap(new HashMap<>());

    //    public boolean isEnabled() {
//        return this.enabled;
//    }
    protected String getFromCache(Language sLang, Language tLang, String text) {
        return this.cache.get(sLang + "/" + tLang + "/" + text);
    }

    protected String putToCache(Language sLang, Language tLang, String text, String result) {
        return this.cache.put(sLang + "/" + tLang + "/" + text, result);
    }

    protected String getCredential(String id) {
        String property = System.getProperty(id);
        //return property != null ? property : (String) CredentialsManager.getInstance().retrieve(id).orElse("");
        return property != null ? property : "";
    }

    protected void setCredential(String id, String value, boolean temporary) {
        System.setProperty(id, value);

    }

    protected abstract String getPreferenceName();

    protected abstract String translate(Language var1, Language var2, String var3) throws Exception;
}
