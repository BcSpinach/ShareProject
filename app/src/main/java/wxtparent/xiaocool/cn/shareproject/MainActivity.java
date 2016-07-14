package wxtparent.xiaocool.cn.shareproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SliderLayout slider1 = (SliderLayout) findViewById(R.id.slider1);
        //SliderLayout slider2 = (SliderLayout) findViewById(R.id.slider2);
        HashMap<String,String> url_maps = new HashMap<String, String>();
        url_maps.put("Hannibal", "http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg");
        url_maps.put("Big Bang Theory", "http://tvfiles.alphacoders.com/100/hdclearart-10.png");
        url_maps.put("House of Cards", "http://cdn3.nflximg.net/images/3093/2043093.jpg");
        url_maps.put("Game of Thrones", "http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");

        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Hannibal",R.drawable.ll1);
        file_maps.put("Big Bang Theory",R.drawable.ll2);
        file_maps.put("House of Cards",R.drawable.ll3);
        file_maps.put("Game of Thrones", R.drawable.ll4);

        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            slider1.addSlider(textSliderView);
        }
        slider1.setPresetTransformer(SliderLayout.Transformer.Accordion);
        slider1.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        slider1.setCustomAnimation(new DescriptionAnimation());
        slider1.setDuration(4000);
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }
}
