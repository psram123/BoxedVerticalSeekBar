package abak.tr.com.boxedverticalseekbar;

import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private BoxedVertical bv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView valueTextView = findViewById(R.id.valueTextView);
        bv = findViewById(R.id.boxed_vertical);

        bv.setOnBoxedPointsChangeListener(new BoxedVertical.OnValuesChangeListener() {
            @Override
            public void onPointsChanged(BoxedVertical boxedPoints, final int points) {
                valueTextView.setText("Current Value is " + points);
            }

            @Override
            public void onStartTrackingTouch(BoxedVertical boxedPoints) {
                Toast.makeText(MainActivity.this, "onStartTrackingTouch", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(BoxedVertical boxedPoints) {
                Toast.makeText(MainActivity.this, "onStopTrackingTouch", Toast.LENGTH_SHORT).show();
            }
        });

        bv.setValue(60);
        System.out.println("VALUE: " + bv.getValue());
        valueTextView.setText("Current Value is " + bv.getValue());
    }

    public void setBorder(View v) {
        int val = Integer.parseInt(v.getTag().toString());
        bv.setCornerRadius(val);
        Toast.makeText(MainActivity.this, "New corner radius is " + val, Toast.LENGTH_SHORT).show();
    }

    public void setMax(View v) {
        int val = Integer.parseInt(v.getTag().toString());
        bv.setMax(val);
        Toast.makeText(MainActivity.this, "New max value is " + val, Toast.LENGTH_SHORT).show();
    }
}