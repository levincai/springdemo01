package com.loevin.springdemo01.propertiesbean;

import java.beans.PropertyEditorSupport;

public class NamePropertiesEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) {
        String[] name = text.split("\\s");
        setValue(new FullName(name[0], name[1]));

    }
}
