package dev.brian.com.drawer_navigation;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mindorks.placeholderview.annotations.Click;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Position;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

/**
 * Created by brian-kamau on 4/7/18.
 */
@Layout(R.layout.drawer_item)
public class DrawerMenuItems {

    public static final int DRAWER_MENU_ITEM_PROFILE = 1;
    public static final int DRAWER_MENU_ITEM_REQUESTS = 2;
    public static final int DRAWER_MENU_ITEM_GROUPS = 3;
    public static final int DRAWER_MENU_ITEM_MESSAGE = 4;
    public static final int DRAWER_MENU_ITEM_NOTIFICATIONS = 5;
    public static final int DRAWER_MENU_ITEM_SETTINGS = 6;
    public static final int DRAWER_MENU_ITEM_TERMS = 7;
    public static final int DRAWER_MENU_ITEM_LOGOUT = 8;

    @Position
    private int mMenuPosition;

    private Context mContext;
    private DrawerCallBack drawerCallBack;

    @View(R.id.itemNameTxt)
    private TextView itemNameTxt;

    @View(R.id.itemIcon)
    private ImageView itemIcon;

    public DrawerMenuItems(Context context){
        mContext = context;

    }
    @Resolve
    private void onResolved(){
        switch(mMenuPosition){
            case DRAWER_MENU_ITEM_PROFILE:
                itemNameTxt.setText("Profile");
                itemIcon.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_account_circle_black_18dp));
                break;

            case DRAWER_MENU_ITEM_REQUESTS:
                itemNameTxt.setText("Requests");
                itemIcon.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_compare_arrows_black_18dp));
                break;

            case DRAWER_MENU_ITEM_GROUPS:
                itemNameTxt.setText("Groups");
                itemIcon.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_group_work_black_18dp));
                break;

            case DRAWER_MENU_ITEM_MESSAGE:
                itemNameTxt.setText("Messages");
                itemIcon.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_email_black_18dp));
                break;

            case DRAWER_MENU_ITEM_NOTIFICATIONS:
                itemNameTxt.setText("Notifications");
                itemIcon.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_notifications_black_18dp));
                break;

            case DRAWER_MENU_ITEM_SETTINGS:
                itemNameTxt.setText("Settings");
                itemIcon.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_settings_black_18dp));
                break;

            case DRAWER_MENU_ITEM_TERMS:
                itemIcon.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_book_black_18dp));
                itemNameTxt.setText("Terms");
                break;

            case DRAWER_MENU_ITEM_LOGOUT:
                itemIcon.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_exit_to_app_black_18dp));
                break;
        }
    }

    @Click(R.id.mainView)
    public void onMenuItemClick(){
        switch(mMenuPosition){
            case DRAWER_MENU_ITEM_PROFILE:
                Toast.makeText(mContext,"Profile",Toast.LENGTH_SHORT).show();
                if(drawerCallBack!=null)drawerCallBack.onProfileMenuSelected();
                break;

            case DRAWER_MENU_ITEM_REQUESTS:
                Toast.makeText(mContext,"Requests",Toast.LENGTH_SHORT).show();
                if(drawerCallBack!=null)drawerCallBack.onRequestMenuSelected();
                break;

            case DRAWER_MENU_ITEM_GROUPS:
                Toast.makeText(mContext,"Groups",Toast.LENGTH_SHORT).show();
                if(drawerCallBack!=null)drawerCallBack.onGroupsMenuSelected();
                break;

            case DRAWER_MENU_ITEM_MESSAGE:
                Toast.makeText(mContext,"Messages",Toast.LENGTH_SHORT).show();
                if(drawerCallBack!=null)drawerCallBack.onMessagesMenuSelected();
                break;

            case DRAWER_MENU_ITEM_NOTIFICATIONS:
                Toast.makeText(mContext,"Notifications",Toast.LENGTH_SHORT).show();
                if(drawerCallBack!=null)drawerCallBack.onNotificationsMenuSelected();
                break;

            case DRAWER_MENU_ITEM_SETTINGS:
                Toast.makeText(mContext,"Settings",Toast.LENGTH_SHORT).show();
                if(drawerCallBack!=null)drawerCallBack.onSettingsMenuSelected();
                break;

            case DRAWER_MENU_ITEM_TERMS:
                Toast.makeText(mContext,"Terms",Toast.LENGTH_SHORT).show();
                if(drawerCallBack!=null)drawerCallBack.onTermsMenuSelected();
                break;

            case DRAWER_MENU_ITEM_LOGOUT:
                Toast.makeText(mContext,"Logout",Toast.LENGTH_SHORT).show();
                if(drawerCallBack!=null)drawerCallBack.onLogoutMenuSelected();
                System.exit(0);
                break;
        }
    }
    public void setDrawerCallBack(DrawerCallBack mdrawerCallBack){
        drawerCallBack = mdrawerCallBack;
    }


    public interface DrawerCallBack{
        void onProfileMenuSelected();
        void onRequestMenuSelected();
        void onGroupsMenuSelected();
        void onMessagesMenuSelected();
        void onNotificationsMenuSelected();
        void onSettingsMenuSelected();
        void onTermsMenuSelected();
        void onLogoutMenuSelected();
    }
}
