package com.hihonor.push.sdk;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class q0 implements Callable<HonorPushDataMsg> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Intent f6469a;

    public q0(Intent intent) {
        this.f6469a = intent;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    @Override // java.util.concurrent.Callable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public HonorPushDataMsg call() throws Exception {
        byte[] byteArrayExtra;
        String string;
        Intent intent = this.f6469a;
        if (intent == null) {
            return null;
        }
        long longExtra = 0;
        try {
            longExtra = intent.getLongExtra("msg_id", 0L);
        } catch (Exception e) {
            c.a("PassByMsgIntentParser", "parserMsgId", e);
        }
        try {
            byteArrayExtra = this.f6469a.getByteArrayExtra("msg_content");
        } catch (Exception e2) {
            c.a("PassByMsgIntentParser", "parseMsgContent", e2);
            byteArrayExtra = null;
        }
        if (byteArrayExtra != null && byteArrayExtra.length != 0) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayExtra);
            InflaterInputStream inflaterInputStream = new InflaterInputStream(byteArrayInputStream, new Inflater());
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byte[] bArr = new byte[256];
                while (true) {
                    int i = inflaterInputStream.read(bArr);
                    if (i <= 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i);
                }
                string = byteArrayOutputStream.toString("UTF-8");
            } catch (IOException e3) {
                c.a("DeflateUtil", "unZipString", e3);
                string = null;
            } finally {
                b.a(byteArrayInputStream);
                b.a(inflaterInputStream);
                b.a(byteArrayOutputStream);
            }
            if (string != null) {
                return null;
            }
            String strOptString = new JSONObject(string).optString("data");
            if (TextUtils.isEmpty(strOptString)) {
                return null;
            }
            HonorPushDataMsg honorPushDataMsg = new HonorPushDataMsg();
            honorPushDataMsg.setMsgId(longExtra);
            honorPushDataMsg.setData(strOptString);
            return honorPushDataMsg;
        }
        Log.w("DeflateUtil", "un zip data is empty");
        string = null;
        if (string != null) {
        }
    }
}
