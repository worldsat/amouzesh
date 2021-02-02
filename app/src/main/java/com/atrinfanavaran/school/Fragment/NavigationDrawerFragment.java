package com.atrinfanavaran.school.Fragment;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.room.Room;

import com.afollestad.materialdialogs.MaterialDialog;
import com.atrinfanavaran.school.Activity.New.ListAnnouncementActivity;
import com.atrinfanavaran.school.Activity.New.ListAsatidActivity;
import com.atrinfanavaran.school.Activity.New.ListBannerActivity;
import com.atrinfanavaran.school.Activity.New.ListCategoryActivity;
import com.atrinfanavaran.school.Activity.New.ListPostActivity;
import com.atrinfanavaran.school.Activity.New.ListStudentActivity;
import com.atrinfanavaran.school.Activity.New.ListTeacherActivity;
import com.atrinfanavaran.school.Activity.New.LoginActivity;
import com.atrinfanavaran.school.BuildConfig;
import com.atrinfanavaran.school.Domain.BoxApi;
import com.atrinfanavaran.school.Domain.BoxIncomeApi;
import com.atrinfanavaran.school.Domain.RouteApi;
import com.atrinfanavaran.school.Kernel.Activity.BaseActivity;
import com.atrinfanavaran.school.Kernel.Bll.SettingsBll;
import com.atrinfanavaran.school.Kernel.Controller.Controller;
import com.atrinfanavaran.school.Kernel.Controller.Interface.CallbackGet;
import com.atrinfanavaran.school.Kernel.Controller.Interface.CallbackOperation;
import com.atrinfanavaran.school.R;
import com.atrinfanavaran.school.Room.AppDatabase;
import com.atrinfanavaran.school.Room.Domian.BoxIncomeR;
import com.atrinfanavaran.school.Room.Domian.BoxR;
import com.atrinfanavaran.school.Room.Domian.RouteR;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


public class NavigationDrawerFragment extends Fragment {

    public static final String PREF_FILE_NAME = "testpref";
    public static final String KEY_USER_LEARNED_DRAWER = "user_learned_drawer";
    private ImageView drawer_pic1;
    private TextView drawer1, drawer2, exitBtn, btn1, category_btn, mypost_btn, Banner_btn, teacherlist_btn, studentlist_btn, asatid_btn, notification_btn;
    private ActionBarDrawerToggle drawer_toggle;
    private LinearLayout btn2, btn3, btn4, btn5, btn6;
    private boolean m_userLearnedDrawer;
    private boolean m_fromSavedInstanceState;
    private AppDatabase db;
    private Controller controller;
    private BaseActivity baseActivity;
    private ImageView imageViewCat, imageViewPost, imageViewBanner, imageViewteacher, imageViewStudent, imageViewasatid, imageViewnotification;

    public NavigationDrawerFragment() {
        // Required empty public constructor
    }

    public static void saveToPreferences(Context con, String preferenceName, String preferenceValue) {
        SharedPreferences sp = con.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(preferenceName, preferenceValue);
        editor.apply();
    }

    public static String readFromPreferences(Context con, String preferenceName, String preferenceValue) {
        SharedPreferences sp = con.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);

        return sp.getString(preferenceName, preferenceValue);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        m_userLearnedDrawer = Boolean.valueOf(
                //inja mitan baz ya baste bodan navigation drawer dar zaman startup ra tanzim kard
                readFromPreferences(getActivity(), KEY_USER_LEARNED_DRAWER, "true")
        );

        if (savedInstanceState != null) {
            m_fromSavedInstanceState = true;
        }


    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final SharedPreferences sp = getActivity().getSharedPreferences("Token", 0);

        db = Room.databaseBuilder(getActivity(),
                AppDatabase.class, "RoomDb").fallbackToDestructiveMigration().allowMainThreadQueries().build();
        controller = new Controller(getActivity());
        baseActivity = new BaseActivity();

