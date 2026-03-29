package com.zenmen.palmchat.contacts;

import android.app.IntentService;
import android.content.Intent;
import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ContactsService extends IntentService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f13333a = "ContactsService";

    public ContactsService() {
        super(f13333a);
    }

    @Override // android.app.IntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.IntentService
    public void onHandleIntent(Intent intent) {
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return;
        }
        action.equals("action_get_friend_list");
    }
}
