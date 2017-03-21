package com.dtkj.library.utils;

import android.app.ActivityManager;
import android.content.Context;

import java.util.List;

/**
 * Created by sword on 17/3/21
 * Email: 1619153872@qq.com
 * Description: the utils for service
 */
public class DTServiceUtils {
    /**
     * 判断服务是否后台运行
     *
     * @param context   Context
     * @param className 判断的服务名字
     * @return true 在运行 false 不在运行
     */
    public static boolean isServiceRun(Context context, String className) {
        boolean isRun = false;
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningServiceInfo> serviceList = activityManager.getRunningServices(40);
        int size = serviceList.size();
        for (int i = 0; i < size; i++) {
            if (serviceList.get(i).service.getClassName().equals(className) == true) {
                isRun = true;
                break;
            }
        }
        return isRun;
    }

}