        SettingsBll settingsBll = new SettingsBll(getActivity());


        TextView name = view.findViewById(R.id.name);
        TextView code = view.findViewById(R.id.code);
//        name.setText(settingsBll.getName());
//        code.setText("کد: " + settingsBll.getApplicationUserId());

        drawer1 = (TextView) view.findViewById(R.id.exit_drawer);
        drawer2 = (TextView) view.findViewById(R.id.getDataBtn);
        btn1 = view.findViewById(R.id.Banners);
        btn2 = view.findViewById(R.id.btn2);
        btn3 = view.findViewById(R.id.btn3);
        btn4 = view.findViewById(R.id.btn4);
        exitBtn = view.findViewById(R.id.exit_btn);
        category_btn = view.findViewById(R.id.category_btn);
        mypost_btn = view.findViewById(R.id.mypost);
        Banner_btn = view.findViewById(R.id.Banners);
        teacherlist_btn = view.findViewById(R.id.teacherlist_btn);
        studentlist_btn = view.findViewById(R.id.studentlist_btn);
        asatid_btn = view.findViewById(R.id.asatid_btn);
        notification_btn = view.findViewById(R.id.notification_btn);
        imageViewCat = view.findViewById(R.id.imageViewCat);
        imageViewPost = view.findViewById(R.id.imageViewPost);
        imageViewBanner = view.findViewById(R.id.imageViewBanner);
        imageViewteacher = view.findViewById(R.id.imageViewteacher);
        imageViewStudent = view.findViewById(R.id.imageViewStudent);
        imageViewasatid = view.findViewById(R.id.imageViewasatid);
        imageViewnotification = view.findViewById(R.id.imageViewanotification);


        btn1.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), ListBannerActivity.class);
            startActivity(intent);
        });
        if (settingsBll.getUserType() == 0 || settingsBll.getUserType() == 1) {
            category_btn.setVisibility(View.VISIBLE);
            imageViewCat.setVisibility(View.VISIBLE);
            mypost_btn.setVisibility(View.VISIBLE);
            imageViewPost.setVisibility(View.VISIBLE);
            imageViewBanner.setVisibility(View.VISIBLE);
            Banner_btn.setVisibility(View.VISIBLE);
            studentlist_btn.setVisibility(View.VISIBLE);
            imageViewStudent.setVisibility(View.VISIBLE);
            notification_btn.setVisibility(View.VISIBLE);
            imageViewnotification.setVisibility(View.VISIBLE);
        } else {
            category_btn.setVisibility(View.GONE);
            imageViewCat.setVisibility(View.GONE);
            mypost_btn.setVisibility(View.GONE);
            imageViewPost.setVisibility(View.GONE);
            imageViewBanner.setVisibility(View.GONE);
            Banner_btn.setVisibility(View.GONE);
            studentlist_btn.setVisibility(View.GONE);
            imageViewStudent.setVisibility(View.GONE);
            notification_btn.setVisibility(View.GONE);
            imageViewnotification.setVisibility(View.GONE);
        }
        if (settingsBll.getUserType() == 0) {
            teacherlist_btn.setVisibility(View.VISIBLE);
            imageViewteacher.setVisibility(View.VISIBLE);
            asatid_btn.setVisibility(View.VISIBLE);
            imageViewasatid.setVisibility(View.VISIBLE);
        } else {
            teacherlist_btn.setVisibility(View.GONE);
            imageViewteacher.setVisibility(View.GONE);
            asatid_btn.setVisibility(View.GONE);
            imageViewasatid.setVisibility(View.GONE);
        }
        if (settingsBll.getUserType() == 2) {
            asatid_btn.setVisibility(View.VISIBLE);
            imageViewasatid.setVisibility(View.VISIBLE);
        } else {
            asatid_btn.setVisibility(View.GONE);
            imageViewasatid.setVisibility(View.GONE);
        }

        category_btn.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), ListCategoryActivity.class);
            startActivity(intent);
        });
        mypost_btn.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), ListPostActivity.class);
            startActivity(intent);
        });
        teacherlist_btn.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), ListTeacherActivity.class);
            startActivity(intent);
        });
        studentlist_btn.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), ListStudentActivity.class);
            startActivity(intent);
        });

        asatid_btn.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), ListAsatidActivity.class);
            startActivity(intent);
        });
        notification_btn.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), ListAnnouncementActivity.class);
            startActivity(intent);
        });
