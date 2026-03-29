package com.qq.gdt.action.j;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f10535a;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(com.qq.gdt.action.d.a().g().getFilesDir());
        String str = File.separator;
        sb.append(str);
        sb.append("gdtDir");
        sb.append(str);
        sb.append("gdt_user_message_v5");
        f10535a = sb.toString();
    }

    public static synchronized com.qq.gdt.action.multioprocess.b a() {
        com.qq.gdt.action.multioprocess.b bVar;
        Object th;
        ObjectInputStream objectInputStream;
        if (!com.qq.gdt.action.multioprocess.a.a().c()) {
            o.a("UserMessage get() no fill，no get info", new Object[0]);
            return null;
        }
        o.a("SerializableUtils get userinfo", new Object[0]);
        com.qq.gdt.action.h.a.a(3402);
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(f10535a));
            try {
                bVar = (com.qq.gdt.action.multioprocess.b) objectInputStream.readObject();
                try {
                    com.qq.gdt.action.h.a.a(3403);
                    try {
                        objectInputStream.close();
                    } catch (Throwable th2) {
                        o.a("SerializableUtils get close ex = " + th2, new Object[0]);
                    }
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        o.a("SerializableUtils get ex = " + th, new Object[0]);
                        com.qq.gdt.action.h.a.a(3404);
                        try {
                            objectInputStream.close();
                        } catch (Throwable th4) {
                            o.a("SerializableUtils get close ex = " + th4, new Object[0]);
                        }
                    } finally {
                    }
                }
            } catch (Throwable th5) {
                bVar = null;
                th = th5;
            }
        } catch (Throwable th6) {
            bVar = null;
            th = th6;
            objectInputStream = null;
        }
        return bVar;
    }

    public static synchronized void a(final com.qq.gdt.action.multioprocess.b bVar) {
        if (com.qq.gdt.action.multioprocess.a.a().c()) {
            j.a().b().execute(new Runnable() { // from class: com.qq.gdt.action.j.s.1
                @Override // java.lang.Runnable
                public void run() {
                    o.a("cp信息开始存储 SerializableUtils save, userMessage = " + bVar, new Object[0]);
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    com.qq.gdt.action.h.a.a(3304, bVar);
                    ObjectOutputStream objectOutputStream = null;
                    try {
                        File file = new File(s.f10535a);
                        if (file.exists()) {
                            file.delete();
                        }
                        if (!file.getParentFile().exists()) {
                            o.a("creating parent directory...", new Object[0]);
                            if (!file.getParentFile().mkdirs()) {
                                throw new Exception("created parent directory failed.");
                            }
                        }
                        file.createNewFile();
                        ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new FileOutputStream(s.f10535a));
                        try {
                            objectOutputStream2.writeObject(bVar);
                            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("ipcSaveFileTimeSuccess", jCurrentTimeMillis2);
                            com.qq.gdt.action.h.a.a(3305, jSONObject, bVar);
                            o.a("cp save file successTime cost = " + jCurrentTimeMillis2, new Object[0]);
                            try {
                                objectOutputStream2.close();
                            } catch (Throwable th) {
                                o.a("SerializableUtils save fileclose ex = " + th, new Object[0]);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            objectOutputStream = objectOutputStream2;
                            try {
                                o.a("SerializableUtils cp save file  save ex  = " + th, new Object[0]);
                                com.qq.gdt.action.h.a.a(3306, bVar);
                                try {
                                    objectOutputStream.close();
                                } catch (Throwable th3) {
                                    o.a("SerializableUtils save fileclose ex = " + th3, new Object[0]);
                                }
                            } catch (Throwable th4) {
                                try {
                                    objectOutputStream.close();
                                } catch (Throwable th5) {
                                    o.a("SerializableUtils save fileclose ex = " + th5, new Object[0]);
                                }
                                throw th4;
                            }
                        }
                    } catch (Throwable th6) {
                        th = th6;
                    }
                    long jCurrentTimeMillis3 = System.currentTimeMillis() - jCurrentTimeMillis;
                    try {
                        new JSONObject().put("ipcSaveFileTimeEnd", jCurrentTimeMillis3);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    o.a("save file endTime cost = " + jCurrentTimeMillis3 + " userMessage = " + bVar, new Object[0]);
                }
            });
        } else {
            o.a("UserMessage save() 未开启补齐信息，不进行文件保存信息", new Object[0]);
        }
    }

    public static synchronized void a(final com.qq.gdt.action.multioprocess.c cVar) {
        if (com.qq.gdt.action.multioprocess.a.a().c()) {
            j.a().b().execute(new Runnable() { // from class: com.qq.gdt.action.j.s.2
                @Override // java.lang.Runnable
                public void run() {
                    cVar.a(s.a());
                }
            });
        } else {
            o.a("UserMessage getAsync() no fill，no get info", new Object[0]);
            cVar.a(null);
        }
    }
}
