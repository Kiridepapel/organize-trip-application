package com.organizetrip.organizetripapplication.components.datechooser.listener;

import com.organizetrip.organizetripapplication.components.datechooser.DateBetween;

import java.util.Date;

public interface DateChooserListener {
    public void dateChanged(Date date, DateChooserAction action);

    public void dateBetweenChanged(DateBetween date, DateChooserAction action);
}
