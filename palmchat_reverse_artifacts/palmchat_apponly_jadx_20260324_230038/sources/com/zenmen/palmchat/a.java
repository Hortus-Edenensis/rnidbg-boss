package com.zenmen.palmchat;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.b35;
import defpackage.c5;
import defpackage.n54;
import defpackage.sm5;
import defpackage.vn0;
import defpackage.wc;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class a {

    /* JADX INFO: renamed from: com.zenmen.palmchat.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C0949a implements c5<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f12173a;
        public final /* synthetic */ d b;

        public C0949a(Activity activity, d dVar) {
            this.f12173a = activity;
            this.b = dVar;
        }

        @Override // defpackage.c5
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(Integer num) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", num);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            LogUtil.uploadInfoImmediate("ar06", null, null, jSONObject.toString());
            if (this.f12173a == null || this.b == null) {
                return;
            }
            try {
                String str = "tab_msg";
                if (num.intValue() == 1) {
                    str = "tab_discover";
                }
                this.b.a(str);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements n54.a<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f12174a;

        public c(Activity activity) {
            this.f12174a = activity;
        }

        @Override // defpackage.c5
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(sm5<? super Integer> sm5Var) {
            Activity activity = this.f12174a;
            sm5Var.onNext(Integer.valueOf((activity == null || !a.b(activity)) ? 6 : 1));
            sm5Var.onCompleted();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d {
        void a(String str);
    }

    public static boolean b(Context context) {
        boolean z = false;
        if (context == null || context.getContentResolver() == null) {
            return false;
        }
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = context.getContentResolver().query(vn0.f21483a, null, "read_status = ? and (source_type = ? or source_type = ? ) and request_type < ? ", new String[]{String.valueOf(0L), String.valueOf(3), String.valueOf(20), String.valueOf(100)}, "_id DESC limit 1");
                if (cursorQuery != null) {
                    if (cursorQuery.getCount() > 0) {
                        z = true;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (cursorQuery != null) {
                }
            }
            return z;
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    public static void c(Activity activity, d dVar) {
        n54.a(new c(activity)).u(b35.c()).i(wc.a()).q(new C0949a(activity, dVar), new b());
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements c5<Throwable> {
        @Override // defpackage.c5
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(Throwable th) {
        }
    }
}
