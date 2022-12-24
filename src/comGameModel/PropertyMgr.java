package comGameModel;

import java.io.IOException;
import java.util.Properties;

/**
 * @author 鸡腿子
 * @version 1.0
 */
public class PropertyMgr {

    static Properties props = new Properties();//Properties存在key和value

    static {
        try {
            props.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));//读取 把资源当成输入流 读出
            //将内容放在props里
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object get(String key) {//取得props的内容
        if (props == null) return null;
        return props.get(key);
    }

//    int getINt(key)
//    getString(key)
    public static void main(String[] args) {
        System.out.println(PropertyMgr.get("initTankCount"));//读出配置文件中坦克数量
    }
}
