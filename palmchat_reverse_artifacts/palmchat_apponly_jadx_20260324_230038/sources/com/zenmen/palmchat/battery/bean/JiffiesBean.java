package com.zenmen.palmchat.battery.bean;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class JiffiesBean {
    public String avgJiffies;
    public int curThreadNum;
    public String during;
    public String fg;
    public int incThreadNum;
    public boolean invalid;
    public boolean overHeat;
    public int pid;
    public int threadEntries;
    public List<ThreadJiffies> threadJiffies = new ArrayList();
    public String totalJiffies;

    /* JADX INFO: compiled from: SearchBox */
    public static class JiffiesBeanJsonSerializer implements JsonSerializer<JiffiesBean> {
        @Override // com.google.gson.JsonSerializer
        public JsonElement serialize(JiffiesBean jiffiesBean, Type type, JsonSerializationContext jsonSerializationContext) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.add("pid", jsonSerializationContext.serialize(Integer.valueOf(jiffiesBean.pid)));
            jsonObject.add("fg", jsonSerializationContext.serialize(jiffiesBean.fg));
            jsonObject.add("during", jsonSerializationContext.serialize(jiffiesBean.during));
            jsonObject.add("totalJiffies", jsonSerializationContext.serialize(jiffiesBean.totalJiffies));
            jsonObject.add("avgJiffies", jsonSerializationContext.serialize(jiffiesBean.avgJiffies));
            jsonObject.add("threadEntries", jsonSerializationContext.serialize(Integer.valueOf(jiffiesBean.threadEntries)));
            jsonObject.add("incThreadNum", jsonSerializationContext.serialize(Integer.valueOf(jiffiesBean.incThreadNum)));
            jsonObject.add("curThreadNum", jsonSerializationContext.serialize(Integer.valueOf(jiffiesBean.curThreadNum)));
            jsonObject.add("overHeat", jsonSerializationContext.serialize(Boolean.valueOf(jiffiesBean.overHeat)));
            jsonObject.add("invalid", jsonSerializationContext.serialize(Boolean.valueOf(jiffiesBean.invalid)));
            jsonObject.add("threadJiffies", jsonSerializationContext.serialize(jiffiesBean.threadJiffies));
            return jsonObject;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class ThreadJiffies {
        public long avgJiffies;
        public String customMessage;
        public long entryJiffies;
        public boolean isNewAdded;
        public String stat;
        public String threadName;
        public int threadTid;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class ThreadJiffiesJsonSerializer implements JsonSerializer<ThreadJiffies> {
        @Override // com.google.gson.JsonSerializer
        public JsonElement serialize(ThreadJiffies threadJiffies, Type type, JsonSerializationContext jsonSerializationContext) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.add("isNewAdded", jsonSerializationContext.serialize(Boolean.valueOf(threadJiffies.isNewAdded)));
            jsonObject.add("stat", jsonSerializationContext.serialize(threadJiffies.stat));
            jsonObject.add("threadName", jsonSerializationContext.serialize(threadJiffies.threadName));
            jsonObject.add("threadTid", jsonSerializationContext.serialize(Integer.valueOf(threadJiffies.threadTid)));
            jsonObject.add("entryJiffies", jsonSerializationContext.serialize(Long.valueOf(threadJiffies.entryJiffies)));
            jsonObject.add("avgJiffies", jsonSerializationContext.serialize(Long.valueOf(threadJiffies.avgJiffies)));
            jsonObject.add("customMessage", jsonSerializationContext.serialize(threadJiffies.customMessage));
            return jsonObject;
        }
    }
}
