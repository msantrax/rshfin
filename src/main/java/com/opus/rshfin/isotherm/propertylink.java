/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opus.rshfin.isotherm;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention( RetentionPolicy.RUNTIME )
@Target( ElementType.METHOD )
public @interface propertylink {
    
    public String propname() default "NONE";
    public String plink() default "NONE";
    public boolean input() default false;
    public String callstate() default "NONE";
 
}