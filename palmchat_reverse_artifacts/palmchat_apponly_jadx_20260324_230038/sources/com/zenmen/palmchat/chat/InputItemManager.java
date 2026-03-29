package com.zenmen.palmchat.chat;

import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.lu4;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class InputItemManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static AtomicInteger f12663a = a();

    /* JADX INFO: compiled from: SearchBox */
    public enum InputItemType {
        INPUT_ITEM_INVALID(0),
        INPUT_ITEM_IMAGE(1),
        INPUT_ITEM_CAMERA(2),
        INPUT_ITEM_FILE(4),
        INPUT_ITEM_VIDEO_CALL(8),
        INPUT_ITEM_GROUP_VOICE_CALL(16),
        INPUT_ITEM_LOCATION(32),
        INPUT_ITEM_NAME_CARD(64),
        INPUT_ITEM_REDPACKET(128),
        INPUT_ITEM_BIG_TEXT(256),
        INPUT_ITEM_SIGHT(512),
        INPUT_ITEM_TRANSFER(1024),
        INPUT_ITEM_VOUCHER(2048),
        INPUT_ITEM_GIFT(4096),
        INPUT_ITEM_AUDIO(8192),
        INPUT_ITEM_EXPRESSION(16384);

        private int value;

        InputItemType(int i) {
            this.value = i;
        }

        public static InputItemType obtainInputItemType(int i) {
            InputItemType inputItemType = INPUT_ITEM_IMAGE;
            if (i == inputItemType.value) {
                return inputItemType;
            }
            InputItemType inputItemType2 = INPUT_ITEM_FILE;
            if (i == inputItemType2.value) {
                return inputItemType2;
            }
            InputItemType inputItemType3 = INPUT_ITEM_LOCATION;
            if (i == inputItemType3.value) {
                return inputItemType3;
            }
            InputItemType inputItemType4 = INPUT_ITEM_NAME_CARD;
            if (i == inputItemType4.value) {
                return inputItemType4;
            }
            InputItemType inputItemType5 = INPUT_ITEM_BIG_TEXT;
            if (i == inputItemType5.value) {
                return inputItemType5;
            }
            InputItemType inputItemType6 = INPUT_ITEM_SIGHT;
            if (i == inputItemType6.value) {
                return inputItemType6;
            }
            InputItemType inputItemType7 = INPUT_ITEM_CAMERA;
            if (i == inputItemType7.value) {
                return inputItemType7;
            }
            InputItemType inputItemType8 = INPUT_ITEM_VIDEO_CALL;
            if (i == inputItemType8.value) {
                return inputItemType8;
            }
            InputItemType inputItemType9 = INPUT_ITEM_GROUP_VOICE_CALL;
            if (i == inputItemType9.value) {
                return inputItemType9;
            }
            InputItemType inputItemType10 = INPUT_ITEM_REDPACKET;
            if (i == inputItemType10.value) {
                return inputItemType10;
            }
            InputItemType inputItemType11 = INPUT_ITEM_TRANSFER;
            if (i == inputItemType11.value) {
                return inputItemType11;
            }
            InputItemType inputItemType12 = INPUT_ITEM_VOUCHER;
            if (i == inputItemType12.value) {
                return inputItemType12;
            }
            InputItemType inputItemType13 = INPUT_ITEM_GIFT;
            return i == inputItemType13.value ? inputItemType13 : INPUT_ITEM_INVALID;
        }

        public void setValue(int i) {
            this.value = i;
        }
    }

    public static AtomicInteger a() {
        return new AtomicInteger(InputItemType.INPUT_ITEM_IMAGE.value | InputItemType.INPUT_ITEM_FILE.value | InputItemType.INPUT_ITEM_LOCATION.value | InputItemType.INPUT_ITEM_NAME_CARD.value | (lu4.a() ? InputItemType.INPUT_ITEM_REDPACKET.value : 0) | 0 | InputItemType.INPUT_ITEM_VIDEO_CALL.value | InputItemType.INPUT_ITEM_GROUP_VOICE_CALL.value | 0 | (lu4.d() ? InputItemType.INPUT_ITEM_TRANSFER.value : 0));
    }

    public static void b(InputItemType inputItemType) {
        AtomicInteger atomicInteger = f12663a;
        atomicInteger.set((~inputItemType.value) & atomicInteger.get());
    }

    public static void c(InputItemType inputItemType) {
        AtomicInteger atomicInteger = f12663a;
        atomicInteger.set(inputItemType.value | atomicInteger.get());
    }

    public static int d() {
        String binaryString = Integer.toBinaryString(f12663a.get());
        int i = 0;
        for (int i2 = 0; i2 < binaryString.length(); i2++) {
            if (binaryString.charAt(i2) == '1') {
                i++;
            }
        }
        return i;
    }

    public static InputItemType e(int i) {
        String binaryString = Integer.toBinaryString(f12663a.get());
        LogUtil.d("InputItemManager", "binaryString " + binaryString);
        int i2 = 0;
        for (int length = binaryString.length() + (-1); length >= 0; length--) {
            if (binaryString.charAt(length) == '1') {
                if (i2 == i) {
                    StringBuilder sb = new StringBuilder("1");
                    for (int i3 = 0; i3 < (binaryString.length() - length) - 1; i3++) {
                        sb.append('0');
                    }
                    return InputItemType.obtainInputItemType(Integer.valueOf(sb.toString(), 2).intValue());
                }
                i2++;
            }
        }
        throw new IndexOutOfBoundsException();
    }

    public static void f() {
        InputItemType.INPUT_ITEM_IMAGE.setValue(1);
        InputItemType.INPUT_ITEM_CAMERA.setValue(2);
        InputItemType.INPUT_ITEM_VIDEO_CALL.setValue(4);
        InputItemType.INPUT_ITEM_LOCATION.setValue(8);
        InputItemType.INPUT_ITEM_REDPACKET.setValue(16);
        InputItemType.INPUT_ITEM_TRANSFER.setValue(32);
        InputItemType.INPUT_ITEM_NAME_CARD.setValue(64);
        InputItemType.INPUT_ITEM_FILE.setValue(128);
        InputItemType.INPUT_ITEM_GROUP_VOICE_CALL.setValue(256);
        InputItemType.INPUT_ITEM_BIG_TEXT.setValue(512);
        InputItemType.INPUT_ITEM_SIGHT.setValue(1024);
        f12663a = a();
    }
}
