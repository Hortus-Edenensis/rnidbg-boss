package com.tencent.matrix.report;

import com.tencent.matrix.plugin.Plugin;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Issue {
    public static final String ISSUE_REPORT_PROCESS = "process";
    public static final String ISSUE_REPORT_TAG = "tag";
    public static final String ISSUE_REPORT_TIME = "time";
    public static final String ISSUE_REPORT_TYPE = "type";
    private JSONObject content;
    private String key;
    private Plugin plugin;
    private String tag;
    private int type;

    public Issue() {
    }

    public JSONObject getContent() {
        return this.content;
    }

    public String getKey() {
        return this.key;
    }

    public Plugin getPlugin() {
        return this.plugin;
    }

    public String getTag() {
        return this.tag;
    }

    public int getType() {
        return this.type;
    }

    public void setContent(JSONObject jSONObject) {
        this.content = jSONObject;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setPlugin(Plugin plugin) {
        this.plugin = plugin;
    }

    public void setTag(String str) {
        this.tag = str;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String toString() {
        JSONObject jSONObject = this.content;
        return String.format("tag[%s]type[%d];key[%s];content[%s]", this.tag, Integer.valueOf(this.type), this.key, jSONObject != null ? jSONObject.toString() : "");
    }

    public Issue(int i) {
        this.type = i;
    }

    public Issue(JSONObject jSONObject) {
        this.content = jSONObject;
    }
}
