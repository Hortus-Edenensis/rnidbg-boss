package cn.fly.verify;

import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.ShortCompanionObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class dn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f2187a;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Number f2188a;
        private Number b;
        private Number c;
        private Number d;
        private boolean e;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r13v22, types: [java.lang.Number] */
        /* JADX WARN: Type inference failed for: r13v29 */
        /* JADX WARN: Type inference failed for: r13v30 */
        /* JADX WARN: Type inference failed for: r13v31 */
        /* JADX WARN: Type inference failed for: r13v32 */
        /* JADX WARN: Type inference failed for: r13v33 */
        /* JADX WARN: Type inference failed for: r13v34 */
        /* JADX WARN: Type inference failed for: r13v35 */
        /* JADX WARN: Type inference failed for: r13v36 */
        public a(Number number, Number number2, Number number3) {
            Number[] numberArr = {number, number2, number3};
            int[] iArr = {0, 0, 0};
            for (int i = 0; i < 3; i++) {
                Number number4 = numberArr[i];
                if (number4 != null) {
                    if (number4 instanceof Byte) {
                        iArr[i] = 1;
                    } else if (number4 instanceof Short) {
                        iArr[i] = 2;
                    } else if (number4 instanceof Integer) {
                        iArr[i] = 3;
                    } else if (number4 instanceof Long) {
                        iArr[i] = 4;
                    } else if (number4 instanceof Float) {
                        iArr[i] = 5;
                    } else if (number4 instanceof Double) {
                        iArr[i] = 6;
                    }
                }
            }
            int i2 = 0;
            for (int i3 = 0; i3 < 3; i3++) {
                int i4 = iArr[i3];
                if (i2 < i4) {
                    i2 = i4;
                }
            }
            ?? ValueOf = number;
            if (number != null) {
                switch (i2) {
                    case 1:
                        ValueOf = Byte.valueOf(Double.valueOf(String.valueOf(number)).byteValue());
                        break;
                    case 2:
                        ValueOf = Short.valueOf(Double.valueOf(String.valueOf(number)).shortValue());
                        break;
                    case 3:
                        ValueOf = Integer.valueOf(Double.valueOf(String.valueOf(number)).intValue());
                        break;
                    case 4:
                        ValueOf = Long.valueOf(Double.valueOf(String.valueOf(number)).longValue());
                        break;
                    case 5:
                        ValueOf = Float.valueOf(Double.valueOf(String.valueOf(number)).floatValue());
                        break;
                    case 6:
                        ValueOf = Double.valueOf(String.valueOf(number));
                        break;
                }
            } else {
                ValueOf = new Number[]{Integer.MIN_VALUE, Byte.valueOf(ByteCompanionObject.MIN_VALUE), Short.valueOf(ShortCompanionObject.MIN_VALUE), Integer.MIN_VALUE, Long.MIN_VALUE, Float.valueOf(Float.MIN_VALUE), Double.valueOf(Double.MIN_VALUE)}[i2];
            }
            if (number2 != null) {
                switch (i2) {
                    case 1:
                        number2 = Byte.valueOf(Double.valueOf(String.valueOf(number2)).byteValue());
                        break;
                    case 2:
                        number2 = Short.valueOf(Double.valueOf(String.valueOf(number2)).shortValue());
                        break;
                    case 3:
                        number2 = Integer.valueOf(Double.valueOf(String.valueOf(number2)).intValue());
                        break;
                    case 4:
                        number2 = Long.valueOf(Double.valueOf(String.valueOf(number2)).longValue());
                        break;
                    case 5:
                        number2 = Float.valueOf(Double.valueOf(String.valueOf(number2)).floatValue());
                        break;
                    case 6:
                        number2 = Double.valueOf(String.valueOf(number2));
                        break;
                }
            } else {
                number2 = new Number[]{Integer.MAX_VALUE, Byte.valueOf(ByteCompanionObject.MAX_VALUE), Short.valueOf(ShortCompanionObject.MAX_VALUE), Integer.MAX_VALUE, Long.MAX_VALUE, Float.valueOf(Float.MAX_VALUE), Double.valueOf(Double.MAX_VALUE)}[i2];
            }
            this.f2188a = ValueOf;
            this.b = number2;
            this.c = number3;
            boolean z = ((Comparable) ValueOf).compareTo(number2) > 0;
            this.e = z;
            if (this.c == null) {
                this.c = Integer.valueOf(z ? -1 : 1);
            }
        }

        public Number b() {
            int iByteValue;
            int iByteValue2;
            Number numberValueOf;
            if (this.d == null) {
                this.d = this.f2188a;
            }
            Number number = this.d;
            Number number2 = this.c;
            if (number2 instanceof Double) {
                numberValueOf = Double.valueOf(number.doubleValue() + this.c.doubleValue());
            } else if (number2 instanceof Float) {
                numberValueOf = Float.valueOf(number.floatValue() + this.c.floatValue());
            } else if (number2 instanceof Long) {
                numberValueOf = Long.valueOf(number.longValue() + this.c.longValue());
            } else {
                if (number2 instanceof Integer) {
                    iByteValue = number.intValue();
                    iByteValue2 = this.c.intValue();
                } else if (number2 instanceof Short) {
                    iByteValue = number.shortValue();
                    iByteValue2 = this.c.shortValue();
                } else {
                    iByteValue = number.byteValue();
                    iByteValue2 = this.c.byteValue();
                }
                numberValueOf = Integer.valueOf(iByteValue + iByteValue2);
            }
            this.d = numberValueOf;
            return number;
        }

        public boolean a() {
            Object obj = this.d;
            if (obj == null) {
                obj = this.f2188a;
            }
            Comparable comparable = (Comparable) obj;
            return this.e ? comparable.compareTo(this.b) >= 0 : comparable.compareTo(this.b) <= 0;
        }
    }

    public dn(Number number, Number number2, Number number3) {
        this.f2187a = new a(number, number2, number3);
    }

    public a a() {
        return this.f2187a;
    }

    public boolean b(Number number) {
        return a(number);
    }

    public boolean a(Number number) {
        return ((Comparable) this.f2187a.f2188a).compareTo(number) <= 0 && ((Comparable) this.f2187a.b).compareTo(number) >= 0;
    }

    public Number[] b() {
        return new Number[]{this.f2187a.f2188a, this.f2187a.b};
    }
}
