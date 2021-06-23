package com.pieterdebot.biomemapping.utils;

import org.bukkit.Bukkit;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NMSUtils {

    private final static String version = getVersion();

    public static String getVersion(){
        if (version != null){
            return version;
        }else{
            String name = Bukkit.getServer().getClass().getPackage().getName();
            return name.substring(name.lastIndexOf(46) + 1) + ".";
        }
    }

    public static Object getHandle(Object craftObject){
        try{
            return getMethod(craftObject.getClass(), "getHandle").invoke(craftObject);
        }catch (ReflectiveOperationException | IllegalArgumentException ex){
            ex.printStackTrace();
            return null;
        }
    }

    public static Object getServer(Object o){
        try{
            return getMethod(o.getClass(), "getServer").invoke(o);
        }catch (ReflectiveOperationException | IllegalArgumentException ex){
            return null;
        }
    }

    public static Method getMethod(Class<?> c, String name) throws ReflectiveOperationException{
        return getMethod(c, name, -1);
    }

    public static void removeFinal(Field field) throws IllegalAccessException {
        try {
            Field modifiersField = Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
        } catch (ReflectiveOperationException ex) {
            throw new IllegalAccessException("Modifying of field modifiers is not supported on your version of Java!");
        }
    }

    public static Method getMethod(Class<?> c, String name, int args) throws ReflectiveOperationException{
        for (Method method : c.getMethods()){
            if (method.getName().equals(name) && (args == -1 || method.getParameterCount() == args)){
                method.setAccessible(true);
                return method;
            }
        }

        for (Method method : c.getDeclaredMethods()){
            if (method.getName().equals(name) && (args == -1 || method.getParameterCount() == args)){
                method.setAccessible(true);
                return method;
            }
        }

        throw new ReflectiveOperationException("Method " + name + " not found in " + c.getName());
    }

    public static Method getMethod(Class<?> c, String name, Class<?>... argTypes) throws ReflectiveOperationException{

        for (Method method : c.getMethods()){
            if (method.getName().equals(name) && Arrays.equals(method.getParameterTypes(), argTypes)){
                method.setAccessible(true);
                return method;
            }
        }

        for (Method method : c.getDeclaredMethods()){
            if (method.getName().equals(name) && Arrays.equals(method.getParameterTypes(), argTypes)){
                method.setAccessible(true);
                return method;
            }
        }

        throw new ReflectiveOperationException("Method " + name + " not found in " + c.getName());
    }

    public static List<Field> getAnnotatedFields(Class<?> c, Class<? extends Annotation> annotation){
        List<Field> fields = new ArrayList<>();
        for (Field field : c.getFields()){
            if (field.isAnnotationPresent(annotation)){
                field.setAccessible(true);
                fields.add(field);
            }
        }

        for (Field field : c.getDeclaredFields()){
            if (field.isAnnotationPresent(annotation)){
                field.setAccessible(true);
                fields.add(field);
            }
        }

        return fields;
    }

}