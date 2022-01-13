package com.ecomerce.ecomerce.anotations;

import java.lang.annotation.*;

@Documented
@Target(value = {ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomClassAnnotation {
}