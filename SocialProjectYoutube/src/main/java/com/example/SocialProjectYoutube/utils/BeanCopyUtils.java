package com.example.SocialProjectYoutube.utils;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class BeanCopyUtils {

    /**
     * Copies properties from one object to another
     * @param source
     * @destination
     * @return
     */
    public static void copyNonNullProperties(Object source, Object destination, String... ignoreProperties){
        Set<String> ignorePropertiesSet = getNullPropertyNames(source);
        for(String propertyName: ignoreProperties) {
            ignorePropertiesSet.add(propertyName);
        }
        String[] result = new String[ignorePropertiesSet.size()];
        result = ignorePropertiesSet.toArray(result);
        BeanUtils.copyProperties(source, destination, result);
    }

    /**
     * Returns an array of null properties of an object
     * @param source
     * @return
     */
    public static Set<String> getNullPropertyNames (Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();
        Set<String> emptyNames = new HashSet<String>();
        for(java.beans.PropertyDescriptor pd : pds) {
            //check if value of this property is null then add it to the collection
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        return emptyNames;
    }

    public static String[] getNullPropertyNames2(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        PropertyDescriptor[] pds = src.getPropertyDescriptors();
        Set emptyNames = new HashSet();
        for (PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null)
                emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return (String[]) emptyNames.toArray(result);
    }
}
