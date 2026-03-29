package com.bykv.vk.component.ttvideo.log;

import android.content.Context;
import android.provider.Settings;
import com.bykv.vk.component.ttvideo.utils.TTVideoEngineLog;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public enum e {
    instance;


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private VideoEventEngineUploader f4959a;
    private Context b;

    public void a(Context context) {
        this.b = context.getApplicationContext();
    }

    public synchronized void a(VideoEventEngineUploader videoEventEngineUploader) {
        this.f4959a = videoEventEngineUploader;
    }

    private void a(JSONObject jSONObject) {
        if (((TTVideoEngineLog.LogTurnOn >> 1) & 1) == 1) {
            Context context = this.b;
            String string = context != null ? Settings.Global.getString(context.getContentResolver(), "engine.debug") : "";
            if (string != null) {
                for (String str : string.split(",", -1)) {
                    if (jSONObject.opt(str) != null) {
                        jSONObject.opt(str);
                    }
                }
            }
        }
    }

    public void a(boolean z, JSONObject jSONObject) {
        synchronized (e.class) {
            if (jSONObject == null) {
                return;
            }
            a(jSONObject);
            VideoEventEngineUploader videoEventEngineUploader = this.f4959a;
            if (videoEventEngineUploader != null) {
                videoEventEngineUploader.onEvent("video_playq", jSONObject);
            }
        }
    }
}
