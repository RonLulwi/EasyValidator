package com.ronlu.easyvalidator;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;

public class EasyChecker {

    /**
     * Checks if the device is connected to the internet.
     *
     * @param context the context of the application
     * @return true if the device is connected to the internet, false otherwise.
     */
    public static boolean isInternetConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }

    /**
     * Checks if airplane mode is enabled on the device.
     * @param context the context of the application
     * @return true if airplane mode is enabled, false otherwise.
     */
    public static boolean isAirplaneModeOn(Context context) {
        return Settings.Global.getInt(context.getContentResolver(),
                Settings.Global.AIRPLANE_MODE_ON, 0) != 0;
    }

    /**
     * Checks if Bluetooth is enabled on the device.
     * @return true if Bluetooth is enabled, false otherwise.
     */
    public static boolean isBluetoothEnabled() {
        return BluetoothAdapter.getDefaultAdapter() != null && BluetoothAdapter.getDefaultAdapter().isEnabled();
    }

    /**
     * Checks if WiFi is enabled on the device.
     * @param context the context of the application
     * @return true if WiFi is enabled, false otherwise.
     */
    public static boolean isWifiEnabled(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.getType() == ConnectivityManager.TYPE_WIFI;
    }

    /**
     * Checks if the device is connected to a WiFi network.
     *
     * @param context the context of the application
     * @return true if the device is connected to a WiFi network, false otherwise.
     */
    public static boolean isWifiConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.getType() == ConnectivityManager.TYPE_WIFI
                && activeNetwork.isConnectedOrConnecting();
    }

    /**
     * Checks if location services are enabled on the device.
     *
     * @param context the context of the application
     * @return true if location services are enabled, false otherwise.
     */
    public static boolean isLocationEnabled(Context context) {
        LocationManager lm = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        return lm.isProviderEnabled(LocationManager.GPS_PROVIDER) || lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
    }



}
