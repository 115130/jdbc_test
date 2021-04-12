package chinasofti.util;

import java.io.IOException;
import java.util.Properties;

//加载配置文件，并根据key get Value
public class ConfigureManager {
    private static Properties pro = new Properties();
    private static ConfigureManager instance=null;
    private ConfigureManager(){
        try {
            //读取properties配置文件信息
            pro.load(ConfigureManager.class.getClassLoader().getResourceAsStream("database.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static ConfigureManager getInstance(){
        if(instance==null){
            instance=new ConfigureManager();
        }
        return instance;
    }

    /**
     * 根据key得到value的值
     */
    public static String getValue(String key) {
        return pro.getProperty(key);
    }

}
