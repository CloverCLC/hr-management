package cn.cloverclc.util;

import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class ConverUtil {
    public static <T, R> R convert(T source, Class<R> targetClass) {
        if (source == null) {
            return null;
        }
        R target;
        try {
            target = targetClass.getDeclaredConstructor().newInstance();
            BeanUtils.copyProperties(source, target);
            return target;
        } catch (Exception e) {
            throw new RuntimeException("对象转换失败", e);
        }
    }


    public static <T, R> List<R> convertList(List<T> sourceList, Class<R> targetClass) {
        if (sourceList == null || sourceList.isEmpty()) {
            return List.of();
        }
        return sourceList.stream()
                .map(source -> convert(source, targetClass))
                .collect(Collectors.toList());
    }
}
