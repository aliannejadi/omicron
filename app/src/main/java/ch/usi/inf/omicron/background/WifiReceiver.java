package ch.usi.inf.omicron.background;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import ch.usi.inf.omicron.Log;

public class WifiReceiver extends BroadcastReceiver {

    public static boolean wifiReceiverOnline = false;

    // log tag
    private static String WIFIR = "umob.Receiver.wifi";

    public WifiReceiver() {
        super();
        wifiReceiverOnline = true;
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.d(WIFIR, "Wifi state changed:");

        ConnectivityManager conMan = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = conMan.getActiveNetworkInfo();

        if (netInfo != null && netInfo.getType() == ConnectivityManager.TYPE_WIFI) {
            Log.d(WIFIR, "  device connected to Wifi");
//            rsm.uploadRecords(context);

        } else
            Log.d(WIFIR, "  device disconnected to Wifi.");

    }

}
