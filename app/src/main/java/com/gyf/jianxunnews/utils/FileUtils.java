package com.gyf.jianxunnews.utils;

import android.content.Context;
import android.os.Environment;

import java.io.File;

/**
 * Created by geyifeng on 2017/4/1.
 */

public class FileUtils {

    public static File getDiskCacheDir(Context context) {
        File file = null;
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
                || !Environment.isExternalStorageRemovable()) {
            file = context.getExternalCacheDir();
        } else {
            file = context.getCacheDir();
        }
        return file;
    }
}
