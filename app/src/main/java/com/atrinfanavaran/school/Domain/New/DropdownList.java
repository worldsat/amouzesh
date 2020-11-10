package com.atrinfanavaran.school.Domain.New;

import com.atrinfanavaran.school.Kernel.Controller.Domain.BaseDomain;

public class DropdownList extends BaseDomain {
    private String ListName;
    private int ListId;
    private boolean tick;

    public DropdownList(String listName, int listId, boolean tick) {
        ListName = listName;
        ListId = listId;
        this.tick = tick;
    }

    public String getListName() {
        return ListName;
    }

    public void setListName(String listName) {
        ListName = listName;
    }

    public int getListId() {
        return ListId;
    }

    public void setListId(int listId) {
        ListId = listId;
    }

    public boolean isTick() {
        return tick;
    }

    public void setTick(boolean tick) {
        this.tick = tick;
    }
}
