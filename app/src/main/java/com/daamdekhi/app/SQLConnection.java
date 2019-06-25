package com.daamdekhi.app;

import android.os.StrictMode;
import android.annotation.SuppressLint;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnection {
    private static final String LOG = "DEBUG";
    private static String ip = "68.65.122.157";
    private static String port = "3306";
    private static String classs = "net.sourceforge.jtds.jdbc.Driver";
    private static String db = "creauxir_daamdekhi";
    private static String un = "creauxir_daam";
    private static String password = "4LnCwNeWHGPv";

    @SuppressLint("NewApi")
    public Connection connect() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection conn = null;
//        String ConnURL;
//
//        try {
//            Class.forName(classs);
//            ConnURL = "jdbc:jtds:sqlserver://" + ip +":"+port+";" + "databaseName=" + db + ";user=" + un + ";password=" + password + ";";
//            conn = DriverManager.getConnection(ConnURL);
//        } catch (SQLException se) {
//            Log.e(LOG, se.getMessage());
//        } catch (ClassNotFoundException e) {
//            Log.e(LOG, e.getMessage());
//        } catch (Exception ex) {
//            Log.e(LOG, ex.getMessage());
//        }
        return conn;
    }
}
