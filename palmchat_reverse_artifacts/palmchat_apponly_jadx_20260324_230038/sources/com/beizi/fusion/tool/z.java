package com.beizi.fusion.tool;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class z {
    private static final Object f = new Object();
    private static z g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f4754a;
    private final HashMap<BroadcastReceiver, ArrayList<b>> b = new HashMap<>();
    private final HashMap<String, ArrayList<b>> c = new HashMap<>();
    private final ArrayList<a> d = new ArrayList<>();
    private final Handler e;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Intent f4756a;
        final ArrayList<b> b;

        public a(Intent intent, ArrayList<b> arrayList) {
            this.f4756a = intent;
            this.b = arrayList;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final IntentFilter f4757a;
        final BroadcastReceiver b;
        boolean c;
        boolean d;

        public b(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.f4757a = intentFilter;
            this.b = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.b);
            sb.append(" filter=");
            sb.append(this.f4757a);
            if (this.d) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    private z(Context context) {
        this.f4754a = context;
        this.e = new Handler(context.getMainLooper()) { // from class: com.beizi.fusion.tool.z.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 1) {
                    super.handleMessage(message);
                } else {
                    z.this.a();
                }
            }
        };
    }

    @NonNull
    public static z a(@NonNull Context context) {
        z zVar;
        synchronized (f) {
            if (g == null) {
                g = new z(context.getApplicationContext());
            }
            zVar = g;
        }
        return zVar;
    }

    public void a(@NonNull BroadcastReceiver broadcastReceiver, @NonNull IntentFilter intentFilter) {
        synchronized (this.b) {
            try {
                b bVar = new b(intentFilter, broadcastReceiver);
                ArrayList<b> arrayList = this.b.get(broadcastReceiver);
                if (arrayList == null) {
                    arrayList = new ArrayList<>(1);
                    this.b.put(broadcastReceiver, arrayList);
                }
                arrayList.add(bVar);
                for (int i = 0; i < intentFilter.countActions(); i++) {
                    String action = intentFilter.getAction(i);
                    ArrayList<b> arrayList2 = this.c.get(action);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList<>(1);
                        this.c.put(action, arrayList2);
                    }
                    arrayList2.add(bVar);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void a(@NonNull BroadcastReceiver broadcastReceiver) {
        ArrayList<b> arrayListRemove;
        synchronized (this.b) {
            try {
                arrayListRemove = this.b.remove(broadcastReceiver);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (arrayListRemove == null) {
                return;
            }
            for (int size = arrayListRemove.size() - 1; size >= 0; size--) {
                b bVar = arrayListRemove.get(size);
                bVar.d = true;
                for (int i = 0; i < bVar.f4757a.countActions(); i++) {
                    String action = bVar.f4757a.getAction(i);
                    ArrayList<b> arrayList = this.c.get(action);
                    if (arrayList != null) {
                        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                            b bVar2 = arrayList.get(size2);
                            if (bVar2.b == broadcastReceiver) {
                                bVar2.d = true;
                                arrayList.remove(size2);
                            }
                        }
                        if (arrayList.size() <= 0) {
                            this.c.remove(action);
                        }
                    }
                }
            }
        }
    }

    public boolean a(@NonNull Intent intent) {
        int i;
        String str;
        ArrayList arrayList;
        ArrayList<b> arrayList2;
        String str2;
        synchronized (this.b) {
            try {
                try {
                    String action = intent.getAction();
                    String strResolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f4754a.getContentResolver());
                    Uri data = intent.getData();
                    String scheme = intent.getScheme();
                    Set<String> categories = intent.getCategories();
                    boolean z = (intent.getFlags() & 8) != 0;
                    if (z) {
                        Log.v("LocalBroadcastManager", "Resolving type " + strResolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
                    }
                    ArrayList<b> arrayList3 = this.c.get(intent.getAction());
                    if (arrayList3 != null) {
                        if (z) {
                            Log.v("LocalBroadcastManager", "Action list: " + arrayList3);
                        }
                        ArrayList arrayList4 = null;
                        int i2 = 0;
                        while (i2 < arrayList3.size()) {
                            b bVar = arrayList3.get(i2);
                            if (z) {
                                Log.v("LocalBroadcastManager", "Matching against filter " + bVar.f4757a);
                            }
                            if (bVar.c) {
                                if (z) {
                                    Log.v("LocalBroadcastManager", "  Filter's target already added");
                                }
                                i = i2;
                                arrayList2 = arrayList3;
                                str = action;
                                str2 = strResolveTypeIfNeeded;
                                arrayList = arrayList4;
                            } else {
                                i = i2;
                                str = action;
                                arrayList = arrayList4;
                                arrayList2 = arrayList3;
                                str2 = strResolveTypeIfNeeded;
                                int iMatch = bVar.f4757a.match(action, strResolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                                if (iMatch >= 0) {
                                    if (z) {
                                        Log.v("LocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(iMatch));
                                    }
                                    arrayList4 = arrayList == null ? new ArrayList() : arrayList;
                                    arrayList4.add(bVar);
                                    bVar.c = true;
                                    i2 = i + 1;
                                    action = str;
                                    arrayList3 = arrayList2;
                                    strResolveTypeIfNeeded = str2;
                                } else if (z) {
                                    Log.v("LocalBroadcastManager", "  Filter did not match: " + (iMatch != -4 ? iMatch != -3 ? iMatch != -2 ? iMatch != -1 ? "unknown reason" : "type" : "data" : "action" : com.huawei.openalliance.ad.constant.x.cw));
                                }
                            }
                            arrayList4 = arrayList;
                            i2 = i + 1;
                            action = str;
                            arrayList3 = arrayList2;
                            strResolveTypeIfNeeded = str2;
                        }
                        ArrayList arrayList5 = arrayList4;
                        if (arrayList5 != null) {
                            for (int i3 = 0; i3 < arrayList5.size(); i3++) {
                                ((b) arrayList5.get(i3)).c = false;
                            }
                            this.d.add(new a(intent, arrayList5));
                            if (!this.e.hasMessages(1)) {
                                this.e.sendEmptyMessage(1);
                            }
                            return true;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        int size;
        a[] aVarArr;
        while (true) {
            synchronized (this.b) {
                size = this.d.size();
                if (size <= 0) {
                    return;
                }
                aVarArr = new a[size];
                this.d.toArray(aVarArr);
                this.d.clear();
            }
            for (int i = 0; i < size; i++) {
                a aVar = aVarArr[i];
                int size2 = aVar.b.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    b bVar = aVar.b.get(i2);
                    if (!bVar.d) {
                        bVar.b.onReceive(this.f4754a, aVar.f4756a);
                    }
                }
            }
        }
    }
}
