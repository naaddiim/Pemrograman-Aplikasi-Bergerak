package proyekAkhir.JSN.mygadget.activities;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;

import com.github.appintro.AppIntroCustomLayoutFragment;

import proyekAkhir.JSN.mygadget.R;

public class AppIntro extends com.github.appintro.AppIntro {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Add Slide
        addSlide(AppIntroCustomLayoutFragment.newInstance(R.layout.appintro_slide1));
        addSlide(AppIntroCustomLayoutFragment.newInstance(R.layout.appintro_slide2));
        addSlide(AppIntroCustomLayoutFragment.newInstance(R.layout.appintro_slide3));

        // Show/hide status bar
        showStatusBar(false);

        setIndicatorColor(
                getResources().getColor(R.color.purple),
                getResources().getColor(R.color.grey_lighter)
        );

        setNextArrowColor(getResources().getColor(R.color.purple));
        setColorDoneText(getResources().getColor(R.color.purple));
        setColorSkipButton(getResources().getColor(R.color.grey));

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

        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(intent);
        finish();
    }
}