//        asatid_btn.setVisibility(View.VISIBLE);

        exitBtn.setOnClickListener(v -> {
            settingsBll.logout();
            getActivity().finish();
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
        });

//        drawer1.setOnClickListener(v -> sendDischargeRoute());
//        drawer2.setOnClickListener(v -> getRoutes());

        TextView version = view.findViewById(R.id.version);
        String versionName = BuildConfig.VERSION_NAME;
        version.setText(" نسخه " + versionName);


//        setLogo();
    }


    public void setUp(int fragmentId, DrawerLayout dl, final Toolbar toolbar) {
        View container_view = getActivity().findViewById(fragmentId);

        DrawerLayout my_drawer_layout = dl;

        drawer_toggle = new ActionBarDrawerToggle(getActivity(), dl, toolbar,
                R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

                if (!m_userLearnedDrawer) {
                    m_userLearnedDrawer = true;
                    saveToPreferences(getActivity(), PREF_FILE_NAME,
                            m_userLearnedDrawer + "");
                }

                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);

                getActivity().invalidateOptionsMenu();
            }

        };


        if (!m_userLearnedDrawer && !m_fromSavedInstanceState) {
            my_drawer_layout.openDrawer(container_view);
        }


        my_drawer_layout.setDrawerListener(drawer_toggle);

        my_drawer_layout.post(
                new Runnable() {
                    @Override
                    public void run() {

                        drawer_toggle.setDrawerIndicatorEnabled(true);
                        drawer_toggle.syncState();
                    }
                }
        );

    }

    private void sendDischargeRoute() {
        JSONObject params = null;
        JSONArray params2 = new JSONArray();
        List<RouteR> data = db.RouteDao().getAllNew();

        for (int i = 0; i < data.size(); i++) {
            try {
                params = new JSONObject();
//                params.put("id", data.get(i).id);
                params.put("code", data.get(i).code);
                params.put("day", data.get(i).day);
                params.put("address", data.get(i).address);
                params.put("lat", data.get(i).lat);
                params.put("lon", data.get(i).lon);

                params2.put(params);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        if (params2 != null) {
            Log.i("moh3n", "sendBoxIncome: " + params2.toString());
        }
        BaseActivity baseActivity = new BaseActivity();
        MaterialDialog wait = baseActivity.alertWaiting2(getActivity(), "در حال ارسال مسیر ها...");
        wait.show();
        controller.Operation("", RouteApi.class, getActivity(), params2.toString(), new CallbackOperation() {
            @Override
            public void onSuccess(String result) {
                Log.i("moh3n", "onSuccess: " + result);
                Toast.makeText(getActivity(), result, Toast.LENGTH_SHORT).show();
                db.RouteDao().deleteAll();
                wait.dismiss();
                sendBox();
            }

            @Override
            public void onError(String error) {
                Log.i("moh3n", "onError: " + error);
                wait.dismiss();
                Toast.makeText(getActivity(), "خطا در ارسال اطلاعات", Toast.LENGTH_SHORT).show();
                Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void sendBox() {
        JSONObject params = null;
        JSONArray params2 = new JSONArray();
        List<BoxR> data = db.BoxDao().getAllNew();

        for (int i = 0; i < data.size(); i++) {
            try {
                params = new JSONObject();
//                params.put("code", data.get(i).code);
                params.put("number", Integer.valueOf(data.get(i).number));
                params.put("fullName", data.get(i).fullName);
                params.put("mobile", new BigInteger(data.get(i).mobile));
                params.put("assignmentDate", data.get(i).assignmentDate);
                params.put("address", data.get(i).address);
                params.put("lat", Double.valueOf(data.get(i).lat));
                params.put("lon", Double.valueOf(data.get(i).lon));
                params.put("dischargeRouteId", Integer.valueOf(data.get(i).dischargeRouteId));

                params2.put(params);
            } catch (Exception e) {
                Log.i("moh3n", "sendBox: " + e);
                Toast.makeText(baseActivity, "خطا در پارامتر های ارسالی اطلاعات صندوق ها", Toast.LENGTH_SHORT).show();
            }
        }


        MaterialDialog wait = baseActivity.alertWaiting2(getActivity(), "در حال ارسال صندوق ها...");
        wait.show();
        controller.Operation("", BoxApi.class, getActivity(), params2.toString(), new CallbackOperation() {
            @Override
            public void onSuccess(String result) {
                Log.i("moh3n", "onSuccess: " + result);
                Toast.makeText(getActivity(), result, Toast.LENGTH_SHORT).show();
                db.BoxDao().deleteAll();
                wait.dismiss();
                sendBoxIncome();
            }

            @Override
            public void onError(String error) {
                Log.i("moh3n", "onError: " + error);
                wait.dismiss();
                Toast.makeText(getActivity(), "خطا در ارسال اطلاعات", Toast.LENGTH_SHORT).show();
                Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void sendBoxIncome() {
        JSONObject params = null;
        JSONArray params2 = new JSONArray();
        List<BoxIncomeR> boxIncome = db.BoxIncomeDao().getAll();

        for (int i = 0; i < boxIncome.size(); i++) {
            try {
                params = new JSONObject();

                try {
                    Integer intt = Integer.valueOf(boxIncome.get(i).price);
                    params.put("price", boxIncome.get(i).price);
                } catch (Exception e) {
                    params.put("price", 0);
                }
                try {
                    params.put("number", Integer.valueOf(boxIncome.get(i).number));
                    params.put("status", Integer.valueOf(boxIncome.get(i).status));
                    params.put("lon", Double.valueOf(boxIncome.get(i).lon));
                    params.put("lat", Double.valueOf(boxIncome.get(i).lat));
                    params.put("assignmentDate", boxIncome.get(i).assignmentDate);
                } catch (Exception e) {
                    Toast.makeText(baseActivity, "خطا در پارامتر های ارسالی  اطلاعات تخلیه ها", Toast.LENGTH_SHORT).show();
                }
                params2.put(params);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        if (params2 != null) {
            Log.i("moh3n", "sendBoxIncome: " + params2.toString());
        }

        MaterialDialog wait = baseActivity.alertWaiting2(getActivity(), "در حال ارسال تخلیه ها...");
        wait.show();
        controller.Operation("", BoxIncomeApi.class, getActivity(), params2.toString(), new CallbackOperation() {
            @Override
            public void onSuccess(String result) {
                Log.i("moh3n", "onSuccessSendBoxIncome: " + result);
                Toast.makeText(getActivity(), result, Toast.LENGTH_SHORT).show();
                db.BoxIncomeDao().deleteAll();
                wait.dismiss();
            }

            @Override
            public void onError(String error) {
                Log.i("moh3n", "onError: " + error);
                wait.dismiss();
                Toast.makeText(getActivity(), "خطا در ارسال اطلاعات", Toast.LENGTH_SHORT).show();
                Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void getBoxIncome() {
        MaterialDialog wait = baseActivity.alertWaiting2(getActivity(), "در حال دریافت اطلاعات تخلیه شده ها");
        wait.show();
        controller.Get(BoxIncomeApi.class, null, 0, 0, true, new CallbackGet() {
            @Override
            public <T> void onSuccess(ArrayList<T> result, int count) {

                List<BoxIncomeApi> response = (List<BoxIncomeApi>) result;

                for (int i = 0; i < response.size(); i++) {
                    BoxIncomeR boxIncomeR = new BoxIncomeR();
//                    boxIncomeR.id = Integer.valueOf(response.get(i).getid());
                    boxIncomeR.price = response.get(i).getprice();
                    boxIncomeR.status = response.get(i).getstatus();
                    boxIncomeR.assignmentDate = response.get(i).getassignmentDate();
                    boxIncomeR.lon = response.get(i).getlon();
                    boxIncomeR.lat = response.get(i).getlat();
                    boxIncomeR.number = response.get(i).getnumber();

                    db.BoxIncomeDao().insertBoxIncome(boxIncomeR);

                }
                String Str = "تعداد " + response.size() + " رکورد با موفقیت ذخیره شد";
                Toast.makeText(getActivity(), Str, Toast.LENGTH_SHORT).show();

                wait.dismiss();
            }

            @Override
            public void onError(String error) {
                Log.i("mo3h", "onError: " + error);
                wait.dismiss();
            }
        });
    }

    private void getBox() {
        MaterialDialog wait = baseActivity.alertWaiting2(getActivity(), "در حال دریافت اطلاعات صندوق ها");
        wait.show();
        controller.Get(BoxApi.class, null, 0, 0, true, new CallbackGet() {
            @Override
            public <T> void onSuccess(ArrayList<T> result, int count) {

                List<BoxApi> response = (List<BoxApi>) result;

                for (int i = 0; i < response.size(); i++) {
                    BoxR data = new BoxR();
                    data.id = Integer.valueOf(response.get(i).getid());
                    data.boxId = Integer.valueOf(response.get(i).getid());
                    data.fullName = response.get(i).getfullName();
                    data.mobile = response.get(i).getmobile();
                    data.assignmentDate = response.get(i).getassignmentDate();
                    data.code = response.get(i).getcode();
                    data.number = response.get(i).getnumber();
                    data.address = response.get(i).getaddress();
                    data.lat = response.get(i).getlat();
                    data.lon = response.get(i).getlon();
                    data.dischargeRouteId = response.get(i).getdischargeRouteId();

                    try {
                        db.BoxDao().insertBox(data);
                    } catch (Exception e) {
                        Log.i("moh3n", "errorInsert: " + e);
                    }
                }
                String Str = "تعداد " + response.size() + " رکورد از صندوق ها با موفقیت ذخیره شد";
                Toast.makeText(getActivity(), Str, Toast.LENGTH_SHORT).show();

                wait.dismiss();
            }

            @Override
            public void onError(String error) {
                Log.i("mo3h", "onError: " + error);
                wait.dismiss();
            }
        });
    }

    private void getRoutes() {
        MaterialDialog wait = baseActivity.alertWaiting2(getActivity(), "در حال دریافت اطلاعات مسیرها");
        wait.show();
        controller.Get(RouteApi.class, null, 0, 0, true, new CallbackGet() {
            @Override
            public <T> void onSuccess(ArrayList<T> result, int count) {

                List<RouteApi> response = (List<RouteApi>) result;

                for (int i = 0; i < response.size(); i++) {
                    RouteR data = new RouteR();
                    data.id = Integer.valueOf(response.get(i).getid());
                    data.code = response.get(i).getcode();
                    data.address = response.get(i).getaddress();
                    data.day = response.get(i).getday();
                    try {
                        db.RouteDao().insertBox(data);
                    } catch (Exception e) {
                        Log.i("moh3n", "errorInsert: " + e);
                    }
                }
                String Str = "تعداد " + response.size() + " رکورد از مسیر ها با موفقیت ذخیره شد";
                Toast.makeText(getActivity(), Str, Toast.LENGTH_SHORT).show();

                wait.dismiss();
                getBox();

            }

            @Override
            public void onError(String error) {
                Log.i("mo3h", "onError: " + error);
                wait.dismiss();
            }
        });
    }


}

