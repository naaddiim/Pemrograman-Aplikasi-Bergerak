package proyekAkhir.JSN.mygadget;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.leanback.widget.Parallax;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.github.appintro.AppIntroCustomLayoutFragment;
import com.github.appintro.AppIntroFragment;
import com.github.appintro.AppIntroPageTransformerType;

public class AppIntro extends com.github.appintro.AppIntro {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Add Slide
        addSlide(AppIntroCustomLayoutFragment.newInstance(R.layout.appintro_slide1));
        addSlide(AppIntroCustomLayoutFragment.newInstance(R.layout.appintro_slide2));
        addSlide(AppIntroCustomLayoutFragment.newInstance(R.layout.appintro_slide3));

        // Show/hide status bar
        showStatusBar(true);

        setIndicatorColor(
                getResources().getColor(R.color.blue_accent_2),
                getResources().getColor(R.color.grey_lighten_1)
        );

        setNextArrowColor(getResources().getColor(R.color.indigo_accent_3));
        setColorDoneText(getResources().getColor(R.color.blue_accent_2));
        setColorSkipButton(getResources().getColor(R.color.indigo_accent_3));

        //Show/hide skip button
        setSkipButtonEnabled(true);

        //Enable immersive mode (no status and nav bar)
        setImmersiveMode();

        //Enable/disable page indicators
        setIndicatorEnabled(true);

        //Dhow/hide ALL buttons
        setButtonsEnabled(true);

    }

    @Override
    protected void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }
}