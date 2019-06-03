package com.test.testrecycleview;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;

/**
 * アプリデータ
 */
class AppInfo {

    /**
     * アプリ名
     */
    private String name;

    /**
     * パッケージ名
     */
    private String packageName;

    /**
     * アプリアイコン
     */
    private Drawable icon;

    /**
     * log用タグ
     */
    // private static final String TAG = "AppInfo";

    /**
     * コンストラクタ
     *
     * @param appInfo アプリ情報
     * @param pm アプリ情報に必要なPackageManager
     */
    AppInfo(ApplicationInfo appInfo, PackageManager pm) {
        this.name = appInfo.loadLabel(pm).toString();
        this.icon = appInfo.loadIcon(pm);
    }

    /**
     * アプリ名取得
     *
     * @return ApplicationInfo.loadLabel
     */
    String getName() {
        return this.name;
    }

    /**
     * パッケージ名取得
     *
     * @return ApplicationInfo,packageMame
     */
    String getPackageName() {
        return packageName;
    }

    /**
     * アプリ・アイコン取得
     *
     * @return Drawable icon
     */
    public Drawable getIcon() {
        return icon;
    }
}
