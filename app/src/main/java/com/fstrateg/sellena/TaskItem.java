package com.fstrateg.sellena;

public class TaskItem {
    public String Text;
    public Integer Progress;
    public Integer Tab;

    public TaskItem(String text, Integer progress)
    {
        Text=text;
        Progress = progress;
        Tab=0;
    }

    public Integer getTab()
    {
        return Tab;
    }
    public void setTab(Integer tab) {
        Tab = tab;
    }
}
