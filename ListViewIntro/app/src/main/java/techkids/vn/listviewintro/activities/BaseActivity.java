package techkids.vn.listviewintro.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import techkids.vn.listviewintro.R;

/**
 * Created by apple on 11/8/16.
 */

public class BaseActivity extends AppCompatActivity {

    public void changeFragment(int resId, Fragment fragment, boolean addToBackstack) {

        // 3: Get FragmentManager
        FragmentManager fragmentManager = this.getSupportFragmentManager();

        // 4: Start replacing
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // 5:
        fragmentTransaction.replace(resId, fragment);

        // 6: (Optional)
        if (addToBackstack) {
            fragmentTransaction.addToBackStack(null);
        }

        // 7:
        fragmentTransaction.commit();
    }
}
