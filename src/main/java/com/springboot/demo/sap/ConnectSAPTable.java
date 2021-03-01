package com.springboot.demo.sap;

import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoTable;

/**
 * @author: JOSEPH.L
 * @date: 2021/2/28 23:52
 * @description:
 * @version: 1.0
 */
public class ConnectSAPTable {

    private JCoDestination jCoDestination;
    private ConnectSAPServer connectSAPServer;

    public int getPruchaseGroup() throws JCoException{
        connectSAPServer = new ConnectSAPServer();
        jCoDestination = ConnectSAPServer.Connect();
        JCoFunction function = jCoDestination.getRepository().getFunction("ZRFMM001");
        int intReturn = 0;
        if (function == null) { throw new RuntimeException("rfc not found in SAP");}
        //传入的参数
//      function.getImportParameterList().setValue("USTYP",ustyp);  // user type
        function.execute(jCoDestination);
        JCoTable returnTable = function.getTableParameterList().getTable("IT_LIST");
        if (returnTable.getNumRows()>0) {
            intReturn = returnTable.getNumRows();
            System.out.println("返回数量："+returnTable.getNumRows());
        }
        return intReturn;
    }

    public static void main(String[] args) {
        ConnectSAPTable test = new ConnectSAPTable();
        try{
            test.getPruchaseGroup();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
