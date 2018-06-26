/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kremlin.auth.imp;


import com.kremlin.auth.resource.filter.Secured;
import java.lang.reflect.AnnotatedElement;

/**
 *
 * @author NICO_CUARTO
 */
public class AuthUtils {
    
     public static TypeAccess extractTypeAccess(AnnotatedElement annotatedElement) {
        if (annotatedElement == null) {
            return null;
        } else {
            Secured secured = annotatedElement.getAnnotation(Secured.class);
            if (secured == null) {
                return null;
            } else {
                TypeAccess access = secured.typeAccess();
                return access;
            }
        }
    }
    public static AccessBy extractAccessBy(AnnotatedElement annotatedElement) {
        if (annotatedElement == null) {
            return null;
        } else {
            Secured secured = annotatedElement.getAnnotation(Secured.class);
            if (secured == null) {
                return null;
            } else {
                AccessBy access = secured.accessBy();
                return access;
            }
        }
    }
   
    
}
