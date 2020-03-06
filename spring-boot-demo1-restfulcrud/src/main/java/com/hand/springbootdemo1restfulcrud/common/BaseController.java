package com.hand.springbootdemo1restfulcrud.common;

import com.sun.beans.editors.DoubleEditor;
import com.sun.beans.editors.FloatEditor;
import com.sun.beans.editors.IntegerEditor;
import com.sun.beans.editors.LongEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseController {

    @InitBinder
    protected void initBinder(WebDataBinder binder){
        System.out.println("initBinder");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"),true));
        binder.registerCustomEditor(int.class, new IntegerEditor());
//        binder.registerCustomEditor(long.class, new CustomNumberEditor(long.class, true));
        binder.registerCustomEditor(long.class, new LongEditor());
        binder.registerCustomEditor(double.class, new DoubleEditor());
        binder.registerCustomEditor(float.class, new FloatEditor());
    }
}
