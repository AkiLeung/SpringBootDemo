package com.springboot.demo.sap;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Properties;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.ext.DestinationDataProvider;

/**
 * @author: JOSEPH.L
 * @date: 2021/2/28 23:32
 * @description:
 * @version: 1.0
 */
public class ConnectSAPServer {

    //SAP服务器IP地址
    static String CLD = "cloud-sap-ecp.sjfood.us";
    static String ABAP_AS_POOLED = "ABAP_AS_WITH_POOL_CLD";
//    static String PRD = "172.16.11.181";
//    static String ABAP_AS_POOLED = "ABAP_AS_WITH_POOL_PRD";
    static{
        Properties connectProperties = new Properties();
        connectProperties.setProperty(DestinationDataProvider.JCO_ASHOST, CLD);
        //系统编号
        connectProperties.setProperty(DestinationDataProvider.JCO_SYSNR,  "00");
        //SAP集团
        connectProperties.setProperty(DestinationDataProvider.JCO_CLIENT, "400");
        //SAP用户名
        connectProperties.setProperty(DestinationDataProvider.JCO_USER,   "JOSEPH.L");
        //密码
        connectProperties.setProperty(DestinationDataProvider.JCO_PASSWD, "123123123");
        //登录语言
        connectProperties.setProperty(DestinationDataProvider.JCO_LANG,   "EN");
        //最大连接数
        connectProperties.setProperty(DestinationDataProvider.JCO_POOL_CAPACITY, "3");
        //最大连接线程
        connectProperties.setProperty(DestinationDataProvider.JCO_PEAK_LIMIT,"10");
        createDataFile(ABAP_AS_POOLED, "jcoDestination", connectProperties);
    }

    /***
     * 如果连接配置文件不存在，则创建一个配置文件，并把配置信息写入到文件中
     * */
    static void createDataFile(String name, String suffix, Properties properties)
    {
        File cfg = new File(name+"."+suffix);
        if(!cfg.exists()){
            try{
                FileOutputStream fos = new FileOutputStream(cfg, false);
                properties.store(fos, "for tests only !");
                fos.close();
            }
            catch (Exception e){
                throw new RuntimeException("Unable to create the destination file " + cfg.getName(), e);
            }
        }
    }

    public static JCoDestination Connect(){
        JCoDestination destination =null;
        try {
            destination = JCoDestinationManager.getDestination(ABAP_AS_POOLED);
        }
        catch (JCoException e)
        {
            e.getCause();
        }
        return destination;
    }

    public static void main(String[] s)
    {
        try{
            JCoDestination jcoConn = Connect();
            System.out.println(jcoConn.getAttributes());
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}