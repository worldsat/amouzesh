package com.atrinfanavaran.school.Kernel;

import android.content.Context;

import com.atrinfanavaran.school.Kernel.Bll.SettingsBll;
import com.atrinfanavaran.school.Kernel.Controller.Controller;

public class DownloadFile {

    public static  void download(Context context,String attachId,String attachName){
        SettingsBll settingsBll = new SettingsBll(context);
        String Api = "api/pgAttach/DownLoadOnline" + "?token=" + settingsBll.getTicket() + "&AttachId=" + attachId;
        Controller controller = new Controller(context);
        controller.DownloadFile(context, attachName, Api, null);
    }
}
