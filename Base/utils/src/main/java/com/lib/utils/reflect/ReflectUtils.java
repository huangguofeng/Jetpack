package com.lib.utils.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author huangguofeng
 * 2021/8/29
 */
public class ReflectUtils {
    /*
     * 适用于类 方法 属性的几个常用方法
     * getAnnotations：获取注解集合
     * getModifiers：获取int类型的访问修饰符，使用Modifier.toString(getModifiers)转换为public private
     *
     * 适用于类：
     * getMethod：获取public方法
     * getDeclaredMethod：获取全部方法
     * getField：获取public属性
     * getDeclaredField：获取全部属性
     * getInterfaces：获取接口类型 Class类型
     * getGenericInterfaces：获取接口类型 Type类型
     *
     * 适用于方法：
     * setAccessible：授权私有犯法获取
     * getReturnType：获取返回值类型 Class类型
     * getGenericReturnType：获取返回值类型 Type类型
     * getGenericParameterTypes：获取方法中的参数类型 Type类型
     * getParameterTypes：获取方法中的参数类型 Class类型
     * getParameterAnnotations：获取参数注解集合 双重数组类型
     * getExceptionTypes：获取方法异常集合 Class类型
     * getGenericExceptionTypes：获取方法异常集合 Type类型
     *
     * 适用于属性：
     * setAccessible：授权私有属性获取
     * getType：获取值类型 Class类型
     * getGenericType 获取值类型 Type类型
     */

