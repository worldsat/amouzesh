package com.atrinfanavaran.school.Domain.New;

import com.atrinfanavaran.school.Kernel.Controller.Domain.BaseDomain;

public class DropdownList extends BaseDomain {
    private String ListName;
    private String ListId;

    public DropdownList(String listName, String listId) {
        ListName = listName;
        ListId = listId;
    }

    public String getListName() {
        return ListName;
    }

    public void setListName(String listName) {
        ListName = listName;
    }

    public String getListId() {
        return ListId;
    }

    public void setListId(String listId) {
        ListId = listId;
    }
}
