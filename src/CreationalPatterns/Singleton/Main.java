package CreationalPatterns.Singleton;

// Where u need only single instance, like logger, configs, n so on


class AppSettings{
    private String dbUrl;
    private String apiKey;

    private static AppSettings appSettings; // Imp to keep it private static

    private AppSettings(){
        dbUrl = "blahblah";
        apiKey = "Some value";
    }

    public static AppSettings getInstance(){
        if(appSettings == null){
            appSettings = new AppSettings();
        }
        return appSettings;
    }
}


public class Main {
}
