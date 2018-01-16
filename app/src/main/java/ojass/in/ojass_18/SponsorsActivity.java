package ojass.in.ojass_18;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SponsorsActivity extends AppCompatActivity {

    TextView sponsers_toolbar;
    TextView i1,i2,i3,i4,i5,i6,i7,i8,i9,i10,i11,i12,i13,i14,i15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sponsors);
        sponsers_toolbar = (TextView) findViewById(R.id.sponsers_toolbar_title);
        Typeface tf = Typeface.createFromAsset(getAssets(), "ToolbarText.ttf");
        sponsers_toolbar.setTypeface(tf);

        i1 = (TextView) findViewById(R.id.i1);
        i2 = (TextView) findViewById(R.id.i2);
        i3 = (TextView) findViewById(R.id.i3);
        i4 = (TextView) findViewById(R.id.i4);
        i5 = (TextView) findViewById(R.id.i5);
        i6 = (TextView) findViewById(R.id.i6);
        i7 = (TextView) findViewById(R.id.i7);
        i8 = (TextView) findViewById(R.id.i8);
        i9 = (TextView) findViewById(R.id.i9);
        i10 = (TextView) findViewById(R.id.i10);
        i11 = (TextView) findViewById(R.id.i11);
        i12 = (TextView) findViewById(R.id.i12);
        i13 = (TextView) findViewById(R.id.i13);
        i14 = (TextView) findViewById(R.id.i14);
        i15 = (TextView) findViewById(R.id.i15);

        i1.setPaintFlags(i1.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        i2.setPaintFlags(i2.getPaintFlags()|Paint.UNDERLINE_TEXT_FLAG);
        i3.setPaintFlags(i3.getPaintFlags()|Paint.UNDERLINE_TEXT_FLAG);
        i4.setPaintFlags(i4.getPaintFlags()|Paint.UNDERLINE_TEXT_FLAG);
        i5.setPaintFlags(i5.getPaintFlags()|Paint.UNDERLINE_TEXT_FLAG);
        i6.setPaintFlags(i6.getPaintFlags()|Paint.UNDERLINE_TEXT_FLAG);
        i7.setPaintFlags(i7.getPaintFlags()|Paint.UNDERLINE_TEXT_FLAG);
        i8.setPaintFlags(i8.getPaintFlags()|Paint.UNDERLINE_TEXT_FLAG);
        i9.setPaintFlags(i9.getPaintFlags()|Paint.UNDERLINE_TEXT_FLAG);
        i10.setPaintFlags(i10.getPaintFlags()|Paint.UNDERLINE_TEXT_FLAG);
        i11.setPaintFlags(i11.getPaintFlags()|Paint.UNDERLINE_TEXT_FLAG);
        i12.setPaintFlags(i12.getPaintFlags()|Paint.UNDERLINE_TEXT_FLAG);
        i13.setPaintFlags(i13.getPaintFlags()|Paint.UNDERLINE_TEXT_FLAG);
        i14.setPaintFlags(i14.getPaintFlags()|Paint.UNDERLINE_TEXT_FLAG);
        i15.setPaintFlags(i15.getPaintFlags()|Paint.UNDERLINE_TEXT_FLAG);


    }
}
