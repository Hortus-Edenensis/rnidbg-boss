package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.ResolutionAnchorProviderKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public final class FindClassInModuleKt {
    public static final ClassDescriptor findClassAcrossModuleDependencies(ModuleDescriptor moduleDescriptor, ClassId classId) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(classId, "classId");
        ClassifierDescriptor classifierDescriptorFindClassifierAcrossModuleDependencies = findClassifierAcrossModuleDependencies(moduleDescriptor, classId);
        if (classifierDescriptorFindClassifierAcrossModuleDependencies instanceof ClassDescriptor) {
            return (ClassDescriptor) classifierDescriptorFindClassifierAcrossModuleDependencies;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x014b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final ClassifierDescriptor findClassifierAcrossModuleDependencies(ModuleDescriptor moduleDescriptor, ClassId classId) {
        ClassifierDescriptor classifierDescriptorMo2145getContributedClassifier;
        Intrinsics.checkNotNullParameter(moduleDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(classId, "classId");
        ModuleDescriptor resolutionAnchorIfAny = ResolutionAnchorProviderKt.getResolutionAnchorIfAny(moduleDescriptor);
        if (resolutionAnchorIfAny == null) {
            FqName packageFqName = classId.getPackageFqName();
            Intrinsics.checkNotNullExpressionValue(packageFqName, "classId.packageFqName");
            PackageViewDescriptor packageViewDescriptor = moduleDescriptor.getPackage(packageFqName);
            List<Name> listPathSegments = classId.getRelativeClassName().pathSegments();
            Intrinsics.checkNotNullExpressionValue(listPathSegments, "classId.relativeClassName.pathSegments()");
            MemberScope memberScope = packageViewDescriptor.getMemberScope();
            Object objFirst = CollectionsKt___CollectionsKt.first((List<? extends Object>) listPathSegments);
            Intrinsics.checkNotNullExpressionValue(objFirst, "segments.first()");
            classifierDescriptorMo2145getContributedClassifier = memberScope.mo2145getContributedClassifier((Name) objFirst, NoLookupLocation.FROM_DESERIALIZATION);
            if (classifierDescriptorMo2145getContributedClassifier == null) {
                return null;
            }
            for (Name name : listPathSegments.subList(1, listPathSegments.size())) {
                if (!(classifierDescriptorMo2145getContributedClassifier instanceof ClassDescriptor)) {
                    return null;
                }
                MemberScope unsubstitutedInnerClassesScope = ((ClassDescriptor) classifierDescriptorMo2145getContributedClassifier).getUnsubstitutedInnerClassesScope();
                Intrinsics.checkNotNullExpressionValue(name, "name");
                ClassifierDescriptor classifierDescriptorMo2145getContributedClassifier2 = unsubstitutedInnerClassesScope.mo2145getContributedClassifier(name, NoLookupLocation.FROM_DESERIALIZATION);
                classifierDescriptorMo2145getContributedClassifier = classifierDescriptorMo2145getContributedClassifier2 instanceof ClassDescriptor ? (ClassDescriptor) classifierDescriptorMo2145getContributedClassifier2 : null;
                if (classifierDescriptorMo2145getContributedClassifier == null) {
                    return null;
                }
            }
        } else {
            FqName packageFqName2 = classId.getPackageFqName();
            Intrinsics.checkNotNullExpressionValue(packageFqName2, "classId.packageFqName");
            PackageViewDescriptor packageViewDescriptor2 = resolutionAnchorIfAny.getPackage(packageFqName2);
            List<Name> listPathSegments2 = classId.getRelativeClassName().pathSegments();
            Intrinsics.checkNotNullExpressionValue(listPathSegments2, "classId.relativeClassName.pathSegments()");
            MemberScope memberScope2 = packageViewDescriptor2.getMemberScope();
            Object objFirst2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) listPathSegments2);
            Intrinsics.checkNotNullExpressionValue(objFirst2, "segments.first()");
            ClassifierDescriptor classifierDescriptorMo2145getContributedClassifier3 = memberScope2.mo2145getContributedClassifier((Name) objFirst2, NoLookupLocation.FROM_DESERIALIZATION);
            if (classifierDescriptorMo2145getContributedClassifier3 == null) {
                classifierDescriptorMo2145getContributedClassifier3 = null;
                if (classifierDescriptorMo2145getContributedClassifier3 == null) {
                    return classifierDescriptorMo2145getContributedClassifier3;
                }
                FqName packageFqName3 = classId.getPackageFqName();
                Intrinsics.checkNotNullExpressionValue(packageFqName3, "classId.packageFqName");
                PackageViewDescriptor packageViewDescriptor3 = moduleDescriptor.getPackage(packageFqName3);
                List<Name> listPathSegments3 = classId.getRelativeClassName().pathSegments();
                Intrinsics.checkNotNullExpressionValue(listPathSegments3, "classId.relativeClassName.pathSegments()");
                MemberScope memberScope3 = packageViewDescriptor3.getMemberScope();
                Object objFirst3 = CollectionsKt___CollectionsKt.first((List<? extends Object>) listPathSegments3);
                Intrinsics.checkNotNullExpressionValue(objFirst3, "segments.first()");
                classifierDescriptorMo2145getContributedClassifier = memberScope3.mo2145getContributedClassifier((Name) objFirst3, NoLookupLocation.FROM_DESERIALIZATION);
                if (classifierDescriptorMo2145getContributedClassifier == null) {
                    return null;
                }
                for (Name name2 : listPathSegments3.subList(1, listPathSegments3.size())) {
                    if (!(classifierDescriptorMo2145getContributedClassifier instanceof ClassDescriptor)) {
                        return null;
                    }
                    MemberScope unsubstitutedInnerClassesScope2 = ((ClassDescriptor) classifierDescriptorMo2145getContributedClassifier).getUnsubstitutedInnerClassesScope();
                    Intrinsics.checkNotNullExpressionValue(name2, "name");
                    ClassifierDescriptor classifierDescriptorMo2145getContributedClassifier4 = unsubstitutedInnerClassesScope2.mo2145getContributedClassifier(name2, NoLookupLocation.FROM_DESERIALIZATION);
                    classifierDescriptorMo2145getContributedClassifier = classifierDescriptorMo2145getContributedClassifier4 instanceof ClassDescriptor ? (ClassDescriptor) classifierDescriptorMo2145getContributedClassifier4 : null;
                    if (classifierDescriptorMo2145getContributedClassifier == null) {
                        return null;
                    }
                }
            } else {
                for (Name name3 : listPathSegments2.subList(1, listPathSegments2.size())) {
                    if (classifierDescriptorMo2145getContributedClassifier3 instanceof ClassDescriptor) {
                        MemberScope unsubstitutedInnerClassesScope3 = ((ClassDescriptor) classifierDescriptorMo2145getContributedClassifier3).getUnsubstitutedInnerClassesScope();
                        Intrinsics.checkNotNullExpressionValue(name3, "name");
                        ClassifierDescriptor classifierDescriptorMo2145getContributedClassifier5 = unsubstitutedInnerClassesScope3.mo2145getContributedClassifier(name3, NoLookupLocation.FROM_DESERIALIZATION);
                        classifierDescriptorMo2145getContributedClassifier3 = classifierDescriptorMo2145getContributedClassifier5 instanceof ClassDescriptor ? (ClassDescriptor) classifierDescriptorMo2145getContributedClassifier5 : null;
                        if (classifierDescriptorMo2145getContributedClassifier3 != null) {
                        }
                    }
                    classifierDescriptorMo2145getContributedClassifier3 = null;
                }
                if (classifierDescriptorMo2145getContributedClassifier3 == null) {
                }
            }
        }
        return classifierDescriptorMo2145getContributedClassifier;
    }

    public static final ClassDescriptor findNonGenericClassAcrossDependencies(ModuleDescriptor moduleDescriptor, ClassId classId, NotFoundClasses notFoundClasses) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(classId, "classId");
        Intrinsics.checkNotNullParameter(notFoundClasses, "notFoundClasses");
        ClassDescriptor classDescriptorFindClassAcrossModuleDependencies = findClassAcrossModuleDependencies(moduleDescriptor, classId);
        return classDescriptorFindClassAcrossModuleDependencies != null ? classDescriptorFindClassAcrossModuleDependencies : notFoundClasses.getClass(classId, SequencesKt___SequencesKt.toList(SequencesKt___SequencesKt.map(SequencesKt__SequencesKt.generateSequence(classId, (Function1<? super ClassId, ? extends ClassId>) ((Function1<? super Object, ? extends Object>) FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$1.INSTANCE)), new Function1<ClassId, Integer>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$2
            @Override // kotlin.jvm.functions.Function1
            public final Integer invoke(ClassId it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return 0;
            }
        })));
    }

    public static final TypeAliasDescriptor findTypeAliasAcrossModuleDependencies(ModuleDescriptor moduleDescriptor, ClassId classId) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(classId, "classId");
        ClassifierDescriptor classifierDescriptorFindClassifierAcrossModuleDependencies = findClassifierAcrossModuleDependencies(moduleDescriptor, classId);
        if (classifierDescriptorFindClassifierAcrossModuleDependencies instanceof TypeAliasDescriptor) {
            return (TypeAliasDescriptor) classifierDescriptorFindClassifierAcrossModuleDependencies;
        }
        return null;
    }
}
