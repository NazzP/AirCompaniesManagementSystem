package com.example.aircompaniesmanagementsystem.aspect;

import com.example.aircompaniesmanagementsystem.dto.response.AirCompanyResponse;
import com.example.aircompaniesmanagementsystem.exception.NullEntityFieldException;
import com.example.aircompaniesmanagementsystem.utils.ResponseUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Aspect
@Component
@Order(1)
public class ValidationAspect {
    @Around("@annotation(ToValidate)")
    @Order(1)
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] arguments = joinPoint.getArgs();
        for (Object argument : arguments) {
            if (argument != null) {
                boolean hasNullField = hasNullField(argument);
                if (hasNullField) {
                    throw new NullEntityFieldException();
                }
            }
        }
        return joinPoint.proceed();
    }

    private boolean hasNullField(Object object) {
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                if (field.get(object) == null) {
                    return true;
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

}