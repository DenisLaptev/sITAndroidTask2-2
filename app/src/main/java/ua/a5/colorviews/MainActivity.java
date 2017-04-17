package ua.a5.colorviews;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int[] COLORS_ARRAY = new int[]{
            Color.BLUE,
            Color.RED,
            Color.GRAY,
            Color.GREEN,
            Color.WHITE,
            Color.YELLOW,
            Color.MAGENTA
    };

    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;

    Button[] buttonsArray;

    List<Integer> fourColorsList = new ArrayList<>();
    List<Integer> newFourColorsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);

        buttonsArray = new Button[]{btn1, btn2, btn3, btn4};

        for (int i = 0; i < buttonsArray.length; i++) {
            buttonsArray[i].setOnClickListener(this);
        }

        initialFillColor();

    }

    private void initialFillColor() {
        int tempColor;
        while (fourColorsList.size() <= 4) {
            tempColor = getRandom(COLORS_ARRAY);
            if (!fourColorsList.contains(tempColor)) {
                fourColorsList.add(tempColor);
            }
        }

        for (int i = 0; i < buttonsArray.length; i++) {
            buttonsArray[i].setBackgroundColor(fourColorsList.get(i));
        }
    }

    private void secondaryFillColor(int initialColorOfTheButton) {
        newFourColorsList = new ArrayList<>();
        int tempColor;
        while (newFourColorsList.size() <= 4) {
            tempColor = getRandom(COLORS_ARRAY);
            if (!newFourColorsList.contains(tempColor) && tempColor != initialColorOfTheButton) {
                newFourColorsList.add(tempColor);
            }
        }
        for (int i = 0; i < buttonsArray.length; i++) {
            buttonsArray[i].setBackgroundColor(newFourColorsList.get(i));
            fourColorsList.set(i, newFourColorsList.get(i));
        }
    }

    @Override
    public void onClick(View v) {
        int initialColorOfTheButton;
        switch (v.getId()) {
            case R.id.btn1:
                initialColorOfTheButton = fourColorsList.get(0);
                secondaryFillColor(initialColorOfTheButton);
                buttonsArray[0].setBackgroundColor(initialColorOfTheButton);
                fourColorsList.set(0, initialColorOfTheButton);
                Toast.makeText(getApplicationContext(), "Button 1", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn2:
                initialColorOfTheButton = fourColorsList.get(1);
                secondaryFillColor(initialColorOfTheButton);
                buttonsArray[1].setBackgroundColor(initialColorOfTheButton);
                fourColorsList.set(1, initialColorOfTheButton);
                Toast.makeText(getApplicationContext(), "Button 2", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn3:
                initialColorOfTheButton = fourColorsList.get(2);
                secondaryFillColor(initialColorOfTheButton);
                buttonsArray[2].setBackgroundColor(initialColorOfTheButton);
                fourColorsList.set(2, initialColorOfTheButton);
                Toast.makeText(getApplicationContext(), "Button 3", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn4:
                initialColorOfTheButton = fourColorsList.get(3);
                secondaryFillColor(initialColorOfTheButton);
                buttonsArray[3].setBackgroundColor(initialColorOfTheButton);
                fourColorsList.set(3, initialColorOfTheButton);
                Toast.makeText(getApplicationContext(), "Button 4", Toast.LENGTH_SHORT).show();
                break;
        }
    }


    public static int getRandom(int[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }


}
