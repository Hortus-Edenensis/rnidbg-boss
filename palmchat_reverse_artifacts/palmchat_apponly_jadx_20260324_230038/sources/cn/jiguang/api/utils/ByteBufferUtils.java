package cn.jiguang.api.utils;

import cn.jiguang.api.JResponse;
import defpackage.l63;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class ByteBufferUtils {
    public static String a(Throwable th, JResponse jResponse, ByteBuffer byteBuffer) {
        StringBuilder sb = new StringBuilder();
        if (jResponse != null) {
            sb.append(jResponse.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("|bytebuffer:");
            sb2.append(byteBuffer == null ? "byteBuffer is null" : byteBuffer.toString());
            sb.append(sb2.toString());
        }
        l63.c("ByteBufferUtils", "byteBuffer info:" + sb.toString());
        try {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            l63.c("ByteBufferUtils", "parse data error stackTrace:" + stringWriter.toString());
        } catch (Exception unused) {
        }
        return sb.toString();
    }

    public static void b(Throwable th, JResponse jResponse, ByteBuffer byteBuffer) {
        a(th, jResponse, byteBuffer);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ByteBuffer get(ByteBuffer byteBuffer, byte[] bArr, JResponse jResponse) {
        try {
            return byteBuffer.get(bArr);
        } catch (BufferOverflowException e) {
            b(e.fillInStackTrace(), jResponse, byteBuffer);
            if (jResponse == null) {
                return null;
            }
            jResponse.d = 10000;
            return null;
        } catch (BufferUnderflowException e2) {
            b(e2.fillInStackTrace(), jResponse, byteBuffer);
            if (jResponse == null) {
            }
        } catch (Exception e3) {
            b(e3.fillInStackTrace(), jResponse, byteBuffer);
            if (jResponse == null) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int getInt(ByteBuffer byteBuffer, JResponse jResponse) {
        try {
            return byteBuffer.getInt();
        } catch (BufferOverflowException e) {
            b(e.fillInStackTrace(), jResponse, byteBuffer);
            if (jResponse == null) {
                return -1;
            }
            jResponse.d = 10000;
            return -1;
        } catch (BufferUnderflowException e2) {
            b(e2.fillInStackTrace(), jResponse, byteBuffer);
            if (jResponse == null) {
            }
        } catch (Exception e3) {
            b(e3.fillInStackTrace(), jResponse, byteBuffer);
            if (jResponse == null) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long getLong(ByteBuffer byteBuffer, JResponse jResponse) {
        try {
            return byteBuffer.getLong();
        } catch (BufferOverflowException e) {
            b(e.fillInStackTrace(), jResponse, byteBuffer);
            if (jResponse == null) {
                return 0L;
            }
            jResponse.d = 10000;
            return 0L;
        } catch (BufferUnderflowException e2) {
            b(e2.fillInStackTrace(), jResponse, byteBuffer);
            if (jResponse == null) {
            }
        } catch (Exception e3) {
            b(e3.fillInStackTrace(), jResponse, byteBuffer);
            if (jResponse == null) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static short getShort(ByteBuffer byteBuffer, JResponse jResponse) {
        try {
            return byteBuffer.getShort();
        } catch (BufferOverflowException e) {
            b(e.fillInStackTrace(), jResponse, byteBuffer);
            if (jResponse == null) {
                return (short) -1;
            }
            jResponse.d = 10000;
            return (short) -1;
        } catch (BufferUnderflowException e2) {
            b(e2.fillInStackTrace(), jResponse, byteBuffer);
            if (jResponse == null) {
            }
        } catch (Exception e3) {
            b(e3.fillInStackTrace(), jResponse, byteBuffer);
            if (jResponse == null) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Byte get(ByteBuffer byteBuffer, JResponse jResponse) {
        try {
            return Byte.valueOf(byteBuffer.get());
        } catch (BufferOverflowException e) {
            b(e.fillInStackTrace(), jResponse, byteBuffer);
            if (jResponse == null) {
                return null;
            }
            jResponse.d = 10000;
            return null;
        } catch (BufferUnderflowException e2) {
            b(e2.fillInStackTrace(), jResponse, byteBuffer);
            if (jResponse == null) {
            }
        } catch (Exception e3) {
            b(e3.fillInStackTrace(), jResponse, byteBuffer);
            if (jResponse == null) {
            }
        }
    }
}
