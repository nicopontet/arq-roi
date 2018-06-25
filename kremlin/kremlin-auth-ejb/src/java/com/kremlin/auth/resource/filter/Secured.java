
package com.kremlin.auth.resource.filter;

import com.kremlin.auth.imp.AccessBy;
import com.kremlin.auth.imp.TypeAccess;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.ws.rs.NameBinding;

@NameBinding
@Retention(RUNTIME)
@Target({METHOD, TYPE})
public @interface Secured {
    TypeAccess typeAccess() default TypeAccess.INTERNAL;
    AccessBy accessBy() default AccessBy.ANNOTATION;
}

