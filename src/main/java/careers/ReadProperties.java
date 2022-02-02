package careers;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadProperties {

    public static Properties prop;

    public static String get(String key) throws Exception {

        FileInputStream fis = new FileInputStream("src/main/resources/data.properties");
        prop = new Properties();
        prop.load(fis);

        String value;
        if((value=prop.getProperty(key))!=null){
            return value;
        }
        else {
            throw new Exception("Property " + key + " Not Found");
        }
    }
}
