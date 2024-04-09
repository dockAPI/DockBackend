package com.example.DockApiBackend.config;// Authorized.java


import org.springframework.web.bind.annotation.Mapping;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Mapping
public @interface Authorized {
}