    /**
     * 无参构造方法创建对象
     * @param className ClassName
     * @return Object
     */
    public static Object createObject(String className) {
        try {
            Class r = Class.forName(className);
            return createObject(r);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 无参构造方法创建对象
     * @param c Class对象
     * @return Object
     */
    public static Object createObject(Class c) {
        Class[] parameterTypes = new Class[]{};
        Object[] parameterValues = new Object[]{};
        return createObject(c, parameterTypes, parameterValues);
    }

    /**
     * 只有一个参数的构造方法创建对象  已知className
     *
     * @param className 类名
     * @param parameterType 参数类型
     * @param parameterValue 参数值
     * @return object
     */
    public static Object createObject(String className, Class parameterType, Object parameterValue) {
        Class[] type = new Class[]{parameterType};
        Object[] value = new Object[]{parameterValue};
        try {
            Class r = Class.forName(className);
            return createObject(r, type, value);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 只有一个参数的构造方法创建对象 已知类
     *
     * @param c class类对象
     * @param parameterType 参数类型
     * @param parameterValue 参数值
     * @return object
     */
    public static Object createObject(Class c, Class parameterType, Object parameterValue) {
        Class[] type = new Class[]{parameterType};
        Object[] value = new Object[]{parameterValue};
        return createObject(c, type, value);
    }

    /**
     * 多个参数的构造方法创建对象 已知className
     * @param className 类名
     * @param parameterTypes 参数类型
     * @param parameterValues 参数值
     * @return object
     */
    public static Object createObject(String className, Class[] parameterTypes, Object[] parameterValues) {
        try {
            Class r = Class.forName(className);
            return createObject(r, parameterTypes, parameterValues);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 多个参数的构造方法创建对象 已知class类型
     *
     * @param c class类对象
     * @param parameterTypes 参数类型
     * @param parameterValues 参数值
     * @return object
     */
    public static Object createObject(Class c, Class[] parameterTypes, Object[] parameterValues) {
        try {
            Constructor constructor = c.getDeclaredConstructor(parameterTypes);
            constructor.setAccessible(true);
            return constructor.newInstance(parameterValues);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 调用无参方法
     * @param obj 构造方法创建的对象
     * @param methodName 方法名
     * @return 方法的返回值
     */
    public static Object invokeInstanceMethod(Object obj, String methodName) {
        Class[] types = new Class[]{};
        Object[] values = new Object[]{};
        return invokeInstanceMethod(obj, methodName, types, values);
    }

    /**
     * 调用一个参数的方法
     * @param obj 构造方法创建的对象
     * @param methodName 方法名
     * @param parameterType 参数类型
     * @param parameterValue 参数值
     * @return 方法的返回值
     */
    public static Object invokeInstanceMethod(Object obj, String methodName, Class parameterType, Object parameterValue) {
        Class[] types = {parameterType};
        Object[] values = {parameterValue};
        return invokeInstanceMethod(obj, methodName, types, values);
    }

    /**
     * 调用多个参数的方法
     * @param obj 构造方法创建的对象
     * @param methodName 方法名
     * @param parameterTypes 参数类型
     * @param parameterValues 参数值
     * @return 方法返回值
     */
    public static Object invokeInstanceMethod(Object obj, String methodName, Class[] parameterTypes, Object[] parameterValues) {
        if (obj == null) {
            return null;
        }
        try {
            //调用一个private方法 //在指定类中获取指定的方法
            Method method = obj.getClass().getDeclaredMethod(methodName, parameterTypes);
            method.setAccessible(true);
            return method.invoke(obj, parameterValues);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 无参静态方法 已知类名
     * @param className 类名
     * @param methodName 静态方法名
     * @return 静态方法返回值
     */
    public static Object invokeStaticMethod(String className, String methodName) {
        Class[] types = new Class[]{};
        Object[] values = new Object[]{};
        return invokeStaticMethod(className, methodName, types, values);
    }

    /**
     * 调用一个参数的静态方法 已知类名
     * @param className 类名
     * @param methodName 静态方法名
     * @param parameterType 参数类型
     * @param parameterValue 参数值
     * @return 静态方法返回值
     */
    public static Object invokeStaticMethod(String className, String methodName, Class parameterType, Object parameterValue) {
        Class[] types = new Class[]{parameterType};
        Object[] values = new Object[]{parameterValue};
        return invokeStaticMethod(className, methodName, types, values);
    }

    /**
     * 调用多个参数的静态方法 已知类名
     * @param className 类名
     * @param methodName 静态方法名
     * @param parameterTypes 参数类型
     * @param parameterValues 参数值
     * @return 静态方法返回值
     */
    public static Object invokeStaticMethod(String className, String methodName, Class[] parameterTypes, Object[] parameterValues) {
        try {
            Class c = Class.forName(className);
            return invokeStaticMethod(c, methodName, parameterTypes, parameterValues);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 无参静态方法 已知类的类型
     * @param clazz 类
     * @param methodName 静态方法名
     * @return 静态方法返回值
     */
    public static Object invokeStaticMethod(Class clazz, String methodName) {
        Class[] types = new Class[]{};
        Object[] values = new Object[]{};

        return invokeStaticMethod(clazz, methodName, types, values);
    }

    /**
     * 一个参数静态方法 已知类的类型
     * @param clazz 类
     * @param methodName 静态方法名
     * @param parameterType 参数类型
     * @param parameterValue 参数值
     * @return 静态方法返回值
     */
    public static Object invokeStaticMethod(Class clazz, String methodName, Class parameterType, Object parameterValue) {
        Class[] types = new Class[]{parameterType};
        Object[] values = new Object[]{parameterValue};
        return invokeStaticMethod(clazz, methodName, types, values);
    }

    /**
     * 多个参数的静态方法 已知类的类型
     * @param clazz 类
     * @param methodName 静态方法名
     * @param parameterTypes 参数类型
     * @param parameterValues 参数值
     * @return 静态方法返回值
     */
    public static Object invokeStaticMethod(Class clazz, String methodName, Class[] parameterTypes, Object[] parameterValues) {
        try {
            Method method = clazz.getDeclaredMethod(methodName, parameterTypes);
            method.setAccessible(true);
            return method.invoke(null, parameterValues);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取对象的某个属性值
     * @param className 目标对象的类名
     * @param obj 目标对象
     * @param filedName 目标对象的属性名
     * @return 目标对象中的属性的值
     */
    public static Object getFieldObject(String className, Object obj, String filedName) {
        try {
            Class c = Class.forName(className);
            return getFieldObject(c, obj, filedName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 获取对象的某个属性值
     * @param clazz 目标对象的类
     * @param obj 目标对象
     * @param filedName 目标对象的属性名
     * @return 目标对象中的属性的值
     */
    public static Object getFieldObject(Class clazz, Object obj, String filedName) {
        try {
            Field field = clazz.getDeclaredField(filedName);
            field.setAccessible(true);
            return field.get(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取对象的某个属性值
     * @param clazz 目标对象的类
     * @param obj 目标对象
     * @param filedName 目标对象的属性名
     * @param filedValue 要设置的属性值
     */
    public static void setFieldObject(Class clazz, Object obj, String filedName, Object filedValue) {
        try {
            Field field = clazz.getDeclaredField(filedName);
            field.setAccessible(true);
            field.set(obj, filedValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 设置目标对象的某个属性值
     * @param className 目标对象的类名
     * @param obj 目标对象
     * @param filedName 目标对象的属性名
     * @param filedValue 要设置的属性值
     */
    public static void setFieldObject(String className, Object obj, String filedName, Object filedValue) {
        try {
            Class c = Class.forName(className);
            setFieldObject(c, obj, filedName, filedValue);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取对象的某个静态属性值
     * @param className 目标对象的类名
     * @param filedName 目标对象的属性名
     * @return 目标对象中的静态属性的值
     */
    public static Object getStaticFieldObject(String className, String filedName) {
        return getFieldObject(className, null, filedName);
    }
    /**
     * 获取对象的某个静态属性值
     * @param clazz 目标对象的类
     * @param filedName 目标对象的属性名
     * @return 目标对象中的静态属性的值
     */
    public static Object getStaticFieldObject(Class clazz, String filedName) {
        return getFieldObject(clazz, null, filedName);
    }
    /**
     * 设置目标类的静态属性值
     * @param className 目标对象的类名
     * @param filedName 目标对象的属性名
     * @param filedValue 要设置的属性值
     */
    public static void setStaticFieldObject(String className, String filedName, Object filedValue) {
        setFieldObject(className, null, filedName, filedValue);
    }
    /**
     * 设置目标类的静态属性值
     * @param clazz 目标对象的类
     * @param filedName 目标对象的属性名
     * @param filedValue 要设置的属性值
     */
    public static void setStaticFieldObject(Class clazz, String filedName, Object filedValue) {
        setFieldObject(clazz, null, filedName, filedValue);
    }
}
