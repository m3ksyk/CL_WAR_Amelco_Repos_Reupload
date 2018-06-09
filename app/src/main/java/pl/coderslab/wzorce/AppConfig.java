package pl.coderslab.wzorce;

//singleton Pattern
public class AppConfig {
    static public AppConfig appConfig;

    static private String dbHost;
    static private String dbUser;
    static private String dbPass;
    static private String dbName;

    private AppConfig(){};

    static public AppConfig getConfig(){
        if (appConfig == null){
            appConfig = new AppConfig();
            //implement read config file
            appConfig.setDbHost("127.0.0.1")
                    .setDbName("JEE_ADV")
                    .setDbUser("root")
                    .setDbPass("password");
        }
        return appConfig;
    }

    private static AppConfig getAppConfig() {
        return appConfig;
    }

    private static void setAppConfig(AppConfig appConfig) {
        AppConfig.appConfig = appConfig;
    }

    public static String getDbHost() {
        return dbHost;
    }

    private AppConfig setDbHost(String dbHost) {
        this.dbHost = dbHost;
        return this;
    }


    public static String getDbUser() {
        return dbUser;
    }

    private AppConfig setDbUser(String dbUser) {
        this.dbUser = dbUser;
        return this;
    }

    public static String getDbPass() {
        return dbPass;
    }

    private AppConfig setDbPass(String dbPass) {
        this.dbPass = dbPass;
        return this;
    }

    public static String getDbName() {
        return dbName;
    }

    private AppConfig setDbName(String dbName) {
        this.dbName = dbName;
        return this;
    }

}
