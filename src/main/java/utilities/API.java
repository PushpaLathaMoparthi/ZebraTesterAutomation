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

        public static String getinstalledZTVersion_data(){
                return configprop.getProperty("installedZTVersion");
        }

        public static String getinstalledSSLVersion_data(){
                return configprop.getProperty("defaultSSLVersion");
        }

        public static String DNSconfig_data(){
                return configprop.getProperty("DNSconfig");
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

        public static String setRecorderSSLVersionAll(){
                return configprop.getProperty("hostIP") + urlprop.getProperty("setRecorderSSLVersionAll");
        }

        public static String setRecorderSSLVersiontls12(){
                return configprop.getProperty("hostIP") + urlprop.getProperty("setRecorderSSLVersiontls12");
        }

        public static String getRecorderDNSConfig(){
                return configprop.getProperty("hostIP") + urlprop.getProperty("getRecorderDNSConfig");
        }

        public static String setRecorderDNSConfig(){
                return configprop.getProperty("hostIP") + urlprop.getProperty("setRecorderDNSConfig");
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

        public static String ats_update_column(){
                return atsAPIprop.getProperty("ats_update_column");
        }

        public static String ats_retrieve_table_size(){
                return atsAPIprop.getProperty("ats_retrieve_table_size");
        }

        public static String data_rowdata(){
                return configprop.getProperty("rowdata").replace("{tableName}", data_tableName());
        }

        public static String data_wrongtable(){
                return configprop.getProperty("wrongtable");
        }

        public static String data_wrongJSON(){
                return configprop.getProperty("wrongJSON").replace("{tableName}", data_tableName());
        }

        public static String data_columndata(){
                return configprop.getProperty("columndata").replace("{tableName}", data_tableName());
        }

        public static String data_sendRowData(){
                return configprop.getProperty("sendRowData").replace("{tableName}", data_tableName());
        }

        public static String data_tableName(){
                return configprop.getProperty("tableName");
        }

        public static String data_sendUniqueRowData(){
                return configprop.getProperty("sendUniqueRowData").replace("{tableName}", data_tableName());
        }

        public static String data_sendStackedRowData(){
                return configprop.getProperty("sendStackedRowData").replace("{tableName}", data_tableName());
        }

        public static String data_sendnewrowdata(){
                return configprop.getProperty("sendnewrowdata").replace("{tableName}", data_tableName());
        }

        public static String data_sendcolumndata(){
                return configprop.getProperty("sendcolumndata").replace("{tableName}", data_tableName());
        }

        public static String data_updatecolumndata(){
                return configprop.getProperty("updatecolumndata").replace("{tableName}", data_tableName());

        }
        public static String data_tableJSON(){
                return configprop.getProperty("tablejson").replace("{tableName}", data_tableName());

        }
        public static String data_wrongColumn(){
                return configprop.getProperty("wrongColumn").replace("{tableName}", data_tableName());

        }

        public static String setRecorderBlacklist(){
                return configprop.getProperty("hostIP") + urlprop.getProperty("setRecorderBlacklist");
        }

        public static String setRecorderWhitelist(){
                return configprop.getProperty("hostIP") + urlprop.getProperty("setRecorderWhitelist");
        }

        public static String setRecorderURLBlacklist(){
                return configprop.getProperty("hostIP") + urlprop.getProperty("setRecorderURLBlacklist");
        }

        public static String setRecorderURLWhitelist(){
                return configprop.getProperty("hostIP") + urlprop.getProperty("setRecorderURLWhitelist");
        }

        public static String setRecorderURLRegexBlacklist(){
                return configprop.getProperty("hostIP") + urlprop.getProperty("setRecorderURLRegexBlacklist");
        }

        public static String setRecorderURLRegexWhitelist(){
                return configprop.getProperty("hostIP") + urlprop.getProperty("setRecorderURLRegexWhitelist");
        }

        public static String defaultRecorderBlacklistdata(){
                // {RecorderBlacklist:[]}
                return "{RecorderBlacklist:" + configprop.getProperty("defaultRecorderdata") + "}";
        }

        public static String defaultRecorderWhitelistdata(){
                // {RecorderWhitelist:[]}
                return "{RecorderWhitelist:" + configprop.getProperty("defaultRecorderdata") + "}";
        }

        public static String defaultRecorderURLBlacklistdata(){
                // {RecorderURLBlacklist:[]}
                return "{RecorderURLBlacklist:" + configprop.getProperty("defaultRecorderdata") + "}";
        }
        public static String defaultRecorderURLWhitelistdata(){
                // {RecorderURLWhitelist:[]}
                return "{RecorderURLWhitelist:" + configprop.getProperty("defaultRecorderdata") + "}";
        }

        public static String defaultRecorderURLRegexBlacklistdata(){
                // {RecorderURLRegexBlacklist:[]}
                return "{RecorderURLRegexBlacklist:" + configprop.getProperty("defaultRecorderdata") + "}";
        }

        public static String defaultRecorderURLRegexWhitelistdata(){
                // {RecorderURLRegexWhitelist:[]}
                return "{RecorderURLRegexWhitelist:" + configprop.getProperty("defaultRecorderdata") + "}";
        }

        public static String recorderBlacklistdata(){
                return configprop.getProperty("recorderBlacklistdata");
        }

        public static String recorderWhitelistdata(){
                return configprop.getProperty("recorderWhitelistdata");
        }

        public static String recorderURLBlacklistdata(){
                return configprop.getProperty("recorderURLBlacklistdata");
        }

        public static String recorderURLWhitelistdata(){
                return configprop.getProperty("recorderURLWhitelistdata");
        }

        public static String recorderURLRegexBlacklistdata(){
                return configprop.getProperty("recorderURLRegexBlacklistdata");
        }

        public static String recorderURLRegexWhitelistdata(){
                return configprop.getProperty("recorderURLRegexWhitelistdata");
        }



}
