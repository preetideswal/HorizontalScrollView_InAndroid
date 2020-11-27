package com.example.horizontalscrollview;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;
import android.view.ViewGroup;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
public class MainActivity extends AppCompatActivity {
    TextView txt;
    ViewGroup scview;
    ImageView icon;
    TextView Caption;
    ImageView imagesel;
    String[] item={"Bike 1","Bike 2","Bike 3","Bike 4","Bike 5"};
    Integer[] thumbnail={R.drawable.images1_tn,R.drawable.images2_tn,R.drawable.images3_tn,R.drawable.images4_tn,R.drawable.images5_tn};
    Integer[] largeImage={R.drawable.images1,R.drawable.images2,R.drawable.images3,R.drawable.images4,R.drawable.images5};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt=(TextView)findViewById(R.id.textmsg);
        imagesel=(ImageView)findViewById(R.id.imageselected);
        scview=(ViewGroup)findViewById(R.id.viewgroup);
        for(int i=0;i<item.length;i++){
            final View singlrfram=getLayoutInflater().inflate(R.layout.framicon,null);
            singlrfram.setId(i);
            TextView caption =(TextView) singlrfram.findViewById(R.id.caption);
            ImageView image=(ImageView) singlrfram.findViewById(R.id.imagef);
            image.setImageResource(thumbnail[i]);
            caption.setText(item[i]);
            caption.setBackgroundColor(Color.BLUE);
            scview.addView(singlrfram);
            singlrfram.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String text1="Select Position: "+singlrfram.getId()+" " + item[singlrfram.getId()];
                    txt.setText(text1);
                    showLargeImage(singlrfram.getId());
                }
            });
        }
    }
    protected void showLargeImage(int frameid){
        Drawable selectedLargeImage=getResources().getDrawable(largeImage[frameid], getTheme());
       imagesel.setBackground(selectedLargeImage);
    }
}