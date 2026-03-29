package com.zenmen.palmchat.battery.bean;

import androidx.core.app.NotificationCompat;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class BatteryInfoBean {
    public AlarmBean alarm;
    public AppStatsBean appStats;
    public BatteryTempBean batteryTemp;
    public BluetoothBean bluetooth;
    public CpuFreqBean cpuFreq;
    public JiffiesBean jiffies;
    public LocationBean location;
    public TrafficStatusBean trafficStatus;
    public WakeLockBean wakeLock;
    public WifiBean wifi;

    /* JADX INFO: compiled from: SearchBox */
    public static class BatteryInfoBeanJsonSerializer implements JsonSerializer<BatteryInfoBean> {
        @Override // com.google.gson.JsonSerializer
        public JsonElement serialize(BatteryInfoBean batteryInfoBean, Type type, JsonSerializationContext jsonSerializationContext) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.add("jiffies", jsonSerializationContext.serialize(batteryInfoBean.jiffies));
            jsonObject.add(NotificationCompat.CATEGORY_ALARM, jsonSerializationContext.serialize(batteryInfoBean.alarm));
            jsonObject.add("wakeLock", jsonSerializationContext.serialize(batteryInfoBean.wakeLock));
            jsonObject.add("bluetooth", jsonSerializationContext.serialize(batteryInfoBean.bluetooth));
            jsonObject.add("wifi", jsonSerializationContext.serialize(batteryInfoBean.wifi));
            jsonObject.add("location", jsonSerializationContext.serialize(batteryInfoBean.location));
            jsonObject.add("cpuFreq", jsonSerializationContext.serialize(batteryInfoBean.cpuFreq));
            jsonObject.add("batteryTemp", jsonSerializationContext.serialize(batteryInfoBean.batteryTemp));
            jsonObject.add("trafficStatus", jsonSerializationContext.serialize(batteryInfoBean.trafficStatus));
            jsonObject.add("appStats", jsonSerializationContext.serialize(batteryInfoBean.appStats));
            return jsonObject;
        }
    }
}
