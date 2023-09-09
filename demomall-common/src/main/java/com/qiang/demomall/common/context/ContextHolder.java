package com.qiang.demomall.common.context;

/**
 * @description 上下文持有者
 *
 * @author qiang
 * @date 2023-09-09 23:27:56
 */
public class ContextHolder {

    // 线程本地变量
    private static final ThreadLocal<LocalContext> local = new ThreadLocal<>();


    /**
     * 设置线程本地上下文
     * @param context 上下文
     * @param <C> 类型
     */
    public static <C extends LocalContext> void set(C context) {
        local.set(context);
    }


    /**
     * 获取线程本地上下文
     * @param clazz 类型
     * @return 线程本地上下文
     */
    public static <C extends LocalContext> C get(Class<C> clazz) {
        return clazz.cast(local.get());
    }

    /**
     * 移除线程本地上下文
     */
    public static void remove() {
        local.remove();
    }
}
