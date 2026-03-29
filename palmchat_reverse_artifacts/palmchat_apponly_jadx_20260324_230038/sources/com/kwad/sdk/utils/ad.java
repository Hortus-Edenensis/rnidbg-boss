package com.kwad.sdk.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class ad {
    private static ad beu;
    private static final Object mLock = new Object();
    private final Context beq;
    private final HashMap<BroadcastReceiver, ArrayList<b>> ber = new HashMap<>();
    private final HashMap<String, ArrayList<b>> bes = new HashMap<>();
    private final ArrayList<a> bet = new ArrayList<>();
    private final Handler iK;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {
        final ArrayList<b> bew;
        final Intent intent;

        public a(Intent intent, ArrayList<b> arrayList) {
            this.intent = intent;
            this.bew = arrayList;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {
        final BroadcastReceiver bex;
        boolean bey;
        boolean bez;
        final IntentFilter filter;

        public b(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.filter = intentFilter;
            this.bex = broadcastReceiver;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.bex);
            sb.append(" filter=");
            sb.append(this.filter);
            if (this.bez) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    private ad(Context context) {
        this.beq = context;
        this.iK = new Handler(context.getMainLooper()) { // from class: com.kwad.sdk.utils.ad.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                if (message.what != 1) {
                    super.handleMessage(message);
                } else {
                    ad.this.RS();
                }
            }
        };
    }

    public static ad cX(Context context) {
        ad adVar;
        synchronized (mLock) {
            if (beu == null) {
                beu = new ad(context.getApplicationContext());
            }
            adVar = beu;
        }
        return adVar;
    }

    public final void RS() {
        int size;
        a[] aVarArr;
        while (true) {
            synchronized (this.ber) {
                size = this.bet.size();
                if (size <= 0) {
                    return;
                }
                aVarArr = new a[size];
                this.bet.toArray(aVarArr);
                this.bet.clear();
            }
            for (int i = 0; i < size; i++) {
                a aVar = aVarArr[i];
                int size2 = aVar.bew.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    b bVar = aVar.bew.get(i2);
                    if (!bVar.bez) {
                        bVar.bex.onReceive(this.beq, aVar.intent);
                    }
                }
            }
        }
    }

    public final void a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.ber) {
            b bVar = new b(intentFilter, broadcastReceiver);
            ArrayList<b> arrayList = this.ber.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.ber.put(broadcastReceiver, arrayList);
            }
            arrayList.add(bVar);
            for (int i = 0; i < intentFilter.countActions(); i++) {
                String action = intentFilter.getAction(i);
                ArrayList<b> arrayList2 = this.bes.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.bes.put(action, arrayList2);
                }
                arrayList2.add(bVar);
            }
        }
    }

    public final boolean i(Intent intent) {
        int i;
        String str;
        ArrayList arrayList;
        ArrayList<b> arrayList2;
        String str2;
        synchronized (this.ber) {
            String action = intent.getAction();
            String strResolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.beq.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z = (intent.getFlags() & 8) != 0;
            if (z) {
                Log.v("KsLocalBroadcastManager", "Resolving type " + strResolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
            }
            ArrayList<b> arrayList3 = this.bes.get(intent.getAction());
            if (arrayList3 != null) {
                if (z) {
                    Log.v("KsLocalBroadcastManager", "Action list: " + arrayList3);
                }
                ArrayList arrayList4 = null;
                int i2 = 0;
                while (i2 < arrayList3.size()) {
                    b bVar = arrayList3.get(i2);
                    if (z) {
                        Log.v("KsLocalBroadcastManager", "Matching against filter " + bVar.filter);
                    }
                    if (bVar.bey) {
                        if (z) {
                            Log.v("KsLocalBroadcastManager", "  Filter's target already added");
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
                        int iMatch = bVar.filter.match(action, strResolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                        if (iMatch >= 0) {
                            if (z) {
                                Log.v("KsLocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(iMatch));
                            }
                            arrayList4 = arrayList == null ? new ArrayList() : arrayList;
                            arrayList4.add(bVar);
                            bVar.bey = true;
                            i2 = i + 1;
                            action = str;
                            arrayList3 = arrayList2;
                            strResolveTypeIfNeeded = str2;
                        } else if (z) {
                            Log.v("KsLocalBroadcastManager", "  Filter did not match: " + (iMatch != -4 ? iMatch != -3 ? iMatch != -2 ? iMatch != -1 ? "unknown reason" : "type" : "data" : "action" : com.huawei.openalliance.ad.constant.x.cw));
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
                        ((b) arrayList5.get(i3)).bey = false;
                    }
                    this.bet.add(new a(intent, arrayList5));
                    if (!this.iK.hasMessages(1)) {
                        this.iK.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }

    public final void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        synchronized (this.ber) {
            ArrayList<b> arrayListRemove = this.ber.remove(broadcastReceiver);
            if (arrayListRemove == null) {
                return;
            }
            for (int size = arrayListRemove.size() - 1; size >= 0; size--) {
                b bVar = arrayListRemove.get(size);
                bVar.bez = true;
                for (int i = 0; i < bVar.filter.countActions(); i++) {
                    String action = bVar.filter.getAction(i);
                    ArrayList<b> arrayList = this.bes.get(action);
                    if (arrayList != null) {
                        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                            b bVar2 = arrayList.get(size2);
                            if (bVar2.bex == broadcastReceiver) {
                                bVar2.bez = true;
                                arrayList.remove(size2);
                            }
                        }
                        if (arrayList.size() <= 0) {
                            this.bes.remove(action);
                        }
                    }
                }
            }
        }
    }
}
