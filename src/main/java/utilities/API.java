package utilities;

import java.util.Properties;

/**
 * Common Functions to use for Apica application automation.
 */

public class API {

        static String apiUrlsFileName  = "apiURLs.properties";
        static String configFileName  = "config.properties";
        static String atsAPIFileName  = "atsAPIs.properties";

        static Properties urlprop = CommonFunctions.PropertyFileReader(apiUrlsFileName);
        static Properties configprop = CommonFunctions.PropertyFileReader(configFileName);
        static Properties atsAPIprop = CommonFunctions.PropertyFileReader(atsAPIFileName);

        public static String getHostIP(){
                return configprop.getProperty("hostIP");
        }

        public static String getATShostIP(){
                return configprop.getProperty("ATShostIP");
        }

        public static String getinstalledVersion(){
                return configprop.getProperty("installedVersion");
        }

        public static String getRecorderVersion(){
                return configprop.getProperty("hostIP") + urlprop.getProperty("getRecorderVersion");
        }

        public static String getRecorderBlacklist(){
                return configprop.getProperty("hostIP") + urlprop.getProperty("getRecorderBlacklist");
        }

        public static String getRecorderWhitelist(){
                return configprop.getProperty("hostIP") + urlprop.getProperty("getRecorderWhitelist");
        }

        public static String getRecorderURLBlacklist(){
                return configprop.getProperty("hostIP") + urlprop.getProperty("getRecorderURLBlacklist");
        }

        public static String getRecorderURLWhitelist(){
                return configprop.getProperty("hostIP") + urlprop.getProperty("getRecorderURLWhitelist");
        }

        public static String getRecorderURLRegexBlacklist(){
                return configprop.getProperty("hostIP") + urlprop.getProperty("getRecorderURLRegexBlacklist");
        }

        public static String getRecorderURLRegexWhitelist(){
                return configprop.getProperty("hostIP") + urlprop.getProperty("getRecorderURLRegexWhitelist");
        }

        public static String getRecorderSSLVersion(){
                return configprop.getProperty("hostIP") + urlprop.getProperty("getRecorderSSLVersion");
        }

        public static String setRecorderSSLVersion(){
                return configprop.getProperty("hostIP") + urlprop.getProperty("setRecorderSSLVersion");
        }

        public static String getRecorderDNSConfig(){
                return configprop.getProperty("hostIP") + urlprop.getProperty("getRecorderDNSConfig");
        }

        public static String clearRecorderDNSResolveCache(){
                return configprop.getProperty("hostIP") + urlprop.getProperty("clearRecorderDNSResolveCache");
        }

        public static String getRecorderDNSTranslationTable(){
                return configprop.getProperty("hostIP") + urlprop.getProperty("getRecorderDNSTranslationTable");
        }

        public static String recorderPluginsGetList(){
                return configprop.getProperty("hostIP") + urlprop.getProperty("recorderPluginsGetList");
        }
        public static String recorderPluginSetActive(){
                return configprop.getProperty("hostIP") + urlprop.getProperty("recorderPluginSetActive");
        }

        public static String recorderPluginsRescan(){
                return configprop.getProperty("hostIP") + urlprop.getProperty("recorderPluginsRescan");
        }

        public static String getRecordingState(){
                return configprop.getProperty("hostIP") + urlprop.getProperty("getRecordingState");
        }

        public static String startRecording(){
                return configprop.getProperty("hostIP") + urlprop.getProperty("startRecording");
        }
        public static String stopRecording(){
                return configprop.getProperty("hostIP") + urlprop.getProperty("stopRecording");
        }

        public static String clearRecording(){
                return configprop.getProperty("hostIP") + urlprop.getProperty("clearRecording");
        }

        public static String insertPageBreak(){
                return configprop.getProperty("hostIP") + urlprop.getProperty("insertPageBreak");
        }

        public static String setSessionBreakDelay(){
                return configprop.getProperty("hostIP") + urlprop.getProperty("setSessionBreakDelay");
        }

        public static String setSessionEnableParallelURLCalls(){
                return configprop.getProperty("hostIP") + urlprop.getProperty("setSessionEnableParallelURLCalls");
        }

        public static String getNumRecordedItems(){
                return configprop.getProperty("hostIP") + urlprop.getProperty("getNumRecordedItems");
        }

        public static String getShortSessionDump(){
                return configprop.getProperty("hostIP") + urlprop.getProperty("getShortSessionDump");
        }

        public static String getSessionFilter(){
                return configprop.getProperty("hostIP") + urlprop.getProperty("getSessionFilter");
        }

        public static String setSessionFilter(){
                return configprop.getProperty("hostIP") + urlprop.getProperty("setSessionFilter");
        }

        public static String getSession(){
                return configprop.getProperty("hostIP") + urlprop.getProperty("getSession");
        }

        public static String getSessionAsHAR(){
                return configprop.getProperty("hostIP") + urlprop.getProperty("getSessionAsHAR");
        }

        public static String loadSession(){
                return configprop.getProperty("hostIP") + urlprop.getProperty("loadSession");
        }

        public static String ats_retrieve_row(){
                return atsAPIprop.getProperty("ats_retrieve_row");
        }

        public static String ats_retrieve_column(){
                return atsAPIprop.getProperty("ats_retrieve_column");
        }

        public static String ats_send_row(){
                return atsAPIprop.getProperty("ats_send_row");
        }

        public static String ats_send_column(){
                return atsAPIprop.getProperty("ats_send_column");
        }

        public static String ats_rowdata(){
                return configprop.getProperty("rowdata");
        }

        public static String ats_columndata(){
                return configprop.getProperty("columndata");
        }

        public static String ats_sendrowdata(){
                return configprop.getProperty("sendrowdata");
        }

        public static String ats_sendcolumndata(){
                return configprop.getProperty("sendcolumndata");
        }

        public static String ats_updatecolumndata(){
                return configprop.getProperty("updatecolumndata");

        }
        public static String ats_update_column(){
                return atsAPIprop.getProperty("ats_update_column");
        }


}
