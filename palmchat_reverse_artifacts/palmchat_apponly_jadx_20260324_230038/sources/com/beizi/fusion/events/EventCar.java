package com.beizi.fusion.events;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.beizi.fusion.model.Messenger;
import com.beizi.fusion.model.RequestInfo;
import com.beizi.fusion.model.ResponseInfo;
import com.beizi.fusion.tool.aa;
import com.beizi.fusion.tool.ai;
import com.beizi.fusion.tool.ao;
import com.beizi.fusion.tool.e;
import com.beizi.fusion.tool.g;
import com.beizi.fusion.tool.t;
import com.beizi.fusion.tool.v;
import com.beizi.fusion.tool.y;
import com.oplus.tblplayer.Constants;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class EventCar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static EventCar f4651a;
    private Context b;
    private List<Messenger.EventsBean> c;
    private long d = 128;
    private long e = 172800000;

    private EventCar(Context context) {
        this.b = context;
        RequestInfo requestInfoInit = RequestInfo.getInstance(context).init();
        if (requestInfoInit.isInit()) {
            return;
        }
        requestInfoInit.init();
    }

    public static EventCar getInstance(Context context) {
        if (f4651a == null) {
            synchronized (EventCar.class) {
                if (f4651a == null) {
                    f4651a = new EventCar(context);
                }
            }
        }
        return f4651a;
    }

    public void doUpLoadLogs() {
        int i;
        int i2;
        try {
            aa.a("BeiZis", "===================doUpLoadLogs===================:" + Thread.currentThread().getName());
            long jCurrentTimeMillis = System.currentTimeMillis();
            File fileA = g.a(this.b);
            aa.a("BeiZis", "doUpLoadLogs storagePath == " + fileA);
            if (fileA != null) {
                String str = fileA.getPath() + "/BeiZi/offline/";
                File[] fileArrListFiles = new File(str).listFiles();
                if (fileArrListFiles == null || fileArrListFiles.length <= 0) {
                    return;
                }
                int length = fileArrListFiles.length;
                int i3 = 0;
                int i4 = 0;
                while (i4 < length) {
                    File file = fileArrListFiles[i4];
                    if (file.isDirectory()) {
                        String strA = "";
                        File file2 = new File(str, file.getName() + "/10000.txt");
                        if (file2.exists()) {
                            strA = a(file2);
                        } else {
                            ai.a(file);
                        }
                        String str2 = strA;
                        if (TextUtils.isEmpty(str2)) {
                            i = i4;
                        } else {
                            File[] fileArrListFiles2 = file.listFiles();
                            int length2 = fileArrListFiles2.length;
                            int i5 = 0;
                            while (i5 < length2) {
                                File file3 = fileArrListFiles2[i5];
                                if (file3.getName().equals("10000.txt")) {
                                    i2 = i4;
                                } else {
                                    i2 = i4;
                                    if (jCurrentTimeMillis - Long.valueOf(file3.getName().substring(i3, file3.getName().indexOf("."))).longValue() < this.e) {
                                        String strA2 = v.a(str2, file3);
                                        if (!TextUtils.isEmpty(strA2)) {
                                            try {
                                                if (new JSONObject(strA2).optInt("code") == 200) {
                                                    file3.delete();
                                                }
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    } else {
                                        file3.delete();
                                    }
                                }
                                i5++;
                                i4 = i2;
                                i3 = 0;
                            }
                            i = i4;
                            if (file.listFiles().length <= 1) {
                                ai.a(file);
                            }
                        }
                    } else {
                        i = i4;
                    }
                    i4 = i + 1;
                    i3 = 0;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void goRoad(final EventBean eventBean) {
        e.b().e().execute(new Runnable() { // from class: com.beizi.fusion.events.EventCar.1
            @Override // java.lang.Runnable
            public void run() {
                EventCar.this.a(eventBean);
            }
        });
    }

    public void goRoadWithoutThread(EventBean eventBean) {
        a(eventBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(EventBean eventBean) {
        try {
            ResponseInfo responseInfo = ResponseInfo.getInstance(this.b);
            String strA = a(eventBean.getEventCode());
            if (responseInfo.getMessenger() != null) {
                this.c = responseInfo.getMessenger().getEvents();
                this.d = Long.valueOf(responseInfo.getMessenger().getFileMaxSize()).longValue();
                this.e = responseInfo.getMessenger().getExpireTime();
                List<Messenger.EventsBean> list = this.c;
                if (list == null || list.size() <= 0) {
                    return;
                }
                for (int i = 0; i < this.c.size(); i++) {
                    Messenger.EventsBean eventsBean = this.c.get(i);
                    List<String> codes = eventsBean.getCodes();
                    if (codes != null && codes.size() > 0) {
                        for (int i2 = 0; i2 < codes.size(); i2++) {
                            if (!TextUtils.isEmpty(eventBean.getEventCode()) && !TextUtils.isEmpty(codes.get(i2)) && (eventBean.getEventCode().equals(codes.get(i2)) || strA.equals(codes.get(i2)))) {
                                if (eventsBean.getIsOnline().equals("1")) {
                                    eventBean.setUrl(eventsBean.getUploadUrl());
                                    a(eventsBean, eventBean);
                                } else {
                                    a(eventsBean, eventBean, true);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return str.substring(0, str.indexOf(".") + 1) + "*";
    }

    private void a(Messenger.EventsBean eventsBean, EventBean eventBean) {
        String strA;
        if (eventBean != null) {
            try {
                if (TextUtils.isEmpty(eventBean.getUrl())) {
                    return;
                }
                String url = eventBean.getUrl();
                if ("590.200".equalsIgnoreCase(eventBean.getEventCode())) {
                    url = eventBean.getTaskReqUrl();
                }
                int iIndexOf = url.indexOf(Constants.STRING_VALUE_UNSET);
                String strSubstring = url.substring(0, iIndexOf);
                String strSubstring2 = url.substring(iIndexOf + 1);
                if ("590.200".equalsIgnoreCase(eventBean.getEventCode())) {
                    strA = ao.a(this.b, strSubstring2, eventBean, eventBean.getAppLinks());
                } else {
                    strA = ao.a(this.b, strSubstring2, eventBean);
                }
                String strA2 = com.beizi.fusion.tool.b.a(y.a(), t.a(strA));
                if (strA2 != null) {
                    String strA3 = v.a(strSubstring, strA2.getBytes());
                    if (!TextUtils.isEmpty(strA3)) {
                        try {
                            if (new JSONObject(strA3).optInt("code") != 200) {
                                a(eventsBean, eventBean, true);
                                return;
                            }
                            return;
                        } catch (JSONException e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    a(eventsBean, eventBean, true);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private static String a(File file) {
        FileInputStream fileInputStream;
        BufferedReader bufferedReader;
        StringBuilder sb = new StringBuilder();
        try {
            fileInputStream = new FileInputStream(file);
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        } catch (Exception e) {
            e.printStackTrace();
        }
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            sb.append(line);
            return sb.toString();
        }
        fileInputStream.close();
        return sb.toString();
    }

    private void a(Messenger.EventsBean eventsBean, EventBean eventBean, boolean z) {
        Log.d("BeiZis", "===================doOffline===================:" + eventBean.getEventCode());
        try {
            File fileA = g.a(this.b);
            aa.a("BeiZis", "doOffline storagePath == " + fileA);
            if (fileA != null) {
                String offlineUrl = z ? eventsBean.getOfflineUrl() : eventsBean.getUploadUrl();
                String strSubstring = offlineUrl.substring(0, offlineUrl.indexOf(Constants.STRING_VALUE_UNSET));
                String strA = com.beizi.fusion.tool.b.a(y.a(), ao.a(this.b, offlineUrl.substring(offlineUrl.indexOf(Constants.STRING_VALUE_UNSET) + 1), eventBean));
                String str = fileA.getPath() + "/BeiZi/offline/" + ao.a(eventsBean.toString()) + "/";
                File file = new File(str);
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(file, "10000.txt");
                synchronized (EventCar.class) {
                    if (!file2.exists()) {
                        file2.createNewFile();
                        FileWriter fileWriter = new FileWriter(file2, true);
                        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                        bufferedWriter.write(strSubstring);
                        bufferedWriter.newLine();
                        bufferedWriter.close();
                        fileWriter.close();
                    }
                }
                long jLongValue = 0;
                for (File file3 : file.listFiles()) {
                    String strSubstring2 = file3.getName().substring(0, file3.getName().indexOf("."));
                    if (Long.valueOf(strSubstring2).longValue() > jLongValue) {
                        jLongValue = Long.valueOf(strSubstring2).longValue();
                    }
                }
                if (jLongValue != 0 && jLongValue != 10000) {
                    File file4 = new File(str + jLongValue + ".txt");
                    if (file4.exists() && file4.length() < this.d * 1000) {
                        FileWriter fileWriter2 = new FileWriter(file4, true);
                        BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter2);
                        bufferedWriter2.write(strA);
                        bufferedWriter2.newLine();
                        bufferedWriter2.close();
                        fileWriter2.close();
                        file4.renameTo(new File(file, System.currentTimeMillis() + ".txt"));
                        return;
                    }
                }
                File file5 = new File(file, System.currentTimeMillis() + ".txt");
                file5.createNewFile();
                FileWriter fileWriter3 = new FileWriter(file5, true);
                BufferedWriter bufferedWriter3 = new BufferedWriter(fileWriter3);
                bufferedWriter3.write(strA);
                bufferedWriter3.newLine();
                bufferedWriter3.close();
                fileWriter3.close();
            }
        } catch (IOException unused) {
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
