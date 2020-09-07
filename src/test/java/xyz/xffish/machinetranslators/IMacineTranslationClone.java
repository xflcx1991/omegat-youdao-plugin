package xyz.xffish.machinetranslators;

//import java.awt.Window;
//import org.omegat.util.Language;

public interface IMacineTranslationClone {

    String getName();

//        boolean isEnabled();

//        default void setEnabled(boolean enabled) {
//        }

//        String getTranslation(Language var1, Language var2, String var3) throws Exception;

//        String getCachedTranslation(Language var1, Language var2, String var3);

    default boolean isConfigurable() {
        return false;
    }

//        default void showConfigurationUI(Window parent) {
//        }
}

