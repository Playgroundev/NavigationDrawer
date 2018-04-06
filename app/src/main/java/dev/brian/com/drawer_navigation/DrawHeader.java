package dev.brian.com.drawer_navigation;

import android.widget.ImageView;
import android.widget.TextView;

import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.NonReusable;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

/**
 * Created by brian-kamau on 4/7/18.
 */
@NonReusable
@Layout(R.layout.drawer_header)
public class DrawHeader {

    @View(R.id.profileImageView)
    private ImageView profileImage;

    @View(R.id.nameTxt)
    private TextView nameTxt;

    @View(R.id.emailTxt)
    private TextView emailTxt;

    @Resolve
    private void onResolved(){
        nameTxt.setText("Brian Kamau");
        emailTxt.setText("Briankamau151659@daystar.ac.ke");
    }
}
