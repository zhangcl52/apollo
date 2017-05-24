package com.hunter.common.util;

import org.apache.commons.lang3.StringUtils;

/**
 * 应用环境帮助类
 * Created by lianjia on 2016/5/26.
 */
public class EnvHelper {
    public static final String ENV_DEV = "DEV";
    public static final String ENV_TEST = "TEST";
    public static final String ENV_VRF = "VRF";
    public static final String ENV_PRO = "PRO";
    private static final String[] evnArray = {ENV_DEV, ENV_TEST, ENV_VRF, ENV_PRO};

    private static String env;

    private EnvHelper() {
    }

    public static boolean isDev() {
        return EnvHelper.getEnv().equals(ENV_DEV);
    }

    public static boolean isTest() {
        return EnvHelper.getEnv().equals(ENV_TEST);
    }

    public static boolean isVrf() {
        return EnvHelper.getEnv().equals(ENV_VRF);
    }

    public static boolean isPro() {
        return EnvHelper.getEnv().equals(ENV_PRO);
    }

    /**
     * 获取配置的当前环境变量
     *
     * @return
     */
    public static String getEnv() {
        if (env != null) {
            return env;
        }
        env = System.getProperty("sysEnv");
        if (StringUtils.isBlank(env)) {
            env = System.getenv("sysEnv");
        }

        for (String envAllowed : evnArray) {
            if (envAllowed.equalsIgnoreCase(env)) {
                return env;
            }
        }
        throw new RuntimeException("Set the environment to one in (DEV,TEST,VRF,PRO)");
    }
}
